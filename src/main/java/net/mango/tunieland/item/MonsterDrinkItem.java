package net.mango.tunieland.item;

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
    public ItemStack finishUsing(ItemStack stack, World world, net.minecraft.entity.LivingEntity user) {
        if (!world.isClient && user instanceof PlayerEntity player) {
            Item item = stack.getItem();

            if (item == ModItems.MONSTER_DRINK_MANGO) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 30, 1));
            } else if (item == ModItems.MONSTER_DRINK_PUNCH) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 20 * 30, 1));
            } else if (item == ModItems.MONSTER_DRINK_ULTRA) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20 * 30, 1));
            } else if (item == ModItems.MONSTER_DRINK) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 20 * 30, 1));
            }
        }
        return super.finishUsing(stack, world, user);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        Item item = stack.getItem();

        if (item == ModItems.MONSTER_DRINK_MANGO ||
                item == ModItems.MONSTER_DRINK_PUNCH ||
                item == ModItems.MONSTER_DRINK_ULTRA ||
                item == ModItems.MONSTER_DRINK) {
            return UseAction.DRINK;
        }

        return super.getUseAction(stack);
    }
}
