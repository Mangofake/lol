package net.mango.tunieland.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MobsCategoryScreen extends Screen {
    private static final Identifier BACKGROUND_TEXTURE = new Identifier("minecraft", "textures/gui/book.png");

    public MobsCategoryScreen() {
        super(Text.literal("Tunieland Guide - Mobs"));
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context);
        int x = (this.width - 192) / 2;
        int y = (this.height - 192) / 2;

        RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
        context.drawTexture(BACKGROUND_TEXTURE, x, y, 0, 0, 192, 192);

        context.drawTextWithShadow(MinecraftClient.getInstance().textRenderer,
                "Mobs", this.width / 2 - 20, y + 10, 0x000000);

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
