package Tiakin.config;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class folder {
	String file;
	String storagetype;
	String storagestring;
	Map<String, Object> storagemap;
	public folder(String pseudo,String storagetype, String storagestring)
	  {
	    this.file = pseudo ;
	    this.storagetype = storagetype;
	    this.storagestring = storagestring;
	  }
	public folder(String pseudo,String storagetype, Map<String, Object> storagemap)
	  {
	    this.file = pseudo ;
	    this.storagetype = storagetype;
	    this.storagemap = storagemap;
	  }
 public void setfolder() {
	 File pluginfile = new File("plugins/storage/"+file+".yml");
     if (!pluginfile.exists()){
         try {
        	 File dir = pluginfile.getParentFile();
         	 dir.mkdirs();
             pluginfile.createNewFile();
             if(storagetype != null) { 
             BufferedWriter bw = new BufferedWriter(new FileWriter(pluginfile));
             bw.write(storagetype+":");
             bw.write(" '"+storagestring+"'");
             bw.newLine();
             bw.flush();
             bw.close();
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
 }
 public void addinfolder() {
	 File pluginfile = new File("plugins/storage/"+file+".yml");
     if (pluginfile.exists()){
         try {
             BufferedWriter bw = new BufferedWriter(new FileWriter(pluginfile,true));
             bw.write(storagetype+":");
             bw.write(" '"+storagestring+"'");
             bw.newLine();
             bw.flush();
             bw.close();
             
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
 }
 public String readfolder() {
	 File pluginfile = new File("plugins/storage/"+file+".yml");
	 String azzs = null;
     if (pluginfile.exists()){
        	 YamlConfiguration myConfig = new YamlConfiguration();
     		try {
					myConfig.load(pluginfile);
					azzs = myConfig.getString(storagetype);
				} catch (IOException | InvalidConfigurationException e1) {
					e1.printStackTrace();
				}
     }
	return azzs;
 }
 public Map<String, Object> readfoldermap() {
	 File pluginfile = new File("plugins/storage/"+file+".yml");
	 Map<String, Object> azzs = null;
     if (pluginfile.exists()){
        	 YamlConfiguration myConfig = new YamlConfiguration();
     		try {
					myConfig.load(pluginfile);
					azzs = myConfig.getConfigurationSection(storagetype).getValues(false);
				} catch (IOException | InvalidConfigurationException e1) {
					e1.printStackTrace();
				}
     }
	return azzs;
 }
 public void editfolder() {
	 File pluginfile = new File("plugins/storage/"+file+".yml");
     if (pluginfile.exists()){
        	 YamlConfiguration myConfig = new YamlConfiguration();
     		try {
					myConfig.load(pluginfile);
					myConfig.set(storagetype, storagestring);
					myConfig.save(pluginfile);

				} catch (IOException | InvalidConfigurationException e1) {
					e1.printStackTrace();
				}
     }
 }
 public void editfoldermap() {
	 File pluginfile = new File("plugins/storage/"+file+".yml");
     if (pluginfile.exists()){
        	 YamlConfiguration myConfig = new YamlConfiguration();
     		try {
					myConfig.load(pluginfile);
					myConfig.createSection(storagetype, storagemap);
					myConfig.save(pluginfile);

				} catch (IOException | InvalidConfigurationException e1) {
					e1.printStackTrace();
				}
     }
 }
 public void removefolder() {
 File pluginfile = new File("plugins/storage/"+file+".yml");
 if (pluginfile.exists()){
    	 File dir = pluginfile.getParentFile();
     	 dir.mkdirs();
         pluginfile.delete();
  }
}
}
