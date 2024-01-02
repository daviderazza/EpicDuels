package me.redyt008.epicduels;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class Data {
    public static File file = new File(EpicDuels.getPlugin(EpicDuels.class).getDataFolder()+"/data.yml");
    private FileConfiguration data;

    public Data(){
        if(!file.exists()){
            try{
                file.createNewFile();
                this.data = YamlConfiguration.loadConfiguration(file);
                this.data.createSection("Data");
                this.data.save(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return;
        }
        this.data = YamlConfiguration.loadConfiguration(file);
    }
    public String getName(){
        return this.data.getName();
    }
    public void setData(Player player, Boolean value){
        this.data.set("Data." + player + ".isOnDuel", value);
        try{
            this.data.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean getData(Player player){
        return this.data.getBoolean("Data." + player + ".isOnDuel");
    }
}
