package net.mango.tunieland.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mango.tunieland.item.ModItems;

public class MainPage extends Screen {
    private static final Identifier BACKGROUND_TEXTURE = new Identifier("minecraft", "textures/gui/book.png");
    private final int backgroundWidth = 192;
    private final int backgroundHeight = 192;

    public MainPage() {
        super(Text.literal("Tunieland Book"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context);

        int x = (this.width - backgroundWidth) / 2;
        int y = (this.height - backgroundHeight) / 2;

        // Draw book background
        RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
        context.drawTexture(BACKGROUND_TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        // Draw title text
        context.drawText(MinecraftClient.getInstance().textRenderer, "Tunieland Book", this.width / 2 - 40, y + 10, 0x000000, false);

        // Draw clickable mango item
        ItemStack mangoStack = ModItems.MANGO.getDefaultStack();
        context.drawItem(mangoStack, x + 30, y + 50);
        context.drawText(MinecraftClient.getInstance().textRenderer, "Items", x + 30, y + 70, 0x000000, false);

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
