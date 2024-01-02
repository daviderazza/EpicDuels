package me.redyt008.epicduels.commands;

import me.redyt008.epicduels.EpicDuels;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TestCommand implements CommandExecutor {

    DuelManager duelManager = new DuelManager();
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(commandSender instanceof Player){
          Player player = (Player) commandSender;
          if(args[0].equalsIgnoreCase("true")){
              EpicDuels.getData().setData(player, true);
          } else if(args[0].equalsIgnoreCase("false")){
              EpicDuels.getData().setData(player, false);
          } else if(args.length != 1){
              player.sendMessage("Utilizzo: /test <true/false>");
          }
        }
        return true;
    }
}
