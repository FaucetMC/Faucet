package com.faucetmc.faucet.command;

import com.faucetmc.faucet.manager.ChatManager;
import com.faucetmc.faucet.FaucetPlugin;
import lombok.Getter;
import org.bukkit.command.CommandSender;

public abstract class FaucetCommand {

    @Getter
    private final String name;

    @Getter
    protected boolean availableForConsole;

    @Getter
    protected boolean availableForPlayer;

    protected ChatManager chat;

    protected FaucetPlugin faucet;

    FaucetCommand(final String name, FaucetPlugin faucet){
        this.name = name;
        this.faucet = faucet;
        this.chat = faucet.getChatManager();
    }

    //public abstract void exec(IFaucetCommandSender sender, String[] args);

    public abstract void exec(CommandSender sender, String[] args);

}
