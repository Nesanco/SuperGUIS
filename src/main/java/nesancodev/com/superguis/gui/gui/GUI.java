package nesancodev.com.superguis.gui.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class GUI {
    private Inventory inv;
    private String format;
    private GUIType type;
    private HashMap<String, ItemStack> formatMap = new HashMap<>();

    public GUI(int size, String title, GUIType type) {
        this.inv = Bukkit.createInventory(null, size, title);
        this.type = type;
    }

    public Inventory getInventoryRaw() {
        return inv;
    }

    public void content(String format) {
        this.format = format;
    }

    public GUIType getType() {
        return type;
    }

    public void addFormat(String text, ItemStack stack) {
        formatMap.put(text, stack);
    }

    public void open(Player p) {
        for(int i = 0; i < format.length(); i++)
        {
            String c = String.valueOf(format.charAt(i));
            if (formatMap.get(c) != null) {
                ItemStack stack = formatMap.get(c);
                inv.setItem(i, stack);
            }
        }

        p.openInventory(inv);
    }
}
