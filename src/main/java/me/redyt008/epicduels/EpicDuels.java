package me.redyt008.epicduels;

import me.redyt008.epicduels.commands.TestCommand;
import me.redyt008.epicduels.commands.DuelManager;
import me.redyt008.epicduels.events.duelVictoryEvent;
import me.redyt008.epicduels.events.playerJoinEvent;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class EpicDuels extends JavaPlugin {

    private static Economy econ = null;
    public static Data data;


    @Override
    public void onEnable() {
        if (!setupEconomy() ) {
            System.out.println("No economy plugin found. Disabling Vault...");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        System.out.println("EpicDuels Online! Made by Davide Razza");
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        data = new Data();
        //REGISTRAZIONE COMANDI
        this.getCommand("duel").setExecutor(new DuelManager());
        this.getCommand("daccept").setExecutor(new DuelManager());
        this.getCommand("ddeny").setExecutor(new DuelManager());
        this.getCommand("edtest").setExecutor(new TestCommand());
        //REGISTRAZIONE EVENTI
        getServer().getPluginManager().registerEvents(new duelVictoryEvent(), this);
        getServer().getPluginManager().registerEvents(new playerJoinEvent(), this);
    }
    public static Data getData() {
        return data;
    }

    @Override
    public void onDisable() {
        System.out.println("EpicDuels Offline! Made by Davide Razza");
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
