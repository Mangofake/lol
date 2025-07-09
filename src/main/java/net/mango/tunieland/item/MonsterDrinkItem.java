package net.mango.tunieland.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class MonsterDrinkItem extends Item {

    public MonsterDrinkItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof PlayerEntity player && !world.isClient) {
            Item item = stack.getItem();

            if (item == ModItems.MONSTER_DRINK_MANGO) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 30, 1));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 20 * 30, 1));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20 * 30, 0));
            } else if (item == ModItems.MONSTER_DRINK_PUNCH) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 20 * 30, 1));
            } else if (item == ModItems.MONSTER_DRINK_ULTRA) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20 * 30, 1));
            } else if (item == ModItems.MONSTER_DRINK) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 20 * 30, 1));
            }

            if (!player.getAbilities().creativeMode) {
                stack.decrement(1); // ✅ actually consume the item
            }
        }

        return super.finishUsing(stack, world, user); // important to return super
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand); // ✅ triggers drinking animation
        return TypedActionResult.consume(user.getStackInHand(hand));
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 32; // standard time for drinking
    }
}
