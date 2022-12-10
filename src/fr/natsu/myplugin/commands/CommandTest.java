package fr.natsu.myplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player)sender;
			
			if(cmd.getName().equalsIgnoreCase("test")) {
				player.sendMessage("§5Dédicace a Daniel_Furt le plus BG des players MC !");
				return true;
			}
			
			if(cmd.getName().equalsIgnoreCase("alert")) {
				
				if(args.length == 0) {
					player.sendMessage("La commande est : /alert <message>");
				}
				
				if(args.length >= 1) {
					
					StringBuilder bc = new StringBuilder();
					for(String part : args) {
						bc.append(part + " ");
					}
					
					Bukkit.broadcastMessage("[" + player.getName() + "] " + bc.toString());
					
				}
				
				return true;
			}
				
				
		}
		
		
		return false;
	}

}
