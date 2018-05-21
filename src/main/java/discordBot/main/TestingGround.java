package discordBot.main;

import discordBot.main.FileUtil.image.CropImage;
import discordBot.main.FileUtil.image.ImageLogic;

import java.awt.image.BufferedImage;
import java.io.File;

public class TestingGround {
    private static CropImage cropImage = new CropImage();
    public static void main(String[] args) {
        BufferedImage inputImg = null;
        inputImg = ImageLogic.fileManager.load(new File("Images/Downloaded/StaticRef1.png"));
        if (inputImg != null) {
            cropImage.createSubImages(inputImg);
        }


    }
}
