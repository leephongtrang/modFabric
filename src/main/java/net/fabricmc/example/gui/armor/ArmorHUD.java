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

        assert player != null;
        Iterable<ItemStack> armor = player.getArmorItems();
        TextRenderer renderer = client.textRenderer;

        int relativePosition = -35;

        for (ItemStack itemStack : armor) {
            if (itemStack.getMaxDamage() != 0) {
                drawContext.drawTexture(new Identifier("minecraft", "textures/item/" + itemStack.getItem().toString() + ".png"), x-94, y-(y/2)-relativePosition-10, 0, 0, 16, 16, 16, 16);
                drawContext.drawText(renderer, String.valueOf(itemStack.getMaxDamage() - itemStack.getDamage()), x-74, y-(y/2)-relativePosition-6, calculateDisplayColor(itemStack.getMaxDamage(), itemStack.getMaxDamage() - itemStack.getDamage()), true);
                relativePosition += 20;
            }
        }
    }
}
