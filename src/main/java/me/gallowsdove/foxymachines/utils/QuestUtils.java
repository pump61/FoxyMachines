package me.gallowsdove.foxymachines.utils;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import me.gallowsdove.foxymachines.FoxyMachines;
import me.gallowsdove.foxymachines.Items;
import net.guizhanss.guizhanlib.minecraft.helper.entity.EntityTypeHelper;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;

public class QuestUtils {
    private QuestUtils() {}

    public static final NamespacedKey KEY = new NamespacedKey(FoxyMachines.getInstance(), "quest");

    private static final List<EntityType> QUEST_MOBS = new ArrayList<>();
    private static final List<String> CURSED_LINES = List.of(
            "Eu realmente quero matar um(a) {entity}, deve ser delicioso!",
            "Agora! Eu quero um(a) {entity}!",
            "Você certamente pode me ajudar a matar um(a) {entity}.",
            "Eu tenho sede de sangue.... o sangue de um(a) {entity}.",
            "Eu preciso do fígado de um(a) {entity}!",
            "Ouvi dizer que o sangue de {entity} é uma delícia...",
            "O coração de um(a) {entity}, hmmm...",
            "Eu mataria um deus por carne de {entity}.",
            "Eu poderia comer {entity} o dia inteiro.",
            "Esperei muito por este dia, é hora de matar um(a) {entity}.",
            "O sangue de {entity} vai correr como um rio!",
            "Minha maldição vai devorar", "a alma dele!");
    private static final List<String> CELESTIAL_LINES = List.of(
            "Eu amo todas as formas de vida, exceto {entity}, eu as odeio!",
            "Tudo deve estar em equilíbrio, por isso preciso matar um(a) {entity}.",
            "Eu venho dos céus, mas também sou uma espada. Agora, me dê um(a) {entity}.",
            "Desculpe, mas agora me dê um(a) {entity}. Não questione!",
            "A Espada Celestial precisa de um sacrifício, {entity}!",
            "A próxima vítima é {entity}, como os deuses desejam.",
            "A seguir é... {entity}!",
            "Os deuses querem que {entity} morra.",
            "Pelos deuses e pela glória, vá matar um(a) {entity}.",
            "Vá, pela justiça! Mate um(a) {entity}!",
            "As estrelas se alinham, e vejo que {entity} será morto pela minha lâmina.");


    public static void init() {
        if (!QUEST_MOBS.isEmpty()) {
            FoxyMachines.log(Level.WARNING, "Attempted to initialize QuestUtils after already initialized!");
            return;
        }

        for (String questMob : FoxyMachines.getInstance().getConfig().getStringList("quest-mobs")) {
            try {
                QuestUtils.QUEST_MOBS.add(EntityType.valueOf(questMob));
            } catch (IllegalArgumentException ignored) {
                FoxyMachines.log(Level.WARNING, "\"quest-mobs\" contém um tipo de criatura inválido: " + questMob);
            }
        }
    }

    @ParametersAreNonnullByDefault
    public static boolean hasActiveQuest(Player p) {
        return p.getPersistentDataContainer().has(KEY, PersistentDataType.INTEGER);
    }

    @ParametersAreNonnullByDefault
    public static boolean isQuestEntity(Player p, LivingEntity e) {
        return hasActiveQuest(p) && toEntityType(p, getQuestLine(p)) == e.getType();
    }

    @ParametersAreNonnullByDefault
    public static int getQuestLine(Player p) {
        PersistentDataContainer container = p.getPersistentDataContainer();
        int id;

        if (container.has(KEY, PersistentDataType.INTEGER)) {
            id = container.get(KEY, PersistentDataType.INTEGER);
        } else {
            id = nextQuestLine(p);
        }

        return id;
    }

    @ParametersAreNonnullByDefault
    public static int nextQuestLine(Player p) {
        int id = ThreadLocalRandom.current().nextInt(QUEST_MOBS.size());
        p.getPersistentDataContainer().set(KEY, PersistentDataType.INTEGER, id);
        return id;
    }

    @ParametersAreNonnullByDefault
    public static void sendQuestLine(Player p, SlimefunItemStack item) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        String entity = toString(p, getQuestLine(p));

        if (item == Items.CURSED_SWORD) {
            int i = random.nextInt(CURSED_LINES.size());
            String line = CURSED_LINES.get(i).replace("{entity}", entity);
            p.sendMessage(ChatColor.RED + line);
        } else if (item == Items.CELESTIAL_SWORD) {
            int i = random.nextInt(CELESTIAL_LINES.size());
            String line = CELESTIAL_LINES.get(i).replace("{entity}", entity);
            p.sendMessage(ChatColor.YELLOW + line);
        }
    }

    @ParametersAreNonnullByDefault
    public static void resetQuestLine(Player p) {
        PersistentDataContainer container = p.getPersistentDataContainer();

        if (container.has(KEY, PersistentDataType.INTEGER)) {
            container.remove(KEY);
        }
    }

    public static EntityType toEntityType(Player p, int id) {
        if (id >= QUEST_MOBS.size()) {
            id = nextQuestLine(p);
        }

        return QUEST_MOBS.get(id);
    }

    public static String toString(Player p, int id) {
        if (id >= QUEST_MOBS.size()) {
            id = nextQuestLine(p);
        }

        return EntityTypeHelper.getName(QUEST_MOBS.get(id));
    }
}