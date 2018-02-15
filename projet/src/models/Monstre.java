package models;

public class Monstre extends Entite{
	
	private De desVie;
	
	public Monstre(String nom, Stat stats, De desVie) {
		super(nom, stats);
		this.setDesVie(desVie);
		this.setVieMax(desVie.getResultat());
		this.setVie(getVieMax());
	}
	
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
		Stat stat = new Stat();
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
		for (int i = 0; i < nombre; mobs[i] = creerMonstreAleaNorm(getNom() + " "+(++i),this, variances));
		return mobs;
	}
	
	public static Monstre creerMonstreAleaNorm(Monstre base, int[] variances) {
		Stat stat = base.getStat();
		int[] moyennes = {base.getForce(), base.getDexterite(), base.getConstitution(), base.getIntelligence(), base.getSagesse(), base.getCharisme()};
		for (int i = 0; i<6; stat.replace(Stat.CLES[i], RandomStat.randn(moyennes[i],variances[i++]))) {}
		De newDeVie = base.getDesVie().clone();
		newDeVie.lancer();
		Monstre mob = new Monstre("",stat,newDeVie);
		De d20 = new De("1d20");
		d20.lancer();
		mob.setInitiative(d20.getResultat());
		return mob;
	}
	
	public static Monstre[] creerMonstreAleaNorm(Monstre base, int[] variances, int nombre) {
		Monstre[] mobs = new Monstre[nombre];
		for (int i = 0; i < nombre; mobs[i++] = creerMonstreAleaNorm(base, variances));
		return mobs;
	}
	
	public static Monstre creerMonstreAleaNorm(String nom, Monstre base, int[] variances) {
		Monstre mob = creerMonstreAleaNorm(base,variances);
		mob.setNom(nom);
		return mob;
	}
	
	public static Monstre[] creerMonstreAleaNorm(String nom, Monstre base, int[] variances, int nombre) {
		Monstre[] mobs = new Monstre[nombre];
		for (int i = 0; i < nombre; mobs[i] = creerMonstreAleaNorm(nom + " "+(++i),base, variances));
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
