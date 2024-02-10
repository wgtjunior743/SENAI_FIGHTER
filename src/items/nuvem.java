package items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import collisions.Box;
import entities.Entity;
import entities.Players;
import main.Game;
import world.Camera;

public class nuvem extends Entity {

	private double dx;
	private double dy;
	private double spd = 4;

	private int life = 600, curLife = 0;

	public static Box hitboxnuvem = new Box(0, 0, 0, 0, Color.cyan);;

	public BufferedImage nuvem;

	public nuvem(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy) {
		super(x, y, width, height, sprite);

		hitboxnuvem = new Box(0, 0, 0, 0, Color.cyan);

		this.dx = dx;
		this.dy = dy;

		nuvem = Game.nuvemsprite.getSprite(0, 0, 40, 23);

	}

	public void tick() {

		hitboxnuvem = new Box(getX() - Camera.x, getY() - 20 - Camera.y, 40, 23, Color.cyan);

		if (Game.char1 == "ThaianyP1") {

			for (Players playersbrabo : Game.players2) {

				if (playersbrabo.SETA == true && hitboxnuvem.intersects(Game.trainer.hitboxTR)) {

					playersbrabo.life -= 10;

					playersbrabo.stunnedmedio = true;
					Game.nuvens.remove(this);

				}

			}

		}

		if (Game.char1 == "ThaianyP2") {

			for (Players playersbrabo : Game.players) {

				if (playersbrabo.SETA == true && hitboxnuvem.intersects(Game.trainer.hitboxTR)) {

					playersbrabo.life -= 10;

					playersbrabo.stunnedmedio = true;
					
					Game.nuvens.remove(this);

				}

			}

		}

		x += dx * spd;
		y += dy * spd;
		curLife++;

		if (curLife == life) {

			Game.nuvens.remove(this);

		}

	}

	public void render(Graphics g) {

		hitboxnuvem.DrawRect(g);

		g.drawImage(nuvem, getX() - Camera.x, getY() - 20 - Camera.y, 40, 23, null);

	}

}
