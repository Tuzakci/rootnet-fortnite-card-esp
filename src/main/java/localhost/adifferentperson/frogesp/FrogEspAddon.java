package localhost.adifferentperson.frogesp;

import dev.rootnet.addons.api.addon.Addon;
import dev.rootnet.addons.api.annotations.RootnetAddon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.Level;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

@SuppressWarnings("unused")
@RootnetAddon(name = "19 Dollar Fortnite Card ESP", author = "ADifferentPerson - forked by Tuzakci", version = "1.1.1")
public final class FrogEspAddon extends Addon {
    private static final String FROG_URL = "https://cdn.discordapp.com/attachments/803114971659108362/825423573006811136/fortnite.gif";
    private static final Minecraft MC = Minecraft.getMinecraft();
    static ResourceLocation frog;
    static double frogRatio;
    static FrogEspAddon INSTANCE;

    @Override
    public final void init() {
        INSTANCE = this;
        log(Level.INFO, "Initializing Fortnite Card...");
        try {
            final BufferedImage image = ImageIO.read(new URL(FROG_URL));
            frogRatio = ((double) image.getWidth()) / ((double) image.getHeight());
            final DynamicTexture dynamicTexture = new DynamicTexture(image);
            dynamicTexture.loadTexture(MC.getResourceManager());
            frog = MC.getTextureManager().getDynamicTextureLocation("FROG", dynamicTexture);
        } catch (final IOException e) {
            e.printStackTrace();
        }
        getRootnet().registerModule(this, new FrogEspModule());
    }
}
