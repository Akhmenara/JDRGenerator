package models;
import java.util.Random;

public class De {
	/**
	 * Classe d'objet repr�sentant des d�s. On repr�sente es d�s comme suit : nombre suivit de "d" puis de valeur, o� nombre et valeur sont des entiers strictement positif.
	 *  exemple : 3d6 pour repr�sente 3 d�s � 6 faces. les d�s repr�sent�s sont mod�lis�s par des d�s partant de 1 et allant � leurs nombre de face (aka valeur).
	 *  
	 */
	private int nombre = 1;
	private int valeur = 1;
	private int resultat = 0;
	public De (String str) {
		String[] parametres = str.split("d");
		setNombre(Integer.parseInt(parametres[0]));
		setValeur(Integer.parseInt(parametres[1]));
		this.resultat = (int) ((1+this.getNombre()*this.getValeur())/2);
		
	}
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		assert (nombre > 0);
		this.nombre = nombre;
	}
	/**
	 * Permet de modifier le nombre de d�.
	 * @return
	 */
	public int getValeur() {
		return valeur;
	}
	/**
	 * Permet de modifier la valeur d'un d�. La valeur d'un d� �tant son nombre de face
	 * (les faces �tant num�rot� de 1 � valeur).
	 * @param valeur
	 */
	public void setValeur(int valeur) {
		assert (valeur > 0);
		this.valeur = valeur;
	}
	/**
	 * Permet d'acc�der � la valeur du d�s (
	 * @return
	 */
	public int getResultat() {
		return resultat;
	}
	
	//Permet de changer la valeur du r�sultat. Doit rester private.
	private void setResultat(int resultat) {
		assert (resultat >= valeur);
		this.resultat = resultat;
	}
	/**
	 * Lance le d�s et change la valeur du r�sultat.
	 */
	public void lancer() {
		int resultat = 0;
		Random alea = new Random();
		for(int i = 0; i<getNombre(); i++) {
			resultat += alea.nextInt(valeur)+1;
		}
		this.setResultat(resultat);
	}
	public De clone() {
		return new De(this.nombre+"d"+this.resultat);
	}
	
	public String toString() {
		return getNombre() + "d"+getValeur() + " =  " + getResultat();
	}
}
