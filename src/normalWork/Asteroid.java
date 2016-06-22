package normalWork;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Asteroid extends Applet implements KeyListener, Runnable {
	// snyder
	Image img;
	int xImage = 375;
	int yImage = 175;
	int xShipSpeed;
	int yShipSpeed;
	int xShipAcceleration;
	int yShipAcceleration;

	// poop
	Image img1;
	ArrayList<Integer> bulletList = new ArrayList<Integer>();
	ArrayList<Integer> bulletSpeedList = new ArrayList<Integer>();
	int xBulletSpeed;
	int yBulletSpeed;
	int xBulletDirection = 0;
	int yBulletDirection = 0;

	public void init() {
		setSize(800, 600);
		setBackground(Color.WHITE);
		addKeyListener(this);
		try {
			URL url = new URL((getDocumentBase()), "snyder.jpg");
			img = ImageIO.read(url);
			// poop
			URL url1 = new URL((getDocumentBase()), "poop.png");
			img1 = ImageIO.read(url1);
		} catch (IOException e) {

		}
	}

	public void start() {
		Thread th = new Thread(this);
		th.start();
	}

	public void stop() {
	}

	public void paint(Graphics g) {

		g.drawRect(xImage, yImage, 15, 15);

		if (bulletList.size() >= 2) {
			for (int i = 0; i < bulletList.size(); i = i + 4) {
				g.drawImage(img1, bulletList.get(i), bulletList.get(i + 1), this);
				g.drawOval(bulletList.get(i), bulletList.get(i + 1), 5, 5);
			}
		}
	}

	public void run() {
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		while (true) {
			if (xImage > 800) {
				xImage = 0;
			} else if (xImage < 0) {
				xImage = 800;
			}

			if (yImage > 600) {
				yImage = 0;
			} else if (yImage < 0) {
				yImage = 600;
			}

			
			xImage = xImage + xShipSpeed + xShipAcceleration;
			yImage = yImage + yShipSpeed + yShipAcceleration;
			if (xShipAcceleration != 0) {
				if (xShipAcceleration < 0) {
					xShipAcceleration++;
				}
				if (xShipAcceleration > 0) {
					xShipAcceleration--;
				}
			}
			if (yShipAcceleration != 0) {
				if (yShipAcceleration < 0) {
					yShipAcceleration++;
				}
				if (yShipAcceleration > 0) {
					yShipAcceleration--;
				}
			}

			for (int i = 0; i < bulletList.size() - 1; i = i + 4) {
				bulletList.set(i, bulletList.get(i) + bulletList.get(i + 2));
				bulletList.set(i + 1, bulletList.get(i + 1) + bulletList.get(i + 3));

			}

			repaint();
			try {
				Thread.sleep(25);
			} catch (InterruptedException Ex) {

			}
		}
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		if (key == KeyEvent.VK_SPACE) {
			xBulletDirection = xBulletSpeed;
			yBulletDirection = yBulletSpeed;
			bulletList.add(xImage);
			bulletList.add(yImage);
			bulletList.add(xBulletDirection);
			bulletList.add(yBulletDirection);
		}
		if (key == KeyEvent.VK_LEFT) {
			xShipSpeed = -15;
			xBulletSpeed = -15;
			yBulletSpeed = 0;
		}
		if (key == KeyEvent.VK_RIGHT) {
			xShipSpeed = 15;
			xBulletSpeed = 15;
			yBulletSpeed = 0;
		}
		if (key == KeyEvent.VK_UP) {
			yShipSpeed = -15;
			yBulletSpeed = -15;
			xBulletSpeed = 0;
		}
		if (key == KeyEvent.VK_DOWN) {
			yShipSpeed = 15;
			yBulletSpeed = 15;
			xBulletSpeed = 0;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			xShipAcceleration = -15;
			xShipSpeed = 0;
		}
		if (key == KeyEvent.VK_RIGHT) {
			xShipAcceleration = 15;
			xShipSpeed = 0;
		}
		if (key == KeyEvent.VK_UP) {
			yShipAcceleration = -15;
			yShipSpeed = 0;
		}
		if (key == KeyEvent.VK_DOWN) {
			yShipAcceleration = 15;
			yShipSpeed = 0;
		}

	}

}
