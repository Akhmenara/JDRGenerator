package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.jdbc.Statement;

import models.De;
import models.Monstre;
import models.Paths;

public class Database {

	private static Connection dbConnection;
	
	public Database(){
	}
	
	public static void createDatabase(){

		//----------------------------------------------
		// Connection to database at the object creation
		Database.DBConnection(Database.getLogin());
		//----------------------------------------------
	}
	
	/**
	 * Extract url, login and password from a external file
	 * @return A HashMap containing the connection informations
	 */
	private static HashMap<String, String> getLogin(){
		HashMap<String, String> logins = new HashMap<String, String>();

		System.out.println(new File(".").getAbsoluteFile());
		
		BufferedReader br = null;
		String line;
		String[] splitResult = new String[2];
		try{
			br = new BufferedReader(new FileReader(Paths.externalFiles + "logintodb.jdrg"));
			while ((line = br.readLine()) != null) {
				splitResult = line.split("=", 2);
				logins.put(splitResult[0], splitResult[1]);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		return logins;
	}
	
	/**
	 * Connect to the database
	 */
	private static void DBConnection(HashMap<String, String> logins){
		
		// jdbc:mysql://<url>:<port>/<db_name>?useSSL=false
		String url = logins.get("url");
		String login = logins.get("login");
		String password = logins.get("password");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Trying to connect...");
			dbConnection = DriverManager.getConnection(url, login, password);			
			System.out.println("Connection Established Successfull");						
		} catch (Exception e) {
			// The connection failed
			System.out.println("Unable to connect to the DB");
			e.printStackTrace();
		}
	}
	
	/**
	 * Ask database to get the list of all the monsters
	 * @return An ArrayList of all the monsters
	 */
	public static ArrayList<Monstre> getAllMonsters(){
		ArrayList<Monstre> list = new ArrayList<Monstre>();
		
		try {
			Statement statement = (Statement) dbConnection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Monstres");
			
			// Browse all results of the query
			while(result.next()){
				// Name of the monster
				String nom = result.getString("nom_monstre");
				
				// Stats of the monster
				String[] statsStr = {result.getString("for_monstre"), result.getString("dex_monstre"), result.getString("con_monstre"), 
						result.getString("int_monstre"), result.getString("sag_monstre"), result.getString("cha_monstre")};
				
				int[] stats = new int[statsStr.length];
				
				for(int i = 0 ; i < statsStr.length ; i++){
					if(statsStr[i].contains("-")){
						statsStr[i].replace('-', '0');
					}
					stats[i] = Integer.parseInt(statsStr[i]);
				}
				
				// Var needed to be store in model
				// String size = result.getString("size");
				
				// Add new object Monstre to the list to be returned
				list.add(new Monstre(nom, stats, new De(result.getString("hp_monstre"))));
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}
	
	/**
	 * Ask database to get one monster by his id
	 * @return A Monstre object
	 */
	public static Monstre getMonsterById(int id){
		Monstre monstre = null;

		try {
			Statement statement = (Statement) dbConnection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Monstres WHERE id_monstre = '" + id + "'");
			
			// Browse all results of the query
			while(result.next()){
				// Name of the monster
				String nom = result.getString("nom_monstre");
				
				// Stats of the monster
				String[] statsStr = {result.getString("for_monstre"), result.getString("dex_monstre"), result.getString("con_monstre"), 
						result.getString("int_monstre"), result.getString("sag_monstre"), result.getString("cha_monstre")};
				
				int[] stats = new int[statsStr.length];
				
				for(int i = 0 ; i < statsStr.length ; i++){
					if(statsStr[i].contains("-")){
						statsStr[i].replace('-', '0');
					}
					stats[i] = Integer.parseInt(statsStr[i]);
				}
				
				// Var needed to be store in model
				// String size = result.getString("size");
				
				// Add new object Monstre to the list to be returned
				monstre = new Monstre(nom, stats, new De(result.getString("hp_monstre")));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return monstre;
	}
	/**
	 * Ask database to get one monster by his name
	 * @return A Monstre object
	 */
	public static Monstre getMonsterByName(String nom){
		Monstre monstre = null;
		if(nom.contains("'")){
			nom.replace("'", " ");
		}
		try {
			Statement statement = (Statement) dbConnection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Monstres WHERE nom_monstre = '" + nom + "'");
			
			// Browse all results of the query
			while(result.next()){
				// Name of the monster
				String nomRet = result.getString("nom_monstre");
				
				// Stats of the monster
				String[] statsStr = {result.getString("for_monstre"), result.getString("dex_monstre"), result.getString("con_monstre"), 
						result.getString("int_monstre"), result.getString("sag_monstre"), result.getString("cha_monstre")};
				
				int[] stats = new int[statsStr.length];
				
				for(int i = 0 ; i < statsStr.length ; i++){
					if(statsStr[i].contains("-")){
						statsStr[i].replace('-', '0');
					}
					stats[i] = Integer.parseInt(statsStr[i]);
				}				
				// Var needed to be store in model
				// String size = result.getString("size");
				
				// Add new object Monstre to the list to be returned
				monstre = new Monstre(nomRet, stats, new De(result.getString("hp_monstre")));
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return monstre;
	}
}
