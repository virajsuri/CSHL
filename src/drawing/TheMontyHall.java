package drawing;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TheMontyHall extends JFrame implements ActionListener {
	JLabel resultLabel, quickResult, labeldoor;
	int rN,rY,wrong;
	JTextField answerBox;
	JButton door1, door2, door3, switchB, reset, no;
	int counterGames = 0, counterWins = 0, counterLoss = 0,go;
	boolean enable = true,check = true;

	public static void main(String[] args) {
		TheMontyHall obj = new TheMontyHall();
		obj.setVisible(true);
	}

	public TheMontyHall() {
		setTitle("Door Program:");
		setSize(750, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel nP = new JPanel();
		
			door1 = new JButton("DOOR 1");
			door1.addActionListener(this);
			nP.add(door1);
			
			door2 = new JButton("DOOR 2");
			door2.addActionListener(this);
			nP.add(door2);
			
			door3 = new JButton("DOOR 3");
			door3.addActionListener(this);
			nP.add(door3);
		
			add(nP, BorderLayout.NORTH);
		
		JPanel sP = new JPanel();
			no = new JButton("No");
			no.addActionListener(this);
			sP.add(no);
			no.setVisible(false);
			
			switchB = new JButton("Change");
			switchB.addActionListener(this);
			sP.add(switchB);
			
			reset = new JButton("Reset");
			reset.addActionListener(this);
			sP.add(reset);
			
			switchB.setEnabled(false);
			add(sP, BorderLayout.SOUTH);
			
		JPanel cP = new JPanel();
			resultLabel = new JLabel("Here is where the results will be printed |");
			cP.add(resultLabel);
			
			quickResult = new JLabel("Choose a door |");
			cP.add(quickResult);
			
			labeldoor = new JLabel("Chosen door: ");
			cP.add(labeldoor);
			add(cP, BorderLayout.CENTER);

	}

	public void actionPerformed(ActionEvent e) {
		String aC = e.getActionCommand();
		if (aC.equalsIgnoreCase("reset")) {
			counterGames = 0;
			counterWins = 0;
			counterLoss = 0;
			resultLabel.setText("Here is where the results will be printed |");
		}
		if (enable == true || aC.equalsIgnoreCase("reset")) {
			switchB.setEnabled(false);
			check = true;
			rN = (int) (Math.random() * 3 + 1);
			door1.setEnabled(true);
			door2.setEnabled(true);
			door3.setEnabled(true);
			quickResult.setText("Choose a door |");
			labeldoor.setText("Chosen door: ");
			no.setVisible(false);
			enable = false;
		}
		if (check == true) {
			if (aC.equalsIgnoreCase("door 1")) {
				enable = false;
				check = false;
				go = 1;
				quickResult.setText("Do you want to switch doors? |");
				labeldoor.setText("Chosen door: " + go);
				switchB.setEnabled(true);
				no.setVisible(true);
				if (go == rN) {
					door2.setEnabled(false);
					wrong = 3;
				} else {
					for (int i = 1; i <= 3; i++) {
						if (i != go & i != rN) {
							wrong = i;
							if (i == 1) {
								door1.setEnabled(false);
							}
							if (i == 2) {
								door2.setEnabled(false);
							}
							if (i == 3) {
								door3.setEnabled(false);
							}
						}
					}
				}
			}
			if (aC.equalsIgnoreCase("door 2")) {
				enable = false;
				check = false;
				go = 2;
				quickResult.setText("Do you want to switch doors? |");
				labeldoor.setText("Chosen door: " + go);
				switchB.setEnabled(true);
				no.setVisible(true);
				if (go == rN) {
					door3.setEnabled(false);
					wrong = 1;
				} else {
					for (int i = 1; i <= 3; i++) {
						if (i != go & i != rN) {
							wrong = i;
							if (i == 1) {
								door1.setEnabled(false);
							}
							if (i == 2) {
								door2.setEnabled(false);
							}
							if (i == 3) {
								door3.setEnabled(false);
							}
						}
					}
				}
			}
			if (aC.equalsIgnoreCase("door 3")) {
				enable = false;
				check = false;
				go = 3;
				quickResult.setText("Do you want to switch doors? |");
				labeldoor.setText("Chosen door: " + go);
				switchB.setEnabled(true);
				no.setVisible(true);
				if (go == rN) {
					door2.setEnabled(false);
					wrong = 2;
				} else {
					for (int i = 1; i <= 3; i++) {
						if (i != go & i != rN) {
							wrong = i;
							if (i == 1) {
								door1.setEnabled(false);
							}
							if (i == 2) {
								door2.setEnabled(false);
							}
							if (i == 3) {
								door3.setEnabled(false);
							}
						}
					}
				}

			}
		} else {
			if (aC.equalsIgnoreCase("change")) {
				counterGames++;
				switchB.setEnabled(false);
				if (go == rN) {
					labeldoor.setText("Chosen door: " + wrong);
					quickResult.setText(
							"You lost. You had the right door but you switched. The right door was DOOR" + rN + " |");
					counterLoss++;
					resultLabel.setText(
							"Games: " + counterGames + " Wins: " + counterWins + " Losses: " + counterLoss + " |");
				} else {
					labeldoor.setText("Chosen door: " + rN);
					quickResult.setText("You won! You switched to the right door, DOOR" + rN + " |");
					counterWins++;
					resultLabel.setText(
							"Games: " + counterGames + " Wins: " + counterWins + " Losses: " + counterLoss + " |");
				}
				enable = true;
			} else if (aC.equalsIgnoreCase("no")) {
				counterGames++;
				switchB.setEnabled(false);
				if (go == rN) {
					quickResult.setText("You won! |");
					counterWins++;
					resultLabel.setText(
							"Games: " + counterGames + " Wins: " + counterWins + " Losses: " + counterLoss + " |");
				} else {
					quickResult.setText("You lost. The right door was DOOR" + rN + " |");
					counterLoss++;
					resultLabel.setText(
							"Games: " + counterGames + " Wins: " + counterWins + " Losses: " + counterLoss + " |");
				}
				enable = true;
			}
		}

	}

}
