package nesancodev.com.superguis.gui.gui.listeners;

import nesancodev.com.superguis.gui.gui.GUI;
import nesancodev.com.superguis.gui.gui.GUIButton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

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
