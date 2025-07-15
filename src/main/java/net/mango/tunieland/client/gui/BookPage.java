package net.mango.tunieland.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;

public abstract class BookPage {
    public abstract void render(DrawContext context, int width, int height, Screen parent, int mouseX, int mouseY, float delta);
}
