package me.redyt008.epicduels.commands;

import me.redyt008.epicduels.EpicDuels;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class ArenaCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            if(player.hasPermission("epicduels.arena")){
                if(args.length != 1){
                    player.sendMessage(ChatColor.RED + "Utilizzo: /arena <numero_arena>");
                }else if(args.length == 1){
                    Location location = player.getLocation();
                    EpicDuels.getArenas().setArena(Integer.parseInt(args[0]), location.getBlockX(), location.getBlockY(), location.getBlockZ());
                    String string = EpicDuels.getArenas().getArenaX(Integer.parseInt(args[0])) + " " + EpicDuels.getArenas().getArenaY(Integer.parseInt(args[0])) + " " + EpicDuels.getArenas().getArenaZ(Integer.parseInt(args[0]));
                    try {
                        EpicDuels.getArenas().reloadArenas();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (InvalidConfigurationException e) {
                        throw new RuntimeException(e);
                    }
                    player.sendMessage(ChatColor.GREEN + "Hai impostato con successo l'arena numero " + args[0] + " a " + string);
                    player.sendMessage(ChatColor.GREEN + "Al momento sono presenti " + EpicDuels.getArenas().getList() + " arene");
                }
            }
        }
        return true;
    }
}
