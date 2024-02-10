
package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import collisions.Box;
import items.dados;
import items.nuvem;
import items.thayulthorizontal;
import items.thayultvertical;
import main.Game;
import world.Camera;

public class Thaiany extends Players {

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
	private int cooldownTime6 = 2000;
	private long lastULT = 0;

	public int right_dirT;
	public int left_dirT;
	public int dirT;

	private double SPEED = 1.4;
	private int weight;
	private int jumpStrength;

	public Box hitboxTH;

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

	public Thaiany(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);

		hitboxTH = new Box(getX(), getY(), 100, 100, Color.ORANGE);
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

		right_dirT = 0;
		left_dirT = 1;

		dirT = left_dirT;

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
		maxFramesJump = 10;
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
		maxFramesAttack1 = 10;
		indexAttack1Right = 0;
		indexAttack1Left = 0;
		maxIndexAttack1 = 5;

		// ATTACK2

		framesAttack2 = 0;
		maxFramesAttack2 = 10;
		indexAttack2Right = 0;
		indexAttack2Left = 0;
		maxIndexAttack2 = 2;

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
		cooldownTime2 = 2500;
		attack2offcooldown = false;

		lastAttack3 = 0;
		cooldownTime3 = 3000;
		attack3offcooldown = false;

		lastSkill1 = 0;
		skill1offcooldown = false;
		cooldownTime4 = 6000;

		lastSkill2 = 0;
		skill2offcooldown = false;
		cooldownTime5 = 15000;

		rightPlayerParado = new BufferedImage[2];
		leftPlayerParado = new BufferedImage[2];
		rightPlayer = new BufferedImage[6];
		leftPlayer = new BufferedImage[6];
		rightPlayerAttack1 = new BufferedImage[6];
		leftPlayerAttack1 = new BufferedImage[6];
		rightPlayerAttack2 = new BufferedImage[3];
		leftPlayerAttack2 = new BufferedImage[3];
		rightPlayerAttack3 = new BufferedImage[3];
		leftPlayerAttack3 = new BufferedImage[3];
		rightPlayerSkill1 = new BufferedImage[4];
		leftPlayerSkill1 = new BufferedImage[4];
		rightPlayerSkill2 = new BufferedImage[8];
		leftPlayerSkill2 = new BufferedImage[8];
		// rightPlayerULT = new BufferedImage[9];
		// leftPlayerULT = new BufferedImage[9];

		rightPlayerJump = new BufferedImage[4];
		leftPlayerJump = new BufferedImage[4];

		playerDamageLeft = Game.thaiany.getSprite(30, 1288, 50, 80);
		playerDamageRight = Game.thaiany.getSprite(30, 1150, 50, 80);

		playerAgachadoRight = Game.thaiany.getSprite(30, 760, 60, 80);
		playerAgachadoLeft = Game.thaiany.getSprite(30, 648, 60, 80);
		
		

		for (int i = 0; i < 2; i++) {
			rightPlayerParado[i] = Game.thaiany.getSprite(29 + (i * 40), 1560, 41, 90);

		}
		for (int i = 0; i < 2; i++) {
			leftPlayerParado[i] = Game.thaiany.getSprite(70 - (i * 40), 1420, 41, 90);

		}

		for (int i = 0; i < 6; i++) {
			rightPlayer[i] = Game.thaiany.getSprite(30 + (i * 40), 1014, 41, 90);

		}
		for (int i = 0; i < 6; i++) {
			leftPlayer[i] = Game.thaiany.getSprite(228 - (i * 40), 870, 41, 90);

		}

		for (int i = 0; i < 4; i++) {
			rightPlayerJump[i] = Game.thaiany.getSprite(30 + (i * 83), 1980, 70, 190);

		}
		for (int i = 0; i < 4; i++) {
			leftPlayerJump[i] = Game.thaianypuloinverso.getSprite(260 - (i * 83), 0, 70, 176);

		}

		for (int i = 0; i < 6; i++) {
			leftPlayerAttack1[i] = Game.thaiany.getSprite(520 - (i * 98), 1841, 97, 100);

		}
		for (int i = 0; i < 6; i++) {
			rightPlayerAttack1[i] = Game.thaiany.getSprite(30 + (i * 98), 1700, 97, 100);
		}

