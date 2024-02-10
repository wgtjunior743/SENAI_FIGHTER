package items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import collisions.Box;
import entities.Entity;
import entities.Players;
import main.Game;
import world.Camera;

public class thayulthorizontal extends Entity {

	private double dx;
	private double dy;
	private double spd = 4;

	private int life = 400, curLife = 0;

	public BufferedImage ulthorizontal;

	public Box hitboxult = new Box(0, 0, 0, 0, Color.cyan);

	public thayulthorizontal(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy) {
		super(x, y, width, height, sprite);

		hitboxult = new Box(0, 0, 0, 0, Color.cyan);

		ulthorizontal = Game.ulthorizontal.getSprite(0, 0, 45, 17);

		this.dx = dx;
		this.dy = dy;

	}

	public void tick() {

		hitboxult = new Box(getX() - Camera.x, getY() - 20 - Camera.y, 40, 23, Color.cyan);

		if (Game.char1 == "ThaianyP1") {

			if (hitboxult.intersects(Game.trainer.hitboxTR) || hitboxult.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxult.intersects(Game.MoisesP2.hitboxMOI) || hitboxult.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxult.intersects(Game.ThaianyP2.hitboxTH)) {

				for (Players playersbrabo : Game.players2) {

					playersbrabo.life -= 0.1;

					playersbrabo.stunnedbaixo = true;

				}

			}

		}

		if (Game.char1 == "ThaianyP2") {

			if (hitboxult.intersects(Game.trainer.hitboxTR) || hitboxult.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxult.intersects(Game.MoisesP1.hitboxMOI) || hitboxult.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxult.intersects(Game.ThaianyP1.hitboxTH)) {

				for (Players playersbrabo : Game.players) {

					playersbrabo.life -= 0.1;

					playersbrabo.stunnedbaixo = true;

				}

			}
		}

		x += dx * spd;
		y += dy * spd;
		curLife++;

		if (curLife == life) {

			Game.ulthoriz.remove(this);

		}

	}

	public void render(Graphics g) {

		// hitboxblocoright.DrawRect(g);
		// hitboxblocoleft.DrawRect(g);

		hitboxult.DrawRect(g);

		g.drawImage(ulthorizontal, getX() - Camera.x, getY() - 20 - Camera.y, 45, 17, null);

	}

}
