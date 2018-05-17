package discordBot.main.FileUtil;

import net.dv8tion.jda.core.entities.Message;

import java.io.File;

public class Attachments {


    /** function tris to download a attached file from discord
     * @param message inputted message that might contain a attachment
     * @param filterImages decides if it only wants to save images or if any file is fine
     * @return returns a boolean depending if the saving was possible or not */
    public static boolean download(Message message, boolean filterImages,String directory) {
        for(Message.Attachment attachment : message.getAttachments()) {
            if(!filterImages || attachment.isImage()) {
                attachment.download(new File(directory + attachment.getFileName()));
                return true;
            }
        }
        return false;
    }
}
