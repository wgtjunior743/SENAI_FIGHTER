package items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import collisions.Box;
import entities.Entity;

import main.Game;
import world.Camera;

public class roteador extends Entity {

	
	
	
	private BufferedImage[] rot;

	private int life = 1000, curLife = 0;
	public static boolean rotmov = false;
	public static  boolean teleporte = false;
	public static boolean teleporte2 = false;
	private int framesrotmov = 0;
	private int maxFramesrotmov = 15;
	private int indexrotmov = 0;
	private int maxIndexrotmov = 2;

	private String Player;

	public roteador(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy, String Player) {
		super(x, y, width, height, sprite);

		rot = new BufferedImage[3];

		for (int i = 0; i < 3; i++) {
			rot[i] = Game.rotright.getSprite(0 + (i * 24), 0, 24, 20);

		}

		this.Player = Player;

	}

	public void tick() {

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

		if (teleporte && Player == "Player1") {

			teleporte = false;
			Game.MoisesP1.setX(this.getX() -18);
			Game.MoisesP1.setY(this.getY() - 80);
			Game.MoisesP1.maxSkillRot -= 1;
			
			Game.rots.remove(this);

		}

		if (teleporte2 && Player == "Player2") {

			teleporte2 = false;
			Game.MoisesP2.setX(this.getX()-18);
			Game.MoisesP2.setY(this.getY() - 80);
			Game.MoisesP2.maxSkillRot -= 1;
		
			Game.rots2.remove(this);

		}
	}

	public void render(Graphics g) {

		if (Game.MoisesP1.dirM == Game.MoisesP1.right_dirM || Game.MoisesP1.dirM == Game.MoisesP1.left_dirM) {

			g.drawImage(rot[indexrotmov], getX() - 10 - Camera.x, getY() - 25 - Camera.y, 35, 25, null);

		}

		/*
		 * g.setColor(Color.YELLOW); g.fillOval(this.getX() - Camera.x, this.getY() -
		 * Camera.y, width, height);
		 */
	}

}
