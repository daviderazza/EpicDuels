package me.redyt008.epicduels.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


public class rankEvent extends Event {


    private static final HandlerList handlers = new HandlerList();


    private Player player;

    public rankEvent(Player player){
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }



    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
