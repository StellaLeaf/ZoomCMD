package io.stellaleaf.zoomcmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class zoomCMD extends JavaPlugin {
	JavaPlugin plugin;
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (args.length != 0) {
				Player p = Bukkit.getPlayer(args[0]);
				if(p == null){
					sender.sendMessage("[ZoomCMD] Could not find that playerID");
					return true;
				}
				try {
					int zoomLevel = Integer.parseInt(args[1]);
					if (zoomLevel >= 0) {
						p.removePotionEffect(PotionEffectType.SLOW);						
					}
					if (zoomLevel > 0) {
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20000, zoomLevel));
						return true;
					} else if (zoomLevel == 0) {
						return true;
					}
				} catch (NumberFormatException e) {
					sender.sendMessage("[ZoomCMD] /zoom <player> <zoomLevel>");
				}
		}
		sender.sendMessage("[ZoomCMD] /zoom <player> <zoomLevel>");
		return false;
	}
}