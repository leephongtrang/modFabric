package net.fabricmc.example;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.util.ActionResult;

public class Tool {
    boolean enableAttackBlock = false;
    boolean enableAttackEntity = false;



    public static void onItemDurabilityAttackBlock() {
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

    public static void onItemDurabilityAttackEntity() {
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) ->
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
