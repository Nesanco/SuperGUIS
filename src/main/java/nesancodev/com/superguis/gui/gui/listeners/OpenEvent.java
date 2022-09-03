package nesancodev.com.superguis.gui.gui.listeners;

import nesancodev.com.superguis.gui.gui.guis.GUI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class OpenEvent implements Listener {

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent e) {
        if (GUI.onopen.get(e.getInventory()) == null) {
            return;
        }

        BukkitRunnable rb = GUI.onopen.get(e.getInventory());
        rb.run();
    }
}
