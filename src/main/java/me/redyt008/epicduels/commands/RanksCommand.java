package me.redyt008.epicduels.commands;

import me.redyt008.epicduels.EpicDuels;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RanksCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            Inventory inventory = Bukkit.createInventory(null, 27, ChatColor.GOLD + "Ranks");

            ItemStack itemStack = new ItemStack(Material.COPPER_BLOCK);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(ChatColor.YELLOW + "Rank Bronzo");
            List list = new ArrayList<String>();
            list.add(ChatColor.GOLD + "Livello: 5-14");
            list.add(ChatColor.GREEN + "Premio: 1000 Monete");
            itemMeta.setLore(list);
            itemStack.setItemMeta(itemMeta);

            ItemStack itemStack1 = new ItemStack(Material.IRON_BLOCK);
            ItemMeta itemMeta1 = itemStack1.getItemMeta();
            itemMeta1.setDisplayName(ChatColor.GRAY + "Rank Ferro");
            List list1 = new ArrayList<String>();
            list1.add(ChatColor.GOLD + "Livello: 15-24");
            list1.add(ChatColor.GREEN + "Premio: 5000 Monete");
            itemMeta1.setLore(list1);
            itemStack1.setItemMeta(itemMeta1);

            ItemStack itemStack2 = new ItemStack(Material.GOLD_BLOCK);
            ItemMeta itemMeta2 = itemStack2.getItemMeta();
            itemMeta2.setDisplayName(ChatColor.GOLD+ "Rank Oro");
            List list2 = new ArrayList<String>();
            list2.add(ChatColor.GOLD + "Livello: 25-39");
            list2.add(ChatColor.GREEN + "Premio: 10000 Monete");
            itemMeta2.setLore(list2);
            itemStack2.setItemMeta(itemMeta2);

            ItemStack itemStack3 = new ItemStack(Material.AMETHYST_BLOCK);
            ItemMeta itemMeta3 = itemStack3.getItemMeta();
            itemMeta3.setDisplayName(ChatColor.LIGHT_PURPLE + "Rank Ametista");
            List list3 = new ArrayList<String>();
            list3.add(ChatColor.GOLD + "Livello: 40-59");
            list3.add(ChatColor.GREEN + "Premio: 15000 Monete");
            itemMeta3.setLore(list3);
            itemStack3.setItemMeta(itemMeta3);

            ItemStack itemStack4 = new ItemStack(Material.DIAMOND_BLOCK);
            ItemMeta itemMeta4 = itemStack4.getItemMeta();
            itemMeta4.setDisplayName(ChatColor.AQUA + "Rank Diamante");
            List list4 = new ArrayList<String>();
            list4.add(ChatColor.GOLD + "Livello: 60-84");
            list4.add(ChatColor.GREEN + "Premio: 20000 Monete");
            itemMeta4.setLore(list4);
            itemStack4.setItemMeta(itemMeta4);

            ItemStack itemStack5 = new ItemStack(Material.BEACON);
            ItemMeta itemMeta5 = itemStack5.getItemMeta();
            itemMeta5.setDisplayName(ChatColor.BLUE + "Rank Beacon");
            List list5 = new ArrayList<String>();
            list5.add(ChatColor.GOLD + "Livello: 85-114");
            list5.add(ChatColor.GREEN + "Premio: 25000 Monete");
            itemMeta5.setLore(list5);
            itemStack5.setItemMeta(itemMeta5);

            ItemStack itemStack6 = new ItemStack(Material.OBSIDIAN);
            ItemMeta itemMeta6 = itemStack6.getItemMeta();
            itemMeta6.setDisplayName(ChatColor.BLACK + "Rank Ossidiana");
            List list6 = new ArrayList<String>();
            list6.add(ChatColor.GOLD + "Livello: 115-149");
            list6.add(ChatColor.GREEN + "Premio: 35000 Monete");
            itemMeta6.setLore(list6);
            itemStack6.setItemMeta(itemMeta6);

            ItemStack itemStack7 = new ItemStack(Material.CRYING_OBSIDIAN);
            ItemMeta itemMeta7 = itemStack7.getItemMeta();
            itemMeta7.setDisplayName(ChatColor.DARK_PURPLE + "Rank Ossidiana Piangente");
            List list7 = new ArrayList<String>();
            list7.add(ChatColor.GOLD + "Livello: 150-174");
            list7.add(ChatColor.GREEN + "Premio: 50000 Monete");
            itemMeta7.setLore(list7);
            itemStack7.setItemMeta(itemMeta7);

            ItemStack itemStack8 = new ItemStack(Material.NETHERITE_BLOCK);
            ItemMeta itemMeta8 = itemStack8.getItemMeta();
            itemMeta8.setDisplayName(ChatColor.DARK_GRAY + "Rank Netherite");
            List list8 = new ArrayList<String>();
            list8.add(ChatColor.GOLD + "Livello: 175-200");
            list8.add(ChatColor.GREEN + "Premio: 75000 Monete");
            itemMeta8.setLore(list8);
            itemStack8.setItemMeta(itemMeta8);

            ItemStack itemStack9 = new ItemStack(Material.BEDROCK);
            ItemMeta itemMeta9 = itemStack9.getItemMeta();
            itemMeta9.setDisplayName(ChatColor.DARK_GRAY + "Rank Bedrock");
            List list9 = new ArrayList<String>();
            list9.add(ChatColor.GOLD + "Livello: 200-249");
            list9.add(ChatColor.GREEN + "Premio: 150000 Monete");
            itemMeta9.setLore(list9);
            itemStack9.setItemMeta(itemMeta9);

            ItemStack itemStack10 = new ItemStack(Material.DIRT);
            ItemMeta itemMeta10 = itemStack10.getItemMeta();
            itemMeta10.setDisplayName(ChatColor.GREEN + "Rank Terra");
            List list10 = new ArrayList<String>();
            list10.add(ChatColor.GOLD + "Livello: 250-...");
            list10.add(ChatColor.GREEN + "Premio: 300000 Monete");
            itemMeta10.setLore(list10);
            itemStack10.setItemMeta(itemMeta10);

            ItemStack itemStack11 = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta skullMeta = (SkullMeta) itemStack11.getItemMeta();
            skullMeta.setOwner(player.getName());
            skullMeta.setDisplayName(ChatColor.GREEN + "Livello di " + player.getName() + ": " + EpicDuels.getData().getLevel(player));
            itemStack11.setItemMeta(skullMeta);

            inventory.setItem(0, itemStack);
            inventory.setItem(1, itemStack1);
            inventory.setItem(2, itemStack2);
            inventory.setItem(3, itemStack3);
            inventory.setItem(4, itemStack4);
            inventory.setItem(5, itemStack5);
            inventory.setItem(6, itemStack6);
            inventory.setItem(7, itemStack7);
            inventory.setItem(8, itemStack8);
            inventory.setItem(9, itemStack9);
            inventory.setItem(10, itemStack10);
            inventory.setItem(26, itemStack11);
            if(player.hasPermission("epicduels.ranks")){
                player.openInventory(inventory);
            }
        }
        return true;
    }
}
