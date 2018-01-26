package models;

public class Monstre extends Entite{
	
	public Monstre(float[] stats) {
		this.setForce(stats[1]);
		this.setDexterite(stats[2]);
		this.setConstitution(stats[3]);
		this.setIntelligence(stats[4]);
		this.setSagesse(stats[5]);
		this.setCharisme(stats[6]);
	}
	
	
	public float getForce() {
		return this.getForce();
	}
	
	public void setForce(float force) {
		this.setForce(force);
	}
	
	public float getDexterite() {
		return this.getDexterite();
	}
	
	public void setDexterite(float dexterite) {
		this.setDexterite(dexterite);
	}
	
	public float getConstitution() {
		return this.getConstitution();
	}
	
	public void setConstitution(float constitution) {
		this.setConstitution(constitution);
	}
	
	public float getIntelligence() {
		return this.getIntelligence();
	}
	
	public void setIntelligence(float intelligence) {
		this.setIntelligence(intelligence);
	}
	
	public float getSagesse() {
		return this.getSagesse();
	}
	
	public void setSagesse(float sagesse) {
		this.setSagesse(sagesse);
	}
	
	public float getCharisme() {
		return this.getCharisme();
	}
	
	public void setCharisme(float charisme) {
		this.setCharisme(charisme);
	}
	
	public static Monstre creerMonstreAleaNorm(float[] moyennes, float[] variances) {
		float[] stats = new float[6];
		for (int i = 0; i<6; stats[i++] = random.randn(moyennes[i++],variances[i++])) {}
		return new Monstre(stats);
	}
	
	
	
	
}
