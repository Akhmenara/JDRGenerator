package controllers;

import views.Accueil;

public class RunApp {

	public static Database db;
	public static void main(String[] args) {

		
		// Initialize the connection to the database
		db = new Database();
		
		Accueil test = new Accueil();
		test.afficher();

	}

}
