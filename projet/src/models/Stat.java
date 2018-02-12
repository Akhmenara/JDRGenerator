package models;

import java.util.Hashtable;
import java.util.Map;

public class Stat extends Hashtable<String, Integer> {

	public Stat() {
		super();
		put("Force", 0);
		put("Dexterite", 0);
		put("Constitution", 0);
		put("Intelligence",0);
		put("Sagesse", 0);
		put("Charisme", 0);
		put("VieMax", 0);
		put("Vie", 0);
		put("CA", 0);
		put("Reflexes", 0);
		put("Vigueur", 0);
		put("Volonte", 0);
		put("Bda", 0);
		
	}

}
