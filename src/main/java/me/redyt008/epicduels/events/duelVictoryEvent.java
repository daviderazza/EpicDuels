package me.redyt008.epicduels.events;

import me.redyt008.epicduels.EpicDuels;
import me.redyt008.epicduels.commands.DuelManager;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

public class duelVictoryEvent implements Listener {

    static final DuelManager duelmanager = new DuelManager();
    private final Plugin plugin = EpicDuels.getPlugin(EpicDuels.class);

    @EventHandler
    public void winningDuelEvent(PlayerDeathEvent event){
        Player player = event.getEntity();
        Player killer = player.getKiller();
        Economy economy = EpicDuels.getEconomy();
        if(killer != null){
            player.sendMessage("Event 1 passed");
            if(EpicDuels.getData().getData(player)){
                event.setDeathMessage(player.getName() + " è stato battuto in un duello da " + killer.getName());
                double balance = economy.getBalance(player)/2;
                economy.depositPlayer(killer, balance);
                economy.withdrawPlayer(player, balance);
                killer.sendMessage("Hai guadagnato " + economy.format(balance) + " battendo in un duello " + player.getName());
                player.sendMessage("Hai perso " + economy.format(balance) + " perdendo in un duello contro " + killer.getName());
                EpicDuels.getData().setData(player, false);
                EpicDuels.getData().setData(killer, false);
            }else{
                    player.sendMessage("Non sei in duello");
                    killer.sendMessage("Non sei in un duello neanche tu:)");
            }
        }
    }
}
