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
	private int cA;
	private int reflexes;
	private int vigueur;
	private int volonte;
	private int bda;
	private int initiative;
	
	public int getForce() {
		return force;
	}
	
	public void setForce(int force) {
		this.force = verif(force);
	}
	
	public int getDexterite() {
		return dexterite;
	}
	
	public void setDexterite(int dexterite) {
		this.dexterite = verif(dexterite);
	}
	
	public int getConstitution() {
		return constitution;
	}
	
	public void setConstitution(int constitution) {
		this.constitution = verif(constitution);
	}
	
	public int getIntelligence() {
		return intelligence;
	}
	
	public void setIntelligence(int intelligence) {
		this.intelligence = verif(intelligence);
	}
	
	public int getSagesse() {
		return sagesse;
	}
	
	public void setSagesse(int sagesse) {
		this.sagesse = verif(sagesse);
	}
	
	public int getCharisme() {
		return charisme;
	}
	
	public void setCharisme(int charisme) {
		this.charisme = verif(charisme);
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getVieMax() {
		return vieMax;
	}

	public void setVieMax(int vieMax) {
		this.vieMax = vieMax;
	}
	
	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}
	
	public int getCA() {
		return cA;
	}
	
	public void setCA(int cA) {
		this.cA = cA;
	}
	
	public int getReflexes() {
		return reflexes;
	}

	public void setReflexes(int reflexes) {
		this.reflexes = reflexes;
	}

	public int getVigueur() {
		return vigueur;
	}

	public void setVigueur(int vigueur) {
		this.vigueur = vigueur;
	}

	public int getVolonte() {
		return volonte;
	}

	public void setVolonte(int volonte) {
		this.volonte = volonte;
	}

	public int getBda() {
		return bda;
	}

	public void setBda(int bda) {
		this.bda = bda;
	}

	public int getInitiative() {
		return initiative;
	}
	
	public void setInitiative(int initiative) {
		this.initiative = verif(initiative + this.bonus(this.getDexterite()));
	}
	
	public int bonus(int stat) {
		return Integer.divideUnsigned(stat, 2) - 5;
	}
	
	private int verif(int x) {
		if (x > 1) {
			return x;
			
		}else {
			return 1;
		}
	}
}
