package nesancodev.com.superguis.gui.gui;

import nesancodev.com.superguis.gui.gui.guis.GUI;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public class Animation {
    private Integer counter = 1;
    private HashMap<Integer, ItemStack> animations = new HashMap<>();
    private Integer slot;
    private Inventory inv;
    private Integer ticks = 60;
    private BukkitTask toggle;

    public Animation(Integer slot, GUI gui) {
        this.slot = slot;
        this.inv = gui.getInventoryRaw();
    }

    public void newFrame(ItemStack stack) {
        animations.put(counter, stack);
        counter++;
    }

    public void setTime(Integer ticks) {
        this.ticks = ticks;
    }

    public Integer getTime() {
        return ticks;
    }

    public void play() {

        BukkitTask task = new BukkitRunnable() {
            int iterations = 1;
            final int keyframes = animations.values().size();

            @Override
            public void run() {
                ItemStack stack = animations.get(iterations);
                inv.setItem(slot, stack);

                iterations++;

                if (iterations > keyframes) {
                    this.cancel();
                }
            }
        }.runTaskTimer(GUI.instance, 0, ticks);
    }

    public void stop() {
        toggle.cancel();
    }

    public void toggle() {

        this.toggle = new BukkitRunnable() {
            int iterations = 1;
            final int keyframes = animations.values().size();

            @Override
            public void run() {
                ItemStack stack = animations.get(iterations);
                inv.setItem(slot, stack);

                iterations++;

                if (iterations > keyframes) {
                    iterations = 1;
                }
            }
        }.runTaskTimer(GUI.instance, 0, ticks);
    }
}
