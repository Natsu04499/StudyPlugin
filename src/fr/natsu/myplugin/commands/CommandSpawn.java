package fr.natsu.myplugin.commands;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		
		if(sender instanceof Player) {
			
			Random random = new Random();
			Player player = (Player) sender;
			Location ploc = player.getLocation();
			
			Location spawn = new Location(player.getWorld(), ploc.getX() + random.nextInt(500), ploc.getY(), ploc.getZ() - random.nextInt(500), 177.2f, 2.1f );
			player.sendMessage("§4Vous vous téléportez !");
			player.teleport(spawn);
		}
		
		return false;
	}

}
