package Tiakin.main;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import Tiakin.config.folder;





public class cmfr extends JavaPlugin implements Listener {

	folder z;
	public void onEnable() {
		 Bukkit.getPluginManager().registerEvents(this, this);
		 getCommand("staffmod").setExecutor(new commande());
		 getCommand("giveweapon").setExecutor(new commande());
		 getCommand("règles").setExecutor(new commande());
		 z = new folder("CMFR", null, "");
 	     if(z.readfolder() != null) {
    	 	 
 		 }else {
 			 z.setfolder();
 			 z = new folder("CMFR", "LobbyName", "lobby");
 			 z.addinfolder();
 			 z = new folder("CMFR", "LobbyXYZ", "0 79 0");
			 z.addinfolder();
			 z = new folder("CMFR", "SurvieName", "Survie_Beta");
 			 z.addinfolder();
 			 z = new folder("CMFR", "SurvieXYZ", "86 74 189");
			 z.addinfolder();
			 z = new folder("CMFR", "EndName", "Survie_Beta_the_end");
 			 z.addinfolder();
 			 z = new folder("CMFR", "EndXYZ", "0 74 0");
			 z.addinfolder();
 		 }
 	     
 	     
		 }

 @EventHandler
  public void onchat(AsyncPlayerChatEvent a) {
	 int Easter = new java.util.Random().nextInt(100) + 1;
	 if(Easter <= 5) {
		 send(a.getMessage().replace('"', '\''),a.getPlayer().getName()+", le patapouf", "https://minotar.net/cube/"+a.getPlayer().getName()+"/100.png");
	 }else {
  send(a.getMessage().replace('"', '\'').replace("@", "@ "),a.getPlayer().getName(), "https://minotar.net/helm/"+a.getPlayer().getName()+"/100.png");
	 }
 }	

  class JSONObject {

	    private final HashMap<String, Object> map = new HashMap<>();

	    void put(String key, Object value) {
	        if (value != null) {
	            map.put(key, value);
	        }
	    }

	    @Override
	    public String toString() {
	        StringBuilder builder = new StringBuilder();
	        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
	        builder.append("{");

	        int i = 0;
	        for (Map.Entry<String, Object> entry : entrySet) {
	            Object val = entry.getValue();
	            builder.append(quote(entry.getKey())).append(":");

	            if (val instanceof String) {
	                builder.append(quote(String.valueOf(val)));
	            } else if (val instanceof Integer) {
	                builder.append(Integer.valueOf(String.valueOf(val)));
	            } else if (val instanceof Boolean) {
	                builder.append(val);
	            } else if (val instanceof JSONObject) {
	                builder.append(val.toString());
	            } else if (val.getClass().isArray()) {
	                builder.append("[");
	                int len = Array.getLength(val);
	                for (int j = 0; j < len; j++) {
	                    builder.append(Array.get(val, j).toString()).append(j != len - 1 ? "," : "");
	                }
	                builder.append("]");
	            }

	            builder.append(++i == entrySet.size() ? "}" : ",");
	        }

	        return builder.toString();
	    }

	    private String quote(String string) {
	        return "\"" + string + "\"";
	    }
	}

  public void send(String content,String user,String link) {
	
    	JSONObject json = new JSONObject();
        json.put("content", content);
        json.put("username", user);
        json.put("avatar_url", link);
        
        
        URL url;
        HttpsURLConnection connection;
    try {
    	url = new URL("https://discordapp.com/api/webhooks/689970326053847046/bFmUSTGYTwigc81VXpdKbt3AY4k6hEStg1W9gSgPhtVOzzShsrpqPfYTNJQpCwO1BJwE");
    	connection = (HttpsURLConnection) url.openConnection();
        connection.addRequestProperty("Content-Type", "application/json");
        connection.addRequestProperty("User-Agent", "Java-DiscordWebhook-link_");
        connection.setDoOutput(true);
    try {
    	connection.setRequestMethod("POST");
    } catch (ProtocolException e) {
    	// TODO Auto-generated catch block
    	e.printStackTrace();
    }
    
        OutputStream stream;
    try {
    	stream = connection.getOutputStream();
    	stream.write(json.toString().getBytes());
    	stream.flush();
    	stream.close();
    	connection.getInputStream().close();
    } catch (IOException e) {
    	// TODO Auto-generated catch block
    	e.printStackTrace();
    }
    connection.disconnect();
    } catch (IOException e1) {
    	// TODO Auto-generated catch block
    	e1.printStackTrace();
    }
}

