package OOP;

public class Pointsin3D extends Pointsin2D{
	public int z1,z2;
	public double distance;
	
	public Pointsin3D() {
		super();
		z1=0;
		z2=0;
	}
	
	public Pointsin3D(int x1, int x2, int y1, int y2, int z1, int z2) {
		super(x1,y1,x2,y2);
		this.z1=z1;
		this.z2=z2;
		
	}
	
	public void distance() {
	
	}
}
