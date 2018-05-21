package discordBot.main.FileUtil.image;

import discordBot.main.FileUtil.FileManager;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
        BufferedImage[] refs = loadCompareRefs();


        objChannel.sendMessage("Match position " + Arrays.toString(Compare.compareTwoImages(ref,saber))).queue();
        objChannel.sendMessage("Match " + Compare.compareTwoImagesDouble(ref,saber) + "%").queue();

        objChannel.sendMessage("Match position " + Arrays.toString(Compare.compareTwoImages(ref,saber))).queue();
        objChannel.sendMessage("Match " + Compare.compareTwoImagesDouble(ref,saber) + "%").queue();
    }
    private BufferedImage[] loadCompareRefs() {
        BufferedImage[] imageArray = new BufferedImage[5];
        for (int i = 0; i < imageArray.length;i++) {
            imageArray[i] = fileManager.load(new File("Images/Downloaded/Refs/ref"+i+".png"));
        }
        return imageArray;
    }
    public void createSubImages(BufferedImage bigImage) {
        // use the Border.png to find the first border.
        BufferedImage border = fileManager.load(new File("Images/Resources/Border/Border.png"));
        int[] coordinates = Compare.findSubimage(bigImage, border);
        System.out.println(coordinates[0] + " - " + coordinates[1]);

        // use IMAGE_CONSTANTS.IMAGE_WIDTH and IMAGE_CONSTANTS.IMAGE_HEIGHT to cut out
        // the image.


        // do this for all images.
        // after the first image, there are 4 rows down at 100 pixels lower than the previous.
        // after the first image, there are 6 colums to the right, at 58 pixels difference
        // after the 6th image, there is a gap of 90 before the above statement is repeated.
        int counter = 0;
        int refNumber = 0;
        for(int rows = 0; rows < 3; rows++) {
            for(int columns = 0; columns < 12; columns++) {
                counter++;
                BufferedImage subImage = bigImage.getSubimage(columns<6?coordinates[0]+(columns*58):coordinates[0]+32+(columns*58), coordinates[1]+(rows*100) ,48, 48);

                if (counter == 5) {
                    try {
                        ImageIO.write(subImage, "png", new File(String.format("Images/Resources/Output/ref%s.png", refNumber)));
                        refNumber++;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    counter = -1;
                }
                if (rows== 2 && columns ==7) {
                    break;
                }
            }
        }



        // write the subimages to disk, this should create 42 images.
    }
}
