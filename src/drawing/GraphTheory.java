package drawing;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GraphTheory extends Applet implements MouseListener,Runnable{
	int[] linepoints = {0,0,0,0};
	ArrayList<Integer> pointsX = new ArrayList<Integer>(2);
	ArrayList<Integer> pointsY = new ArrayList<Integer>(2);

	
	public void init() {
		setSize(400,400);
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
//		g.fillOval(0, 0, 10, 10);

		for(int i=0;i<=pointsX.size()-1;i++) {
			g.fillOval(pointsX.get(i)-7, pointsY.get(i)-6, 10, 10);
		}
	}
	
	public void mouseClicked(MouseEvent e) {
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
