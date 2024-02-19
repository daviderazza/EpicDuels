package me.redyt008.epicduels.commands;

import me.redyt008.epicduels.EpicDuels;
import me.redyt008.epicduels.events.preArenaEvent;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class DuelManager implements CommandExecutor {

    private static HashMap<UUID, UUID> requests = new HashMap<>();
    private Plugin plugin = EpicDuels.getPlugin(EpicDuels.class);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {


        if (!(sender instanceof Player)) {
            sender.sendMessage("Devi essere un Giocatore per eseguire questo comando");
            return true;
        }

        Player player = (Player) sender;
        Economy economy = EpicDuels.getEconomy();
        if (command.getName().equalsIgnoreCase("duel")) {
            if (!player.hasPermission("epicduels.duel")) {
                player.sendMessage(ChatColor.RED + "Non hai il permesso di eseguire questo comando");
                return true;
            }
            if (args.length != 1) {
                player.sendMessage(ChatColor.GOLD + "Utilizzo: /duel <player>");
                return true;
            }
            if (!(economy.has(player, 200))) {
                player.sendMessage(ChatColor.RED + "Per iniziare un duello devi avere almeno 200 monete");
                return true;
            }
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {
                if(!target.getName().equals(player.getName())){
                    if(requests.containsKey(player.getUniqueId())){
                        player.sendMessage(ChatColor.DARK_RED + "Hai gia nessuna richiesta di duello");
                    }else {
                        requests.put(target.getUniqueId(), player.getUniqueId());
                        player.sendMessage(ChatColor.GOLD + "Hai mandato una richiesta di duello a " + target.getName() + ".");
                        target.sendMessage(ChatColor.GOLD + player.getName() + " ti ha mandato una richiesta di duello");
                        target.sendMessage(ChatColor.GOLD + "Scrivi /daccept o /ddeny");
                    }
                }else {
                    player.sendMessage(ChatColor.RED + "Non puoi mandare una richiesta di duello a te stesso!");
                }
            }else {
                player.sendMessage(ChatColor.RED + "Il player è offline");
            }
        }
        if (command.getName().equalsIgnoreCase("daccept")) {
            if (requests.containsKey(player.getUniqueId())) {
                player.sendMessage(ChatColor.GREEN + "Hai accettato la richiesta di duello di " + Bukkit.getPlayer(requests.get(player.getUniqueId())).getName());
                Bukkit.getPlayer(requests.get(player.getUniqueId())).sendMessage(ChatColor.GREEN + player.getName() + " ha accettato la tua richiesta di duello");
                Bukkit.getPluginManager().callEvent(new preArenaEvent(Bukkit.getPlayer(requests.get(player.getUniqueId())), player));
                EpicDuels.getData().setEnemy(Bukkit.getPlayer(requests.get(player.getUniqueId())), player);
                EpicDuels.getData().setEnemy(player, Bukkit.getPlayer(requests.get(player.getUniqueId())));
                try {
                    EpicDuels.getData().reloadData();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InvalidConfigurationException e) {
                    throw new RuntimeException(e);
                }
                requests.remove(player.getUniqueId());
                return true;
            }
            player.sendMessage(ChatColor.DARK_RED + "Non hai nessuna richiesta da accettare");
        }

        if (command.getName().equalsIgnoreCase("ddeny")) {
            if (requests.containsKey(player.getUniqueId())) {
                player.sendMessage(ChatColor.RED + "Hai rifiutato la richiesta di duello di " + Bukkit.getPlayer(requests.get(player.getUniqueId())).getName());
                Bukkit.getPlayer(requests.get(player.getUniqueId())).sendMessage(ChatColor.RED + player.getName() + " ha rifiutato la tua richiesta di duello");
                requests.remove(player.getUniqueId());
                return true;
            }
            player.sendMessage(ChatColor.DARK_RED + "Non hai nessuna richiesta da rifiutare");
        }
        return true;
    }
}
