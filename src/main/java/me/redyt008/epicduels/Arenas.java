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
    public void setArena(int num, int X, int Y, int Z){
        this.arenas.set("World." + "Arena" + num + "." + "X", X);
        this.arenas.set("World." + "Arena" + num + "." + "Y", Y);
        this.arenas.set("World." + "Arena" + num + "." + "Z", Z);
        this.arenas.set("World." + "Arena" + num + "." + "isEnabled", true);

        int counter = this.getList() + 1;
        arenas.set("arenasCounter", counter);

        if(arenas.getList("arenasList") == null){
            if(!arenasList.contains("Arena" + num)){
                this.arenas.set("arenasList", arenasList);
                arenasList.add("Arena" + num);
                this.arenas.set("arenasList", arenasList);
            }
        }else{
            if(!arenasList.contains("Arena" + num)){
                arenasList.add("Arena" + num);
                this.arenas.set("arenasList", arenasList);
            }
        }
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
    public int getList(){
        return arenasList.size();
    }

    public int getCounter(){
        return this.arenas.getInt("arenasCounter");
    }
    public boolean getState(int num){
        if(this.arenas.get("World." + "Arena" + num + "." + "isOccupied") != null){
            return (boolean) this.arenas.get("World." + "Arena" + num + "." + "isOccupied");
        }
        return true;
    }
    public void setState(int num, boolean value){
        this.arenas.set("World." + "Arena" + num + "." + "isEnabled", value);
    }
}
