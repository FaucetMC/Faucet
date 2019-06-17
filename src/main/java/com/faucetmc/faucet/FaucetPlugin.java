package com.faucetmc.faucet;

import com.faucetmc.faucet.manager.ChatManager;
import com.faucetmc.faucet.manager.GodManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class FaucetPlugin extends JavaPlugin {

    @Getter
    private GodManager godManager;

    @Getter
    private ChatManager chatManager;

    public void onEnable(){
        this.chatManager = new ChatManager(this);
        this.godManager = new GodManager(this);
    }

    public void onDisable(){

    }

}
