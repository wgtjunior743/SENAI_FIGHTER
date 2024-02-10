package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import collisions.Box;
import items.Bullets;
import items.mirault;
import main.Game;
import world.Camera;

public class Maxuel extends Players {

	public int right_dirM;
	public int left_dirM;
	public int dirM;

	public Box hitboxMX;
	private double SPEED = 1.4;
	private int weight;
	private int jumpStrength;

	public Box hitboxAttack1Right;
	public Box hitboxAttack1Left;
	public Box hitboxAttack2;
	public Box hitboxAttack2Left;
	public Box hitboxAttack2Right;
	public Box hitboxAttack3Left;
	public Box hitboxAttack3Right;

	private Box hitboxSkill2Left;
	private Box hitboxSkill2Right;
	private Box hitboxSkill1Right;
	private Box hitboxSkill1Left;

	protected BufferedImage rightPlayerJump;
	protected BufferedImage leftPlayerJump;
	private boolean attack1LEFT;
	private boolean attack1RIGHT;
	private boolean skill1HAP;

	private boolean skill2HAP;
	private boolean Skill2LEFT;

	private boolean Skill2RIGHT;

	private boolean skill1lefthappening;
	private boolean Skill1LEFT;

	private boolean skill1righthappening;
	private boolean Skill1RIGHT;
	public boolean MAXULT = false;
	private boolean oncetest = false;

	private boolean skillultcooldown = false;
	private int cooldownTime6 = 100;
	private long lastULT = 0;
	private Box hitboxULT;

	public Maxuel(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);

		hitboxMX = new Box(0, 0, 0, 0, Color.ORANGE);
		hitboxULT = new Box(0, 0, 0, 0, Color.orange);
		hitboxAttack1Right = new Box(0, 0, 0, 0, Color.cyan);
		hitboxAttack1Left = new Box(0, 0, 0, 0, Color.cyan);
		hitboxAttack2Right = new Box(0, 0, 0, 0, Color.cyan);
		hitboxAttack2Left = new Box(0, 0, 0, 0, Color.cyan);
		hitboxAttack3Right = new Box(0, 0, 0, 0, Color.cyan);
		hitboxAttack3Left = new Box(0, 0, 0, 0, Color.cyan);
		hitboxSkill1Left = new Box(0, 0, 0, 0, Color.cyan);
		hitboxSkill1Right = new Box(0, 0, 0, 0, Color.cyan);
		hitboxSkill2Left = new Box(0, 0, 0, 0, Color.cyan);
		hitboxSkill2Right = new Box(0, 0, 0, 0, Color.cyan);

		ult = 0;
		energy = 0;

		right_dirM = 0;
		left_dirM = 1;

		dirM = left_dirM;

		rightspeed = 5;
		leftspeed = 1;

		jumping = true;
		gravity = 2;

		// PUSH

		LEFTPUSHBAIXO = false;
		LEFTPUSHENDBAIXO = false;

		RIGHTPUSHBAIXO = false;
		RIGHTPUSHENDBAIXO = false;

		LEFTPUSHBAIXOREVERSO = false;
		LEFTPUSHENDBAIXOREVERSO = false;

		RIGHTPUSHBAIXOREVERSO = false;
		RIGHTPUSHENDBAIXOREVERSO = false;

		LEFTPUSHZEROGRAVITY = false;
		LEFTPUSHENDZEROGRAVITY = false;

		RIGHTPUSHZEROGRAVITY = false;
		RIGHTPUSHENDZEROGRAVITY = false;

		LEFTPUSHMEDIO = false;
		LEFTPUSHENDMEDIO = false;

		RIGHTPUSHMEDIO = false;
		RIGHTPUSHENDMEDIO = false;

		LEFTPUSHENDALTO = false;
		LEFTPUSHALTO = false;

		RIGHTPUSHENDALTO = false;
		RIGHTPUSHALTO = false;

		RIGHTPUSHENDEXPLOSION = false;
		RIGHTPUSHEXPLOSION = false;

		LEFTPUSHENDEXPLOSION = false;
		LEFTPUSHEXPLOSION = false;

		// ANDAR
		framesAndar = 0;
		maxFramesAndar = 10;
		indexAndar = 0;
		maxIndexAndar = 4;
		// PULO
		maxFramesJump = 60;
		framesJump = 0;
		indexJump = 0;
		maxIndexJump = 1;

		jumping = false;
		falling = true;
		// PARADO
		framesParado = 0;
		maxFramesParado = 20;
		indexParado = 0;
		maxIndexParado = 1;
		// ATTACk1
		framesAttack1 = 0;
		maxFramesAttack1 = 12;
		indexAttack1Right = 0;
		indexAttack1Left = 0;
		maxIndexAttack1 = 5;

		// ATTACK2

		framesAttack2 = 0;
		maxFramesAttack2 = 15;
		indexAttack2Right = 0;
		indexAttack2Left = 0;
		maxIndexAttack2 = 3;

		// ATTACK3

		framesAttack3 = 0;
		maxFramesAttack3 = 10;
		indexAttack3Right = 0;
		indexAttack3Left = 0;
		maxIndexAttack3 = 7;

		// SKILL 1
		framesSkill1 = 0;
		maxFramesSkill1 = 15;
		maxIndexSkill1 = 3;
		indexSkill1Right = 0;
		indexSkill1Left = 0;

		// SKILL 2
		indexSkill2Right = 0;
		indexSkill2Left = 0;
		maxIndexSkill2 = 7;
		framesSkill2 = 0;
		maxFramesSkill2 = 10;

		// BLOCK

		block = false;
		defesa = 2;

		// ATTACK1 COOLDOWN
		attack1cdframes = 0;
		attack1cdmaxframes = 50;

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

		// STUNS

		Attack2frames = 0;

		// PUSH

		LEFTPUSH = false;
		RIGHTPUSH = false;

		// COOLDOWNS

		// COOLDOWNS

		lastAttack = 0;
		cooldownTime = 5000;
		attack1offcooldown = false;

		lastJump = 0;
		cooldownTimeJump = 2000;
		jumpoffcooldown = false;

		lastAttack2 = 0;
		cooldownTime2 = 3000;
		attack2offcooldown = false;

		lastAttack3 = 0;
		cooldownTime3 = 3000;
		attack3offcooldown = false;

		lastSkill1 = 0;
		skill1offcooldown = false;
		cooldownTime4 = 1500;

		lastSkill2 = 0;
		skill2offcooldown = false;
		cooldownTime5 = 1500;

		rightPlayerParado = new BufferedImage[2];
		leftPlayerParado = new BufferedImage[2];
		rightPlayer = new BufferedImage[5];
		leftPlayer = new BufferedImage[5];
		rightPlayerAttack1 = new BufferedImage[6];
		leftPlayerAttack1 = new BufferedImage[6];
		rightPlayerAttack2 = new BufferedImage[4];
		leftPlayerAttack2 = new BufferedImage[4];
		rightPlayerAttack3 = new BufferedImage[8];
		leftPlayerAttack3 = new BufferedImage[8];
		rightPlayerSkill1 = new BufferedImage[4];
		leftPlayerSkill1 = new BufferedImage[4];
		rightPlayerSkill2 = new BufferedImage[8];
		leftPlayerSkill2 = new BufferedImage[8];

