package me.redyt008.epicduels;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class EpicDuels extends JavaPlugin {

    private static Economy econ = null;

    @Override
    public void onEnable() {
        if (!setupEconomy() ) {
            System.out.println("No economy plugin found. Disabling Vault...");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        System.out.println("CustomWeapons Online! Made by Davide Razza");
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
