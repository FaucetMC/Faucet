package com.faucetmc.faucet.command;

import com.faucetmc.faucet.FaucetPlugin;
import com.faucetmc.faucet.manager.GodManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand extends FaucetCommand {
    protected GodCommand(FaucetPlugin faucet) {
        super("god", faucet);
    }

    @Override
    public void exec(CommandSender sender, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            this.faucet.getGodManager().toggle(player.getUniqueId());
            player.sendMessage("Toggled god mode");
        }
    }
}
