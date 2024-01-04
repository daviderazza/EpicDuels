package me.redyt008.epicduels.commands;

import me.redyt008.epicduels.EpicDuels;
import me.redyt008.epicduels.listeners.rankManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class setRankCommand implements CommandExecutor {
    rankManager rankManager = new rankManager();
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            if(player.hasPermission("epicduels.setrank")){
                if(args.length != 1){
                    player.sendMessage("Utilizzo: /setrank <rank>");
                }else{
                    if(args[0].equalsIgnoreCase("1")){
                        EpicDuels.getData().setRank(player, rankManager.bronzo);
                    }
                    if(args[0].equalsIgnoreCase("2")){
                        EpicDuels.getData().setRank(player, rankManager.ferro);
                    }
                    if(args[0].equalsIgnoreCase("3")){
                        EpicDuels.getData().setRank(player, rankManager.oro);
                    }
                    if(args[0].equalsIgnoreCase("4")){
                        EpicDuels.getData().setRank(player, rankManager.ametista);
                    }
                    if(args[0].equalsIgnoreCase("5")){
                        EpicDuels.getData().setRank(player, rankManager.diamante);
                    }
                    if(args[0].equalsIgnoreCase("6")){
                        EpicDuels.getData().setRank(player, rankManager.beacon);
                    }
                    if(args[0].equalsIgnoreCase("7")){
                        EpicDuels.getData().setRank(player, rankManager.ossidiana);
                    }
                    if(args[0].equalsIgnoreCase("8")){
                        EpicDuels.getData().setRank(player, rankManager.ossidiana2);
                    }
                    if(args[0].equalsIgnoreCase("9")){
                        EpicDuels.getData().setRank(player, rankManager.netherite);
                    }
                    if(args[0].equalsIgnoreCase("10")){
                        EpicDuels.getData().setRank(player, rankManager.bedrock);
                    }
                    if(args[0].equalsIgnoreCase("11")){
                        EpicDuels.getData().setRank(player, rankManager.terra);
                    }
                }
            }
        }
        return true;
    }
}
