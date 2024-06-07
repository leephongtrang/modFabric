package net.fabricmc.example.gui;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.StickyKeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.apache.commons.lang3.NotImplementedException;
import org.lwjgl.glfw.GLFW;

public class ToolOption {
    static MinecraftClient minecraftClient = MinecraftClient.getInstance();
    //static ToolOptionScreen menu = new ToolOptionScreen(new ToolOptionGUI());

    public static void init() {
        keyBindOpenOptionMenu();
    }

    public static void openMenu() {
        throw new NotImplementedException();
        //minecraftClient.setScreen(menu);
    }

    public static void closeMenu() {
        minecraftClient.currentScreen.close();
    }

    public static void keyBindOpenOptionMenu() {
        KeyBinding binding = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.fabric-key-binding-api-v1-testmod.test_keybinding_1", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_Z, "key.category.first.test"));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (binding.wasPressed()) {
//                if (client.player != null) {
//                    client.player.sendMessage(Text.literal("Key 1 was pressed!"), false);
//                }
                openMenu();
            }
        });
    }

    public static void keyBindControl() {
        KeyBinding binding2 = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.fabric-key-binding-api-v1-testmod.test_keybinding_2", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_X, "key.category.second.test"));
        KeyBinding stickyBinding = KeyBindingHelper.registerKeyBinding(new StickyKeyBinding("key.fabric-key-binding-api-v1-testmod.test_keybinding_sticky", GLFW.GLFW_KEY_R, "key.category.first.test", () -> true));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (binding2.wasPressed()) {
                client.player.sendMessage(Text.literal("Key 2 was pressed!"), false);
            }

            if (stickyBinding.isPressed()) {
                client.player.sendMessage(Text.literal("Sticky Key was pressed!"), false);
            }
        });
    }
}
