package me.redyt008.epicduels.listeners;

import me.redyt008.epicduels.EpicDuels;
import me.redyt008.epicduels.events.preArenaEvent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class preArenaListener implements Listener {

    Plugin plugin = EpicDuels.getPlugin(EpicDuels.class);


    @EventHandler
    public void onPlayerInPreArena(preArenaEvent event){
        Player player = event.getPlayer();
        if(plugin.getConfig().getLocation("pre arena.arena1") != null){
            player.sendTitle(ChatColor.GREEN + "Il duello sta per iniziare", ChatColor.GOLD + "Preparati!");
            player.teleport(plugin.getConfig().getLocation("pre arena.arena1"));
            player.sendTitle(ChatColor.GREEN + "Il duello sta per iniziare", ChatColor.GOLD + "Preparati!");
            if(plugin.getConfig().getLocation("arena") != null){
                player.teleport(plugin.getConfig().getLocation("arena"));
            }
        }
    }
}
