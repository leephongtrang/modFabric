package net.fabricmc.example;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.util.ActionResult;

public class Tool {
    public static void onItemDurability() {
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
