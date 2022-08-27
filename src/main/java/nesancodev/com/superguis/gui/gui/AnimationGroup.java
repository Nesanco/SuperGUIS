package nesancodev.com.superguis.gui.gui;

import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

public class AnimationGroup {
    private ArrayList<Animation> animations = new ArrayList<>();

    public void addAnimation(Animation animation) {
        animations.add(animation);
    }

    public void removeAnimation(Animation animation) {
        animations.remove(animation);
    }

    public void play() {
        for (Animation anima : animations) {
            anima.play();
        }
    }

    public void toggle() {
        for (Animation anima : animations) {
            anima.toggle();
        }
    }

    public void stop() {
        for (Animation anima : animations) {
            anima.stop();
        }
    }

    public ArrayList<Animation> getAnimations() {
        return animations;
    }
}
