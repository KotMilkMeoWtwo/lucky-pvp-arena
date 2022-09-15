package ru.meowland.cmds;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.meowland.Blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class GiveCmd implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {


        Player player = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("givelbb")){
            switch (args[0]){
                case ("1"):
                    player.getInventory().addItem(Blocks.lb1());
                    player.sendMessage(ChatColor.GREEN + "Done");
                    break;
                case ("2"):
                    player.getInventory().addItem(Blocks.lb2());
                    player.sendMessage(ChatColor.GREEN + "Done");
                    break;
                case ("3"):
                    player.getInventory().addItem(Blocks.lb3());
                    player.sendMessage(ChatColor.GREEN + "Done");
                    break;
                case ("4"):
                    player.getInventory().addItem(Blocks.lb4());
                    player.sendMessage(ChatColor.GREEN + "Done");
                    break;
                case ("5"):
                    player.getInventory().addItem(Blocks.lb5());
                    player.sendMessage(ChatColor.GREEN + "Done");
                    break;
                default:
                    sender.sendMessage("args must be 1-5 int");
            }
            return true;
        }
        return false;
    }
}