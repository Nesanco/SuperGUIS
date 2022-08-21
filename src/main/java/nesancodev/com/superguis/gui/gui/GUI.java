package nesancodev.com.superguis.gui.gui;

import nesancodev.com.superguis.gui.gui.listeners.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GUI implements Listener {
    public static ArrayList<Inventory> lockedGUI = new ArrayList<>();
    public static Plugin instance;

    private Inventory inv;
    private String format;
    private GUIType type;
    private String title;
    private HashMap<String, ItemStack> formatMap = new HashMap<>();

    public GUI(int size, String title, GUIType type) {
        this.inv = Bukkit.createInventory(null, size, title);
        this.type = type;
        this.title = title;
    }

    public void lock(Plugin plugin) {
        instance = plugin;
        lockedGUI.add(inv);

        plugin.getServer().getPluginManager().registerEvents(new ClickEvent(), plugin);
    }

    public void addButton(Integer slot, BukkitRunnable code) {

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

    public ItemStack getItem(Integer slot) {
        return inv.getItem(slot);
    }

    public ArrayList<ItemStack> getAll(ItemStack stack) {
        ArrayList<ItemStack> stacks = new ArrayList<>();
        for (ItemStack x : inv.getContents()) {
            if (x == stack) {
                stacks.add(x);
            }
        }
        return stacks;
    }

    public void remove(Integer i) {
        inv.clear(i);
    }

    public HashMap<Integer, ItemStack> getAll() {
        HashMap<Integer, ItemStack> stackHashMap = new HashMap<>();
        for (int i = 0; i < inv.getSize(); i++) {
            stackHashMap.put(i, inv.getItem(i));
        }
        return stackHashMap;
    }

    public String getTitle() {
        return title;
    }

    public List<HumanEntity> getViewers() {
        return inv.getViewers();
    }

    public Integer getSize() {
        return inv.getSize();
    }

    public ItemStack[] getItems() {
        return inv.getContents();
    }

    public void addFormat(String text, ItemStack stack) {
        formatMap.put(text, stack);
    }

    public void formatSlot(Integer slot, ItemStack stack) {
        inv.setItem(slot, stack);
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

    @EventHandler
    private void onInventoryClick(InventoryClickEvent e) {
        for (Inventory inv : GUI.lockedGUI) {
            if (e.getInventory() == inv) {
                e.setCancelled(true);
            }
        }
    }
}
