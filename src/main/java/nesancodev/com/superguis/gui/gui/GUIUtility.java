package nesancodev.com.superguis.gui.gui;

import nesancodev.com.superguis.gui.gui.guis.GUI;
import nesancodev.com.superguis.gui.gui.listeners.ClickEvent;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.Collections;

public class GUIUtility {

    public void register(Plugin plugin) {
        GUI.instance = plugin;

        plugin.getServer().getPluginManager().registerEvents(new ClickEvent(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new ClickEvent(), plugin);
    }

    public ItemStack buildItem(Material material, String name, String lore) {
        ItemStack it1 = new ItemStack(material);
        ItemMeta it1meta = it1.getItemMeta();
        String itm1 = ChatColor.translateAlternateColorCodes('&', name);
        it1meta.setLore(Collections.singletonList(ChatColor.translateAlternateColorCodes('&', lore)));
        it1meta.setDisplayName(itm1);
        it1.setItemMeta(it1meta);
        return it1;
    }

    public ItemStack buildItem(Material material, String name) {
        ItemStack it1 = new ItemStack(material);
        ItemMeta it1meta = it1.getItemMeta();
        String itm1 = ChatColor.translateAlternateColorCodes('&', name);
        it1meta.setDisplayName(itm1);
        it1.setItemMeta(it1meta);
        return it1;
    }

    public ItemStack buildItem(Material material, String name, String lore, Integer modeldata) {
        ItemStack it1 = new ItemStack(material);
        ItemMeta it1meta = it1.getItemMeta();
        assert name != null;
        String itm1 = ChatColor.translateAlternateColorCodes('&', name);
        assert it1meta != null;
        it1meta.setCustomModelData(modeldata);
        it1meta.setLore(Collections.singletonList(ChatColor.translateAlternateColorCodes('&', lore)));
        it1meta.setDisplayName(itm1);
        it1.setItemMeta(it1meta);
        return it1;
    }

    public ItemStack buildItem(Material material) {
        return new ItemStack(material);
    }
}
