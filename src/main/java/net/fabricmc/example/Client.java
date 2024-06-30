package net.fabricmc.example;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.example.gui.config.PreventBreakingConfig;
import net.fabricmc.example.gui.config.ShowBreakingProgressionConfig;
import net.fabricmc.example.gui.config.ToolOption;
import net.fabricmc.example.gui.config.ConfigFile;
import net.fabricmc.example.gui.armor.ArmorHUD;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

import java.util.List;

public class Client implements ClientModInitializer {
    public static List<Option> option;
    @Override
    public void onInitializeClient() {
//        AutoConfig.register(PreventBreakingConfig.class, GsonConfigSerializer::new);
//        AutoConfig.register(ShowBreakingProgressionConfig.class, GsonConfigSerializer::new);


        ConfigFile.initFile();
        option = ConfigFile.getFileOption();

        Tool.setOption();
        Tool.onItemDurabilityAttackEntity();
        Tool.onItemDurabilityAttackBlock();

        //ToolOption.keyBindControl();
        ToolOption.init();

        //Render the HUD
        HudRenderCallback.EVENT.register(new ArmorHUD());
    }
}
