package net.fabricmc.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.example.gui.ToolOption;
import net.fabricmc.example.gui.ToolOptionFile;

import java.util.List;

public class Client implements ClientModInitializer {
    public static List<Option> option;
    @Override
    public void onInitializeClient() {
        ToolOptionFile.initFile();
        option = ToolOptionFile.getFileOption();

        Tool.setOption();
        Tool.onItemDurabilityAttackEntity();
        Tool.onItemDurabilityAttackBlock();

        ToolOption.keyBindControl();
        ToolOption.init();
    }
}
