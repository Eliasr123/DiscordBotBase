package discordBot.main.FileUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileManager {
    public BufferedImage load(File filename) {
        try {
            System.out.println("Loading succeeded");
           return ImageIO.read(new File("ImagesDownloaded/"+ filename));
        } catch (IOException e) {
            System.out.println("Image Load Failed!");
        }
        return null;
    }
}
