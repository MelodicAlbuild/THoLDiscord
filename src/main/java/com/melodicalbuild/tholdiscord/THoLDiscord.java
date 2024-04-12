package com.melodicalbuild.tholdiscord;

import com.melodicalbuild.tholcore.THoLCore;
import com.melodicalbuild.tholcore.plugin.Available.DiscordPlugin;
import github.scarsz.discordsrv.DiscordSRV;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class THoLDiscord extends JavaPlugin implements Listener {
    private DiscordSRVListener discordSRVListener = new DiscordSRVListener(this);

    @Override
    public void onEnable() {
        DiscordSRV.api.subscribe(discordSRVListener);
        getServer().getPluginManager().registerEvents(this, this);

        THoLCore.pluginManager.EnablePlugin(new DiscordPlugin("1.0", false));
    }

    @Override
    public void onDisable() {
        DiscordSRV.api.unsubscribe(discordSRVListener);
    }
}
