package discordBot.main.FileUtil.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Put in picture, coordinates and size and it will spit back a image
 */
public class CropImage {
    private BufferedImage crop(int x,int y,int w,int h,String path, int i){
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("ImagesDownloaded/"+path));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("Image Load failed");
        }
        return image.getSubimage(x, y, w, h);

    }
    public int[] findRelativePos() {
        return null;
    }
}
