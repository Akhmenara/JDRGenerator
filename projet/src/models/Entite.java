package models;

abstract class Entite {
	private int force;
	private int dexterite;
	private int constitution;
	private int intelligence;
	private int sagesse;
	private int charisme;
	private String nom;
	private int vieMax;
	private int vie;

	protected int getForce() {
		return force;
	}
	
	protected void setForce(int force) {
		this.force = verif(force);
	}
	
	protected int getDexterite() {
		return dexterite;
	}
	
	protected void setDexterite(int dexterite) {
		this.dexterite = verif(dexterite);
	}
	
	protected int getConstitution() {
		return constitution;
	}
	
	protected void setConstitution(int constitution) {
		this.constitution = verif(constitution);
	}
	
	protected int getIntelligence() {
		return intelligence;
	}
	
	protected void setIntelligence(int intelligence) {
		this.intelligence = verif(intelligence);
	}
	
	protected int getSagesse() {
		return sagesse;
	}
	
	protected void setSagesse(int sagesse) {
		this.sagesse = verif(sagesse);
	}
	
	protected int getCharisme() {
		return charisme;
	}
	
	protected void setCharisme(int charisme) {
		this.charisme = verif(charisme);
	}
	
	protected String getNom() {
		return nom;
	}
	
	protected void setNom(String nom) {
		this.nom = nom;
	}
	
	protected int getVieMax() {
		return vieMax;
	}

	protected void setVieMax(int vieMax) {
		this.vieMax = vieMax;
	}
	
	protected int getVie() {
		return vie;
	}

	protected void setVie(int vie) {
		this.vie = vie;
	}
	
	private int verif(int x) {
		if (x > 1) {
			return x;
			
		}else {
			return 1;
		}
	}
}
