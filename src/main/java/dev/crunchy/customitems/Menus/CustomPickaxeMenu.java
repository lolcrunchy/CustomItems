package dev.crunchy.customitems.Menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomPickaxeMenu implements InventoryHolder {

    private Inventory inv;

    public CustomPickaxeMenu() {
        inv = Bukkit.createInventory(this, 54, "Opgradere din pickaxe");
        items();
    }

    /**
     * Alle items i menuen!
     */
    private void items() {
        ItemStack item;
        for (int i = 36; i < 45; i++) {
            item = setItem("§7", Material.STAINED_GLASS_PANE, (short)7, Collections.synchronizedList(makeLore("")));
            inv.setItem(i, item);
        }
        item = setItem("§c▸ Efficiency", Material.FEATHER, (short)0, Collections.synchronizedList(makeLore(
                "&8Øger hastigheden af din mining!",
                "",
                "&8&l➥ &7Opgradere din pickaxe med efficiency,",
                "&8&l➥ &7og mine hurtigere!",
                "&8&l➥ &7Du tilføjer +1 hver gang du køber dette!",
                "",
                "&8&l➥ &7Pris: &a2.500.000",
                "",
                "&eKlik for at købe &6✦")));
        inv.setItem(12, item);
        item = setItem("§c▸ Explosive", Material.TNT, (short)0, Collections.synchronizedList(makeLore(
                "&8Laver explosioner imens du miner!",
                "",
                "&8&l➥ &7Opgradere din pickaxe med explosive,",
                "&8&l➥ &7så når du miner er der et område der spinger!",
                "&8&l➥ &7Du tilføjer +1 hver gang du køber dette!",
                "",
                "&8&l➥ &7Pris: &a50.000.000",
                "",
                "&eKlik for at købe &6✦")));
        inv.setItem(13, item);
        item = setItem("§C▸ Unbreaking", Material.ANVIL, (short)0, Collections.synchronizedList(makeLore(
                "&8Styrker ubrydeligheden af dit tool!",
                "",
                "&8&l➥ &7Opgradere din pickaxe med unbreaking,",
                "&8&l➥ &7så din pickaxe aldrig går i stykker!",
                "&8&l➥ &7Du tilføjer +1 hver gang du køber dette!",
                "",
                "&8&l➥ &7Pris: &a2.000.000",
                "",
                "&eKlik for at købe &6✦")));
        inv.setItem(14, item);
        item = setItem("§c▸ Adgang Nægtet", Material.STAINED_GLASS, (short)14, Collections.synchronizedList(makeLore(
                "&8Ingen adgang til denne funktion!",
                "",
                "&7Du har desværre ikke adgang til denne funktion",
                "",
                "&eIngen Adgang &6✦")));
        inv.setItem(18, item);
        inv.setItem(19, item);
        inv.setItem(25, item);
        inv.setItem(26, item);
        item = setItem("§c▸ Luck", Material.EXP_BOTTLE, (short)0, Collections.synchronizedList(makeLore(
                "&8Chancen for at modtage gaver imens du miner!",
                "",
                "&8&l➥ &7Opgradere din pickaxe med luck,",
                "&8&l➥ &7så har du chancen for at modtage penge samt coins,",
                "&8&l➥ &7imens du miner!",
                "&8&l➥ &7Du tilføjer +1 hver gang du køber dette!",
                "",
                "&7Pris: &a15.000.000",
                "",
                "&eKlik for at købe &6✦")));
        inv.setItem(22, item);
        item = setItem("§c▸ Profil", Material.NETHER_STAR, (short)0, Collections.synchronizedList(makeLore(
                "&8Se dine stats!",
                "",
                "&7Vil du se dine stats,",
                "&7se dem her!",
                "",
                "&eKlik for at åbne stats &6✦")));
        inv.setItem(46, item);
        item = setItem("§c▸ Luk Menuen", Material.BARRIER, (short)0, Collections.synchronizedList(makeLore(
                "&8Lukker din menu!",
                "",
                "&8&l➥ &7Vil du lukke din menu? Så klik her.",
                "",
                "&eKlik for at lukke menu &6✦")));
        inv.setItem(49, item);
        item = setItem("§c▸ Indstillinger", Material.COMPASS, (short)0, Collections.synchronizedList(makeLore(
                "&8Ændre dine indstillinger!",
                "",
                "&7Ændre dine indstiller omkring din pickaxe!",
                "",
                "&eKlik for at åbne indstillinger &6✦")));
        inv.setItem(52, item);
    }

    private ItemStack setItem(String name, Material mat, short i, List<String> lore) {
        ItemStack item = new ItemStack(mat, 1, (short)i);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    /**
     * Laver lore mere overskuelig
     */
    public static ArrayList<String> makeLore(String... str) {
        ArrayList<String> lore = new ArrayList<>();
        for(String s : str) {
            lore.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        return lore;
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
