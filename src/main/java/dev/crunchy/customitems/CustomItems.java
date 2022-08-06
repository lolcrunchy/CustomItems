package dev.crunchy.customitems;

import dev.crunchy.customitems.Items.Commands;
import dev.crunchy.customitems.Items.CustomPickaxe;
import dev.crunchy.customitems.Items.TeleportRod;
import dev.crunchy.customitems.Menus.MenuEvents.CustomPickaxeMenuListener;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomItems extends JavaPlugin {

    @Override
    public void onEnable() {

        /**
         * Kommando handler
         */
        Commands commands = new Commands();
        this.getCommand("customitems").setExecutor(new Commands());

        /**
         * EventListener handler
         */
        this.getServer().getPluginManager().registerEvents((new TeleportRod(this)), this);
        this.getServer().getPluginManager().registerEvents(new CustomPickaxe(), this);
        this.getServer().getPluginManager().registerEvents((new CustomPickaxeMenuListener(this)), this);

    }

    @Override
    public void onDisable() {

    }

}