 @EventHandler
  public void onentityspawn(PlayerJoinEvent e){
     Player p = e.getPlayer();
     z = new folder("CMFR", "LobbyName", "");
     String lname = z.readfolder();
     z = new folder("CMFR", "LobbyXYZ", "");
     String[] lXYZ = z.readfolder().split(" ");
     p.teleport(new Location(Bukkit.getWorld(lname), Integer.parseInt(lXYZ[0]), Integer.parseInt(lXYZ[1]), Integer.parseInt(lXYZ[2])));
     p.teleport(new Location(Bukkit.getWorld(lname), Integer.parseInt(lXYZ[0]), Integer.parseInt(lXYZ[1]), Integer.parseInt(lXYZ[2])));
	 //premier join
     
     File pluginfile = new File("plugins/storage/player/"+p.getName()+".yml");
     if(!pluginfile.exists()){
      z = new folder("player/"+p.getName(), "money", "1000");
      z.setfolder();
     }
     
	 if(!p.hasPlayedBefore()) {
		 e.setJoinMessage(p.getName()+" vient de rejoindre pour la première fois ce mystérieux serveur. N'hésitez pas à l'aider en cas de problème !");
		 
	 } else {
	 // join message
		 int CustomByName = new java.util.Random().nextInt(10) + 1;
		 if(p.getName().equalsIgnoreCase("tiakin69") && CustomByName <= 4) {
			 
			 e.setJoinMessage("§8-->§4 Prévoyez de la redstone. §cTiakin §4vient de rejoindre le serveur !"); 
			 
		 }else if(p.getName().equalsIgnoreCase("Vallas") && CustomByName <= 4){	 
			 
			 e.setJoinMessage("§8-->§eLe seigneur Pégu §6Vallas §evient de rejoindre. faîtes lui des dons !");
			 
		 }else if((p.getName().equalsIgnoreCase("MisterXav5") || p.getName().equalsIgnoreCase("Ackerk")) && CustomByName <= 4){	 
			 
			 e.setJoinMessage("§8-->§eLe §4serveur §ea rejoint le serveur ... ah non c'est juste §c"+ p.getName());
			 
		 }else if(p.getName().equalsIgnoreCase("SuperNoobYT") && CustomByName <= 4){
			 
			 e.setJoinMessage("§8-->§7C'est §csuperman §7! Ah non c'est juste §cSuperNoob§8.");
			 
		 }else if(p.getName().equalsIgnoreCase("Lamatt2") && CustomByName <= 4){
			 
			 e.setJoinMessage("§8-->§7C'est vraiment §4Lamatt§7 qui a rejoint le serveur ? En espérant qu'il ne crash pas...");
			 
		 }else if(p.getName().equalsIgnoreCase("PulsI0") && CustomByName <= 4){
			 
			 e.setJoinMessage("§8-->§7Heyyyy, §4PulsI0§7 est la pour perdre son stuff !");
			 
		 }
		 
		 
		 else {
			 int message = new java.util.Random().nextInt(7) + 1;
			 if(message == 1) {
				 
				 e.setJoinMessage("§8-->Le §7Serveur §8a rejoint §7"+p.getName()+"§8 ... euh enfaîtes pas si sûr :/");
		 
			 }else if(message == 2) {
				 
				 e.setJoinMessage("§8-->Il est là, §l§9Herobrine ! §r§8ah non c'est §7"+p.getName()+"§8.");
		 
			 }else if(message == 3) {
				 
				 e.setJoinMessage("§8-->§r§lWoaw§r, §7mais qu'il est beau ! §8"+p.getName()+"§7 vient de se connecter au serveur !");
		 
			 }else if(message == 4) {
				 
				 e.setJoinMessage("§8-->§oÉtonnant.. §r§7"+p.getName()+"§8 a retrouvé son chemin !");
		 
			 }else if(message == 5) {
				 
				 e.setJoinMessage("§8-->§oMagnifique §r§7"+p.getName()+"§8 est apparu dans ce monde !");
		 
			 }else if(message == 6) {
				 
				 e.setJoinMessage("§8-->oh non §7"+p.getName()+"§8 est venu pour tout explosé !");
		 
			 }else if(message == 7) {
				 
				 e.setJoinMessage("§8-->C'est un §7enderman§8 ! Ah non c'est §7"+p.getName()+"§8 mais ne le regardez quand même pas dans les yeux !");
		 
			 }
		 }
    }
	 if(p.getName().equalsIgnoreCase("tiakin69"))
		 send("Oh wow ! C'est "+p.getName()+" qui est arrivé ! Mais quel rareté !", "arrivé", "https://cdn.discordapp.com/attachments/689970299441250304/690160545310965854/plus.png");
	 else 
		 send("Youpi ! "+p.getName()+" est arrivé !", "arrivé", "https://cdn.discordapp.com/attachments/689970299441250304/690160545310965854/plus.png");
     
	 if(p.getWorld().getName().equalsIgnoreCase(lname)) {
	  
	  p.getInventory().clear();
	  
	  ItemStack item1 = new ItemStack(Material.NAME_TAG, 1);
	    ItemMeta itemMeta1 = item1.getItemMeta();
	    itemMeta1.setDisplayName("§5Mode de jeux");
	    item1.setItemMeta(itemMeta1);
	  
	  p.getInventory().addItem(item1);
	  
  }
  }
 