		playerDamageRight = Game.maxuelresto.getSprite(30, 347, 80, 100);
		playerDamageLeft = Game.maxuelresto.getSprite(30, 212, 80, 90);

		playerAgachadoRight = Game.spritesheet3.getSprite(23, 250, 52, 74);
		playerAgachadoLeft = Game.spritesheet3.getSprite(22, 364, 53, 80);

		rightPlayerJump = Game.maxuelpulando.getSprite(80, 5, 70, 90);
		leftPlayerJump = Game.maxuelpulando.getSprite(82, 115, 70, 90);

		rightPlayerULT = Game.maxuelresto.getSprite(29, 112, 140, 40);
		leftPlayerULT = Game.maxuelresto.getSprite(29, 20, 140, 40);

		for (int i = 0; i < 2; i++) {
			rightPlayerParado[i] = Game.spritesheet3.getSprite(29 + (i * 81), 1165, 75, 110);

		}
		for (int i = 0; i < 2; i++) {
			leftPlayerParado[i] = Game.spritesheet3.getSprite(108 - (i * 81), 1424, 75, 110);

		}

		for (int i = 0; i < 5; i++) {
			rightPlayer[i] = Game.maxuelandando.getSprite(15 + (i * 74), 146, 75, 100);

		}
		for (int i = 0; i < 5; i++) {
			leftPlayer[i] = Game.maxuelandando.getSprite(314 - (i * 74), 21, 75, 100);

		}

		for (int i = 0; i < 6; i++) {
			leftPlayerAttack1[i] = Game.spritesheet3.getSprite(562 - (i * 107), 1710, 100, 100);

		}
		for (int i = 0; i < 6; i++) {
			rightPlayerAttack1[i] = Game.spritesheet3.getSprite(30 + (i * 107), 1565, 100, 100);

		}

		for (int i = 0; i < 4; i++) {
			rightPlayerAttack2[i] = Game.maxuelsetas.getSprite(38 + (i * 100), 34, 100, 100);

		}
		for (int i = 0; i < 4; i++) {
			leftPlayerAttack2[i] = Game.maxuelsetas.getSprite(339 - (i * 100), 194, 100, 100);

		}

		for (int i = 0; i < 8; i++) {
			leftPlayerAttack3[i] = Game.spritesheet3.getSprite(554 - (i * 76), 123, 80, 100);

		}
		for (int i = 0; i < 8; i++) {
			rightPlayerAttack3[i] = Game.spritesheet3.getSprite(25 + (i * 76), 0, 80, 100);

		}

		for (int i = 0; i < 4; i++) {
			leftPlayerSkill1[i] = Game.spritesheet3.getSprite(410 - (i * 128), 484, 130, 100);

		}
		for (int i = 0; i < 4; i++) {
			rightPlayerSkill1[i] = Game.spritesheet3.getSprite(25 + (i * 128), 754, 129, 100);

		}

