package com.fusionflux.originsumbrellas.mixin;

import com.fusionflux.originsumbrellas.items.UmbrellaItems;
import io.github.apace100.origins.power.factory.condition.PlayerConditions;
import io.github.apace100.origins.util.SerializableData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerConditions.class)
public class PlayerConditionsMixin {

    @Inject(method = "lambda$register$10", at = @At("HEAD"), cancellable = true)
    private static void sunDamagePrevention(SerializableData.Instance data, PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        for (ItemStack stack : player.getItemsHand()) {
            if (stack.getItem().equals(UmbrellaItems.UMBRELLA) && stack.getDamage() < stack.getMaxDamage() - 1) {
                cir.setReturnValue(false);
            }
        }
    }

    @Inject(method = "lambda$register$11", at = @At("HEAD"), cancellable = true)
    private static void umbrellaRainedOn(SerializableData.Instance data, PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        for (ItemStack stack : player.getItemsHand()) {
            if (stack.getItem().equals(UmbrellaItems.UMBRELLA) && stack.getDamage() < stack.getMaxDamage() - 1) {
                cir.setReturnValue(false);
            }
        }
    }


}
