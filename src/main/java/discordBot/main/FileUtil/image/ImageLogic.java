package discordBot.main.FileUtil.image;

import discordBot.main.FileUtil.FileManager;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;

public class ImageLogic {
    public static FileManager fileManager = new FileManager();
    private static CropImage cropImage = new CropImage();

    /**
     *
     * @param objChannel
     */
    public void compareImage(MessageChannel objChannel,Message message, File filePath) {
        BufferedImage[] refs = fileManager.loadRefs(new File("Images/Downloaded/Refs/"));
        BufferedImage inputImg = null;
        inputImg = ImageLogic.fileManager.load(new File("Images/Downloaded/StaticRef1.png"));
        if (inputImg != null) {
            cropImage.createSubImages(inputImg);
        }

    }
}
