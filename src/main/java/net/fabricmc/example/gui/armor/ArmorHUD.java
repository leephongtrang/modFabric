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
        int x = 0;
        int y = 0;
        if (client != null) {
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();

            x = width / 2;
            y = height;
        }

        assert MinecraftClient.getInstance() != null;
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
        Iterable<ItemStack> armor = player.getArmorItems();

        for (ItemStack itemStack : armor) {
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
            drawContext.drawTexture(helmet, x-94, y-295, 0, 0, 16, 16, 16, 16);
            drawContext.drawText(renderer, String.valueOf(helmetDurability), x-74, y-290, calculateDisplayColor(helmetMaxDurability, helmetDurability), true);
        }

        // Render Chestplate
        if (chestplateMaxDurability != 0) {
            drawContext.drawTexture(chestplate, x-94, y-275, 0, 0, 16, 16, 16, 16);
            drawContext.drawText(renderer, String.valueOf(chestplateDurability), x-74, y-270, calculateDisplayColor(chestplateMaxDurability, chestplateDurability), true);
        }

        // Render Legging
        if (leggingMaxDurability != 0) {
            drawContext.drawTexture(legging, x-94, y-255, 0, 0, 16, 16, 16, 16);
            drawContext.drawText(renderer, String.valueOf(leggingDurability), x-74, y-250, calculateDisplayColor(leggingMaxDurability, leggingDurability), true);
        }

        // Render Boots
        if (bootMaxDurability != 0) {
            drawContext.drawTexture(boot, x-94, y-235, 0, 0, 16, 16, 16, 16);
            drawContext.drawText(renderer, String.valueOf(bootDurability), x-74, y-230, calculateDisplayColor(bootMaxDurability, bootDurability), true);
        }

    }
}
