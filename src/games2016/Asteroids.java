package games2016;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import viraj.util.*;

public class Asteroids extends Applet implements KeyListener,Runnable{
	int xPos = 500, yPos = 350;
	int xSpeed = 0, ySpeed = 0;
	int xAcc = 0, yAcc = 0;
	ArrayList<Integer> xAsteroids = new ArrayList<Integer>(), yAsteroids = new ArrayList<Integer>();
	
	long start=System.currentTimeMillis();

	genAsteroids obj = new genAsteroids();
	Timer timer = new Timer();
	
	public void init() {
		setSize(1000,700);
		setBackground(Color.PINK);
		addKeyListener(this);
	}
	
	public void stop() {}
	
	public void start() {
		Thread th = new Thread(this);
		th.start();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("Create");
				obj.create(xAsteroids, yAsteroids);
				
			}
		},0,4000);
	}
	
	public void run() {
		
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		
		while(true) {
			
			
			long seconds= (System.currentTimeMillis()-start);
//			System.out.println(seconds);
			
			for(int i=0; i<=xAsteroids.size()-1; i++) {
				yAsteroids.set(i, yAsteroids.get(i)+3);
				xAsteroids.set(i, xAsteroids.get(i)+3);
			}
			
			
			xPos=xPos+xSpeed+xAcc;
			yPos=yPos+ySpeed+yAcc;
			if(xAcc!=0) {
				if(xAcc > 0)
					xAcc--;
				if(xAcc < 0) {
					xAcc++;
				}
			}
			if(yAcc!=0) {
				if(yAcc > 0)
					yAcc--;
				if(yAcc < 0)
					yAcc++;
			}
			
			if(xPos>1000)
				xPos=0;
			if(xPos<0)
				xPos=1000;
			if(yPos>700)
				yPos=0;
			if(yPos<0)
				yPos=700;
			
			repaint();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void paint(Graphics g) {
		g.drawRect(xPos, yPos, 10, 20);
		for(int i=0; i<=xAsteroids.size()-1;i++) {
			g.fillRect(xAsteroids.get(i), yAsteroids.get(i), 30, 30);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	public void keyPressed(KeyEvent e) {
		
		
		int keyCode=e.getKeyCode();
		//r 39
		//u 38
		//l 37
		//d 40
		if(keyCode == 39) { //right
			xSpeed=10;
		}
		if(keyCode == 38) { //up
			ySpeed=-10;

		}
		if(keyCode == 37) { //left
			xSpeed=-10;
		}
		if(keyCode == 40) { //down
			ySpeed=10;
		}
		System.out.println("X: "+xPos);
		System.out.println("Y: "+yPos+"\n");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode=e.getKeyCode();
		//r 39
		//u 38	
		//l 37
		//d 40
		
		if(keyCode == 39) { //right
			xSpeed=0;
			xAcc=10;
		}
		if(keyCode == 38) { //up
			ySpeed=0;
			yAcc=-10;

		}
		if(keyCode == 37) { //left
			xSpeed=0;
			xAcc=-10;
		}
		if(keyCode == 40) { //down
			ySpeed=0;
			yAcc=10;
		}
		
	}
	
	
	
}
