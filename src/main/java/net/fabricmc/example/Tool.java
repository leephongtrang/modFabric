package net.fabricmc.example;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.util.ActionResult;

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
