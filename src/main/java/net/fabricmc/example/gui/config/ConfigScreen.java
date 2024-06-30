package net.fabricmc.example.gui.config;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ConfigScreen {
    static MinecraftClient minecraftClient = MinecraftClient.getInstance();

    public static void OpenScreen() {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(minecraftClient.currentScreen)
                .setTitle(Text.literal("dasd"));

        Screen screen = builder.build();

        minecraftClient.setScreen(screen);

    }
}
