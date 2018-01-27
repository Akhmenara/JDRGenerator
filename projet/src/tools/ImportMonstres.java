package tools;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
 
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mysql.jdbc.Statement;
 
public class ImportMonstres {
	public static void main(String[] args) throws FileNotFoundException, JSONException {
		String jsonData = "";
		BufferedReader br = null;
		String url = "jdbc:mysql://localhost:3306/jdrgenerator?useSSL=false";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Trying to connect...");
			Connection connection = DriverManager.getConnection(url, "root", "");
			System.out.println("Connection established successfull");
					
			//--------------------------------------
			//Create the table to store the monsters
			Statement createTable = (Statement) connection.createStatement();
			createTable.executeUpdate("CREATE TABLE `monstres` (`id_monstre` int(11) NOT NULL, `nom_monstre` varchar(99) DEFAULT NULL, `taille_monstre` enum('Tiny','Small','Medium','Large','Huge','Gargantuan') NOT NULL, `for_monstre` int(11) DEFAULT NULL, `dex_monstre` int(11) DEFAULT NULL, `con_monstre` int(11) DEFAULT NULL, `int_monstre` int(11) DEFAULT NULL, `sag_monstre` int(11) DEFAULT NULL, `cha_monstre` int(11) DEFAULT NULL)");
			Statement primaryKey = (Statement) connection.createStatement();
			primaryKey.executeUpdate("ALTER TABLE `Monstres` ADD PRIMARY KEY (`id_monstre`);");
			Statement autoInc = (Statement) connection.createStatement();
			autoInc.executeUpdate("ALTER TABLE `Monstres` MODIFY `id_monstre` int(11) NOT NULL AUTO_INCREMENT;");
			//--------------------------------------			
			
			long debut = System.currentTimeMillis();
			String line;
			int nbLines = 0;
			br = new BufferedReader(new FileReader("./projet/src/tools/Monstres.json"));
			while ((line = br.readLine()) != null) {
				jsonData += line + "\n";
				nbLines++;
			}
			JSONArray arr = new JSONArray(jsonData);
			
			long fin = System.currentTimeMillis();
			long duree = fin-debut;
			System.out.println("JSONArray length : " + arr.length());
			
			/*
			<name>Goblin</name>
	        <size>S</size>
	        <str>8</str>
	        <dex>14</dex>
	        <con>10</con>
	        <int>10</int>
	        <wis>8</wis>
	        <cha>8</cha>
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
				
				insertInto.executeUpdate("INSERT INTO `monstres` (`id_monstre`, `nom_monstre`, `taille_monstre`, `for_monstre`, `dex_monstre`, `con_monstre`, `int_monstre`, `sag_monstre`, `cha_monstre`) VALUES (NULL, '" + name + "', '" + size + "', " + str + ", " + dex + ", " + con + ", " + intel + ", " + wis + ", " + cha + ");");
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