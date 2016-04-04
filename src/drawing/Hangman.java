package drawing;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Hangman extends JFrame implements ActionListener{
	
	char[] characters,blanks;
	JLabel blankLabel,livesLabel;
	static String word="";
	int lives=2;
	int score=0;
	
	public static void main(String [] args){
		
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream("words.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
			e.printStackTrace();
			System.exit(0);
		}
		word=inputStream.nextLine();
		Hangman obj = new Hangman();
		obj.setVisible(true);
	}

	
	public Hangman(){
		setTitle("Hangman");
		setSize(700,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//word = "cat";
		String blankString="";
		characters = word.toCharArray();
		
		JButton[] buttons = new JButton[word.length()+3];
		JPanel northP = new JPanel();
			for(int i=0;i<=characters.length-1;i++){
				buttons[i] = new JButton(characters[i]+"");
				buttons[i].addActionListener(this);
				northP.add(buttons[i]);
			}

			char[] randoms = {'a','e','i'};
			for(int i=1;i<=2;i++){
				buttons[characters.length+i]=new JButton(randoms[i]+"");
				buttons[characters.length+i].addActionListener(this);
				northP.add(buttons[characters.length+i]);
			}
			
			
		
			
		//	Collections.shuffle(Arrays.asList(buttons));
			
		add(northP, BorderLayout.NORTH);
		
		JPanel centerP = new JPanel();
		blanks = new char[word.length()];
			for(int i=0;i<=characters.length-1;i++){
				blanks[i]='_';
			}
			
			for(int i=0;i<=word.length()-1; i++){
				blankString +="  _";
			}
			blankLabel = new JLabel(blankString);
			centerP.add(blankLabel);
			
		add(centerP, BorderLayout.CENTER);
		
		JPanel southP = new JPanel();
			livesLabel = new JLabel("Lives: "+lives);
			southP.add(livesLabel);
		add(southP, BorderLayout.SOUTH);
	}

	
	public void actionPerformed(ActionEvent e) {
		boolean removelife=false;
		String blankString="";
		int i=0;
		String actionString = e.getActionCommand();
		char action = actionString.charAt(0);
		
		for(i=0;i<=characters.length-1;i++){
			System.out.println("is your guess " + action+" equal to "+characters[i]);
			
			if(action==(characters[i])){
				score++;
				System.out.println("yes"+ " on spot "+(i+1));
				blanks[i]=action;				
				
				System.out.println("Score is "+score);
				break;
			}
			else{
				System.out.println("Wrong");
				removelife=true;
				
				
			}
			
		}
		if(removelife) {
			lives--;
			livesLabel.setText(("Lives: "+lives));
			System.err.println("Removed a life");
		}
		for(int d=0;d<=word.length()-1; d++){
			blankString=blankString+blanks[d];
		}
		blankLabel.setText(blankString);
		
	if(score==word.length()){
		JOptionPane.showMessageDialog(null, "You won");
		System.exit(0);
	}
	}
}