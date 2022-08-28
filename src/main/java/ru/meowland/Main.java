package ru.meowland;

import org.bukkit.Material;
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

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("meow");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onKillPlayer(PlayerDeathEvent e){
        Player p = e.getEntity();
        Player killer = p.getKiller();

        if(killer != null){
            ItemStack itemStack = new ItemStack(setName( new ItemStack(Material.DIAMOND, 1, (short) 0), "Lucky block"));
            killer.getInventory().addItem(itemStack);
            killer.sendMessage("u get diamond");
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void LuckBlockOpen(PlayerInteractEvent e){
        if(e.getPlayer().getItemInHand().getType() == Material.DIAMOND){
            if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
                Player p = e.getPlayer();
                p.sendMessage("meow");
                p.getInventory().remove(Material.DIAMOND);
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

}
