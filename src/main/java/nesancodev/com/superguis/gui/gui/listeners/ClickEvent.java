package nesancodev.com.superguis.gui.gui.listeners;

import nesancodev.com.superguis.gui.gui.guis.GUI;
import nesancodev.com.superguis.gui.gui.GUIButton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class ClickEvent implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        for (Inventory inv : GUI.lockedGUI) {
            if (e.getInventory() == inv) {
                e.setCancelled(true);
            }
        }

        if (GUIButton.stats.get(e.getInventory()) == null) {
            return;
        }

        HashMap<Integer, BukkitRunnable> actions = GUIButton.stats.get(e.getInventory());

        if (actions.get(e.getSlot()) == null) {
            return;
        }

        actions.get(e.getSlot()).run();
    }
}