		for (int i = 0; i < 3; i++) {
			rightPlayerAttack2[i] = Game.thaiany.getSprite(30 + (i * 35), 360, 38, 40);

		}
		for (int i = 0; i < 3; i++) {
			leftPlayerAttack2[i] = Game.thaiany.getSprite(105 - (i * 35), 275, 35, 40);

		}

		for (int i = 0; i < 3; i++) {
			leftPlayerAttack3[i] = Game.thaianyattack3inverso.getSprite(100 - (i * 35), 30, 40, 40);

		}
		for (int i = 0; i < 3; i++) {
			rightPlayerAttack3[i] = Game.thaiany.getSprite(30 + (i * 35), 190, 40, 56);

		}

		/*
		 * for (int i = 0; i < 4; i++) { leftPlayerSkill1[i] =
		 * Game.thaiany.getSprite(410 - (i * 128), 484, 130, 100);
		 * 
		 * } for (int i = 0; i < 4; i++) { rightPlayerSkill1[i] =
		 * Game.thaiany.getSprite(25 + (i * 128), 754, 129, 100);
		 * 
		 * }
		 * 
		 * for (int i = 0; i < 8; i++) { leftPlayerSkill2[i] = Game.thaiany.getSprite(0
		 * - (i * 115), 1030, 108, 110);
		 * 
		 * } for (int i = 0; i < 8; i++) { rightPlayerSkill2[i] =
		 * Game.thaiany.getSprite(30 + (i * 115), 106, 108, 110);
		 * 
		 * }
		 */

		// for (int i = 0; i < 9; i++) {
		// leftPlayerULT[i] = Game.ivanildoultinverso.getSprite(8130 - (i * 1000), 70,
		// 900, 90);
		// leftPlayerULT[i] = Game.ivanildoultinverso.getSprite(870 + (i*1000),70 , 900,
		// 90);
		// }
		/// for (int i = 0; i < 9; i++) {
		// rightPlayerULT[i] = Game.ivanildoult.getSprite(30 + (i * 1000), 145, 900,
		// 90);

		// }



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
		
		if (energy > 100) {

			energy = 100;

		}

		if (Game.char1 == "ThaianyP1" || Game.char2 == "ThaianyP2") {

			hitboxTH = new Box(getX() - Camera.x, getY() - Camera.y, getWidth() / 2, getHeight() - 5, Color.ORANGE);
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

		if (Game.char1 == "ThaianyP1" && !SETARPO) {

			Game.ThaianyP1.dirT = Game.ThaianyP1.right_dirT;

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
			dirT = right_dirT;
			x += rightspeed;

			// CAMERA POSSIBILIDADE 1
			/*
			 * Camera.x+=speed;
			 */
		} else if (dirT == right_dirT && !right) {

			parado = true;

		}

		/*
		 * if (Game.MaxuelP1.right) {
		 * 
		 * Game.MaxuelP1.dirT = Game.MaxuelP1.right_dirT;
		 * 
		 * }
		 * 
		 * if (Game.MaxuelP1.left) {
		 * 
		 * Game.MaxuelP1.dirT = Game.MaxuelP1.left_dirT;
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
			dirT = left_dirT;
			x -= leftspeed;

			// CAMERA POSSIBILIDADE 1
			/*
			 * Camera.x-=speed;
			 */
		} else if (dirT == left_dirT && !left) {

			parado = true;

		}

		if (up && !down && Tanochao) {

			jumping = true;

			y -= 80;

		}

