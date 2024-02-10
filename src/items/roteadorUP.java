package items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import entities.Entity;
import main.Game;
import world.Camera;

public class roteadorUP extends Entity {
	

	private BufferedImage[] rot;
	
	private double dx;
	private double dy;
	private double spd = 4;
	
	private int life = 10, curLife = 0;
	public boolean rotmov = false;
	public  boolean teleporteUP = false;
	private int framesrotmov = 0;
	private int maxFramesrotmov = 15;
	private int indexrotmov = 0;
	private int maxIndexrotmov = 2;

	
	private int tpframes = 0;

	private int maxFramestp = 50;

	private String Player;

	public boolean teleporteUP2 = false;

	private int tpframes2 = 0;

	private int maxFramestp2 = 50;

	public static boolean teste = false;

	public roteadorUP(int x, int y, int width, int height, BufferedImage sprite, double dx , double dy, String Player) {
		super(x, y, width, height, sprite);

		rot = new BufferedImage[3];

		for (int i = 0; i < 3; i++) {
			rot[i] = Game.rotright.getSprite( + (i * 24), 0, 24, 20);
			

			this.dx = dx ;
			this.dy = dy;
			this.Player = Player;

		}
	}
	
	public void tick() {

		
		y += dy * spd;

		
		if (curLife == life) {
			Game.rotsup.remove(this);
			return;
		}
		
		if (rotmov == true) {

			framesrotmov++;
			if (framesrotmov == maxFramesrotmov) {

				framesrotmov = 0;
				indexrotmov++;
				if (indexrotmov > maxIndexrotmov) {
					indexrotmov = 0;
					
					
				}
			}

		}

	
		/*
		 * if (curLife == life) { Game.pcs.remove(this); return; }
		 */

		
		
		if (teleporteUP && Player == "Player1") {
			tpframes++;
			while (tpframes == maxFramestp) {

				teleporteUP = false;
				Game.MoisesP1.setX(this.getX());
				Game.MoisesP1.setY(this.getY()-80);
				Game.MoisesP1.maxSkillRotUp -= 1;
				Game.rotsup.remove(this);
				tpframes = 0;

				
			}
			
			

		}
		
		if (teleporteUP2 && Player == "Player2") {
			tpframes2++;
			while (tpframes2 == maxFramestp2 ) {

				teleporteUP2 = false;
				Game.MoisesP2.setX(this.getX());
				Game.MoisesP2.setY(this.getY()-80);
				Game.MoisesP2.maxSkillRotUp -= 1;
				Game.rotsup2.remove(this);
				tpframes2 = 0;

				
			}
		}
		
	}

	public void render(Graphics g) {

		
		if (Game.MoisesP1.dirM == Game.MoisesP1.right_dirM || Game.MoisesP1.dirM == Game.MoisesP1.left_dirM  ) {
			
			g.drawImage(rot[indexrotmov], getX()+5 - Camera.x, getY() - 25 - Camera.y, 35, 25, null);

		}

	

		/*
		 * g.setColor(Color.YELLOW); g.fillOval(this.getX() - Camera.x, this.getY() -
		 * Camera.y, width, height);
		 */
	}

}
