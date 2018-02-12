package models;
import java.util.Random;

public class De {
	/**
	 * Classe d'objet représentant des dés. On représente es dés comme suit : nombre suivit de "d" puis de valeur, où nombre et valeur sont des entiers strictement positif.
	 *  exemple : 3d6 pour représente 3 dés à 6 faces. les dés représentés sont modélisés par des dés partant de 1 et allant à leurs nombre de face (aka valeur).
	 *  
	 */
	private int nombre = 1;
	private int valeur = 1;
	private int resultat = 0;
	private int bonus = 0;
	public De (String str) {
		str = str.split("P")[0];
		int indice = Integer.max(str.indexOf("+"),str.indexOf("-"));
		int bonus;
		String[] parametres;
		if (indice > -1) {
			parametres = str.substring(0,indice).split("d");
			setNombre(Integer.parseInt(parametres[0]));
			setValeur(Integer.parseInt(parametres[1]));
			bonus = Integer.parseInt(str.substring(indice+1));
		}else {
			parametres = str.split("d");
			setNombre(Integer.parseInt(parametres[0]));
			setValeur(Integer.parseInt(parametres[1]));
			bonus = 0;
		}
		setNombre(Integer.parseInt(parametres[0]));
		setValeur(Integer.parseInt(parametres[1]));
		setBonus(bonus);
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
	 * Permet de modifier le nombre de dé.
	 * @return
	 */
	public int getValeur() {
		return valeur;
	}
	/**
	 * Permet de modifier la valeur d'un dé. La valeur d'un dé étant son nombre de face
	 * (les faces étant numéroté de 1 à valeur).
	 * @param valeur
	 */
	public void setValeur(int valeur) {
		assert (valeur > 0);
		this.valeur = valeur;
	}
	/**
	 * Permet d'accéder à la valeur du dés (
	 * @return
	 */
	public int getResultat() {
		return resultat;
	}
	
	//Permet de changer la valeur du résultat. Doit rester private.
	private void setResultat(int resultat) {
		assert (resultat >= valeur);
		this.resultat = resultat;
	}
	
	private int getBonus() {
		return this.bonus;
	}
	
	private void setBonus(int bonus) {
		this.bonus = bonus;
	}
	/**
	 * Lance le dés et change la valeur du résultat.
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
