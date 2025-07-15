package net.mango.tunieland.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.client.MinecraftClient;
import net.mango.tunieland.item.ModItems;
import net.minecraft.item.ItemStack;

public class ItemsPage extends Screen {

    protected ItemsPage() {
        super(Text.of("Tunieland Items"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context);

        int x = (this.width - 192) / 2;
        int y = (this.height - 192) / 2;

        // Title
        context.drawText(MinecraftClient.getInstance().textRenderer, Text.literal("All Items"), x + 10, y + 10, 0x000000, false);

        // Example: draw the Mango item
        context.drawItem(new ItemStack(ModItems.MANGO), x + 10, y + 30);
        context.drawText(MinecraftClient.getInstance().textRenderer, Text.literal("Mango"), x + 30, y + 34, 0x000000, false);

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
