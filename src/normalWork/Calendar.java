package normalWork;
import javax.swing.JOptionPane;

import viraj.util.Arrays;

public class Calendar {
	static int xx=7;
	static int yy=13;
	static int zz=2;
	
	static String [] times = {"6:00","7:00","8:00","9:00","10:00","11:00","12:00","1:00","2:00","3:00","4:00","5:00","6:00"};
	static String [] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

	
	public static void main (String [] args) {
		String [][][] calendar = new String[xx][yy][zz];
		
		
		
		for(int i=0; i<=xx-1;i++) {
			for(int k=0;k<=12;k++) {
				calendar[i][k][0]=times[k]+": ";
			}
		}
		printArray(calendar);
		
		while (true) {
			int choiceDay = JOptionPane.showOptionDialog(null, "Day?", "Choose an option", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, days, days);
			int choiceTime = JOptionPane.showOptionDialog(null, "Time?", "Choose an option", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, times, times);
			System.out.println(choiceDay);
			System.out.println(choiceTime);
			String event = JOptionPane.showInputDialog("Whats the event?");
			calendar[choiceDay][choiceTime][1] = event;
			printArray(calendar);
		}
	}
	
	public static void printArray(String [][][] calendar) {
		for(int x=0;x<=xx-1;x++) {
			System.out.println(days[x]);
			for(int y=0;y<=yy-1;y++) {
				for(int z=0;z<=zz-1;z++) {
					System.out.print(calendar[x][y][z]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
