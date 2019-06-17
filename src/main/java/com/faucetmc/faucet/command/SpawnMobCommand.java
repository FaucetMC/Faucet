package com.faucetmc.faucet.command;

import com.faucetmc.faucet.FaucetPlugin;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SpawnMobCommand extends FaucetCommand {
    public SpawnMobCommand(FaucetPlugin faucet) {
        super("spawnMob", faucet);
    }

    @Override
    public void exec(CommandSender sender, String[] args) {
        if(sender instanceof Player){
            Player player = (Player)sender;
            if(args.length == 2) {
                var mobName = args[0];
                int count = 0;
                try {
                    count = Integer.parseInt(args[1]);
                } catch (NumberFormatException ex){
                    chat.sendError(sender, "Cannot parse number");
                    return;
                }

                EntityType mobType = null;
                for(EntityType type : EntityType.values()){
                    if(type.name().equalsIgnoreCase(mobName)){
                        mobType = type;
                        break;
                    }
                }

                if(mobType == null){
                    chat.sendError(sender, "Cannot recognize entity");
                    return;
                }

                if(!mobType.isSpawnable()){
                    chat.sendError(sender, "Entity is not able to spawn.");
                    return;
                }

                for(int i = 0; i <= count; i++){
                    player.getWorld().spawnEntity(player.getLocation(), mobType);
                }
                chat.sendMessage(sender, String.format("Spawned %s (%d times)", mobType.name(), count));
            }
        }
    }
}
