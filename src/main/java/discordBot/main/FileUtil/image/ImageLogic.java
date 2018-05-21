package discordBot.main.FileUtil.image;

import discordBot.main.FileUtil.FileManager;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;

public class ImageLogic {
    public static FileManager fileManager = new FileManager();

    /**
     *
     * @param objChannel
     */
    public void compareImage(MessageChannel objChannel,Message message, File filePath) {
        BufferedImage ref = fileManager.load(filePath);
        BufferedImage saber = fileManager.load(filePath);
        BufferedImage[] refs = fileManager.loadRefs(new File("Images/Downloaded/Refs/"));


        objChannel.sendMessage("Match position " + Arrays.toString(Compare.compareTwoImages(ref,saber))).queue();
        objChannel.sendMessage("Match " + Compare.compareTwoImagesDouble(ref,saber) + "%").queue();

        objChannel.sendMessage("Match position " + Arrays.toString(Compare.compareTwoImages(ref,saber))).queue();
        objChannel.sendMessage("Match " + Compare.compareTwoImagesDouble(ref,saber) + "%").queue();
    }
}
