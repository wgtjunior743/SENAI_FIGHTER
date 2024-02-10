package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import collisions.Box;
import items.html;
import items.robo;
import main.Game;
import world.Camera;

public class Ivanildo extends Players {

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

	public int right_dirI;
	public int left_dirI;
	public int dirI;

	private double SPEED = 1.4;
	private int weight;
	private int jumpStrength;

	public Box hitboxIV;

	public Box hitboxAttack1Right;
	public Box hitboxAttack1Left;
	public Box hitboxAttack2;
	public Box hitboxAttack2Left;
	public Box hitboxAttack2Right;
	public Box hitboxAttack3Left;
	public Box hitboxAttack3Right;

	protected Box hitboxSkill2Left;
	protected Box hitboxSkill2Right;
	protected Box hitboxSkill1Right;
	protected Box hitboxSkill1Left;

	private Box hitboxultRight;
	private Box hitboxultLeft;

	private boolean skillultHAP;

	private int indexultRight;
	private int indexultLeft;
	private int maxIndexult;
	private int framesult;
	private int maxFramesult;
	private boolean ULTON = false;

	protected BufferedImage[] rightPlayerULT;
	protected BufferedImage[] leftPlayerULT;

	public Ivanildo(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);

		hitboxIV = new Box(getX(), getY(), 100, 100, Color.ORANGE);
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
		hitboxultLeft = new Box(0, 0, 0, 0, Color.cyan);
		hitboxultRight = new Box(0, 0, 0, 0, Color.cyan);

		indexultRight = 0;
		indexultLeft = 0;
		maxIndexult = 8;
		framesult = 0;
		maxFramesult = 50;

		ult = 0;
		energy = 0;

		right_dirI = 0;
		left_dirI = 1;

		dirI = left_dirI;

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
		maxIndexAndar = 5;
		// PULO
		maxFramesJump = 60;
		framesJump = 0;
		indexJump = 0;
		maxIndexJump = 3;

		jumping = false;
		falling = true;
		// PARADO
		framesParado = 0;
		maxFramesParado = 20;
		indexParado = 0;
		maxIndexParado = 1;
		// ATTACk1
		framesAttack1 = 0;
		maxFramesAttack1 = 6;
		indexAttack1Right = 0;
		indexAttack1Left = 0;
		maxIndexAttack1 = 3;

		// ATTACK2

		framesAttack2 = 0;
		maxFramesAttack2 = 10;
		indexAttack2Right = 0;
		indexAttack2Left = 0;
		maxIndexAttack2 = 4;

		// ATTACK3

		framesAttack3 = 0;
		maxFramesAttack3 = 15;
		indexAttack3Right = 0;
		indexAttack3Left = 0;
		maxIndexAttack3 = 2;

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

		// ULT
		indexultRight = 0;
		indexultLeft = 0;
		maxIndexult = 7;
		framesult = 0;
		maxFramesult = 6;

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
		cooldownTime = 1000;
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
		cooldownTime4 = 5000;

		lastSkill2 = 0;
		skill2offcooldown = false;
		cooldownTime5 = 5000;

		rightPlayerParado = new BufferedImage[2];
		leftPlayerParado = new BufferedImage[2];
		rightPlayer = new BufferedImage[6];
		leftPlayer = new BufferedImage[6];
		rightPlayerAttack1 = new BufferedImage[4];
		leftPlayerAttack1 = new BufferedImage[4];
		rightPlayerAttack2 = new BufferedImage[5];
		leftPlayerAttack2 = new BufferedImage[5];
		rightPlayerAttack3 = new BufferedImage[3];
		leftPlayerAttack3 = new BufferedImage[3];
		rightPlayerSkill1 = new BufferedImage[4];
		leftPlayerSkill1 = new BufferedImage[4];
		rightPlayerSkill2 = new BufferedImage[8];
		leftPlayerSkill2 = new BufferedImage[8];
		rightPlayerULT = new BufferedImage[9];
		leftPlayerULT = new BufferedImage[9];

		rightPlayerJump = new BufferedImage[4];
		leftPlayerJump = new BufferedImage[4];

