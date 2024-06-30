package net.fabricmc.example.gui.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import net.minecraft.item.ItemStack;

import java.util.List;

@Config(name = "prevent_breaking")
public class PreventBreakingConfig implements ConfigData {
    boolean enableAttackBlock;
    boolean enableAttackEntity;

    List<ItemStack> itemsBlackList;
}
