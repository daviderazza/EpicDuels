package me.redyt008.epicduels.listeners;

import me.redyt008.epicduels.EpicDuels;
import me.redyt008.epicduels.events.rankEvent;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.Objects;

public class rankManager implements Listener {

    public String zero = "Rank Zero";
    public String bronzo = "Rank Bronzo";
    public String ferro = "Rank Ferro";
    public String oro = "Rank Oro";
    public String ametista = "Rank Ametista";
    public String diamante = "Rank Diamante";
    public String beacon = "Rank Beacon";
    public String ossidiana = "Rank Ossidiana";
    public String ossidiana2 = "Rank Ossidiana Piangente";
    public String netherite = "Rank Netherite";
    public String bedrock = "Rank Bedrock";
    public String terra = "Rank Terra";

    @EventHandler
    public void onPlayerChangeRank(rankEvent event) {
        Player player = event.getPlayer();
        Economy economy = EpicDuels.getEconomy();
        if (EpicDuels.getData().getRank(player) != null) {
            if (!Objects.equals(EpicDuels.getData().getRank(player), zero)) {
                if (EpicDuels.getData().getRank(player).equalsIgnoreCase(bronzo)) {
                    if (EpicDuels.getData().getMessage(player)) {
                        player.sendMessage(ChatColor.GOLD + "Complimenti! Hai raggiunto il Rank Bronzo. Ecco a te 1000 Monete");
                        player.sendMessage(ChatColor.GOLD + "Per raggiungere il " + ferro + " devi avere il livello 15");
                        economy.depositPlayer(player, 1000);
                        EpicDuels.getData().setMessage(player, false);
                    }
                }
                if (EpicDuels.getData().getRank(player).equalsIgnoreCase(ferro)) {
                    EpicDuels.getData().setMessage(player, true);
                    if (EpicDuels.getData().getMessage(player)) {
                        player.sendMessage(ChatColor.GOLD + "Complimenti! Hai raggiunto il Rank Ferro. Ecco a te 5000 Monete");
                        player.sendMessage(ChatColor.GOLD + "Per raggiungere il " + oro + " devi avere il livello 25");
                        economy.depositPlayer(player, 5000);
                        EpicDuels.getData().setMessage(player, false);
                    }
                }
                if (EpicDuels.getData().getRank(player).equalsIgnoreCase(oro)) {
                    EpicDuels.getData().setMessage(player, true);
                    if (EpicDuels.getData().getMessage(player)) {
                        player.sendMessage(ChatColor.GOLD + "Complimenti! Hai raggiunto il Rank Oro. Ecco a te 10000 Monete");
                        player.sendMessage(ChatColor.GOLD + "Per raggiungere il " + ametista + " devi avere il livello 40");
                        economy.depositPlayer(player, 10000);
                        EpicDuels.getData().setMessage(player, false);
                    }
                }
                if (EpicDuels.getData().getRank(player).equalsIgnoreCase(ametista)) {
                    EpicDuels.getData().setMessage(player, true);
                    if (EpicDuels.getData().getMessage(player)) {
                        player.sendMessage(ChatColor.GOLD + "Complimenti! Hai raggiunto il Rank Ametista. Ecco a te 15000 Monete");
                        player.sendMessage(ChatColor.GOLD + "Per raggiungere il " + diamante + " devi avere il livello 60");
                        economy.depositPlayer(player, 15000);
                        EpicDuels.getData().setMessage(player, false);
                    }
                }
                if (EpicDuels.getData().getRank(player).equalsIgnoreCase(diamante)) {
                    EpicDuels.getData().setMessage(player, true);
                    if (EpicDuels.getData().getMessage(player)) {
                        player.sendMessage(ChatColor.GOLD + "Complimenti! Hai raggiunto il Rank Diamante. Ecco a te 20000 Monete");
                        player.sendMessage(ChatColor.GOLD + "Per raggiungere il " + beacon + " devi avere il livello 85");
                        economy.depositPlayer(player, 20000);
                        EpicDuels.getData().setMessage(player, false);
                    }
                }
                if (EpicDuels.getData().getRank(player).equalsIgnoreCase(beacon)) {
                    EpicDuels.getData().setMessage(player, true);
                    if (EpicDuels.getData().getMessage(player)) {
                        player.sendMessage(ChatColor.GOLD + "Complimenti! Hai raggiunto il Rank Beacon. Ecco a te 25000 Monete");
                        player.sendMessage(ChatColor.GOLD + "Per raggiungere il " + ossidiana + " devi avere il livello 115");
                        economy.depositPlayer(player, 25000);
                        EpicDuels.getData().setMessage(player, false);
                    }
                }
                if (EpicDuels.getData().getRank(player).equalsIgnoreCase(ossidiana)) {
                    EpicDuels.getData().setMessage(player, true);
                    if (EpicDuels.getData().getMessage(player)) {
                        player.sendMessage(ChatColor.GOLD + "Complimenti! Hai raggiunto il Rank Ossidiana. Ecco a te 35000 Monete");
                        player.sendMessage(ChatColor.GOLD + "Per raggiungere il " + ossidiana2 + " devi avere il livello 150");
                        economy.depositPlayer(player, 35000);
                        EpicDuels.getData().setMessage(player, false);
                    }
                }
                if (EpicDuels.getData().getRank(player).equalsIgnoreCase(ossidiana2)) {
                    EpicDuels.getData().setMessage(player, true);
                    if (EpicDuels.getData().getMessage(player)) {
                        player.sendMessage(ChatColor.GOLD + "Complimenti! Hai raggiunto il Rank Ossidiana Piangente. Ecco a te 50000 Monete");
                        player.sendMessage(ChatColor.GOLD + "Per raggiungere il " + netherite + " devi avere il livello 175");
                        economy.depositPlayer(player, 50000);
                        EpicDuels.getData().setMessage(player, false);
                    }
                }
                if (EpicDuels.getData().getRank(player).equalsIgnoreCase(netherite)) {
                    EpicDuels.getData().setMessage(player, true);
                    if (EpicDuels.getData().getMessage(player)) {
                        player.sendMessage(ChatColor.GOLD + "Complimenti! Hai raggiunto il Rank Netherite. Ecco a te 75000 Monete");
                        player.sendMessage(ChatColor.GOLD + "Per raggiungere il " + bedrock + " devi avere il livello 200");
                        economy.depositPlayer(player, 75000);
                        EpicDuels.getData().setMessage(player, false);
                    }
                }
                if (EpicDuels.getData().getRank(player).equalsIgnoreCase(bedrock)) {
                    EpicDuels.getData().setMessage(player, true);
                    if (EpicDuels.getData().getMessage(player)) {
                        player.sendMessage(ChatColor.GOLD + "Complimenti! Hai raggiunto il Rank Bedrock. Ecco a te 150000 Monete");
                        player.sendMessage(ChatColor.GOLD + "Per raggiungere il " + terra + " devi avere il livello 250");
                        economy.depositPlayer(player, 150000);
                        EpicDuels.getData().setMessage(player, false);
                    }
                }
                if (EpicDuels.getData().getRank(player).equalsIgnoreCase(terra)) {
                    EpicDuels.getData().setMessage(player, true);
                    if (EpicDuels.getData().getMessage(player)) {
                        player.sendMessage(ChatColor.GOLD + "Complimenti! Hai raggiunto il Rank Terra. Ecco a te 300000 Monete");
                        player.sendMessage(ChatColor.GOLD + "Hai completato tutti i rank!");
                        economy.depositPlayer(player, 30000);
                        EpicDuels.getData().setMessage(player, false);
                    }
                }
            }
        }
    }
}