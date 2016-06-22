package normalWork;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class LunchMenu extends JFrame implements ActionListener{
	
	
	public static void main(String []args) {
		LunchMenu obj = new LunchMenu();
		obj.setVisible(true);
	}

	JTextField nameField, gradeField;
	String[] mealNames;
	JLabel finalOrder;
	JButton[] mealsButton;
	
	public LunchMenu() {
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int amountOfMeals = Integer.parseInt(JOptionPane.showInputDialog("How many meals"));
		mealNames = new String[amountOfMeals];
		for(int i=0;i<amountOfMeals;i++) {
			mealNames[i]=JOptionPane.showInputDialog("Meal #"+(i+1)+"?");
		}
		
		JTabbedPane tabbedPane = new JTabbedPane();
			JPanel northPanel = new JPanel();
			
				JLabel namePrompt = new JLabel("Name?");
				northPanel.add(namePrompt);
				nameField = new JTextField(8);
				northPanel.add(nameField);
				
				JLabel gradePrompt = new JLabel("Grade?");
				northPanel.add(gradePrompt);
				gradeField = new JTextField(8);
				northPanel.add(gradeField);
				
				mealsButton = new JButton[amountOfMeals];
				for(int i=0;i<=amountOfMeals-1;i++) {
					mealsButton[i] = new JButton(mealNames[i]);
					mealsButton[i].addActionListener(this);
					northPanel.add(mealsButton[i]);
				}
				JButton submit = new JButton("Submit");
				submit.addActionListener(this);
				northPanel.add(submit);
		
		add(northPanel, BorderLayout.NORTH);
		tabbedPane.addTab("Order", northPanel);		
		add(tabbedPane);
		
		JPanel submitPanel = new JPanel();
		finalOrder = new JLabel();
		submitPanel.add(finalOrder);
		tabbedPane.addTab("Submit",submitPanel);

		
	}
	
	ArrayList<String> name = new ArrayList<String>();
	ArrayList<Integer> grade= new ArrayList<Integer>();
	ArrayList<String> order = new ArrayList<String>();
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand(),mealChoice="";
		name.add(nameField.getText());
		grade.add(Integer.parseInt(gradeField.getText()));
		
		
		System.out.println(command);
		
		for(int i=0;i<mealNames.length;i++) {
			if(mealsButton[i].getText().equals(command)) {
				mealChoice = command;
			}
			else {
				mealsButton[i].setEnabled(false);
			}
		}
		order.add(mealChoice);
		
		if(command.equals("Submit")) {
			
			for(int i=0; i<=name.size()-1;i++) {
				
				try {
					mealsButton[i].setEnabled(true);
					finalOrder.setText(finalOrder.getText()+"\n"+name.get(i)+"\n"+"Grade"+grade.get(i)+"\n"+"Order:"+order.get(i));
					System.out.println();
					System.out.println(finalOrder.getText()+"print label"); 
					System.out.println();
				} catch (IndexOutOfBoundsException e1) {
					e1.printStackTrace();
				}
				nameField.setText("");
				gradeField.setText("");
			}
			
		
			
		}
		
		
	}
}
