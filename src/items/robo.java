package items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import collisions.Box;
import entities.Entity;
import entities.Players;
import main.Game;
import world.Camera;

public class robo extends Entity {

	public static Box hitboxrobo = new Box(0, 0, 0, 0, Color.cyan);

	public BufferedImage roboright;

	public BufferedImage roboleft;

	private double dx;
	private double dy;
	private double spd = 4;

	private int life = 100, curLife = 0;

	public robo(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy) {
		super(x, y, width, height, sprite);

		roboleft = Game.ivanildoskill2.getSprite(30, 30, 49, 62);
		roboright = Game.ivanildoskill2.getSprite(30, 153, 49, 62);

		this.dx = dx;
		this.dy = dy;

		hitboxrobo = new Box(0, 0, 0, 0, Color.cyan);

	}

	public void tick() {

		hitboxrobo = new Box(getX() - Camera.x, getY() - Camera.y, 49, 62, Color.cyan);

		if (Game.char1 == "IvanildoP1") {
			if (hitboxrobo.intersects(Game.trainer.hitboxTR) || hitboxrobo.intersects(Game.MaxuelP2.hitboxMX)

					|| hitboxrobo.intersects(Game.MoisesP2.hitboxMOI)

					|| hitboxrobo.intersects(Game.PhellipeP2.hitboxPH)

					|| hitboxrobo.intersects(Game.IvanildoP2.hitboxIV)

					|| hitboxrobo.intersects(Game.ThaianyP2.hitboxTH)) {
				
				Game.IvanildoP1.energy += 5;
				Game.IvanildoP1.ult += 5;

				if (Game.PhellipeP1.MODERONALD == false) {
					Game.PhellipeP1.RONALDBAR += 5;

				}

				if (Game.PhellipeP2.MODERONALD == false) {
					Game.PhellipeP2.RONALDBAR += 5;

				}
				
				for (Players playersbrabo : Game.players2) {

					playersbrabo.life -= 10;
					Game.robos.remove(this);

					if (Game.IvanildoP1.LEFTPUSH == true) {

						playersbrabo.stunnedmedio = true;
						playersbrabo.LEFTPUSHMEDIO = true;

					}
					playersbrabo.stunnedmedio = true;

					if (Game.IvanildoP1.RIGHTPUSH == true) {

						playersbrabo.stunnedmedio = true;
						playersbrabo.RIGHTPUSHMEDIO = true;

					}
				}

			}

		}

		if (Game.char2 == "IvanildoP2") {
			if (hitboxrobo.intersects(Game.trainer.hitboxTR) || hitboxrobo.intersects(Game.MaxuelP1.hitboxMX)

					|| hitboxrobo.intersects(Game.MoisesP1.hitboxMOI)

					|| hitboxrobo.intersects(Game.PhellipeP1.hitboxPH)

					|| hitboxrobo.intersects(Game.IvanildoP1.hitboxIV)

					|| hitboxrobo.intersects(Game.ThaianyP1.hitboxTH)) {

				
				Game.IvanildoP2.energy += 5;
				Game.IvanildoP2.ult += 5;
				
				for (Players playersbrabo : Game.players) {

					playersbrabo.life -= 10;
					Game.robos.remove(this);

					if (Game.IvanildoP1.LEFTPUSH == true) {

						playersbrabo.stunnedmedio = true;
						playersbrabo.LEFTPUSHMEDIO = true;

					}
					playersbrabo.stunnedmedio = true;

					if (Game.IvanildoP1.RIGHTPUSH == true) {

						playersbrabo.stunnedmedio = true;
						playersbrabo.RIGHTPUSHMEDIO = true;

					}
				}

			}

		}

		x += dx * spd;
		y += dy * spd;
		curLife++;

		if (curLife == life) {

			Game.robos.remove(this);

		}

	}

	public void render(Graphics g) {

		hitboxrobo.DrawRect(g);

		if (Game.IvanildoP1.dirI == Game.IvanildoP1.right_dirI) {

			g.drawImage(roboright, getX() - Camera.x, getY() - Camera.y, 49, 62, null);
		}

		if (Game.IvanildoP1.dirI == Game.IvanildoP1.left_dirI) {

			g.drawImage(roboleft, getX() + 20 - Camera.x, getY() - Camera.y, 49, 62, null);
		}

	}

}
