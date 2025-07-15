package net.mango.tunieland.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.item.ItemStack;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mango.tunieland.item.ModItems;

import java.util.List;

public class ItemPagesScreen extends Screen {
    private static final Identifier BACKGROUND_TEXTURE = new Identifier("minecraft", "textures/gui/book.png");

    private static class PageContent {
        public final String title;
        public final String description;
        public final ItemStack icon;

        public PageContent(String title, String description, ItemStack icon) {
            this.title = title;
            this.description = description;
            this.icon = icon;
        }
    }

    private final List<PageContent> pages = List.of(
            new PageContent("Mango", "Una fruta y nombre de un hombre alto apuesto con carisma buena persona.", ModItems.MANGO.getDefaultStack()),
            new PageContent("Jocoque", "Un producto lácteo que por alguna razón le gusta a la gente, al consumirlo otorga resistencia a costo de velocidad, como el zombie jajalolxd", ModItems.JOCOQUE.getDefaultStack()),
            new PageContent("Pinky Drink", "Bebida sobrevalorada proveniente del estarbus, le gusta al streamer por esa esta aquí no tiene lore, otorga resistencia, regeneración y velocidad.", ModItems.PINKY_DRINK.getDefaultStack()),
            new PageContent("Sangre", "Sangre del terror de nephtunie (mosquitos), usada para crafteo.", ModItems.SANGRE_DE_MOSQUITO.getDefaultStack()),
            new PageContent("Monster", "Bebidas enérgicas, cada bebida tiene su respectivo efecto.", ModItems.MONSTER_DRINK.getDefaultStack())
    );

    private int currentPage = 0;

    public ItemPagesScreen() {
        super(Text.literal("Items"));
    }

    @Override
    protected void init() {
        super.init();
        int x = (this.width - 192) / 2;
        int y = (this.height - 192) / 2;

        this.addDrawableChild(ButtonWidget.builder(Text.literal("<"), btn -> {
            if (currentPage > 0) {
                currentPage--;
            }
        }).dimensions(x + 10, y + 170, 20, 20).build());

        this.addDrawableChild(ButtonWidget.builder(Text.literal(">"), btn -> {
            if (currentPage < pages.size() - 1) {
                currentPage++;
            }
        }).dimensions(x + 162, y + 170, 20, 20).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context);

        int bookX = (this.width - 192) / 2;
        int bookY = (this.height - 192) / 2;

        RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
        context.drawTexture(BACKGROUND_TEXTURE, bookX, bookY, 0, 0, 192, 192);

        PageContent item = pages.get(currentPage);

        int rightPageX = bookX + 52;
        int rightPageY = bookY + 9; // moved higher by 6 pixels
        int wrapWidth = 90;

        // === Title ===
        int titleWidth = MinecraftClient.getInstance().textRenderer.getWidth(item.title);
        context.drawTextWithShadow(
                MinecraftClient.getInstance().textRenderer,
                item.title,
                rightPageX + (wrapWidth - titleWidth) / 2,
                rightPageY,
                0x000000
        );

        // === Icon ===
        int iconX = rightPageX + (wrapWidth - 32) / 2;
        int iconY = rightPageY + 14;
        context.getMatrices().push();
        context.getMatrices().translate(iconX, iconY, 100);
        context.getMatrices().scale(2.0f, 2.0f, 1.0f);
        context.drawItem(item.icon, 0, 0);
        context.drawItemInSlot(MinecraftClient.getInstance().textRenderer, item.icon, 0, 0, null);
        context.getMatrices().pop();

        // === Description ===
        List<OrderedText> lines = MinecraftClient.getInstance().textRenderer.wrapLines(Text.literal(item.description), wrapWidth);
        for (int i = 0; i < lines.size(); i++) {
            context.drawText(MinecraftClient.getInstance().textRenderer, lines.get(i), rightPageX, iconY + 36 + i * 10, 0x000000, false);
        }

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
