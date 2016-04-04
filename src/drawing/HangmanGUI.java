package drawing;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangmanGUI extends JFrame implements ActionListener {
	JButton B1,B2,B3,B4,B5;

	JLabel S1,S2,S3;

	JLabel lives;
	int life = 2;

	String[] word = { "C", "A", "T", "G", "Q" };
	String answer = "CAT";

	public static void main(String[] args) {
		HangmanGUI obj = new HangmanGUI();
		obj.setVisible(true);

	}

	public HangmanGUI() {
		setTitle("Hangman");
		setSize(500, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		JPanel northPanel = new JPanel();
		//northPanel.setBackground(new Color(90, 86, 2));

		for (int i = 3; i > 0; i--) {
			int x = (int) (Math.random() * i);
			String temp = word[x];
			word[x] = word[i];
			word[i] = temp;

		}

		B1 = new JButton(word[0]);
		northPanel.add(B1);
		B1.addActionListener(this);

		B2 = new JButton(word[1]);
		northPanel.add(B2);
		B2.addActionListener(this);

		B3 = new JButton(word[2]);
		northPanel.add(B3);
		B3.addActionListener(this);

		B4 = new JButton(word[3]);
		northPanel.add(B4);
		B4.addActionListener(this);

		B5 = new JButton(word[4]);
		northPanel.add(B5);
		B5.addActionListener(this);

		add(northPanel, BorderLayout.NORTH);

		JPanel southPanel = new JPanel();

		southPanel.setBackground(new Color(23, 60, 85));
		lives = new JLabel(life + "/2");
		southPanel.add(lives);

		add(southPanel, BorderLayout.SOUTH);

		JPanel centerPanel = new JPanel();
		//centerPanel.setBackground(new Color(30, 17, 150));

		S1 = new JLabel("_");
		centerPanel.add(S1);
		S2 = new JLabel("_");
		centerPanel.add(S2);
		S3 = new JLabel("_");
		centerPanel.add(S3);

		add(centerPanel, BorderLayout.CENTER);

	}

	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		int j = 0;
		System.out.println(action);

		if (action.equals("C")) {
			System.out.println("C");
			S1.setText("C");
			j++;
		}
		if (action.equals("A")) {
			System.out.println("A");
			S2.setText("A");
			j++;
		}
		if (action.equals("T")) {
			S3.setText("T");
			j++;
		}

		if (action.equals("G")) {
			life--;
			lives.setText(life + "/2");
		}
		if (action.equals("Q")) {
			life--;
			lives.setText(life + "/2");
			if(life==0) {
				JOptionPane.showMessageDialog(null, "You lost, loser.");
			}
		}
		if (lives.equals("0")) {
			JOptionPane.showInputDialog("You lose");
		}

	}

}