 @EventHandler
  public void onplayeruse(PlayerInteractEvent e) {
	 Player p = e.getPlayer();
	 z = new folder("CMFR", "LobbyName", "");
	    if (p.getWorld().getName().equalsIgnoreCase(z.readfolder())) {
	    	if (p.getInventory().getItemInMainHand().getType() == Material.NAME_TAG) {
	    		 e.setCancelled(true);
	    		if(e.getAction() != Action.PHYSICAL) {
	            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
	            new inv("principal",p);
	    		}
	          }else if(p.getInventory().getItemInMainHand().getType() == Material.GOLDEN_HOE) {
	        	  if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction()== Action.RIGHT_CLICK_BLOCK) {
	        		  if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§4Pistolet"))
	        		  p.launchProjectile(Snowball.class);
	        	  }
	        	  
	          }
	    }
	
 }
 
 @EventHandler
  public void onentityleft(PlayerQuitEvent e){
	 Player p = e.getPlayer();
	 e.setQuitMessage("§8--> Oh non ! §7"+p.getName()+"§8 est parti !");
	 send("Oh non ! "+p.getName()+" est parti !", "départ", "https://cdn.discordapp.com/attachments/689970299441250304/690161184212516896/moins.png");
 }
 
 @EventHandler
  public void onentitygotoend(PlayerChangedWorldEvent e){
	 Player p = e.getPlayer();
	 z = new folder("CMFR", "EndName", "");
     String ename = z.readfolder();
     z = new folder("CMFR", "EndXYZ", "");
     String[] eXYZ = z.readfolder().split(" ");
	 if(p.getWorld().getName().equalsIgnoreCase(ename))
		 p.teleport(new Location(p.getWorld(), Integer.parseInt(eXYZ[0]), Integer.parseInt(eXYZ[1]), Integer.parseInt(eXYZ[2])));
 }

 @EventHandler 
  public void onInventoryClick(InventoryClickEvent e)
 {
	 Player p = (Player)e.getWhoClicked();
	 ItemStack clicked = e.getCurrentItem();
	 //Inventory inventory = e.getInventory();
	 InventoryView name = e.getView();
	 if (name.getTitle().equals("§eCMFR")) {
		 if (clicked.getType() == Material.GRASS_BLOCK) {
			 z = new folder("CMFR", "SurvieName", "");
		     String sname = z.readfolder();
		     z = new folder("CMFR", "SurvieXYZ", "");
		     String[] sXYZ = z.readfolder().split(" ");
			 p.teleport(new Location(Bukkit.getWorld(sname), Integer.parseInt(sXYZ[0]), Integer.parseInt(sXYZ[1]), Integer.parseInt(sXYZ[2])));
		 }
		 e.setCancelled(true);
	 }else if (name.getTitle().equals("§eRègles")) {
		 
		 p.openBook(null);
	 }
 }

@EventHandler
  public void OnDamage(EntityDamageByEntityEvent e) {
	if(e.getDamager() instanceof Snowball) {
		Snowball ball = (Snowball)e.getDamager();
		
		if(ball.getShooter() instanceof Player) {
			Player p = (Player) ball.getShooter();
			if(p.getInventory().getItemInMainHand().getType() == Material.GOLDEN_HOE) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§4Pistolet"))
				e.setDamage(5);
			}
		}
		
	}
}
}