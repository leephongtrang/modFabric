package net.fabricmc.example.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(net.minecraft.client.gui.screen.ingame.AnvilScreen.class)
public class AnvilXpLimitBreakGUIMixin {
    @ModifyConstant(method = "drawForeground", constant = @Constant(intValue = 40, ordinal = 0))
    private int modifyInt(int input) {
        return Integer.MAX_VALUE;
    }
}
