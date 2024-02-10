package items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import collisions.Box;
import entities.Entity;
import entities.Players;
import main.Game;
import world.Camera;

public class Bullets extends Entity {

	private double dx;
	private double dy;
	private double spd = 4;

	private Box bulletbox = new Box(0, 0, 0, 0, null);

	private int life = 30, curLife = 0;
	private mirault mira;
	public boolean bulletdead = false;

	public Bullets(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy) {
		super(x, y, width, height, sprite);

		bulletbox = new Box(0, 0, 0, 0, null);

		this.y = y;
		this.dx = dx;
		this.dy = dy;

	}

	public void tick() {

		if (Game.MaxuelP1.dirM == Game.MaxuelP1.right_dirM) {

			x += 100 / 2;

			bulletbox = new Box((int) x -50 - Camera.x, getY() - Camera.y, 500, height, null);

		}

		if (Game.MaxuelP1.dirM == Game.MaxuelP1.left_dirM) {

			x -= 100 / 2;

			bulletbox = new Box((int) x  + 50- Camera.x, getY() - Camera.y, 500, height, null);

		}
		
		
		
		

		

		if (Game.char1 == "MaxuelP1") {

			if (bulletbox.intersects(Game.trainer.hitboxTR) || bulletbox.intersects(Game.MoisesP2.hitboxMOI)
					|| bulletbox.intersects(Game.MaxuelP2.hitboxMX) || bulletbox.intersects(Game.IvanildoP2.hitboxIV)
					|| bulletbox.intersects(Game.PhellipeP2.hitboxPH)
					|| bulletbox.intersects(Game.ThaianyP2.hitboxTH)) {

				
				System.out.println("RAAAAAAAAA");
				for (Players playersbrabo : Game.players2) {

					playersbrabo.life -= 0.5;
				}
			}
		
		}
			

		if (Game.char2 == "MaxuelP2") {

			if (bulletbox.intersects(Game.MoisesP1.hitboxMOI) || bulletbox.intersects(Game.MaxuelP1.hitboxMX)
					|| bulletbox.intersects(Game.IvanildoP1.hitboxIV) || bulletbox.intersects(Game.PhellipeP1.hitboxPH)
					|| bulletbox.intersects(Game.ThaianyP1.hitboxTH)) {

				System.out.println("RAAAAAAAAA");
				for (Players playersbrabo : Game.players) {

					playersbrabo.life -= 0.5;
				}
			}
		}

		curLife++;
		if (curLife == life)

		{

			bulletdead = true;
			Game.bullets.remove(this);
			return;
		}
	}

	public void render(Graphics g) {

		if (Game.MaxuelP1.dirM == Game.MaxuelP1.right_dirM) {
			//g.drawRect(getX()+300, getY()+175, width, height);
		}

		if (Game.MaxuelP1.dirM == Game.MaxuelP1.left_dirM) {

			//g.drawRect(getX()+300, getY()+175, width, height);
		}

		g.setColor(Color.BLACK);
		bulletbox.DrawRect(g);
		
		
		g.setColor(Color.cyan);
		g.fillOval((int) x - Camera.x, getY() - Camera.y, width, height);

	}
}
