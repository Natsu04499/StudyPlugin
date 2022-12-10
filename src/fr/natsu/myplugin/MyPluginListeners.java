package fr.natsu.myplugin;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MyPluginListeners implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		player.getInventory().clear();
		player.getInventory().addItem(new ItemStack(Material.IRON_SWORD, 5));
		
		ItemStack customsword = new ItemStack(Material.FEATHER, 1);
		ItemMeta customM = customsword.getItemMeta();
		customM.setDisplayName("§4Activation Stand");
		customM.setLore(Arrays.asList("Cette objet contient la force de votre Stand","Activé le pour utiliser votre Stand","Son nom est Star Platinium"));
		customM.addEnchant(Enchantment.DURABILITY, 1000, true);
		customM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		customsword.setItemMeta(customM);
		
		
		player.getInventory().addItem(customsword);
		
		ItemStack customcompass = new ItemStack(Material.COMPASS, 1);
		ItemMeta customC = customcompass.getItemMeta();
		customC.setDisplayName("§aNavigation");
		customC.setLore(Arrays.asList("Ceci est un outils de navigation"));
		customC.addEnchant(Enchantment.DURABILITY, 1000, true);
		customC.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		customcompass.setItemMeta(customC);
		
		player.getInventory().setItem(4,customcompass);
		
		player.updateInventory();
	}
	
	@EventHandler
	public void onIntercat(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack it = event.getItem();
		
		if(it == null) return;
		
		if(it.getType() == Material.DIAMOND_HOE) {
			if(action == Action.RIGHT_CLICK_AIR) {
				player.sendMessage("Vous venez de faire un clique");
			}
		}
		
		if(it.getType() == Material.FEATHER && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§4Activation Stand")) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20 * 300, 3));
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 300, 3));
			player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20 * 300, 3));
			ItemStack customhead = new ItemStack(Material.BEDROCK);
			ItemMeta customH = customhead.getItemMeta();
			customH.setDisplayName("§cTête de Star Platinium");
			customH.addEnchant(Enchantment.DURABILITY, 1000, true);
			customH.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			customhead.setItemMeta(customH);
			player.getInventory().setHelmet(customhead);
		}
		
		if(it.getType() == Material.COMPASS && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§aNavigation")) {
			
			Inventory nav = Bukkit.createInventory(null, 45, "§8Menu de navigation");
			
			ItemStack UHC = new ItemStack(Material.GOLDEN_APPLE, 1);
			ItemMeta customUHC = UHC.getItemMeta();
			customUHC.setDisplayName("§eUHC");
			customUHC.setLore(Arrays.asList("Les UHC sont des combats endiablé","ou la stratégie et la ruse prime","prenez connaissance de votre rôle et élaborer"," des stratagème pour parvenir a vos fins","retrouvez JOJO UHC etc..."));
			customUHC.addEnchant(Enchantment.DURABILITY, 1000, true);
			customUHC.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			UHC.setItemMeta(customUHC);
			
			
			ItemStack Bed = new ItemStack(Material.BED, 1);
			ItemMeta customBed = Bed.getItemMeta();
			customBed.setDisplayName("§eBedwars");
			customBed.setLore(Arrays.asList("Protéger votre lit","contre les autres équipes","équiper vous et allez au combat","seul les plus fort gagnerons"));
			customBed.addEnchant(Enchantment.DURABILITY, 1000, true);
			customBed.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			Bed.setItemMeta(customBed);
			
			
			nav.setItem(11, UHC);
			nav.setItem(14, Bed);
			
			player.openInventory(nav);
			
		}
		
		
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		
		Inventory nav = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack current = event.getCurrentItem();
		
		if(current == null) return;
		
		
		if(nav.getName().equalsIgnoreCase("§8Menu de navigation")) {
			
			event.setCancelled(true);
			
			if(current.getType() == Material.GOLDEN_APPLE) {
				player.closeInventory();
				player.setGameMode(GameMode.ADVENTURE);
			}
			
		}
	}

}
