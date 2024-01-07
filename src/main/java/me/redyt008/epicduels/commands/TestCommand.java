package me.redyt008.epicduels.commands;


import me.redyt008.epicduels.EpicDuels;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class TestCommand implements CommandExecutor {
    static final Plugin plugin = EpicDuels.getPlugin(EpicDuels.class);

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(commandSender instanceof Player){
          Player player = (Player) commandSender;
            Location arena = new Location(player.getWorld(), plugin.getConfig().getInt("arena.X"), plugin.getConfig().getInt("arena.Y"),plugin.getConfig().getInt("arena.Z"));
            player.teleport(arena);
        }
        return true;
    }
}
