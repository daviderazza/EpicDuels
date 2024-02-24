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

public class SpectCommand implements CommandExecutor {
    private Plugin plugin = EpicDuels.getPlugin(EpicDuels.class);
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            if(player.hasPermission("epicduels.spect")){

                player.sendMessage(ChatColor.RED + "Comando attualmente disabilitato");
                player.sendMessage(ChatColor.RED + "Verrà riattivato nella prossima versione");
                /*
                Location stands = new Location(player.getWorld(), plugin.getConfig().getInt("stands.X"), plugin.getConfig().getInt("stands.Y"),plugin.getConfig().getInt("stands.Z"));
                player.teleport(stands);
                */
            }
        }
        return true;
    }
}
