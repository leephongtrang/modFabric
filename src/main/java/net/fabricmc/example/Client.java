package net.fabricmc.example;

import net.fabricmc.api.ClientModInitializer;

public class Client implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Tool.onItemDurability();
    }
}
