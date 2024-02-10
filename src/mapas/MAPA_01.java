package mapas;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MAPA_01 {

	private BufferedImage MAPA01_FUNDO;
	private BufferedImage MAPA01_CHAO;

	public MAPA_01(String path, String path2) {

		try {
			MAPA01_FUNDO = ImageIO.read(getClass().getResource(path));
			MAPA01_CHAO = ImageIO.read(getClass().getResource(path2));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public BufferedImage getMAPA_01_FUNDO(int x, int y, int width, int height) {

		return MAPA01_FUNDO.getSubimage(x, y, width, height);
	}

	public BufferedImage getMAPA_01_CHAO(int x, int y, int width, int height) {

		return MAPA01_CHAO.getSubimage(x, y, width, height);
	}

}
