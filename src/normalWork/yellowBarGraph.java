package normalWork;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class yellowBarGraph extends Applet{
	int [] lengths = new int[4];
	public void init() {
		setSize(1000,500);
		setBackground(Color.RED);
		
		
		
	}
	
	public void start() {};
	
	public void stop() {};
	
	
	public void paint(Graphics g) {
		for(int i=0;i<=3;i++) {
			lengths[i]=(int)(Math.random()*500+1);
			System.out.println(lengths[i]);
		}

		lengths=viraj.util.Sort.insertion(lengths);
		
		
		g.fillRect(10, 10, lengths[0], 75);
		g.fillRect(10, 100, lengths[1], 75);
		g.fillRect(10, 200, lengths[2], 75);
		g.setColor(Color.YELLOW);
		g.fillRect(10, 300, lengths[3], 75);
		
	
		
		
	}
}
