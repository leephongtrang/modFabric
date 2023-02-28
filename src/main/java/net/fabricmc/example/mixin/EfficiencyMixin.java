package net.fabricmc.example.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(net.minecraft.enchantment.EfficiencyEnchantment.class)
public class EfficiencyMixin {
	@Overwrite
	public int getMaxLevel() {
		return 9;
	}
}
