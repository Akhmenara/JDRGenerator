package models;
import java.util.Random;



public abstract class RandomStat {
	
	public static int randn(int esperance, int variance) {
		Random alea = new Random(8173);
		return (int) (Math.round((Math.sqrt(variance))*alea.nextGaussian())+esperance);
	}

}
