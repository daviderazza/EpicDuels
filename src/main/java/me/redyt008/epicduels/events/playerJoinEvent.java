package me.redyt008.epicduels.events;

import me.redyt008.epicduels.EpicDuels;
import me.redyt008.epicduels.listeners.rankManager;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;

public class playerJoinEvent implements Listener {
    rankManager rankManager = new rankManager();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) throws IOException, InvalidConfigurationException {
        Player player = event.getPlayer();
        EpicDuels.getData().setData(player, false);
        EpicDuels.getData().setMessage(player, false);
        if(EpicDuels.getData().getRank(player) == null){
            EpicDuels.getData().setRank(player, rankManager.zero);
            EpicDuels.getData().reloadData();
        }
    }
}
