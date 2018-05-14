package discordBot.main.commands;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.List;

public class MessageReceived {
    private Commands commands = new Commands();
    private Handler handler = new Handler();
    //Obtains properties of the received message
    private Message thisMsg;
    private MessageChannel thisChannel;
    private User thisUser;
    private MessageEmbed thisImage[];
    // gets a list of all the roles that user has
    private List<Role> roles;

    /**
     * Gets all necessary info for handling a input
     * @param messageEvent this is the last inputted message
     */
    public MessageReceived(MessageReceivedEvent messageEvent) {
        thisMsg = messageEvent.getMessage();
        thisChannel = messageEvent.getChannel();
        thisUser = messageEvent.getAuthor();
        roles = messageEvent.getGuild().getMember(thisUser).getRoles();
        thisImage = messageEvent.getMessage().getEmbeds().toArray(new MessageEmbed[0]);

    }
    /**
     *Checks if anything is needed for certain commands to trigger
     *  */
    public void messageReceivedHandler() {
    //makes bot unable to respond to its own message
        if(!thisUser.isBot()) {
        //Admin only commands.
        if (handler.checkRole(roles, "admin")) {
            commands.serverAdmin(thisUser, thisMsg, thisChannel,thisImage);
        }
        else if (!handler.checkRole(roles,"admin")) {
            commands.nonAdmin(thisUser,thisMsg,thisChannel);
        }
        //Example of Role specific serverWide
        else if (handler.checkRole(roles, "ExampleRole")) {
            //serverWide(thisUser, thisMsg, thisChannel);
        }
        //for input serverWide in a specific channel in this case "input-channel"
        else if (handler.checkChannel(thisChannel, "input-channel")) {
            commands.serverWide(thisUser, thisMsg, thisChannel);
        }else {
            thisChannel.sendMessage("input invalid").queue();
        }

    }
}
}
