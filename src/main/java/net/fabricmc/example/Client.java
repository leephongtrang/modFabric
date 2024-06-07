package net.fabricmc.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.example.gui.ToolOption;
import net.fabricmc.example.gui.ToolOptionFile;
import net.fabricmc.example.gui.armor.ArmorHUD;

import java.util.List;

public class Client implements ClientModInitializer {
    public static List<Option> option;
    @Override
    public void onInitializeClient() {
        ToolOptionFile.initFile();
        option = ToolOptionFile.getFileOption();

        //ArmorHUD

        Tool.setOption();
        Tool.onItemDurabilityAttackEntity();
        Tool.onItemDurabilityAttackBlock();

        //ToolOption.keyBindControl();
        ToolOption.init();
    }
}
