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
        player.sendTitle(ChatColor.GREEN + "Il duello è iniziato", ChatColor.GOLD + "Combatti!");
        Location arena = new Location(player.getWorld(), plugin.getConfig().getInt("arena.X"), plugin.getConfig().getInt("arena.Y"),plugin.getConfig().getInt("arena.Z"));
        player.teleport(arena);
    }
}
