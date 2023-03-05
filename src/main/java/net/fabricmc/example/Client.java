package net.fabricmc.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.example.gui.ToolOption;
import net.fabricmc.example.gui.ToolOptionFile;

public class Client implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ToolOptionFile.initFile();

        Tool.onItemDurabilityAttackEntity();
        Tool.onItemDurabilityAttackBlock();

        ToolOption.keyBindControl();
        ToolOption.init();
    }
}
