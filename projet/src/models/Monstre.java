package models;

public class Monstre extends Entite{
	
	public Monstre(int[] stats) {
		this.setForce(stats[1]);
		this.setDexterite(stats[2]);
		this.setConstitution(stats[3]);
		this.setIntelligence(stats[4]);
		this.setSagesse(stats[5]);
		this.setCharisme(stats[6]);
	}
	
	
	public int Force() {
		return this.getForce();
	}
	
	public void setForce(int force) {
		super.setForce(force);
	}
	
	public int getDexterite() {
		return super.getDexterite();
	}
	
	public void setDexterite(int dexterite) {
		super.setDexterite(dexterite);
	}
	
	public int getConstitution() {
		return super.getConstitution();
	}
	
	public void setConstitution(int constitution) {
		super.setConstitution(constitution);
	}
	
	public int getIntelligence() {
		return super.getIntelligence();
	}
	
	public void setIntelligence(int intelligence) {
		super.setIntelligence(intelligence);
	}
	
	public int getSagesse() {
		return super.getSagesse();
	}
	
	public void setSagesse(int sagesse) {
		super.setSagesse(sagesse);
	}
	
	public int getCharisme() {
		return super.getCharisme();
	}
	
	public void setCharisme(int charisme) {
		super.setCharisme(charisme);
	}
	
	public static Monstre creerMonstreAleaNorm(int[] moyennes, int[] variances) {
		int[] stats = new int[6];
		for (int i = 0; i<6; stats[i++] = RandomStat.randn(moyennes[i++],variances[i++])) {}
		return new Monstre(stats);
	}
	
	public static Monstre[] creerMonstreAleaNorm(int[] moyennes, int[] variances, int nombre) {
		Monstre[] mobs = new Monstre[nombre];
		for (int i = 0; i < nombre; i++) {
			int[] stats = new int[6];
			for (int j = 0; j < 6; stats[j++] = RandomStat.randn(moyennes[j++],variances[j++])) {}
			mobs[i] = new Monstre(stats);
		}
		return mobs;
	}
	
	
	
}
