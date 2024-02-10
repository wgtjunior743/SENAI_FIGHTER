package graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

import main.Game;

public class UI {

	public void renderPlayerPH1(Graphics g) {

		AffineTransform mirrorTransform = new AffineTransform();
		mirrorTransform.scale(-1, 1);

		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.ORANGE);
		g2.fillRect(108, 45, (int) ((Game.PhellipeP1.RONALDBAR / Game.PhellipeP1.RONALDBARMAX) * 160), 4);

		AffineTransform originalTransform = g2.getTransform();

		g2.transform(mirrorTransform);

		Color color1 = new Color(20, 232, 9);
	
		
		g2.setColor(Color.red);
		g2.fillRect(-295, 10, 280, 20);

		g2.setColor(color1);
		g2.fillRect(-295, 10, (int) ((Game.PhellipeP1.life / Game.PhellipeP1.maxlife) * 280), 20);

		g2.drawImage(Game.VIDAINVERSO.getSprite(0, 0, 305, 34), -308, 4, null, null);

		g2.drawImage(Game.ENERGIAINVERSO.getSprite(0, 0, 173, 13), -278, 40, null, null);

	}

	public void renderPlayerMOI1(Graphics g) {

		AffineTransform mirrorTransform = new AffineTransform();
		mirrorTransform.scale(-1, 1);

		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.blue);
		g2.fillRect(108, 45, (int) ((Game.MoisesP1.energy / Game.MoisesP1.maxenergy) * 160), 4);

		g2.setColor(Color.magenta);
		g2.fillRect(108, 65, (int) ((Game.MoisesP1.ult / Game.MoisesP1.maxult) * 160), 4);
		g2.setColor(Color.RED);

		AffineTransform originalTransform = g2.getTransform();

		g2.transform(mirrorTransform);

		g2.setColor(Color.red);
		g2.fillRect(-295, 10, 280, 20);

		Color color1 = new Color(20, 232, 9);
		
		
		g2.setColor(color1);
		g2.fillRect(-295, 10, (int) ((Game.MoisesP1.life / Game.MoisesP1.maxlife) * 280), 20);

		g2.drawImage(Game.VIDAINVERSO.getSprite(0, 0, 305, 34), -308, 4, null, null);

		g2.drawImage(Game.ENERGIAINVERSO.getSprite(0, 0, 173, 13), -278, 40, null, null);

		g2.drawImage(Game.ENERGIAINVERSO.getSprite(0, 0, 173, 13), -278, 60, null, null);

	}
	
	public void renderPlayerMAX1(Graphics g) {

		AffineTransform mirrorTransform = new AffineTransform();
		mirrorTransform.scale(-1, 1);

		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.blue);
		g2.fillRect(108, 45, (int) ((Game.MaxuelP1.energy / Game.MaxuelP1.maxenergy) * 160), 4);

		g2.setColor(Color.magenta);
		g2.fillRect(108, 65, (int) ((Game.MaxuelP1.ult / Game.MaxuelP1.maxult) * 160), 4);
		g2.setColor(Color.RED);

		AffineTransform originalTransform = g2.getTransform();

		g2.transform(mirrorTransform);

		Color color1 = new Color(20, 232, 9);
		
		
		g2.setColor(Color.red);
		g2.fillRect(-295, 10, 280, 20);

		g2.setColor(color1);
		g2.fillRect(-295, 10, (int) ((Game.MaxuelP1.life / Game.MaxuelP1.maxlife) * 280), 20);

		g2.drawImage(Game.VIDAINVERSO.getSprite(0, 0, 305, 34), -308, 4, null, null);

		g2.drawImage(Game.ENERGIAINVERSO.getSprite(0, 0, 173, 13), -278, 40, null, null);

		g2.drawImage(Game.ENERGIAINVERSO.getSprite(0, 0, 173, 13), -278, 60, null, null);

	}
	
	public void renderPlayerIV1(Graphics g) {

		AffineTransform mirrorTransform = new AffineTransform();
		mirrorTransform.scale(-1, 1);

		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.blue);
		g2.fillRect(108, 45, (int) ((Game.IvanildoP1.energy / Game.IvanildoP1.maxenergy) * 160), 4);

		g2.setColor(Color.magenta);
		g2.fillRect(108, 65, (int) ((Game.IvanildoP1.ult / Game.IvanildoP1.maxult) * 160), 4);
		g2.setColor(Color.RED);

		AffineTransform originalTransform = g2.getTransform();

		g2.transform(mirrorTransform);

		g2.setColor(Color.red);
		g2.fillRect(-295, 10, 280, 20);

		Color color1 = new Color(20, 232, 9);
		
		
		g2.setColor(color1);
		g2.fillRect(-295, 10, (int) ((Game.IvanildoP1.life / Game.IvanildoP1.maxlife) * 280), 20);

		g2.drawImage(Game.VIDAINVERSO.getSprite(0, 0, 305, 34), -308, 4, null, null);

		g2.drawImage(Game.ENERGIAINVERSO.getSprite(0, 0, 173, 13), -278, 40, null, null);

		g2.drawImage(Game.ENERGIAINVERSO.getSprite(0, 0, 173, 13), -278, 60, null, null);

	}
	
	public void renderPlayerTH1(Graphics g) {

		AffineTransform mirrorTransform = new AffineTransform();
		mirrorTransform.scale(-1, 1);

		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.blue);
		g2.fillRect(108, 45, (int) ((Game.ThaianyP1.energy / Game.ThaianyP1.maxenergy) * 160), 4);

		g2.setColor(Color.magenta);
		g2.fillRect(108, 65, (int) ((Game.ThaianyP1.ult / Game.ThaianyP1.maxult) * 160), 4);
		g2.setColor(Color.RED);

		AffineTransform originalTransform = g2.getTransform();

		g2.transform(mirrorTransform);

		g2.setColor(Color.red);
		g2.fillRect(-295, 10, 280, 20);

		Color color1 = new Color(20, 232, 9);
		
		
		g2.setColor(color1);
		g2.fillRect(-295, 10, (int) ((Game.ThaianyP1.life / Game.ThaianyP1.maxlife) * 280), 20);

		g2.drawImage(Game.VIDAINVERSO.getSprite(0, 0, 305, 34), -308, 4, null, null);

		g2.drawImage(Game.ENERGIAINVERSO.getSprite(0, 0, 173, 13), -278, 40, null, null);

		g2.drawImage(Game.ENERGIAINVERSO.getSprite(0, 0, 173, 13), -278, 60, null, null);

	}
	
	

	public void renderPlayerPH2(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.red);
		g2.fillRect(602, 10, 280, 20);
		
		Color color1 = new Color(20, 232, 9);
		

		g2.setColor(color1);
		g2.fillRect(602, 10, (int) ((Game.PhellipeP2.life / Game.PhellipeP2.maxlife) * 280), 20);

		g2.setColor(Color.ORANGE);
		g2.fillRect(790 - (int) ((Game.PhellipeP2.RONALDBAR / Game.PhellipeP2.RONALDBARMAX) * 160), 45, (int) ((Game.PhellipeP2.RONALDBAR / Game.PhellipeP2.RONALDBARMAX) * 160), 4);

		g2.drawImage(Game.VIDAINVERSO.getSprite(0, 0, 305, 34), 590, 4, null, null);

		g2.drawImage(Game.ENERGIAINVERSO.getSprite(0, 0, 173, 13), 620, 40, null, null);
		
	

	}

	public void renderPlayerMOI2(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.red);
		g2.fillRect(602, 10, 280, 20);
	
		Color color1 = new Color(20, 232, 9);
		
		
		g2.setColor(color1);
		g2.fillRect(602, 10, (int) ((Game.MoisesP2.life / Game.MoisesP2.maxlife) * 280), 20);
		
		
		g2.drawImage(Game.VIDAINVERSO.getSprite(0, 0, 305, 34), 590, 4, null, null);
		
		g.setColor(Color.blue);
		g.fillRect(790  -  (int) ((Game.MoisesP2.energy / Game.MoisesP2.maxenergy) * 160), 45, (int) ((Game.MoisesP2.energy / Game.MoisesP2.maxenergy) * 160), 4);

		g.setColor(Color.magenta);
		g.fillRect(790  - (int) ((Game.MoisesP2.ult / Game.MoisesP2.maxult) * 160) ,  65, (int) ((Game.MoisesP2.ult / Game.MoisesP2.maxult) * 160), 4);
		g.setColor(Color.RED);

		
		g2.drawImage(Game.ENERGIAINVERSO.getSprite(0, 0, 173, 13), 620, 40, null, null);

		g2.drawImage(Game.ENERGIAINVERSO.getSprite(0, 0, 173, 13), 620, 60, null, null);
	}
	
	public void renderPlayerMAX2(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		
		Color color1 = new Color(20, 232, 9);
		
		
		g2.setColor(Color.red);
		g2.fillRect(602, 10, 280, 20);
	
		g2.setColor(color1);
		g2.fillRect(602, 10, (int) ((Game.MaxuelP2.life / Game.MaxuelP2.maxlife) * 280), 20);
		
		
		g2.drawImage(Game.VIDAINVERSO.getSprite(0, 0, 305, 34), 590, 4, null, null);
		
		g.setColor(Color.blue);
		g.fillRect(790  -  (int) ((Game.MaxuelP2.energy / Game.MaxuelP2.maxenergy) * 160), 45, (int) ((Game.MaxuelP2.energy / Game.MaxuelP2.maxenergy) * 160), 4);

		g.setColor(Color.magenta);
		g.fillRect(790  - (int) ((Game.MaxuelP2.ult / Game.MaxuelP2.maxult) * 160) ,  65, (int) ((Game.MaxuelP2.ult / Game.MaxuelP2.maxult) * 160), 4);
		g.setColor(Color.RED);

		
		g2.drawImage(Game.ENERGIAINVERSO.getSprite(0, 0, 173, 13), 620, 40, null, null);

		g2.drawImage(Game.ENERGIAINVERSO.getSprite(0, 0, 173, 13), 620, 60, null, null);
	}
	
	
	public void renderPlayerIV2(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		
		Color color1 = new Color(20, 232, 9);
		
		
		g2.setColor(Color.red);
		g2.fillRect(602, 10, 280, 20);
	
		g2.setColor(color1);
		g2.fillRect(602, 10, (int) ((Game.IvanildoP2.life / Game.IvanildoP2.maxlife) * 280), 20);
		
		
		g2.drawImage(Game.VIDAINVERSO.getSprite(0, 0, 305, 34), 590, 4, null, null);
		
		g.setColor(Color.blue);
		g.fillRect(790  -  (int) ((Game.IvanildoP2.energy / Game.IvanildoP2.maxenergy) * 160), 45, (int) ((Game.IvanildoP2.energy / Game.IvanildoP2.maxenergy) * 160), 4);

		g.setColor(Color.magenta);
		g.fillRect(790  - (int) ((Game.IvanildoP2.ult / Game.IvanildoP2.maxult) * 160) ,  65, (int) ((Game.IvanildoP2.ult / Game.IvanildoP2.maxult) * 160), 4);
		g.setColor(Color.RED);

		
		g2.drawImage(Game.ENERGIAINVERSO.getSprite(0, 0, 173, 13), 620, 40, null, null);

		g2.drawImage(Game.ENERGIAINVERSO.getSprite(0, 0, 173, 13), 620, 60, null, null);
	}
	
	
	
	public void renderPlayerTH2(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		
		Color color1 = new Color(20, 232, 9);
		
		
		g2.setColor(Color.red);
		g2.fillRect(602, 10, 280, 20);
	
		g2.setColor(color1);
		g2.fillRect(602, 10, (int) ((Game.ThaianyP2.life / Game.ThaianyP2.maxlife) * 280), 20);
		
		
		g2.drawImage(Game.VIDAINVERSO.getSprite(0, 0, 305, 34), 590, 4, null, null);
		
		g.setColor(Color.blue);
		g.fillRect(790  -  (int) ((Game.ThaianyP2.energy / Game.ThaianyP2.maxenergy) * 160), 45, (int) ((Game.ThaianyP2.energy / Game.ThaianyP2.maxenergy) * 160), 4);

		g.setColor(Color.magenta);
		g.fillRect(790  - (int) ((Game.ThaianyP2.ult / Game.ThaianyP2.maxult) * 160) ,  65, (int) ((Game.ThaianyP2.ult / Game.ThaianyP2.maxult) * 160), 4);
		g.setColor(Color.RED);

		
		g2.drawImage(Game.ENERGIAINVERSO.getSprite(0, 0, 173, 13), 620, 40, null, null);

		g2.drawImage(Game.ENERGIAINVERSO.getSprite(0, 0, 173, 13), 620, 60, null, null);
	}
	
	

	public void renderPorrada(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.red);
		g2.fillRect(602, 10, 280, 20);
	
		Color color1 = new Color(20, 232, 9);
		
		
		g2.setColor(color1);
		g2.fillRect(602, 10, (int) ((Game.trainer.life / Game.trainer.maxlife) * 280), 20);
		
		
		g2.drawImage(Game.VIDAINVERSO.getSprite(0, 0, 305, 34), 590, 4, null, null);

	}

}
