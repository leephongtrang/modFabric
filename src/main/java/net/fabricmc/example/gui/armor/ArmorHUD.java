package net.fabricmc.example.gui.armor;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.item.ItemStack;

import java.awt.*;

public class ArmorHUD implements HudRenderCallback{

    // Function to set color
    public static int calculateDisplayColor(int max, int cur) {

        if (cur >= max*0.5)
            return Color.GREEN.getRGB();
        if (cur < max*0.05)
            return Color.LIGHT_GRAY.getRGB();
        if (cur < max*0.1)
            return Color.RED.getRGB();
        if (cur < max*0.5)
            return Color.YELLOW.getRGB();
        return Color.WHITE.getRGB();
    }

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        MinecraftClient client =  MinecraftClient.getInstance();
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        Identifier boot = null;
        Identifier legging = null;
        Identifier chestplate = null;
        Identifier helmet = null;

        int helmetDurability = 0;
        int chestplateDurability = 0;
        int leggingDurability = 0;
        int bootDurability = 0;

        int helmetMaxDurability = 0;
        int chestplateMaxDurability = 0;
        int leggingMaxDurability = 0;
        int bootMaxDurability = 0;

        int counter = 0;

        assert player != null;
        Iterable<ItemStack> test = player.getArmorItems();

        for (ItemStack itemStack : test) {
            if (counter == 0){
                bootDurability = itemStack.getMaxDamage() - itemStack.getDamage();
                bootMaxDurability = itemStack.getMaxDamage();
                boot = new Identifier("minecraft", "textures/item/" + itemStack.getItem().toString() + ".png");
            } else if (counter == 1) {
                leggingDurability = itemStack.getMaxDamage() - itemStack.getDamage();
                leggingMaxDurability = itemStack.getMaxDamage();
                legging = new Identifier("minecraft", "textures/item/" + itemStack.getItem().toString() + ".png");
            } else if (counter == 2) {
                chestplateDurability = itemStack.getMaxDamage() - itemStack.getDamage();
                chestplateMaxDurability = itemStack.getMaxDamage();
                chestplate = new Identifier("minecraft", "textures/item/" + itemStack.getItem().toString() + ".png");
            } else if (counter == 3) {
                helmetDurability = itemStack.getMaxDamage() - itemStack.getDamage();
                helmetMaxDurability = itemStack.getMaxDamage();
                helmet = new Identifier("minecraft", "textures/item/" + itemStack.getItem().toString() + ".png");
            }
            counter++;
        }

        TextRenderer renderer = client.textRenderer;

        // Render Helmet
        if (helmetMaxDurability != 0) {
            drawContext.drawTexture(helmet, 0, 100, 0, 0, 16, 16, 16, 16);
            drawContext.drawText(renderer, String.valueOf(helmetDurability), 20, 105, calculateDisplayColor(helmetMaxDurability, helmetDurability), true);
        }

        // Render Chestplate
        if (chestplateMaxDurability != 0) {
            drawContext.drawTexture(chestplate, 0, 120, 0, 0, 16, 16, 16, 16);
            drawContext.drawText(renderer, String.valueOf(chestplateDurability), 20, 125, calculateDisplayColor(chestplateMaxDurability, chestplateDurability), true);
        }

        // Render Legging
        if (leggingMaxDurability != 0) {
            drawContext.drawTexture(legging, 0, 140, 0, 0, 16, 16, 16, 16);
            drawContext.drawText(renderer, String.valueOf(leggingDurability), 20, 145, calculateDisplayColor(leggingMaxDurability, leggingDurability), true);
        }


        // Render Boots
        if (bootMaxDurability != 0) {
            drawContext.drawTexture(boot, 0, 160, 0, 0, 16, 16, 16, 16);
            drawContext.drawText(renderer, String.valueOf(bootDurability), 20, 165, calculateDisplayColor(bootMaxDurability, bootDurability), true);
        }

    }
}
