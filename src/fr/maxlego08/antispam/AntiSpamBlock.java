package fr.maxlego08.antispam;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiSpamBlock extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBlockPlace(BlockPlaceEvent event) {

		if (event.isCancelled()) {

			Player player = event.getPlayer();
			Block block = event.getBlock().getRelative(BlockFace.DOWN);

			if (block.getType().equals(Material.AIR)) {

				Location location = block.getLocation();
				location.add(0.5, 0, 0.5);
				location.setYaw(player.getLocation().getYaw());
				location.setPitch(player.getLocation().getPitch());
				player.teleport(location);

			}

		}

	}

}
