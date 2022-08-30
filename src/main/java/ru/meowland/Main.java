package ru.meowland;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import ru.meowland.config.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Main extends JavaPlugin implements Listener {

    FileConfiguration config = getConfig();
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();
        FileConfiguration config = getConfig();
        getConfig();
        reloadConfig();
        this.getConfig();
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onKillPlayer(PlayerDeathEvent e){
        Player p = e.getEntity();
        Player killer = p.getKiller();

        if(killer != null){
            List<String> desc = new ArrayList<>();
            desc.add(ChatColor.DARK_GRAY + "Выпадает: " + ChatColor.DARK_BLUE + "EPIC" + ChatColor.DARK_GRAY + "вещи");
            desc.add(ChatColor.DARK_GRAY + "Выпадает: " + ChatColor.GOLD + "LEGENDARY" + ChatColor.DARK_GRAY + "вещи");
            ItemStack itemStack = new ItemStack(setName( new ItemStack(Material.DIAMOND_BLOCK, 1, (short) 0), ChatColor.BLUE + "Lucky block lvl 5", desc));
            killer.getInventory().addItem(itemStack);
            killer.sendMessage("u get diamond");
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void LuckBlockOpen(PlayerInteractEvent e){
        if(e.getPlayer().getItemInHand().getType() == Material.DIAMOND_BLOCK){
            if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
                Player p = e.getPlayer();
                p.sendMessage("meow");
                for(int i = 0; i < p.getInventory().getSize(); i++){
                    if(p.getInventory().getItem(i) != null){
                        if(Objects.requireNonNull(p.getInventory().getItem(i)).getType() == Material.DIAMOND_BLOCK){
                            ItemStack d = new ItemStack(setName(new ItemStack(Material.DIAMOND_BLOCK, 1), ChatColor.BLUE + "Lucky block lvl 5"));
                            p.getInventory().removeItem(d);
                            break;
                        }
                    }

                }
                /*
                int rand = (int) (Math.random()*3);
                ItemStack p0 = new ItemStack(Material.DIAMOND_SWORD, 1);
                p0.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
                p0.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
                ItemStack p1 = new ItemStack(Material.DIAMOND_BOOTS, 1);
                p1.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                ItemStack p2 = new ItemStack(Material.DIAMOND_HELMET);
                switch (rand){
                    case (0):
                        p.getInventory().addItem(p0);
                        break;
                    case (1):
                        p.getInventory().addItem(p1);
                        break;
                    case (2):
                        p.getInventory().addItem(p2);
                        break;
                }
                */
                int rand1 = (int) (Math.random()* getConfig().getInt("lb5.items_count"));
                Material material = Material.valueOf(getConfig().getString("lb5.items." + rand1 + ".item"));
                ItemStack item = setName(new ItemStack(material, 1), getConfig().getString("lb5.items." + rand1 + ".name"));
                p.getInventory().addItem(item);
                /*
                for(int i = 0; i < getConfig().getInt("lb5.items_count"); i++){
                    Material material = Material.valueOf(getConfig().getString("lb5.items." + i + "item"));
                    ItemStack item = setName(new ItemStack(material, 1), getConfig().getString("lb5.items." + i + "name"));
                    p.getInventory().addItem(item);
                    break;
                }
                 */

            }
        }
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
