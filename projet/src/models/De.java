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
	private int bonus = 0;
	private De[] deBonus = null;
	public De (String str) {
		str = str.split(" ")[0];
		if (str.contains("d")) {
			String[] arguments = str.split("\\+");
			int indice = arguments[0].indexOf("-");
			String bonus;
			String[] parametres;
			if (indice > -1) {
				parametres = arguments[0].substring(0,indice).split("d");
				setNombre(Integer.parseInt(parametres[0]));
				setValeur(Integer.parseInt(parametres[1]));
				bonus = arguments[0].substring(indice+1);
			}else {
				parametres = arguments[0].split("d");
				setNombre(Integer.parseInt(parametres[0]));
				setValeur(Integer.parseInt(parametres[1]));
				bonus = null;
			}
			setNombre(Integer.parseInt(parametres[0]));
			setValeur(Integer.parseInt(parametres[1]));
			if (bonus != null) {
				setBonus(Integer.parseInt(bonus));
			}else {
				deBonus = new De[arguments.length -1];
				for (int i = 1; i < arguments.length;i++) {
					deBonus[i-1] = new De(arguments[i]);
				}
			}
			this.resultat = (int) ((1+this.getNombre()*this.getValeur())/2);
		}else {
			try{
				this.bonus = Integer.parseInt(str);
			}catch (Exception e) {
				this.bonus = 0;
			}
			this.setNombre(0);
			this.setValeur(1);
		}
	}

	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		assert (nombre >= 0);
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
	
	private int getBonus() {
		return this.bonus;
	}
	
	private void setBonus(int bonus) {
		this.bonus = bonus;
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
		De newDe = new De("1d1");
		newDe.nombre = nombre;
		newDe.valeur = valeur;
		newDe.resultat = resultat;
		newDe.bonus = bonus;
		if (deBonus != null) {
			newDe.deBonus = new De[deBonus.length];
			System.out.println("deBonus.length : "+ deBonus.length);
			System.out.println(deBonus[0]);
			for(int i = 0; i < deBonus.length; newDe.deBonus[i] = deBonus[i++].clone());
		}else {
			newDe.deBonus = null;
		}
		return newDe;
	}
	
	public String toString() {
		return getNombre() + "d"+getValeur() + " =  " + getResultat();
	}
}
