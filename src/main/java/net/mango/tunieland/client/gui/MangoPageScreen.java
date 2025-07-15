package net.mango.tunieland.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MangoPageScreen extends Screen {
    private static final Identifier BACKGROUND_TEXTURE = new Identifier("minecraft", "textures/gui/book.png");

    public MangoPageScreen() {
        super(Text.literal("Tunieland Guide - Mango"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context);

        int x = (this.width - 192) / 2;
        int y = (this.height - 192) / 2;

        RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
        context.drawTexture(BACKGROUND_TEXTURE, x, y, 0, 0, 192, 192);

        // Draw title centered
        String title = "Tunieland Guide - Mango";
        context.drawTextWithShadow(
                MinecraftClient.getInstance().textRenderer,
                title,
                this.width / 2 - MinecraftClient.getInstance().textRenderer.getWidth(title) / 2,
                y + 10,
                0x000000
        );

        // Draw body text centered under title
        String line = "This is a Mango page.";
        context.drawTextWithShadow(
                MinecraftClient.getInstance().textRenderer,
                line,
                this.width / 2 - MinecraftClient.getInstance().textRenderer.getWidth(line) / 2,
                y + 40,
                0x000000
        );

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
