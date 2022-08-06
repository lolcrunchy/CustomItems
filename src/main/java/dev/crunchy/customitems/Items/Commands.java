package dev.crunchy.customitems.Items;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("customitems")) {
            if (player.hasPermission("customitems")) {
                if (args.length <= 0) {
                    player.sendMessage("§6§m--------------------------------------------------------------");
                    player.sendMessage("§6Commands:");
                    player.sendMessage("§e/Customitems help§c - Udskriver denne besked");
                    player.sendMessage("§e/Customitems reload §c-Reloader config filen");
                    player.sendMessage("§e/Customitems give (Spiller) (Item) §c- Giver spilleren et item");
                    player.sendMessage("");
                    player.sendMessage("§6Version: 1.0.0");
                    player.sendMessage("");
                    player.sendMessage("§6§m--------------------------------------------------------------");
                } else if (args.length <= 1) {
                    if (args[0].equalsIgnoreCase("help")) {
                        player.sendMessage("§6§m--------------------------------------------------------------");
                        player.sendMessage("§6Commands:");
                        player.sendMessage("§e/Customitems help§c - Udskriver denne besked");
                        player.sendMessage("§e/Customitems reload §c-Reloader config filen");
                        player.sendMessage("§e/Customitems give (Spiller) (Item) §c- Giver spilleren et item");
                        player.sendMessage("");
                        player.sendMessage("§6Version: 1.0.0");
                        player.sendMessage("");
                        player.sendMessage("§6§m--------------------------------------------------------------");
                    } else if (args[0].equalsIgnoreCase("reload")) {
                        player.sendMessage("§6§m--------------------------------------------------------------");
                        player.sendMessage("§d");
                        player.sendMessage("§cConfig.yml eksistere ikke");
                        player.sendMessage("§c");
                        player.sendMessage("§6§m--------------------------------------------------------------");
                    } else if (args[0].equalsIgnoreCase("give")) {
                        player.sendMessage("§6§m--------------------------------------------------------------");
                        player.sendMessage("§6Items:");
                        player.sendMessage("§eTeleport Rod §c- Højre klik og bliv teleporteret");
                        player.sendMessage("§eCustom Pickaxe §c- Højre klik og opgradere din pickaxe");
                        player.sendMessage("");
                        player.sendMessage("§6§m--------------------------------------------------------------");
                    } else {
                        player.sendMessage("§6§m--------------------------------------------------------------");
                        player.sendMessage("§6Items:");
                        player.sendMessage("§eTeleport Rod §c- Højre klik og bliv teleporteret");
                        player.sendMessage("§eCustom Pickaxe §c- Højre klik og opgradere din pickaxe");
                        player.sendMessage("");
                        player.sendMessage("§6§m--------------------------------------------------------------");
                    }

                } else if (args.length <= 2) {
                    player.sendMessage("§6§m--------------------------------------------------------------");
                    player.sendMessage("§6Items:");
                    player.sendMessage("§eTeleport Rod §c- Højre klik og bliv teleporteret");
                    player.sendMessage("§eCustom Pickaxe §c- Højre klik og opgradere din pickaxe");
                    player.sendMessage("");
                    player.sendMessage("§6§m--------------------------------------------------------------");

                } else if (args.length <= 3) {
                    if (args[2].equalsIgnoreCase("teleportrod")) {
                        player.sendMessage("§6§m--------------------------------------------------------------");
                        player.sendMessage("");
                        player.sendMessage("§e" + player.getName() + " modtog teleport rod");
                        player.sendMessage("");
                        player.sendMessage("§6§m--------------------------------------------------------------");
                        player.getInventory().addItem(TeleportRod.getTeleportRod());
                    } else if (args[2].equalsIgnoreCase("custompickaxe")) {
                        player.sendMessage("§6§m--------------------------------------------------------------");
                        player.sendMessage("");
                        player.sendMessage("§e" + player.getName() + " modtog custom pickaxe");
                        player.sendMessage("");
                        player.sendMessage("§6§m--------------------------------------------------------------");
                        player.getInventory().addItem(CustomPickaxe.getCustomPickaxe());
                    } else {
                        player.sendMessage("§6§m--------------------------------------------------------------");
                        player.sendMessage("§6Items:");
                        player.sendMessage("§eTeleport Rod §c- Højre klik og bliv teleporteret");
                        player.sendMessage("");
                        player.sendMessage("§6§m--------------------------------------------------------------");
                    }
                }
            } else {
                player.sendMessage("§6§m--------------------------------------------------------------");
                player.sendMessage("§d");
                player.sendMessage("§cDu har ikke adgang til denne kommando");
                player.sendMessage("§c");
                player.sendMessage("§6§m--------------------------------------------------------------");
            }
            return true;
        }
        return false;
    }
}
