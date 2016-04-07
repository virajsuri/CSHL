package OOP;

public class DistanceDriver {
	public static void main(String [] args) {
		Pointsin2D obj1 = new Pointsin2D();
		Pointsin2D obj2 = new Pointsin2D(1,2,19,-12);
		System.out.println(obj1);
		System.out.println(obj2);
		
		Pointsin2D obj3 = new Pointsin2D();
		obj3.setX1();
		obj3.setY1();
		obj3.setX2();
		obj3.setY2();
		System.out.println(obj3);
		double distance=obj3.getDistance();
		System.out.println(distance);
	}

}
