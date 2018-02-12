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

import com.mysql.jdbc.PreparedStatement;
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
			createTable.executeUpdate("CREATE OR REPLACE TABLE `monstres` " +
					"(`id_monstre` int(11) NOT NULL, `str_monstre` varchar(255) DEFAULT NULL, " +
					"`dex_monstre` varchar(255) DEFAULT NULL, `con_monstre` varchar(255) DEFAULT NULL, " +
					"`int_monstre` varchar(255) DEFAULT NULL, `sag_monstre` varchar(255) DEFAULT NULL, " +
					"`cha_monstre` varchar(255) DEFAULT NULL, `name_monstre` varchar(255) DEFAULT NULL, " +
					"`hp_monstre` varchar(255) DEFAULT NULL, `vig_monstre` varchar(255) DEFAULT NULL, " +
					"`ref_monstre` varchar(255) DEFAULT NULL, `vol_monstre` varchar(255) DEFAULT NULL)");
			Statement primaryKey = (Statement) connection.createStatement();
			primaryKey.executeUpdate("ALTER TABLE `monstres` ADD PRIMARY KEY (`id_monstre`)");
			Statement autoInc = (Statement) connection.createStatement();
			autoInc.executeUpdate("ALTER TABLE `monstres` MODIFY `id_monstre` int(11) NOT NULL AUTO_INCREMENT");
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
			
			System.out.println("JSONArray length : " + arr.length());
			
			/*
			 * Example of datas extracted from the JSON file and stored in db
			 * {
			 *  "Name":"Goblin",
			 *  "Str":11,
			 *  "Dex":15,
			 *	"Con":"12",
			 *	"Int":"10",
			 *	"Wis":9,
			 *	"Cha":6,
			 *  "HD":"1d10+1",
			 *	"Fort":3,
			 *	"Ref":2,
			 *	"Will":-1,
			 * }
	         */
			int nbInsert = 0;
			Statement insertInto = (Statement) connection.createStatement();
			for(int i = 0 ; i < arr.length() ; i++){
				JSONObject obj = arr.getJSONObject(i);
				String name = obj.getString("Name");
				if(name.contains("'")){
					name = name.replace("'", " ");
				}
				String str = obj.get("Str").toString();
				String dex = obj.get("Dex").toString();
				
				String con = obj.get("Con").toString();
				String intel = obj.get("Int").toString();
				String wis = obj.get("Wis").toString();
				String cha = obj.get("Cha").toString();
				String hp = obj.getString("HD").toString();
				String fort = obj.get("Fort").toString();
				String ref = obj.get("Ref").toString();
				String will = obj.get("Will").toString();
				
				
				String insertQuery = "INSERT INTO `monstres`(`str_monstre`, `dex_monstre`, `con_monstre`, `int_monstre`, `sag_monstre`, `cha_monstre`, `name_monstre`, `hp_monstre`, `vig_monstre`, `ref_monstre`, `vol_monstre`) " +
						"VALUES (?,?,?,?,?,?,?,?,?,?,?)";
				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(insertQuery);
				preparedStatement.setString(1, str);
				preparedStatement.setString(2, dex);
				preparedStatement.setString(3, con);
				preparedStatement.setString(4, intel);
				preparedStatement.setString(5, wis);
				preparedStatement.setString(6, cha);
				preparedStatement.setString(7, name);
				preparedStatement.setString(8, hp);
				preparedStatement.setString(9, fort);
				preparedStatement.setString(10, ref);
				preparedStatement.setString(11, will);
				preparedStatement.executeUpdate();
				
				nbInsert++;
			}
			long fin = System.currentTimeMillis();
			long duree = fin-debut;
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