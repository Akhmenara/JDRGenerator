package models;

public class Monstre extends Entite{
	
	private De desVie;
	
	public Monstre(String nom, int[] stats, De desVie) {
		this(nom,stats);
		this.setDesVie(desVie);
		this.setVieMax((int) ((1+desVie.getNombre()*desVie.getValeur())/2));
		this.setVie(getVieMax());
	}
	
	public Monstre(String nom, int[] stats) {
		this(stats);
		this.setNom(nom);
	}
	
	public Monstre(int[] stats, De deVie) {
		this(stats);
		this.setDesVie(deVie);
	}
	
	public Monstre(int[] stats) {
		this.setForce(stats[0]);
		this.setDexterite(stats[1]);
		this.setConstitution(stats[2]);
		this.setIntelligence(stats[3]);
		this.setSagesse(stats[4]);
		this.setCharisme(stats[5]);
		this.setNom("Default");
		this.setDesVie(new De("1d1"));
		this.setVieMax(1);
		this.setVie(getVieMax());
	}
	
	
	public int getForce() {
		return super.getForce();
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
	
	public String getNom() {
		return super.getNom();
	}
	
	public void setNom(String nom) {
		super.setNom(nom);
	}
	
	public int getVieMax() {
		return super.getVieMax();
	}

	public void setVieMax(int vieMax) {
		super.setVieMax(vieMax);
	}
	
	public int getVie() {
		return super.getVie();
	}

	public void setVie(int vie) {
		super.setVie(vie);
	}
	
	public De getDesVie() {
		return desVie;
	}

	public void setDesVie(De desVie) {
		this.desVie = desVie;
	}

	public static Monstre creerMonstreAleaNorm(int[] moyennes, int[] variances, De deVie) {
		int[] stats = new int[6];
		for (int i = 0; i<6; stats[i] = RandomStat.randn(moyennes[i],variances[i++])) {}
		return new Monstre(stats,deVie);
	}
	
	public static Monstre[] creerMonstreAleaNorm(int[] moyennes, int[] variances, De deVie, int nombre) {
		Monstre[] mobs = new Monstre[nombre];
		for (int i = 0; i < nombre; mobs[i] = creerMonstreAleaNorm(moyennes, variances, deVie)) {}
		return mobs;
	}
	
	public static Monstre creerMonstreAleaNorm(String nom, int[] moyennes, int[] variances, De deVie) {
		int[] stats = new int[6];
		for (int i = 0; i<6; stats[i] = RandomStat.randn(moyennes[i],variances[i++])) {}
		return new Monstre(nom,stats,deVie);
	}
	
	public static Monstre[] creerMonstreAleaNorm(String nom, int[] moyennes, int[] variances, De deVie, int nombre) {
		Monstre[] mobs = new Monstre[nombre];
		for (int i = 0; i < nombre; mobs[i] = creerMonstreAleaNorm(nom + " "+(++i),moyennes, variances, deVie)) {}
		return mobs;
	}
	
	@Override
	public String toString() {
		if(this.getNom() == null || this.getNom().equals("")){
			return "Monstre getDesVie()" + getDesVie() + "[Force = " + getForce() + ", Dexterite = " + getDexterite() + ", Constitution = "
					+ getConstitution() + ", Intelligence = " + getIntelligence() + ", Sagesse = " + getSagesse()
					+ ", Charisme = " + getCharisme() + "]";
		}
		else{
			return this.getNom() + "getDesVie()" + getDesVie() + " [Force = " + getForce() + ", Dexterite = " + getDexterite() + ", Constitution = "
					+ getConstitution() + ", Intelligence = " + getIntelligence() + ", Sagesse = " + getSagesse()
					+ ", Charisme = " + getCharisme() + "]";
		}
	}
	
	
	
}
