package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Caras {

	
private BufferedImage Cara;
	
	public Caras(String path) {
		
		try {
			Cara = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public BufferedImage getCara(int x, int y, int width, int height) {

		return Cara.getSubimage(x, y, width, height);
	}

	
	
}
