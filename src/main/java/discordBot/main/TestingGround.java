package discordBot.main;

import discordBot.main.FileUtil.image.CropImage;
import discordBot.main.FileUtil.image.ImageLogic;

import java.awt.image.BufferedImage;
import java.io.File;

public class TestingGround {
    private static ImageLogic imageLogic = new ImageLogic();
    private static CropImage cropImage = new CropImage();
    public static void main(String[] args) {
        BufferedImage ref = null;
        ref = ImageLogic.fileManager.load(new File("Images/Downloaded/StaticRef1.png"));
        if (ref != null) {
            cropImage.createSubImages(ref);
        }


        //imageLogic.compareImageTest(new File("ImagesDownloaded/staticrefser.png"),new File("ImagesDownloaded/ref4.png"));

    }
    private void runTest() {


    }
}
