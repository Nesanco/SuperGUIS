package nesancodev.com.superguis.gui.gui;

import nesancodev.com.superguis.gui.gui.guis.GUI;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;

public class GUIButton {
    public static ArrayList<BukkitRunnable> runnables = new ArrayList<>();
    public static ArrayList<Integer> slots = new ArrayList<>();
    public static ArrayList<Inventory> inventories = new ArrayList<>();

    private Integer slot;
    private Inventory inv;

    private BukkitRunnable runnable;

    public GUIButton(Integer slot, GUI gui) {
        this.slot = slot;
        this.inv = gui.getInventoryRaw();
    }

    public void setAction(BukkitRunnable rb) {
        runnables.add(rb);
        slots.add(slot);
        inventories.add(inv);

        runnable = rb;
    }

    public void delete() {
        runnables.remove(runnable);
        slots.remove(slot);
        inventories.remove(inv);
    }
}
