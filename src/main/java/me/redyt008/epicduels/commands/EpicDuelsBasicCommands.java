package me.redyt008.epicduels.commands;

import me.redyt008.epicduels.EpicDuels;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.lang.foreign.PaddingLayout;

public class EpicDuelsBasicCommands implements CommandExecutor {
    EpicDuels plugin = EpicDuels.getPlugin(EpicDuels.class);
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(sender instanceof ConsoleCommandSender){
            if(args.length != 1){
                plugin.getLogger().info(ChatColor.RED + "Utilizzo: epicduels <debug/info/wiki>");
            }
            if(args.length == 1){
                if(!args[0].equalsIgnoreCase("debug") && !args[0].equalsIgnoreCase("info") && !args[0].equalsIgnoreCase("wiki")){
                    plugin.getLogger().info(ChatColor.RED + "Utilizzo: epicduels <debug/info/wiki>");
                }
                if(args[0].equalsIgnoreCase("debug")){
                    if(plugin.isEnabled()){
                        if(plugin.getDataFolder().exists()){
                            plugin.getLogger().info(ChatColor.GREEN + "Il plugin è abilitato e funziona corretamente");
                            plugin.getLogger().info(ChatColor.GREEN + "I dati dei player sono stati caricati corretamente");
                            plugin.getLogger().info(ChatColor.GREEN + "I dati delle arene sono stati caricati corretamente");
                            plugin.getLogger().info(ChatColor.GREEN + "Versione: " + plugin.getDescription().getVersion());
                        }else{
                            plugin.getLogger().info(ChatColor.RED + "Errore nel caricamento dei dati. Per favore prova a riavviare il server");
                        }
                    }else{
                        plugin.getLogger().info(ChatColor.RED + "Errore nell'attivazione del plugin. Per favore prova a riavviare il server");
                    }
                }
                if(args[0].equalsIgnoreCase("info")){
                    plugin.getLogger().info(ChatColor.GREEN + "Plugin: " + plugin.getDescription().getFullName());
                    plugin.getLogger().info(ChatColor.GREEN + "Versione: " + plugin.getDescription().getVersion());
                    plugin.getLogger().info(ChatColor.GREEN + "Verione dell'API: Paper API " + plugin.getDescription().getAPIVersion());
                    plugin.getLogger().info(ChatColor.GREEN + "Autore: " + plugin.getDescription().getAuthors());
                }
                if(args[0].equalsIgnoreCase("wiki")){
                    plugin.getLogger().info(ChatColor.GREEN + "Puoi trovare la wiki del plugin a questo URL:");
                    plugin.getLogger().info(ChatColor.GREEN + "https://github.com/daviderazza/EpicDuels/wiki");
                }
            }
        }
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("epicduels.admin")){
                if(args.length != 1){
                    player.sendMessage(ChatColor.RED + "Utilizzo: /epicduels <debug/info/wiki>");
                }
                if(args.length == 1){
                    if(!args[0].equalsIgnoreCase("debug") && !args[0].equalsIgnoreCase("info") && !args[0].equalsIgnoreCase("wiki")){
                        player.sendMessage(ChatColor.RED + "Utilizzo: /epicduels <debug/info/wiki>");
                    }
                    if(args[0].equalsIgnoreCase("debug")){
                        if(plugin.isEnabled()){
                            if(plugin.getDataFolder().exists()){
                                player.sendMessage(ChatColor.GREEN + "Il plugin è abilitato e funziona corretamente");
                                player.sendMessage(ChatColor.GREEN + "I dati dei player sono stati caricati corretamente");
                                player.sendMessage(ChatColor.GREEN + "I dati delle arene sono stati caricati corretamente");
                                player.sendMessage(ChatColor.GREEN + "Versione:" + plugin.getDescription().getVersion());
                            }else{
                                player.sendMessage(ChatColor.RED + "Errore nel caricamento dei dati. Per favore prova a riavviare il server");
                            }
                        }else{
                            player.sendMessage(ChatColor.RED + "Errore nell'attivazione del plugin. Per favore prova a riavviare il server");
                        }
                    }
                    if(args[0].equalsIgnoreCase("info")){
                        player.sendMessage(ChatColor.GREEN + "Plugin: " + plugin.getDescription().getFullName());
                        player.sendMessage(ChatColor.GREEN + "Versione: " + plugin.getDescription().getVersion());
                        player.sendMessage(ChatColor.GREEN + "Verione dell'API: Paper API " + plugin.getDescription().getAPIVersion());
                        player.sendMessage(ChatColor.GREEN + "Autore: " + plugin.getDescription().getAuthors());
                    }
                    if(args[0].equalsIgnoreCase("wiki")){
                        player.sendMessage(ChatColor.GREEN + "Puoi trovare la wiki del plugin a questo URL:");
                        player.sendMessage(ChatColor.GREEN + "https://github.com/daviderazza/EpicDuels/wiki");
                    }
                }
            }else{
                player.sendMessage(ChatColor.RED + "Non hai il permesso di eseguire questo comando!");
            }
        }
        return true;
    }
}
