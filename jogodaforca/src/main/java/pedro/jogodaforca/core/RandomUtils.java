package pedro.jogodaforca.core;

import java.util.Random;

public class RandomUtils {

	
	private static Random random = new Random();
		
	public static int newInt(int min, int max) {
		return random.nextInt(max - min) + min;
	}

}
