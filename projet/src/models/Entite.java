package models;

abstract class Entite {
	private String nom;
	/*private int force;
	private int dexterite;
	private int constitution;
	private int intelligence;
	private int sagesse;
	private int charisme;
	private int vieMax;
	private int vie;
	private int cA;
	private int reflexes;
	private int vigueur;
	private int volonte;
	private int bda;*/
	private Stat stat = new Stat();
	private int initiative;
	
	
	
	public Entite(String nom, Stat stats) {
		this.setNom(nom);
		this.setStat(stats);
		this.setInitiative(0);
	}
	
	public Entite() {
		
	}
	
	public int getForce() {
		return stat.get("Force");
	}
	
	public void setForce(int force) {
		stat.replace("Force", verif(force));
	}
	
	public int getDexterite() {
		return stat.get("Dexterite");
	}
	
	public void setDexterite(int dexterite) {
		stat.replace("Dexterite",verif(dexterite));
	}
	
	public int getConstitution() {
		return stat.get("Constitution");
	}
	
	public void setConstitution(int constitution) {
		stat.replace("Constitution", verif(constitution));
	}
	
	public int getIntelligence() {
		return stat.get("Intelligence");
	}
	
	public void setIntelligence(int intelligence) {
		stat.replace("Intelligence", verif(intelligence));
	}
	
	public int getSagesse() {
		return stat.get("Sagesse");
	}
	
	public void setSagesse(int sagesse) {
		stat.replace("Sagesse", verif(sagesse));
	}
	
	public int getCharisme() {
		return stat.get("Charisme");
	}
	
	public void setCharisme(int charisme) {
		stat.replace("Charisme", verif(charisme));
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getVieMax() {
		return stat.get("VieMax");
	}

	public void setVieMax(int vieMax) {
		stat.replace("VieMax", vieMax);
	}
	
	public int getVie() {
		return stat.get("Vie");
	}

	public void setVie(int vie) {
		stat.replace("Vie", vie);
	}
	
	public int getCA() {
		return stat.get("CA");
	}
	
	public void setCA(int cA) {
		stat.replace("CA", cA);
	}
	
	public int getReflexes() {
		return stat.get("Reflexes");
	}

	public void setReflexes(int reflexes) {
		stat.replace("Reflexes", reflexes);
	}

	public int getVigueur() {
		return stat.get("Vigueur");
	}

	public void setVigueur(int vigueur) {
		stat.replace("Vigueur", vigueur);
	}

	public int getVolonte() {
		return stat.get("Volonte");
	}

	public void setVolonte(int volonte) {
		stat.replace("Volonte", volonte);
	}

	public int getBda() {
		return stat.get("Bda");
	}

	public void setBda(int bda) {
		stat.replace("Bda", bda);
	}

	public int getInitiative() {
		return initiative;
	}
	
	public void setInitiative(int initiative) {
		this.initiative = verif(initiative + this.bonus(this.getDexterite()));
	}
	
	public Stat getStat() {
		Stat stats = new Stat();
		for(String cle : Stat.CLES) {
			stats.replace(cle, this.stat.get(cle));
		}
		return stats;
	}
	
	public void setStat(Stat stats) {
		for(String cle : Stat.CLES) {
			this.stat.replace(cle, stats.get(cle));
		}
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
