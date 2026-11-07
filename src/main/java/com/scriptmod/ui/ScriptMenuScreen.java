package com.scriptmod.ui;

import com.scriptmod.core.ScriptExecutor;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class ScriptMenuScreen extends Screen {

    public ScriptMenuScreen() {
        super(Text.literal("Script Executor"));
    }

    @Override
    protected void init() {
        int buttonWidth = 150;
        int buttonHeight = 20;
        int startX = (this.width - buttonWidth) / 2;
        int startY = 80;

        // Кнопка запуска скрипта (в стиле Delta)
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Запустить скрипт"), button -> {
            ScriptExecutor.runScriptString("print('Delta-like script executed successfully!');");
        }).dimensions(startX, startY, buttonWidth, buttonHeight).build());

        // Кнопка закрытия
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Закрыть"), button -> {
            this.close();
        }).dimensions(startX, startY + 30, buttonWidth, buttonHeight).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);

        int panelWidth = 300;
        int panelHeight = 200;
        int panelX = (this.width - panelWidth) / 2;
        int panelY = (this.height - panelHeight) / 2;

        // Красивое стильное окно интерфейса (Темная тема)
        context.fill(panelX, panelY, panelX + panelWidth, panelY + panelHeight, 0xCC1E1E2E);
        context.fill(panelX, panelY, panelX + panelWidth, panelY + 25, 0xFF89B4FA);
        context.drawText(this.textRenderer, "📜 Script Hub (Delta Style)", panelX + 10, panelY + 8, 0xFF11111B, false);

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
