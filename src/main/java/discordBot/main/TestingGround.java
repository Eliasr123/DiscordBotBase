package discordBot.main;

import discordBot.main.FileUtil.image.ImageLogic;

import java.io.File;

public class TestingGround {
    private static ImageLogic imageLogic = new ImageLogic();
    public static void main(String[] args) {
        imageLogic.compareImageTest(new File("staticrefser.png"),new File("ref4.png"));

    }
    private void runTest() {


    }
}
