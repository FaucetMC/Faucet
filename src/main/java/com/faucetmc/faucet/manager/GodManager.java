package com.faucetmc.faucet.manager;

import com.faucetmc.faucet.FaucetPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class GodManager {

    private final FaucetPlugin faucet;

    private final List<UUID> godModePlayers = new ArrayList<>();

    public GodManager(final FaucetPlugin faucet) {
        this.faucet = faucet;
    }

    public void enable(UUID uuid){
        this.godModePlayers.add(uuid);
    }

    public void disable(UUID uuid){
        this.godModePlayers.remove(uuid);
    }

    public boolean isGodMode(UUID uuid){
        return this.godModePlayers.contains(uuid);
    }

    public UUID[] getPlayers() {
        return godModePlayers.toArray(UUID[]::new);
    }

    public void toggle(UUID uuid){
        if(isGodMode(uuid)) {
            disable(uuid);
        } else {
            enable(uuid);
        }
    }


}
