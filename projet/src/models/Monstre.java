package models;

public class Monstre extends Entite{
	
	private De desVie;
	
	public Monstre(String nom, int[] stats, De desVie) {
		this(nom,stats);
		System.out.println(desVie);
		this.setDesVie(desVie);
		this.setVieMax(desVie.getResultat());
		this.setVie(getVieMax());
	}
	
	public Monstre(String nom, int[] stats) {
		this(stats);
		this.setNom(nom);
	}
	
	public Monstre(int[] stats, De deVie) {
		this(stats);
		this.setDesVie(deVie);
		this.setVieMax(getDesVie().getResultat());
		this.setVie(getVieMax());
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
		this.setVieMax(getDesVie().getResultat());
		this.setVie(getVieMax());
		this.setBda(0);
		this.setCA(10);
		this.setInitiative(0);
		this.setReflexes(0);
		this.setVigueur(0);
		this.setVolonte(0);
	}
	public De getDesVie() {
		return desVie;
	}

	public void setDesVie(De desVie) {
		this.desVie = desVie;
	}

	public Monstre[] engendrer(int nombre, int[] variances) {
		Monstre[] mobs = new Monstre[nombre];
		int[] moyennes = {getForce(), getDexterite(), getConstitution(), getIntelligence(), getSagesse(), getCharisme()};
		for (int i = 0; i < nombre; mobs[i] = creerMonstreAleaNorm(getNom() + " "+(++i),moyennes, variances, getDesVie()));
		return mobs;
	}
	
	public static Monstre creerMonstreAleaNorm(int[] moyennes, int[] variances, De deVie) {
		int[] stats = new int[6];
		for (int i = 0; i<6; stats[i] = RandomStat.randn(moyennes[i],variances[i++])) {}
		De newDeVie = deVie.clone();
		System.out.println(newDeVie);
		newDeVie.lancer();
		System.out.println(newDeVie);
		Monstre mob = new Monstre(stats,newDeVie);
		De d20 = new De("1d20");
		d20.lancer();
		mob.setInitiative(d20.getResultat());
		return mob;
	}
	
	public static Monstre[] creerMonstreAleaNorm(int[] moyennes, int[] variances, De deVie, int nombre) {
		Monstre[] mobs = new Monstre[nombre];
		for (int i = 0; i < nombre; mobs[i++] = creerMonstreAleaNorm(moyennes, variances, deVie));
		return mobs;
	}
	
	public static Monstre creerMonstreAleaNorm(String nom, int[] moyennes, int[] variances, De deVie) {
		Monstre mob = creerMonstreAleaNorm(moyennes,variances,deVie);
		mob.setNom(nom);
		return mob;
	}
	
	public static Monstre[] creerMonstreAleaNorm(String nom, int[] moyennes, int[] variances, De deVie, int nombre) {
		Monstre[] mobs = new Monstre[nombre];
		for (int i = 0; i < nombre; mobs[i] = creerMonstreAleaNorm(nom + " "+(++i),moyennes, variances, deVie));
		return mobs;
	}
	
	@Override
	public String toString() {
		return "Monstre [getDesVie()=" + getDesVie() + ", getForce()=" + getForce() + ", getDexterite()="
				+ getDexterite() + ", getConstitution()=" + getConstitution() + ", getIntelligence()="
				+ getIntelligence() + ", getSagesse()=" + getSagesse() + ", getCharisme()=" + getCharisme()
				+ ", getNom()=" + getNom() + ", getVieMax()=" + getVieMax() + ", getVie()=" + getVie() + ", getCA()="
				+ getCA() + ", getReflexes()=" + getReflexes() + ", getVigueur()=" + getVigueur() + ", getVolonte()="
				+ getVolonte() + ", getBda()=" + getBda() + ", getInitiative()=" + getInitiative() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
