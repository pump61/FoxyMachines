package me.gallowsdove.foxymachines;

import io.github.mooy1.infinitylib.machines.MachineLore;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import io.github.thebusybiscuit.slimefun4.utils.itemstack.ColoredFireworkStar;
import me.gallowsdove.foxymachines.implementation.machines.ElectricGoldRefinery;
import me.gallowsdove.foxymachines.implementation.machines.ForcefieldDome;
import me.gallowsdove.foxymachines.implementation.machines.ImprovementForge;
import me.gallowsdove.foxymachines.implementation.machines.PotionMixer;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

public final class Items{

    // Grupos de itens
    public static final NestedItemGroup MAIN_ITEM_GROUP = new NestedItemGroup(
            new NamespacedKey(FoxyMachines.getInstance(), "foxy_machines"),
            new CustomItemStack(Material.SHEARS, "&4Tecnologia Arcana")
    );

    public static final SubItemGroup MATERIALS_ITEM_GROUP = new SubItemGroup(
            new NamespacedKey(FoxyMachines.getInstance(), "materials"),
            MAIN_ITEM_GROUP,
            new CustomItemStack(Material.GOLD_INGOT, "&bMateriais")
    );

    public static final SubItemGroup MACHINES_ITEM_GROUP = new SubItemGroup(
            new NamespacedKey(FoxyMachines.getInstance(), "machines"),
            MAIN_ITEM_GROUP,
            new CustomItemStack(Material.BEACON, "&aMáquinas")
    );

    public static final SubItemGroup TOOLS_ITEM_GROUP = new SubItemGroup(
            new NamespacedKey(FoxyMachines.getInstance(), "tools"),
            MAIN_ITEM_GROUP,
            new CustomItemStack(Material.BLAZE_ROD, "&eFerramentas")
    );

    public static final SubItemGroup WEAPONS_AND_ARMORS_ITEM_GROUP = new SubItemGroup(
            new NamespacedKey(FoxyMachines.getInstance(), "weapons_and_armors"),
            MAIN_ITEM_GROUP,
            new CustomItemStack(Material.NETHERITE_SWORD, "&aArmas e Armaduras")
    );

    public static final SubItemGroup ALTAR_ITEM_GROUP = new SubItemGroup(
        new NamespacedKey(FoxyMachines.getInstance(), "sacrificial_altars"),
        MAIN_ITEM_GROUP,
        new CustomItemStack(Material.POLISHED_BLACKSTONE_BRICKS, "&4Altar de Sacrifício")
    );

    public static final SubItemGroup BOSSES_ITEM_GROUP = new SubItemGroup(
        new NamespacedKey(FoxyMachines.getInstance(), "bosses"),
        MAIN_ITEM_GROUP,
        new CustomItemStack(Material.DRAGON_HEAD, "&cChefes")
    );

    public static final SubItemGroup GHOST_BLOCKS_ITEM_GROUP = new SubItemGroup(
            new NamespacedKey(FoxyMachines.getInstance(), "ghost_blocks"),
            MAIN_ITEM_GROUP,
            new CustomItemStack(Material.GLASS, "&5Blocos Fantasmas")
    );

    // Itens
    public static final SlimefunItemStack ELECTRIC_WIND_STAFF = new SlimefunItemStack(
            "ELECTRIC_WIND_STAFF",
            Material.BLAZE_ROD,
            "&6Cajado Elemental Elétrico &7- &b&lVento",
            "",
            "&7Voe com o vento",
            "",
            "&c&o&8⇨ &e⚡ &70 / 100 J"
    );

    static {
        ELECTRIC_WIND_STAFF.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        ItemMeta meta = ELECTRIC_WIND_STAFF.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ELECTRIC_WIND_STAFF.setItemMeta(meta);
    }

    public static final SlimefunItemStack ELECTRIC_FIRE_STAFF = new SlimefunItemStack(
            "ELECTRIC_FIRE_STAFF",
            Material.BLAZE_ROD,
            "&6Cajado Elemental Elétrico &7- &4&lFogo",
            "",
            "&cDeixe o fogo purificar tudo!",
            "",
            "&c&o&8⇨ &e⚡ &70 / 100 J"
    );
    static {
        ELECTRIC_FIRE_STAFF.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        ItemMeta meta = ELECTRIC_FIRE_STAFF.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ELECTRIC_FIRE_STAFF.setItemMeta(meta);
    }

