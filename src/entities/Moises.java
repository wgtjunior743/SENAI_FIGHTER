package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import collisions.Box;
import items.mouse;
import items.pc;
import items.roteador;
import items.roteadorUP;
import main.Game;
import world.Camera;

public class Moises extends Players {

	public boolean dead = false;

	// private static int right_dir;
	// private static int left_dir;

	// private static int dir;

	/*
	 * public static int right_dirM; public static int left_dirM;
	 * 
	 * public static int dirNr;
	 */

	public int right_dirM;
	public int left_dirM;
	public int dirM;

	public Box hitboxMOI;
	public Box hitboxAttack1RightMOI1;
	public Box hitboxAttack1LeftMOI1;
	public Box hitboxAttack2MOI1;
	public Box hitboxAgachadoMOI1;
	// ULT
	public Box hitboxULTrightMOI1;
	public Box hitboxULTleftMOI1;

	public int maxSkill3 = 0;

	// COOLDOWNS

	public int maxSkillRot;
//BAGULHO DE STATIC DA MERDA
	// ULT

	protected BufferedImage[] ULTrightPlayerAndando;
	protected BufferedImage[] ULTleftPlayerAndando;
	protected BufferedImage[] ULTrightPlayerParado;
	protected BufferedImage[] ULTleftPlayerParado;
	protected BufferedImage ULTleftattackPlayer;
	protected BufferedImage ULTrightattackPlayer;

	private boolean MOISESULTON = false;
	private boolean MOISESHAKAI = false;
	private int AttackULTframes = 0;
	private int maxFramesULT = 200;

	private double SPEED = 1.4;
	/*
	 * 
	 * J = ATTACK1, K = ATTACK2, L = ATTACK3 U = SKILl 1 , I = SKILL 2 , O = ULT
	 * 
	 * 
	 */
	public boolean skillultHAKAI = false;
	private boolean MOISESATTACKHAKAI = false;

	// OBSOLETO?
	private int maxFramesStun;
	private int Stunframes;
	private boolean Stun;

	public boolean attack1LEFT;
	public boolean attack1RIGHT;

	public int maxSkillRotUp;
	public boolean RIGHT;
	public boolean LEFT;

	public Moises(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);

		ult = 0;

		hitboxMOI = new Box(0, 0, 0, 0, Color.ORANGE);
		hitboxAgachadoMOI1 = new Box(0, 0, 0, 0, Color.ORANGE);
		hitboxAttack1RightMOI1 = new Box(0, 0, 0, 0, Color.cyan);
		hitboxAttack1LeftMOI1 = new Box(0, 0, 0, 0, Color.cyan);

		hitboxULTleftMOI1 = new Box(0, 0, 0, 0, Color.cyan);
		hitboxULTrightMOI1 = new Box(0, 0, 0, 0, Color.cyan);

		rightspeed = 1.4;
		leftspeed = 1.4;

		jumping = true;
		gravity = 2;

		// ANDAR
		framesAndar = 0;
		maxFramesAndar = 7;
		indexAndar = 0;
		maxIndexAndar = 4;
		// PULO
		maxFramesJump = 10;
		framesJump = 0;
		// PARADO
		framesParado = 0;
		maxFramesParado = 20;
		indexParado = 0;
		maxIndexParado = 1;

		// BLOCK

		block = false;

		// ATTACk1
		framesAttack1 = 0;
		maxFramesAttack1 = 10;
		indexAttack1Right = 0;
		indexAttack1Left = 0;
		maxIndexAttack1 = 3;

		maxFramesStun = 50;

		// ATTACK1 COOLDOWN
		attack1cdframes = 0;
		attack1cdmaxframes = 50;

		// TESTE
		TestBooleanFalsa = false;

		TestBooleanVerd = true;

		TesteFrames = 0;

		moved = false;

		right_dirM = 0;
		left_dirM = 1;

		dirM = left_dirM;

		parado = true;

		attack1move = false;
		attacking = false;
		attack1used = false;

		JumpUsed = false;

		isDamaged = false;
		damageFrames = 0;

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
		maxFramesStunalto = 80;

		// STUN EXPLOSION

		StunExplosion = false;
		StunExplosionframes = 0;
		maxFramesStunExplosion = 120;

		// STUN REVERSO
		Stunbaixorever = false;
		Stunbaixoreverframes = 0;
		maxFramesStunbaixorever = 60;

		// STUN 0GRAVITY

		Stun0gravity = false;
		Stun0gravityframes = 0;
		maxFramesStun0gravity = 60;

		Attack2frames = 0;
		maxFramesAttack2 = 100;

		attack3cd = false;
		attack3cdframes = 0;
		maxframesattack3cd = 100;

		attack1HAP = false;
		attack2HAP = false;
		downHAP = false;
		Cantattack = false;

		// PUSH

		LEFTPUSH = false;
		RIGHTPUSH = false;

		// COOLDOWN

		lastAttack = 0;
		cooldownTime = 1000;
		attack1offcooldown = false;

		lastAttack2 = 0;
		cooldownTime2 = 3000;
		attack2offcooldown = false;

		lastAttack3 = 0;
		cooldownTime3 = 2000;
		attack3offcooldown = false;

		lastSkill1 = 0;
		cooldownTime4 = 5000;
		skill1offcooldown = false;

		lastJump = 0;
		cooldownTimeJump = 5000;
		jumpoffcooldown = false;

		// NORMAL
		rightPlayerAttack1 = new BufferedImage[4];
		leftPlayerAttack1 = new BufferedImage[4];
		rightPlayerParado = new BufferedImage[2];
		leftPlayerParado = new BufferedImage[2];
		rightPlayer = new BufferedImage[5];
		leftPlayer = new BufferedImage[5];

