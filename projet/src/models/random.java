package models;
import java.util.Random;



public abstract class random {
	
	public static float randn(float esperance, float variance) {
		Random alea = new Random(8173);
		return (float) (Math.sqrt(variance)*alea.nextGaussian()+esperance);
	}

}
