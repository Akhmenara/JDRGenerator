package models;
import java.util.Random;

public class De {
	private int nombre;
	private int valeur;
	private int resultat;
	public De (String str) {
		String[] parametres = str.split("d");
		setNombre(Integer.parseInt(parametres[0]));
		setValeur(Integer.parseInt(parametres[1]));
		
	}
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public int getValeur() {
		return valeur;
	}
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	
	public int getResultat() {
		return resultat;
	}
	
	public void lancer() {
		resultat = 0;
		Random alea = new Random();
		for(int i = 0; i<getNombre(); i++) {
			resultat += alea.nextInt(valeur)+1;
		}
	}
}
