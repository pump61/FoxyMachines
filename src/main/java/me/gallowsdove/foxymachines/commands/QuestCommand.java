package me.gallowsdove.foxymachines.commands;

import io.github.mooy1.infinitylib.commands.SubCommand;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.gallowsdove.foxymachines.Items;
import me.gallowsdove.foxymachines.utils.QuestUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.List;

public class QuestCommand extends SubCommand {
    public QuestCommand() {
        super("quest", "Mostra as informações da missão atual", "foxymachines.info");
    }

    @Override
    protected void execute(@Nonnull CommandSender commandSender, @Nonnull String[] args) {
        if (!(commandSender instanceof Player p) ) {
            return;
        }

        if (args.length != 0) {
            commandSender.sendMessage(ChatColor.LIGHT_PURPLE + "Uso: /foxy quest");
            return;
        }

        if (SlimefunUtils.isItemSimilar(p.getInventory().getItemInMainHand(), Items.CURSED_SWORD, false, false)) {
            QuestUtils.sendQuestLine(p, Items.CURSED_SWORD);
        } else if (SlimefunUtils.isItemSimilar(p.getInventory().getItemInMainHand(), Items.CELESTIAL_SWORD, false, false)) {
            QuestUtils.sendQuestLine(p, Items.CELESTIAL_SWORD);
        } else {
            p.sendMessage(ChatColor.LIGHT_PURPLE + "Você precisa estar segurando a " + ChatColor.RED + "Espada Amaldiçoada" +
                    ChatColor.LIGHT_PURPLE + "ou a " + ChatColor.YELLOW + "Espada Celestial" + ChatColor.LIGHT_PURPLE + "para ver a missão");
        }
    }

    @Override
    protected void complete(@Nonnull CommandSender commandSender, @Nonnull String[] strings, @Nonnull List<String> list) { }
}