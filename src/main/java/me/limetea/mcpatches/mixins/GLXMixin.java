package me.limetea.mcpatches.mixins;

import com.mojang.blaze3d.platform.GLX;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.LongSupplier;

@Mixin(GLX.class)
public final class GLXMixin {

    @Inject(method = "_initGlfw", at = @At("HEAD"), remap = false)
    private static void onInitGLFW(CallbackInfoReturnable<LongSupplier> info) {
        if (GLFW.glfwPlatformSupported(GLFW.GLFW_PLATFORM_WAYLAND))
            GLFW.glfwInitHint(GLFW.GLFW_PLATFORM, GLFW.GLFW_PLATFORM_WAYLAND);
    }

}
