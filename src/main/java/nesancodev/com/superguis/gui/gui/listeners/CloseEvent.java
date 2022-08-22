package nesancodev.com.superguis.gui.gui.listeners;

import nesancodev.com.superguis.gui.gui.guis.GUI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class CloseEvent implements Listener {

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        if (GUI.onclose.get(e.getInventory()) == null) {
            return;
        }

        BukkitRunnable rb = GUI.onclose.get(e.getInventory());
        rb.run();
    }
}
