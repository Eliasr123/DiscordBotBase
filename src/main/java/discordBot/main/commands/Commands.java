package discordBot.main.commands;

import discordBot.main.App;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

public class Commands {
    public void serverAdmin(User user, Message objMsg, MessageChannel objChannel) {
        //prints out all the channels available
        if (objMsg.getContentRaw().equalsIgnoreCase(".ShowAllChannels")) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < discordBot.main.App.textChannels.size(); i++) {
                s.append(i).append(".  ").append(App.textChannels.get(i).toString()).append("\r\n");
            }
            objChannel.sendMessage(s).queue();
        }
        //tests printing in another channel
        if (objMsg.getContentRaw().equalsIgnoreCase(".printIn")) {
            App.textChannels.get(4).sendMessage("printing in another channel!").queue();

        }
    }
    public void serverWide(User user, Message msg, MessageChannel channel) {
        String[] commands = {" ", " ", "input-channel"};


        if (msg.getContentRaw().equalsIgnoreCase(".hello")) {
            channel.sendMessage("Hello, " + user.getAsMention() + "!").queue();
        }

        //this prints out server wide commands
        if (msg.getContentRaw().equalsIgnoreCase(".Commands")) {
            StringBuilder s = new StringBuilder();
            s.append("```");
            for (int i = 0; i < commands.length; i++) {
                s.append(commands[i]).append("\r\n");
            }
            s.append("\r\n For TokenUtil specific ```");
            channel.sendMessage(s).queue();
        }
        if (msg.getContentRaw().equalsIgnoreCase(commands[1])) {
            channel.sendMessage(channel.getName()).queue();
        }
    }
}

