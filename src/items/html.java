package items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import collisions.Box;
import entities.Entity;
import entities.Players;
import main.Game;
import world.Camera;

public class html extends Entity {

	public static Box hitboxbloco = new Box(0, 0, 0, 0, Color.cyan);;

	private Box hitboxblocoright;

	private Box hitboxblocoleft;

	private double dx;
	private double dy;
	private double spd = 4;

	private int life = 140, curLife = 0;
	private BufferedImage bloco;

	public html(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy) {
		super(x, y, width, height, sprite);

		hitboxbloco = new Box(0, 0, 0, 0, Color.cyan);

		hitboxblocoleft = new Box(0, 0, 0, 0, Color.cyan);

		hitboxblocoright = new Box(0, 0, 0, 0, Color.cyan);
		;

		this.dx = dx;
		this.dy = dy;

		bloco = Game.ivanildoskill1.getSprite(0, 0, 130, 106);

	}

	public void tick() {

		hitboxbloco = new Box(getX() - Camera.x, getY() - 20 - Camera.y, 130, 106, Color.cyan);

		hitboxblocoleft = new Box(getX() - Camera.x, getY() - 20 - Camera.y, 65, 106, Color.cyan);

		hitboxblocoright = new Box(getX() + 65 - Camera.x, getY() - 20 - Camera.y, 65, 106, Color.cyan);
		;

		if (isGround() == true) {
			hitboxblocoleft = new Box(0, 0, 0, 0, Color.cyan);

			hitboxblocoright = new Box(0, 0, 0, 0, Color.cyan);
			dy = 0;
		}

		if (Game.char1 == "IvanildoP1") {

			if (hitboxblocoright.intersects(Game.trainer.hitboxTR) || hitboxblocoleft.intersects(Game.trainer.hitboxTR)
					|| hitboxblocoright.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxblocoleft.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxblocoright.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxblocoleft.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxblocoright.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxblocoleft.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxblocoright.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxblocoleft.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxblocoright.intersects(Game.ThaianyP2.hitboxTH)
					|| hitboxblocoleft.intersects(Game.ThaianyP2.hitboxTH)) {
				
				Game.IvanildoP1.energy += 0.5;
				Game.IvanildoP1.ult += 0.5;

				for (Players playersbrabo : Game.players2) {

					playersbrabo.life -= 0.5;

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

			if (hitboxblocoright.intersects(Game.trainer.hitboxTR) || hitboxblocoleft.intersects(Game.trainer.hitboxTR)
					|| hitboxblocoright.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxblocoleft.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxblocoright.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxblocoleft.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxblocoright.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxblocoleft.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxblocoright.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxblocoleft.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxblocoright.intersects(Game.ThaianyP1.hitboxTH)
					|| hitboxblocoleft.intersects(Game.ThaianyP1.hitboxTH)) {

				Game.IvanildoP2.energy += 0.5;
				Game.IvanildoP2.ult += 0.5;
				
				for (Players playersbrabo : Game.players) {

					playersbrabo.life -= 0.5;

					if (Game.IvanildoP2.LEFTPUSH == true) {

						playersbrabo.stunnedmedio = true;
						playersbrabo.LEFTPUSHMEDIO = true;

					}
					playersbrabo.stunnedmedio = true;

					if (Game.IvanildoP2.RIGHTPUSH == true) {

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

			Game.blocohtml.remove(this);

		}

	}

	public boolean isGround() {

		if (hitboxbloco.intersects(Game.chao01)) {

			return true;
		} else

			return false;

	}

	public void render(Graphics g) {

		hitboxblocoright.DrawRect(g);
		hitboxblocoleft.DrawRect(g);

		g.drawImage(bloco, getX() - Camera.x, getY() - 20 - Camera.y, 130, 106, null);

	}
}
