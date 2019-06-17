package com.faucetmc.faucet.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public final class CommandBridge extends Command {

    private FaucetCommand command;

    public CommandBridge(FaucetCommand command) {
        super(command.getName());
        this.command = command;
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        this.command.exec(sender, args);
        return true;
    }
}
