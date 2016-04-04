package games2016;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JPanel;

public class Board extends JPanel{
	private Image storm;
	
	public Board() {
		initBoard();
	}
	
	private void initBoard() {
		loadImage();
		int w = storm.getWidth(this);
		int h = storm.getHeight(this);
		setPreferredSize(new Dimension(w,h));
	}
}
