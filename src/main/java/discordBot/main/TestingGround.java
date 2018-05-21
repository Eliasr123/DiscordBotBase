package discordBot.main;

import discordBot.main.FileUtil.FileManager;
import discordBot.main.FileUtil.image.Compare;
import discordBot.main.FileUtil.image.CropImage;
import discordBot.main.FileUtil.image.ImageLogic;

import java.awt.image.BufferedImage;
import java.io.File;

public class TestingGround {
    private static CropImage cropImage = new CropImage();
    private static ImageLogic imageLogic = new ImageLogic();
    private static Compare compare = new Compare();
    private static FileManager fileManager = new FileManager();
    public static void main(String[] args) {
        //BufferedImage inputImg = fileManager.load(new File("Images/Downloaded/Refs/ref2.png"));
        //BufferedImage tradeImg = fileManager.load(new File("Images/Downloaded/Input/ref2.png"));
        imageLogic.compareImageTest();

        //System.out.println(compare.findSubImageDouble(tradeImg,inputImg,0.01));
    }
}
