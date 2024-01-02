package me.redyt008.epicduels.commands;

import me.redyt008.epicduels.EpicDuels;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.UUID;

public class DuelManager implements CommandExecutor {

    private static HashMap<UUID, UUID> requests = new HashMap<>();
    private Plugin plugin = EpicDuels.getPlugin(EpicDuels.class);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {


        if (!(sender instanceof Player)) {
            sender.sendMessage("§cDevi essere un Giocatore per eseguire questo comando");
            return true;
        }

        Player player = (Player) sender;
        Economy economy = EpicDuels.getEconomy();
        if (command.getName().equalsIgnoreCase("duel")) {
            if (!player.hasPermission("epicduels.duel")) {
                player.sendMessage("§cNon hai il permesso di eseguire questo comando");
                return true;
            }
            if (args.length != 1) {
                player.sendMessage("§7Utilizzo: /duel <player>");
                return true;
            }
            if (!(economy.has(player, 200))) {
                player.sendMessage("§cYou don't have enough money.");
                return true;
            }
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {
                requests.put(target.getUniqueId(), player.getUniqueId());
                player.sendMessage("§7Hai mandato una richiesta di duello a " + target.getName() + ".");
                target.sendMessage("§7" + player.getName() + " ti ha mandato una richiesta di duello");
                target.sendMessage("§7Scrivi /daccept o /ddeny");
                return true;
            }
            player.sendMessage("§cIl player è offline");
        }
        if (command.getName().equalsIgnoreCase("daccept")) {
            if (requests.containsKey(player.getUniqueId())) {
                player.sendMessage(ChatColor.GREEN + "§7Hai accettato la richiesta di duello di " + Bukkit.getPlayer(requests.get(player.getUniqueId())));
                Bukkit.getPlayer(requests.get(player.getUniqueId())).sendMessage(ChatColor.GREEN + "§7" + player.getName() + " ha accettato la tua richiesta di duello");
                Bukkit.getPlayer(requests.get(player.getUniqueId())).teleport(player);
                EpicDuels.getData().setData(Bukkit.getPlayer(requests.get(player.getUniqueId())), true);
                requests.remove(player.getUniqueId());
                EpicDuels.getData().setData(player, true);
                return true;
            }
            player.sendMessage(ChatColor.DARK_RED + "§cNon hai nessuna richiesta da accettare");
        }

        if (command.getName().equalsIgnoreCase("ddeny")) {
            if (requests.containsKey(player.getUniqueId())) {
                player.sendMessage(ChatColor.RED + "§7Hai rifiutato la richiesta di duello di " + Bukkit.getPlayer(requests.get(player.getUniqueId())));
                Bukkit.getPlayer(requests.get(player.getUniqueId())).sendMessage(ChatColor.RED + "§7" +  player.getName() + " ha rifiutato la tua richiesta di duello");
                requests.remove(player.getUniqueId());
                return true;
            }
            player.sendMessage(ChatColor.DARK_RED + "§cNon hai nessuna richiesta da rifiutare");
        }
        return true;
    }
}
