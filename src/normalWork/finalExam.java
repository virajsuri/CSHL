package normalWork;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class finalExam extends JFrame implements ActionListener{
	
	
	public static void main(String []args) {
		finalExam obj = new finalExam();
		obj.setVisible(true);
	}

	finalExamMethods system = new finalExamMethods();
	
	JTextField nameField, ageField, genderField, nameSearchField,genderSearchField,ageSearchField;
	JLabel nameLabel, ageLabel,genderLabel;
	JTextArea searchResults;
	String[] candidateNames = {"Clinton","Trump"};
	JLabel finalOrder;
	JButton[] candidateButton;
	int amountOfCandidates=2;
	
	public finalExam() {
		setSize(550,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		int amountOfCandidates = Integer.parseInt(JOptionPane.showInputDialog("How many candidates?"));
//		candidateNames = new String[amountOfCandidates];
//		for(int i=0;i<amountOfMeals;i++) {
//			candidateNames[i]=JOptionPane.showInputDialog(" Candidate #"+(i+1)+"?");
//		}
		
		//FIRST TAB
		//*********************************************************************************************************
		JTabbedPane tabbedPane = new JTabbedPane();
			JPanel northPanel = new JPanel();
			
				JLabel namePrompt = new JLabel("Name?");
					northPanel.add(namePrompt);
				nameField = new JTextField(8);
					northPanel.add(nameField);
				
				JLabel agePrompt = new JLabel("Age?");
					northPanel.add(agePrompt);
				ageField = new JTextField(8);
					northPanel.add(ageField);
				
				JLabel genderPrompt = new JLabel("Gender?");
					northPanel.add(genderPrompt);
				genderField = new JTextField(8);
					northPanel.add(genderField);
				
				candidateButton = new JButton[amountOfCandidates];
				for(int i=0;i<=amountOfCandidates-1;i++) {
					candidateButton[i] = new JButton(candidateNames[i]);
					candidateButton[i].addActionListener(this);
					northPanel.add(candidateButton[i]);
				}
				JButton submit = new JButton("Submit");
				submit.addActionListener(this);
				northPanel.add(submit);
		
		add(northPanel, BorderLayout.NORTH);
		tabbedPane.addTab("Ballot", northPanel);		
		
		//SECOND TAB
		//*********************************************************************************************************
		JPanel searchPanel = new JPanel();
		finalOrder = new JLabel();
//		searchPanel.add(finalOrder);
		
		JButton searchByName = new JButton("Search by Name");
		searchByName.addActionListener(this);
		searchPanel.add(searchByName);
		
			JLabel nameSearchLabel = new JLabel("What name do you wanna search");
			searchPanel.add(nameSearchLabel);
			
			nameSearchField = new JTextField(8);
			searchPanel.add(nameSearchField);
		
		JButton searchByGender = new JButton("Search by Gender");
		searchByGender.addActionListener(this);
		searchPanel.add(searchByGender);
		
			JLabel genderSearchLabel = new JLabel("What gender do you wanna search");
			searchPanel.add(genderSearchLabel);
			
			genderSearchField = new JTextField(8);
			searchPanel.add(genderSearchField);
		
		JButton searchByAge = new JButton("Search by Age");
		searchByAge.addActionListener(this);
		searchPanel.add(searchByAge);
		
			JLabel ageSearchLabel = new JLabel("What age do you wanna search");
			searchPanel.add(ageSearchLabel);
			
			ageSearchField = new JTextField(8);
			searchPanel.add(ageSearchField);
		
		searchResults = new JTextArea(20,8);
		searchPanel.add(searchResults);

		tabbedPane.addTab("Search",searchPanel);

		//THIRD TAB
		//*********************************************************************************************************
		JPanel resultsPanel = new JPanel();
		
		JButton getResultsButton = new JButton("Get Results");
			getResultsButton.addActionListener(this);
			resultsPanel.add(getResultsButton);
		
		JTextArea resultsArea = new JTextArea(20,20);
			resultsPanel.add(resultsArea);

		tabbedPane.addTab("Analysis", resultsPanel);
		
		
		add(tabbedPane);
	}
	
	ArrayList<String> name = new ArrayList<String>();
	ArrayList<Integer> age= new ArrayList<Integer>();
	ArrayList<String> gender = new ArrayList<String>();
	ArrayList<String> candidate = new ArrayList<String>();
	int counter=-1;
	String candidateChoice="";
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.err.println("Command "+command);

		for(int i=0;i<candidateNames.length;i++) {
			if(candidateButton[i].getText().equals(command)) {
				
				candidateChoice = command;
				System.out.println("You chose "+ candidateChoice);
			} else {
				candidateButton[i].setEnabled(false);
			}
		}
		

		if (command.equals("Submit")) {
			name.add(nameField.getText());
			age.add(Integer.parseInt(ageField.getText()));
			gender.add(genderField.getText());
			candidate.add(candidateChoice);
			
			counter++;
			System.out.println("Counter value: "+counter);
			
			finalOrder.setText(finalOrder.getText() +
					"\n" + name.get(counter) + 
					"\n" + "Age: " + age.get(counter) + 
					"\n" + "Gender: " + gender.get(counter) + 
					"\n"+ "Candidate: " + candidate.get(counter));
			
			
			//reset buttons and fields
			reset();

			System.out.println(finalOrder.getText() + " print label");

				System.out.println("PRINTINT ARRAYLISTS");
				System.out.println(name);
				System.out.println(age);
				System.out.println(gender);
				System.out.println(candidate);

		}
		
		else if(command.equals("Search by Name")) {
			searchResults.setText(system.searchName(name,candidate,nameSearchField.getText()));

			reset();
		}
		else if(command.equals("Search by Gender")) {
			searchResults.setText(system.searchGender(gender,candidate,genderSearchField.getText()));
			reset();
		}
		else if(command.equals("Search by Age")) {
			searchResults.setText(system.searchAge(age,candidate,ageSearchField.getText()));
			reset();
		}
		else if(command.equals("Get Results")) {
			system.analyze(name,age,gender,candidate,amountOfCandidates);
			reset();
		}
	}
	
	public void reset() {
		nameField.setText("");
		genderField.setText("");
		ageField.setText("");
		for (int i = 0; i <= candidateButton.length - 1; i++) {
			candidateButton[i].setEnabled(true);
		}
	}
}
