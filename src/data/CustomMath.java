package data;

public class CustomMath {
	public static int limit(int x, int min, int max) {
		//vereinfachte if/else funktion. ":" steht für "else" 
		return(x > max) ? max : (x<min ? min : x);
	}

}
