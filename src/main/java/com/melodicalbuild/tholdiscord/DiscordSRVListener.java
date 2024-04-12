package com.melodicalbuild.tholdiscord;

import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.api.Subscribe;
import github.scarsz.discordsrv.api.events.DiscordReadyEvent;
import github.scarsz.discordsrv.dependencies.jda.api.entities.TextChannel;
import github.scarsz.discordsrv.util.DiscordUtil;
import org.bukkit.event.server.BroadcastMessageEvent;

public class DiscordSRVListener {

    private final THoLDiscord plugin;

    public DiscordSRVListener(THoLDiscord plugin) {
        this.plugin = plugin;
    }

    @Subscribe
    public void discordReadyEvent(DiscordReadyEvent event) {
        // Example of using JDA's events
        // We need to wait until DiscordSRV has initialized JDA, thus we're doing this inside DiscordReadyEvent
        DiscordUtil.getJda().addEventListener(new JDAListener(plugin));

        // ... we can also do anything other than listen for events with JDA now,
        plugin.getLogger().info("Chatting on Discord with " + DiscordUtil.getJda().getUsers().size() + " users!");
        // see https://ci.dv8tion.net/job/JDA/javadoc/ for JDA's javadoc
        // see https://github.com/DV8FromTheWorld/JDA/wiki for JDA's wiki
    }

    @Subscribe
    public void onBungeeCordAlert(BroadcastMessageEvent event) {
        TextChannel textChannel = DiscordSRV.getPlugin().getDestinationTextChannelForGameChannelName("announcements");

        if (textChannel != null) {
            textChannel.sendMessage(event.getMessage()).queue();
        } else {
            plugin.getLogger().warning("Channel called \"announcements\" could not be found in the DiscordSRV configuration");
        }
    }

}
