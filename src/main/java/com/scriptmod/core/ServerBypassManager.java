package com.scriptmod.core;

import net.minecraft.client.MinecraftClient;
import java.util.HashMap;
import java.util.Map;

public class ServerBypassManager {
    private static final Map<String, String> serverBypasses = new HashMap<>();

    static {
        // База обходов под конкретные серверы
        serverBypasses.put("hypixel.net", "hypixel_bypass");
        serverBypasses.put("funtime.su", "funtime_bypass");
    }

    public static void checkAndApplyBypass(MinecraftClient client) {
        if (client.getCurrentServerEntry() != null) {
            String ip = client.getCurrentServerEntry().address.toLowerCase();
            for (Map.Entry<String, String> entry : serverBypasses.entrySet()) {
                if (ip.contains(entry.getKey())) {
                    System.out.println("[BypassManager] Activated bypass for: " + entry.getKey());
                    break;
                }
            }
        }
    }
}
