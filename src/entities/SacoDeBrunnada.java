package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import collisions.Box;
import items.html;
import main.Game;
import world.Camera;

public class SacoDeBrunnada extends Players {

	public Box hitboxTR;

	public BufferedImage playerParadoRight;
	public BufferedImage playerParadoLeft;

	public String dir = "left_dir";

	public SacoDeBrunnada(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		hitboxTR = new Box(0, 0, 0, 0, Color.ORANGE);
		playerDamageRight = Game.spritesheetboneco.getSprite(0, 0, 39, 90);
		playerDamageLeft = Game.spritesheetboneco.getSprite(112, 170, 50, 90);
		playerParadoRight = Game.spritesheetboneco.getSprite(112, 170, 50, 90);
		playerParadoLeft = Game.spritesheetboneco.getSprite(25, 170, 50, 90);

		life = 200;

		// STUN BAIXO
		Stunbaixo = false;
		Stunbaixoframes = 0;
		maxFramesStunbaixo = 30;

		// STUN MEDIO
		Stunmedio = false;
		Stunmedioframes = 0;
		maxFramesStunmedio = 60;

		// STUN ALTO
		Stunalto = false;
		Stunaltoframes = 0;
		maxFramesStunalto = 100;

		// STUN EXPLOSION

		StunExplosion = false;
		StunExplosionframes = 0;
		maxFramesStunExplosion = 120;

		// STUN 0GRAVITY

		Stun0gravity = false;
		Stun0gravityframes = 0;
		maxFramesStun0gravity = 60;

		// STUN BAIXO REVERSO

		Stunbaixorever = false;
		Stunbaixoreverframes = 0;
		maxFramesStunbaixorever = 40;

		// STUN HAKAI

		StunHAKAI = false;
		StunHAKAIframes = 0;
		maxFramesStunHAKAI = 200;

		
		lastSeta = 0;
		setaoffcooldown = false;
		cooldownTime6 = 5000;
		
	}

	public void tick() {

		hitboxTR = new Box(getX() - Camera.x, getY() - Camera.y, getWidth(), getHeight() + 10, Color.ORANGE);

		isStunnedAlto();
		isStunnedMedio();
		isStunnedBaixo();
		isStunnedBaixoReverso();
		isStunnedZEROGRAVITY();
		isStunnedExplosion();
		isStunnedHAKAI();

		cooldownSeta();
		
		if(SETA && !setaoffcooldown) {
			
			
			SETA = false;
			setaoffcooldown = true;
			
			
			
			
			
		}
		
		if(!STUNNED) {
			
			isDamaged = false;
		}
		
		if (life <= 0) {

			life = 200;
		}

		if (isWallLeft()) {

			leftspeed = 0;
		}

		if (isWallRight()) {

			rightspeed = 0;
		}

		if (!isGround() && Stun0gravity == false) {

			y += 1;
		}

	}

	public boolean isGround() {

		if (hitboxTR.intersects(Game.chao01)) {

			Tanochao = true;

			return true;
		} else

			Tanochao = false;

		return false;

	}

	public boolean isWallLeft() {

		if (hitboxTR.intersects(Game.parede01)) {

			return true;
		} else

			return false;

	}

	public boolean isWallRight() {

		if (hitboxTR.intersects(Game.parede02)) {

			return true;
		} else

			return false;

	}
	
	
	public void cooldownSeta() {
		long time2 = System.currentTimeMillis();
		if (time2 > lastSeta + cooldownTime6) {

			setaoffcooldown = false;

			// System.out.println("JONAS!");

			lastSeta= time2;
		}
	}

	public void isStunnedHAKAI() {

		if (stunnedHAKAI) {
			STUNNED = true;
			StunHAKAI = true;
			isDamaged = true;

		}

		if (StunHAKAI) {

			StunHAKAIframes++;

			while (StunHAKAIframes == maxFramesStunHAKAI) {

				StunHAKAIframes = 0;

				StunHAKAI = false;
			}
			if (!StunHAKAI) {
				stunnedHAKAI = false;
				STUNNED = false;
				isDamaged = false;
			}

		}

	}

	public void isStunnedExplosion() {

		if (stunnedexplosion) {
			STUNNED = true;
			StunExplosion = true;
			isDamaged = true;

			if (RIGHTPUSHEXPLOSION) {

				if (!isWallRight() && !isWallLeft())
					x += 2;
				RIGHTPUSHENDEXPLOSION = true;
			}

			if ((LEFTPUSHEXPLOSION)) {

				if (!isWallRight() && !isWallLeft())
					x -= 2;
				LEFTPUSHENDEXPLOSION = true;
			}

		}

		if (StunExplosion) {

			StunExplosionframes++;

			while (StunExplosionframes == maxFramesStunExplosion) {

				StunExplosionframes = 0;

				StunExplosion = false;
			}
			if (!StunExplosion) {
				if (RIGHTPUSHENDEXPLOSION) {

					RIGHTPUSHEXPLOSION = false;
				}

				if (LEFTPUSHENDEXPLOSION) {

					LEFTPUSHEXPLOSION = false;
				}
				
				stunnedexplosion = false;
				STUNNED = false;
				isDamaged = false;
			}

		}

	}

	public void isStunnedAlto() {

		if (stunnedalto) {
			STUNNED = true;
			Stunalto = true;
			isDamaged = true;

			if (LEFTPUSHALTO) {

				if (!isWallRight() && !isWallLeft())
					x -= 2;
				LEFTPUSHENDALTO = true;
			}

			if (RIGHTPUSHALTO) {

				if (!isWallRight() && !isWallLeft())
					x += 2;
				RIGHTPUSHENDALTO = true;
			}

		}

		if (Stunalto) {

			Stunaltoframes++;

			while (Stunaltoframes == maxFramesStunalto) {

				Stunaltoframes = 0;

				Stunalto = false;
			}
			if (!Stunalto) {

				if (RIGHTPUSHENDALTO) {

					RIGHTPUSHALTO = false;
				}

				if (LEFTPUSHENDALTO) {

					LEFTPUSHALTO = false;
				}
				stunnedalto = false;
				STUNNED = false;
				isDamaged = false;

			}

		}
	}

