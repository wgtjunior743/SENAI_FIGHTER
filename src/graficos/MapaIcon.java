package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;



public class MapaIcon {
	
	private BufferedImage mapaicon;

public MapaIcon(String path) {
		
		try {
			mapaicon = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public BufferedImage getIcon(int x, int y, int width, int height) {

		return mapaicon.getSubimage(x, y, width, height);
	}

}
