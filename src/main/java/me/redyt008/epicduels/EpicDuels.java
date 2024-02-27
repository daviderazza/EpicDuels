package me.redyt008.epicduels;

import me.redyt008.epicduels.commands.*;
import me.redyt008.epicduels.events.duelVictoryEvent;
import me.redyt008.epicduels.events.playerJoinEvent;
import me.redyt008.epicduels.events.playerLeaveEvent;
import me.redyt008.epicduels.events.rankInventoryClickEvent;
import me.redyt008.epicduels.listeners.preArenaListener;
import me.redyt008.epicduels.listeners.rankManager;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class EpicDuels extends JavaPlugin {

    private static Economy econ = null;
    public static Data data;
    public static Arenas arenas;


    @Override
    public void onEnable() {
        if (!setupEconomy() ) {
            System.out.println("No economy plugin found. Disabling Vault...");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        this.getLogger().info("EpicDuels Online! Made by Davide Razza");
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        data = new Data();
        arenas = new Arenas();
        //REGISTRAZIONE COMANDI
        this.getCommand("duel").setExecutor(new DuelManager());
        this.getCommand("daccept").setExecutor(new DuelManager());
        this.getCommand("ddeny").setExecutor(new DuelManager());
        this.getCommand("edtest").setExecutor(new TestCommand());
        this.getCommand("edstats").setExecutor(new edStats());
        this.getCommand("setrank").setExecutor(new setRankCommand());
        this.getCommand("ranks").setExecutor(new RanksCommand());
        this.getCommand("prearena").setExecutor(new preArenaCommand());
        this.getCommand("arena").setExecutor(new ArenaCommand());
        this.getCommand("stands").setExecutor(new StandsCommand());
        this.getCommand("spect").setExecutor(new SpectCommand());
        this.getCommand("epicduels").setExecutor(new EpicDuelsBasicCommands());
        //REGISTRAZIONE EVENTI
        getServer().getPluginManager().registerEvents(new duelVictoryEvent(), this);
        getServer().getPluginManager().registerEvents(new playerJoinEvent(), this);
        getServer().getPluginManager().registerEvents(new rankManager(), this);
        getServer().getPluginManager().registerEvents(new rankInventoryClickEvent(), this);
        getServer().getPluginManager().registerEvents(new preArenaListener(), this);
        getServer().getPluginManager().registerEvents(new playerLeaveEvent(), this);
    }
    public static Data getData() {
        return data;
    }
    public static Arenas getArenas(){
        return arenas;
    }

    @Override
    public void onDisable() {
        this.getLogger().info("EpicDuels Offline! Made by Davide Razza");
    }
    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
    public static Economy getEconomy() {
        return econ;
    }
}
