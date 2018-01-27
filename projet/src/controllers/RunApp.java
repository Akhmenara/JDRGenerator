package controllers;

import views.Accueil;

public class RunApp {

	public static Database db;
	public static void main(String[] args) {
		Accueil test = new Accueil();
		test.afficher();
		
		// Initialize the connection to the database
		db = new Database();
		
		// Static call to the method
		System.out.println(Database.getAllMonsters());

	}

}
