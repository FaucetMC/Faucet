package com.faucetmc.faucet.manager;

import com.faucetmc.faucet.FaucetPlugin;
import com.faucetmc.faucet.command.CommandBridge;
import com.faucetmc.faucet.command.FaucetCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    private final FaucetPlugin faucet;

    public CommandManager(final FaucetPlugin faucet){
        this.faucet = faucet;
    }

    private List<FaucetCommand> commands = new ArrayList<>();

    public void registerCommand(FaucetCommand command){
        commands.add(command);
        registerCommandAtServer(command);
        this.faucet.getLogger().info("Registered command " + command.getName().toUpperCase());

    }

    private void registerCommandAtServer(FaucetCommand command){
        try {
            final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");

            bukkitCommandMap.setAccessible(true);
            CommandMap commandMap = (CommandMap) bukkitCommandMap.get(this.faucet.getServer());

            commandMap.register(command.getName(), "faucet", new CommandBridge(command));
        } catch(NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