		playerDamageLeft = Game.ivanildo.getSprite(30, 806, 80, 100);
		playerDamageRight = Game.ivanildo.getSprite(30, 673, 80, 100);

		playerAgachadoRight = Game.ivanildo.getSprite(30, 435, 60, 74);
		playerAgachadoLeft = Game.ivanildo.getSprite(30, 555, 60, 80);

		for (int i = 0; i < 2; i++) {
			rightPlayerParado[i] = Game.ivanildo.getSprite(30 + (i * 69), 1655, 70, 110);

		}
		for (int i = 0; i < 2; i++) {
			leftPlayerParado[i] = Game.ivanildo.getSprite(99 - (i * 69), 1780, 70, 110);

		}

		for (int i = 0; i < 6; i++) {
			rightPlayer[i] = Game.ivanildo.getSprite(30 + (i * 69), 1935, 70, 100);

		}
		for (int i = 0; i < 6; i++) {
			leftPlayer[i] = Game.ivanildo.getSprite(373 - (i * 69), 1509, 70, 100);

		}

		for (int i = 0; i < 4; i++) {
			rightPlayerJump[i] = Game.ivanildo.getSprite(76 + (i * 69), 2082, 70, 98);

		}
		for (int i = 0; i < 4; i++) {
			leftPlayerJump[i] = Game.ivanildo.getSprite(275 - (i * 69), 2231, 70, 100);

		}

		for (int i = 0; i < 4; i++) {
			leftPlayerAttack1[i] = Game.ivanildo.getSprite(283 - (i * 84), 1379, 83, 100);

		}
		for (int i = 0; i < 4; i++) {
			rightPlayerAttack1[i] = Game.ivanildo.getSprite(32 + (i * 84), 1238, 83, 100);

		}

		for (int i = 0; i < 5; i++) {
			rightPlayerAttack2[i] = Game.ivanildo.getSprite(30 + (i * 87), 956, 90, 100);

		}
		for (int i = 0; i < 5; i++) {
			leftPlayerAttack2[i] = Game.ivanildo.getSprite(374 - (i * 87), 1097, 90, 100);

		}

		for (int i = 0; i < 3; i++) {
			leftPlayerAttack3[i] = Game.ivanildo.getSprite(30 + (i * 75), 12, 80, 100);

		}
		for (int i = 0; i < 3; i++) {
			rightPlayerAttack3[i] = Game.ivanildo.getSprite(30 + (i * 75), 12, 80, 100);

		}
		/*
		 * for (int i = 0; i < 4; i++) { leftPlayerSkill1[i] =
		 * Game.ivanildo.getSprite(410 - (i * 128), 484, 130, 100);
		 * 
		 * } for (int i = 0; i < 4; i++) { rightPlayerSkill1[i] =
		 * Game.ivanildo.getSprite(25 + (i * 128), 754, 129, 100);
		 * 
		 * }
		 * 
		 * for (int i = 0; i < 8; i++) { leftPlayerSkill2[i] = Game.ivanildo.getSprite(0
		 * - (i * 115), 1030, 108, 110);
		 * 
		 * } for (int i = 0; i < 8; i++) { rightPlayerSkill2[i] =
		 * Game.ivanildo.getSprite(30 + (i * 115), 106, 108, 110);
		 * 
		 * }
		 */

