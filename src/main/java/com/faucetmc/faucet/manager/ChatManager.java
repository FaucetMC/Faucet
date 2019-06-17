package com.faucetmc.faucet.manager;

import com.faucetmc.faucet.FaucetPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ChatManager {

    private final static ChatColor NORMAL_COLOR = ChatColor.BLUE;
    private final static ChatColor ERROR_COLOR = ChatColor.RED;

    private final static String PREFIX = NORMAL_COLOR + ChatColor.BOLD.toString() + "[Faucet] " + ChatColor.RESET;

    private final FaucetPlugin faucet;

    public ChatManager(FaucetPlugin faucet){
        this.faucet = faucet;
    }

    public void sendError(CommandSender sender, String text){
        sender.sendMessage(PREFIX + ERROR_COLOR + text);
    }

    public void sendMessage(CommandSender sender, String text){
        sender.sendMessage(PREFIX + NORMAL_COLOR + text);
    }

}
