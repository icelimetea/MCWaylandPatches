# Some MC patches

### *This mod is nothing more than an experiment.*

A very dumb try to launch Minecraft under native Wayland.

## GLFW fallback decoration bugs

GLFW will try to request window decoration from your compositor via xdg-decoration protocol.
However, some compositors (e.g. GNOME's Mutter) do not support this protocol.
In this case, GLFW is going to fall back to very basic self-made window decoration, that might cause some rendering bugs.

Because of that, there is an option that disables any window decorations at all.
In order to use it, add this to JVM arguments in your Minecraft launch profile:
```
-Dminecraft.no_glfw_decors=true
```
