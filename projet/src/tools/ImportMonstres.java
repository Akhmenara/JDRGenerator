package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
 
import models.Paths;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mysql.jdbc.Statement;

/**
 * Class used to import monsters in DB from a json file
 * Run this file once to create the table and to fill it
 */
public class ImportMonstres {
	public static void main(String[] args) throws FileNotFoundException, JSONException {
		
		HashMap<String, String> logins = new HashMap<String, String>();
		
		BufferedReader brLogins = null;
		String lineLogins;
		String[] splitResultLogins = new String[2];
		try{
			brLogins = new BufferedReader(new FileReader(Paths.externalFiles + "logintodb.jdrg"));
			while ((lineLogins = brLogins.readLine()) != null) {
				splitResultLogins = lineLogins.split("=", 2);
				logins.put(splitResultLogins[0], splitResultLogins[1]);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if (brLogins != null)
					brLogins.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	
		String jsonData = "";
		BufferedReader br = null;
		String url = logins.get("url");
		String login = logins.get("login");
		String password = logins.get("password");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Trying to connect...");
			Connection connection = DriverManager.getConnection(url, login, password);
			System.out.println("Connection established successfull");
					
			//---------------------------------------
			// Create the table to store the monsters
			Statement createTable = (Statement) connection.createStatement();
			createTable.executeUpdate("CREATE TABLE `monstres` (`id_monstre` int(11) NOT NULL, `nom_monstre` varchar(99) DEFAULT NULL, `taille_monstre` enum('Tiny','Small','Medium','Large','Huge','Gargantuan') NOT NULL, `for_monstre` int(11) DEFAULT NULL, `dex_monstre` int(11) DEFAULT NULL, `con_monstre` int(11) DEFAULT NULL, `int_monstre` int(11) DEFAULT NULL, `sag_monstre` int(11) DEFAULT NULL, `cha_monstre` int(11) DEFAULT NULL)");
			Statement primaryKey = (Statement) connection.createStatement();
			primaryKey.executeUpdate("ALTER TABLE `Monstres` ADD PRIMARY KEY (`id_monstre`);");
			Statement autoInc = (Statement) connection.createStatement();
			autoInc.executeUpdate("ALTER TABLE `Monstres` MODIFY `id_monstre` int(11) NOT NULL AUTO_INCREMENT;");
			Statement addHP = (Statement) connection.createStatement();
			addHP.executeUpdate("ALTER TABLE `monstres` ADD `hp_monstre` VARCHAR(255) NULL DEFAULT NULL AFTER `cha_monstre`;");
			//---------------------------------------			
			
			long debut = System.currentTimeMillis();
			String line;
			int nbLines = 0;
			br = new BufferedReader(new FileReader(Paths.externalFiles + "Monstres.json"));
			while ((line = br.readLine()) != null) {
				jsonData += line + "\n";
				nbLines++;
			}
			JSONArray arr = new JSONArray(jsonData);
			
			long fin = System.currentTimeMillis();
			long duree = fin-debut;
			System.out.println("JSONArray length : " + arr.length());
			
			/*
			 * Exemple of datas extracted from the JSON file and stored in db
			 * {
			 *   "name": "Goblin",
			 *   "size": "Small",
			 *   "strength": 8,
			 *   "dexterity": 14,
			 *   "constitution": 10,
			 *   "intelligence": 10,
			 *   "wisdom": 8,
			 *   "charisma": 8
			 *   "hit_dice": "2d6"
			 * }
	         */
			int nbInsert = 0;
			Statement insertInto = (Statement) connection.createStatement();
			for(int i = 0 ; i < arr.length()-1 ; i++){
				JSONObject obj = arr.getJSONObject(i);
				String name = obj.getString("name");
				if(name.contains("'")){
					name = name.replace("'", " ");
				}
				String size = obj.getString("size");
				int str = obj.getInt("strength");
				int dex = obj.getInt("dexterity");
				int con = obj.getInt("constitution");
				int intel = obj.getInt("intelligence");
				int wis = obj.getInt("wisdom");
				int cha = obj.getInt("charisma");
				String hp = obj.getString("hit_dice");
				
				insertInto.executeUpdate("INSERT INTO `monstres` (`id_monstre`, `nom_monstre`, `taille_monstre`, `for_monstre`, `dex_monstre`, `con_monstre`, `int_monstre`, `sag_monstre`, `cha_monstre`, `hp_monstre`) VALUES (NULL, '" + name + "', '" + size + "', " + str + ", " + dex + ", " + con + ", " + intel + ", " + wis + ", " + cha + ", '" + hp + "');");
				nbInsert++;
			}
			
			System.out.println("Temps d'extraction de " + nbLines + " lignes du JSON et d'insertion de " + nbInsert + " lignes en BD : " + duree + "ms");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}