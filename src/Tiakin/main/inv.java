package Tiakin.main;



import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
 
public class inv {
	
	public inv(String name,Player p) {
		
		if(name.equalsIgnoreCase("principal")) {
			
			Inventory Inventorymenu = Bukkit.createInventory(null, 27, "§eCMFR");
			
		    ItemStack deco1 = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
	        ItemMeta itemMetaDeco1 = deco1.getItemMeta();
	        itemMetaDeco1.setDisplayName(" ");	    
	        deco1.setItemMeta(itemMetaDeco1);
	        
	        ItemStack deco2 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
	        ItemMeta itemMetaDeco2 = deco2.getItemMeta();
	        itemMetaDeco2.setDisplayName(" ");	    
	        deco2.setItemMeta(itemMetaDeco2);
	        
	        ItemStack deco3 = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
	        ItemMeta itemMetaDeco3 = deco3.getItemMeta();
	        itemMetaDeco3.setDisplayName(" ");	    
	        deco3.setItemMeta(itemMetaDeco3);
	        
	        ItemStack PvpBox = new ItemStack(Material.BOW, 1);
	        ItemMeta PvpBoxmeta = PvpBox.getItemMeta();
	        PvpBoxmeta.setDisplayName("§4 PAS ENCORE DISPONIBLE");	    
	        PvpBox.setItemMeta(PvpBoxmeta);
	        
	        ItemStack Survie = new ItemStack(Material.GRASS_BLOCK, 1);
	        ItemMeta Surviemeta = Survie.getItemMeta();
	        Surviemeta.setDisplayName(ChatColor.DARK_GREEN+"Survie");	    
	        Survie.setItemMeta(Surviemeta);
	        
	        ItemStack MiniJeux = new ItemStack(Material.GOLDEN_APPLE, 1);
	        ItemMeta MiniJeuxmeta = MiniJeux.getItemMeta();
	        MiniJeuxmeta.setDisplayName("§4 PAS ENCORE DISPONIBLE");	    
	        MiniJeux.setItemMeta(MiniJeuxmeta);
	        
	        Inventorymenu.setItem(0, deco1);
	        Inventorymenu.setItem(1, deco1);
	        Inventorymenu.setItem(2, deco2);
	        Inventorymenu.setItem(3, deco1);
	        Inventorymenu.setItem(4, deco2);
	        Inventorymenu.setItem(5, deco1);
	        Inventorymenu.setItem(6, deco2);
	        Inventorymenu.setItem(7, deco1);
	        Inventorymenu.setItem(8, deco1);
	        
	        Inventorymenu.setItem(9, deco1);
	        Inventorymenu.setItem(10, deco2);
	        Inventorymenu.setItem(11, PvpBox);
	        Inventorymenu.setItem(12, deco3);
	        Inventorymenu.setItem(13, Survie);
	        Inventorymenu.setItem(14, deco3);
	        Inventorymenu.setItem(15, MiniJeux);
	        Inventorymenu.setItem(16, deco2);
	        Inventorymenu.setItem(17, deco1);
	        
	        Inventorymenu.setItem(18, deco1);
	        Inventorymenu.setItem(19, deco1);
	        Inventorymenu.setItem(20, deco2);
	        Inventorymenu.setItem(21, deco1);
	        Inventorymenu.setItem(22, deco2);
	        Inventorymenu.setItem(23, deco1);
	        Inventorymenu.setItem(24, deco2);
	        Inventorymenu.setItem(25, deco1);
	        Inventorymenu.setItem(26, deco1);
	        
	        p.openInventory(Inventorymenu);
		}else if(name.equalsIgnoreCase("rules")) {
			
			Inventory Inventorymenu = Bukkit.createInventory(null, 36, "§eRègles");
			
		    ItemStack deco1 = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
	        ItemMeta itemMetaDeco1 = deco1.getItemMeta();
	        itemMetaDeco1.setDisplayName(" ");	    
	        deco1.setItemMeta(itemMetaDeco1);
	        
	        ItemStack deco2 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
	        ItemMeta itemMetaDeco2 = deco2.getItemMeta();
	        itemMetaDeco2.setDisplayName(" ");	    
	        deco2.setItemMeta(itemMetaDeco2);
	        
	        ItemStack deco3 = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
	        ItemMeta itemMetaDeco3 = deco3.getItemMeta();
	        itemMetaDeco3.setDisplayName(" ");	    
	        deco3.setItemMeta(itemMetaDeco3);
	        
	       
	        ItemStack cancel = new ItemStack(Material.BARRIER, 1);
	        ItemMeta itemMetacancel = cancel.getItemMeta();
	        itemMetacancel.setDisplayName("§cQuitter");
	        itemMetacancel.setLore(Arrays.asList("§5Cliquez ici pour fermer le menu !"));
	        cancel.setItemMeta(itemMetacancel);
	        
	        ItemStack livre = new ItemStack(Material.BOOK, 1);
	        ItemMeta itemMetaLivre = livre.getItemMeta();
	        
	        Inventorymenu.setItem(0, deco3);
	        Inventorymenu.setItem(1, deco3);
	        Inventorymenu.setItem(2, deco3);
	        Inventorymenu.setItem(3, deco3);
	        Inventorymenu.setItem(4, deco3);
	        Inventorymenu.setItem(5, deco3);
	        Inventorymenu.setItem(6, deco3);
	        Inventorymenu.setItem(7, deco3);
	        Inventorymenu.setItem(8, deco3);
	        
	        itemMetaLivre.setDisplayName("- => §c(✘) §7Le cheat");
	        itemMetaLivre.setLore(Arrays.asList("§5Cliquez ici pour ouvrir cette page de règle !"));
	        livre.setItemMeta(itemMetaLivre);
	        Inventorymenu.setItem(9,  livre);
	        
	        itemMetaLivre.setDisplayName("- => §c(✘)§7La duplication");
	        itemMetaLivre.setLore(Arrays.asList("§5Cliquez ici pour ouvrir cette page de règle !"));
	        livre.setItemMeta(itemMetaLivre);
	        Inventorymenu.setItem(10, livre);
	        
	        itemMetaLivre.setDisplayName("- => §c(✘) §7Le grief");
	        itemMetaLivre.setLore(Arrays.asList("§5Cliquez ici pour ouvrir cette page de règle !"));
	        livre.setItemMeta(itemMetaLivre);
	        Inventorymenu.setItem(11, livre);
	        
	        itemMetaLivre.setDisplayName("- => §c(✘) §7Les arnaques");
	        itemMetaLivre.setLore(Arrays.asList("§5Cliquez ici pour ouvrir cette page de règle !"));
	        livre.setItemMeta(itemMetaLivre);
	        Inventorymenu.setItem(12, livre);
	        
	        itemMetaLivre.setDisplayName("- => §c(✘) §7La toxicité");
	        itemMetaLivre.setLore(Arrays.asList("§5Cliquez ici pour ouvrir cette page de règle !"));
	        livre.setItemMeta(itemMetaLivre);
	        Inventorymenu.setItem(13, livre);
	        
	        itemMetaLivre.setDisplayName("- => §c(✘) §7Sujets sensible");
	        itemMetaLivre.setLore(Arrays.asList("§5Cliquez ici pour ouvrir cette page de règle !"));
	        livre.setItemMeta(itemMetaLivre);
	        Inventorymenu.setItem(14, livre);
	        
	        itemMetaLivre.setDisplayName("- => §c(✘) §7La descrimination");
	        itemMetaLivre.setLore(Arrays.asList("§5Cliquez ici pour ouvrir cette page de règle !"));
	        livre.setItemMeta(itemMetaLivre);
	        Inventorymenu.setItem(15, livre);
	        
	        itemMetaLivre.setDisplayName("- => §c(✘) §7Les menaces");
	        itemMetaLivre.setLore(Arrays.asList("§5Cliquez ici pour ouvrir cette page de règle !"));
	        livre.setItemMeta(itemMetaLivre);
	        Inventorymenu.setItem(16, livre);
	        
	        itemMetaLivre.setDisplayName("- => §c(✘) §7Les messages indésirables");
	        itemMetaLivre.setLore(Arrays.asList("§5Cliquez ici pour ouvrir cette page de règle !"));
	        livre.setItemMeta(itemMetaLivre);
	        Inventorymenu.setItem(17, livre);
	        
	        
	        Inventorymenu.setItem(18, deco1);
	        Inventorymenu.setItem(19, deco2);
	        Inventorymenu.setItem(20, deco2);
	        
	        itemMetaLivre.setDisplayName("- => §e(✦) §7La publicité");
	        itemMetaLivre.setLore(Arrays.asList("§dCette page demeure précis il est donc conseillé de le regardé."));
	        livre.setItemMeta(itemMetaLivre);
	        Inventorymenu.setItem(21, livre);
	        
	        itemMetaLivre.setDisplayName("- => §e(✦) §7Liste non exhaustif");
	        itemMetaLivre.setLore(Arrays.asList("§dCette page demeure précis il est donc conseillé de le regardé."));
	        livre.setItemMeta(itemMetaLivre);
	        Inventorymenu.setItem(22, livre);
	        
	        itemMetaLivre.setDisplayName("- => §e(✦) §7En ce qui concerne le staff");
	        itemMetaLivre.setLore(Arrays.asList("§dCette page demeure précis il est donc conseillé de le regardé."));
	        livre.setItemMeta(itemMetaLivre);
	        Inventorymenu.setItem(23, livre);
	        
	        Inventorymenu.setItem(24, deco2);
	        Inventorymenu.setItem(25, deco2);
	        Inventorymenu.setItem(26, deco1);
	        
	        Inventorymenu.setItem(27, deco1);
	        Inventorymenu.setItem(28, deco1);
	        Inventorymenu.setItem(29, deco1);
	        Inventorymenu.setItem(30, deco1);
	        Inventorymenu.setItem(31, cancel);
	        Inventorymenu.setItem(32, deco1);
	        Inventorymenu.setItem(33, deco1);
	        Inventorymenu.setItem(34, deco1);
	        Inventorymenu.setItem(35, deco1);
	        
	        p.openInventory(Inventorymenu);
		}
		
	}
}
