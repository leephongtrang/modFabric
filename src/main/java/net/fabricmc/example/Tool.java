package net.fabricmc.example;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;

import java.util.Arrays;
import java.util.List;

public class Tool {
    public static boolean enableAttackBlock;
    public static boolean enableAttackEntity;

    public static void setOption() {
        enableAttackBlock = Client.option.get(0).value;
        enableAttackEntity = Client.option.get(1).value;
    }

    public static void onItemDurabilityAttackBlock() {
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) ->
        {
            if (player.getMainHandStack().isDamaged()) {
                if (!enableAttackBlock) {
                    if (player.getMainHandStack().getDamage() >= player.getMainHandStack().getMaxDamage() - 10) {
                        world.playSound(player, player.getBlockPos(), SoundEvents.BLOCK_AMETHYST_BLOCK_HIT, SoundCategory.BLOCKS, 1f, 1f);
                        return ActionResult.FAIL;
                    }
                }
            }
            return ActionResult.PASS;
        });
    }

    public static void onItemDurabilityAttackEntity() {
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) ->
        {
            if (player.getMainHandStack().isDamaged()) {
                if (!enableAttackEntity) {
                    if (player.getMainHandStack().getDamage() >= player.getMainHandStack().getMaxDamage() - 10) {
                        world.playSound(player, player.getBlockPos(), SoundEvents.BLOCK_AMETHYST_BLOCK_HIT, SoundCategory.BLOCKS, 1f, 1f);
                        return ActionResult.FAIL;
                    }
                }
            }
            return ActionResult.PASS;
        });
    }
}