		// ULT
		ULTrightPlayerAndando = new BufferedImage[5];
		ULTleftPlayerAndando = new BufferedImage[5];
		ULTrightPlayerParado = new BufferedImage[2];
		ULTleftPlayerParado = new BufferedImage[2];

		ULTleftattackPlayer = Game.spritesheet.getSprite(20, 1559, 100, 80);
		ULTrightattackPlayer = Game.spritesheet.getSprite(20, 1076, 100, 80);

		playerDamageLeft = Game.spritesheet.getSprite(0, 1679, 80, 80);
		playerDamageRight = Game.spritesheet.getSprite(0, 1199, 80, 80);

		playerAgachadoRight = Game.spritesheet.getSprite(14, 232, 60, 80);
		playerAgachadoLeft = Game.spritesheet.getSprite(14, 1770, 53, 80);

		playerAttack2Right = Game.spritesheet.getSprite(0, 955, 85, 80);
		playerAttack2Left = Game.spritesheet.getSprite(0, 1437, 85, 80);

		Blockright = Game.blockright.getSprite(0, 0, 30, 80);

		Blockleft = Game.blockleft.getSprite(0, 0, 30, 80);

		for (int i = 0; i < 5; i++) {
			ULTrightPlayerAndando[i] = Game.spritesheet.getSprite(22 + (i * 59), 354, 56, 80);

		}
		for (int i = 0; i < 5; i++) {
			ULTleftPlayerAndando[i] = Game.spritesheet.getSprite(22 + (i * 59), 475, 56, 80);

		}

		for (int i = 0; i < 2; i++) {
			ULTrightPlayerParado[i] = Game.moisesultparado.getSprite(11 + (i * 59), 10, 56, 80);

		}
		for (int i = 0; i < 2; i++) {
			ULTleftPlayerParado[i] = Game.moisesultparado.getSprite(11 + (i * 59), 113, 56, 80);

		}
		////

		for (int i = 0; i < 2; i++) {
			rightPlayerParado[i] = Game.spritesheet.getSprite(22 + (i * 57), 141, 56, 80);

		}
		for (int i = 0; i < 2; i++) {
			leftPlayerParado[i] = Game.spritesheet.getSprite(22 + (i * 57), 20, 56, 80);

		}

