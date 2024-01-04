package me.redyt008.epicduels.commands;

import me.redyt008.epicduels.EpicDuels;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class edStats implements CommandExecutor{
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            int duelsPlayed = EpicDuels.getData().getVictories(player) + EpicDuels.getData().getDefeates(player);
            player.sendMessage(ChatColor.GOLD + "Le tue statistiche sono:");
            player.sendMessage(ChatColor.YELLOW + "Duelli Giocati: " + duelsPlayed);
            player.sendMessage(ChatColor.GREEN + "Duelli Vinti: " + EpicDuels.getData().getVictories(player));
            player.sendMessage(ChatColor.RED + "Duelli Persi: " + EpicDuels.getData().getDefeates(player));
            player.sendMessage(ChatColor.AQUA + "Livello: " + EpicDuels.getData().getLevel(player));
            player.sendMessage(ChatColor.BLUE + "Rank: " + EpicDuels.getData().getRank(player));
            if(player.hasPermission("epicduels.stats")){
                if(args.length == 1){
                    if(Bukkit.getPlayer(args[0]) != null){
                        Player player1 = Bukkit.getPlayer(args[0]);
                        int duelsPlayed2 = EpicDuels.getData().getVictories(player1) + EpicDuels.getData().getDefeates(player1);
                        player.sendMessage(ChatColor.GOLD + "Le statistiche di " + player1 + " sono:");
                        player.sendMessage(ChatColor.YELLOW + "Duelli Giocati: " + duelsPlayed2);
                        player.sendMessage(ChatColor.GREEN + "Duelli Vinti: " + EpicDuels.getData().getVictories(player1));
                        player.sendMessage(ChatColor.RED + "Duelli Persi: " + EpicDuels.getData().getDefeates(player1));
                        player.sendMessage(ChatColor.AQUA + "Livello: " + EpicDuels.getData().getLevel(player1));
                        player.sendMessage(ChatColor.BLUE + "Rank: " + EpicDuels.getData().getRank(player1));
                    }
                }
            }
        }
        return true;
    }
}
