package me.gallowsdove.foxymachines.types;

import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.gallowsdove.foxymachines.FoxyMachines;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

public class FoxyRecipeType {
    private static final CustomItemStack QUEST_ITEM = new CustomItemStack(new CustomItemStack(Material.MOJANG_BANNER_PATTERN, "&6Recompensa de Missão", "", "&e&oObtido ao completar a missão com a espada indicada",
            "&e&oUse &c/foxy quest &e&opara ver a missão atual"));
    static {
        ItemMeta meta = QUEST_ITEM.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        QUEST_ITEM.setItemMeta(meta);
    }

    public static RecipeType SACRIFICIAL_ALTAR = new RecipeType(new NamespacedKey(FoxyMachines.getInstance(), "sacrificial_altar"),
            new CustomItemStack(Material.POLISHED_BLACKSTONE_BRICKS, "&cAltar de Sacrifício", "", "&e&oSacrifique criaturas no Altar de Sacrifício",
                    "&e&oUse &c/foxy altar &e&opara ver como construir o Altar de Sacrifício"));
    public static RecipeType FISHING = new RecipeType(new NamespacedKey(FoxyMachines.getInstance(), "fishing"),
            new CustomItemStack(Material.FISHING_ROD, "&bPesca", "", "&e&oObtido ao pescar"));
    public static RecipeType QUEST = new RecipeType(new NamespacedKey(FoxyMachines.getInstance(), "quest"), QUEST_ITEM);
    public static RecipeType CUSTOM_MOB_DROP = new RecipeType(new NamespacedKey(FoxyMachines.getInstance(), "mob_drop"),
            new CustomItemStack(Material.DIAMOND_SWORD, "&aDrop de Criatura", "", "&e&oObtido ao derrotar a criatura indicada"));
}
