package com.melodicalbuild.tholdiscord;

import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.dependencies.jda.api.entities.TextChannel;
import org.bukkit.plugin.java.JavaPlugin;

public class AnnounceEvent {
    private final JavaPlugin plugin;

    public AnnounceEvent(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void Announce(String message) {
        TextChannel textChannel = DiscordSRV.getPlugin().getDestinationTextChannelForGameChannelName("announcements");

        if (textChannel != null) {
            textChannel.sendMessage(message).queue();
        } else {
            plugin.getLogger().warning("Channel called \"announcements\" could not be found in the DiscordSRV configuration");
        }
    }
}
