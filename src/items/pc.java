package items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import collisions.Box;
import entities.Entity;
import entities.Players;
import main.Game;
import world.Camera;

public class pc extends Entity {

	private BufferedImage[] pcright;
	private BufferedImage[] pcleft;

	private int life = 1000, curLife = 0;
	public static boolean pcmov = false;
	public static boolean pcmov2 = false;
	private int framespcmov = 0;
	private int maxFramespcmov = 10;
	private int indexpcmov = 0;
	private int maxIndexpcmov = 2;
	private boolean explodir;
	private String Player;
	private boolean explodir2;

	private int indexpcmov2 = 0;
	private int framespcmov2 = 0;
	private int maxFramespcmov2 = 10;
	private int maxIndexpcmov2 = 2;

	public static Box hitboxpcleft;
	public static Box hitboxpcright;

	public pc(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy, String Player) {
		super(x, y, width, height, sprite);

		pcright = new BufferedImage[3];
		pcleft = new BufferedImage[3];

		this.Player = Player;

		for (int i = 0; i < 3; i++) {
			pcright[i] = Game.pcright.getSprite(10 + (i * 60), 0, 60, 47);

		}

	}

	public void tick() {

		if (!explodir) {

			hitboxpcright = new Box(0, 0, 0, 0, null);
			hitboxpcleft = new Box(0, 0, 0, 0, null);

		}

		curLife++;

		if (pcmov == true && Player == "Player1") {

			framespcmov++;
			if (framespcmov == maxFramespcmov) {

				framespcmov = 0;
				indexpcmov++;
				if (indexpcmov > maxIndexpcmov) {
					indexpcmov = 0;
					hitboxpcright = new Box(getX() + 13 - Camera.x, getY() - 50 - Camera.y, 70 / 2, 60, Color.cyan);
					hitboxpcleft = new Box(getX() - 23 - Camera.x, getY() - 50 - Camera.y, 60 / 2, 60 / 2, Color.cyan);
					pcmov = false;
					explodir = true;
					Game.pcs.remove(this);
				}
			}

		}

		if (pcmov2 == true && Player == "Player2") {

			framespcmov++;
			if (framespcmov == maxFramespcmov) {

				framespcmov = 0;
				indexpcmov++;
				if (indexpcmov > maxIndexpcmov) {
					indexpcmov = 0;
					hitboxpcright = new Box(getX() + 13 - Camera.x, getY() - 50 - Camera.y, 70 / 2, 60, Color.cyan);
					hitboxpcleft = new Box(getX() - 23 - Camera.x, getY() - 50 - Camera.y, 60 / 2, 60 / 2, Color.cyan);
					pcmov2 = false;
					explodir2 = true;
					Game.pcs2.remove(this);

				}
			}

		}

		/*
		 * if (curLife == life) { Game.pcs.remove(this); return; }
		 */

		// || hitboxpcleft.intersects(Game.PhellipeP2.hitboxPH) ||
		// || hitboxpcleft.intersects(Game.trainer.hitboxTR)

		if (Player == "Player1" && hitboxpcright.intersects(Game.MoisesP2.hitboxMOI)
				|| hitboxpcright.intersects(Game.PhellipeP2.hitboxPH) || hitboxpcright.intersects(Game.trainer.hitboxTR)
				|| hitboxpcright.intersects(Game.MaxuelP2.hitboxMX) || hitboxpcright.intersects(Game.IvanildoP2.hitboxIV)
				|| hitboxpcright.intersects(Game.ThaianyP2.hitboxTH)

		) {

			if (Game.PhellipeP1.MODERONALD == false) {
				Game.PhellipeP1.RONALDBAR += 5;

			}

			if (Game.PhellipeP2.MODERONALD == false) {
				Game.PhellipeP2.RONALDBAR += 5;

			}
			if (indexpcmov > maxIndexpcmov) {
				Game.pcs.remove(this);

			}

			if (Game.MoisesP1.maxSkill3 >= 1) {
				Game.MoisesP1.maxSkill3 -= 1;
			}

			for (Players playersbrabo : Game.players2) {

				playersbrabo.life -= 10;
				Game.MoisesP1.ult += 5;
				playersbrabo.stunnedexplosion = true;
				playersbrabo.RIGHTPUSHEXPLOSION = true;

			}
		}

		if (Player == "Player1" && hitboxpcleft.intersects(Game.MoisesP2.hitboxMOI)
				|| hitboxpcleft.intersects(Game.PhellipeP2.hitboxPH)
				|| hitboxpcleft.intersects(Game.trainer.hitboxTR)|| hitboxpcleft.intersects(Game.MaxuelP2.hitboxMX) || hitboxpcleft.intersects(Game.IvanildoP2.hitboxIV)
				|| hitboxpcleft.intersects(Game.ThaianyP2.hitboxTH)) {

			if (Game.PhellipeP1.MODERONALD == false) {
				Game.PhellipeP1.RONALDBAR += 5;

			}

			if (Game.PhellipeP2.MODERONALD == false) {
				Game.PhellipeP2.RONALDBAR += 5;

			}
			if (indexpcmov > maxIndexpcmov) {
				Game.pcs.remove(this);

			}

			if (Game.MoisesP1.maxSkill3 >= 1) {
				Game.MoisesP1.maxSkill3 -= 1;
			}

			for (Players playersbrabo : Game.players2) {

				playersbrabo.life -= 10;
				Game.MoisesP1.ult += 5;
				playersbrabo.stunnedexplosion = true;
				playersbrabo.LEFTPUSHEXPLOSION = true;

			}
		}

		if (Player == "Player2" && hitboxpcright.intersects(Game.MoisesP1.hitboxMOI)
				|| hitboxpcright.intersects(Game.PhellipeP1.hitboxPH)|| hitboxpcright.intersects(Game.MaxuelP1.hitboxMX) || hitboxpcright.intersects(Game.IvanildoP1.hitboxIV)
				|| hitboxpcright.intersects(Game.ThaianyP1.hitboxTH)) {

			if (Game.PhellipeP1.MODERONALD == false) {
				Game.PhellipeP1.RONALDBAR += 5;

			}

			if (Game.PhellipeP2.MODERONALD == false) {
				Game.PhellipeP2.RONALDBAR += 5;

			}

			if (indexpcmov > maxIndexpcmov) {
				Game.pcs2.remove(this);

			}

			if (Game.MoisesP2.maxSkill3 >= 1) {
				Game.MoisesP2.maxSkill3 -= 1;
			}

			for (Players playersbrabo : Game.players) {

				playersbrabo.life -= 10;

				playersbrabo.stunnedexplosion = true;
				Game.MoisesP2.ult += 5;
				playersbrabo.RIGHTPUSHEXPLOSION = true;

			}

			Game.MoisesP2.ult += 10;

		}

		if (Player == "Player2" && hitboxpcleft.intersects(Game.MoisesP1.hitboxMOI)
				|| hitboxpcleft.intersects(Game.PhellipeP1.hitboxPH)|| hitboxpcleft.intersects(Game.MaxuelP1.hitboxMX) || hitboxpcleft.intersects(Game.IvanildoP1.hitboxIV)
				|| hitboxpcleft.intersects(Game.ThaianyP1.hitboxTH)) {

			if (Game.PhellipeP1.MODERONALD == false) {
				Game.PhellipeP1.RONALDBAR += 5;

			}

			if (Game.PhellipeP2.MODERONALD == false) {
				Game.PhellipeP2.RONALDBAR += 5;

			}

			if (indexpcmov > maxIndexpcmov) {
				Game.pcs2.remove(this);

			}

			if (Game.MoisesP2.maxSkill3 >= 1) {
				Game.MoisesP2.maxSkill3 -= 1;
			}

			for (Players playersbrabo : Game.players) {

				playersbrabo.life -= 10;

				playersbrabo.stunnedexplosion = true;
				Game.MoisesP2.ult += 5;
				playersbrabo.LEFTPUSHEXPLOSION = true;

			}

			Game.MoisesP2.ult += 10;

		}

		if (explodir && Player == "Player1") {

			if (Game.MoisesP1.maxSkill3 == 3) {

				Game.MoisesP1.maxSkill3 -= 3;
			}

			if (Game.MoisesP1.maxSkill3 == 2) {

				Game.MoisesP1.maxSkill3 -= 2;
			}

			if (Game.MoisesP1.maxSkill3 == 1) {

				Game.MoisesP1.maxSkill3 -= 1;
			}

		}

		if (explodir2 && Player == "Player2") {

			if (Game.MoisesP2.maxSkill3 == 3) {

				Game.MoisesP2.maxSkill3 -= 3;
			}

			if (Game.MoisesP2.maxSkill3 == 2) {

				Game.MoisesP2.maxSkill3 -= 2;
			}

			if (Game.MoisesP2.maxSkill3 == 1) {

				Game.MoisesP2.maxSkill3 -= 1;
			}
			Game.pcs2.remove(this);

		}
	}

