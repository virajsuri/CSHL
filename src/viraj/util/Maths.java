package viraj.util;

public class Maths {
	public static int randomIntBetween(int min, int max) {
		int range = (max - min) + 1;     
		return (int)(Math.random() * range) + min;
	}
	
	public static double distance(int x1,int x2,int y1,int y2) {
		double distance = (Math.sqrt(  ((x1-x2)*(x1-x2)) + ((y1-y2)*(y1-y2))  )  );
		return distance;
	}
	
	
}
