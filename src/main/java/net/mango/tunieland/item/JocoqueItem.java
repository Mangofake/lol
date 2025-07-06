package net.mango.tunieland.item;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;

public class JocoqueItem extends Item {
    public JocoqueItem(Settings settings) {
        super(settings.food(new FoodComponent.Builder()
                .hunger(4)
                .saturationModifier(0.3f)
                .alwaysEdible()
                .build()));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return super.use(world, user, hand);
    }
}