	public void render(Graphics g) {

		if (Game.MoisesP2.attack2HAP == true || Game.MoisesP1.attack2HAP == true) {

			hitboxpcright = new Box(getX() + 13 - Camera.x, getY() - 50 - Camera.y, 70 / 2, 60, Color.cyan);
			hitboxpcright.DrawRect(g);
			hitboxpcleft = new Box(getX() - 23 - Camera.x, getY() - 50 - Camera.y, 70 / 2, 60, Color.cyan);
			hitboxpcleft.DrawRect(g);

		}

		if (Game.MoisesP2.attack2 == true || Game.MoisesP1.attack2 == true) {

			hitboxpcright = new Box(getX() + 13 - Camera.x, getY() - 50 - Camera.y, 70 / 2, 60, Color.cyan);
			hitboxpcright.DrawRect(g);
			hitboxpcleft = new Box(getX() - 23 - Camera.x, getY() - 50 - Camera.y, 70 / 2, 60, Color.cyan);
			hitboxpcleft.DrawRect(g);

		}

		if (Game.MoisesP1.dirM == Game.MoisesP1.right_dirM || Game.MoisesP1.dirM == Game.MoisesP1.left_dirM) {

			g.drawImage(pcright[indexpcmov], getX() - 10 - Camera.x, getY() - 40 - Camera.y, 50, 40, null);

		}

		/*
		 * g.setColor(Color.YELLOW); g.fillOval(this.getX() - Camera.x, this.getY() -
		 * Camera.y, width, height);
		 */
	}

}
