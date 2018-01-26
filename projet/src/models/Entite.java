package models;

abstract class Entite {
	private float force;
	private float dexterite;
	private float constitution;
	private float intelligence;
	private float sagesse;
	private float charisme;
	
	protected float getForce() {
		return force;
	}
	
	protected void setForce(float force) {
		this.force = force;
	}
	
	protected float getDexterite() {
		return dexterite;
	}
	
	protected void setDexterite(float dexterite) {
		this.dexterite = dexterite;
	}
	
	protected float getConstitution() {
		return constitution;
	}
	
	protected void setConstitution(float constitution) {
		this.constitution = constitution;
	}
	
	protected float getIntelligence() {
		return intelligence;
	}
	
	protected void setIntelligence(float intelligence) {
		this.intelligence = intelligence;
	}
	
	protected float getSagesse() {
		return sagesse;
	}
	
	protected void setSagesse(float sagesse) {
		this.sagesse = sagesse;
	}
	
	protected float getCharisme() {
		return charisme;
	}
	
	protected void setCharisme(float charisme) {
		this.charisme = charisme;
	}
}
