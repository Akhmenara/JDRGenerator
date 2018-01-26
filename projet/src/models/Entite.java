package models;

abstract class Entite {
	private int force;
	private int dexterite;
	private int constitution;
	private int intelligence;
	private int sagesse;
	private int charisme;
	
	protected int getForce() {
		return force;
	}
	
	protected void setForce(int force) {
		this.force = force;
	}
	
	protected int getDexterite() {
		return dexterite;
	}
	
	protected void setDexterite(int dexterite) {
		this.dexterite = dexterite;
	}
	
	protected int getConstitution() {
		return constitution;
	}
	
	protected void setConstitution(int constitution) {
		this.constitution = constitution;
	}
	
	protected int getIntelligence() {
		return intelligence;
	}
	
	protected void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	
	protected int getSagesse() {
		return sagesse;
	}
	
	protected void setSagesse(int sagesse) {
		this.sagesse = sagesse;
	}
	
	protected int getCharisme() {
		return charisme;
	}
	
	protected void setCharisme(int charisme) {
		this.charisme = charisme;
	}
}
