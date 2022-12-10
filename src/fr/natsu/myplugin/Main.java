package fr.natsu.myplugin;

import org.bukkit.event.server.ServiceRegisterEvent;
import org.bukkit.plugin.java.JavaPlugin;

import fr.natsu.myplugin.commands.CommandSpawn;
import fr.natsu.myplugin.commands.CommandTest;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		System.out.println("Le plugin viens de s'allummer !");
		getCommand("test").setExecutor(new CommandTest());
		getCommand("alert").setExecutor(new CommandTest());
		getCommand("spawn").setExecutor(new CommandSpawn());
		getServer().getPluginManager().registerEvents(new MyPluginListeners(), this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("Le plugin viens de s'arrêter");
	}

}
