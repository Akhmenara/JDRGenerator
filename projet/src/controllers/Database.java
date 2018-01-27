package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import models.Monstre;

public class Database {

	private static Connection dbConnection;
	
	public Database(){

		//----------------------------------------------
		// Connection to database at the object creation
		this.DBConnection();
		//----------------------------------------------
	}
	
	/**
	 * Connect to the database
	 */
	private void DBConnection(){
		
		// jdbc:mysql://<url>:<port>/<db_name>?useSSL=false
		String url = "jdbc:mysql://localhost:3306/jdrgenerator?useSSL=false";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Trying to connect...");
			dbConnection = DriverManager.getConnection(url, "root", "");			
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
				int[] stats = {result.getInt("for_monstre"), result.getInt("dex_monstre"), result.getInt("con_monstre"), 
						result.getInt("int_monstre"), result.getInt("sag_monstre"), result.getInt("cha_monstre")};
				
				// Var needed to be store in model
				// String size = result.getString("size");
				
				// Add new object Monstre to the list to be returned
				list.add(new Monstre(nom, stats));
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
				int[] stats = {result.getInt("for_monstre"), result.getInt("dex_monstre"), result.getInt("con_monstre"), 
						result.getInt("int_monstre"), result.getInt("sag_monstre"), result.getInt("cha_monstre")};
				
				// Var needed to be store in model
				// String size = result.getString("size");
				
				// Add new object Monstre to the list to be returned
				monstre = new Monstre(nom, stats);
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
				int[] stats = {result.getInt("for_monstre"), result.getInt("dex_monstre"), result.getInt("con_monstre"), 
						result.getInt("int_monstre"), result.getInt("sag_monstre"), result.getInt("cha_monstre")};
				
				// Var needed to be store in model
				// String size = result.getString("size");
				
				// Add new object Monstre to the list to be returned
				monstre = new Monstre(nomRet, stats);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return monstre;
	}
}