		for (int i = 0; i < 9; i++) {
			leftPlayerULT[i] = Game.ivanildoultinverso.getSprite(8130 - (i * 1000), 70, 900, 90);
			// leftPlayerULT[i] = Game.ivanildoultinverso.getSprite(870 + (i*1000),70 , 900,
			// 90);
		}
		for (int i = 0; i < 9; i++) {
			rightPlayerULT[i] = Game.ivanildoult.getSprite(30 + (i * 1000), 145, 900, 90);

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

		

		if (Game.char1 == "IvanildoP1" || Game.char2 == "IvanildoP2") {

			hitboxIV = new Box(getX() - Camera.x, getY() - Camera.y, getWidth(), getHeight(), Color.ORANGE);
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
			hitboxultLeft = new Box(0, 0, 0, 0, Color.cyan);
			hitboxultRight = new Box(0, 0, 0, 0, Color.cyan);

		}

		if (Game.char1 == "IvanildoP1" && !SETARPO) {

			Game.IvanildoP1.dirI = Game.IvanildoP1.right_dirI;

			SETARPO = true;

		}

		if (isWallLeft() || down) {

			leftspeed = 0;
		}

		if (isWallRight() || down) {

			rightspeed = 0;
		}

		if (right && !STUNNED && !attacking && !down) {
			parado = false;
			moved = true;
			dirI = right_dirI;
			x += rightspeed;

			// CAMERA POSSIBILIDADE 1
			/*
			 * Camera.x+=speed;
			 */
		} else if (dirI == right_dirI && !right) {

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

		if (left && !STUNNED && !attacking && !down) {
			parado = false;
			moved = true;
			dirI = left_dirI;
			x -= leftspeed;

			// CAMERA POSSIBILIDADE 1
			/*
			 * Camera.x-=speed;
			 */
		} else if (dirI == left_dirI && !left) {

			parado = true;

		}

		if (up && !down && Tanochao) {

			jumping = true;
			jumpStrength = 50;

			y -= jumpStrength;
			jumpStrength -= weight;

		}

		if (down && isGround() == true && !attack1HAP && !attack2HAP && !STUNNED) {

			moved = false;
			parado = false;

			if (dirI == left_dirI) {
				hitboxIV = new Box(getX() - Camera.x, getY() + 22 - Camera.y, getWidth() - 10, getHeight(),
						Color.ORANGE);

			}

			if (dirI == right_dirI) {
				hitboxIV = new Box(getX() + 10 - Camera.x, getY() + 22 - Camera.y, getWidth() - 10, getHeight(),
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

		if (jumping == true) {

			framesJump++;
			if (framesJump == maxFramesJump) {

				framesJump = 0;
				indexJump++;
				if (indexJump > maxIndexJump) {

					indexJump = 0;
					jumping = false;

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

		if (Game.IvanildoP1.life <= 0) {
			/*
			 * Game.gameState = "MENU";
			 */
			Game.IvanildoP1.dead = true;

		}

		if (Game.IvanildoP2.life <= 0) {
			/*
			 * Game.gameState = "MENU";
			 */
			Game.IvanildoP2.dead = true;

		}

		if (falling) {

			y += gravity;

		}

		if (attack1 && dirI == right_dirI && !Cantattack && !STUNNED && !block) {
			attacking = true;
			attack1RIGHT = true;
			RIGHTPUSH = true;
			if (!attack1offcooldown) {

				attack1HAP = true;
				if (indexAttack1Right >= 2) {

					hitboxAttack1Right = new Box(getX() + 70 - Camera.x, getY() + 20 - Camera.y, 30, 30, Color.cyan);

				}
				framesAttack1++;
				if (framesAttack1 == maxFramesAttack1) {

					framesAttack1 = 0;
					indexAttack1Right++;

					if (indexAttack1Right > maxIndexAttack1) {
						isAttacking1Hitting();
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

		if (attack1 && dirI == left_dirI && !attack2 && !Cantattack && !STUNNED && !block) {
			attacking = true;
			LEFTPUSH = true;
			attack1LEFT = true;
			if (!attack1offcooldown) {

				attack1HAP = true;

				if (indexAttack1Left >= 2) {

					hitboxAttack1Left = new Box(getX() - 26 - Camera.x, getY() + 20 - Camera.y, 30, 30, Color.cyan);
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

		if (attack2 == true && dirI == left_dirI && !attack2righthappening && !attack2offcooldown && !attack3HAP
				&& !attack1HAP && !block && !STUNNED) {
			LEFTPUSH = true;
			attacking = true;
			attack2lefthappening = true;
			attack2HAP = true;

			if (indexAttack2Left >= 3) {

				hitboxAttack2Left = new Box(getX() - 30 - Camera.x, getY() + 25 - Camera.y, 40, 30, Color.cyan);
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

		if (attack2 == true && dirI == right_dirI && !attack2lefthappening && !attack2offcooldown && !attack3HAP
				&& !attack1HAP && !block && !STUNNED) {
			RIGHTPUSH = true;
			attacking = true;
			attack2righthappening = true;
			attack2HAP = true;

			if (indexAttack2Right >= 3) {

				hitboxAttack2Right = new Box(getX() + 60 - Camera.x, getY() + 25 - Camera.y, 40, 30, Color.cyan);
			}
			framesAttack2++;
			if (framesAttack2 == maxFramesAttack2) {

				framesAttack2 = 0;
				indexAttack2Right++;

				isAttacking2Hitting();

				if (indexAttack2Right > maxIndexAttack2) {

					// isAttacking2Hitting();
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

		if (attack3 == true && dirI == left_dirI && !attack3righthappening && !attack3offcooldown && !attack2HAP
				&& !attack1HAP && down && !block && !STUNNED) {
			LEFTPUSH = true;
			attacking = true;
			down = true;
			attack3lefthappening = true;
			attack3HAP = true;

			if (indexAttack3Left >= 1) {

				hitboxAttack3Left = new Box(getX() - 70 - Camera.x, getY() + 56 - Camera.y, 60, 45, Color.cyan);
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

		if (attack3 == true && dirI == right_dirI && !attack3lefthappening && !attack3offcooldown && !attack2HAP
				&& !attack1HAP && down && !block && !STUNNED) {
			attacking = true;
			down = true;
			RIGHTPUSH = true;
			attack3righthappening = true;
			attack3HAP = true;

			if (indexAttack3Right >= 1) {

				hitboxAttack3Right = new Box(getX() + 85 - Camera.x, getY() + 55 - Camera.y, 60, 45, Color.cyan);

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

		if (skillult && ult >= 100) {

			ULTON = true;

		}

		if (ult >= 1 && ULTON) {

			ult = 0;

		}

		if (ULTON && dirI == left_dirI) {
			hitboxIV = new Box(0, 0, 0, 0, Color.ORANGE);
			LEFTPUSH = true;
			attacking = true;
			down = true;
			skillultHAP = true;

			if (indexultLeft >= 1) {

				hitboxultLeft = new Box(getX() - 900 - Camera.x, getY() - Camera.y, 900, 80, Color.cyan);
			}
			framesult++;
			if (framesult == maxFramesult) {

				framesult = 0;
				indexultLeft++;
				// isAttacking3Hitting();

				if (indexultLeft > maxIndexult) {

					indexultLeft = 0;

					LEFTPUSH = false;
					skillult = false;
					attacking = false;
					skillultHAP = false;
					down = false;
					ULTON = false;
					// ultlefthappening = false;
					hitboxultLeft = new Box(0, 0, 0, 0, Color.cyan);
					skillultcooldown = true;

				}

			}

		}

		if (ULTON && dirI == right_dirI) {
			hitboxIV = new Box(0, 0, 0, 0, Color.ORANGE);
			attacking = true;
			down = true;
			RIGHTPUSH = true;
			skillultHAP = true;

			if (indexultRight >= 1) {

				hitboxultRight = new Box(getX() + 110 - Camera.x, getY() - Camera.y, 900, 80, Color.cyan);

			}
			framesult++;
			if (framesult == maxFramesult) {

				framesult = 0;
				indexultRight++;
				isULTHitting();

				if (indexultRight > maxIndexult) {

					indexultRight = 0;
					RIGHTPUSH = false;
					skillult = false;
					attacking = false;
					skillultHAP = false;
					ULTON = false;
					// ultrighthappening = false;
					down = false;
					hitboxultRight = new Box(0, 0, 0, 0, Color.cyan);
					skillultcooldown = true;

				}

			}

		}

		if (skillult && attack1HAP || skillult && attack2HAP || skillult && down || skillult && ult<100) {

			skillult = false;
			skillultHAP = false;
			attacking = false;
			// skillultlefthappening = false;
			// skillultrighthappening = false;
			// framesskillult = 0;
			// indexskillultRight = 0;
			// indexskillultLeft = 0;
		}

		if (skill1 && dirI == right_dirI && STUNNED == false && block == false && energy>=10) {

			RIGHTPUSH = true;

			if (skill1offcooldown == false) {
				energy-=10;
				skill1offcooldown = true;
				int dx = 0;
				int dy = 0;
				int px = 0;
				int py = -150;

				px = 100;
				dx = 0;
				dy = 1;
				html bloco1 = new html(getX() + px, getY() + py, 3, 3, null, dx, dy);
				Game.blocohtml.add(bloco1);
				skill1 = false;

			}

		}

		if (skill1 && dirI == left_dirI && STUNNED == false && block == false && energy>=10) {

			LEFTPUSH = true;

			if (skill1offcooldown == false) {
				energy-=10;
				skill1offcooldown = true;

				int dx = 0;
				int px = 0;
				int dy = 0;
				int py = -150;

				px = -168;
				dx = 0;
				dy = 1;

				html bloco1 = new html(getX() + px, getY() + py, 3, 3, null, dx, dy);
				Game.blocohtml.add(bloco1);
				skill1 = false;

			}

		}

		if (skill2 && dirI == right_dirI && STUNNED == false && block == false && energy>=10) {

			RIGHTPUSH = true;

			if (skill2offcooldown == false) {
				energy-=10;
				skill2offcooldown = true;
				int dx = 0;
				int dy = 0;
				int px = 0;
				int py = 30;

				px = 100;
				dx = 1;
				dy = 0;
				robo robo1 = new robo(getX() + px, getY() + py, 3, 3, null, dx, dy);
				Game.robos.add(robo1);
				skill2 = false;

			}

		}

		if (skill2 && dirI == left_dirI && STUNNED == false && block == false && energy>=10) {

			LEFTPUSH = true;

			if (skill2offcooldown == false) {

				energy-=10;
				
				skill2offcooldown = true;

				int dx = 0;
				int px = 0;
				int dy = 0;
				int py = 30;

				px = -106;
				dx = -1;
				dy = 0;

				robo robo1 = new robo(getX() + px, getY() + py, 3, 3, null, dx, dy);
				Game.robos.add(robo1);
				skill2 = false;

			}

		}

		if (skill1 && !Tanochao || attack2HAP || attack1HAP || block || skill1offcooldown ||energy<=10) {

			skill1 = false;

		}

		if (skill2 && !Tanochao || attack2HAP || attack1HAP || block || skill2offcooldown  ||energy<=10) {

			skill2 = false;

		}

		Camera.x = -300;
		Camera.y = -175;

	}

	public void isAttacking1Hitting() {

		if (Game.char1 == "IvanildoP1") {

			if (hitboxAttack1Right.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack1Left.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack1Right.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack1Left.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack1Right.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxAttack1Left.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxAttack1Right.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack1Left.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack1Right.intersects(Game.ThaianyP2.hitboxTH)
					|| hitboxAttack1Left.intersects(Game.ThaianyP2.hitboxTH)
					|| hitboxAttack1Right.intersects(Game.trainer.hitboxTR)
					|| hitboxAttack1Left.intersects(Game.trainer.hitboxTR)) {

				Game.IvanildoP1.energy += 5;
				Game.IvanildoP1.ult += 2;

				if (Game.PhellipeP1.MODERONALD == false) {
					Game.PhellipeP1.RONALDBAR += 5;

				}

				if (Game.PhellipeP2.MODERONALD == false) {
					Game.PhellipeP2.RONALDBAR += 5;

				}

				for (Players playersbrabo : Game.players2) {

					if (playersbrabo.block == true) {

						playersbrabo.life -= 2 / playersbrabo.defesa;
					} else if (playersbrabo.block == false) {
						playersbrabo.life -= 2;

						if (Game.IvanildoP1.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHBAIXO = true;
							playersbrabo.stunnedmedio = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.IvanildoP1.LEFTPUSH) {

							playersbrabo.LEFTPUSHBAIXO = true;
							playersbrabo.stunnedmedio = true;
							playersbrabo.STUNNED = true;

						}
					}
				}
			}

		}

		if (Game.char2 == "IvanildoP2") {

			if (hitboxAttack1Right.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack1Left.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack1Right.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack1Left.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack1Right.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxAttack1Left.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxAttack1Right.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack1Left.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack1Right.intersects(Game.ThaianyP1.hitboxTH)
					|| hitboxAttack1Left.intersects(Game.ThaianyP1.hitboxTH)) {

				Game.IvanildoP2.energy += 5;
				Game.IvanildoP2.ult += 2;

				if (Game.PhellipeP1.MODERONALD == false) {
					Game.PhellipeP1.RONALDBAR += 5;

				}

				if (Game.PhellipeP2.MODERONALD == false) {
					Game.PhellipeP2.RONALDBAR += 5;

				}

				for (Players playersbrabo : Game.players) {

					if (playersbrabo.block == true) {

						playersbrabo.life -= 2 / playersbrabo.defesa;
					} else if (playersbrabo.block == false) {
						playersbrabo.life -= 2;

						if (Game.IvanildoP2.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHBAIXO = true;
							playersbrabo.stunnedmedio = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.IvanildoP2.LEFTPUSH) {

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

		if (Game.char1 == "IvanildoP1") {

			if (hitboxAttack2Right.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack2Left.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack2Right.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack2Left.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack2Right.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxAttack2Left.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxAttack2Right.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack2Left.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack2Right.intersects(Game.ThaianyP2.hitboxTH)
					|| hitboxAttack2Left.intersects(Game.ThaianyP2.hitboxTH)
					|| hitboxAttack2Right.intersects(Game.trainer.hitboxTR)
					|| hitboxAttack2Left.intersects(Game.trainer.hitboxTR)) {

				Game.IvanildoP1.energy += 5;
				Game.IvanildoP1.ult += 2;

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

						if (Game.IvanildoP1.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHBAIXO = true;
							playersbrabo.stunnedbaixo = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.IvanildoP1.LEFTPUSH) {

							playersbrabo.LEFTPUSHBAIXO = true;
							playersbrabo.stunnedbaixo = true;
							playersbrabo.STUNNED = true;

						}
					}
				}
			}

		}

		if (Game.char2 == "IvanildoP2") {

			if (hitboxAttack2Right.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack2Left.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack2Right.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack2Left.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack2Right.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxAttack2Left.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxAttack2Right.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack2Left.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack2Right.intersects(Game.ThaianyP1.hitboxTH)
					|| hitboxAttack2Left.intersects(Game.ThaianyP1.hitboxTH)) {

				Game.IvanildoP2.energy += 5;
				Game.IvanildoP2.ult += 2;

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

						if (Game.IvanildoP2.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHBAIXO = true;
							playersbrabo.stunnedbaixo = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.IvanildoP2.LEFTPUSH) {

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

		if (Game.char1 == "IvanildoP1") {

			if (hitboxAttack3Right.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack3Left.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack3Right.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack3Left.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack3Right.intersects(Game.trainer.hitboxTR)
					|| hitboxAttack3Left.intersects(Game.trainer.hitboxTR)
					|| hitboxAttack3Right.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxAttack3Left.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxAttack3Right.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack3Left.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack3Right.intersects(Game.ThaianyP2.hitboxTH)
					|| hitboxAttack3Left.intersects(Game.ThaianyP2.hitboxTH)) {

				Game.IvanildoP1.energy += 5;
				Game.IvanildoP1.ult += 2;

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

						if (Game.IvanildoP1.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHALTO = true;
							playersbrabo.stunnedalto = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.IvanildoP1.LEFTPUSH) {

							playersbrabo.LEFTPUSHALTO = true;
							playersbrabo.stunnedalto = true;
							playersbrabo.STUNNED = true;

						}
					}
				}
			}

		}

		if (Game.char2 == "IvanildoP2") {

			if (hitboxAttack3Right.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack3Left.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack3Right.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack3Left.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack3Right.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxAttack3Left.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxAttack3Right.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack3Left.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack3Right.intersects(Game.ThaianyP1.hitboxTH)
					|| hitboxAttack3Left.intersects(Game.ThaianyP1.hitboxTH)) {

				Game.IvanildoP1.energy += 5;
				Game.IvanildoP1.ult += 2;

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

						if (Game.IvanildoP2.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHALTO = true;
							playersbrabo.stunnedalto = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.IvanildoP2.LEFTPUSH) {

							playersbrabo.LEFTPUSHALTO = true;
							playersbrabo.stunnedalto = true;
							playersbrabo.STUNNED = true;

						}
					}

				}

			}
		}

	}

	public void isULTHitting() {

		if (Game.char1 == "IvanildoP1") {

			if (hitboxultRight.intersects(Game.MoisesP2.hitboxMOI) || hitboxultLeft.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxultRight.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxultLeft.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxultRight.intersects(Game.trainer.hitboxTR)
					|| hitboxultLeft.intersects(Game.trainer.hitboxTR)
					|| hitboxultRight.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxultLeft.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxultRight.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxultLeft.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxultRight.intersects(Game.ThaianyP2.hitboxTH)
					|| hitboxultLeft.intersects(Game.ThaianyP2.hitboxTH)) {

				for (Players playersbrabo : Game.players2) {

					playersbrabo.life -= 12;

				}
			}

		}

		if (Game.char2 == "IvanildoP2") {

			if (hitboxultRight.intersects(Game.MoisesP1.hitboxMOI) || hitboxultLeft.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxultRight.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxultLeft.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxultRight.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxultLeft.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxultRight.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxultLeft.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxultRight.intersects(Game.ThaianyP1.hitboxTH)
					|| hitboxultLeft.intersects(Game.ThaianyP1.hitboxTH)) {

				for (Players playersbrabo : Game.players) {

					playersbrabo.life -= 12;

				}
			}
		}

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

	public boolean isGround() {

		if (hitboxIV.intersects(Game.chao01)) {

			Tanochao = true;
			jumping = false;

			return true;
		} else

			Tanochao = false;

		return false;

	}

	public boolean isWallLeft() {

		if (hitboxIV.intersects(Game.parede01)) {

			return true;
		} else

			return false;

	}

	public boolean isWallRight() {

		if (hitboxIV.intersects(Game.parede02)) {

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

		for (int i = 0; i < Game.robos.size(); i++) {
			Game.robos.get(i).render(g);
		}

		for (int i = 0; i < Game.blocohtml.size(); i++) {
			Game.blocohtml.get(i).render(g);

		}

		if (!ULTON) {

			if (!attacking && !attack1HAP && !isDamaged && !attack2HAP && !Cantattack) {

				if (parado && dirI == left_dirI && !jumping) {

					g.drawImage(leftPlayerParado[indexParado], this.getX() - Camera.x, this.getY() - 10 - Camera.y,
							null);

				}

				if (parado && dirI == right_dirI && !jumping) {

					g.drawImage(rightPlayerParado[indexParado], this.getX() - Camera.x, this.getY() + 6 - Camera.y,
							null);

				}

				if (dirI == left_dirI && !parado && moved && !jumping) {
					g.drawImage(leftPlayer[indexAndar], this.getX() - Camera.x, this.getY() + 1 - Camera.y, null);

				}

				if (dirI == right_dirI && !parado && moved && !jumping) {
					g.drawImage(rightPlayer[indexAndar], this.getX() - Camera.x, this.getY() + 4 - Camera.y, null);

				}

				if (dirI == left_dirI && jumping) {
					g.drawImage(leftPlayerJump[indexJump], this.getX() - Camera.x, this.getY() - Camera.y, null);

				}

				if (dirI == right_dirI && jumping) {
					g.drawImage(rightPlayerJump[indexJump], this.getX() - Camera.x, this.getY() - Camera.y, null);

				}

			}

			if (dirI == right_dirI && down && !jumping && !attack1HAP && !attack2HAP) {

				g.drawImage(playerAgachadoRight, this.getX() + 10 - Camera.x, this.getY() + 32 - Camera.y, null);

			}

			if (dirI == left_dirI && down && !jumping && !attack1HAP && !attack2HAP) {

				g.drawImage(playerAgachadoLeft, this.getX() - Camera.x, this.getY() + 29 - Camera.y, null);

			}

			if (attack1 && !attack2HAP && !Cantattack && !STUNNED && !block && !attack1offcooldown) {

				if (dirI == left_dirI) {
					g.drawImage(leftPlayerAttack1[indexAttack1Left], this.getX() - 15 - Camera.x,
							this.getY() + 12 - Camera.y, null);

				}

				if (dirI == right_dirI) {
					g.drawImage(rightPlayerAttack1[indexAttack1Right], this.getX() + 3 - Camera.x,
							this.getY() + 12 - Camera.y, null);

				}

			}

			if (attack2 && !attack2offcooldown && !attack3HAP && !attack1HAP && !block && !STUNNED) {

				if (dirI == left_dirI) {
					g.drawImage(leftPlayerAttack2[indexAttack2Left], this.getX() - 22 - Camera.x,
							this.getY() + 12 - Camera.y, null);

				}

				if (dirI == right_dirI) {
					g.drawImage(rightPlayerAttack2[indexAttack2Right], this.getX() - Camera.x,
							this.getY() + 12 - Camera.y, null);

				}
			}

			if (attack3 && !attack3offcooldown && !attack1HAP && !attack2HAP && down && !block && !STUNNED) {

				if (dirI == left_dirI) {
					g.drawImage(leftPlayerAttack3[indexAttack3Left], this.getX() - 80 - Camera.x,
							this.getY() + 55 - Camera.y, null);

				}

				if (dirI == right_dirI) {
					g.drawImage(rightPlayerAttack3[indexAttack3Right], this.getX() + 70 - Camera.x,
							this.getY() + 55 - Camera.y, null);

				}

			}

			if (skill1 && !block && !STUNNED && !skill2HAP && !skill1offcooldown) {

				if (dirI == left_dirI) {
					g.drawImage(leftPlayerSkill1[indexSkill1Left], this.getX() - 57 - Camera.x,
							this.getY() + 2 - Camera.y, null);

				}

				if (dirI == right_dirI) {
					g.drawImage(rightPlayerSkill1[indexSkill1Right], this.getX() + 5 - Camera.x,
							this.getY() + 2 - Camera.y, null);

				}
			}

			if (skill2 && !block && !STUNNED && !skill1HAP && !skill2offcooldown) {

				if (dirI == left_dirI) {
					g.drawImage(leftPlayerSkill2[indexSkill2Left], this.getX() - 48 - Camera.x,
							this.getY() - 1 - Camera.y, null);

				}

				if (dirI == right_dirI) {
					g.drawImage(rightPlayerSkill2[indexSkill2Right], this.getX() + 13 - Camera.x,
							this.getY() - 5 - Camera.y, null);

				}
			}

		}

		if (ULTON) {

			if (dirI == left_dirI) {
				g.drawImage(leftPlayerULT[indexultLeft], this.getX() - 825 - Camera.x, this.getY() + 8 - Camera.y,
						null);

			}

			if (dirI == right_dirI) {
				g.drawImage(rightPlayerULT[indexultRight], this.getX() - 4 - Camera.x, this.getY() + 7 - Camera.y,
						null);

			}

		}

		if (isDamaged && dirI == right_dirI) {

			g.drawImage(playerDamageRight, this.getX() - 5 - Camera.x, this.getY()+7 - Camera.y, null);
		}
		if (isDamaged && dirI == left_dirI) {

			g.drawImage(playerDamageLeft, this.getX()  - Camera.x, this.getY() - Camera.y, null);
		}

		hitboxIV.DrawRect(g);
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
		hitboxultRight.DrawRect(g);
		hitboxultLeft.DrawRect(g);

	}
}
