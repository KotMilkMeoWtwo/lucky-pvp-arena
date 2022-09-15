package ru.meowland;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Blocks {


    public static ItemStack lb1(){
        List<String> desc = new ArrayList<>();
        ItemStack itemStack;
        desc.add(ChatColor.DARK_GRAY + "Выпадают: " + ChatColor.BOLD + ChatColor.GRAY + "COMMON" + ChatColor.DARK_GRAY + " вещи");
        itemStack = new ItemStack(setName(new ItemStack(Material.COAL_BLOCK, 1, (short) 0), ChatColor.GRAY + "Lucky block lvl 1", desc));
        return itemStack;
    }

    public static ItemStack lb2(){
        List<String> desc = new ArrayList<>();
        ItemStack itemStack;
        desc.add(ChatColor.DARK_GRAY + "Выпадают: " + ChatColor.BOLD + ChatColor.GRAY + "COMMON" + ChatColor.DARK_GRAY + " вещи");
        desc.add(ChatColor.DARK_GRAY + "Выпадают: " + ChatColor.BOLD + ChatColor.YELLOW + "RARE" + ChatColor.DARK_GRAY + " вещи");
        itemStack = new ItemStack(setName(new ItemStack(Material.IRON_BLOCK, 1, (short) 0),"Lucky block lvl 2", desc));
        return itemStack;
    }

    public static ItemStack lb3(){
        List<String> desc = new ArrayList<>();
        ItemStack itemStack;
        desc.add(ChatColor.DARK_GRAY + "Выпадают: " + ChatColor.BOLD + ChatColor.YELLOW + "RARE" + ChatColor.DARK_GRAY + " вещи");
        desc.add(ChatColor.DARK_GRAY + "Выпадают: " + ChatColor.BOLD + ChatColor.BLUE + "EPIC" +ChatColor.DARK_GRAY + " вещи");
        itemStack = new ItemStack(setName(new ItemStack(Material.GOLD_BLOCK, 1, (short) 0),ChatColor.YELLOW + "Lucky block lvl 3", desc));
        return itemStack;
    }

    public static ItemStack lb4(){
        List<String> desc = new ArrayList<>();
        ItemStack itemStack;
        desc.add(ChatColor.DARK_GRAY + "Выпадают: " + ChatColor.BOLD + ChatColor.BLUE + "EPIC" + ChatColor.DARK_GRAY + " вещи");
        itemStack = new ItemStack(setName(new ItemStack(Material.DIAMOND_BLOCK, 1, (short) 0),"Lucky block lvl 4", desc));
        return itemStack;
    }

    public static ItemStack lb5(){
        List<String> desc = new ArrayList<>();
        ItemStack itemStack;
        desc.add(ChatColor.DARK_GRAY + "Выпадают: " + ChatColor.BOLD + ChatColor.DARK_BLUE + "EPIC" + ChatColor.DARK_GRAY + " вещи");
        desc.add(ChatColor.DARK_GRAY + "Выпадают: " + ChatColor.BOLD + ChatColor.GOLD + "LEGENDARY" + ChatColor.DARK_GRAY + " вещи");
        itemStack = new ItemStack(setName( new ItemStack(Material.NETHERITE_BLOCK, 1, (short) 0), ChatColor.GOLD + "Lucky block lvl 5", desc));
        return itemStack;
    }

    public static ItemStack setName(ItemStack is, String name){
        ItemMeta m = is.getItemMeta();
        if (m != null) {
            m.setDisplayName(name);
        }
        is.setItemMeta(m);
        return is;
    }
    public static ItemStack setName(ItemStack is, String name, List<String> desc){
        ItemMeta m = is.getItemMeta();
        if (m != null) {
            m.setDisplayName(name);
            m.setLore(desc);
        }
        is.setItemMeta(m);
        return is;
    }
}
