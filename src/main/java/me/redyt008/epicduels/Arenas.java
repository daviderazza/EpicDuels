package me.redyt008.epicduels;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arenas {
    public static File file = new File(EpicDuels.getPlugin(EpicDuels.class).getDataFolder()+"/arenas.yml");
    private FileConfiguration arenas;

    public Arenas(){
        if(!file.exists()){
            try{
                file.createNewFile();
                this.arenas = YamlConfiguration.loadConfiguration(file);
                this.arenas.createSection("World");
                this.arenas.save(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return;
        }
        this.arenas = YamlConfiguration.loadConfiguration(file);
    }
    final List<String> arenasList = new ArrayList<>();
    int counter;
    public void setArena(int num, int X, int Y, int Z){

        if(this.arenas.get("World." + "Arena" + num + "." + "X") == null){
            this.counter = this.getCounter();
            counter++;
            arenas.set("arenasCounter", counter);
            this.counter = this.getCounter();

        }
        this.arenas.set("World." + "Arena" + num + "." + "X", X);
        this.arenas.set("World." + "Arena" + num + "." + "Y", Y);
        this.arenas.set("World." + "Arena" + num + "." + "Z", Z);
        this.arenas.set("World." + "Arena" + num + "." + "isEnabled", true);
    }
    public int getArenaX(int num){
        if(this.arenas.get("World." + "Arena" + num + "." + "X") != null){
            return (int) this.arenas.get("World." + "Arena" + num + "." + "X");
        }
        return 0;
    }
    public int getArenaY(int num){
        if(this.arenas.get("World." + "Arena" + num + "." + "X") != null){
            return (int) this.arenas.get("World." + "Arena" + num + "." + "Y");
        }
        return 0;
    }
    public int getArenaZ(int num){
        if(this.arenas.get("World." + "Arena" + num + "." + "X") != null){
            return (int) this.arenas.get("World." + "Arena" + num + "." + "Z");
        }
        return 0;
    }
    public void reloadArenas() throws IOException, InvalidConfigurationException {
        this.arenas.save(file);
        this.arenas.load(file);
    }
    public int getCounter(){
        return this.arenas.getInt("arenasCounter");
    }
    public boolean getState(int num){
        if(this.arenas.get("World." + "Arena" + num + "." + "isEnabled") != null){
            return (boolean) this.arenas.get("World." + "Arena" + num + "." + "isEnabled");
        }
        return true;
    }
    public void setState(int num, boolean value){
        this.arenas.set("World." + "Arena" + num + "." + "isEnabled", value);
    }
}
