package nesancodev.com.superguis.gui.gui;

import nesancodev.com.superguis.gui.gui.listeners.ClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public class GUIButton {
    public static HashMap<Inventory, HashMap<Integer, BukkitRunnable>> stats = new HashMap<>();

    private Integer slot;
    private Inventory inv;

    public GUIButton(Integer slot, GUI gui) {
        this.slot = slot;
        this.inv = gui.getInventoryRaw();
    }

    public void setAction(BukkitRunnable rb, Plugin plugin) {
        HashMap<Integer, BukkitRunnable> map = new HashMap<>();
        map.put(slot, rb);
        stats.put(inv, map);

        plugin.getServer().getPluginManager().registerEvents(new ClickEvent(), plugin);
    }
}
