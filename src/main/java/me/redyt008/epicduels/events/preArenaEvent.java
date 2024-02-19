package me.redyt008.epicduels.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class preArenaEvent extends Event {

    private static final HandlerList handlers = new HandlerList();


    private Player player;
    private Player player1;


    public preArenaEvent(Player player, Player player1){
        this.player = player;
        this.player1 = player1;
    }

    public Player getPlayer() {
        return player;
    }

    public Player getPlayer1(){
        return player1;
    }


    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
