package me.redyt008.epicduels.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class rankInventoryClickEvent implements Listener {

    @EventHandler
    public void onPlayerClickInventory(InventoryClickEvent event){
        if(event.getCurrentItem() == null){
            return;
        }
        if(event.getClickedInventory() == null){
            return;
        }
        if(event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "Ranks")) {
            event.setCancelled(true);
        }
    }
}