	public void isStunnedMedio() {

		if (stunnedmedio) {
			STUNNED = true;
			Stunmedio = true;
			isDamaged = true;

			if (LEFTPUSHMEDIO) {
				if (!isWallRight() && !isWallLeft())
					x -= 0.5;
				LEFTPUSHENDMEDIO = true;
			}

			if (RIGHTPUSHMEDIO) {
				if (!isWallRight() && !isWallLeft())
					x += 0.5;
				RIGHTPUSHENDMEDIO = true;
			}

		}

		if (Stunmedio) {

			Stunmedioframes++;

			while (Stunmedioframes == maxFramesStunmedio) {

				Stunmedioframes = 0;

				Stunmedio = false;
				;
			}
			if (!Stunmedio) {
				if (RIGHTPUSHENDMEDIO) {

					RIGHTPUSHMEDIO = false;
				}

				if (LEFTPUSHENDMEDIO) {

					LEFTPUSHMEDIO = false;
				}
				stunnedmedio = false;

				if (RIGHTPUSHALTO || LEFTPUSHALTO) {

					STUNNED = true;
				} else
					STUNNED = false;

			}

		}
	}

	public void isStunnedZEROGRAVITY() {

		if (stunned0gravity) {
			STUNNED = true;
			Stun0gravity = true;
			isDamaged = true;
			falling = false;
			gravity = 0;

			if (LEFTPUSHZEROGRAVITY) {

				if (!isWallRight() && !isWallLeft())

					x -= 0.2;
				y -= 1;
				LEFTPUSHENDZEROGRAVITY = true;
			}

			if (RIGHTPUSHZEROGRAVITY) {

				if (!isWallRight() && !isWallLeft())

					x += 0.2;
				y -= 1;
				RIGHTPUSHENDZEROGRAVITY = true;
			}

		}

		if (Stun0gravity) {

			Stun0gravityframes++;

			while (Stun0gravityframes == maxFramesStun0gravity) {

				Stun0gravityframes = 0;

				Stun0gravity = false;
			}
			if (!Stun0gravity) {
				if (RIGHTPUSHENDZEROGRAVITY) {

					RIGHTPUSHZEROGRAVITY = false;
				}

				if (LEFTPUSHENDZEROGRAVITY) {

					LEFTPUSHZEROGRAVITY = false;
				}
				stunned0gravity = false;
				STUNNED = false;
				isDamaged = false;
				falling = true;
				gravity = 1.5;

			}

		}
	}

	public void isStunnedBaixoReverso() {

		if (stunnedbaixoreverso) {
			STUNNED = true;
			Stunbaixorever = true;
			isDamaged = true;

			if (LEFTPUSHBAIXOREVERSO) {

				if (!isWallRight() && !isWallLeft())
					x += 0.5;
				LEFTPUSHBAIXOREVERSO = true;
			}

			if (RIGHTPUSHBAIXOREVERSO) {

				if (!isWallRight() && !isWallLeft())
					x -= 0.5;
				RIGHTPUSHENDBAIXOREVERSO = true;
			}
		}

		if (Stunbaixorever) {

			Stunbaixoreverframes++;

			while (Stunbaixoreverframes == maxFramesStunbaixorever) {

				Stunbaixoreverframes = 0;

				Stunbaixorever = false;
			}
			if (!Stunbaixorever) {
				if (RIGHTPUSHENDBAIXOREVERSO) {

					RIGHTPUSHBAIXOREVERSO = false;
				}

				if (LEFTPUSHENDBAIXOREVERSO) {

					LEFTPUSHBAIXOREVERSO = false;
				}

				stunnedbaixoreverso = false;
				STUNNED = false;
				isDamaged = false;

			}

		}
	}

	public void isStunnedBaixo() {

		if (stunnedbaixo) {
			STUNNED = true;
			Stunbaixo = true;
			isDamaged = true;

			if (LEFTPUSHBAIXO) {

				if (!isWallRight() && !isWallLeft()) {

					x -= 1;
				}
				LEFTPUSHENDBAIXO = true;
			}

			if (RIGHTPUSHBAIXO) {

				if (!isWallRight() && !isWallLeft()) {
					x += 1;
				}

				RIGHTPUSHENDBAIXO = true;
			}

		}

		if (Stunbaixo) {

			Stunbaixoframes++;

			while (Stunbaixoframes == maxFramesStunbaixo) {

				Stunbaixoframes = 0;

				Stunbaixo = false;
			}
			if (!Stunbaixo) {

				if (RIGHTPUSHENDBAIXO) {

					RIGHTPUSHBAIXO = false;
				}

				if (LEFTPUSHENDBAIXO) {

					LEFTPUSHBAIXO = false;
				}
				stunnedbaixo = false;
				STUNNED = false;
				isDamaged = false;

			}

		}
	}

	public void render(Graphics g) {

		if (dir == "left_dir" && !isDamaged) {

			g.drawImage(playerParadoLeft, this.getX() - Camera.x, this.getY() - Camera.y, null);

		}

		if (isDamaged == true) {

			g.drawImage(playerDamageLeft, this.getX() - Camera.x, this.getY() - Camera.y, null);
			
		}

		hitboxTR.DrawRect(g);
	}

}
