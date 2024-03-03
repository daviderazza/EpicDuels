package me.redyt008.epicduels.commands;

import me.redyt008.epicduels.EpicDuels;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class ArenaCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            if(player.hasPermission("epicduels.arena")){
                if(args.length != 3){
                    player.sendMessage(ChatColor.RED + "Utilizzo: /arena <numero_arena> <posizione_spawn> <mondo_arena>");
                }else if(args.length == 3){
                    if(Integer.parseInt(args[0]) > 0){
                        if(Integer.parseInt(args[1]) == 1 || Integer.parseInt(args[1]) == 2){
                            if(Bukkit.getWorld(args[2]) != null){
                                Location location = player.getLocation();
                                String world = args[2];
                                EpicDuels.getArenas().setArena(Integer.parseInt(args[0]), Integer.parseInt(args[1]), location.getBlockX(), location.getBlockY(), location.getBlockZ(), world);
                                String string = EpicDuels.getArenas().getArenaX(Integer.parseInt(args[0]), Integer.parseInt(args[1])) + " " + EpicDuels.getArenas().getArenaY(Integer.parseInt(args[0]), Integer.parseInt(args[1])) + " " + EpicDuels.getArenas().getArenaZ(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
                                try {
                                    EpicDuels.getArenas().reloadArenas();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                } catch (InvalidConfigurationException e) {
                                    throw new RuntimeException(e);
                                }
                                player.sendMessage(ChatColor.GREEN + "Hai impostato con successo la posizione di spawn " + args[1] + " dell'arena numero " + args[0] + " a " + string);
                                player.sendMessage(ChatColor.GREEN + "Al momento sono presenti " + EpicDuels.getArenas().getCounter() + " arene");
                            }else{
                                player.sendMessage(ChatColor.RED + "Non ho trovato un mondo con quel nome!");
                            }
                        }else{
                            player.sendMessage(ChatColor.RED + "La posizione dello spawn non può essere diversa da 1 o 2!");
                        }
                    }else{
                        player.sendMessage(ChatColor.RED + "Il numero dell'arena non può essere uguale o minore di 0!");
                    }
                }
            }
        }
        return true;
    }
}
