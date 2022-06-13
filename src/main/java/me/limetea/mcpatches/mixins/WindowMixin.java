package me.limetea.mcpatches.mixins;

import net.minecraft.client.util.Window;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Desc;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Window.class)
public final class WindowMixin {

    @Inject(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    desc = @Desc(
                            owner = GLFW.class,
                            value = "glfwDefaultWindowHints"
                    ),
                    shift = At.Shift.AFTER
            )
    )
    private void onInit(CallbackInfo info) {
        if (GLFW.glfwPlatformSupported(GLFW.GLFW_PLATFORM_WAYLAND)) {
            GLFW.glfwWindowHint(GLFW.GLFW_FOCUSED, GLFW.GLFW_FALSE);

            if (Boolean.parseBoolean(System.getProperty("minecraft.no_glfw_decors")))
                GLFW.glfwWindowHint(GLFW.GLFW_DECORATED, GLFW.GLFW_FALSE);
        }
    }

    @Inject(method = "setIcon", at = @At("HEAD"), cancellable = true)
    private void setIcon(CallbackInfo info) {
        if (GLFW.glfwPlatformSupported(GLFW.GLFW_PLATFORM_WAYLAND))
            info.cancel();
    }

}
