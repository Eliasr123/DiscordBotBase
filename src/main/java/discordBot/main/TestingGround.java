package discordBot.main;

import discordBot.main.FileUtil.image.CropImage;
import discordBot.main.FileUtil.image.ImageLogic;

import java.awt.image.BufferedImage;
import java.io.File;

public class TestingGround {
    private static CropImage cropImage = new CropImage();
    private static ImageLogic imageLogic = new ImageLogic();
    public static void main(String[] args) {
        BufferedImage inputImg = null;
        imageLogic.compareImageTest();
    }
}
