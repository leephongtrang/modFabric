package net.fabricmc.example.gui;

import net.minecraft.client.option.KeyBinding;

public class ToolOption {
    public static KeyBinding keyBinding;

//    public void test(){
//        ToolOption.keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
//                "key.examplemod.spook", // The translation key of the keybinding's name
//                InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
//                GLFW.GLFW_KEY_Z, // The keycode of the key
//                "category.examplemod.test" // The translation key of the keybinding's category.
//        ));
//
//        ClientTickEvents.END_CLIENT_TICK.register(client -> {
//            while (ToolOption.keyBinding.wasPressed()) {
//                client.player.sendMessage(Text.literal("Key 1 was pressed!"), true);
//            }
//        });
//    }
}
