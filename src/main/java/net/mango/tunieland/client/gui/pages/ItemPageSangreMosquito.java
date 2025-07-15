package net.mango.tunieland.client.gui.pages;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mango.tunieland.item.ModItems;

public class ItemPageSangreMosquito extends Screen {
    private static final Identifier BACKGROUND_TEXTURE = new Identifier("minecraft", "textures/gui/book.png");

    public ItemPageSangreMosquito() {
        super(Text.literal("Sangre de mosquito"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context);

        int x = (this.width - 192) / 2;
        int y = (this.height - 192) / 2;

        RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
        context.drawTexture(BACKGROUND_TEXTURE, x, y, 0, 0, 192, 192);

        // Draw item icon scaled 2x
        context.getMatrices().push();
        context.getMatrices().translate(0, 0, 100);
        context.getMatrices().scale(2.0f, 2.0f, 2.0f);
        context.drawItem(ModItems.SANGRE_DE_MOSQUITO.getDefaultStack(), (x + 30) / 2, (y + 60) / 2);
        context.getMatrices().pop();

        // Draw text
        context.drawTextWithShadow(MinecraftClient.getInstance().textRenderer, "Sangre de mosquito", x + 110, y + 40, 0xFFFFFF);
        context.drawTextWithShadow(MinecraftClient.getInstance().textRenderer, "Sangre del terror de nephtunie, usada para crafteo.", x + 110, y + 60, 0xFFFFFF);

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
