package ru.meowland.cmds;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GiveCmd {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        ItemStack itemStack;
        List<String> desc = new ArrayList<>();

        if(cmd.getName().equalsIgnoreCase("givelbb")){
            switch (args[0]){
                case ("1"):
                    desc.add(ChatColor.DARK_GRAY + "Выпадают: " + ChatColor.BOLD + ChatColor.GRAY + "COMMON" + ChatColor.DARK_GRAY + " вещи");
                    itemStack = new ItemStack(setName(new ItemStack(Material.COAL_BLOCK, 1, (short) 0), ChatColor.GRAY + "Lucky block lvl 1", desc));
                    break;
                case ("2"):
                    desc.add(ChatColor.DARK_GRAY + "Выпадают: " + ChatColor.BOLD + ChatColor.GRAY + "COMMON" + ChatColor.DARK_GRAY + " вещи");
                    desc.add(ChatColor.DARK_GRAY + "Выпадают: " + ChatColor.BOLD + ChatColor.YELLOW + "RARE" + ChatColor.DARK_GRAY + " вещи");
                    itemStack = new ItemStack(setName(new ItemStack(Material.IRON_BLOCK, 1, (short) 0),"Lucky block lvl 2", desc));
                    break;
                case ("3"):
                    desc.add(ChatColor.DARK_GRAY + "Выпадают: " + ChatColor.BOLD + ChatColor.YELLOW + "RARE" + ChatColor.DARK_GRAY + " вещи");
                    desc.add(ChatColor.DARK_GRAY + "Выпадают: " + ChatColor.BOLD + ChatColor.BLUE + "EPIC" +ChatColor.DARK_GRAY + " вещи");
                    itemStack = new ItemStack(setName(new ItemStack(Material.GOLD_BLOCK, 1, (short) 0),ChatColor.YELLOW + "Lucky block lvl 3", desc));
                    break;
                case ("4"):
                    desc.add(ChatColor.DARK_GRAY + "Выпадают: " + ChatColor.BOLD + ChatColor.BLUE + "EPIC" + ChatColor.DARK_GRAY + " вещи");
                    itemStack = new ItemStack(setName(new ItemStack(Material.DIAMOND_BLOCK, 1, (short) 0),"Lucky block lvl 4", desc));
                    break;
                case ("5"):
                    desc.add(ChatColor.DARK_GRAY + "Выпадают: " + ChatColor.BOLD + ChatColor.DARK_BLUE + "EPIC" + ChatColor.DARK_GRAY + " вещи");
                    desc.add(ChatColor.DARK_GRAY + "Выпадают: " + ChatColor.BOLD + ChatColor.GOLD + "LEGENDARY" + ChatColor.DARK_GRAY + " вещи");
                    itemStack = new ItemStack(setName( new ItemStack(Material.NETHERITE_BLOCK, 1, (short) 0), ChatColor.GOLD + "Lucky block lvl 5", desc));
                    break;
                default:
                    sender.sendMessage("args must be 1-5 int");
            }
            return true;
        }
        return false;
    }

    public ItemStack setName(ItemStack is, String name){
        ItemMeta m = is.getItemMeta();
        if (m != null) {
            m.setDisplayName(name);
        }
        is.setItemMeta(m);
        return is;
    }
    public ItemStack setName(ItemStack is, String name, List<String> desc){
        ItemMeta m = is.getItemMeta();
        if (m != null) {
            m.setDisplayName(name);
            m.setLore(desc);
        }
        is.setItemMeta(m);
        return is;
    }
}