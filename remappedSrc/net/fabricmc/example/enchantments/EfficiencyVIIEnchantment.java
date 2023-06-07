package net.fabricmc.example.enchantments;

import net.minecraft.enchantment.EfficiencyEnchantment;
import net.minecraft.entity.EquipmentSlot;

public class EfficiencyVIIEnchantment extends EfficiencyEnchantment {
    public EfficiencyVIIEnchantment(Rarity weight, EquipmentSlot... slotTypes) {
        super(weight, slotTypes);
    }

    @Override
    public int getMaxLevel() {
        return 9;
    }


}
