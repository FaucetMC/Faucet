package com.faucetmc.faucet.listener;

import com.faucetmc.faucet.FaucetPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class GodListener implements Listener {

    private final FaucetPlugin faucet;

    public GodListener(FaucetPlugin faucet){
        this.faucet = faucet;
    }

    @EventHandler
    public void onGetDamage(EntityDamageEvent event){
        if(event.getEntity() instanceof Player && event.getCause() != EntityDamageEvent.DamageCause.SUICIDE) {
            if(this.faucet.getGodManager().isGodMode(event.getEntity().getUniqueId())){
                event.setCancelled(true);
            }
        }
    }

}
