package discordBot.main.FileUtil.image;

import discordBot.main.FileUtil.Attachments;
import discordBot.main.FileUtil.FileManager;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;

import java.awt.image.BufferedImage;
import java.io.File;

public class ImageLogic {
    static FileManager fileManager = new FileManager();
    private static CropImage cropImage = new CropImage();
    private Attachments attachments = new Attachments();
    private Compare compare = new Compare();

    public void compareImage(MessageChannel objChannel,Message message) {
        Boolean[] output = new Boolean[5];
        BufferedImage[] refs = fileManager.loadRefs(new File("Images/Downloaded/Refs/ref"));
        BufferedImage[] subImages = new BufferedImage[5];
        if (trySavingAttachment(objChannel,message)) {
             BufferedImage inputImg = fileManager.load(new File("Images/Downloaded/Input/inputRef.png"));
             cropImage.createSubImages(inputImg);
             subImages = fileManager.loadRefs(new File("Images/Downloaded/Input/ref"));
         }
        checkMatches(output, refs, subImages,0.01);
    }
    public void compareImageTest() {
        Boolean[] output = new Boolean[5];
        BufferedImage[] refs = fileManager.loadRefs(new File("Images/Downloaded/Refs/ref"));
        BufferedImage[] subImages;

        BufferedImage inputImg = fileManager.load(new File("Images/Downloaded/Input/inputRef.png"));
        cropImage.createSubImages(inputImg);
        subImages = fileManager.loadRefs(new File("Images/Downloaded/Input/ref"));

        checkMatches(output, refs, subImages,0.01);
    }

    private void checkMatches(Boolean[] output, BufferedImage[] refs, BufferedImage[] subImages,Double matchLimit) {
        for (int i=0; i< output.length;i++) {
            double temp = compare.findSubImageDouble(refs[i],subImages[i],matchLimit);
            if (temp < matchLimit) {
                System.out.println("match % "+temp);
                output[i] = true;
                System.out.println("Match at "+i);
            }
            else {
                System.out.println("No Match at " +i);
            }

        }
    }

    private boolean trySavingAttachment(MessageChannel objChannel, Message objMsg) {
        if (tryDeletingOldFile(new File("Images/Downloaded/Input/inputRef.png"))) {
            File b = attachments.downloadChangeName(objMsg, true, new File("Images/Downloaded/Input/inputRef.png"));
            if (b != null) {
                objChannel.sendMessage("Saving worked! file has been saved!").queue();
                return true;
            } else {
                objChannel.sendMessage("Saving failed or something went wrong!").queue();
            }
        }
        return false;
    }
    private boolean tryDeletingOldFile(File file) {
        try{
            if(file.delete()){
                System.out.println(file.getName() + " is deleted!");
                return true;
            }else{

                System.out.println("Delete operation is failed.");
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
