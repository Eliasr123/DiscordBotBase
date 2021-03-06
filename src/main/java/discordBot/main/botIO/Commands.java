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
    private ImageLogic imageLogic = new ImageLogic();

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
      /*  if (objMsg.getContentRaw().equalsIgnoreCase(preFix + "image")) {
                boolean b = Attachments.downloadRetainName(objMsg, true,"ImagesDownloaded/");
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
         imageLogic.compareImage(objChannel,objMsg);
        }
    }

    void nonAdmin(User user, Message objMsg, MessageChannel objChannel) {

    }
    void serverWide(User objUser, Message objMsg, MessageChannel objChannel) {
        String[] commands = {" ", " ", "input-channel"};
        if (objMsg.getContentRaw().contains(" ")) {
            String[] rollInput = objMsg.getContentRaw().split(" ");
            if (rollInput[0].equalsIgnoreCase(preFix + "roll") && rollInput[1] != null) {
                int rollValue = (int) Math.floor(Math.random() * Double.parseDouble(rollInput[1]))+1;
                if (rollValue == 0) {
                    rollValue +=1;
                }
                objChannel.sendMessage("you rolled " + rollValue + "!").queue();
            }
        } else if (objMsg.getContentRaw().equalsIgnoreCase(preFix + "roll")) {
            int rollValue = (int) Math.floor(Math.random() * 99);
            rollValue +=1;
            objChannel.sendMessage("You rolled "+rollValue+"!").queue();
        }

        if (objMsg.getContentRaw().equalsIgnoreCase(preFix+"hello")) {
            objChannel.sendMessage("Hello, " + objUser.getAsMention() + "!").queue();
        }

        //this prints out server wide commands
        if (objMsg.getContentRaw().equalsIgnoreCase(preFix+"Commands")) {
            StringBuilder s = new StringBuilder();
            s.append("```");
            for (String command : commands) {
                s.append(command).append("\r\n");
            }
            s.append("\r\n For channel specific ```");
            objChannel.sendMessage(s).queue();
        }
        if (objMsg.getContentRaw().equalsIgnoreCase(preFix+commands[1])) {
            objChannel.sendMessage(objChannel.getName()).queue();
        }
        if (objMsg.getContentRaw().startsWith("REE")) {
            objChannel.sendFile(new File("ImagesDownloaded/REE.gif")).queue();
        }
    }
}

