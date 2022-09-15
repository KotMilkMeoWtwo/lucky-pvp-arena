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
import ru.meowland.cmds.GiveCmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();
        FileConfiguration config = getConfig();
        getCommand("givelbb").setExecutor(new GiveCmd());
        getConfig();
        reloadConfig();
        this.getConfig();
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void luckyBlocksDrop(PlayerDeathEvent e){
        Player p = e.getEntity();
        Player killer = p.getKiller();

        if(killer != null){
            int rand = (int) (Math.random()*5);
            ItemStack itemStack;
            List<String> desc = new ArrayList<>();
            switch (rand){
                case (0):
                    itemStack = Blocks.lb1();
                    break;
                case (1):
                    itemStack = Blocks.lb2();
                    break;
                case (2):
                    itemStack = Blocks.lb3();
                    break;
                case (3):
                    itemStack = Blocks.lb4();
                    break;
                case (4):
                    itemStack = Blocks.lb5();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + rand);
            }
            killer.getInventory().addItem(itemStack);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void LuckBlockOpen(PlayerInteractEvent e){
        if(e.getPlayer().getItemInHand().getType() == Material.NETHERITE_BLOCK){
            if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
                Player p = e.getPlayer();
                p.sendMessage("meow");
                for(int i = 0; i < p.getInventory().getSize(); i++){
                    if(p.getInventory().getItem(i) != null){
                        List<String> desc = new ArrayList<>();
                        List<String> desc1 = new ArrayList<>();
                        ItemStack itemStack;
                        if(Objects.requireNonNull(p.getInventory().getItem(i)).getType() == Material.NETHERITE_BLOCK){

                            itemStack = Blocks.lb5();
                            p.getInventory().removeItem(itemStack);

                            int rand1 = (int) (Math.random()* getConfig().getInt("lb5.items_count"));

                            Material material = Material.valueOf(getConfig().getString("lb5.items." + rand1 + ".item"));
                            ItemStack item = setName(new ItemStack(material, 1), getConfig().getString("lb5.items." + rand1 + ".name"));
                            item.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, getConfig().getInt("lb5.items." + rand1 + ".enchants.ARROW_DAMAGE"));
                            item.addUnsafeEnchantment(Enchantment.ARROW_FIRE, getConfig().getInt("lb5.items." + rand1 + ".enchants.ARROW_FIRE"));
                            item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, getConfig().getInt("lb5.items." + rand1 + ".enchants.DAMAGE_ALL"));
                            item.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, getConfig().getInt("lb5.items." + rand1 + ".enchants.FIRE_ASPECT"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, getConfig().getInt("lb5.items." + rand1 + ".enchants.KNOCKBACK"));
                            item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, getConfig().getInt("lb5.items." + rand1 + ".enchants.PROTECTION_ENVIRONMENTAL"));
                            item.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, getConfig().getInt("lb5.items." + rand1 + ".enchants.PROTECTION_FIRE"));
                            item.addUnsafeEnchantment(Enchantment.THORNS, getConfig().getInt("lb5.items." + rand1 + ".enchants.THORNS"));

                            desc1.add(ChatColor.DARK_GRAY + "Выпадают: " + ChatColor.BOLD + ChatColor.DARK_BLUE + "EPIC" + ChatColor.DARK_GRAY + " вещи");
                            desc1.add(ChatColor.DARK_GRAY + "Выпадают: " + ChatColor.BOLD + ChatColor.GOLD + "LEGENDARY" + ChatColor.DARK_GRAY + " вещи");
                            p.getInventory().removeItem(new ItemStack(setName(new ItemStack(Material.NETHERITE_BLOCK, 1, (short) 0), ChatColor.GOLD + "Lucky block lvl 5", desc1)));
                            p.getInventory().addItem(item);
                            break;
                        } else if (Objects.requireNonNull(p.getInventory().getItem(i)).getType() == Material.COAL_BLOCK){
                            itemStack = Blocks.lb1();
                            p.getInventory().removeItem(itemStack);

                            int rand1 = (int) (Math.random()* getConfig().getInt("lb1.items_count"));

                            Material material = Material.valueOf(getConfig().getString("lb1.items." + rand1 + ".item"));
                            ItemStack item = setName(new ItemStack(material, 1), getConfig().getString("lb1.items." + rand1 + ".name"));
                            item.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, getConfig().getInt("lb1.items." + rand1 + ".enchants.ARROW_DAMAGE"));
                            item.addUnsafeEnchantment(Enchantment.ARROW_FIRE, getConfig().getInt("lb1.items." + rand1 + ".enchants.ARROW_FIRE"));
                            item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, getConfig().getInt("lb1.items." + rand1 + ".enchants.DAMAGE_ALL"));
                            item.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, getConfig().getInt("lb1.items." + rand1 + ".enchants.FIRE_ASPECT"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, getConfig().getInt("lb1.items." + rand1 + ".enchants.KNOCKBACK"));
                            item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, getConfig().getInt("lb1.items." + rand1 + ".enchants.PROTECTION_ENVIRONMENTAL"));
                            item.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, getConfig().getInt("lb1.items." + rand1 + ".enchants.PROTECTION_FIRE"));
                            item.addUnsafeEnchantment(Enchantment.THORNS, getConfig().getInt("lb1.items." + rand1 + ".enchants.THORNS"));

                            p.getInventory().removeItem(p.getItemOnCursor());
                            p.getInventory().addItem(item);
                            break;
                        } else if (Objects.requireNonNull(p.getInventory().getItem(i)).getType() == Material.IRON_BLOCK) {
                            itemStack = Blocks.lb2();
                            p.getInventory().removeItem(itemStack);

                            int rand1 = (int) (Math.random()* getConfig().getInt("lb2.items_count"));

                            Material material = Material.valueOf(getConfig().getString("lb2.items." + rand1 + ".item"));
                            ItemStack item = setName(new ItemStack(material, 1), getConfig().getString("lb2.items." + rand1 + ".name"));
                            item.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, getConfig().getInt("lb2.items." + rand1 + ".enchants.ARROW_DAMAGE"));
                            item.addUnsafeEnchantment(Enchantment.ARROW_FIRE, getConfig().getInt("lb2.items." + rand1 + ".enchants.ARROW_FIRE"));
                            item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, getConfig().getInt("lb2.items." + rand1 + ".enchants.DAMAGE_ALL"));
                            item.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, getConfig().getInt("lb2.items." + rand1 + ".enchants.FIRE_ASPECT"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, getConfig().getInt("lb2.items." + rand1 + ".enchants.KNOCKBACK"));
                            item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, getConfig().getInt("lb2.items." + rand1 + ".enchants.PROTECTION_ENVIRONMENTAL"));
                            item.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, getConfig().getInt("lb2.items." + rand1 + ".enchants.PROTECTION_FIRE"));
                            item.addUnsafeEnchantment(Enchantment.THORNS, getConfig().getInt("lb2.items." + rand1 + ".enchants.THORNS"));

                            p.getInventory().removeItem(p.getItemOnCursor());
                            p.getInventory().addItem(item);
                            break;
                        } else if (Objects.requireNonNull(p.getInventory().getItem(i)).getType() == Material.GOLD_BLOCK) {
                            itemStack = Blocks.lb3();
                            p.getInventory().removeItem(itemStack);

                            int rand1 = (int) (Math.random()* getConfig().getInt("lb3.items_count"));

                            Material material = Material.valueOf(getConfig().getString("lb3.items." + rand1 + ".item"));
                            ItemStack item = setName(new ItemStack(material, 1), getConfig().getString("lb3.items." + rand1 + ".name"));
                            item.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, getConfig().getInt("lb3.items." + rand1 + ".enchants.ARROW_DAMAGE"));
                            item.addUnsafeEnchantment(Enchantment.ARROW_FIRE, getConfig().getInt("lb3.items." + rand1 + ".enchants.ARROW_FIRE"));
                            item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, getConfig().getInt("lb3.items." + rand1 + ".enchants.DAMAGE_ALL"));
                            item.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, getConfig().getInt("lb3.items." + rand1 + ".enchants.FIRE_ASPECT"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, getConfig().getInt("lb3.items." + rand1 + ".enchants.KNOCKBACK"));
                            item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, getConfig().getInt("lb3.items." + rand1 + ".enchants.PROTECTION_ENVIRONMENTAL"));
                            item.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, getConfig().getInt("lb3.items." + rand1 + ".enchants.PROTECTION_FIRE"));
                            item.addUnsafeEnchantment(Enchantment.THORNS, getConfig().getInt("lb3.items." + rand1 + ".enchants.THORNS"));

                            p.getInventory().removeItem(p.getItemOnCursor());
                            p.getInventory().addItem(item);
                            break;
                        } else if (Objects.requireNonNull(p.getInventory().getItem(i)).getType() == Material.DIAMOND_BLOCK) {
                            itemStack = Blocks.lb4();
                            p.getInventory().removeItem(itemStack);

                            int rand1 = (int) (Math.random()* getConfig().getInt("lb4.items_count"));

                            Material material = Material.valueOf(getConfig().getString("lb4.items." + rand1 + ".item"));
                            ItemStack item = setName(new ItemStack(material, 1), getConfig().getString("lb4.items." + rand1 + ".name"));
                            item.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, getConfig().getInt("lb4.items." + rand1 + ".enchants.ARROW_DAMAGE"));
                            item.addUnsafeEnchantment(Enchantment.ARROW_FIRE, getConfig().getInt("lb4.items." + rand1 + ".enchants.ARROW_FIRE"));
                            item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, getConfig().getInt("lb4.items." + rand1 + ".enchants.DAMAGE_ALL"));
                            item.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, getConfig().getInt("lb4.items." + rand1 + ".enchants.FIRE_ASPECT"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, getConfig().getInt("lb4.items." + rand1 + ".enchants.KNOCKBACK"));
                            item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, getConfig().getInt("lb4.items." + rand1 + ".enchants.PROTECTION_ENVIRONMENTAL"));
                            item.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, getConfig().getInt("lb4.items." + rand1 + ".enchants.PROTECTION_FIRE"));
                            item.addUnsafeEnchantment(Enchantment.THORNS, getConfig().getInt("lb4.items." + rand1 + ".enchants.THORNS"));

                            p.getInventory().removeItem(p.getItemOnCursor());
                            p.getInventory().addItem(item);
                            break;
                        }
                    }
                }
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
