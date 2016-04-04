package drawing;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class NoGreen {
	public static void main(String [] args) throws IOException{
		File input = new File("viraj.jpg");
		BufferedImage image = ImageIO.read(input);
		removeGreen(image);
		File output = new File("greenDelete"+input.getName()+".jpg");
		ImageIO.write(image, "jpg", output);
	}
	
	public static void removeGreen(BufferedImage p){
		int width = p.getWidth();
		int height = p.getHeight();
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				Color c = new Color(p.getRGB(j, i));
				Color newColor = new Color(c.getRed(), 0, c.getBlue());
				p.setRGB(j, i, newColor.getRGB());
			}
		}
	}
}
	