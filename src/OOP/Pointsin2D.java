package OOP;

import viraj.util.*;
import javax.swing.JOptionPane;

public class Pointsin2D {
	public int x1, y1, x2, y2;
	
	public Pointsin2D() {
		x1=0;
		y1=0;
		x2=0;
		y2=0;
		
	}
	
	public Pointsin2D(int x1, int y1,int x2, int y2) {
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		
		
	}
	
	public String toString() {
		return "("+x1+","+y1+") and ("+x2+","+y2+")";
	}

	public void setX1() {
		x1= Integer.parseInt(JOptionPane.showInputDialog("Val of x1?"));
	}
	
	public int getx1() {
		
		return x1;
	}

	public void setY1() {
		y1= Integer.parseInt(JOptionPane.showInputDialog("Val of y1?"));
	}
	
	public int gety1() {
		
		return y1;
	}
	
	public void setX2() {
		x2= Integer.parseInt(JOptionPane.showInputDialog("Val of x2?"));
	}
	
	public int getx2() {
		
		return x2;
	}

	public void setY2() {
		y2= Integer.parseInt(JOptionPane.showInputDialog("Val of y2?"));
	}
	
	public int gety2() {
		
		return y2;
	}

	public double getDistance() {
		return viraj.util.Maths.distance(x1, x2, y1, y2);
	}
	
	
}
