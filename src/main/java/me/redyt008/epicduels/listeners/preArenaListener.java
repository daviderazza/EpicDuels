package me.redyt008.epicduels.listeners;

import me.redyt008.epicduels.EpicDuels;
import me.redyt008.epicduels.events.preArenaEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;

public class preArenaListener implements Listener {

    Plugin plugin = EpicDuels.getPlugin(EpicDuels.class);


    @EventHandler
    public void onPlayerInPreArena(preArenaEvent event){
        Player player = event.getPlayer();
        Player player1 = event.getPlayer1();
        player.sendMessage(ChatColor.GOLD + "Ricerca partita in corso...");
        new BukkitRunnable(){
            final int counter = EpicDuels.getArenas().getCounter();
            int a = 1;
            @Override
            public void run() {
                if(counter != 0){
                    if(a <= counter){
                        if(EpicDuels.getArenas().getState(a)){
                            player.sendTitle(ChatColor.GREEN + "Il duello è iniziato", ChatColor.GOLD + "Combatti!");
                            player1.sendTitle(ChatColor.GREEN + "Il duello è iniziato", ChatColor.GOLD + "Combatti!");
                            World world = Bukkit.getWorld(EpicDuels.getArenas().getArenaWorld(a));
                            Location location = new Location(world, EpicDuels.getArenas().getArenaX(a), EpicDuels.getArenas().getArenaY(a), EpicDuels.getArenas().getArenaZ(a));
                            player.teleport(location);
                            player1.teleport(location);
                            EpicDuels.getData().setData(player, true);
                            EpicDuels.getData().setArena(player, a);
                            EpicDuels.getData().setData(player1, true);
                            EpicDuels.getData().setArena(player1, a);
                            try {
                                EpicDuels.getData().reloadData();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            } catch (InvalidConfigurationException e) {
                                throw new RuntimeException(e);
                            }
                            EpicDuels.getArenas().setState(a, false);
                            try {
                                EpicDuels.getArenas().reloadArenas();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            } catch (InvalidConfigurationException e) {
                                throw new RuntimeException(e);
                            }
                            cancel();
                        }
                        a++;
                    }else {
                        if(!EpicDuels.getData().getData(player)){
                            player.sendMessage(ChatColor.RED + "Tutte le arene disponibili sono occupate! Riprova più tardi");
                            player1.sendMessage(ChatColor.RED + "Tutte le arene disponibili sono occupate! Riprova più tardi");
                            cancel();
                        }
                    }
                }else{
                    player.sendMessage(ChatColor.RED + "Impossibile avviare il duello: non ho trovato nessuna arena");
                    player1.sendMessage(ChatColor.RED + "Impossibile avviare il duello: non ho trovato nessuna arena");
                    cancel();
                }
            }
        }.runTaskTimer(plugin, 0, 1);


        /* OLD CODE
        player.sendTitle(ChatColor.GREEN + "Il duello è iniziato", ChatColor.GOLD + "Combatti!");
        Location arena = new Location(player.getWorld(), plugin.getConfig().getInt("arena.X"), plugin.getConfig().getInt("arena.Y"),plugin.getConfig().getInt("arena.Z"));
        player.teleport(arena);
        */
    }
}
