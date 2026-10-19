package me.gallowsdove.foxymachines.utils;

import me.gallowsdove.foxymachines.FoxyMachines;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Bukkit;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    private Utils() {}

    public static boolean isAuraSkillsLoaded() {
        return Bukkit.getPluginManager().isPluginEnabled("AuraSkills");
    }

    /**
     * Applies true damage one tick later. Almost every caller runs inside an EntityDamageEvent:
     * killing the entity there (setHealth(0)) and then letting the event's own damage apply made
     * players die twice (two death messages, two PlayerDeathEvents). Deferring lets the hit
     * resolve first; if it already killed, the extra damage is simply skipped.
     */
    public static void dealDamageBypassingArmor(LivingEntity entity, double damage) {
        if (damage <= 0) {
            return;
        }
        runNextTickIfAlive(entity, () -> {
            double remaining = damage;
            double absorption = entity.getAbsorptionAmount();
            if (absorption > 0) {
                double absorbed = Math.min(absorption, remaining);
                entity.setAbsorptionAmount(absorption - absorbed);
                remaining -= absorbed;
            }
            if (remaining > 0) {
                entity.setHealth(Math.max(0, entity.getHealth() - remaining));
            }
        });
    }

    /** Same deferral as {@link #dealDamageBypassingArmor}, for extra hits dealt from inside a damage event. */
    public static void damageNextTick(LivingEntity entity, double damage) {
        runNextTickIfAlive(entity, () -> entity.damage(damage));
    }

    private static void runNextTickIfAlive(LivingEntity entity, Runnable action) {
        Bukkit.getScheduler().runTask(FoxyMachines.getInstance(), () -> {
            if (entity.isValid() && !entity.isDead()) {
                action.run();
            }
        });
    }

    public static int countItemInInventory(@Nonnull Inventory inventory, @Nonnull ItemStack itemStack) {
        int amount = 0;
        for (ItemStack item : inventory.getContents()) {
            if (itemStack.isSimilar(item)) {
                amount = amount + item.getAmount();
            }
        }

        return amount;
    }

    public static boolean isWithinBox(Location centerLocation, Location location, double radius) {
        return isWithinBox(centerLocation, location, radius, radius, radius);
    }

    public static boolean isWithinBox(Location centerLocation, Location location, double x, double y, double z) {
        return Math.abs(centerLocation.getX() - location.getX()) <= x
                && Math.abs(centerLocation.getY() - location.getY()) <= y
                && Math.abs(centerLocation.getZ() - location.getZ()) <= z;
    }

    public static List<Player> getNearbyPlayersInSurvival(Location location, double radius) {
        return getNearbyPlayersInSurvival(location, radius, radius, radius);
    }

    public static List<Player> getNearbyPlayersInSurvival(Location location, double x, double y, double z) {
        World world = location.getWorld();
        if (world == null) {
            return new ArrayList<>();
        }

        List<Player> players = new ArrayList<>();
        for (Entity entity : world.getNearbyEntities(location, x, y, z)) {
            if (entity instanceof Player player && player.getGameMode() == GameMode.SURVIVAL) {
                players.add(player);
            }
        }
        return players;
    }

    public static Player getNearbyPlayerInSurvival(Location location, double radius) {
        return getNearbyPlayerInSurvival(location, radius, radius, radius);
    }

    public static @Nullable Player getNearbyPlayerInSurvival(Location location, double x, double y, double z) {
        World world = location.getWorld();
        if (world == null) {
            return null;
        }

        for (Entity entity : world.getNearbyEntities(location, x, y, z)) {
            if (entity instanceof Player player && player.getGameMode() == GameMode.SURVIVAL) {
                return player;
            }
        }
        return null;
    }
}
