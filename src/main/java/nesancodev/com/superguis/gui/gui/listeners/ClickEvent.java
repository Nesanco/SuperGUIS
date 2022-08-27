package nesancodev.com.superguis.gui.gui.listeners;

import nesancodev.com.superguis.gui.gui.guis.GUI;
import nesancodev.com.superguis.gui.gui.GUIButton;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class ClickEvent implements Listener {
    public static HashMap<Inventory, ClickType> clickTypeHashMap = new HashMap<>();
    public static HashMap<Inventory, ItemStack> clickedItemHashMap = new HashMap<>();
    public static HashMap<Inventory, Integer> slotHashMap = new HashMap<>();
    public static HashMap<Inventory, HumanEntity> playerHashMap = new HashMap<>();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        clickTypeHashMap.put(e.getInventory(), e.getClick());
        slotHashMap.put(e.getInventory(), e.getSlot());
        clickedItemHashMap.put(e.getInventory(), e.getCurrentItem());
        playerHashMap.put(e.getInventory(), e.getWhoClicked());

        for (Inventory inv : GUI.lockedGUI) {
            if (e.getInventory() == inv) {
                e.setCancelled(true);
            }
        }

        int slot = e.getSlot();
        for (int i = 0; i < GUIButton.inventories.size(); i++) {

            if (GUIButton.slots.get(i) == slot && GUIButton.inventories.get(i) == e.getInventory()) {
                BukkitRunnable rb = GUIButton.runnables.get(i);

                rb.run();
            }
        }
    }
}
