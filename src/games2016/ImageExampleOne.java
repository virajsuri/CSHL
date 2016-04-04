package games2016;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class ImageExampleOne extends JFrame{

	//CONSTRUCTOR
	public ImageExampleOne() {
		initUI();
	}
	
	//user defined method
	
	private void initUI() {
		add(new Board());
		pack();
		setTitle("Stormtrooper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public static void main (String [] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ImageExampleOne ex = new ImageExampleOne();
				ex.setVisible(true);
			}
		});
	}
}
