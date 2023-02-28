package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.example.enchantments.EfficiencyVIIEnchantment;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");
	/*private static final Enchantment EFFICIENCY = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier("afonu", "brrrt"),
			new EfficiencyVIIEnchantment(Enchantment.Rarity.COMMON, EquipmentSlot.MAINHAND)
	);*/
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		//net.minecraft.enchantment.EfficiencyEnchantment a = new net.minecraft.enchantment.EfficiencyEnchantment();
		//TODO change effi 5 -> 9

		onItem10Durability();

		LOGGER.info("Hello Fabric world!");
	}

	public void onItem10Durability() {
		AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) ->
		{
			if (player.getMainHandStack().isDamaged()){
				if (player.getMainHandStack().getDamage() >= player.getMainHandStack().getMaxDamage() - 10){
					return ActionResult.FAIL;
				}
			}
			return ActionResult.PASS;
		});
	}
}
