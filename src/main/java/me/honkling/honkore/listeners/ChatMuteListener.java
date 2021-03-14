package me.honkling.honkore.listeners;

import me.honkling.honkore.Honkore;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatMuteListener implements Listener {

	private Honkore plugin;

	public ChatMuteListener(Honkore plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onChatMessage(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if(plugin.chatMuted && !p.hasPermission("honkore.bypasschatmute")) {
			e.setCancelled(true);
			p.sendMessage("§7Chat is currently muted.");
		}
	}

}
