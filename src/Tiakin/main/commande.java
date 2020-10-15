package Tiakin.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Tiakin.config.IS;
import Tiakin.config.folder;

public class commande implements  CommandExecutor, Listener {
	folder z;
	String empty = null;
public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args)	{
	
    if (sender instanceof Player) { 
    Player p = (Player) sender;
    
    if (cmd.getName().equalsIgnoreCase("giveweapon")) {
    	if(p.hasPermission("CMFR.giveweapon")) {
    		ItemStack item = new ItemStack(Material.GOLDEN_HOE, 1);
	        ItemMeta itemmeta = item.getItemMeta();
	        itemmeta.setDisplayName("§4Pistolet");	    
	        item.setItemMeta(itemmeta);
	        
    		if(args.length == 0) {
    	    p.getInventory().addItem(item);
    		}else {
    		Bukkit.getPlayer(args[0]).getInventory().addItem(item);
    		}
    }
    	
    }else if(cmd.getName().equalsIgnoreCase("staffmod")) {
    	if(p.hasPermission("CMFR.staffmod")) {
    		     
    		z = new folder("player/"+p.getName(), p.getWorld().getName()+".staffmod", "false");
    		if(z.readfolder() != null) {
       		    	  
    		}else {
    			z.addinfolder();
    		}
    	
    	z = new folder("player/"+p.getName(), p.getWorld().getName()+".staffmod", empty);
    	if(z.readfolder().equalsIgnoreCase("true")) {
    		
    		p.getInventory().clear();
    		ItemStack[] inv = new ItemStack[36];
    		for(int n = 0; n < 36;) {
    			z = new folder("player/"+p.getPlayer().getName(), p.getWorld().getName()+".slot."+n, empty);
    			if(!z.readfolder().equalsIgnoreCase("null"))
    			inv[n] = IS.deserialize(z.readfoldermap());
    			else
    				inv[n] = null;
    			n++;	
    			}
    			p.getInventory().setStorageContents(inv);
    			ItemStack[] armor = new ItemStack[4];
    		for(int n = 0; n < 4;) {
    			z = new folder("player/"+p.getPlayer().getName(), p.getWorld().getName()+".armorslot."+n, empty);
    			if(!z.readfolder().equalsIgnoreCase("null"))
    				armor[n] = IS.deserialize(z.readfoldermap());
    			else
    				armor[n] = null;
		        n++;
		        }
    		p.getInventory().setArmorContents(armor);
    		
    		z = new folder("player/"+p.getPlayer().getName(), p.getWorld().getName()+".offslot", empty);
			if(!z.readfolder().equalsIgnoreCase("null"))
				p.getInventory().setItemInOffHand(IS.deserialize(z.readfoldermap()));
    		
    		z = new folder("player/"+p.getName(), p.getWorld().getName()+".staffmod", "false");
    		z.editfolder();
    		
    		
    	}else if(z.readfolder().equalsIgnoreCase("false")) {
    		
    		
    		for(int n = 0; n < 36;) {
    			if(p.getInventory().getStorageContents()[n] != null) {
    				z = new folder("player/"+p.getPlayer().getName(), p.getWorld().getName()+".slot."+n, IS.serialize(p.getInventory().getStorageContents()[n]));
    				z.editfoldermap();
    			} else {
    				z = new folder("player/"+p.getPlayer().getName(), p.getWorld().getName()+".slot."+n, "null");
    				if(z.readfolder()!=null)
			    		z.editfolder();
			    	else
			    		z.addinfolder();
    		  }
    			n++;
    		}
    		
    		for(int n = 0; n < 4;) {
    			if(p.getInventory().getArmorContents()[n] != null) {
    				z = new folder("player/"+p.getPlayer().getName(), p.getWorld().getName()+".armorslot."+n, IS.serialize(p.getInventory().getArmorContents()[n]));
    				z.editfoldermap();  
    			} else {
    				z = new folder("player/"+p.getPlayer().getName(), p.getWorld().getName()+".armorslot."+n, "null");
    				if(z.readfolder()!=null)
			    		z.editfolder();
			    	else
			    		z.addinfolder();
    		  }
    			n++;
    	    }
    		    
			    if(p.getInventory().getItemInOffHand() != null || p.getInventory().getItemInOffHand().getType() != Material.AIR) {
			    	z = new folder("player/"+p.getPlayer().getName(), p.getWorld().getName()+".offslot", IS.serialize(p.getInventory().getItemInOffHand()));
			        z.editfoldermap();
			    } else {
			    	z = new folder("player/"+p.getPlayer().getName(), p.getWorld().getName()+".offslot", "null");
			    	if(z.readfolder()!=null)
			    		z.editfolder();
			    	else
			    		z.addinfolder();
			    }
    		p.getInventory().clear();
    		z = new folder("player/"+p.getName(), p.getWorld().getName()+".staffmod", "true");
    		z.editfolder();
    		
    		
    		ItemStack vanish = new ItemStack(Material.GRASS_BLOCK, 1);
	        ItemMeta Surviemeta = vanish.getItemMeta();
	        Surviemeta.setDisplayName(ChatColor.DARK_GREEN+"test !");	    
	        vanish.setItemMeta(Surviemeta);
    		
    		p.getInventory().addItem(vanish);
    		
    	}
      }
     }else if(cmd.getName().equalsIgnoreCase("rules")) {
    	 new inv("rules",p);
     }
    }
	return false;
  }
}
