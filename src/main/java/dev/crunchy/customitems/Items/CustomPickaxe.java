package dev.crunchy.customitems.Items;

import dev.crunchy.customitems.Menus.CustomPickaxeMenu;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class CustomPickaxe implements Listener {

    private static ItemStack up;

    static {
        up();
    }

    @EventHandler
    public void onclick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (player.getInventory().getItemInHand().getType() == Material.DIAMOND_PICKAXE) {
                if (player.getInventory().getItemInHand().hasItemMeta()) {
                    if (player.getInventory().getItemInHand().getItemMeta().getDisplayName().equals("§aCustom Pickaxe §7(Højre klik)")) {
                        CustomPickaxeMenu gui = new CustomPickaxeMenu();
                        player.openInventory(gui.getInventory());
                    }
                }
            }
        }
    }

    private static void up() {
        ItemStack cp = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta meta = cp.getItemMeta();
        meta.setDisplayName("§aCustom Pickaxe §7(Højre klik)");
        List<String> makeLore = makeLore(
                "&7",
                "&7Enchantments",
                "&f• Explosive: &a ",
                "&f• Luck: &a ",
                "&f• Efficiency: &a ",
                "&f• Unbreaking: &a ",
                "&7",
                "&7Stats",
                "&f• Level: &a ",
                "&f• Blocks smadret: &a0",
                "&7");
        meta.setLore(makeLore);
        meta.addEnchant(Enchantment.DIG_SPEED, 5, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        cp.setItemMeta(meta);

        up = cp;
    }
    public static ItemStack getCustomPickaxe() {
        return up.clone();
    }

    public static ArrayList<String> makeLore(String... str) {
        ArrayList<String> lore = new ArrayList<>();
        for(String s : str) {
            lore.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        return lore;
    }


}