    public static final SlimefunItemStack ELECTRIC_FIRE_STAFF_II = new SlimefunItemStack(
            "ELECTRIC_FIRE_STAFF_II",
            Material.BLAZE_ROD,
            "&6Cajado Elemental Elétrico &7- &4&lFogo &7- &eII",
            "",
            "&7Fogo, fogo, mais fogo!",
            "",
            "&c&o&8⇨ &e⚡ &70 / 200 J"
    );
    static {
        ELECTRIC_FIRE_STAFF_II.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        ItemMeta meta = ELECTRIC_FIRE_STAFF_II.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ELECTRIC_FIRE_STAFF_II.setItemMeta(meta);
    }

    public static final SlimefunItemStack HEALING_BOW = new SlimefunItemStack(
            "HEALING_BOW",
            Material.BOW,
            "&4Arco da Cura",
            "&cCura II",
            "",
            "&8Finalmente uma arma de suporte.",
            "",
            "&f𳭚"
    );

    public static final SlimefunItemStack REINFORCED_STRING = new SlimefunItemStack(
            "REINFORCED_STRING",
            Material.STRING,
            "&bLinha Reforçada",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack IMPROVEMENT_FORGE = new SlimefunItemStack(
            "IMPROVEMENT_FORGE",
            Material.SMITHING_TABLE,
            "&bForja de Aprimoramento",
            "",
            "&7Usada para aprimorar ferramentas, armas",
            "&7e armaduras do Slimefun",
            "&7Requer um &aNúcleo de Aprimoramento",
            "",
            "&7Ferramentas: Madeira > Pedra > Ferro > Ouro > Diamante > Netherite",
            "&7Armaduras: Couro > Cota de Malha > Ferro > Ouro > Diamante > Netherite",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.powerPerSecond(ImprovementForge.ENERGY_CONSUMPTION)
    );

    public static final SlimefunItemStack IMPROVEMENT_CORE = new SlimefunItemStack(
            "IMPROVEMENT_CORE",
            "faff2eb498e5c6a04484f0c9f785b448479ab213df95ec91176a308a12add70",
            "&aNúcleo de Aprimoramento",
            "",
            "&7Usado na &bForja de Aprimoramento",
            "&7junto com equipamentos do Slimefun",
            "&7para aumentar a qualidade do equipamento",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack POTION_MIXER = new SlimefunItemStack(
            "POTION_MIXER",
            Material.BREWING_STAND,
            "&bMisturador de Poções",
            "",
            "&7Usado para misturar poções",
            "",
            LoreBuilder.machine(MachineTier.GOOD, MachineType.MACHINE),
            LoreBuilder.powerPerSecond(PotionMixer.ENERGY_CONSUMPTION)
    );

    public static final SlimefunItemStack ELECTRIC_GOLD_REFINERY = new SlimefunItemStack(
            "ELECTRIC_GOLD_REFINERY",
            Material.GOLD_BLOCK	,
            "&bRefinaria Elétrica de Ouro",
            "",
            "&7Refina pó de ouro em lingotes de quilate específico",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.powerPerSecond(ElectricGoldRefinery.ENERGY_CONSUMPTION)
    );

    public static final SlimefunItemStack CHUNK_LOADER = new SlimefunItemStack(
            "CHUNK_LOADER",
            Material.BEACON,
            "&bCarregador de Chunk",
            "",
            "&7Mantém o chunk onde está sempre carregado",
            "",
            "&7Cada carregador de chunk requer:",
            "&77500 de complexidade de rede GPS"
    );

    public static final SlimefunItemStack STABILIZED_BLISTERING_BLOCK = new SlimefunItemStack(
            "STABILIZED_BLISTERING_BLOCK",
            Material.SNOW_BLOCK,
            "&bBloco de Bolhas Estabilizado",
            "",
            "&7Um material estável",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack BOOSTED_RAIL = new SlimefunItemStack(
            "BOOSTED_RAIL",
            Material.RAIL,
            "&fTrilho Acelerado",
            "",
            "&7Suporta velocidade 2,5x maior",
            "",
            "&f𳭚"
    );

    public static final SlimefunItemStack BOOSTED_ACTIVATOR_RAIL = new SlimefunItemStack(
            "BOOSTED_ACTIVATOR_RAIL",
            Material.ACTIVATOR_RAIL,
            "&fTrilho Ativador Acelerado",
            "",
            "&7Suporta velocidade 2,5x maior",
            "",
            "&f𳭚"
    );

    public static final SlimefunItemStack BOOSTED_DETECTOR_RAIL = new SlimefunItemStack(
            "BOOSTED_DETECTOR_RAIL",
            Material.DETECTOR_RAIL,
            "&fTrilho Detector Acelerado",
            "",
            "&7Suporta velocidade 2,5x maior",
            "",
            "&f𳭚"
    );

    public static final SlimefunItemStack BOOSTED_POWERED_RAIL = new SlimefunItemStack(
            "BOOSTED_POWERED_RAIL",
            Material.POWERED_RAIL,
            "&fTrilho Propulsor Acelerado",
            "",
            "&7Suporta velocidade 2,5x maior",
            "",
            "&f𳭚"
    );

    public static final SlimefunItemStack BERRY_BUSH_TRIMMER = new SlimefunItemStack(
            "BERRY_BUSH_TRIMMER",
            Material.SHEARS,
            "&eTesoura de Arbustos de Frutinhas",
            "",
            "&7Remove os espinhos do arbusto de frutinhas",
            "",
            "&f𳭚"
    );

    public static final SlimefunItemStack FORCEFIELD_DOME = new SlimefunItemStack(
            "FORCEFIELD_DOME",
            Material.OBSERVER,
            "&4Cúpula de Campo de Força",
            "",
            "&7Ao ser energizada, gera uma barreira",
            "&7protetora em um raio de 32 blocos ao redor.",
            "&7A barreira desaparece se faltar energia",
            "&7ou se o bloco for destruído",
            "",
            MachineLore.energyPerSecond(ForcefieldDome.ENERGY_CONSUMPTION)
    );

    public static final SlimefunItemStack REMOTE_CONTROLLER = new SlimefunItemStack(
            "REMOTE_CONTROLLER",
            Material.NAME_TAG,
            "&cControle Remoto",
            "",
            "&7Permite controlar a Cúpula de Campo",
            "&7de Força remotamente",
            "&eShift + Clique direito &7para vincular a Cúpula de Campo de Força",
            "",
            "&c&o&8⇨ &e⚡ &70 / 1000 J",
            "",
            "&f𳭚"
    );

    public static final SlimefunItemStack FORCEFIELD_ENGINE = new SlimefunItemStack(
            "FORCEFIELD_ENGINE",
            Material.STRUCTURE_BLOCK,
            "&fMotor de Campo de Força",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack FORCEFIELD_STABILIZER = new SlimefunItemStack(
            "FORCEFIELD_STABILIZER",
            Material.STRUCTURE_VOID,
            "&fEstabilizador de Campo de Força",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack WIRELESS_TRANSMITTER = new SlimefunItemStack(
            "WIRELESS_TRANSMITTER",
            Material.REPEATER,
            "&fTransmissor Sem Fio",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack DEMONIC_INGOT = new SlimefunItemStack(
            "DEMONIC_INGOT",
            Material.GOLD_INGOT,
            "&cLingote Demoníaco",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack DEMONIC_PLATE = new SlimefunItemStack(
            "DEMONIC_PLATE",
            Material.LIGHT_WEIGHTED_PRESSURE_PLATE,
            "&cPlaca Demoníaca",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack AQUATIC_NETHERITE_INGOT = new SlimefunItemStack(
            "AQUATIC_NETHERITE_INGOT",
            Material.NETHERITE_INGOT,
            "&bLingote de Netherite Aquático",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack DAMIENIUM = new SlimefunItemStack(
            "DAMIENIUM",
            Material.GOLD_INGOT,
            "&aLingote de Damiênio",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack SWEET_INGOT = new SlimefunItemStack(
            "SWEET_INGOT",
            Material.GOLD_INGOT,
            "&eLingote Doce",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack SWEETENED_SWEET_INGOT = new SlimefunItemStack(
            "SWEETENED_SWEET_INGOT",
            Material.GOLD_INGOT,
            "&eLingote Doce Açucarado",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack SACRIFICIAL_ALTAR_BLACKSTONE_BRICKS = new SlimefunItemStack(
            "SACRIFICIAL_ALTAR_BLACKSTONE_BRICKS",
            Material.POLISHED_BLACKSTONE_BRICKS,
            "&fTijolos de Blackstone Sacrificial",
            "",
            "&7Usado para construir o Altar de Sacrifício",
            "",
            "&7Use &9/foxy altar &7para ver o tutorial em vídeo de construção"
    );

    public static final SlimefunItemStack SACRIFICIAL_ALTAR_BLACKSTONE_BRICK_WALL = new SlimefunItemStack(
            "SACRIFICIAL_ALTAR_BLACKSTONE_BRICK_WALL",
            Material.POLISHED_BLACKSTONE_BRICK_WALL,
            "&fMuro de Tijolos de Blackstone Sacrificial",
            "",
            "&7Usado para construir o Altar de Sacrifício",
            "",
            "&7Use &9/foxy altar &7para ver o tutorial em vídeo de construção"
    );

    public static final SlimefunItemStack SACRIFICIAL_ALTAR_BLACKSTONE_BRICK_STAIRS = new SlimefunItemStack(
            "SACRIFICIAL_ALTAR_BLACKSTONE_BRICK_STAIRS",
            Material.POLISHED_BLACKSTONE_BRICK_STAIRS,
            "&fEscada de Tijolos de Blackstone Sacrificial",
            "",
            "&7Usado para construir o Altar de Sacrifício",
            "",
            "&7Use &9/foxy altar &7para ver o tutorial em vídeo de construção"
    );

    public static final SlimefunItemStack SACRIFICIAL_ALTAR_SOUL_TORCH = new SlimefunItemStack(
            "SACRIFICIAL_ALTAR_SOUL_TORCH",
            Material.SOUL_TORCH,
            "&fTocha de Alma Sacrificial",
            "",
            "&7Usado para construir o Altar de Sacrifício",
            "",
            "&7Use &9/foxy altar &7para ver o tutorial em vídeo de construção"
    );

    public static final SlimefunItemStack SACRIFICIAL_ALTAR_BLACKSTONE_PRESSURE_PLATE = new SlimefunItemStack(
            "SACRIFICIAL_ALTAR_BLACKSTONE_PRESSURE_PLATE",
            Material.POLISHED_BLACKSTONE_PRESSURE_PLATE,
            "&fPlaca de Sacrifício",
            "",
            "&7Usado para construir o Altar de Sacrifício",
            "&7Após concluir a estrutura, clique direito para ativar",
            "",
            "&7Use &9/foxy altar &7para ver o tutorial em vídeo de construção",
            "",
            "&f𳭚"
    );

    public static final SlimefunItemStack CURSED_RABBIT_PAW = new SlimefunItemStack(
            "CURSED_RABBIT_PAW",
            Material.RABBIT_FOOT,
            "&cPata de Coelho Amaldiçoada",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack HUMAN_SKULL = new SlimefunItemStack(
            "HUMAN_SKULL",
            Material.SKELETON_SKULL,
            "&cCrânio Humano",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack BLOOD_INFUSED_SKULL = new SlimefunItemStack(
            "BLOOD_INFUSED_SKULL",
            "daa4e2294df370b9a50cb924cdda78f740b0fbaf5a687106178505c80a79addc",
            "&cCrânio Infundido com Sangue",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack BLOOD = new SlimefunItemStack(
            "BLOOD",
            Material.REDSTONE,
            "&cSangue",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack UNHOLY_WITHER_SKELETON_BONE = new SlimefunItemStack(
            "UNHOLY_WITHER_SKELETON_BONE",
            Material.BONE,
            "&cOsso Profano de Esqueleto Wither",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack PURIFIED_BONE = new SlimefunItemStack(
            "PURIFIED_BONE",
            Material.BONE,
            "&bOsso Purificado",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack PURE_BONE_DUST = new SlimefunItemStack(
            "PURE_BONE_DUST",
            Material.BONE_MEAL,
            "&bPó de Osso Puro",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack BUCKET_OF_BLOOD = new SlimefunItemStack(
            "BUCKET_OF_BLOOD",
            Material.LAVA_BUCKET,
            "&cBalde de Sangue",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack POSEIDONS_FISHING_ROD = new SlimefunItemStack(
            "POSEIDONS_FISHING_ROD",
            Material.FISHING_ROD,
            "&bVara de Pesca de Poseidon",
            "&7Bênção de Poseidon",
            "",
            "&7Permite obter itens especiais",
            "",
            "&f𳭚"
    );
    static {
        POSEIDONS_FISHING_ROD.addUnsafeEnchantment(Enchantment.LUCK, 5);
        POSEIDONS_FISHING_ROD.addUnsafeEnchantment(Enchantment.LURE, 3);
    }

    public static final SlimefunItemStack POSEIDONS_BLESSING = new SlimefunItemStack(
            "POSEIDONS_BLESSING",
            Material.HEART_OF_THE_SEA,
            "&bBênção de Poseidon",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack CURSED_SWORD = new SlimefunItemStack(
            "CURSED_SWORD",
            Material.NETHERITE_SWORD,
            "&cEspada Amaldiçoada",
            "&7Roubo de Vida I",
            "&7Penetração de Armadura I",
            "",
            "&7Confunde inimigos e aumenta o dano.",
            "&7Pode causar efeitos negativos em quem a utiliza.",
            "",
            "&f𳭋"
    );

    public static final SlimefunItemStack CELESTIAL_SWORD = new SlimefunItemStack(
            "CELESTIAL_SWORD",
            Material.NETHERITE_SWORD,
            "&eEspada Celestial",
            "&7Golpe Divino II",
            "&7Penetração de Armadura V",
            "",
            "&f𳭋"
    );

    public static final SlimefunItemStack ELUCIDATOR = new SlimefunItemStack(
            "ELUCIDATOR",
            Material.NETHERITE_SWORD,
            "&bElucidator",
            "&7Dano III",
            "&7Roubo de Vida II",
            "&7Penetração de Armadura II",
            "&7Cura Excedente",
            "",
            "&f𳭊"
    );
    static {
        ELUCIDATOR.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
        ELUCIDATOR.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 5);
    }

    public static final SlimefunItemStack MAGIC_LUMP_4 = new SlimefunItemStack(
            "MAGIC_LUMP_4",
            Material.GOLD_NUGGET,
            "&6Fragmento Mágico &7- &eIV",
            "",
            "&c&oNível: IV");

    public static final SlimefunItemStack MAGIC_LUMP_5 = new SlimefunItemStack(
            "MAGIC_LUMP_5",
            Material.GOLD_NUGGET,
            "&6Fragmento Mágico &7- &eV",
            "",
            "&c&oNível: V");

    public static final SlimefunItemStack AQUATIC_HELMET = new SlimefunItemStack(
            "AQUATIC_HELMET",
            Material.NETHERITE_HELMET,
            "&bElmo Aquático",
            "&7Visão Noturna",
            "",
            "&f𳭉"
    );
    static {
        AQUATIC_HELMET.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        AQUATIC_HELMET.addUnsafeEnchantment(Enchantment.WATER_WORKER, 1);
        AQUATIC_HELMET.addUnsafeEnchantment(Enchantment.OXYGEN, 5);
        AQUATIC_HELMET.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, 5);
    }

    public static final SlimefunItemStack RESISTANT_CHESTPLATE = new SlimefunItemStack(
            "RESISTANT_CHESTPLATE",
            Material.NETHERITE_CHESTPLATE,
            "&aPeitoral Resistente",
            "&7Resistência I",
            "&7Regeneração I",
            "",
            "&f𳭉"
    );
    static {
        RESISTANT_CHESTPLATE.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
    }

    public static final SlimefunItemStack FIERY_LEGGINGS = new SlimefunItemStack(
            "FIERY_LEGGINGS",
            Material.NETHERITE_LEGGINGS,
            "&cCalças Flamejantes",
            "&7Resistência ao Fogo I",
            "&7Aura de Fogo II",
            "",
            "&f𳭉"
    );
    static {
        FIERY_LEGGINGS.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        FIERY_LEGGINGS.addUnsafeEnchantment(Enchantment.THORNS, 6);
    }

    public static final SlimefunItemStack LIGHT_BOOTS = new SlimefunItemStack(
            "LIGHT_BOOTS",
            Material.NETHERITE_BOOTS,
            "&eBotas Leves",
            "&7Salto Elevado II",
            "&7Velocidade II",
            "",
            "&f𳭉"
    );
    static {
        LIGHT_BOOTS.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        LIGHT_BOOTS.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 5);
        LIGHT_BOOTS.addUnsafeEnchantment(Enchantment.SOUL_SPEED, 5);
    }

    public static final SlimefunItemStack AQUATIC_HELMET_FRAME = new SlimefunItemStack(
            "HELMET_FRAME",
            Material.CHAINMAIL_HELMET,
            "&fArmação do Elmo Aquático",
            "",
            "&7Material de fabricação",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack RESISTANT_CHESTPLATE_FRAME = new SlimefunItemStack(
            "RESISTANT_CHESTPLATE_FRAME",
            Material.CHAINMAIL_CHESTPLATE,
            "&fArmação do Peitoral Resistente",
            "",
            "&7Material de fabricação",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack FIERY_LEGGINGS_FRAME = new SlimefunItemStack(
            "FIERY_LEGGINGS_FRAME",
            Material.CHAINMAIL_LEGGINGS,
            "&fArmação das Calças Flamejantes",
            "",
            "&7Material de fabricação",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack LIGHT_BOOTS_FRAME = new SlimefunItemStack(
            "LIGHT_BOOTS_FRAME",
            Material.CHAINMAIL_BOOTS,
            "&fArmação das Botas Leves",
            "",
            "&7Material de fabricação",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack CURSED_SHARD = new SlimefunItemStack(
            "CURSED_SHARD",
            Material.NETHERITE_SCRAP,
            "&cFragmento Amaldiçoado",
            "",
            "&7Material de fabricação",
            "&7Jogue este item no Altar de Sacrifício para reiniciar a missão...",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack CELESTIAL_SHARD = new SlimefunItemStack(
            "CELESTIAL_SHARD",
            Material.PRISMARINE_SHARD,
            "&eFragmento Celestial",
            "",
            "&7Material de fabricação",
            "&7Jogue este item no Altar de Sacrifício para reiniciar a missão...",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack EQUANIMOUS_GEM = new SlimefunItemStack(
            "EQUANIMOUS_GEM",
            Material.EMERALD,
            "&aGema da Equanimidade",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack POLAR_FOX_HIDE = new SlimefunItemStack(
            "POLAR_FOX_HIDE",
            Material.SNOWBALL,
            "&fPele de Raposa Polar",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack MAGMA_ESSENCE = new SlimefunItemStack(
            "MAGMA_ESSENCE",
            Material.MAGMA_CREAM,
            "&cEssência de Magma",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack TROPICAL_FISH_SCALE = new SlimefunItemStack(
            "TROPICAL_FISH_SCALE",
            Material.TROPICAL_FISH_SPAWN_EGG,
            "&bEscama de Peixe Tropical",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack PARROT_FEATHER = new SlimefunItemStack(
            "PARROT_FEATHER",
            Material.FEATHER,
            "&aPena de Papagaio",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack UNBREAKABLE_RUNE = new SlimefunItemStack(
            "UNBREAKABLE_RUNE",
            new ColoredFireworkStar(
                    Color.fromRGB(0, 188, 0),
                    "&7Runa Ancestral &8&l[&2&lInquebrável&8&l]",
                    "",
                    "&eJogue no chão o item que deseja vincular",
                    "&ee então jogue esta runa em direção ao item",
                    "&epara torná-lo &2inquebrável"
            ));

    public static final SlimefunItemStack PIXIE_QUEEN_SPAWN_EGG = new SlimefunItemStack(
            "PIXIE_QUEEN_SPAWN_EGG",
            Material.CREEPER_SPAWN_EGG,
            "&aOvo de Geração da &fRainha Fada",
            "",
            "&f𳭚"
    );

    public static final SlimefunItemStack HEADLESS_HORSEMAN_SPAWN_EGG = new SlimefunItemStack(
            "HEADLESS_HORSEMAN_SPAWN_EGG",
            Material.SPIDER_SPAWN_EGG,
            "&cOvo de Geração do &fCavaleiro sem Cabeça",
            "",
            "&f𳭚"
    );

    public static final SlimefunItemStack PIXIE_QUEEN_HEART = new SlimefunItemStack(
            "PIXIE_QUEEN_HEART",
            Material.FERMENTED_SPIDER_EYE,
            "&4Coração da Rainha Fada",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack PIXIE_DUST = new SlimefunItemStack(
            "PIXIE_DUST",
            Material.SUGAR,
            "&ePó de Fada",
            "",
            "&7Força IV",
            "",
            "&f𳭚"
    );

    public static final SlimefunItemStack VILE_PUMPKIN = new SlimefunItemStack(
            "VILE_PUMPKIN",
            Material.CARVED_PUMPKIN,
            "&cAbóbora Vil",
            "",
            "&f𳭙"
    );

    public static final SlimefunItemStack VILE_SEEDS = new SlimefunItemStack(
            "VILE_SEEDS",
            Material.MELON_SEEDS,
            "&cSementes Vis",
            "",
            "&7Aumento de Vida V",
            "",
            "&f𳭚"
    );

    public static final SlimefunItemStack ACRI_ARCUM = new SlimefunItemStack(
            "ACRI_ARCUM",
            Material.BOW,
            "&eArco Afiado",
            "&7Penetração de Armadura II",
            "",
            "&f𳭉"
    );
    static {
        ACRI_ARCUM.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 7);
        ACRI_ARCUM.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
    }

    public static final SlimefunItemStack GHOST_BLOCK_REMOVER = new SlimefunItemStack(
            "GHOST_BLOCK_REMOVER",
            Material.CLOCK,
            "&eRemovedor de Blocos Fantasmas",
            "",
            "&eClique direito &7para remover um bloco fantasma",
            "",
            "&f𳭚"
    );

    public static final SlimefunItemStack POSITION_SELECTOR = new SlimefunItemStack(
            "POSITION_SELECTOR",
            Material.STICK,
            "&eSeletor de Posição",
            "",
            "&eClique esquerdo &7em um bloco para selecionar a primeira posição",
            "&eClique direito &7em um bloco para selecionar a segunda posição",
            "&8Funciona de forma parecida com uma ferramenta de seleção de área",
            "",
            "&c&o&8⇨ &e⚡ &70 / 200 J",
            "",
            "&f𳭚"
    );

    public static final SlimefunItemStack FILL_WAND = new SlimefunItemStack(
            "FILL_WAND",
            Material.BLAZE_ROD,
            "&eVarinha de Preenchimento",
            "",
            "&7Use o &eSeletor de Posição &7para definir os dois cantos",
            "&eShift+Clique direito &7em um bloco para selecioná-lo como material",
            "&eClique direito &7para preencher a área",
            "",
            "&7Material: &eNenhum",
            "&c&o&8⇨ &e⚡ &70 / 1000 J",
            "",
            "&f𳭚"
    );

    public static final SlimefunItemStack SPONGE_WAND = new SlimefunItemStack(
            "SPONGE_WAND",
            Material.BLAZE_ROD,
            "&eVarinha de Esponja",
            "",
            "&7Use o &eSeletor de Posição &7para definir os dois cantos",
            "&eClique direito &7para remover água e lava",
            "",
            "&c&o&8⇨ &e⚡ &70 / 2000 J",
            "",
            "&f𳭚"
    );

    public static final SlimefunItemStack NUCLEAR_SALT = new SlimefunItemStack(
            "NUCLEAR_SALT",
            Material.LIME_DYE,
            "&aSal Nuclear",
            "",
            LoreBuilder.radioactive(Radioactivity.VERY_HIGH),
            LoreBuilder.HAZMAT_SUIT_REQUIRED,
            "",
            "&f𳭉"
    );

    public static final SlimefunItemStack COMPRESSED_SPONGE = new SlimefunItemStack(
            "COMPRESSED_SPONGE",
            Material.WET_SPONGE,
            "&fEsponja Comprimida",
            "",
            "&f𳭙"
    );
}
