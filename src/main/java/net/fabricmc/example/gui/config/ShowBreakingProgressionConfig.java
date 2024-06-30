package net.fabricmc.example.gui.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "show_breaking_progression")
public class ShowBreakingProgressionConfig implements ConfigData {
    boolean showMainHandDurability;
    boolean showOffHandDurability;
    boolean showArmorDurability;
}
