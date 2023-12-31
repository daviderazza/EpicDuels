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


public class preArenaCommand implements CommandExecutor {
    private Plugin plugin = EpicDuels.getPlugin(EpicDuels.class);
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            if(player.hasPermission("epicduels.prearena")){
                Location location = player.getLocation();
                String string = location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ();
                if(plugin.getConfig().get("pre arena.arena1.X") == null){
                    plugin.getConfig().set("pre arena.arena1.X", location.getBlockX());
                    plugin.getConfig().set("pre arena.arena1.Y", location.getBlockY());
                    plugin.getConfig().set("pre arena.arena1.Z", location.getBlockZ());
                    player.sendMessage(ChatColor.GREEN + "Hai impostato la prima prearena a " + string + " con successo!");
                    plugin.saveConfig();
                }else {
                    plugin.getConfig().set("pre arena.arena2.X", location.getBlockX());
                    plugin.getConfig().set("pre arena.arena2.Y", location.getBlockY());
                    plugin.getConfig().set("pre arena.arena2.Z", location.getBlockZ());
                    player.sendMessage(ChatColor.GREEN + "Hai impostato le prearene a " + plugin.getConfig().get("pre arena.arena1.X") + plugin.getConfig().get("pre arena.arena1.Y") + plugin.getConfig().get("pre arena.arena1.Z") + " e a " + plugin.getConfig().get("pre arena.arena2.X") + plugin.getConfig().get("pre arena.arena2.Y") + plugin.getConfig().get("pre arena.arena2.Z") + " con successo!");
                    plugin.saveConfig();
                }
            }
        }
        return true;
    }
}
