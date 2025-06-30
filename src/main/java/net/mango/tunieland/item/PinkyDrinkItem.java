package net.mango.tunieland.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class PinkyDrinkItem extends Item {
    public PinkyDrinkItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack result = super.finishUsing(stack, world, user); // ✅ ensure drink sound & effects

        if (user instanceof PlayerEntity player) {
            if (!player.getAbilities().creativeMode) {
                stack.decrement(1);
                ItemStack emptyBottle = new ItemStack(Items.GLASS_BOTTLE);
                if (!player.getInventory().insertStack(emptyBottle)) {
                    player.dropItem(emptyBottle, false);
                }
            }

            player.getHungerManager().add(4, 0.3F);

            // ✅ Add status effects
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1800, 1));       // Speed II
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1800, 0));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1800, 1)); // Resistance I
        }

        return result;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 32;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public SoundEvent getDrinkSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return TypedActionResult.consume(user.getStackInHand(hand));
    }
}