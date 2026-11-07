package com.scriptmod.core;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

public class ScriptExecutor {
    private static final Globals globals = JsePlatform.standardGlobals();

    public static void runScriptString(String code) {
        try {
            LuaValue chunk = globals.load(code);
            chunk.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
