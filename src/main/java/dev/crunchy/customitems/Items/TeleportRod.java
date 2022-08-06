package dev.crunchy.customitems.Items;

import dev.crunchy.customitems.CustomItems;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.UUID;

public class TeleportRod implements Listener {

    private final CustomItems plugin;
    public TeleportRod(CustomItems plugin) {
        this.plugin = plugin;
    }

    private HashMap<UUID, Long> cooldown = new HashMap<UUID, Long>();
    private int cooldowntime = 5;

    private static ItemStack TR;

    static {
        TR();
    }

    private static void TR() {
        ItemStack rod = new ItemStack(Material.FISHING_ROD, 1);
        ItemMeta meta = rod.getItemMeta();
        meta.setDisplayName("§aTeleport Rod §7(Højre klik)");
        meta.addEnchant(Enchantment.ARROW_FIRE, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        rod.setItemMeta(meta);


        TR = rod;
    }
    public static ItemStack getTeleportRod() {
        return TR.clone();
    }

    @EventHandler
    public void onright(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (player.getInventory().getItemInHand().getType() == Material.FISHING_ROD) {
                if (player.getInventory().getItemInHand().hasItemMeta()) {
                    if (player.getInventory().getItemInHand().getItemMeta().getDisplayName().equals("§aTeleport Rod §7(Højre klik)")) {
                        if (cooldown.containsKey(player.getUniqueId())) {
                            if (cooldown.get(player.getUniqueId()) > System.currentTimeMillis()) {
                                long secondsleft = (cooldown.get(player.getUniqueId()) - System.currentTimeMillis()) / 1000;
                                player.sendMessage("§6§m--------------------------------------------------------------");
                                player.sendMessage("§6");
                                player.sendMessage("§eVent venligst " + secondsleft + " sekunder, og prøv igen!");
                                player.sendMessage("§6");
                                player.sendMessage("§6§m--------------------------------------------------------------");
                                player.getWorld().playSound(player.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
                                return;
                            }
                        }
                        Vector unitVector = new Vector(player.getLocation().getDirection().getX(), player.getLocation().getDirection().getY(), player.getLocation().getDirection().getZ());
                        player.setVelocity(unitVector.multiply(2));
                        player.getWorld().playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1.0F, 1.0F);
                        cooldown.put(player.getUniqueId(), System.currentTimeMillis() + (6 * 1000));
                    }
                }
            }
        }
    }

    @EventHandler
    public void signClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if(event.getClickedBlock() == null || event.getClickedBlock().getState() == null) {
            return;
        }
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getClickedBlock().getType() == Material.WALL_SIGN || event.getClickedBlock().getType() == Material.SIGN_POST || event.getClickedBlock().getType() == Material.SIGN) {
                if (sign.getLine(0).equalsIgnoreCase(colorTrans("&4&lWARPS"))) {
                    Sign sign = (Sign) event.getClickedBlock().getState();
                    if (player.hasPermission(perms("", "", "", "", "", "", "", ""))) {
                        if (plugin.cooldown.containsKey(player.getUniqueId())) {
                            long secondsleft = ((plugin.cooldown.get(player.getUniqueId()) / 1000) + plugin.cooldowmtime) - (System.currentTimeMillis() / 1000);

                            if (secondsleft > 0) {
                                player.sendMessage(colorTrans("&8&l| &e&lVAGT &8&l| &fDu har vagt cooldown! &8(&7" + plugin.convert(secondsleft) + "&8)"));
                                return;

                            }
                        }
                        Gui i = new Gui();
                        i.vagtServerSelectorGui(player);
                    }
                    sign.update();
                }
            }
        }
    }

    public String colorTrans(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public String perms (String... s) {
        return perms(s);
    }
}
