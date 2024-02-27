package me.redyt008.epicduels.events;

import me.redyt008.epicduels.EpicDuels;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class playerLeaveEvent implements Listener {


    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        Player player = event.getPlayer();
        if(EpicDuels.getData().getData(player)){
            Player enemy = EpicDuels.getData().getEnemy(player);
            EpicDuels.getData().setData(player, false);
            EpicDuels.getData().setData(enemy, false);
            EpicDuels.getData().setEnemy(player, null);
            EpicDuels.getData().setEnemy(enemy, null);
            if(enemy.getBedSpawnLocation() != null){
                enemy.teleport(enemy.getBedSpawnLocation());
            }else {
                enemy.teleport(enemy.getWorld().getSpawnLocation());
            }
            enemy.sendMessage(ChatColor.RED + "Duello annullato: il tuo sfidante ha abbandonato la partita");
        }
    }
}
