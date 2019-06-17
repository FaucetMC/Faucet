package com.faucetmc.faucet;

import com.faucetmc.faucet.manager.GodManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class FaucetPlugin extends JavaPlugin {

    @Getter
    private GodManager godManager;

    public void onEnable(){
        this.godManager = new GodManager(this);
    }

    public void onDisable(){

    }

}