		for (int i = 0; i < 8; i++) {
			leftPlayerSkill2[i] = Game.spritesheet3.getSprite(830 - (i * 115), 2030, 108, 110);

		}
		for (int i = 0; i < 8; i++) {
			rightPlayerSkill2[i] = Game.spritesheet3.getSprite(30 + (i * 115), 1866, 108, 110);

		}

	}

	public void tick() {

		rightspeed = SPEED;
		leftspeed = SPEED;

		
		if (!STUNNED) {

			isDamaged = false;
		}

		start();

		if (ult >= 100) {

			ult = 100;

		}
		
		if (energy > 100) {

			energy = 100;

		}

		cooldownAttack1();

		cooldownAttack2();

		cooldownAttack3();

		cooldownSkill1();

		cooldownSkill2();

		cooldownULT();

		cooldownJump();

		// STUNS TICKS
		isStunnedAlto();
		isStunnedMedio();
		isStunnedBaixo();
		isStunnedBaixoReverso();
		isStunnedZEROGRAVITY();
		isStunnedExplosion();
		isStunnedHAKAI();

		if (Game.char1 == "MaxuelP1" || Game.char2 == "MaxuelP2") {

			hitboxMX = new Box(getX() - Camera.x, getY() - Camera.y, getWidth(), getHeight(), Color.ORANGE);

			hitboxULT = new Box(0, 0, 0, 0, Color.orange);
			hitboxAttack1Right = new Box(0, 0, 0, 0, Color.cyan);
			hitboxAttack1Left = new Box(0, 0, 0, 0, Color.cyan);
			hitboxAttack2Right = new Box(0, 0, 0, 0, Color.cyan);
			hitboxAttack2Left = new Box(0, 0, 0, 0, Color.cyan);
			hitboxAttack3Right = new Box(0, 0, 0, 0, Color.cyan);
			hitboxAttack3Left = new Box(0, 0, 0, 0, Color.cyan);
			hitboxSkill1Left = new Box(0, 0, 0, 0, Color.cyan);
			hitboxSkill1Right = new Box(0, 0, 0, 0, Color.cyan);
			hitboxSkill2Left = new Box(0, 0, 0, 0, Color.cyan);
			hitboxSkill2Right = new Box(0, 0, 0, 0, Color.cyan);
		}

		if (Game.char1 == "MaxuelP1" && !SETARPO) {

			Game.MaxuelP1.dirM = Game.MaxuelP1.right_dirM;

			SETARPO = true;

		}

		if (isWallLeft() || down) {

			leftspeed = 0;
		}

		if (isWallRight() || down) {

			rightspeed = 0;
		}

		if (right && !STUNNED && !attacking && !down && !MAXULT) {
			parado = false;
			moved = true;
			dirM = right_dirM;
			x += rightspeed;

			// CAMERA POSSIBILIDADE 1
			/*
			 * Camera.x+=speed;
			 */
		} else if (dirM == right_dirM && !right) {

			parado = true;

		}

		/*
		 * if (Game.MaxuelP1.right) {
		 * 
		 * Game.MaxuelP1.dirP = Game.MaxuelP1.right_dirP;
		 * 
		 * }
		 * 
		 * if (Game.MaxuelP1.left) {
		 * 
		 * Game.MaxuelP1.dirP = Game.MaxuelP1.left_dirP;
		 * 
		 * }
		 * 
		 * 
		 * 
		 */
		weight = 1;

		if (left && !STUNNED && !attacking && !down && !MAXULT) {
			parado = false;
			moved = true;
			dirM = left_dirM;
			x -= leftspeed;

			// CAMERA POSSIBILIDADE 1
			/*
			 * Camera.x-=speed;
			 */
		} else if (dirM == left_dirM && !left) {

			parado = true;

		}

		if (up && !down && Tanochao && !MAXULT) {

			jumping = true;
			jumpStrength = 50;

			y -= jumpStrength;
			jumpStrength -= weight;

		}

		if (down && isGround() == true && !attack1HAP && !attack2HAP && !STUNNED && !MAXULT) {

			moved = false;
			parado = false;

			if (dirM == left_dirM) {
				hitboxMX = new Box(getX() - Camera.x, getY() + 22 - Camera.y, getWidth() - 20, getHeight(),
						Color.ORANGE);

			}

			if (dirM == right_dirM) {
				hitboxMX = new Box(getX() + 10 - Camera.x, getY() + 22 - Camera.y, getWidth() - 20, getHeight(),
						Color.ORANGE);

			}

		}

		/*
		 * if (!jumpoffcooldown) {
		 * 
		 * jumpoffcooldown = true; parado = false; moved = true; for (int i = 0; i < 17;
		 * i += 1) { y -= 3; }
		 * 
		 * }
		 */

		if (moved == true) {

			framesAndar++;
			if (framesAndar == maxFramesAndar) {

				framesAndar = 0;
				indexAndar++;
				if (indexAndar > maxIndexAndar) {
					indexAndar = 0;
				}
			}

		}

		if (parado == true) {

			framesParado++;
			if (framesParado == maxFramesParado) {

				framesParado = 0;
				indexParado++;
				if (indexParado > maxIndexParado) {
					indexParado = 0;
				}
			}

		}

		if (isGround()) {

			gravity = 0;

		}

		if (isGround() == false) {

			gravity = 1.5;

		}

		if (isDamaged) {
			this.damageFrames++;
			if (this.damageFrames == 10) {

				this.damageFrames = 0;

			}

		}

		if (Game.MaxuelP1.life <= 0) {
			/*
			 * Game.gameState = "MENU";
			 */
			Game.MaxuelP1.dead = true;

		}

		if (Game.MaxuelP2.life <= 0) {
			/*
			 * Game.gameState = "MENU";
			 */
			Game.MaxuelP2.dead = true;

		}

		if (falling) {

			y += gravity;

		}

		// ATAQUES

		if (attack1 && dirM == right_dirM && !Cantattack && !STUNNED && !block) {
			attacking = true;
			attack1RIGHT = true;
			RIGHTPUSH = true;
			if (!attack1offcooldown) {

				attack1HAP = true;
				if (indexAttack1Right >= 2) {

					hitboxAttack1Right = new Box(getX() + 60 - Camera.x, getY() + 10 - Camera.y, 50, 60, Color.cyan);
				}
				framesAttack1++;
				if (framesAttack1 == maxFramesAttack1) {

					framesAttack1 = 0;
					indexAttack1Right++;
					isAttacking1Hitting();
					if (indexAttack1Right > maxIndexAttack1) {

						indexAttack1Right = 0;

						RIGHTPUSH = false;
						attack1RIGHT = false;
						attack1 = false;
						attacking = false;
						attack1HAP = false;
						attack1offcooldown = true;
						hitboxAttack1Right = new Box(0, 0, 0, 0, Color.cyan);

					}

					/*
					 * attack1 = false; attacking = false;
					 * 
					 */

				}

			}

		}

		if (attack1 && dirM == left_dirM && !attack2 && !Cantattack && !STUNNED && !block) {
			attacking = true;
			LEFTPUSH = true;
			attack1LEFT = true;
			if (!attack1offcooldown) {

				attack1HAP = true;

				if (indexAttack1Left >= 2) {

					hitboxAttack1Left = new Box(getX() - 46 - Camera.x, getY() + 10 - Camera.y, 50, 60, Color.cyan);
				}
				framesAttack1++;
				if (framesAttack1 == maxFramesAttack1) {

					framesAttack1 = 0;
					indexAttack1Left++;
					isAttacking1Hitting();
					if (indexAttack1Left > maxIndexAttack1) {

						indexAttack1Left = 0;

						LEFTPUSH = false;
						attack1LEFT = false;
						attack1 = false;
						attacking = false;
						attack1HAP = false;
						attack1offcooldown = true;
						hitboxAttack1Left = new Box(0, 0, 0, 0, Color.cyan);

					}

					/*
					 * attack1 = false; attacking = false;
					 * 
					 */

				}
			}
		}

		if (attack1 && attack1offcooldown || attack1 && attack2HAP || attack1 && block || attack1 && STUNNED) {

			attack1 = false;
			attack1HAP = false;
			attacking = false;
			attack1lefthappening = false;
			attack1righthappening = false;

		}

		if (attack2 == true && dirM == left_dirM && !attack2righthappening && !attack2offcooldown && !attack3HAP
				&& !attack1HAP && !block && !STUNNED) {
			LEFTPUSH = true;
			attacking = true;
			attack2lefthappening = true;
			attack2HAP = true;

			if (indexAttack2Left >= 3) {

				hitboxAttack2Left = new Box(getX() - 60 - Camera.x, getY() + 10 - Camera.y, 60, 30, Color.cyan);
			}
			framesAttack2++;
			if (framesAttack2 == maxFramesAttack2) {

				framesAttack2 = 0;
				indexAttack2Left++;

				//

				if (indexAttack2Left > maxIndexAttack2) {
					isAttacking2Hitting();
					LEFTPUSH = false;
					indexAttack2Left = 0;
					attack2offcooldown = true;
					attack2HAP = false;
					attack2 = false;
					attacking = false;
					attack2lefthappening = false;
					hitboxAttack2Left = new Box(0, 0, 0, 0, Color.cyan);

				}

				/*
				 * attack1 = false; attacking = false;
				 * 
				 */

			}

		}

		if (attack2 == true && dirM == right_dirM && !attack2lefthappening && !attack2offcooldown && !attack3HAP
				&& !attack1HAP && !block && !STUNNED) {
			RIGHTPUSH = true;
			attacking = true;
			attack2righthappening = true;
			attack2HAP = true;

			if (indexAttack2Right >= 3) {

				hitboxAttack2Right = new Box(getX() + 60 - Camera.x, getY() + 10 - Camera.y, 60, 30, Color.cyan);
			}
			framesAttack2++;
			if (framesAttack2 == maxFramesAttack2) {

				framesAttack2 = 0;
				indexAttack2Right++;

				// isAttacking2Hitting();

				if (indexAttack2Right > maxIndexAttack2) {

					isAttacking2Hitting();
					RIGHTPUSH = false;
					indexAttack2Right = 0;
					attack2offcooldown = true;
					attack2HAP = false;
					attack2 = false;
					attacking = false;
					attack2righthappening = false;
					hitboxAttack2Right = new Box(0, 0, 0, 0, Color.cyan);

				}

				/*
				 * attack1 = false; attacking = false;
				 * 
				 */

			}

		}

		if (attack2 && attack2offcooldown || attack2 && attack1HAP || attack2 && attack3HAP || attack2 && STUNNED) {

			attack2 = false;
			attack2HAP = false;
			attacking = false;
			attack2lefthappening = false;
			attack2righthappening = false;
			framesAttack2 = 0;

		}

		if (attack3 == true && dirM == left_dirM && !attack3righthappening && !attack3offcooldown && !attack2HAP
				&& !attack1HAP && down && !block && !STUNNED) {
			LEFTPUSH = true;
			attacking = true;
			down = true;
			attack3lefthappening = true;
			attack3HAP = true;

			if (indexAttack3Left >= 3) {

				hitboxAttack3Left = new Box(getX() - 70 - Camera.x, getY() + 36 - Camera.y, 50, 45, Color.cyan);
			}
			framesAttack3++;
			if (framesAttack3 == maxFramesAttack3) {

				framesAttack3 = 0;
				indexAttack3Left++;
				isAttacking3Hitting();

				if (indexAttack3Left > maxIndexAttack3) {

					indexAttack3Left = 0;

					LEFTPUSH = false;
					attack3 = false;
					attacking = false;
					attack3HAP = false;
					down = false;
					attack3lefthappening = false;
					hitboxAttack3Left = new Box(0, 0, 0, 0, Color.cyan);
					attack3offcooldown = true;

				}

			}

		}

		if (attack3 == true && dirM == right_dirM && !attack3lefthappening && !attack3offcooldown && !attack2HAP
				&& !attack1HAP && down && !block && !STUNNED) {
			attacking = true;
			down = true;
			RIGHTPUSH = true;
			attack3righthappening = true;
			attack3HAP = true;

			if (indexAttack3Right >= 3) {

				hitboxAttack3Right = new Box(getX() + 85 - Camera.x, getY() + 35 - Camera.y, 50, 45, Color.cyan);

			}
			framesAttack3++;
			if (framesAttack3 == maxFramesAttack3) {

				framesAttack3 = 0;
				indexAttack3Right++;
				isAttacking3Hitting();

				if (indexAttack3Right > maxIndexAttack3) {

					indexAttack3Right = 0;
					RIGHTPUSH = false;
					attack3 = false;
					attacking = false;
					attack3HAP = false;
					attack3righthappening = false;
					down = false;
					hitboxAttack3Right = new Box(0, 0, 0, 0, Color.cyan);
					attack3offcooldown = true;

				}

			}

		}

		if (attack3 && attack3offcooldown || attack3 && attack1HAP || attack3 && attack2HAP || attack3 && !down) {

			attack3 = false;
			attack3HAP = false;
			attacking = false;
			attack3lefthappening = false;
			attack3righthappening = false;
			framesAttack3 = 0;
			indexAttack3Right = 0;
			indexAttack3Left = 0;
		}

		if (skill1 == true && dirM == left_dirM && !skill1offcooldown && !skill2HAP) {
			
			energy-=10;
			attacking = true;
			LEFTPUSH = true;
			attacking = true;
			skill1HAP = true;
			skill1lefthappening = true;
			Skill1LEFT = true;
			// attack3HAP = true;

			if (indexSkill1Left >= 3) {

				hitboxSkill1Left = new Box(getX() - 65 - Camera.x, getY() + 40 - Camera.y, 30, 30, Color.cyan);
			}

			framesSkill1++;
			if (framesSkill1 == maxFramesSkill1) {

				framesSkill1 = 0;
				indexSkill1Left++;
				isAttackingSkill1Hitting();

				if (indexSkill1Left > maxIndexSkill1) {

					attacking = false;
					LEFTPUSH = false;
					Skill1LEFT = false;
					indexSkill1Left = 0;
					skill1HAP = false;
					skill1 = false;
					skill1offcooldown = true;
					// hitboxAttack3Left = new Box(0, 0, 0, 0, Color.cyan);

					// attack3offcooldown = true;

				}

			}

		}

		if (skill1 == true && dirM == right_dirM && !skill1offcooldown && !skill2HAP ) {
			RIGHTPUSH = true;
			attacking = true;
			skill1HAP = true;
			skill1righthappening = true;
			Skill1RIGHT = true;
			// attack3HAP = true;
			energy-=10;
			if (indexSkill1Right >= 3) {

				hitboxSkill1Right = new Box(getX() + 108 - Camera.x, getY() + 40 - Camera.y, 30, 30, Color.cyan);
			}

			framesSkill1++;
			if (framesSkill1 == maxFramesSkill1) {

				framesSkill1 = 0;
				indexSkill1Right++;
				isAttackingSkill1Hitting();

				if (indexSkill1Right > maxIndexSkill1) {

					RIGHTPUSH = false;
					Skill1RIGHT = false;
					indexSkill1Right = 0;
					attacking = false;
					skill1HAP = false;
					skill1 = false;
					skill1offcooldown = true;

				}

			}

		}

		if (skill1 && skill1offcooldown || skill1 && skill2HAP ) {

			skill1 = false;
			framesSkill1 = 0;

		}

		if (skill2 == true && dirM == right_dirM && !skill1HAP && !skill2offcooldown) {
			RIGHTPUSH = true;
			attacking = true;
			skill2HAP = true;
			// skill2righthappening = true;
			Skill2RIGHT = true;
			// attack3HAP = true;
			energy-=10;
			if (indexSkill2Right >= 4) {

				hitboxSkill2Right = new Box(getX() + 72 - Camera.x, getY() + 20 - Camera.y, 50, 50, Color.cyan);
			}

			framesSkill2++;
			if (framesSkill2 == maxFramesSkill2) {

				framesSkill2 = 0;
				indexSkill2Right++;
				isAttackingSkill2Hitting();

				if (indexSkill2Right > maxIndexSkill2) {
					RIGHTPUSH = false;
					indexSkill2Right = 0;
					Skill2RIGHT = false;
					skill2HAP = false;
					attacking = false;
					skill2 = false;
					skill2offcooldown = true;

				}

			}

		}

		if (skill2 == true && dirM == left_dirM && !skill1HAP && !skill2offcooldown) {
			LEFTPUSH = true;
			attacking = true;
			skill2HAP = true;
			// skill2righthappening = true;
			Skill2LEFT = true;
			// attack3HAP = true;
			energy-=10;
			if (indexSkill2Left >= 4) {

				hitboxSkill2Left = new Box(getX() - 51 - Camera.x, getY() + 20 - Camera.y, 50, 50, Color.cyan);
			}

			framesSkill2++;
			if (framesSkill2 == maxFramesSkill2) {

				framesSkill2 = 0;
				indexSkill2Left++;
				isAttackingSkill2Hitting();

				if (indexSkill2Left > maxIndexSkill2) {
					indexSkill2Left = 0;
					Skill2LEFT = false;
					attacking = false;
					LEFTPUSH = false;
					attacking = false;
					skill2HAP = false;
					skill2 = false;
					skill2offcooldown = true;

				}

			}

		}

		if (skill2 && skill2offcooldown || skill2 && skill1HAP ) {

			skill2 = false;

		}

		if (skillult && ult >= 100 ) {

			MAXULT = true;

		}

		if (MAXULT && Game.char1 == "MaxuelP1") {

			hitboxMX = new Box(0, 0, 0, 0, Color.ORANGE);
			ult -= 0.1;
			SPEED = 2;

			if (Game.char2 == "trainer") {

				mirault mira = new mirault(Game.trainer.getX(), Game.trainer.getY() - 70, 40, 40, null);

				if (dirM == right_dirM) {

					if (oncetest == false) {

						Game.miras.add(mira);

						oncetest = true;

					}

				}

				if (dirM == left_dirM) {

					if (oncetest == false) {

						Game.miras.add(mira);

						oncetest = true;

					}
				}
			}

			if (skillult && dirM == right_dirM && !skillultcooldown) {

				skillultcooldown = true;

				Bullets bullet = new Bullets(Game.MaxuelP1.getX() + 140, getY() + 70, 6, 6, null, 1, 1);
				Game.bullets.add(bullet);

			}

			if (skillult && dirM == left_dirM && !skillultcooldown) {

				skillultcooldown = true;

				Bullets bullet = new Bullets(Game.MaxuelP1.getX() - 20, getY() + 70, 6, 6, null, 1, 1);
				Game.bullets.add(bullet);

			}

			if (dirM == left_dirM) {
				hitboxULT = new Box(getX() + 50 - Camera.x, getY() + 62 - Camera.y, getWidth() + 20, getHeight(),
						Color.ORANGE);

			}

			if (dirM == right_dirM) {
				hitboxULT = new Box(getX() - Camera.x, getY() + 62 - Camera.y, getWidth() + 20, getHeight(),
						Color.ORANGE);

			}

		}

		if (Game.MaxuelP2.MAXULT && Game.char2 == "MaxuelP2") {

			Game.MaxuelP2.hitboxMX = new Box(0, 0, 0, 0, Color.ORANGE);
			Game.MaxuelP2.ult -= 0.1;
			Game.MaxuelP2.SPEED = 2;

			if (Game.char2 == "trainer") {

				mirault mira = new mirault(Game.trainer.getX(), Game.trainer.getY() - 70, 40, 40, null);

				if (dirM == right_dirM) {

					if (oncetest == false) {

						Game.miras.add(mira);

						oncetest = true;

					}

				}

				if (dirM == left_dirM) {

					if (oncetest == false) {

						Game.miras.add(mira);

						oncetest = true;

					}
				}
			}

			if (Game.MaxuelP2.skillult && Game.MaxuelP2.dirM == Game.MaxuelP2.right_dirM
					&& Game.MaxuelP2.skillultcooldown == false) {

				Game.MaxuelP2.skillultcooldown = true;

				Bullets bullet = new Bullets(Game.MaxuelP2.getX() + 140, getY() + 70, 6, 6, null, 1, 1);
				Game.bullets.add(bullet);

			}

			if (Game.MaxuelP2.skillult && Game.MaxuelP2.dirM == Game.MaxuelP2.left_dirM
					&& Game.MaxuelP2.skillultcooldown == false) {

				Game.MaxuelP2.skillultcooldown = true;

				Bullets bullet = new Bullets(Game.MaxuelP2.getX() - 20, getY() + 70, 6, 6, null, 1, 1);
				Game.bullets.add(bullet);

			}

			if (Game.MaxuelP2.dirM == Game.MaxuelP2.left_dirM) {
				Game.MaxuelP2.hitboxULT = new Box(getX() + 50 - Camera.x, getY() + 62 - Camera.y, getWidth() + 20,
						getHeight(), Color.ORANGE);

			}

			if (Game.MaxuelP2.dirM == Game.MaxuelP2.right_dirM) {
				Game.MaxuelP2.hitboxULT = new Box(getX() - Camera.x, getY() + 62 - Camera.y, getWidth() + 20,
						getHeight(), Color.ORANGE);

			}

		}

		if (MAXULT && ult <= 0) {

			MAXULT = false;
			SPEED = 1.4;

		}

		
		if (Game.MaxuelP1.life <= 0) {
			/*
			 * Game.gameState = "MENU";
			 */
			Game.MaxuelP1.dead = true;

		}

		if (Game.MaxuelP2.life <= 0) {
			/*
			 * Game.gameState = "MENU";
			 */
			Game.MaxuelP2.dead = true;

		}
		
		Camera.x = -300;
		Camera.y = -175;

	}

	public void cooldownAttack1() {
		long time = System.currentTimeMillis();
		if (time > lastAttack + cooldownTime) {

			attack1offcooldown = false;

			// System.out.println("CARLOS!");

			lastAttack = time;
		}
	}

	public void cooldownAttack2() {
		long time2 = System.currentTimeMillis();
		if (time2 > lastAttack2 + cooldownTime2) {

			attack2offcooldown = false;

			// System.out.println("JONAS!");

			lastAttack2 = time2;
		}
	}

	public void cooldownAttack3() {
		long time3 = System.currentTimeMillis();
		if (time3 > lastAttack3 + cooldownTime3) {

			attack3offcooldown = false;

			// System.out.println("BRABOS!");

			lastAttack3 = time3;
		}
	}

	public void cooldownSkill1() {
		long time4 = System.currentTimeMillis();
		if (time4 > lastSkill1 + cooldownTime4) {

			skill1offcooldown = false;

			// System.out.println("BRABOS!");

			lastSkill1 = time4;
		}
	}

	public void cooldownSkill2() {
		long time5 = System.currentTimeMillis();
		if (time5 > lastSkill2 + cooldownTime5) {

			skill2offcooldown = false;

			// System.out.println("BRABOS!");

			lastSkill2 = time5;
		}
	}

	public void cooldownULT() {
		long time6 = System.currentTimeMillis();
		if (time6 > lastULT + cooldownTime6) {

			skillultcooldown = false;

			// System.out.println("BRABOS!");

			lastULT = time6;
		}
	}

	public void cooldownJump() {
		long time2 = System.currentTimeMillis();
		if (time2 > lastJump + cooldownTimeJump) {

			jumpoffcooldown = false;

			// System.out.println("JONAS!");

			lastJump = time2;
		}
	}

	// (Game.trainer.hitboxTR)

	public void isAttacking1Hitting() {

		if (Game.char1 == "MaxuelP1") {

			if (hitboxAttack1Right.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack1Left.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack1Right.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack1Left.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack1Right.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack1Left.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack1Right.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxAttack1Left.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxAttack1Right.intersects(Game.ThaianyP2.hitboxTH)
					|| hitboxAttack1Left.intersects(Game.ThaianyP2.hitboxTH)
					|| hitboxAttack1Right.intersects(Game.trainer.hitboxTR)
					|| hitboxAttack1Left.intersects(Game.trainer.hitboxTR)) {

				Game.MaxuelP1.energy += 5;
				Game.MaxuelP1.ult += 3;

				if (Game.PhellipeP1.MODERONALD == false) {
					Game.PhellipeP1.RONALDBAR += 5;

				}

				if (Game.PhellipeP2.MODERONALD == false) {
					Game.PhellipeP2.RONALDBAR += 5;

				}

				for (Players playersbrabo : Game.players2) {

					if (playersbrabo.block == true) {

						playersbrabo.life -= 5 / playersbrabo.defesa;
					} else if (playersbrabo.block == false) {
						playersbrabo.life -= 5;

						if (Game.MaxuelP1.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHBAIXO = true;
							playersbrabo.stunnedmedio = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.MaxuelP1.LEFTPUSH) {

							playersbrabo.LEFTPUSHBAIXO = true;
							playersbrabo.stunnedmedio = true;
							playersbrabo.STUNNED = true;

						}
					}
				}
			}

		}

		if (Game.char2 == "MaxuelP2") {

			if (hitboxAttack1Right.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack1Left.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack1Right.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack1Left.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack1Right.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack1Left.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack1Right.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack1Left.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack1Right.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxAttack1Left.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxAttack1Right.intersects(Game.ThaianyP1.hitboxTH)
					|| hitboxAttack1Left.intersects(Game.ThaianyP1.hitboxTH)) {

				Game.MaxuelP2.energy += 5;
				Game.MaxuelP2.ult += 3;

				if (Game.PhellipeP1.MODERONALD == false) {
					Game.PhellipeP1.RONALDBAR += 5;

				}

				if (Game.PhellipeP2.MODERONALD == false) {
					Game.PhellipeP2.RONALDBAR += 5;

				}

				for (Players playersbrabo : Game.players) {

					if (playersbrabo.block == true) {

						playersbrabo.life -= 5 / playersbrabo.defesa;
					} else if (playersbrabo.block == false) {
						playersbrabo.life -= 5;

						if (Game.MaxuelP2.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHBAIXO = true;
							playersbrabo.stunnedmedio = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.MaxuelP2.LEFTPUSH) {

							playersbrabo.LEFTPUSHMEDIO = true;
							playersbrabo.stunnedmedio = true;
							playersbrabo.STUNNED = true;

						}
					}

				}

			}
		}

	}

	public void isAttacking2Hitting() {

		if (Game.char1 == "MaxuelP1") {

			if (hitboxAttack2Right.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack2Left.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack2Right.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack2Left.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack2Right.intersects(Game.trainer.hitboxTR)
					|| hitboxAttack2Left.intersects(Game.trainer.hitboxTR)
					|| hitboxAttack2Right.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack2Left.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack2Right.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack2Left.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack2Right.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxAttack2Left.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxAttack2Right.intersects(Game.ThaianyP2.hitboxTH)
					|| hitboxAttack2Left.intersects(Game.ThaianyP2.hitboxTH)) {

				Game.MaxuelP1.energy += 5;
				Game.MaxuelP1.ult += 3;

				if (Game.PhellipeP1.MODERONALD == false) {
					Game.PhellipeP1.RONALDBAR += 5;

				}

				if (Game.PhellipeP2.MODERONALD == false) {
					Game.PhellipeP2.RONALDBAR += 5;

				}

				for (Players playersbrabo : Game.players2) {

					if (playersbrabo.block == true) {

						playersbrabo.life -= 10 / playersbrabo.defesa;
					} else if (playersbrabo.block == false) {
						playersbrabo.life -= 10;

						if (Game.MaxuelP1.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHBAIXO = true;
							playersbrabo.stunnedbaixo = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.MaxuelP1.LEFTPUSH) {

							playersbrabo.LEFTPUSHBAIXO = true;
							playersbrabo.stunnedbaixo = true;
							playersbrabo.STUNNED = true;

						}
					}
				}
			}

		}

		if (Game.char2 == "MaxuelP2") {

			if (hitboxAttack2Right.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack2Left.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack2Right.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack2Left.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack2Right.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack2Left.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack2Right.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack2Left.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack2Right.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxAttack2Left.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxAttack2Right.intersects(Game.ThaianyP1.hitboxTH)
					|| hitboxAttack2Left.intersects(Game.ThaianyP1.hitboxTH)) {

				Game.MaxuelP2.energy += 5;
				Game.MaxuelP2.ult += 3;

				if (Game.PhellipeP1.MODERONALD == false) {
					Game.PhellipeP1.RONALDBAR += 5;

				}

				if (Game.PhellipeP2.MODERONALD == false) {
					Game.PhellipeP2.RONALDBAR += 5;

				}

				for (Players playersbrabo : Game.players) {

					if (playersbrabo.block == true) {

						playersbrabo.life -= 10 / playersbrabo.defesa;
					} else if (playersbrabo.block == false) {
						playersbrabo.life -= 10;

						if (Game.MaxuelP2.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHBAIXO = true;
							playersbrabo.stunnedbaixo = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.MaxuelP2.LEFTPUSH) {

							playersbrabo.LEFTPUSHBAIXO = true;
							playersbrabo.stunnedbaixo = true;
							playersbrabo.STUNNED = true;

						}
					}

				}

			}
		}
	}

	public void isAttacking3Hitting() {

		if (Game.char1 == "MaxuelP1") {

			if (hitboxAttack3Right.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack3Left.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack3Right.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack3Left.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack3Right.intersects(Game.trainer.hitboxTR)
					|| hitboxAttack3Left.intersects(Game.trainer.hitboxTR)
					|| hitboxAttack3Right.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack3Left.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack3Right.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack3Left.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack3Right.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxAttack3Left.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxAttack3Right.intersects(Game.ThaianyP2.hitboxTH)
					|| hitboxAttack3Left.intersects(Game.ThaianyP2.hitboxTH)) {

				Game.MaxuelP1.energy += 5;
				Game.MaxuelP1.ult += 3;

				if (Game.PhellipeP1.MODERONALD == false) {
					Game.PhellipeP1.RONALDBAR += 5;

				}

				if (Game.PhellipeP2.MODERONALD == false) {
					Game.PhellipeP2.RONALDBAR += 5;

				}

				for (Players playersbrabo : Game.players2) {

					if (playersbrabo.block == true) {

						playersbrabo.life -= 10 / playersbrabo.defesa;
					} else if (playersbrabo.block == false) {
						playersbrabo.life -= 10;

						if (Game.MaxuelP1.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHALTO = true;
							playersbrabo.stunnedalto = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.MaxuelP1.LEFTPUSH) {

							playersbrabo.LEFTPUSHALTO = true;
							playersbrabo.stunnedalto = true;
							playersbrabo.STUNNED = true;

						}
					}
				}
			}

		}

		if (Game.char2 == "MaxuelP2") {

			if (hitboxAttack3Right.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack3Left.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack3Right.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack3Left.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack3Right.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack3Left.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack3Right.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack3Left.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack3Right.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxAttack3Left.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxAttack3Right.intersects(Game.ThaianyP1.hitboxTH)
					|| hitboxAttack3Left.intersects(Game.ThaianyP1.hitboxTH)) {

				Game.MaxuelP2.energy += 5;
				Game.MaxuelP2.ult += 3;

				if (Game.PhellipeP1.MODERONALD == false) {
					Game.PhellipeP1.RONALDBAR += 5;

				}

				if (Game.PhellipeP2.MODERONALD == false) {
					Game.PhellipeP2.RONALDBAR += 5;

				}
				for (Players playersbrabo : Game.players) {

					if (playersbrabo.block == true) {

						playersbrabo.life -= 10 / playersbrabo.defesa;
					} else if (playersbrabo.block == false) {
						playersbrabo.life -= 10;

						if (Game.MaxuelP2.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHALTO = true;
							playersbrabo.stunnedalto = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.MaxuelP2.LEFTPUSH) {

							playersbrabo.LEFTPUSHALTO = true;
							playersbrabo.stunnedalto = true;
							playersbrabo.STUNNED = true;

						}
					}

				}

			}
		}

	}

	public void isAttackingSkill1Hitting() {

		if (Game.char1 == "MaxuelP1") {

			if (hitboxSkill1Right.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxSkill1Left.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxSkill1Right.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxSkill1Left.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxSkill1Right.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxSkill1Left.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxSkill1Right.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxSkill1Left.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxSkill1Right.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxSkill1Left.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxSkill1Right.intersects(Game.ThaianyP2.hitboxTH)
					|| hitboxSkill1Left.intersects(Game.ThaianyP2.hitboxTH)
					|| hitboxSkill1Right.intersects(Game.trainer.hitboxTR)
					|| hitboxSkill1Left.intersects(Game.trainer.hitboxTR)) {

				Game.MaxuelP1.energy += 5;
				Game.MaxuelP1.ult += 5;

				if (Game.PhellipeP1.MODERONALD == false) {
					Game.PhellipeP1.RONALDBAR += 5;

				}

				if (Game.PhellipeP2.MODERONALD == false) {
					Game.PhellipeP2.RONALDBAR += 5;
					

				}
				for (Players playersbrabo : Game.players2) {

					if (playersbrabo.block == true) {

						playersbrabo.life -= 10 / playersbrabo.defesa;
					} else if (playersbrabo.block == false) {
						playersbrabo.life -= 10;

						if (Game.MaxuelP1.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHMEDIO = true;
							playersbrabo.stunnedmedio = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.MaxuelP1.LEFTPUSH) {

							playersbrabo.LEFTPUSHMEDIO = true;
							playersbrabo.stunnedmedio = true;
							playersbrabo.STUNNED = true;

						}
					}
				}
			}

		}

		if (Game.char2 == "MaxuelP2") {

			if (hitboxSkill1Right.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxSkill1Left.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxSkill1Right.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxSkill1Left.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxSkill1Right.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxSkill1Left.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxSkill1Right.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxSkill1Left.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxSkill1Right.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxSkill1Left.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxSkill1Right.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxSkill1Left.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxSkill1Right.intersects(Game.ThaianyP1.hitboxTH)
					|| hitboxSkill1Left.intersects(Game.ThaianyP1.hitboxTH)) {

				Game.MaxuelP2.energy += 5;
				Game.MaxuelP2.ult += 5;

				if (Game.PhellipeP1.MODERONALD == false) {
					Game.PhellipeP1.RONALDBAR += 5;

				}

				if (Game.PhellipeP2.MODERONALD == false) {
					Game.PhellipeP2.RONALDBAR += 5;

				}
				for (Players playersbrabo : Game.players) {

					if (playersbrabo.block == true) {

						playersbrabo.life -= 10 / playersbrabo.defesa;
					} else if (playersbrabo.block == false) {
						playersbrabo.life -= 10;

						if (Game.MaxuelP2.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHMEDIO = true;
							playersbrabo.stunnedmedio = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.MaxuelP2.LEFTPUSH) {

							playersbrabo.LEFTPUSHMEDIO = true;
							playersbrabo.stunnedmedio = true;
							playersbrabo.STUNNED = true;

						}
					}

				}

			}
		}

	}

	public void isAttackingSkill2Hitting() {

		if (Game.char1 == "MaxuelP1") {

			if (hitboxSkill2Right.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxSkill2Left.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxSkill2Right.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxSkill2Left.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxSkill2Right.intersects(Game.trainer.hitboxTR)
					|| hitboxSkill2Left.intersects(Game.trainer.hitboxTR)
					|| hitboxSkill2Right.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxSkill2Left.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxSkill2Right.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxSkill2Left.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxSkill2Right.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxSkill2Left.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxSkill2Right.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxSkill2Left.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxSkill2Right.intersects(Game.ThaianyP2.hitboxTH)
					|| hitboxSkill2Left.intersects(Game.ThaianyP2.hitboxTH)) {

				Game.MaxuelP1.energy += 5;
				Game.MaxuelP1.ult += 5;

				if (Game.PhellipeP1.MODERONALD == false) {
					Game.PhellipeP1.RONALDBAR += 5;

				}

				if (Game.PhellipeP2.MODERONALD == false) {
					Game.PhellipeP2.RONALDBAR += 5;

				}

				for (Players playersbrabo : Game.players2) {

					if (playersbrabo.block == true) {

						playersbrabo.life -= 6 / playersbrabo.defesa;
					} if (playersbrabo.block == false) {
						playersbrabo.life -= 6;

						playersbrabo.stunnedbaixo = true;
						playersbrabo.STUNNED = true;

					}
				}
			}
		}

		if (Game.char2 == "MaxuelP2") {

			if (hitboxSkill2Right.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxSkill2Left.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxSkill2Right.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxSkill2Left.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxSkill2Right.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxSkill2Left.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxSkill2Right.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxSkill2Left.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxSkill2Right.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxSkill2Left.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxSkill2Right.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxSkill2Left.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxSkill2Right.intersects(Game.ThaianyP1.hitboxTH)
					|| hitboxSkill2Left.intersects(Game.ThaianyP1.hitboxTH)) {

				Game.MaxuelP2.energy += 5;
				Game.MaxuelP2.ult += 5;

				if (Game.PhellipeP1.MODERONALD == false) {
					Game.PhellipeP1.RONALDBAR += 5;

				}

				if (Game.PhellipeP2.MODERONALD == false) {
					Game.PhellipeP2.RONALDBAR += 5;

				}
				for (Players playersbrabo : Game.players) {

					if (playersbrabo.block == true) {

						playersbrabo.life -= 6 / playersbrabo.defesa;
					} else if (playersbrabo.block == false) {
						playersbrabo.life -= 6;

						playersbrabo.stunnedbaixo = true;
						playersbrabo.STUNNED = true;

					}
				}

			}

		}
	}

	/*
	 * 
	 * if (moved == true) {
	 * 
	 * frames++; if (frames == maxFrames) {
	 * 
	 * frames = 0; index++; if (index > maxIndex) { index = 0; } }
	 * 
	 * }
	 */

	public boolean isGround() {

		if (hitboxMX.intersects(Game.chao01) || hitboxULT.intersects(Game.chao01)) {

			Tanochao = true;
			jumping = false;

			return true;
		} else

			Tanochao = false;

		return false;

	}

	public boolean isWallLeft() {

		if (hitboxMX.intersects(Game.parede01)) {

			return true;
		} else

			return false;

	}

	public boolean isWallRight() {

		if (hitboxMX.intersects(Game.parede02)) {

			return true;
		} else

			return false;

	}

	public void MidStun() {

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
					x -= 4;
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

		for (int i = 0; i < Game.miras.size(); i++) {
			Game.miras.get(i).render(g);
		}

		for (int i = 0; i < Game.bullets.size(); i++) {
			Game.bullets.get(i).render(g);

		}

		if (!MAXULT) {

			if (!attacking && !attack1HAP && !isDamaged && !attack2HAP && !Cantattack) {

				if (parado && dirM == left_dirM && !jumping) {

					g.drawImage(leftPlayerParado[indexParado], this.getX() - Camera.x, this.getY() - 3 - Camera.y,
							null);

				}

				if (parado && dirM == right_dirM && !jumping) {

					g.drawImage(rightPlayerParado[indexParado], this.getX() - Camera.x, this.getY() + 8 - Camera.y,
							null);

				}

				if (dirM == left_dirM && !parado && moved && !jumping) {
					g.drawImage(leftPlayer[indexAndar], this.getX() - Camera.x, this.getY() + 10 - Camera.y, null);

				}

				if (dirM == right_dirM && !parado && moved && !jumping) {
					g.drawImage(rightPlayer[indexAndar], this.getX() - Camera.x, this.getY() + 10 - Camera.y, null);

				}

				if (dirM == left_dirM && jumping) {
					g.drawImage(leftPlayerJump, this.getX() - Camera.x, this.getY() - Camera.y, null);

				}

				if (dirM == right_dirM && jumping) {
					g.drawImage(rightPlayerJump, this.getX() - Camera.x, this.getY() - Camera.y, null);

				}

			}

			if (dirM == right_dirM && down && !jumping && !attack1HAP && !attack2HAP) {

				g.drawImage(playerAgachadoRight, this.getX() + 10 - Camera.x, this.getY() + 22 - Camera.y, null);

			}

			if (dirM == left_dirM && down && !jumping && !attack1HAP && !attack2HAP) {

				g.drawImage(playerAgachadoLeft, this.getX() - Camera.x, this.getY() + 17 - Camera.y, null);

			}

			if (attack1 && !attack2HAP && !Cantattack && !STUNNED && !block && !attack1offcooldown) {

				if (dirM == left_dirM) {
					g.drawImage(leftPlayerAttack1[indexAttack1Left], this.getX() - 35 - Camera.x,
							this.getY() - 1 - Camera.y, null);

				}

				if (dirM == right_dirM) {
					g.drawImage(rightPlayerAttack1[indexAttack1Right], this.getX() + 10 - Camera.x,
							this.getY() - 4 - Camera.y, null);

				}

			}

			if (attack2 && !attack2offcooldown && !attack3HAP && !attack1HAP && !block && !STUNNED) {

				if (dirM == left_dirM) {
					g.drawImage(leftPlayerAttack2[indexAttack2Left], this.getX() - 30 - Camera.x,
							this.getY() - 2 - Camera.y, null);

				}

				if (dirM == right_dirM) {
					g.drawImage(rightPlayerAttack2[indexAttack2Right], this.getX() + 6 - Camera.x,
							this.getY() + 3 - Camera.y, null);

				}
			}

			if (attack3 && !attack3offcooldown && !attack1HAP && !attack2HAP && down && !block && !STUNNED) {

				if (dirM == left_dirM) {
					g.drawImage(leftPlayerAttack3[indexAttack3Left], this.getX() - 80 - Camera.x,
							this.getY() + 14 - Camera.y, null);

				}

				if (dirM == right_dirM) {
					g.drawImage(rightPlayerAttack3[indexAttack3Right], this.getX() + 60 - Camera.x,
							this.getY() + 4 - Camera.y, null);

				}

			}

			if (skill1 && !block && !STUNNED && !skill2HAP && !skill1offcooldown) {

				if (dirM == left_dirM) {
					g.drawImage(leftPlayerSkill1[indexSkill1Left], this.getX() - 57 - Camera.x,
							this.getY() + 2 - Camera.y, null);

				}

				if (dirM == right_dirM) {
					g.drawImage(rightPlayerSkill1[indexSkill1Right], this.getX() + 5 - Camera.x,
							this.getY() + 2 - Camera.y, null);

				}
			}

			if (skill2 && !block && !STUNNED && !skill1HAP && !skill2offcooldown) {

				if (dirM == left_dirM) {
					g.drawImage(leftPlayerSkill2[indexSkill2Left], this.getX() - 48 - Camera.x,
							this.getY() - 1 - Camera.y, null);

				}

				if (dirM == right_dirM) {
					g.drawImage(rightPlayerSkill2[indexSkill2Right], this.getX() + 13 - Camera.x,
							this.getY() - 5 - Camera.y, null);

				}
			}

		}

		if (MAXULT) {

			if (dirM == left_dirM) {
				g.drawImage(leftPlayerULT, this.getX() - Camera.x, this.getY() + 53 - Camera.y, null);

			}

			if (dirM == right_dirM) {
				g.drawImage(rightPlayerULT, this.getX() - Camera.x, this.getY() + 55 - Camera.y, null);

			}

		}

		if (isDamaged && dirM == right_dirM) {

			g.drawImage(playerDamageRight, this.getX() -5 - Camera.x, this.getY() - Camera.y, null);
		}
		if (isDamaged && dirM == left_dirM) {

			g.drawImage(playerDamageLeft, this.getX()  - Camera.x, this.getY()+8 - Camera.y, null);
		}

		hitboxMX.DrawRect(g);
		hitboxAttack1Left.DrawRect(g);
		hitboxAttack1Right.DrawRect(g);
		hitboxAttack2Right.DrawRect(g);
		hitboxAttack2Left.DrawRect(g);
		hitboxAttack3Right.DrawRect(g);
		hitboxAttack3Left.DrawRect(g);
		hitboxSkill1Right.DrawRect(g);
		hitboxSkill1Left.DrawRect(g);
		hitboxSkill2Right.DrawRect(g);
		hitboxSkill2Left.DrawRect(g);

	}

}
