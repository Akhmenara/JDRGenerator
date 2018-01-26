package models;
import java.util.Random;



public abstract class RandomStat {
	
	public static int randn(int esperance, int variance) {
		Random alea = new Random();
		int resultat = (int) (Math.round((Math.sqrt(variance))*alea.nextGaussian())+esperance);
		System.out.println(Math.sqrt(variance));
		System.out.println(alea.nextGaussian());
		System.out.println(Math.round((Math.sqrt(variance))*alea.nextGaussian()));
		System.out.println(resultat);
		
		return resultat;
	}

}
