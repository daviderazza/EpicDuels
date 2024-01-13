package me.redyt008.epicduels.events;

import me.redyt008.epicduels.EpicDuels;
import me.redyt008.epicduels.commands.DuelManager;
import me.redyt008.epicduels.listeners.rankManager;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

import java.io.IOException;

public class duelVictoryEvent implements Listener {

    static final DuelManager duelmanager = new DuelManager();
    private final Plugin plugin = EpicDuels.getPlugin(EpicDuels.class);
    me.redyt008.epicduels.listeners.rankManager rankManager = new rankManager();

    @EventHandler
    public void winningDuelEvent(PlayerDeathEvent event) throws IOException, InvalidConfigurationException {
        Player player = event.getEntity();
        Player killer = player.getKiller();
        Economy economy = EpicDuels.getEconomy();
        if(killer != null){
            if(EpicDuels.getData().getData(player)){
                event.setDeathMessage(ChatColor.GOLD + player.getName() + " è stato battuto in un duello da " + killer.getName());
                double balance = 10000.00;
                economy.depositPlayer(killer, balance);
                economy.depositPlayer(killer, 5000);
                economy.withdrawPlayer(player, balance);
                killer.sendMessage(ChatColor.GREEN + "Hai guadagnato " + economy.format(balance) + " e un bonus di 5000 monete battendo in un duello " + player.getName());
                player.sendMessage(ChatColor.RED + "Hai perso " + economy.format(balance) + " perdendo in un duello contro " + killer.getName());
                EpicDuels.getData().setData(player, false);
                EpicDuels.getData().setData(killer, false);
                EpicDuels.getData().setEnemy(player, null);
                EpicDuels.getData().setEnemy(killer, null);
                EpicDuels.getData().setVictories(killer, EpicDuels.getData().getVictories(killer) + 1);
                EpicDuels.getData().setDefeates(player, EpicDuels.getData().getDefeates(player) + 1);
                EpicDuels.getData().setDuelsPlayed(killer);
                EpicDuels.getData().setDuelsPlayed(player);
                EpicDuels.getData().setLevel(player);
                EpicDuels.getData().setLevel(killer);

                if(EpicDuels.getData().getLevel(player) < 5){
                    EpicDuels.getData().setRank(player, rankManager.zero);
                }
                if(EpicDuels.getData().getLevel(player) >= 5){
                    EpicDuels.getData().setRank(player, rankManager.bronzo);
                }
                if(EpicDuels.getData().getLevel(player) >= 15){
                    EpicDuels.getData().setRank(player, rankManager.ferro);
                }
                if(EpicDuels.getData().getLevel(player) >= 25){
                    EpicDuels.getData().setRank(player, rankManager.oro);
                }
                if(EpicDuels.getData().getLevel(player) >= 40){
                    EpicDuels.getData().setRank(player, rankManager.ametista);
                }
                if(EpicDuels.getData().getLevel(player) >= 60){
                    EpicDuels.getData().setRank(player, rankManager.diamante);
                }
                if(EpicDuels.getData().getLevel(player) >= 85){
                    EpicDuels.getData().setRank(player, rankManager.beacon);
                }
                if(EpicDuels.getData().getLevel(player) >= 115){
                    EpicDuels.getData().setRank(player, rankManager.ossidiana);
                }
                if(EpicDuels.getData().getLevel(player) >= 150){
                    EpicDuels.getData().setRank(player, rankManager.ossidiana2);
                }
                if(EpicDuels.getData().getLevel(player) >= 175){
                    EpicDuels.getData().setRank(player, rankManager.netherite);
                }
                if(EpicDuels.getData().getLevel(player) >= 200){
                    EpicDuels.getData().setRank(player, rankManager.bedrock);
                }
                if(EpicDuels.getData().getLevel(player) >= 250){
                    EpicDuels.getData().setRank(player, rankManager.terra);
                }

                if(EpicDuels.getData().getLevel(killer) >= 5){
                    EpicDuels.getData().setRank(killer, rankManager.bronzo);
                }
                if(EpicDuels.getData().getLevel(killer) >= 15){
                    EpicDuels.getData().setRank(killer, rankManager.ferro);
                }
                if(EpicDuels.getData().getLevel(killer) >= 25){
                    EpicDuels.getData().setRank(killer, rankManager.oro);
                }
                if(EpicDuels.getData().getLevel(killer) >= 40){
                    EpicDuels.getData().setRank(killer, rankManager.ametista);
                }
                if(EpicDuels.getData().getLevel(killer) >= 60){
                    EpicDuels.getData().setRank(killer, rankManager.diamante);
                }
                if(EpicDuels.getData().getLevel(killer) >= 85){
                    EpicDuels.getData().setRank(killer, rankManager.beacon);
                }
                if(EpicDuels.getData().getLevel(killer) >= 115){
                    EpicDuels.getData().setRank(killer, rankManager.ossidiana);
                }
                if(EpicDuels.getData().getLevel(killer) >= 150){
                    EpicDuels.getData().setRank(killer, rankManager.ossidiana2);
                }
                if(EpicDuels.getData().getLevel(killer) >= 175){
                    EpicDuels.getData().setRank(killer, rankManager.netherite);
                }
                if(EpicDuels.getData().getLevel(killer) >= 200){
                    EpicDuels.getData().setRank(killer, rankManager.bedrock);
                }
                if(EpicDuels.getData().getLevel(killer) >= 250){
                    EpicDuels.getData().setRank(killer, rankManager.terra);
                }
                if(EpicDuels.getData().getLevel(killer) < 5){
                    EpicDuels.getData().setRank(killer, rankManager.zero);
                }

                EpicDuels.getData().reloadData();
                Bukkit.getServer().getPluginManager().callEvent(new rankEvent(player));
                Bukkit.getServer().getPluginManager().callEvent(new rankEvent(killer));
                killer.sendTitle(ChatColor.GREEN + "Hai vinto il duello", ChatColor.GOLD + "Complimenti!");
                if(killer.getBedSpawnLocation() != null){
                    killer.teleport(killer.getBedSpawnLocation());
                }else {
                    killer.teleport(killer.getWorld().getSpawnLocation());
                }
            }
        }else {
            if(EpicDuels.getData().getData(player)){
                Player enemy = EpicDuels.getData().getEnemy(player);
                event.setDeathMessage(ChatColor.GOLD + player.getName() + " è stato battuto in un duello da " + enemy.getName());
                economy.depositPlayer(killer, 10000);
                economy.withdrawPlayer(player, 10000);
                enemy.sendMessage(ChatColor.GREEN + "Hai guadagnato " + economy.format(10000) + " battendo in un duello " + player.getName());
                player.sendMessage(ChatColor.RED + "Hai perso " + economy.format(10000) + " perdendo in un duello contro " + enemy.getName());
                EpicDuels.getData().setData(player, false);
                EpicDuels.getData().setData(enemy, false);
                EpicDuels.getData().setEnemy(player, null);
                EpicDuels.getData().setEnemy(enemy, null);
                EpicDuels.getData().setVictories(enemy, EpicDuels.getData().getVictories(killer) + 1);
                EpicDuels.getData().setDefeates(player, EpicDuels.getData().getDefeates(player) + 1);
                EpicDuels.getData().setDuelsPlayed(enemy);
                EpicDuels.getData().setDuelsPlayed(player);
                EpicDuels.getData().setLevel(player);
                EpicDuels.getData().setLevel(enemy);

                if(EpicDuels.getData().getLevel(player) < 5){
                    EpicDuels.getData().setRank(player, rankManager.zero);
                }
                if(EpicDuels.getData().getLevel(player) >= 5){
                    EpicDuels.getData().setRank(player, rankManager.bronzo);
                }
                if(EpicDuels.getData().getLevel(player) >= 15){
                    EpicDuels.getData().setRank(player, rankManager.ferro);
                }
                if(EpicDuels.getData().getLevel(player) >= 25){
                    EpicDuels.getData().setRank(player, rankManager.oro);
                }
                if(EpicDuels.getData().getLevel(player) >= 40){
                    EpicDuels.getData().setRank(player, rankManager.ametista);
                }
                if(EpicDuels.getData().getLevel(player) >= 60){
                    EpicDuels.getData().setRank(player, rankManager.diamante);
                }
                if(EpicDuels.getData().getLevel(player) >= 85){
                    EpicDuels.getData().setRank(player, rankManager.beacon);
                }
                if(EpicDuels.getData().getLevel(player) >= 115){
                    EpicDuels.getData().setRank(player, rankManager.ossidiana);
                }
                if(EpicDuels.getData().getLevel(player) >= 150){
                    EpicDuels.getData().setRank(player, rankManager.ossidiana2);
                }
                if(EpicDuels.getData().getLevel(player) >= 175){
                    EpicDuels.getData().setRank(player, rankManager.netherite);
                }
                if(EpicDuels.getData().getLevel(player) >= 200){
                    EpicDuels.getData().setRank(player, rankManager.bedrock);
                }
                if(EpicDuels.getData().getLevel(player) >= 250){
                    EpicDuels.getData().setRank(player, rankManager.terra);
                }

                if(EpicDuels.getData().getLevel(enemy) >= 5){
                    EpicDuels.getData().setRank(enemy, rankManager.bronzo);
                }
                if(EpicDuels.getData().getLevel(enemy) >= 15){
                    EpicDuels.getData().setRank(enemy, rankManager.ferro);
                }
                if(EpicDuels.getData().getLevel(enemy) >= 25){
                    EpicDuels.getData().setRank(enemy, rankManager.oro);
                }
                if(EpicDuels.getData().getLevel(enemy) >= 40){
                    EpicDuels.getData().setRank(enemy, rankManager.ametista);
                }
                if(EpicDuels.getData().getLevel(enemy) >= 60){
                    EpicDuels.getData().setRank(enemy, rankManager.diamante);
                }
                if(EpicDuels.getData().getLevel(enemy) >= 85){
                    EpicDuels.getData().setRank(enemy, rankManager.beacon);
                }
                if(EpicDuels.getData().getLevel(enemy) >= 115){
                    EpicDuels.getData().setRank(enemy, rankManager.ossidiana);
                }
                if(EpicDuels.getData().getLevel(enemy) >= 150){
                    EpicDuels.getData().setRank(enemy, rankManager.ossidiana2);
                }
                if(EpicDuels.getData().getLevel(enemy) >= 175){
                    EpicDuels.getData().setRank(enemy, rankManager.netherite);
                }
                if(EpicDuels.getData().getLevel(enemy) >= 200){
                    EpicDuels.getData().setRank(enemy, rankManager.bedrock);
                }
                if(EpicDuels.getData().getLevel(enemy) >= 250){
                    EpicDuels.getData().setRank(enemy, rankManager.terra);
                }
                if(EpicDuels.getData().getLevel(enemy) < 5){
                    EpicDuels.getData().setRank(enemy, rankManager.zero);
                }

                EpicDuels.getData().reloadData();
                Bukkit.getServer().getPluginManager().callEvent(new rankEvent(player));
                Bukkit.getServer().getPluginManager().callEvent(new rankEvent(enemy));
                enemy.sendTitle(ChatColor.GREEN + "Hai vinto il duello", ChatColor.GOLD + "Complimenti!");
                if(enemy.getBedSpawnLocation() != null){
                    enemy.teleport(enemy.getBedSpawnLocation());
                }else {
                    enemy.teleport(enemy.getWorld().getSpawnLocation());
                }
            }
        }
    }
}
