package controllers;

import views.Accueil;
import views.FenetreAccueil;

public class RunApp {

	public static void main(String[] args) {
		
		// Initialize the connection to the database
		Database.createDatabase();
		
		Accueil test = new Accueil();
		System.out.println("Accueil fait");
		test.setVisible(true);

	}

}
