package items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import collisions.Box;
import entities.Entity;
import entities.Players;
import main.Game;
import world.Camera;

public class dados extends Entity {

	public static Box hitboxdado = new Box(0, 0, 0, 0, Color.cyan);;

	public BufferedImage[] dado;

	private int life = 300, curLife = 0;

	public static boolean dadomov = false;
	public int framesdadomov = 0;
	public int maxFramesdadomov = 15;
	public int indexdadomov = 0;
	public int maxIndexdadomov = 6;

	public dados(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);

		hitboxdado = new Box(0, 0, 0, 0, Color.green);

		dado = new BufferedImage[7];

		for (int i = 0; i < 7; i++) {
			dado[i] = Game.dadosprite.getSprite(0 + (i * 36), 0, 36, 29);

		}
	}

	public void tick() {
		hitboxdado = new Box(0, 0, 0, 0, Color.green);

		curLife++;
		framesdadomov++;
		if (indexdadomov >= 3) {

			hitboxdado = new Box(getX() - 10 - Camera.x, getY() - 25 - Camera.y, 36, 29, Color.green);
		}
		if (framesdadomov == maxFramesdadomov) {

			framesdadomov = 0;
			indexdadomov++;

			if (indexdadomov > maxIndexdadomov) {

				indexdadomov = 0;

			}
		}

		if (Game.char1 == "ThaianyP1") {

			if (hitboxdado.intersects(Game.trainer.hitboxTR) || hitboxdado.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxdado.intersects(Game.MaxuelP2.hitboxMX) || hitboxdado.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxdado.intersects(Game.PhellipeP2.hitboxPH)) {


				Game.ThaianyP1.energy += 5;
				Game.ThaianyP1.ult += 5;
				
				for (Players playersbrabo : Game.players2) {

					playersbrabo.life -= 0.5;

					playersbrabo.stunnedmedio = true;

				}

			}

		}

		if (Game.char2 == "ThaianyP2") {

			if (hitboxdado.intersects(Game.trainer.hitboxTR)
					|| hitboxdado.intersects(Game.MoisesP1.hitboxMOI) || hitboxdado.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxdado.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxdado.intersects(Game.PhellipeP1.hitboxPH)) {
				

				Game.ThaianyP2.energy += 5;
				Game.ThaianyP2.ult += 5;

				for (Players playersbrabo : Game.players) {

					playersbrabo.life -= 0.5;

					playersbrabo.stunnedmedio = true;

				}

			}

		}

		if (curLife == life) {

			Game.dadosvarios.remove(this);

		}
	}

	public void render(Graphics g) {

		hitboxdado.DrawRect(g);
		g.drawImage(dado[indexdadomov], getX() - 10 - Camera.x, getY() - 25 - Camera.y, 35, 25, null);

	}

}
