package discordBot.main.FileUtil.image;

import discordBot.main.FileUtil.FileManager;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;

public class ImageLogic {
    private static FileManager fileManager = new FileManager();

    /**
     *
     * @param objChannel
     */
    public void compareImage(MessageChannel objChannel,Message message, File filePath) {
        BufferedImage ref = fileManager.load(filePath);
        BufferedImage saber = fileManager.load(filePath);
        BufferedImage[] refs = loadCompareRefs();


        objChannel.sendMessage("Match position " + Arrays.toString(Compare.findSubImage(ref,saber))).queue();
        objChannel.sendMessage("Match " + Compare.findSubImageD(ref,saber) + "%").queue();

        objChannel.sendMessage("Match position " + Arrays.toString(Compare.findSubImage(ref,saber))).queue();
        objChannel.sendMessage("Match " + Compare.findSubImageD(ref,saber) + "%").queue();
    }
    private BufferedImage[] loadCompareRefs() {
        BufferedImage[] imageArray = new BufferedImage[8];
        for (int i = 0; i < imageArray.length;i++) {
            imageArray[i] = fileManager.load(new File("ImagesDownloaded/Refs/item"+i+".png"));
        }
        return imageArray;
    }
}
