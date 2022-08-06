package dev.crunchy.customitems.Menus.MenuEvents;

import dev.crunchy.customitems.CustomItems;
import dev.crunchy.customitems.Menus.CustomPickaxeMenu;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CustomPickaxeMenuListener implements Listener {

    private CustomItems plugin;
    public CustomPickaxeMenuListener(CustomItems plugin) {
        this.plugin = plugin;
    }

    /**
     * Tjekker når spilleren klikker i menuen, og tjekker om
     * spilleren har noget i sin cursor!
     */
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getClickedInventory().getHolder() instanceof CustomPickaxeMenu) {
            if (!(e.getCurrentItem().getType() == Material.AIR)) {
                e.setCancelled(true);
            }

            if (!(e.getCursor().getType() == Material.AIR)) {
                e.setCancelled(true);
            }

            if (e.getSlot() == 12) {
                e.setCancelled(true);
                player.playSound(player.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
            }

            if (e.getSlot() == 13) {
                e.setCancelled(true);
                player.playSound(player.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
            }

            if (e.getSlot() == 14) {
                e.setCancelled(true);
                player.playSound(player.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
            }

            if (e.getSlot() == 22) {
                e.setCancelled(true);
                player.playSound(player.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
            }

            if (e.getSlot() == 46) {
                e.setCancelled(true);
                player.playSound(player.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
            }

            if (e.getSlot() == 52) {
                e.setCancelled(true);
                player.playSound(player.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
            }
            /**
             * inv.setItem(12, item);
             * inv.setItem(13, item);
             * inv.setItem(14, item);
             * inv.setItem(22, item);
             * inv.setItem(46, item);
             * inv.setItem(52, item);
             */



            if (e.getSlot() == 49) {
                e.setCancelled(true);
                player.playSound(player.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
                player.closeInventory();
            }

            if (e.getSlot() == 18 || e.getSlot() == 19 || e.getSlot() == 25 || e.getSlot() == 26) {
                e.setCancelled(true);
                player.playSound(player.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
                player.closeInventory();
            }
            /**
             * Alle slots af adgang nægtet
             *
             * inv.setItem(18, item);
             * inv.setItem(19, item);
             * inv.setItem(25, item);
             * inv.setItem(26, item);
             */
        }
    }

}
