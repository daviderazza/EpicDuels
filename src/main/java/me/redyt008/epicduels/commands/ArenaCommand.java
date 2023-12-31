package me.redyt008.epicduels.commands;

import me.redyt008.epicduels.EpicDuels;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class ArenaCommand implements CommandExecutor {
    private Plugin plugin = EpicDuels.getPlugin(EpicDuels.class);
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            if(player.hasPermission("epicduels.arena")){
                Location location = player.getLocation();
                String string = location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ();
                player.sendMessage(ChatColor.GREEN + "Hai impostato l'arena a " + string + " con successo!");
                plugin.getConfig().set("arena.X", location.getBlockX());
                plugin.getConfig().set("arena.Y", location.getBlockY());
                plugin.getConfig().set("arena.Z", location.getBlockZ());
                plugin.saveConfig();
            }
        }
        return true;
    }
}
