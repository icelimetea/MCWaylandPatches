package me.limetea.mcpatches;

import net.fabricmc.api.ClientModInitializer;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.util.tinyfd.TinyFileDialogs;

public final class MCWaylandPatches implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        if (!GLFW.glfwPlatformSupported(GLFW.GLFW_PLATFORM_WAYLAND)) {
            TinyFileDialogs.tinyfd_messageBox(
                    "SomeMCPatches mod",
                    "Wayland is not supported on your configuration.",
                    "ok",
                    "warning",
                    true
            );
        }
    }

}
