package me.redyt008.epicduels;

import org.bukkit.configuration.InvalidConfigurationException;
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
    public void setDuelsPlayed(Player player){
        int victories = EpicDuels.getData().getVictories(player);
        int defeates = EpicDuels.getData().getDefeates(player);
        int duelsplayed = victories + defeates;
        this.data.set("Data." + player + ".duelsPlayed", duelsplayed);
    }
    public void setVictories(Player player, int victories){
        this.data.set("Data." + player + ".victories", victories);
    }
    public int getVictories(Player player){
        return this.data.getInt("Data." + player + ".victories");
    }
    public void setDefeates(Player player, int defeates){
        this.data.set("Data." + player + ".defeates", defeates);
    }
    public int getDefeates(Player player){
        return this.data.getInt("Data." + player + ".defeates");
    }
    public void setLevel(Player player){
        int victories = EpicDuels.getData().getVictories(player);
        int defeates = EpicDuels.getData().getDefeates(player);
        int level =  victories - defeates;
        this.data.set("Data." + player + ".level", level);
    }
    public int getLevel(Player player){
        return this.data.getInt("Data." + player + ".level");
    }
    public void reloadData() throws IOException, InvalidConfigurationException {
        this.data.save(file);
        this.data.load(file);
    }
    public void setRank(Player player, String rank){
        this.data.set("Data." + player + ".rank", rank);
    }
    public String getRank(Player player){
        return this.data.getString("Data." + player + ".rank");
    }
    public void setMessage(Player player, Boolean message){
        this.data.set("Data." + player + ".showMessage", message);
    }
    public Boolean getMessage(Player player){
        return this.data.getBoolean("Data." + player + ".showMessage");
    }

    public void setEnemy(Player player, Player enemy){
        this.data.set("Data." + player + ".enemy", enemy);
    }
    public Player getEnemy(Player player){
        return (Player) this.data.getOfflinePlayer("Data." + player + ".enemy");
    }
    public void setArena(Player player, int arena){
        this.data.set("Data." + player + ".arena", arena);
    }
    public int getArena(Player player){
        return this.data.getInt("Data." + player + ".arena");
    }
}
