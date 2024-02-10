package items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import collisions.Box;
import entities.Entity;
import entities.Players;
import main.Game;
import world.Camera;

public class mouse extends Entity {

	private BufferedImage[] mouseright;
	private BufferedImage[] mouseleft;

	private double dx;
	private double dy;
	private double spd = 4;

	private int life = 70, curLife = 0;
	public static boolean mousemov = true;
	private int framesmousemov = 0;
	private int maxFramesmousemov = 10;
	private int indexmousemov = 0;
	private int maxIndexmousemov = 2;
	private String player;

	static Box hitboxMouse;

	public mouse(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy, String player) {
		super(x, y, width, height, sprite);

		mouseright = new BufferedImage[3];
		mouseleft = new BufferedImage[3];

		for (int i = 0; i < 3; i++) {
			mouseleft[i] = Game.mouseleft.getSprite(1 + (i * 32), 0, 33, 20);

		}
		for (int i = 0; i < 3; i++) {
			mouseright[i] = Game.mouseright.getSprite(0 + (i * 32), 0, 33, 20);

		}

		this.dx = dx;
		this.dy = dy;
		this.player = player;

	}

	public void tick() {

		hitboxMouse = new Box(getX() - Camera.x, getY() - 20 - Camera.y, 20, 20, Color.cyan);

		x += dx * spd;
		y += dy * spd;
		curLife++;

		if (mousemov == true) {

			framesmousemov++;
			if (framesmousemov == maxFramesmousemov) {

				framesmousemov = 0;
				indexmousemov++;
				if (indexmousemov > maxIndexmousemov) {
					indexmousemov = 0;
				}
			}

		}

		if (curLife == life) {
			Game.mouses2.remove(this);

			hitboxMouse = new Box(0, 0, 0, 0, Color.cyan);
			if (Game.MoisesP1.RIGHT == true) {

				Game.MoisesP1.RIGHT = false;
			}

			if (Game.MoisesP1.LEFT == true) {

				Game.MoisesP1.LEFT = false;
			}

			if (Game.MoisesP2.RIGHT == true) {

				Game.MoisesP2.RIGHT = false;
			}

			if (Game.MoisesP2.LEFT == true) {

				Game.MoisesP2.LEFT = false;
			}

			return;
		}

		if (player == "Player1" && hitboxMouse.intersects(Game.MoisesP2.hitboxMOI)
				|| hitboxMouse.intersects(Game.PhellipeP2.hitboxPH) || hitboxMouse.intersects(Game.trainer.hitboxTR)
				|| hitboxMouse.intersects(Game.MaxuelP2.hitboxMX) || hitboxMouse.intersects(Game.IvanildoP2.hitboxIV)
				|| hitboxMouse.intersects(Game.ThaianyP2.hitboxTH)) {
			Game.mouses.remove(this);

			for (Players playersbrabo : Game.players2) {
				Game.MoisesP1.energy += 2;
				Game.MoisesP1.ult += 2;
				if (Game.PhellipeP1.MODERONALD == false) {
					Game.PhellipeP1.RONALDBAR += 5;

				}

				if (Game.PhellipeP2.MODERONALD == false) {
					Game.PhellipeP2.RONALDBAR += 5;

				}
				if (playersbrabo.block == true) {

					playersbrabo.life -= 5 / playersbrabo.defesa;
				} else if (playersbrabo.block == false) {
					playersbrabo.life -= 5;
					playersbrabo.stunnedbaixo = true;
				}

			}

		}

		if (player == "Player2" && hitboxMouse.intersects(Game.MoisesP1.hitboxMOI)
				|| hitboxMouse.intersects(Game.PhellipeP1.hitboxPH) || hitboxMouse.intersects(Game.MaxuelP1.hitboxMX)
				|| hitboxMouse.intersects(Game.IvanildoP1.hitboxIV)
				|| hitboxMouse.intersects(Game.ThaianyP1.hitboxTH)) {
			Game.mouses2.remove(this);

			for (Players playersbrabo : Game.players) {
				Game.MoisesP2.energy += 2;
				Game.MoisesP2.ult += 2;
				if (Game.PhellipeP1.MODERONALD == false) {
					Game.PhellipeP1.RONALDBAR += 5;

				}

				if (Game.PhellipeP2.MODERONALD == false) {
					Game.PhellipeP2.RONALDBAR += 5;

				}
				if (playersbrabo.block == true) {

					playersbrabo.life -= 5 / playersbrabo.defesa;
				} else if (playersbrabo.block == false) {
					playersbrabo.life -= 5;
					playersbrabo.stunnedbaixo = true;
				}
			}
		}
	}

	public void render(Graphics g) {
		hitboxMouse = new Box(getX() - Camera.x, getY() - Camera.y, getWidth() + 10, getHeight() - 20, Color.cyan);
		hitboxMouse.DrawRect(g);

		if (player == "Player1") {

			if (Game.MoisesP1.LEFT == true) {

				g.drawImage(mouseleft[indexmousemov], getX() - Camera.x, getY() - 20 - Camera.y, 20, 20, null);

			}

			if (Game.MoisesP1.RIGHT == true) {

				g.drawImage(mouseright[indexmousemov], getX() - Camera.x, getY() - 20 - Camera.y, 20, 20, null);

			}
		}

		if (player == "Player2") {

			if (Game.MoisesP2.LEFT == true) {

				g.drawImage(mouseleft[indexmousemov], getX() - Camera.x, getY() - 20 - Camera.y, 20, 20, null);

			}

			if (Game.MoisesP2.RIGHT == true) {

				g.drawImage(mouseright[indexmousemov], getX() - Camera.x, getY() - 20 - Camera.y, 20, 20, null);

			}

		}

		/*
		 * g.setColor(Color.YELLOW); g.fillOval(this.getX() - Camera.x, this.getY() -
		 * Camera.y, width, height);
		 */
	}

}
