package drawing;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class Piksels extends Applet implements KeyListener,Runnable{
	int yPos1=50, xPos1=70,yPos2=90, xPos2=30;

	
	public void init() {
		setSize(1000,700);
		setBackground(Color.PINK);
		addKeyListener(this);
	}
	
	public void stop() {}
	
	public void start() {
		Thread th = new Thread(this);
		th.start();
	}
	
	public void run() {
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		while(true) {
			
				
			try {
				repaint();
				Thread.sleep(150);
			}catch(InterruptedException Ex) {
				
			}
		}
	}
	
	public void paint(Graphics g) {
		g.drawRect(xPos1, yPos1, 10, 10);
		g.drawRect(xPos2, yPos2, 10, 10);
	}


		
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode=e.getKeyCode();
		//r 39
		//u 38
		//l 37
		//d 40
		if(keyCode == 39) {
			xPos1+=10;
		}
		if(keyCode == 38) {
			yPos1-=10;
		}
		if(keyCode == 37) {
			xPos1-=10;
		}
		if(keyCode == 40) {
			yPos1+=10;
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