		for (int i = 0; i < 4; i++) {
			rightPlayerAttack1[i] = Game.spritesheet.getSprite(23 + (i * 95), 836, 93, 80);

		}
		for (int i = 0; i < 4; i++) {
			leftPlayerAttack1[i] = Game.spritesheet.getSprite(310 - (i * 95), 1317, 93, 80);

		}
		for (int i = 0; i < 5; i++) {
			rightPlayer[i] = Game.spritesheet.getSprite(22 + (i * 57), 595, 56, 80);

		}
		for (int i = 0; i < 5; i++) {
			leftPlayer[i] = Game.spritesheet.getSprite(22 + (i * 57), 715, 56, 80);

		}

	}

	public void tick() {

		leftspeed = SPEED;
		rightspeed = SPEED;

		start();

		

		cooldownAttack1();
		// PRECISA DE UMA ADAPTAÇÃO MELHOR //cooldownAttack2();
		cooldownAttack3();
		cooldownSkill1();
		cooldownJump();

		if (ult > 100) {

			ult = 100;

		}

		

		if (Game.char1 == "MoisesP1") {
			Game.MoisesP1.hitboxMOI = new Box(Game.MoisesP1.getX() + 2 - Camera.x, Game.MoisesP1.getY() + 1 - Camera.y,
					getWidth() - 8, getHeight(), Color.cyan);

			Game.MoisesP1.hitboxAttack1RightMOI1 = new Box(0, 0, 0, 0, Color.cyan);
			Game.MoisesP1.hitboxAttack1LeftMOI1 = new Box(0, 0, 0, 0, Color.cyan);

			Game.MoisesP1.hitboxULTleftMOI1 = new Box(0, 0, 0, 0, Color.cyan);
			Game.MoisesP1.hitboxULTrightMOI1 = new Box(0, 0, 0, 0, Color.cyan);

		}

		if (Game.char2 == "MoisesP2") {
			Game.MoisesP2.hitboxMOI = new Box(Game.MoisesP2.getX() + 2 - Camera.x, Game.MoisesP2.getY() + 1 - Camera.y,
					getWidth() - 8, getHeight(), Color.cyan);

			Game.MoisesP2.hitboxAttack1RightMOI1 = new Box(0, 0, 0, 0, Color.cyan);
			Game.MoisesP2.hitboxAttack1LeftMOI1 = new Box(0, 0, 0, 0, Color.cyan);

			Game.MoisesP2.hitboxULTleftMOI1 = new Box(0, 0, 0, 0, Color.cyan);
			Game.MoisesP2.hitboxULTrightMOI1 = new Box(0, 0, 0, 0, Color.cyan);
		}

		if (Game.char1 == "MoisesP1" && !SETARPO) {

			Game.MoisesP1.dirM = Game.MoisesP1.right_dirM;

			SETARPO = true;

		}

		if (!STUNNED) {

			isDamaged = false;
		}

		if (isDamaged) {
			this.damageFrames++;
			if (this.damageFrames == 10) {

				this.damageFrames = 0;
				isDamaged = false;
			}

		}

		// STUNS TICKS
		isStunnedAlto();
		isStunnedMedio();
		isStunnedBaixo();
		isStunnedBaixoReverso();

		isStunnedExplosion();

		isStunnedHAKAI();
		isStunnedZEROGRAVITY();

		// ANALISE A SER FEITA SE DE FATO A HITBOX NO TICK É IDEAL

		if (isWallLeft()) {

			leftspeed = 0;
		}

		if (isWallRight()) {

			rightspeed = 0;

		}

		if (right && !attack1 && !attack2 && !STUNNED && !MOISESHAKAI && !down) {
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

		if (left && !attack1 && !attack2 && !STUNNED && !MOISESHAKAI && !down) {

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

		/*
		 * if (attack1 && !Playedonce) {
		 * 
		 * parado = false; moved = false; attacking = true; attack1move = true;
		 * 
		 * }
		 */
		/*
		 * if (Playedonce) { attacking = false; attack1 = false; indexAttack1 = 0;
		 * 
		 * attack1cdframes++; while (attack1cdframes == attack1cdmaxframes) {
		 * 
		 * attack1cdframes = 0; Playedonce = false;
		 * 
		 * }
		 * 
		 * }
		 */

		// MOISES P1

		Game.MoisesP1.maxFramesAttack2 = 80;
		Game.MoisesP2.maxFramesAttack2 = 80;

		if (Game.MoisesP1.up && Game.MoisesP1.down == false && Game.MoisesP1.stunnedbaixo == false
				&& Game.MoisesP1.Tanochao && Game.MoisesP1.attack1 == false && Game.MoisesP1.attack2 == false
				&& Game.MoisesP1.MOISESHAKAI == false && Game.MoisesP1.jumpoffcooldown == false) {

			if (Game.MoisesP1.maxSkillRotUp >= 0 && Game.MoisesP1.maxSkillRotUp < 1) {
				Game.MoisesP1.maxSkillRotUp += 1;

				int dx = 0;
				int px = 0;
				int py = 80;
				px = 18;
				dx = 1;

				roteadorUP rotUP = new roteadorUP(Game.MoisesP1.getX() + 5, Game.MoisesP1.getY() + py, 3, 3, null, dx,
						-0.5, "Player1");
				Game.rotsup.add(rotUP);
				rotUP.teleporteUP = true;
				rotUP.rotmov = true;
				Game.MoisesP1.jumpoffcooldown = true;
			}

			// MOISES P2

			/*
			 * if (!jumpoffcooldown) {
			 * 
			 * jumpoffcooldown = true; parado = false; moved = true; for (int i = 0; i < 17;
			 * i += 1) { y -= 2; }
			 * 
			 * }
			 * 
			 */
		}

		if (Game.MoisesP2.up && Game.MoisesP2.down == false && Game.MoisesP2.stunnedbaixo == false
				&& Game.MoisesP2.Tanochao && Game.MoisesP2.attack1 == false && Game.MoisesP2.attack2 == false
				&& Game.MoisesP2.MOISESHAKAI == false && Game.MoisesP2.jumpoffcooldown == false) {

			if (Game.MoisesP2.maxSkillRotUp >= 0 && Game.MoisesP2.maxSkillRotUp < 1) {
				Game.MoisesP2.maxSkillRotUp += 1;

				if (Game.MoisesP2.down) {

					Game.MoisesP2.parado = true;
				}

				int dx = 0;
				int px = 0;
				int py = 80;
				px = 18;
				dx = 1;

				roteadorUP rotUP2 = new roteadorUP(Game.MoisesP2.getX() + 5, Game.MoisesP2.getY() + py, 3, 3, null, dx,
						-0.5, "Player2");
				Game.rotsup2.add(rotUP2);
				rotUP2.teleporteUP2 = true;
				rotUP2.rotmov = true;
				Game.MoisesP2.jumpoffcooldown = true;
			}
		}

		if (Game.MoisesP1.down && Game.MoisesP1.isGround() && Game.MoisesP1.STUNNED == false
				&& Game.MoisesP1.attack1HAP == false && Game.MoisesP1.attack2HAP == false
				&& Game.MoisesP1.MOISESHAKAI == false) {

			Game.MoisesP1.Cantattack = true;
			Game.MoisesP1.moved = false;
			Game.MoisesP1.parado = false;
			Game.MoisesP1.hitboxMOI = new Box(Game.MoisesP1.getX() - Camera.x, Game.MoisesP1.getY() + 25 - Camera.y,
					getWidth(), getHeight(), Color.ORANGE);

		}

		if (Game.MoisesP2.down && Game.MoisesP2.isGround() && Game.MoisesP2.STUNNED == false
				&& Game.MoisesP2.attack1HAP == false && Game.MoisesP2.attack2HAP == false
				&& Game.MoisesP2.MOISESHAKAI == false) {

			Game.MoisesP2.Cantattack = true;
			Game.MoisesP2.moved = false;
			Game.MoisesP2.parado = false;
			Game.MoisesP2.hitboxMOI = new Box(Game.MoisesP2.getX() - Camera.x, Game.MoisesP2.getY() + 25 - Camera.y,
					getWidth(), getHeight(), Color.ORANGE);

		}

		if (!down) {

			Cantattack = false;

		}

		if (Cantattack) {
			attack1 = false;
			attack2 = false;

		}

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

		if (attack1 && attack2HAP) {

			attack1 = false;

		}

		if (attack1 && dirM == right_dirM && !Cantattack && !STUNNED && !block && !MOISESULTON && !MOISESHAKAI) {
			attack1RIGHT = true;
			RIGHTPUSH = true;
			if (!attack1offcooldown) {

				attack1HAP = true;
				if (indexAttack1Right >= 3) {

					hitboxAttack1RightMOI1 = new Box(getX() + 55 - Camera.x, getY() + 10 - Camera.y, 50, 30,
							Color.cyan);
				}
				framesAttack1++;
				if (framesAttack1 == maxFramesAttack1) {

					framesAttack1 = 0;
					indexAttack1Right++;

					if (indexAttack1Right > maxIndexAttack1) {

						indexAttack1Right = 0;
						isAttacking1Hitting();
						RIGHTPUSH = false;
						attack1RIGHT = false;
						attack1 = false;
						attacking = false;
						attack1HAP = false;
						attack1offcooldown = true;
						hitboxAttack1RightMOI1 = new Box(0, 0, 0, 0, Color.cyan);

					}

					/*
					 * attack1 = false; attacking = false;
					 * 
					 */

				}

			}

		}

		if (attack1 && dirM == left_dirM && !attack2 && !Cantattack && !STUNNED && !block && !MOISESULTON
				&& !MOISESHAKAI) {
			LEFTPUSH = true;
			attack1LEFT = true;
			if (!attack1offcooldown) {

				attack1HAP = true;

				if (indexAttack1Left >= 3) {

					hitboxAttack1LeftMOI1 = new Box(getX() - 52 - Camera.x, getY() + 10 - Camera.y, 50, 30, Color.cyan);
				}
				framesAttack1++;
				if (framesAttack1 == maxFramesAttack1) {

					framesAttack1 = 0;
					indexAttack1Left++;

					if (indexAttack1Left > maxIndexAttack1) {

						indexAttack1Left = 0;
						isAttacking1Hitting();
						LEFTPUSH = false;
						attack1LEFT = false;
						attack1 = false;
						attacking = false;
						attack1HAP = false;
						attack1offcooldown = true;
						hitboxAttack1LeftMOI1 = new Box(0, 0, 0, 0, Color.cyan);

					}

					/*
					 * attack1 = false; attacking = false;
					 * 
					 */

				}
			}
		}

		if (attack1 && attack1offcooldown || attack1 && attack2HAP || attack1 && block || attack1 && STUNNED
				|| attack1 && MOISESULTON) {

			attack1 = false;
			attack1HAP = false;
			attacking = false;
			attack1lefthappening = false;
			attack1righthappening = false;

		}

		if (Game.char1 == "MoisesP1" && Game.char2 == "MoisesP2") {

			Game.MoisesP1.maxFramesAttack2 *= 2;
			Game.MoisesP2.maxFramesAttack3 *= 2;

		}

		if (Game.MoisesP1.attack2 && Game.MoisesP1.Cantattack == false && Game.MoisesP1.STUNNED == false
				&& Game.MoisesP1.block == false && Game.MoisesP1.MOISESULTON == false
				&& Game.MoisesP1.MOISESHAKAI == false) {

			roteador.teleporte = true;
			Game.MoisesP1.attack2HAP = true;
			pc.pcmov = true;
			Game.MoisesP1.Attack2frames++;
			while (Game.MoisesP1.Attack2frames == Game.MoisesP1.maxFramesAttack2) {

				Game.MoisesP1.Attack2frames = 0;
				pc.pcmov = false;
				Game.MoisesP1.attack2 = false;
				Game.MoisesP1.attack2HAP = false;
				roteador.teleporte = false;
			}

		}

		if (Game.MoisesP2.attack2 && Game.MoisesP2.Cantattack == false && Game.MoisesP2.STUNNED == false
				&& Game.MoisesP2.block == false && Game.MoisesP2.MOISESULTON == false
				&& Game.MoisesP2.MOISESHAKAI == false) {

			roteador.teleporte2 = true;
			Game.MoisesP2.attack2HAP = true;
			pc.pcmov2 = true;
			Game.MoisesP2.Attack2frames++;
			while (Game.MoisesP2.Attack2frames == Game.MoisesP2.maxFramesAttack2) {

				Game.MoisesP2.Attack2frames = 0;
				pc.pcmov2 = false;
				Game.MoisesP2.attack2 = false;
				Game.MoisesP2.attack2HAP = false;
				roteador.teleporte2 = false;
			}

		}

		if (attack2 && attack2offcooldown || attack2 && attack1HAP || attack2 && block || attack2 && STUNNED
				|| attack2 && MOISESULTON) {

			attack2 = false;
			attack2HAP = false;
			attacking = false;

		}

		if (attack3 && !down || attack3 && MOISESULTON) {

			attack3 = false;
		}

		// MOISES P1

		if (Game.MoisesP1.attack3 && Game.MoisesP1.down && Game.MoisesP1.dirM == Game.MoisesP1.right_dirM
				&& Game.MoisesP1.STUNNED == false && Game.MoisesP1.block == false && Game.MoisesP1.MOISESULTON == false
				&& Game.MoisesP1.MOISESHAKAI == false) {

			if (Game.MoisesP1.attack3offcooldown == false) {

				Game.MoisesP1.RIGHT = true;
				Game.MoisesP1.attack3offcooldown = true;
				int dx = 0;
				int px = 0;
				int py = 80;

				px = 18;
				dx = 1;
				mouse mouse1 = new mouse(Game.MoisesP1.getX() + px, Game.MoisesP1.getY() + py, 3, 3, null, dx, 0,
						"Player1");
				Game.mouses.add(mouse1);
				Game.MoisesP1.attack3 = false;

			}

		}

		if (Game.MoisesP1.attack3 && Game.MoisesP1.down && Game.MoisesP1.dirM == Game.MoisesP1.left_dirM
				&& Game.MoisesP1.STUNNED == false && Game.MoisesP1.block == false && Game.MoisesP1.MOISESULTON == false
				&& Game.MoisesP1.MOISESHAKAI == false) {

			if (Game.MoisesP1.attack3offcooldown == false) {
				Game.MoisesP1.LEFT = true;
				Game.MoisesP1.attack3offcooldown = true;

				Game.MoisesP1.attack3cd = true;

				int dx = 0;
				int px = 0;
				int py = 80;

				px = -8;
				dx = -1;

				mouse mouse1 = new mouse(Game.MoisesP1.getX() + px, Game.MoisesP1.getY() + py, 3, 3, null, dx, 0,
						"Player1");
				Game.mouses.add(mouse1);
				Game.MoisesP1.attack3 = false;

			}

		}

		// MOISES P2

		if (Game.MoisesP2.attack3 && Game.MoisesP2.down && Game.MoisesP2.dirM == Game.MoisesP2.right_dirM
				&& Game.MoisesP2.STUNNED == false && Game.MoisesP2.block == false && Game.MoisesP2.MOISESULTON == false
				&& Game.MoisesP2.MOISESHAKAI == false) {

			if (Game.MoisesP2.attack3offcooldown == false) {
				Game.MoisesP2.RIGHT = true;
				Game.MoisesP2.attack3offcooldown = true;
				int dx = 0;
				int px = 0;
				int py = 80;

				px = 18;
				dx = 1;
				mouse mouse2 = new mouse(Game.MoisesP2.getX() + px, Game.MoisesP2.getY() + py, 3, 3, null, dx, 0,
						"Player2");
				Game.mouses2.add(mouse2);
				Game.MoisesP2.attack3 = false;

			}

		}

		if (Game.MoisesP2.attack3 && Game.MoisesP2.down && Game.MoisesP2.dirM == Game.MoisesP2.left_dirM
				&& Game.MoisesP2.STUNNED == false && Game.MoisesP2.block == false && Game.MoisesP2.MOISESULTON == false
				&& Game.MoisesP2.MOISESHAKAI == false) {

			if (Game.MoisesP2.attack3offcooldown == false) {
				Game.MoisesP2.LEFT = true;
				Game.MoisesP2.attack3offcooldown = true;

				Game.MoisesP2.attack3cd = true;

				int dx = 0;
				int px = 0;
				int py = 80;

				px = -8;
				dx = -1;

				mouse mouse2 = new mouse(Game.MoisesP2.getX() + px, Game.MoisesP2.getY() + py, 3, 3, null, dx, 0,
						"Player2");
				Game.mouses2.add(mouse2);
				Game.MoisesP2.attack3 = false;

			}

		}

		// MOISES P1

		if (Game.MoisesP1.skill1 && Game.MoisesP1.energy >= 10 && Game.MoisesP1.Tanochao
				&& Game.MoisesP1.attack2HAP == false && Game.MoisesP1.attack1HAP == false
				&& Game.MoisesP1.STUNNED == false && Game.MoisesP1.block == false && Game.MoisesP1.MOISESULTON == false
				&& Game.MoisesP1.MOISESHAKAI == false) {

			if (Game.MoisesP1.maxSkill3 >= 0 && Game.MoisesP1.maxSkill3 < 3) {
				Game.MoisesP1.energy -= 5;
				Game.MoisesP1.maxSkill3 += 1;
				int dx = 0;
				int px = 0;
				int py = 80;

				px = 18;
				dx = 1;

				pc pc1 = new pc(Game.MoisesP1.getX() + px, Game.MoisesP1.getY() + py, 3, 3, null, dx, 0, "Player1");
				Game.pcs.add(pc1);

				Game.MoisesP1.skill1 = false;
			} else if (Game.MoisesP1.maxSkill3 >= 3) {

				Game.MoisesP1.skill1 = false;
			}

		}

		// MOISES P2

		if (Game.MoisesP2.skill1 && Game.MoisesP2.energy >= 10 && Game.MoisesP2.Tanochao
				&& Game.MoisesP2.attack2HAP == false && Game.MoisesP2.attack1HAP == false
				&& Game.MoisesP2.STUNNED == false && Game.MoisesP2.block == false && Game.MoisesP2.MOISESULTON == false
				&& Game.MoisesP2.MOISESHAKAI == false) {

			if (Game.MoisesP2.maxSkill3 >= 0 && Game.MoisesP2.maxSkill3 < 3) {
				Game.MoisesP2.energy -= 5;
				Game.MoisesP2.maxSkill3 += 1;
				int dx = 0;
				int px = 0;
				int py = 80;

				px = 18;
				dx = 1;

				pc pc2 = new pc(Game.MoisesP2.getX() + px, Game.MoisesP2.getY() + py, 3, 3, null, dx, 0, "Player2");
				Game.pcs2.add(pc2);

				Game.MoisesP2.skill1 = false;
			} else if (Game.MoisesP2.maxSkill3 >= 3) {

				Game.MoisesP2.skill1 = false;
			}

		}

		if (skill1 && !Tanochao || attack2HAP || attack1HAP || block || energy <= 10) {

			skill1 = false;

		}

		if (skill2 && !Tanochao || attack2HAP || attack1HAP || block || energy <= 10) {

			skill2 = false;

		}

		// MOISES P1

		if (Game.MoisesP1.skill2 && Game.MoisesP1.energy >= 20 && Game.MoisesP1.Tanochao
				&& Game.MoisesP1.attack2HAP == false && Game.MoisesP1.attack1HAP == false
				&& Game.MoisesP1.STUNNED == false && Game.MoisesP1.block == false && Game.MoisesP1.MOISESULTON == false
				&& Game.MoisesP1.MOISESHAKAI == false) {

			if (Game.MoisesP1.maxSkillRot >= 0 && Game.MoisesP1.maxSkillRot < 1) {
				Game.MoisesP1.maxSkillRot += 1;
				Game.MoisesP1.energy -= 5;
				roteador.rotmov = true;
				int dx = 0;
				int px = 0;
				int py = 80;

				px = 18;
				dx = 1;

				roteador rot1 = new roteador(Game.MoisesP1.getX() + px, Game.MoisesP1.getY() + py, 3, 3, null, dx, 0,
						"Player1");
				Game.rots.add(rot1);

				Game.MoisesP1.skill2 = false;
			} else if (Game.MoisesP1.maxSkill3 >= 1) {

				Game.MoisesP1.skill2 = false;
			}

		}

		// MOISES P2

		if (Game.MoisesP2.skill2 && Game.MoisesP2.energy >= 10 && Game.MoisesP2.Tanochao
				&& Game.MoisesP2.attack2HAP == false && Game.MoisesP2.attack1HAP == false
				&& Game.MoisesP2.STUNNED == false && Game.MoisesP2.block == false && Game.MoisesP2.MOISESULTON == false
				&& Game.MoisesP2.MOISESHAKAI == false) {

			if (Game.MoisesP2.maxSkillRot >= 0 && Game.MoisesP2.maxSkillRot < 1) {
				Game.MoisesP2.maxSkillRot += 1;
				Game.MoisesP2.energy -= 5;
				roteador.rotmov = true;
				int dx = 0;
				int px = 0;
				int py = 80;

				px = 18;
				dx = 1;

				roteador rot2 = new roteador(Game.MoisesP2.getX() + px, Game.MoisesP2.getY() + py, 3, 3, null, dx, 0,
						"Player2");
				Game.rots2.add(rot2);

				Game.MoisesP2.skill2 = false;
			} else if (Game.MoisesP2.maxSkill3 >= 1) {

				Game.MoisesP2.skill2 = false;
			}

		}

		if (ult >= 100 && skillult && !MOISESULTON) {

			MOISESULTON = true;
			skillult = false;

		}

		if (MOISESULTON) {

			while (AttackULTframes < maxFramesULT)
				AttackULTframes++;
			ult -= 0.07;
			while (AttackULTframes == maxFramesULT) {

				AttackULTframes = 0;

			}

		}

		if (MOISESULTON && ult <= 0) {

			MOISESULTON = false;

		}

		if (MOISESULTON && skillult) {

			MOISESULTON = false;
			MOISESHAKAI = true;

		}

		if (skillult && ult < 100) {

			skillult = false;

		}

		if (MOISESHAKAI && dirM == right_dirM) {

			ult -= 0.5;
			skillult = false;
			MOISESULTON = false;
			hitboxULTrightMOI1 = new Box(getX() + 56 - Camera.x, getY() + 10 - Camera.y, 30, 30, Color.cyan);
			isAttackingULTHitting();
			AttackULTframes++;
			while (AttackULTframes == maxFramesULT) {
				AttackULTframes = 0;
				MOISESHAKAI = false;
				hitboxULTrightMOI1 = new Box(0, 0, 0, 0, Color.cyan);

			}
		}

		if (MOISESHAKAI && dirM == left_dirM) {
			skillult = false;
			MOISESULTON = false;
			ult -= 0.5;
			hitboxULTleftMOI1 = new Box(getX() - 32 - Camera.x, getY() + 10 - Camera.y, 30, 30, Color.cyan);
			isAttackingULTHitting();
			AttackULTframes++;

			while (AttackULTframes == maxFramesULT) {

				AttackULTframes = 0;
				MOISESHAKAI = false;
				hitboxULTrightMOI1 = new Box(0, 0, 0, 0, Color.cyan);

			}

		}

		/*
		 * if (attack1 && STUNNED || attack2 && STUNNED || attack3 && STUNNED || skill1
		 * && STUNNED || skill2 && STUNNED) {
		 * 
		 * attack1 = false; attack2 = false; attack3 = false; skill1 = false; skill2 =
		 * false;
		 * 
		 * }
		 */

		if (isGround() || stunned0gravity) {

			gravity = 0;

		} else if (!isGround()) {

			gravity = 1.5;

		}

		if (life <= 0) {
		}

		if (falling || jumping) {

			y += gravity;

		}

		if (Game.MoisesP1.life <= 0) {
			/*
			 * Game.gameState = "MENU";
			 */
			Game.MoisesP1.dead = true;

		}

		if (Game.MoisesP2.life <= 0) {
			/*
			 * Game.gameState = "MENU";
			 */
			Game.MoisesP2.dead = true;

		}

		// VERSÃO COM CLAMP

		Camera.x = -300;
		Camera.y = -175;

		// VERSÃO SEM CLAMP

		/*
		 * 
		 * Camera.x = this.getX() - (Game.WIDTH/2); Camera.y = this.getY() -
		 * (Game.HEIGHT/2);
		 */

	}

	public void cooldownAttack1() {
		long time = System.currentTimeMillis();
		if (time > lastAttack + cooldownTime) {

			attack1offcooldown = false;

			// System.out.println("CARLOS!");

			lastAttack = time;
		}
	}

	/*
	 * public void cooldownAttack2() { long time = System.currentTimeMillis(); if
	 * (time > lastAttack2 + cooldownTimeAttack2) {
	 * 
	 * attack2offcooldown = false;
	 * 
	 * // System.out.println("CARLOS!");
	 * 
	 * lastAttack2 = time; } }
	 * 
	 */

	public void cooldownAttack3() {
		long time = System.currentTimeMillis();
		if (time > lastAttack3 + cooldownTime3) {

			attack3offcooldown = false;

			// System.out.println("CARLOS!");

			lastAttack3 = time;
		}
	}

	public void cooldownSkill1() {
		long time = System.currentTimeMillis();
		if (time > lastSkill1 + cooldownTime4) {

			attack1offcooldown = false;

			// System.out.println("CARLOS!");

			lastSkill1 = time;
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

	public boolean JumpCooldown() {

		return false;

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

		if (hitboxMOI.intersects(Game.chao01)) {

			Tanochao = true;
			return true;
		} else
			Tanochao = false;
		return false;

	}

	public boolean isWallLeft() {

		if (hitboxMOI.intersects(Game.parede01)) {

			return true;
		} else

			return false;

	}

	public boolean isWallRight() {

		if (hitboxMOI.intersects(Game.parede02)) {

			return true;
		} else

			return false;

	}

	public boolean isNotmoving() {

		return false;
	}

	public void isAttacking1Hitting() {

		if (Game.char1 == "MoisesP1") {

			if (hitboxAttack1RightMOI1.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxAttack1LeftMOI1.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxAttack1RightMOI1.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack1LeftMOI1.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack1RightMOI1.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack1LeftMOI1.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack1RightMOI1.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack1LeftMOI1.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack1RightMOI1.intersects(Game.ThaianyP2.hitboxTH)
					|| hitboxAttack1LeftMOI1.intersects(Game.ThaianyP2.hitboxTH)
					|| (hitboxAttack1RightMOI1.intersects(Game.trainer.hitboxTR)
							|| hitboxAttack1LeftMOI1.intersects(Game.trainer.hitboxTR))) {

				Game.MoisesP1.energy += 5;
				Game.MoisesP1.ult += 2;

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

						if (Game.MoisesP1.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHMEDIO = true;
							playersbrabo.stunnedmedio = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.MoisesP1.LEFTPUSH) {

							playersbrabo.LEFTPUSHMEDIO = true;
							playersbrabo.stunnedmedio = true;
							playersbrabo.STUNNED = true;

						}
					}
				}

			}

		}

		if (Game.char2 == "MoisesP2") {

			if (hitboxAttack1RightMOI1.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxAttack1LeftMOI1.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxAttack1RightMOI1.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack1LeftMOI1.intersects((Game.MoisesP1.hitboxMOI))
					|| hitboxAttack1RightMOI1.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack1LeftMOI1.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack1RightMOI1.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack1LeftMOI1.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack1RightMOI1.intersects(Game.ThaianyP1.hitboxTH)
					|| hitboxAttack1LeftMOI1.intersects(Game.ThaianyP1.hitboxTH)) {

				Game.MoisesP2.energy += 5;
				Game.MoisesP2.ult += 2;

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

						if (Game.MoisesP2.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHMEDIO = true;
							playersbrabo.stunnedmedio = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.MoisesP2.LEFTPUSH) {

							playersbrabo.LEFTPUSHMEDIO = true;
							playersbrabo.stunnedmedio = true;
							playersbrabo.STUNNED = true;

						}
					}
				}
			}

		}

	}

	public void isAttackingULTHitting() {

		// (Game.trainer.hitboxTR)

		if (Game.char1 == "MoisesP1") {

			if (hitboxULTrightMOI1.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxULTleftMOI1.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxULTrightMOI1.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxULTleftMOI1.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxULTrightMOI1.intersects(Game.trainer.hitboxTR)
					|| hitboxULTleftMOI1.intersects(Game.trainer.hitboxTR)
					|| hitboxULTrightMOI1.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxULTleftMOI1.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxULTrightMOI1.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxULTleftMOI1.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxULTleftMOI1.intersects(Game.ThaianyP2.hitboxTH)
					|| hitboxULTrightMOI1.intersects(Game.ThaianyP2.hitboxTH)) {

				for (Players playersbrabo : Game.players2) {

					playersbrabo.stunnedbaixo = false;
					playersbrabo.stunnedbaixoreverso = false;
					playersbrabo.stunnedmedio = false;
					playersbrabo.stunnedalto = false;
					playersbrabo.stunnedexplosion = false;
					playersbrabo.stunned0gravity = false;
					playersbrabo.life -= 0.5;
					playersbrabo.stunnedHAKAI = true;
					playersbrabo.STUNNED = true;

				}

			}

		}

		if (Game.char2 == "MoisesP2") {

			if (hitboxULTrightMOI1.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxULTleftMOI1.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxULTrightMOI1.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxULTleftMOI1.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxULTrightMOI1.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxULTleftMOI1.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxULTrightMOI1.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxULTleftMOI1.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxULTleftMOI1.intersects(Game.ThaianyP1.hitboxTH)
					|| hitboxULTrightMOI1.intersects(Game.ThaianyP1.hitboxTH)) {

				for (Players playersbrabo : Game.players) {

					playersbrabo.stunnedbaixo = false;
					playersbrabo.stunnedbaixoreverso = false;
					playersbrabo.stunnedmedio = false;
					playersbrabo.stunnedalto = false;
					playersbrabo.stunnedexplosion = false;
					playersbrabo.stunned0gravity = false;
					playersbrabo.life -= 0.5;
					playersbrabo.stunnedHAKAI = true;
					playersbrabo.STUNNED = true;

				}
			}
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

		for (int i = 0; i < Game.mouses.size(); i++) {
			Game.mouses.get(i).render(g);
		}

		for (int i = 0; i < Game.pcs.size(); i++) {
			Game.pcs.get(i).render(g);

		}

		for (int i = 0; i < Game.rots.size(); i++) {
			Game.rots.get(i).render(g);

		}

		for (int i = 0; i < Game.rotsup.size(); i++) {
			Game.rotsup.get(i).render(g);

		}

		for (int i = 0; i < Game.mouses2.size(); i++) {
			Game.mouses2.get(i).render(g);
		}

		for (int i = 0; i < Game.pcs2.size(); i++) {
			Game.pcs2.get(i).render(g);

		}

		for (int i = 0; i < Game.rots2.size(); i++) {
			Game.rots2.get(i).render(g);

		}

		for (int i = 0; i < Game.rotsup2.size(); i++) {
			Game.rotsup2.get(i).render(g);

		}

		if (!attacking && !attack1 && !isDamaged && !attack2 && !MOISESULTON && !MOISESHAKAI) {

			if (parado && dirM == left_dirM) {

				g.drawImage(leftPlayerParado[indexParado], this.getX() - Camera.x, this.getY() - Camera.y, null);

			}

			if (parado && dirM == right_dirM) {

				g.drawImage(rightPlayerParado[indexParado], this.getX() - Camera.x, this.getY() - Camera.y, null);

				// g.drawImage(rightPlayerParado[indexParado], this.getX() - Camera.x,
				// this.getY() - Camera.y, null);

				// VOU AUMENTAR MOISÉSg.drawImage(rightPlayerParado[indexParado], this.getX() -
				// Camera.x, this.getY() - Camera.y,56, 85, null);
				// AUMENTA
				// g.drawImage(rightPlayerParado[indexParado], this.getX() - Camera.x,
				// this.getY() - Camera.y,this.getWidth()*2, this.getHeight()*2, null);

			}

			if (dirM == left_dirM && !parado && moved) {
				g.drawImage(leftPlayer[indexAndar], this.getX() - Camera.x, this.getY() - Camera.y, null);

			}

			if (dirM == right_dirM && !parado && moved) {
				g.drawImage(rightPlayer[indexAndar], this.getX() - Camera.x, this.getY() - Camera.y, null);

			}

		}

		if (dirM == right_dirM && down && Tanochao && !STUNNED && Cantattack) {

			g.drawImage(playerAgachadoRight, this.getX() - Camera.x, this.getY() - Camera.y, null);

		}

		if (dirM == left_dirM && down && Tanochao && !STUNNED && Cantattack) {

			g.drawImage(playerAgachadoLeft, this.getX() - Camera.x, this.getY() - Camera.y, null);

		}

		if (attack1 && !attack2HAP && !Cantattack && !STUNNED && !block && !MOISESULTON && !MOISESHAKAI) {

			if (!Playedonce && dirM == left_dirM) {
				g.drawImage(leftPlayerAttack1[indexAttack1Left], this.getX() - 40 - Camera.x, this.getY() - Camera.y,
						null);

			}

			if (!Playedonce && dirM == right_dirM) {
				g.drawImage(rightPlayerAttack1[indexAttack1Right], this.getX() - Camera.x, this.getY() - Camera.y,
						null);

			}

		}

		if (attack2 && !attack1HAP && !Cantattack && !STUNNED && !block && !MOISESULTON && !MOISESHAKAI) {

			if (dirM == left_dirM) {
				g.drawImage(playerAttack2Left, this.getX() - 22 - Camera.x, this.getY() - Camera.y, null);
			}

			if (dirM == right_dirM) {
				g.drawImage(playerAttack2Right, this.getX() - 22 - Camera.x, this.getY() - Camera.y, null);

			}

		}

		if (isDamaged && dirM == right_dirM) {

			g.drawImage(playerDamageRight, this.getX() - 30 - Camera.x, this.getY() - Camera.y, null);
		}
		if (isDamaged && dirM == left_dirM) {

			g.drawImage(playerDamageLeft, this.getX() - 30 - Camera.x, this.getY() - Camera.y, null);
		}

		if (block && dirM == right_dirM && !STUNNED) {

			g.drawImage(Blockright, this.getX() + 40 - Camera.x, this.getY() - Camera.y, null);

		}

		if (block && dirM == left_dirM && !STUNNED) {

			g.drawImage(Blockleft, this.getX() - 20 - Camera.x, this.getY() - Camera.y, null);

		}

		if (MOISESULTON) {

			if (dirM == left_dirM && !parado && moved && !isDamaged) {
				g.drawImage(ULTleftPlayerAndando[indexAndar], this.getX() - Camera.x, this.getY() - Camera.y, null);

			}

			if (dirM == right_dirM && !parado && moved && !isDamaged) {
				g.drawImage(ULTrightPlayerAndando[indexAndar], this.getX() - Camera.x, this.getY() - Camera.y, null);

			}

			if (dirM == left_dirM && parado && !isDamaged) {
				g.drawImage(ULTleftPlayerParado[indexParado], this.getX() - Camera.x, this.getY() - Camera.y, null);

			}

			if (dirM == right_dirM && parado && !isDamaged) {
				g.drawImage(ULTrightPlayerParado[indexParado], this.getX() - Camera.x, this.getY() - Camera.y, null);

			}

		}

		if (!isDamaged && MOISESHAKAI && dirM == right_dirM) {

			g.drawImage(ULTrightattackPlayer, this.getX() - Camera.x, this.getY() - Camera.y, null);
		}

		if (!isDamaged && MOISESHAKAI && dirM == left_dirM) {

			g.drawImage(ULTleftattackPlayer, this.getX() - 20 - Camera.x, this.getY() - Camera.y, null);
		}

		if (Game.char1 == "MoisesP1") {
			Game.MoisesP1.hitboxMOI.DrawRect(g);
			Game.MoisesP1.hitboxAgachadoMOI1.DrawRect(g);
			Game.MoisesP1.hitboxAttack1LeftMOI1.DrawRect(g);
			Game.MoisesP1.hitboxAttack1RightMOI1.DrawRect(g);
			Game.MoisesP1.hitboxULTleftMOI1.DrawRect(g);
			Game.MoisesP1.hitboxULTrightMOI1.DrawRect(g);

		}

		if (Game.char2 == "MoisesP2") {
			Game.MoisesP2.hitboxMOI.DrawRect(g);
			Game.MoisesP2.hitboxAgachadoMOI1.DrawRect(g);
			Game.MoisesP2.hitboxAttack1LeftMOI1.DrawRect(g);
			Game.MoisesP2.hitboxAttack1RightMOI1.DrawRect(g);
			Game.MoisesP2.hitboxULTleftMOI1.DrawRect(g);
			Game.MoisesP2.hitboxULTrightMOI1.DrawRect(g);

		}

	}

}
