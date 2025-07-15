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

public class TunielandBookScreen extends Screen {
    private static final Identifier BACKGROUND_TEXTURE = new Identifier("minecraft", "textures/gui/book.png");

    private int mangoX, mangoY;
    private int mosquitoX, mosquitoY;

    public TunielandBookScreen() {
        super(Text.literal("Tunieland Guide"));
    }

    @Override
    protected void init() {
        super.init();
        int centerX = this.width / 2;
        int centerY = this.height / 2;

        mangoX = centerX - 40;
        mosquitoX = centerX + 24;
        mangoY = mosquitoY = centerY;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context);

        int x = (this.width - 192) / 2;
        int y = (this.height - 192) / 2;

        RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
        context.drawTexture(BACKGROUND_TEXTURE, x, y, 0, 0, 192, 192);

        // Draw title
        context.drawTextWithShadow(
                MinecraftClient.getInstance().textRenderer,
                "Tunieland",
                this.width / 2 - 30,
                y + 10,
                0xFFFFFF
        );

        // === Scaled Icons ===
        context.getMatrices().push();
        context.getMatrices().translate(0, 0, 100); // Ensure it's on top
        context.getMatrices().scale(2.0f, 2.0f, 2.0f); // Scale 2x

        // Since we're scaling, we divide coordinates by scale
        int iconY = (y + 60) / 2;
        drawItem(context, ModItems.MANGO.getDefaultStack(), (mangoX) / 2, iconY);
        drawItem(context, new ItemStack(ModItems.SANGRE_DE_MOSQUITO), (mosquitoX) / 2, iconY);

        context.getMatrices().pop();

        // === Labels ===
        context.drawTextWithShadow(
                MinecraftClient.getInstance().textRenderer,
                "Items",
                mangoX - 2,
                y + 100,
                0xFFFFFF
        );

        context.drawTextWithShadow(
                MinecraftClient.getInstance().textRenderer,
                "Mobs",
                mosquitoX - 2,
                y + 100,
                0xFFFFFF
        );

        super.render(context, mouseX, mouseY, delta);
    }

    private void drawItem(DrawContext context, ItemStack stack, int x, int y) {
        context.drawItem(stack, x, y);
        context.drawItemInSlot(MinecraftClient.getInstance().textRenderer, stack, x, y, null);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (mouseX >= mangoX && mouseX <= mangoX + 16 && mouseY >= mangoY && mouseY <= mangoY + 16) {
            MinecraftClient.getInstance().setScreen(new ItemPagesScreen());
            return true;
        }

        if (mouseX >= mosquitoX && mouseX <= mosquitoX + 16 && mouseY >= mosquitoY && mouseY <= mosquitoY + 16) {
            MinecraftClient.getInstance().setScreen(new MobsCategoryScreen());
            return true;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
