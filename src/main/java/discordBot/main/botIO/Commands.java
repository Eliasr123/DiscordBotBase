package discordBot.main.botIO;

import discordBot.main.App;
import discordBot.main.FileUtil.Attachments;
import discordBot.main.FileUtil.image.Compare;
import discordBot.main.FileUtil.FileManager;
import discordBot.main.FileUtil.image.ImageLogic;
import net.dv8tion.jda.core.entities.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;

class Commands {
    ImageLogic imageLogic = new ImageLogic();
    Attachments attachments = new Attachments();

    private String preFix = ".";
    void serverAdmin(User user, Message objMsg, MessageChannel objChannel) {
        //Splits the command at spaces
        String[] stringInput = objMsg.getContentRaw().split(" ");

        //prints out all the channels available
        if (objMsg.getContentRaw().equalsIgnoreCase(preFix + "ShowAllChannels")) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < discordBot.main.App.textChannels.size(); i++) {
                s.append(i).append(".  ").append(App.textChannels.get(i).toString()).append("\r\n");
            }
            objChannel.sendMessage(s).queue();
        }
        //tests printing in another channel
        if (objMsg.getContentRaw().equalsIgnoreCase(preFix + "printIn")) {
            App.textChannels.get(4).sendMessage("printing in another channel!").queue();

        }
        if (objMsg.getContentRaw().equalsIgnoreCase(preFix + "roll")) {
            int rollValue = (int) Math.floor(Math.random() * 5);
            objChannel.sendMessage("You rolled "+rollValue+"!").queue();
        }
      /*  if (objMsg.getContentRaw().equalsIgnoreCase(preFix + "image")) {
                boolean b = Attachments.download(objMsg, true,"ImagesDownloaded/");
                if (b) {
                    objChannel.sendMessage("Saving worked! file has been saved!").queue();
                } else {
                    objChannel.sendMessage("Saving failed or something went wrong!").queue();
                }
        }*/
        if (objMsg.getContentRaw().equalsIgnoreCase(preFix + "sendTestImage")) {
            objChannel.sendFile(new File("ImagesDownloaded/test.png")).queue();
        }
        if (objMsg.getContentRaw().equalsIgnoreCase(preFix+"testCompare")) {
            imageLogic.compareImage(objChannel,objMsg,attachments.download(objMsg,true,"ImagesDownloaded/"));
        }
        if (objMsg.getContentRaw().equalsIgnoreCase(preFix+"testCompare1")) {

        }
    }

    void nonAdmin(User user, Message objMsg, MessageChannel objChannel) {
        if (objMsg.getContentRaw().equalsIgnoreCase(preFix + "roll")) {
            int rollValue = (int) Math.floor(Math.random() * 100);
            objChannel.sendMessage("You rolled "+rollValue+"!").queue();
        }
    }
    void serverWide(User user, Message msg, MessageChannel channel) {
        String[] commands = {" ", " ", "input-channel"};


        if (msg.getContentRaw().equalsIgnoreCase(preFix+"hello")) {
            channel.sendMessage("Hello, " + user.getAsMention() + "!").queue();
        }

        //this prints out server wide commands
        if (msg.getContentRaw().equalsIgnoreCase(preFix+"Commands")) {
            StringBuilder s = new StringBuilder();
            s.append("```");
            for (String command : commands) {
                s.append(command).append("\r\n");
            }
            s.append("\r\n For channel specific ```");
            channel.sendMessage(s).queue();
        }
        if (msg.getContentRaw().equalsIgnoreCase(preFix+commands[1])) {
            channel.sendMessage(channel.getName()).queue();
        }
    }
}

