package normalWork;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class KnightsTour extends JFrame implements ActionListener {
	JButton game[][] = new JButton[8][8];

	// variables
	int xSpot = -1;
	int ySpot = -1;

	int newYspot;
	int newXspot;
	int spotNum = 0;

	// counter that changes color
	int changecolor = 0;

	public static void main(String[] args) {
		KnightsTour obj = new KnightsTour();
		obj.setVisible(true);
	}

	public KnightsTour() {
		super("Knight's Tour");
		setSize(1000, 1000);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new GridLayout(8, 8));

		for (int i = 0; i < 8; i++) {
			for (int z = 0; z < 8; z++) {
				// switch colors
				changecolor++;

				game[z][i] = new JButton();
				add(game[z][i]);
				game[z][i].addActionListener(this);
				game[z][i].setActionCommand(z + " , " + i);
				game[z][i].setBorderPainted(false);
				game[z][i].setOpaque(true);


				if (i % 2 == 0) {
					if (z % 2 == 0) {
						game[z][i].setBackground(Color.GRAY);
					}
				}
				else {
					if (z % 2 != 0) {
						game[z][i].setBackground(Color.GRAY);
					}
				}
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		// make new spots
		String action = e.getActionCommand();
		for (int i = 0; i < 8; i++)
			for (int z = 0; z < 8; z++)

				if (action.equals(z + " , " + i)) {
					newXspot = z;
					newYspot = i;
				}

		if (spotNum == 0) {
			spotNum++;
			xSpot = newXspot;
			ySpot = newYspot;

			game[xSpot][ySpot].setText("" + spotNum);

			game[xSpot][ySpot].setBackground(Color.PINK);
			game[xSpot][ySpot].setEnabled(false);
		} else {
			
			int goodMove = (Math.abs(xSpot - newXspot)) + (Math.abs(ySpot - newYspot));

			if (goodMove == 3 && (Math.abs(xSpot - newXspot)) < 3 && (Math.abs(ySpot - newYspot)) < 3) {
				System.out.println("Valid Move");
				spotNum++;
				xSpot = newXspot;
				ySpot = newYspot;

//				game[xSpot][ySpot].setText("" + spotNum);

				game[xSpot][ySpot].setBackground(Color.PINK);
				game[xSpot][ySpot].setEnabled(false);
			} else {
				// JOptionPane.showMessageDialog(null, "Not a valid move");
				System.err.println("Not a valid move");
			}
		}

	}

}