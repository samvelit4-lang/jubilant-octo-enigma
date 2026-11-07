package com.scriptmod.core;

import com.scriptmod.ui.ScriptMenuScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ClientModInit implements ClientModInitializer {
    public static KeyBinding openMenuKey;

    @Override
    public void onInitializeClient() {
        // Регистрация клавиши Right Shift
        openMenuKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.scriptmod.open_menu",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_RIGHT_SHIFT,
            "category.scriptmod.general"
        ));

        // Отслеживание нажатия в игре
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openMenuKey.wasPressed()) {
                if (client.player != null) {
                    ServerBypassManager.checkAndApplyBypass(client);
                    client.setScreen(new ScriptMenuScreen());
                }
            }
        });
    }
}
