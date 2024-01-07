package me.redyt008.epicduels.listeners;

import me.redyt008.epicduels.EpicDuels;
import me.redyt008.epicduels.events.preArenaEvent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class preArenaListener implements Listener {

    Plugin plugin = EpicDuels.getPlugin(EpicDuels.class);


    @EventHandler
    public void onPlayerInPreArena(preArenaEvent event){
        Player player = event.getPlayer();
        if(plugin.getConfig().getLocation("pre arena.arena1.X") != null){
            player.sendTitle(ChatColor.GREEN + "Il duello sta per iniziare", ChatColor.GOLD + "Preparati!");
            Location prearena = new Location(player.getWorld(), plugin.getConfig().getInt("pre arena.arena1.X"), plugin.getConfig().getInt("pre arena.arena1.Y"),plugin.getConfig().getInt("pre arena.arena1.Z"));
            player.teleport(prearena);
            if(plugin.getConfig().getLocation("arena") != null){
                Location arena = new Location(player.getWorld(), plugin.getConfig().getInt("arena.X"), plugin.getConfig().getInt("arena.Y"),plugin.getConfig().getInt("arena.Z"));
                player.teleport(arena);
            }
        }
    }
}
