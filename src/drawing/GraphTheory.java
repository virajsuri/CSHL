package drawing;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import viraj.util.*;

public class GraphTheory extends Applet implements MouseListener,Runnable{
	int[] linepoints = {0,0,0,0};
	int verticies =0,faces=0,edges=0;
	ArrayList<Integer> pointsX = new ArrayList<Integer>(1);
	ArrayList<Integer> pointsY = new ArrayList<Integer>(1);

	
	public void init() {
		setSize(1000,700);
		setBackground(Color.PINK);
		addMouseListener(this);
	}
	
	public void stop() {}
	
	public void start() {
		Thread th = new Thread(this);
		th.start();
	}
	
	public void run() {
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
//		while(true) {
//			
//				
//			try {
//				Thread.sleep(500);
//			}catch(InterruptedException Ex) {
//				
//			}
//		}
	}
	
	public void paint(Graphics g) {
		g.drawString("Verticies: "+verticies, 10, 10);
		g.drawString("Faces: "+faces, 10, 25);
		g.drawString("Edges: "+edges, 10, 40);

		for(int i=0;i<=pointsX.size()-1;i++) {
			g.fillOval(pointsX.get(i)-7, pointsY.get(i)-6, 10, 10);
		}
		
			for(int i=0; i<=pointsX.size()-2; i++) {
				g.drawLine(pointsX.get(i), pointsY.get(i), pointsX.get(i+1), pointsY.get(i+1));
			}
		
	}
	
	public void mouseClicked(MouseEvent e) {
		
		
		
		int x=e.getX();
		int y=e.getY();
		System.out.println();
		for(int i=0; i<=pointsX.size()-1;i++) {
//			System.out.println(viraj.util.Maths.distance(x, pointsX.get(i), y, pointsY.get(i)));
			if(viraj.util.Maths.distance(x, pointsX.get(i), y, pointsY.get(i))<5) {
				pointsX.add(pointsX.get(i));
				pointsY.add(pointsY.get(i));
				System.out.println("NEAR");
				repaint();
				return;
			}
		}
		verticies++;
		
		if(verticies>1) {
			edges = (verticies + 1);
			faces = (2 - verticies + edges);
			System.out.println(faces + " FACES ");
		}
		
		System.out.println("add");
		pointsX.add(e.getX());
		pointsY.add(e.getY());		
		repaint();

		
	}


	public void mousePressed(MouseEvent e) {

		
	}


	public void mouseReleased(MouseEvent e) {
		
		
	}


	public void mouseEntered(MouseEvent e) {
		
		
	}


	public void mouseExited(MouseEvent e) {

		
	}
	
	
	
}
