package normalWork;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class gpaSort extends JFrame implements ActionListener{
	static int amount;
	static JTextArea[] input;
	
	public static void main(String []args) {
//		amount = Integer.parseInt(JOptionPane.showInputDialog("How many GPA's"));
		amount=5;
		gpaSort obj = new gpaSort();
		obj.setVisible(true);
	}
	
	public gpaSort() {
		super("goa");
		setSize(700,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		input = new JTextArea[amount];
		JPanel nPanel = new JPanel();
		for(int i=0;i<=amount-1;i++) {
			JLabel gpaLabel = new JLabel("GPA #"+i);
			input[i] = new JTextArea(1,3);
			
			nPanel.add(gpaLabel);
			nPanel.add(input[i]);
		}
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(this);
		add(submit, BorderLayout.SOUTH);
		
		
		add(nPanel, BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double [] gpas = new double[amount];
		System.out.println(e.getActionCommand());

		for(int i=0;i<=amount-1;i++) {
			gpas[i]=Double.parseDouble(input[i].getText());
//			System.out.println(gpas[i]);
			
			
		}
		String girng="";
		double [] sorted = viraj.util.Sort.selection(gpas);
		for(int i=0;i<=sorted.length-1;i++) {
			girng += (sorted[i]+"\n");
		}
		JOptionPane.showMessageDialog(null, girng);
	}
}