		if (down && isGround() == true && !attack1HAP && !attack2HAP && !STUNNED) {

			moved = false;
			parado = false;

			if (dirT == left_dirT) {
				hitboxTH = new Box(getX() - Camera.x, getY() + 22 - Camera.y, getWidth() - 25, getHeight(),
						Color.ORANGE);

			}

			if (dirT == right_dirT) {
				hitboxTH = new Box(getX() + 10 - Camera.x, getY() + 22 - Camera.y, getWidth() - 25, getHeight(),
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

		if (falling) {

			y += gravity;

		}

		if (isDamaged) {
			this.damageFrames++;
			if (this.damageFrames == 10) {

				this.damageFrames = 0;

			}

		}

		if (attack1 && dirT == right_dirT && !Cantattack && !STUNNED && !block) {
			attacking = true;
			attack1RIGHT = true;
			RIGHTPUSH = true;
			if (!attack1offcooldown) {

				attack1HAP = true;
				if (indexAttack1Right >= 2) {

					hitboxAttack1Right = new Box(getX() + 70 - Camera.x, getY() + 10 - Camera.y, 30, 30, Color.cyan);

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

		if (attack1 && dirT == left_dirT && !attack2 && !Cantattack && !STUNNED && !block) {
			attacking = true;
			LEFTPUSH = true;
			attack1LEFT = true;

			if (!attack1offcooldown) {

				attack1HAP = true;

				if (indexAttack1Left >= 2) {

					hitboxAttack1Left = new Box(getX() - 55 - Camera.x, getY() + 10 - Camera.y, 30, 30, Color.cyan);
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

		if (attack2 == true && dirT == left_dirT && !attack2righthappening && !attack2offcooldown && !attack3HAP
				&& !attack1HAP && !block && !STUNNED) {
			LEFTPUSH = true;

			attack2lefthappening = true;
			attack2HAP = true;

			if (!down) {

				parado = true;
			}

			if (indexAttack2Left >= 1) {

				hitboxAttack2Left = new Box(getX() - 60 - Camera.x, getY() + 10 - Camera.y, 30, 50, Color.cyan);
			}
			framesAttack2++;
			if (framesAttack2 == maxFramesAttack2) {

				framesAttack2 = 0;
				indexAttack2Left++;
				isAttacking2Hitting();
				// isAttacking2Hitting();

				if (indexAttack2Left > maxIndexAttack2) {

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

		if (attack2 == true && dirT == right_dirT && !attack2lefthappening && !attack2offcooldown && !attack3HAP
				&& !attack1HAP && !block && !STUNNED) {
			RIGHTPUSH = true;

			attack2righthappening = true;
			attack2HAP = true;

			if (!down) {

				parado = true;
			}

			if (indexAttack2Right >= 1) {

				hitboxAttack2Right = new Box(getX() + 60 - Camera.x, getY() + 5 - Camera.y, 30, 50, Color.cyan);
			}
			framesAttack2++;
			if (framesAttack2 == maxFramesAttack2) {

				framesAttack2 = 0;
				indexAttack2Right++;
				isAttacking2Hitting();
				// isAttacking2Hitting();

				if (indexAttack2Right > maxIndexAttack2) {

					RIGHTPUSH = false;
					indexAttack2Right = 0;
					attack2offcooldown = true;
					attack2 = false;
					attack2HAP = false;
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

		if (attack3 == true && dirT == left_dirT && !attack3righthappening && !attack3offcooldown && !attack2HAP
				&& !attack1HAP && down && !block && !STUNNED) {
			LEFTPUSH = true;

			down = true;
			attack3lefthappening = true;
			attack3HAP = true;

			if (indexAttack3Left >= 2) {

				hitboxAttack3Left = new Box(getX() - 67 - Camera.x, getY() + 56 - Camera.y, 40, 30, Color.cyan);
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

		if (attack3 == true && dirT == right_dirT && !attack3lefthappening && !attack3offcooldown && !attack2HAP
				&& !attack1HAP && down && !block && !STUNNED) {
			// REMOVE ATTACKING de attack3 e 2
			down = true;
			RIGHTPUSH = true;
			attack3righthappening = true;
			attack3HAP = true;

			if (indexAttack3Right >= 2) {

				hitboxAttack3Right = new Box(getX() + 75 - Camera.x, getY() + 55 - Camera.y, 40, 30, Color.cyan);

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

		if (attack3 && attack3offcooldown || attack3 && attack1HAP || attack3 && attack2HAP || attack3 && !down
				|| attack3 && STUNNED) {

			attack3 = false;
			attack3HAP = false;
			attacking = false;
			attack3lefthappening = false;
			attack3righthappening = false;
			framesAttack3 = 0;
			indexAttack3Right = 0;
			indexAttack3Left = 0;
		}

		if (skillult && attack1HAP || skillult && attack2HAP || skillult && down) {

			skillult = false;
			skillultHAP = false;
			attacking = false;
			// skillultlefthappening = false;
			// skillultrighthappening = false;
			// framesskillult = 0;
			// indexskillultRight = 0;
			// indexskillultLeft = 0;
		}

		if (skill1 && dirT == right_dirT && STUNNED == false && block == false && energy>=10) {

			RIGHTPUSH = true;

			if (skill1offcooldown == false) {
				energy-=10;
				skill1offcooldown = true;
				int dx = 0;
				int px = 0;
				int dy = 0;
				int py = 90;

				px = +68;
				dx = 0;
				dy = 0;

				dados dado1 = new dados(getX() + px, getY() + py, 3, 3, null);
				Game.dadosvarios.add(dado1);
				skill1 = false;

			}

		}

		if (skill1 && dirT == left_dirT && STUNNED == false && block == false && energy>=10) {

			LEFTPUSH = true;

			if (skill1offcooldown == false) {
				energy-=10;
				skill1offcooldown = true;

				int dx = 0;
				int px = 0;
				int dy = 0;
				int py = 90;

				px = -68;
				dx = 0;
				dy = 0;

				dados dado1 = new dados(getX() + px, getY() + py, 3, 3, null);
				Game.dadosvarios.add(dado1);
				skill1 = false;

			}

		}

		if (skill2 && dirT == right_dirT && STUNNED == false && block == false && energy>=10) {

			RIGHTPUSH = true;

			if (skill2offcooldown == false) {
				energy-=10;
				skill2offcooldown = true;
				int dx = 0;
				int dy = 0;
				int px = 0;
				int py = 85;

				px = 50;
				dx = 0;
				dy = 0;
				nuvem nuvem1 = new nuvem(getX() + px, getY() + py, 3, 3, null, dx, dy);
				Game.nuvens.add(nuvem1);
				skill2 = false;

			}

		}

		if (skill2 && dirT == left_dirT && STUNNED == false && block == false && energy>=10) {
			
		

			LEFTPUSH = true;

			if (skill2offcooldown == false) {
				energy-=10;
				skill2offcooldown = true;

				int dx = 0;
				int px = 0;
				int dy = 0;
				int py = 85;

				px = -50;
				dx = 0;
				dy = 0;

				nuvem nuvem1 = new nuvem(getX() + px, getY() + py, 3, 3, null, dx, dy);
				Game.nuvens.add(nuvem1);
				skill2 = false;

			}

		}

		if (skill1 && !Tanochao || attack2HAP || attack1HAP || block || skill1offcooldown || energy<=10) {

			skill1 = false;

		}

		if (skill2 && !Tanochao || attack2HAP || attack1HAP || block || skill2offcooldown || energy<=10) {

			skill2 = false;

		}

		Camera.x = -300;
		Camera.y = -175;

		if (skillult && ult >= 100) {

			ULTON = true;

		}

		if (ULTON && ult <= 0) {

			ULTON = false;

		}

		if (ULTON) {

			ult -= 0.1;

			if (!skillultcooldown) {

				int dx = 0;
				int px = 0;
				int dy = 0;
				int py = -400;

				px = -100;
				dx = 0;
				dy = 1;

				int dx2 = 0;
				int px2 = 0;
				int dy2 = 0;
				int py2 = 0;

				px2 = -400;
				dx2 = 1;
				dy2 = 0;

				int dx3 = 0;
				int px3 = 0;
				int dy3 = 0;
				int py3 = -100;

				px3 = -400;
				dx3 = 1;
				dy3 = 0;

				thayultvertical ultvert1 = new thayultvertical(getX() + -200, getY() + py, 3, 3, null, dx, dy);

				thayultvertical ultvert2 = new thayultvertical(getX() + 0, getY() + -400, 3, 3, null, dx, dy);

				thayultvertical ultvert3 = new thayultvertical(getX() + 200, getY() + -400, 3, 3, null, dx, dy);

				thayultvertical ultvert4 = new thayultvertical(getX() + 400, getY() + -400, 3, 3, null, dx, dy);

				thayulthorizontal ulthorz1 = new thayulthorizontal(getX() + px2, getY() + py2, 3, 3, null, dx2, dy2);

				thayulthorizontal ulthorz2 = new thayulthorizontal(getX() + px3, getY() + py3, 3, 3, null, dx3, dy3);

				/*
				 * thayulthorizontal ulthorz1 = new thayulthorizontal(getX() + -200, getY() +
				 * py, 3, 3, null, dx, dy);
				 * 
				 * thayulthorizontal ulthorz2 = new thayulthorizontal(getX() + 0, getY() + -400,
				 * 3, 3, null, dx, dy);
				 * 
				 * thayulthorizontal ulthorz3 = new thayulthorizontal(getX() + 200, getY() +
				 * -400, 3, 3, null, dx, dy);
				 * 
				 * thayulthorizontal ulthorz4 = new thayulthorizontal(getX() + 400, getY() +
				 * -400, 3, 3, null, dx, dy);
				 * 
				 * thayultvertical ultvert1 = new thayultvertical(getX() + px2, getY() + py2, 3,
				 * 3, null, dx2, dy2);
				 * 
				 * thayultvertical ultvert2 = new thayultvertical(getX() + px3, getY() + py3, 3,
				 * 3, null, dx3, dy3);
				 */

				Game.ulthoriz.add(ulthorz1);

				Game.ulthoriz.add(ulthorz2);

				Game.ultverti.add(ultvert3);

				Game.ultverti.add(ultvert4);

				Game.ultverti.add(ultvert1);

				Game.ultverti.add(ultvert2);

				skillultcooldown = true;
			}

		}
		
		
		if (Game.ThaianyP1.life <= 0) {
			/*
			 * Game.gameState = "MENU";
			 */
			Game.ThaianyP1.dead = true;

		}

		if (Game.ThaianyP2.life <= 0) {
			/*
			 * Game.gameState = "MENU";
			 */
			Game.ThaianyP2.dead = true;

		}

	}

	public void isAttacking1Hitting() {

		if (Game.char1 == "ThaianyP1") {

			if (hitboxAttack1Right.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack1Left.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack1Right.intersects(Game.trainer.hitboxTR)
					|| hitboxAttack1Left.intersects(Game.trainer.hitboxTR)
					|| hitboxAttack1Right.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack1Left.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack1Right.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack1Left.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack1Right.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack1Left.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack1Right.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxAttack1Left.intersects(Game.PhellipeP2.hitboxPH)) {
				
				
				Game.ThaianyP1.energy += 5;
				Game.ThaianyP1.ult += 3;
				
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
						playersbrabo.SETA = true;

						if (Game.ThaianyP1.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHBAIXO = true;
							playersbrabo.stunnedbaixo = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.ThaianyP1.LEFTPUSH) {

							playersbrabo.LEFTPUSHBAIXO = true;
							playersbrabo.stunnedbaixo = true;
							playersbrabo.STUNNED = true;

						}
					}
				}
			}

		}

		if (Game.char2 == "ThaianyP2") {

			if (hitboxAttack1Right.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack1Left.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack1Right.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack1Left.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack1Right.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack1Left.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack1Right.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack1Left.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack1Right.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxAttack1Left.intersects(Game.PhellipeP1.hitboxPH)) {

				
				Game.ThaianyP2.energy += 5;
				Game.ThaianyP2.ult += 3;
				
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
						playersbrabo.SETA = true;
						if (Game.ThaianyP2.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHBAIXO = true;
							playersbrabo.stunnedbaixo = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.ThaianyP2.LEFTPUSH) {

							playersbrabo.LEFTPUSHBAIXO = true;
							playersbrabo.stunnedbaixo = true;
							playersbrabo.STUNNED = true;

						}
					}

				}

			}
		}

	}

	public void isAttacking2Hitting() {

		if (Game.char1 == "ThaianyP1") {

			if (hitboxAttack2Right.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack2Left.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack2Right.intersects(Game.trainer.hitboxTR)
					|| hitboxAttack2Left.intersects(Game.trainer.hitboxTR)
					|| hitboxAttack2Right.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack2Left.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack2Right.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack2Left.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack2Right.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack2Left.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack2Right.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxAttack2Left.intersects(Game.PhellipeP2.hitboxPH)) {

				Game.ThaianyP1.energy += 5;
				Game.ThaianyP1.ult += 3;
				
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
						playersbrabo.SETA = true;

						playersbrabo.stunnedmedio = true;

					}
				}
			}

		}

		if (Game.char2 == "ThaianyP2") {

			if (hitboxAttack2Right.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack2Left.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack2Right.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack2Left.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack2Right.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack2Left.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack2Right.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack2Left.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack2Right.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxAttack2Left.intersects(Game.PhellipeP1.hitboxPH)) {

				

				Game.ThaianyP2.energy += 5;
				Game.ThaianyP2.ult += 3;
				
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

						playersbrabo.stunnedmedio = true;

						playersbrabo.STUNNED = true;

					}
				}

			}

		}
	}

	public void isAttacking3Hitting() {

		if (Game.char1 == "ThaianyP1") {

			if (hitboxAttack3Right.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack3Left.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack3Right.intersects(Game.trainer.hitboxTR)
					|| hitboxAttack3Left.intersects(Game.trainer.hitboxTR)
					|| hitboxAttack3Right.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack3Left.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack3Right.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack3Left.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack3Right.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack3Left.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack3Right.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxAttack3Left.intersects(Game.PhellipeP2.hitboxPH)) {
				

				Game.ThaianyP1.energy += 5;
				Game.ThaianyP1.ult += 3;
				
				if (Game.PhellipeP1.MODERONALD == false) {
					Game.PhellipeP1.RONALDBAR += 5;

				}

				if (Game.PhellipeP2.MODERONALD == false) {
					Game.PhellipeP2.RONALDBAR += 5;

				}

				for (Players playersbrabo : Game.players2) {

					if (playersbrabo.block == true) {

						playersbrabo.life -= 15 / playersbrabo.defesa;
					} else if (playersbrabo.block == false) {
						playersbrabo.life -= 15;

						if (Game.ThaianyP1.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHMEDIO = true;
							playersbrabo.stunnedmedio = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.ThaianyP1.LEFTPUSH) {

							playersbrabo.LEFTPUSHMEDIO = true;
							playersbrabo.stunnedmedio = true;
							playersbrabo.STUNNED = true;

						}

					}
				}
			}

		}

		if (Game.char2 == "ThaianyP2") {

			if (hitboxAttack3Right.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack3Left.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack3Right.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack3Left.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack3Right.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack3Left.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack3Right.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack3Left.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack3Right.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxAttack3Left.intersects(Game.PhellipeP1.hitboxPH)) {

				

				Game.ThaianyP2.energy += 5;
				Game.ThaianyP2.ult += 3;
				
				if (Game.PhellipeP1.MODERONALD == false) {
					Game.PhellipeP1.RONALDBAR += 5;

				}

				if (Game.PhellipeP2.MODERONALD == false) {
					Game.PhellipeP2.RONALDBAR += 5;

				}
				for (Players playersbrabo : Game.players) {

					if (playersbrabo.block == true) {

						playersbrabo.life -= 15 / playersbrabo.defesa;
					} else if (playersbrabo.block == false) {
						playersbrabo.life -= 15;

						if (Game.ThaianyP1.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHMEDIO = true;
							playersbrabo.stunnedmedio = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.ThaianyP1.LEFTPUSH) {

							playersbrabo.LEFTPUSHMEDIO = true;
							playersbrabo.stunnedmedio = true;
							playersbrabo.STUNNED = true;

						}

					}
				}

			}

		}
	}

	public void isULTHitting() {

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

		if (hitboxTH.intersects(Game.chao01)) {

			Tanochao = true;
			jumping = false;

			return true;
		} else

			Tanochao = false;

		return false;

	}

	public boolean isWallLeft() {

		if (hitboxTH.intersects(Game.parede01)) {

			return true;
		} else

			return false;

	}

	public boolean isWallRight() {

		if (hitboxTH.intersects(Game.parede02)) {

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

		for (int i = 0; i < Game.dadosvarios.size(); i++) {
			Game.dadosvarios.get(i).render(g);
		}

		for (int i = 0; i < Game.nuvens.size(); i++) {
			Game.nuvens.get(i).render(g);

		}

		for (int i = 0; i < Game.ultverti.size(); i++) {
			Game.ultverti.get(i).render(g);
		}

		for (int i = 0; i < Game.ulthoriz.size(); i++) {
			Game.ulthoriz.get(i).render(g);
		}

		if (!attacking && !attack1HAP && !isDamaged && !Cantattack) {

			if (parado && dirT == left_dirT && !jumping) {

				g.drawImage(leftPlayerParado[indexParado], this.getX() - Camera.x, this.getY() + 3 - Camera.y, null);

			}

			if (parado && dirT == right_dirT && !jumping) {

				g.drawImage(rightPlayerParado[indexParado], this.getX() - Camera.x, this.getY() + 4 - Camera.y, null);

			}

			if (dirT == left_dirT && !parado && moved && !jumping) {
				g.drawImage(leftPlayer[indexAndar], this.getX() - Camera.x, this.getY() + 6 - Camera.y, null);

			}

			if (dirT == right_dirT && !parado && moved && !jumping) {
				g.drawImage(rightPlayer[indexAndar], this.getX() - Camera.x, this.getY() + 12 - Camera.y, null);

			}

			if (dirT == left_dirT && jumping) {
				g.drawImage(leftPlayerJump[indexJump], this.getX() - 15 - Camera.x, this.getY() - Camera.y, null);

			}

			if (dirT == right_dirT && jumping) {
				g.drawImage(rightPlayerJump[indexJump], this.getX() - 20 - Camera.x, this.getY() - Camera.y, null);

			}

			if (dirT == right_dirT && down && !jumping && !attack1HAP && !attack2HAP) {

				g.drawImage(playerAgachadoRight, this.getX() + 10 - Camera.x, this.getY() + 34 - Camera.y, null);

			}

			if (dirT == left_dirT && down && !jumping && !attack1HAP && !attack2HAP) {

				g.drawImage(playerAgachadoLeft, this.getX() - Camera.x, this.getY() + 35 - Camera.y, null);

			}

		}

		if (attack1 && !attack2HAP && !Cantattack && !STUNNED && !block && !attack1offcooldown) {

			if (dirT == left_dirT) {
				g.drawImage(leftPlayerAttack1[indexAttack1Left], this.getX() - 58 - Camera.x,
						this.getY() + 1 - Camera.y, null);

			}

			if (dirT == right_dirT) {
				g.drawImage(rightPlayerAttack1[indexAttack1Right], this.getX() + 1 - Camera.x,
						this.getY() + 2 - Camera.y, null);

			}

		}

		if (attack2 && !attack2offcooldown && !attack3HAP && !attack1HAP && !block && !STUNNED) {

			if (dirT == left_dirT && !attack2righthappening) {
				g.drawImage(leftPlayerAttack2[indexAttack2Left], this.getX() - 50 - Camera.x,
						this.getY() + 20 - Camera.y, null);

			}

			if (dirT == right_dirT && !attack2lefthappening) {
				g.drawImage(rightPlayerAttack2[indexAttack2Right], this.getX() + 50 - Camera.x,
						this.getY() + 20 - Camera.y, null);

			}
		}

		if (attack3 && !attack3offcooldown && !attack1HAP && !attack2HAP && down && !block && !STUNNED) {

			if (dirT == left_dirT && !attack3righthappening) {
				g.drawImage(leftPlayerAttack3[indexAttack3Left], this.getX() - 55 - Camera.x,
						this.getY() + 64 - Camera.y, null);

			}

			if (dirT == right_dirT && !attack3lefthappening) {
				g.drawImage(rightPlayerAttack3[indexAttack3Right], this.getX() + 70 - Camera.x,
						this.getY() + 64 - Camera.y, null);

			}

		}

		if (isDamaged && dirT == right_dirT) {

			g.drawImage(playerDamageRight, this.getX()  - Camera.x, this.getY()+10 - Camera.y, null);
		}
		if (isDamaged && dirT == left_dirT) {

			g.drawImage(playerDamageLeft, this.getX()  - Camera.x, this.getY()+10 - Camera.y, null);
		}

		hitboxTH.DrawRect(g);
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
