package net.mango.tunieland.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import net.minecraft.client.MinecraftClient;
import net.mango.tunieland.client.gui.TunielandBookScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class TunielandBookItem extends Item {
    public TunielandBookItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (world.isClient) {
            openClientBookScreen();
        }
        return TypedActionResult.success(player.getStackInHand(hand), world.isClient());
    }

    private void openClientBookScreen() {
        MinecraftClient.getInstance().setScreen(new TunielandBookScreen());
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        return this.use(context.getWorld(), context.getPlayer(), context.getHand()).getResult();
    }
}
