package com.faucetmc.faucet.command;

import com.faucetmc.faucet.FaucetPlugin;
import org.bukkit.command.CommandSender;

public class GodCommand extends FaucetCommand {
    protected GodCommand(FaucetPlugin faucet) {
        super("god", faucet);
    }

    @Override
    public void exec(CommandSender sender, String[] args) {
    }
}
