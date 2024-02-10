package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import collisions.Box;
import items.pc;
import items.roteador;
import main.Game;
import world.Camera;

public class Phellipe extends Players {

	public Box hitboxPH;

	public Box hitboxRONALDTRANSFORM;

	public Box hitboxAttack1Right;
	public Box hitboxAttack1Left;
	public Box hitboxAttack2;
	public Box hitboxAttack2Left;
	public Box hitboxAttack2Right;
	public Box hitboxAttack3Left;
	public Box hitboxAttack3Right;

	public int right_dirP;
	public int left_dirP;
	public int dirP;

	private int maxIndexJumpTeste = 6;

	public BufferedImage[] RonaldTransformright;
	public BufferedImage[] RonaldTransformleft;

	private BufferedImage[] RonaldDesTransformright;
	private BufferedImage[] RonaldDesTransformleft;

	public BufferedImage[] RonaldParadoright;
	public BufferedImage[] RonaldParadoleft;
	public BufferedImage[] RonaldAndandoright;
	public BufferedImage[] RonaldAndandoleft;

	public BufferedImage[] RonaldSpecialskill1right;
	public BufferedImage[] RonaldSpecialskill1left;

	public BufferedImage[] RonaldSpecialskill2right;
	public BufferedImage[] RonaldSpecialskill2left;

	private boolean attack2righthappening;
	private boolean attack2lefthappening;

	protected int maxFramesAttack2BRABO = 10;
	private int maxFramesAttack3BRABO = 10;

	private boolean attack3righthappening;
	private boolean attack3lefthappening;
	public boolean attack3HAP;

	public double SPEED = 1;

	public boolean MODERONALD = false;

	public double RONALDBAR = 0;
	public double RONALDBARMAX = 100;

	/*
	 * 
	 * Z = ATTACK1, X = ATTACK2, C = ATTACK3 V = SKILl 1 , B = SKILL 2 , G = ULT
	 * 
	 * 
	 */

	// ULT

	private int indexRONALD;
	private int framesRONALD;
	private int maxFramesRONALD;
	private int maxIndexRONALD;
	private boolean RONALDTRANSFORM;

	private boolean DESTRANSFORM;
	private int framesDESTRANS;
	private int maxFramesDESTRANS;
	private int indexDESTRANS;
	private int maxIndexDESTRANS;

	// ULT ANDAR FRAMES E INDEX
	private int framesAndarULT;
	private int maxFramesAndarULT;
	private int indexAndarULT;
	private int maxIndexAndarULT;
	private int framesSkill1ULT;
	private int maxFramesSkill1ULT;
	private int indexSkill1RightULT;
	private int indexSkill1LeftULT;
	private int maxIndexSkill1ULT;

	private boolean skill1lefthappening;

	private boolean attackingRONALD;
	private boolean skill1righthappening;

	private boolean Skill1RIGHT;
	private boolean Skill1LEFT;

	// private boolean RIGHTPUSHEND;
	// private boolean LEFTPUSHEND;

	private int framesSkill2ULT;
	private int maxFramesSkill2ULT;
	private int indexSkill2RightULT;
	private int indexSkill2LeftULT;
	private int maxIndexSkill2ULT;

	private boolean Skill2RIGHT;

	private Box hitboxRONALDSkill1Right;
	private Box hitboxRONALDSkill1Left;
	private Box hitboxRONALDSkill2Right;
	private Box hitboxRONALDSkill2Left;

	private boolean Skill2LEFT;

	private boolean skill2HAP;
	private boolean skill1HAP;

	private int jumpStrength;

	private int weight = 1;

	private int maxFramesJumpTest = 10;

	private boolean GOTHIT = false;

	private boolean NOTRONALD;

	private boolean DESTRANSFORMTEST;

	// JUMP

	public Phellipe(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);

		// HITBOX

		hitboxPH = new Box(0, 0, 0, 0, Color.ORANGE);
		hitboxAttack1Right = new Box(0, 0, 0, 0, Color.cyan);
		hitboxAttack1Left = new Box(0, 0, 0, 0, Color.cyan);
		hitboxAttack2Right = new Box(0, 0, 0, 0, Color.cyan);
		hitboxAttack2Left = new Box(0, 0, 0, 0, Color.cyan);
		hitboxAttack3Right = new Box(0, 0, 0, 0, Color.cyan);
		hitboxAttack3Left = new Box(0, 0, 0, 0, Color.cyan);

		hitboxRONALDTRANSFORM = new Box(0, 0, 0, 0, Color.cyan);
		hitboxRONALDSkill1Right = new Box(0, 0, 0, 0, Color.cyan);
		hitboxRONALDSkill1Left = new Box(0, 0, 0, 0, Color.cyan);
		hitboxRONALDSkill2Right = new Box(0, 0, 0, 0, Color.cyan);
		hitboxRONALDSkill2Left = new Box(0, 0, 0, 0, Color.cyan);

		RONALDBAR = 10;
		MODERONALD = false;

		ult = 0;
		energy = 0;

		right_dirP = 0;
		left_dirP = 1;
		dirP = left_dirP;

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
		maxFramesAndar = 7;
		indexAndar = 0;
		maxIndexAndar = 4;
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
		maxIndexAttack1 = 3;

		// ATTACK2

		framesAttack2 = 0;
		maxFramesAttack2 = 10;
		indexAttack2Right = 0;
		indexAttack2Left = 0;
		maxIndexAttack2 = 5;

		// ATTACK3

		framesAttack3 = 0;
		maxFramesAttack3 = 10;
		indexAttack3Right = 0;
		indexAttack3Left = 0;
		maxIndexAttack3 = 5;

		// BLOCK

		block = false;
		defesa = 2;

		// ULT

		indexRONALD = 0;
		maxIndexRONALD = 9;
		framesRONALD = 0;
		maxFramesRONALD = 12;

		// ULT DESTRANSFORMAR

		indexDESTRANS = 0;
		maxIndexDESTRANS = 9;
		framesDESTRANS = 0;
		maxFramesDESTRANS = 12;

		// ULT ANDAR

		framesAndarULT = 0;
		maxFramesAndarULT = 10;
		indexAndarULT = 0;
		maxIndexAndarULT = 1;

		// ULT SKILL 1

		framesSkill1ULT = 0;
		maxFramesSkill1ULT = 7;
		indexSkill1RightULT = 0;
		indexSkill1LeftULT = 0;
		maxIndexSkill1ULT = 4;

		// ULT SKILL 2

		framesSkill2ULT = 0;
		maxFramesSkill2ULT = 7;
		indexSkill2RightULT = 0;
		indexSkill2LeftULT = 0;
		maxIndexSkill2ULT = 4;

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

		// ULT

		RonaldDesTransformright = new BufferedImage[13];
		RonaldDesTransformleft = new BufferedImage[13];

		RonaldTransformright = new BufferedImage[13];
		RonaldTransformleft = new BufferedImage[13];

		RonaldParadoright = new BufferedImage[2];
		RonaldParadoleft = new BufferedImage[2];
		RonaldAndandoright = new BufferedImage[2];
		RonaldAndandoleft = new BufferedImage[2];

		RonaldSpecialskill1right = new BufferedImage[5];
		RonaldSpecialskill1left = new BufferedImage[5];

		RonaldSpecialskill2right = new BufferedImage[5];
		RonaldSpecialskill2left = new BufferedImage[5];

		// NORMAL

		rightPlayer = new BufferedImage[6];
		leftPlayer = new BufferedImage[6];
		rightPlayerJump = new BufferedImage[4];
		leftPlayerJump = new BufferedImage[4];
		leftPlayerParado = new BufferedImage[2];
		rightPlayerParado = new BufferedImage[2];
		rightPlayerAttack1 = new BufferedImage[6];
		leftPlayerAttack1 = new BufferedImage[6];
		rightPlayerAttack2 = new BufferedImage[6];
		leftPlayerAttack2 = new BufferedImage[6];
		rightPlayerAttack3 = new BufferedImage[6];
		leftPlayerAttack3 = new BufferedImage[6];

		playerDamageRight = Game.spritesheet2.getSprite(0, 672, 39, 76);
		playerDamageLeft = Game.spritesheet2.getSprite(0, 750, 39, 76);
		playerAgachadoRight = Game.spritesheet2.getSprite(0, 464, 50, 76);
		playerAgachadoLeft = Game.spritesheet2.getSprite(0, 542, 50, 76);

		Blockright = Game.blockright.getSprite(0, 0, 30, 80);

		Blockleft = Game.blockleft.getSprite(0, 0, 30, 80);

		// ULT

		for (int i = 0; i < 10; i++) {
			RonaldDesTransformright[i] = Game.RONALDtransform.getSprite(1050 - (i * 111), 258, 90, 120);

		}
		for (int i = 0; i < 10; i++) {
			RonaldDesTransformleft[i] = Game.RONALDtransform.getSprite(60 + (i * 111), 50, 90, 120);

		}

		for (int i = 0; i < 10; i++) {
			RonaldTransformright[i] = Game.RONALDtransform.getSprite(60 + (i * 111), 258, 90, 120);

		}
		for (int i = 0; i < 10; i++) {
			RonaldTransformleft[i] = Game.RONALDtransform.getSprite(1050 - (i * 111), 50, 90, 120);

		}

		for (int i = 0; i < 2; i++) {
			RonaldParadoleft[i] = Game.RONALDmode.getSprite(8 + (i * 72), 274, 73, 73);

		}
		for (int i = 0; i < 2; i++) {
			RonaldParadoright[i] = Game.RONALDmode.getSprite(8 + (i * 72), 185, 73, 73);

		}

		for (int i = 0; i < 2; i++) {
			RonaldAndandoright[i] = Game.RONALDmode.getSprite(16 + (i * 80), 456, 73, 73);

		}
		for (int i = 0; i < 2; i++) {
			RonaldAndandoleft[i] = Game.RONALDmode.getSprite(10 + (i * 80), 365, 73, 73);

		}

		for (int i = 0; i < 5; i++) {
			RonaldSpecialskill1right[i] = Game.RONALDmode.getSprite(8 + (i * 99), 10, 100, 73);

		}
		for (int i = 0; i < 5; i++) {
			RonaldSpecialskill1left[i] = Game.RONALDmode.getSprite(408 - (i * 99), 98, 100, 73);

		}

		for (int i = 0; i < 5; i++) {
			RonaldSpecialskill2right[i] = Game.RONALDskill2.getSprite(97 + (i * 88), 400, 92, 140);

		}
		for (int i = 0; i < 5; i++) {
			RonaldSpecialskill2left[i] = Game.RONALDskill2.getSprite(451 - (i * 88), 100, 92, 140);

		}

		// NORMAL

		for (int i = 0; i < 5; i++) {
			rightPlayer[i] = Game.spritesheet2.getSprite(1 + (i * 39), 160, 39, 76);

		}
		for (int i = 0; i < 5; i++) {
			leftPlayer[i] = Game.spritesheet2.getSprite(1 + (i * 39), 238, 39, 76);

		}

		for (int i = 0; i < 4; i++) {
			rightPlayerJump[i] = Game.spritesheet2.getSprite(0 + (i * 49), 942, 49, 76);

		}
		for (int i = 0; i < 4; i++) {
			leftPlayerJump[i] = Game.spritesheet2.getSprite(155 - (i * 49), 1159, 49, 76);

		}

		for (int i = 0; i < 2; i++) {
			rightPlayerParado[i] = Game.spritesheet2.getSprite(2 + (i * 39), 2, 39, 76);

		}
		for (int i = 0; i < 2; i++) {
			leftPlayerParado[i] = Game.spritesheet2.getSprite(2 + (i * 39), 82, 39, 76);

		}

		for (int i = 0; i < 6; i++) {
			leftPlayerAttack1[i] = Game.ataque1phinv.getSprite(0 + (i * 92), 0, 90, 35);

		}
		for (int i = 0; i < 6; i++) {
			rightPlayerAttack1[i] = Game.ataque1ph.getSprite(0 + (i * 92), 0, 90, 35);

		}

		for (int i = 0; i < 6; i++) {
			leftPlayerAttack2[i] = Game.spritesheet2.getSprite(429 - (i * 72), 362, 77, 50);

		}
		for (int i = 0; i < 6; i++) {
			rightPlayerAttack2[i] = Game.spritesheet2.getSprite(3 + (i * 72), 316, 75, 50);

		}

		for (int i = 0; i < 6; i++) {
			leftPlayerAttack3[i] = Game.spritesheet2.getSprite(0 + (i * 97), 621, 100, 25);

		}
		for (int i = 0; i < 6; i++) {
			rightPlayerAttack3[i] = Game.spritesheet2.getSprite(0 + (i * 97), 621, 100, 25);

		}

	}

	public void tick() {

		RONALDBARMAX = 100;
		rightspeed = SPEED;
		leftspeed = SPEED;

		SPEED = 1;

		if (!STUNNED) {

			isDamaged = false;
		}


		start();

		cooldownAttack1();

		cooldownAttack2();

		cooldownAttack3();

		cooldownSkill1();

		cooldownSkill2();

		cooldownJump();

		// STUNS TICKS
		isStunnedAlto();
		isStunnedMedio();
		isStunnedBaixo();
		isStunnedBaixoReverso();
		isStunnedZEROGRAVITY();
		isStunnedExplosion();
		isStunnedHAKAI();

		if (Game.char1 == "PhellipeP1" || Game.char2 == "PhellipeP2") {
			hitboxPH = new Box(getX() + 7 - Camera.x, getY() + 1 - Camera.y, getWidth(), getHeight(), Color.ORANGE);
			hitboxAttack1Right = new Box(0, 0, 0, 0, Color.cyan);
			hitboxAttack1Left = new Box(0, 0, 0, 0, Color.cyan);
			hitboxAttack2Right = new Box(0, 0, 0, 0, Color.cyan);
			hitboxAttack2Left = new Box(0, 0, 0, 0, Color.cyan);
			hitboxAttack3Right = new Box(0, 0, 0, 0, Color.cyan);
			hitboxAttack3Left = new Box(0, 0, 0, 0, Color.cyan);

			hitboxRONALDTRANSFORM = new Box(0, 0, 0, 0, Color.cyan);
			hitboxRONALDSkill1Right = new Box(0, 0, 0, 0, Color.cyan);
			hitboxRONALDSkill1Left = new Box(0, 0, 0, 0, Color.cyan);
			hitboxRONALDSkill2Right = new Box(0, 0, 0, 0, Color.cyan);
			hitboxRONALDSkill2Left = new Box(0, 0, 0, 0, Color.cyan);
		}

		if (Game.char1 == "PhellipeP1" && !SETARPO) {

			Game.PhellipeP1.dirP = Game.PhellipeP1.right_dirP;

			SETARPO = true;

		}

		if (RONALDBAR > 100) {

			RONALDBAR = 100;

		}

		if (RONALDBAR == 100) {

			RONALDTRANSFORM = true;
			NOTRONALD = true;
		}

	

		if (Game.PhellipeP1.MODERONALD && Game.PhellipeP1.RONALDBAR <= 5) {

			Game.PhellipeP1.MODERONALD = false;
			Game.PhellipeP1.DESTRANSFORM = true;

		}

		
		
		
		if (Game.PhellipeP2.MODERONALD && Game.PhellipeP2.RONALDBAR <= 5) {

			Game.PhellipeP2.MODERONALD = false;
			Game.PhellipeP2.DESTRANSFORM = true;

		}

		if (MODERONALD && !RONALDTRANSFORM) {

			
			RONALDTRANSFORM = false;
			hitboxPH = new Box(getX() - 5 - Camera.x, getY() + 1 - Camera.y, getWidth() + 30, getHeight(),
					Color.ORANGE);
			RONALDBAR -= 0.40;
			SPEED = 1.5;

			attack1 = false;
			attack2 = false;
			attack3 = false;

			stunnedbaixo = false;
			stunnedbaixoreverso = false;
			stunnedmedio = false;
			stunnedalto = false;
			stunnedexplosion = false;
			stunned0gravity = false;
			stunnedHAKAI = false;
			STUNNED = false;

		}

		if (Game.PhellipeP1.MODERONALD == false && Game.PhellipeP1.NOTRONALD == false) {

			Game.PhellipeP1.SPEED = 1;
			Game.PhellipeP1.skill1 = false;
			Game.PhellipeP1.skill2 = false;

		}
		
		if (Game.PhellipeP2.MODERONALD == false && Game.PhellipeP2.NOTRONALD == false) {

			Game.PhellipeP2.SPEED = 1;
			Game.PhellipeP2.skill1 = false;
			Game.PhellipeP2.skill2 = false;

		}


		if (RONALDTRANSFORM) {

			RONALDBAR -= 0.0005;
			hitboxPH = new Box(0, 0, 0, 0, Color.ORANGE);
			hitboxRONALDTRANSFORM = new Box(getX() + 5 - Camera.x, getY() + 1 - Camera.y, getWidth() + 30, getHeight(),
					Color.ORANGE);

			framesRONALD++;
			if (framesRONALD == maxFramesRONALD) {

				framesRONALD = 0;
				indexRONALD++;

				if (indexRONALD > maxIndexRONALD) {
					RONALDTRANSFORM = false;
					indexRONALD = 0;

					MODERONALD = true;

				}

			}

		}

		if (DESTRANSFORM) {
			NOTRONALD = false;
			RONALDBAR -= 0.0005;
			hitboxPH = new Box(0, 0, 0, 0, Color.ORANGE);
			hitboxRONALDTRANSFORM = new Box(getX() + 5 - Camera.x, getY() + 1 - Camera.y, getWidth() + 30, getHeight(),
					Color.ORANGE);

			framesDESTRANS++;
			if (framesDESTRANS == maxFramesDESTRANS) {

				framesDESTRANS = 0;
				indexDESTRANS++;
				
				right = false;
				left = false;

				if (indexDESTRANS > maxIndexDESTRANS) {
					
					if(skill1 || skill2) {
						
						DESTRANSFORM = false;
					}
					DESTRANSFORM = false;
					indexDESTRANS = 0;
					attackingRONALD = false;
					
					DESTRANSFORMTEST = true;
					

				}

			}

		}

		// ANALISE A SER FEITA SE DE FATO A HITBOX NO TICK É IDEAL

		if (isWallLeft() || down) {

			leftspeed = 0;
		}

		if (isWallRight() || down) {

			rightspeed = 0;
		}

		if (right && !STUNNED && !RONALDTRANSFORM && !attacking && !attackingRONALD && !down && !DESTRANSFORM) {
			parado = false;
			moved = true;
			dirP = right_dirP;
			x += rightspeed;

			// CAMERA POSSIBILIDADE 1
			/*
			 * Camera.x+=speed;
			 */
		} else if (dirP == right_dirP && !right) {

			parado = true;

		}

		/*
		 * if (Game.PhellipeP1.right) {
		 * 
		 * Game.PhellipeP1.dirP = Game.PhellipeP1.right_dirP;
		 * 
		 * }
		 * 
		 * if (Game.PhellipeP1.left) {
		 * 
		 * Game.PhellipeP1.dirP = Game.PhellipeP1.left_dirP;
		 * 
		 * }
		 * 
		 * 
		 * 
		 */
		weight = 1;

		if (left && !STUNNED && !RONALDTRANSFORM && !attacking && !attackingRONALD && !down && !DESTRANSFORM) {
			parado = false;
			moved = true;
			dirP = left_dirP;
			x -= leftspeed;

			// CAMERA POSSIBILIDADE 1
			/*
			 * Camera.x-=speed;
			 */
		} else if (dirP == left_dirP && !left) {

			parado = true;

		}

		if (up && !down && Tanochao && !DESTRANSFORM && !MODERONALD && !RONALDTRANSFORM) {

			jumping = true;
			jumpStrength = 50;

			y -= jumpStrength;
			jumpStrength -= weight;

		}

		/*
		 * if (!jumpoffcooldown) {
		 * 
		 * jumpoffcooldown = true; parado = false; moved = true; for (int i = 0; i < 17;
		 * i += 1) { y -= 3; }
		 * 
		 * }
		 */

		if (Game.PhellipeP1.down && Game.PhellipeP1.isGround() && Game.PhellipeP1.stunnedbaixo == false
				&& Game.PhellipeP1.stunnedmedio == false && Game.PhellipeP1.stunnedalto == false
				&& Game.PhellipeP1.RONALDTRANSFORM == false && Game.PhellipeP1.MODERONALD == false
				&& Game.PhellipeP1.DESTRANSFORM == false) {

			Game.PhellipeP1.moved = false;
			Game.PhellipeP1.parado = false;
			Game.PhellipeP1.hitboxPH = new Box(Game.PhellipeP1.getX() + 3 - Camera.x,
					Game.PhellipeP1.getY() + 15 - Camera.y, getWidth() + 17, getHeight(), Color.ORANGE);

		}

		if (Game.PhellipeP2.down && Game.PhellipeP2.isGround() && Game.PhellipeP2.stunnedbaixo == false
				&& Game.PhellipeP2.stunnedmedio == false && Game.PhellipeP2.stunnedalto == false
				&& Game.PhellipeP2.RONALDTRANSFORM == false && Game.PhellipeP2.MODERONALD == false
				&& Game.PhellipeP2.DESTRANSFORM == false) {

			Game.PhellipeP2.moved = false;
			Game.PhellipeP2.parado = false;
			Game.PhellipeP2.hitboxPH = new Box(Game.PhellipeP2.getX() + 3 - Camera.x,
					Game.PhellipeP2.getY() + 15 - Camera.y, getWidth() + 17, getHeight(), Color.ORANGE);

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

		if (moved == true) {

			framesAndarULT++;
			if (framesAndarULT == maxFramesAndarULT) {

				framesAndarULT = 0;
				indexAndarULT++;
				if (indexAndarULT > maxIndexAndarULT) {
					indexAndarULT = 0;
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

		if (block && !STUNNED) {

		}

		if (attack1 == true && dirP == right_dirP && !attack1lefthappening && !attack1offcooldown && !attack3HAP
				&& !attack2HAP && !block && !STUNNED && !RONALDTRANSFORM && !MODERONALD && !DESTRANSFORM) {

			RIGHTPUSH = true;
			attacking = true;
			attack1righthappening = true;
			attack1HAP = true;

			if (!down) {

				parado = true;
			}

			if (indexAttack1Right >= 3) {

				hitboxAttack1Right = new Box(getX() + 55 - Camera.x, getY() - Camera.y, 95, 30, Color.cyan);
			}
			framesAttack1++;
			if (framesAttack1 == maxFramesAttack1) {

				framesAttack1 = 0;
				indexAttack1Right++;
				isAttacking1Hitting();
				if (indexAttack1Right > maxIndexAttack1) {
					indexAttack1Right = 0;

					RIGHTPUSH = false;
					attack1 = false;
					attacking = false;
					attack1HAP = false;
					attack1righthappening = false;
					hitboxAttack1Right = new Box(0, 0, 0, 0, Color.cyan);
					attack1offcooldown = true;

				}

				/*
				 * attack1 = false; attacking = false;
				 * 
				 */

			}

		}

		if (attack1 == true && dirP == left_dirP && !attack1righthappening && !attack1offcooldown && !attack3HAP
				&& !attack2HAP && !block && !STUNNED && !RONALDTRANSFORM && !MODERONALD && !DESTRANSFORM) {
			LEFTPUSH = true;
			attacking = true;
			attack1lefthappening = true;
			attack1HAP = true;

			if (!down) {

				parado = true;
			}

			if (indexAttack1Left >= 3) {

				hitboxAttack1Left = new Box(getX() - 90 - Camera.x, getY() - Camera.y, 95, 30, Color.cyan);
			}
			framesAttack1++;
			if (framesAttack1 == maxFramesAttack1) {

				framesAttack1 = 0;
				indexAttack1Left++;

				isAttacking1Hitting();

				if (indexAttack1Left > maxIndexAttack1) {
					indexAttack1Left = 0;
					LEFTPUSH = false;
					attack1 = false;
					attacking = false;
					attack1HAP = false;
					attack1lefthappening = false;
					hitboxAttack1Left = new Box(0, 0, 0, 0, Color.cyan);
					attack1offcooldown = true;

				}

				/*
				 * attack1 = false; attacking = false;
				 * 
				 */

			}

		}

		if (attack1 && attack1offcooldown || attack1 && attack2HAP || attack1 && attack3HAP || attack1 && STUNNED
				|| attack1 && RONALDTRANSFORM || attack1 && MODERONALD || attack1 && DESTRANSFORM
				|| attack1 && GOTHIT) {

			attack1 = false;
			attack1HAP = false;
			attacking = false;
			attack1lefthappening = false;
			attack1righthappening = false;
			framesAttack1 = 0;

		}

		if (attack2 == true && dirP == left_dirP && !attack2righthappening && !attack2offcooldown && !attack3HAP
				&& !attack1HAP && !block && !STUNNED && !RONALDTRANSFORM && !MODERONALD && !DESTRANSFORM) {
			LEFTPUSH = true;
			attacking = true;
			attack2lefthappening = true;
			attack2HAP = true;

			if (!down) {

				parado = true;
			}

			if (indexAttack2Left >= 3 && indexAttack2Left <= 3) {

				hitboxAttack2Left = new Box(getX() - 60 - Camera.x, getY() + 10 - Camera.y, 60, 30, Color.cyan);
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

		if (attack2 == true && dirP == right_dirP && !attack2lefthappening && !attack2offcooldown && !attack3HAP
				&& !attack1HAP && !block && !STUNNED && !RONALDTRANSFORM && !MODERONALD && !DESTRANSFORM) {
			RIGHTPUSH = true;
			attacking = true;
			attack2righthappening = true;
			attack2HAP = true;

			if (!down) {

				parado = true;
			}

			if (indexAttack2Right >= 3 && indexAttack2Right <= 3) {

				hitboxAttack2Right = new Box(getX() + 50 - Camera.x, getY() + 5 - Camera.y, 60, 30, Color.cyan);
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

		if (attack2 && attack2offcooldown || attack2 && attack1HAP || attack2 && attack3HAP || attack2 && STUNNED
				|| attack2 && RONALDTRANSFORM || attack2 && MODERONALD || attack2 && DESTRANSFORM
				|| attack2 && GOTHIT) {

			attack2 = false;
			attack2HAP = false;
			attacking = false;
			attack2lefthappening = false;
			attack2righthappening = false;
			framesAttack2 = 0;

		}

		if (attack3 == true && dirP == left_dirP && !attack3righthappening && !attack3offcooldown && !attack2HAP
				&& !attack1HAP && down && !block && !STUNNED && !RONALDTRANSFORM && !MODERONALD && !DESTRANSFORM) {
			LEFTPUSH = true;
			attacking = true;
			down = true;
			attack3lefthappening = true;
			attack3HAP = true;

			if (indexAttack3Left >= 2) {

				hitboxAttack3Left = new Box(getX() - 97 - Camera.x, getY() + 46 - Camera.y, 90, 30, Color.cyan);
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

		if (attack3 == true && dirP == right_dirP && !attack3lefthappening && !attack3offcooldown && !attack2HAP
				&& !attack1HAP && down && !block && !STUNNED && !RONALDTRANSFORM && !MODERONALD && !DESTRANSFORM) {
			attacking = true;
			down = true;
			RIGHTPUSH = true;
			attack3righthappening = true;
			attack3HAP = true;

			if (indexAttack3Right >= 2) {

				hitboxAttack3Right = new Box(getX() + 55 - Camera.x, getY() + 45 - Camera.y, 90, 30, Color.cyan);

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
				|| attack3 && STUNNED || attack3 && RONALDTRANSFORM || attack3 && MODERONALD || attack3 && DESTRANSFORM
				|| attack3 && GOTHIT) {

			attack3 = false;
			attack3HAP = false;
			attacking = false;
			attack3lefthappening = false;
			attack3righthappening = false;
			framesAttack3 = 0;
			indexAttack3Right = 0;
			indexAttack3Left = 0;
		}

		if (skill1 == true && dirP == left_dirP && MODERONALD && !skill1offcooldown && !skill2HAP) {
			LEFTPUSH = true;
			attackingRONALD = true;
			skill1HAP = true;
			skill1lefthappening = true;
			Skill1LEFT = true;
			// attack3HAP = true;

			if (indexSkill1LeftULT >= 4) {

				// MUDEI ERA RIGHT

				hitboxRONALDSkill1Left = new Box(getX() - 45 - Camera.x, getY() + 10 - Camera.y, 50, 50, Color.cyan);
			}

			framesSkill1ULT++;
			if (framesSkill1ULT == maxFramesSkill1ULT) {

				framesSkill1ULT = 0;
				indexSkill1LeftULT++;
				isAttackingSkill1Hitting();

				if (indexSkill1LeftULT > maxIndexSkill1ULT) {

					LEFTPUSH = false;
					Skill1LEFT = false;
					indexSkill1LeftULT = 0;
					skill1HAP = false;
					attackingRONALD = false;
					skill1 = false;
					skill1offcooldown = true;
					// hitboxAttack3Left = new Box(0, 0, 0, 0, Color.cyan);

					// attack3offcooldown = true;

				}

			}

		}

		if (skill1 == true && dirP == right_dirP && MODERONALD && !skill1offcooldown && !skill2HAP) {
			RIGHTPUSH = true;
			attackingRONALD = true;
			skill1HAP = true;
			skill1righthappening = true;
			Skill1RIGHT = true;
			// attack3HAP = true;

			if (indexSkill1RightULT >= 4) {

				hitboxRONALDSkill1Right = new Box(getX() + 55 - Camera.x, getY() + 10 - Camera.y, 50, 50, Color.cyan);
			}

			framesSkill1ULT++;
			if (framesSkill1ULT == maxFramesSkill1ULT) {

				framesSkill1ULT = 0;
				indexSkill1RightULT++;
				isAttackingSkill1Hitting();

				if (indexSkill1RightULT > maxIndexSkill1ULT) {

					RIGHTPUSH = false;
					Skill1RIGHT = false;
					indexSkill1RightULT = 0;
					attackingRONALD = false;
					skill1HAP = false;
					skill1 = false;
					skill1offcooldown = true;

				}

			}

		}

		if (skill1 && skill1offcooldown || skill1 && skill2HAP || skill1 && RONALDTRANSFORM || skill1 && DESTRANSFORM || skill1 && RONALDBAR<=10) {

			skill1 = false;
			framesSkill1ULT = 0;

		}

		if (skill2 == true && dirP == right_dirP && MODERONALD && !skill1HAP && !skill2offcooldown) {
			RIGHTPUSH = true;
			attackingRONALD = true;
			skill2HAP = true;
			// skill2righthappening = true;
			Skill2RIGHT = true;
			// attack3HAP = true;

			if (indexSkill2RightULT >= 4) {

				hitboxRONALDSkill2Right = new Box(getX() + 45 - Camera.x, getY() + 50 - Camera.y, 50, 30, Color.cyan);
			}

			framesSkill2ULT++;
			if (framesSkill2ULT == maxFramesSkill2ULT) {

				framesSkill2ULT = 0;
				indexSkill2RightULT++;
				isAttackingSkill2Hitting();

				if (indexSkill2RightULT > maxIndexSkill2ULT) {
					RIGHTPUSH = false;
					indexSkill2RightULT = 0;
					Skill2RIGHT = false;
					skill2HAP = false;
					attackingRONALD = false;
					skill2 = false;
					skill2offcooldown = true;

				}

			}

		}

		if (skill2 == true && dirP == left_dirP && MODERONALD && !skill1HAP && !skill2offcooldown) {
			LEFTPUSH = true;
			attackingRONALD = true;
			skill2HAP = true;
			// skill2righthappening = true;
			Skill2LEFT = true;
			// attack3HAP = true;

			if (indexSkill2LeftULT >= 4) {

				hitboxRONALDSkill2Left = new Box(getX() - 36 - Camera.x, getY() + 50 - Camera.y, 50, 30, Color.cyan);
			}

			framesSkill2ULT++;
			if (framesSkill2ULT == maxFramesSkill2ULT) {

				framesSkill2ULT = 0;
				indexSkill2LeftULT++;
				isAttackingSkill2Hitting();

				if (indexSkill2LeftULT > maxIndexSkill2ULT) {
					indexSkill2LeftULT = 0;
					Skill2LEFT = false;

					LEFTPUSH = false;
					attackingRONALD = false;
					skill2HAP = false;
					skill2 = false;
					skill2offcooldown = true;

				}

			}

		}

		if (skill2 && skill2offcooldown || skill2 && skill1HAP || skill2 && RONALDTRANSFORM || skill2 && DESTRANSFORM || skill2 && RONALDBAR<=10) {

			skill2 = false;
			framesSkill2ULT = 0;

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

		if (Game.PhellipeP1.life <= 0) {
			/*
			 * Game.gameState = "MENU";
			 */
			Game.PhellipeP1.dead = true;

		}

		if (Game.PhellipeP2.life <= 0) {
			/*
			 * Game.gameState = "MENU";
			 */
			Game.PhellipeP2.dead = true;

		}

		if (falling) {

			y += gravity;

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

		if (Game.char1 == "PhellipeP1") {

			if (hitboxAttack1Right.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack1Left.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack1Right.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxAttack1Left.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxAttack1Right.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack1Left.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack1Right.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack1Left.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack1Right.intersects(Game.ThaianyP2.hitboxTH)
					|| hitboxAttack1Left.intersects(Game.ThaianyP2.hitboxTH)
					|| hitboxAttack1Right.intersects(Game.trainer.hitboxTR)
					|| hitboxAttack1Left.intersects(Game.trainer.hitboxTR)) {
				if (RONALDBAR < 100) {
					Game.PhellipeP1.RONALDBAR += 10;

				}

				if (Game.PhellipeP2.MODERONALD == false) {
					Game.PhellipeP2.RONALDBAR += 5;

				}

				for (Players playersbrabo : Game.players2) {

					if (playersbrabo.block == true) {

						playersbrabo.life -= 10 / playersbrabo.defesa;
					} else if (playersbrabo.block == false) {
						playersbrabo.life -= 10;

						if (Game.PhellipeP1.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHBAIXO = true;
							playersbrabo.stunnedbaixo = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.PhellipeP1.LEFTPUSH) {

							playersbrabo.LEFTPUSHBAIXO = true;
							playersbrabo.stunnedbaixo = true;
							playersbrabo.STUNNED = true;

						}
					}
				}
			}

		}

		if (Game.char2 == "PhellipeP2") {

			if (hitboxAttack1Right.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack1Left.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack1Right.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxAttack1Left.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxAttack1Right.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack1Left.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack1Right.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack1Left.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack1Right.intersects(Game.ThaianyP1.hitboxTH)
					|| hitboxAttack1Left.intersects(Game.ThaianyP1.hitboxTH)) {
				if (RONALDBAR < 100) {
					Game.PhellipeP2.RONALDBAR += 10;

				}

				if (Game.PhellipeP1.MODERONALD == false) {
					Game.PhellipeP1.RONALDBAR += 5;

				}

				for (Players playersbrabo : Game.players) {

					if (playersbrabo.block == true) {

						playersbrabo.life -= 10 / playersbrabo.defesa;
					} else if (playersbrabo.block == false) {
						playersbrabo.life -= 10;

						if (Game.PhellipeP2.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHBAIXO = true;
							playersbrabo.stunnedbaixo = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.PhellipeP2.LEFTPUSH) {

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

		// (Game.trainer.hitboxTR)

		if (Game.char1 == "PhellipeP1") {

			if (hitboxAttack2Right.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack2Left.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack2Right.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxAttack2Left.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxAttack2Right.intersects(Game.trainer.hitboxTR)
					|| hitboxAttack2Left.intersects(Game.trainer.hitboxTR)
					|| hitboxAttack2Right.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack2Left.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack2Right.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack2Left.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack2Right.intersects(Game.ThaianyP2.hitboxTH)
					|| hitboxAttack2Left.intersects(Game.ThaianyP2.hitboxTH)) {
				if (RONALDBAR < 100) {
					Game.PhellipeP1.RONALDBAR += 10;

				}

				if (Game.PhellipeP2.MODERONALD == false) {
					Game.PhellipeP2.RONALDBAR += 5;

				}

				for (Players playersbrabo : Game.players2) {

					if (playersbrabo.block == true) {

						playersbrabo.life -= 10 / playersbrabo.defesa;
					} else if (playersbrabo.block == false) {
						playersbrabo.life -= 10;

						if (Game.PhellipeP1.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHBAIXOREVERSO = true;
							playersbrabo.stunnedbaixoreverso = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.PhellipeP1.LEFTPUSH) {

							playersbrabo.LEFTPUSHBAIXOREVERSO = true;
							playersbrabo.stunnedbaixoreverso = true;
							playersbrabo.STUNNED = true;

						}
					}
				}

			}
		}

		if (Game.char2 == "PhellipeP2") {

			if (hitboxAttack2Right.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack2Left.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack2Right.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxAttack2Left.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxAttack2Right.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack2Left.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack2Right.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack2Left.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack2Right.intersects(Game.ThaianyP1.hitboxTH)
					|| hitboxAttack2Left.intersects(Game.ThaianyP1.hitboxTH)) {
				if (RONALDBAR < 100) {

					Game.PhellipeP2.RONALDBAR += 10;

				}

				if (Game.PhellipeP1.MODERONALD == false) {
					Game.PhellipeP1.RONALDBAR += 5;

				}

				for (Players playersbrabo : Game.players) {

					if (playersbrabo.block == true) {

						playersbrabo.life -= 10 / playersbrabo.defesa;
					} else if (playersbrabo.block == false) {
						playersbrabo.life -= 10;

						if (Game.PhellipeP2.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHBAIXOREVERSO = true;
							playersbrabo.stunnedbaixoreverso = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.PhellipeP2.LEFTPUSH) {

							playersbrabo.LEFTPUSHBAIXOREVERSO = true;
							playersbrabo.stunnedbaixoreverso = true;
							playersbrabo.STUNNED = true;

						}
					}
				}
			}

		}

	}

	public void isAttacking3Hitting() {

		// (Game.trainer.hitboxTR)

		if (Game.char1 == "PhellipeP1") {

			if (hitboxAttack3Right.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack3Left.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxAttack3Right.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxAttack3Left.intersects(Game.PhellipeP2.hitboxPH)
					|| hitboxAttack3Right.intersects(Game.trainer.hitboxTR)
					|| hitboxAttack3Left.intersects(Game.trainer.hitboxTR)
					|| hitboxAttack3Right.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack3Left.intersects(Game.MaxuelP2.hitboxMX)
					|| hitboxAttack3Right.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack3Left.intersects(Game.IvanildoP2.hitboxIV)
					|| hitboxAttack3Right.intersects(Game.ThaianyP2.hitboxTH)
					|| hitboxAttack3Left.intersects(Game.ThaianyP2.hitboxTH)) {

				if (RONALDBAR < 100) {
					Game.PhellipeP1.RONALDBAR += 2;

				}

				if (Game.PhellipeP2.MODERONALD == false) {
					Game.PhellipeP2.RONALDBAR += 5;

				}

				for (Players playersbrabo : Game.players2) {

					if (playersbrabo.block == true) {

						playersbrabo.life -= 2 / playersbrabo.defesa;
					} else if (playersbrabo.block == false) {
						playersbrabo.life -= 2;

						if (Game.PhellipeP1.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHZEROGRAVITY = true;
							playersbrabo.stunned0gravity = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.PhellipeP1.LEFTPUSH) {

							playersbrabo.LEFTPUSHZEROGRAVITY = true;
							playersbrabo.stunned0gravity = true;
							playersbrabo.STUNNED = true;

						}

					}
				}

			}

		}

		if (Game.char2 == "PhellipeP2") {

			if (hitboxAttack3Right.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack3Left.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxAttack3Right.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxAttack3Left.intersects(Game.PhellipeP1.hitboxPH)
					|| hitboxAttack3Right.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack3Left.intersects(Game.MaxuelP1.hitboxMX)
					|| hitboxAttack3Right.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack3Left.intersects(Game.IvanildoP1.hitboxIV)
					|| hitboxAttack3Right.intersects(Game.ThaianyP1.hitboxTH)
					|| hitboxAttack3Left.intersects(Game.ThaianyP1.hitboxTH)) {

				if (RONALDBAR < 100) {
					Game.PhellipeP2.RONALDBAR += 2;

				}
				if (Game.PhellipeP1.MODERONALD == false) {
					Game.PhellipeP1.RONALDBAR += 5;

				}

				for (Players playersbrabo : Game.players) {

					if (playersbrabo.block == true) {

						playersbrabo.life -= 2 / playersbrabo.defesa;
					} else if (playersbrabo.block == false) {
						playersbrabo.life -= 2;

						if (Game.PhellipeP2.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHZEROGRAVITY = true;
							playersbrabo.stunned0gravity = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.PhellipeP2.LEFTPUSH) {

							playersbrabo.LEFTPUSHZEROGRAVITY = true;
							playersbrabo.stunned0gravity = true;
							playersbrabo.STUNNED = true;

						}
					}
				}
			}

		}

	}

	public void isAttackingSkill1Hitting() {

		// (Game.trainer.hitboxTR)

		if (Game.char1 == "PhellipeP1") {

			if (hitboxRONALDSkill1Right.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxRONALDSkill1Left.intersects(Game.MoisesP2.hitboxMOI)
					|| Game.PhellipeP1.hitboxRONALDSkill1Right.intersects(Game.PhellipeP2.hitboxPH)
					|| Game.PhellipeP1.hitboxRONALDSkill1Left.intersects(Game.PhellipeP2.hitboxPH)
					|| Game.PhellipeP1.hitboxRONALDSkill1Right.intersects(Game.MaxuelP2.hitboxMX)
					|| Game.PhellipeP1.hitboxRONALDSkill1Left.intersects(Game.MaxuelP2.hitboxMX)
					|| Game.PhellipeP1.hitboxRONALDSkill1Right.intersects(Game.IvanildoP2.hitboxIV)
					|| Game.PhellipeP1.hitboxRONALDSkill1Left.intersects(Game.IvanildoP2.hitboxIV)
					|| Game.PhellipeP1.hitboxRONALDSkill1Right.intersects(Game.ThaianyP2.hitboxTH)
					|| Game.PhellipeP1.hitboxRONALDSkill1Left.intersects(Game.ThaianyP2.hitboxTH)
					|| Game.PhellipeP1.hitboxRONALDSkill1Right.intersects(Game.trainer.hitboxTR)
					|| Game.PhellipeP1.hitboxRONALDSkill1Left.intersects(Game.trainer.hitboxTR)) {

				if (RONALDBAR < 100) {
					Game.PhellipeP1.RONALDBAR += 2;

				}

				if (Game.PhellipeP2.MODERONALD == false) {
					Game.PhellipeP2.RONALDBAR += 5;

				}

				for (Players playersbrabo : Game.players2) {

					if (playersbrabo.block == true) {

						playersbrabo.life -= 10 / playersbrabo.defesa;
					} else if (playersbrabo.block == false) {
						playersbrabo.life -= 10;

						if (Game.PhellipeP1.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHMEDIO = true;
							playersbrabo.stunnedmedio = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.PhellipeP1.LEFTPUSH) {

							playersbrabo.LEFTPUSHMEDIO = true;
							playersbrabo.stunnedmedio = true;
							playersbrabo.STUNNED = true;

						}
					}

				}

			}
		}

		if (Game.char2 == "PhellipeP2") {

			if (hitboxRONALDSkill1Right.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxRONALDSkill1Left.intersects(Game.MoisesP1.hitboxMOI)
					|| Game.PhellipeP2.hitboxRONALDSkill1Right.intersects(Game.PhellipeP1.hitboxPH)
					|| Game.PhellipeP2.hitboxRONALDSkill1Left.intersects(Game.PhellipeP1.hitboxPH)
					|| Game.PhellipeP2.hitboxRONALDSkill1Right.intersects(Game.MaxuelP1.hitboxMX)
					|| Game.PhellipeP2.hitboxRONALDSkill1Left.intersects(Game.MaxuelP1.hitboxMX)
					|| Game.PhellipeP2.hitboxRONALDSkill1Right.intersects(Game.IvanildoP1.hitboxIV)
					|| Game.PhellipeP2.hitboxRONALDSkill1Left.intersects(Game.IvanildoP1.hitboxIV)
					|| Game.PhellipeP2.hitboxRONALDSkill1Right.intersects(Game.ThaianyP1.hitboxTH)
					|| Game.PhellipeP2.hitboxRONALDSkill1Left.intersects(Game.ThaianyP1.hitboxTH)) {

				if (RONALDBAR < 100) {
					Game.PhellipeP2.RONALDBAR += 2;

				}

				if (Game.PhellipeP1.MODERONALD == false) {
					Game.PhellipeP1.RONALDBAR += 5;

				}

				for (Players playersbrabo : Game.players) {

					if (playersbrabo.block == true) {

						playersbrabo.life -= 10 / playersbrabo.defesa;
					} else if (playersbrabo.block == false) {
						playersbrabo.life -= 10;

						if (Game.PhellipeP2.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHMEDIO = true;
							playersbrabo.stunnedmedio = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.PhellipeP2.LEFTPUSH) {

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

		// (Game.trainer.hitboxTR)

		if (Game.char1 == "PhellipeP1") {

			if (hitboxRONALDSkill2Right.intersects(Game.MoisesP2.hitboxMOI)
					|| hitboxRONALDSkill2Left.intersects(Game.MoisesP2.hitboxMOI)
					|| Game.PhellipeP1.hitboxRONALDSkill2Right.intersects(Game.PhellipeP2.hitboxPH)
					|| Game.PhellipeP1.hitboxRONALDSkill2Left.intersects(Game.PhellipeP2.hitboxPH)
					|| Game.PhellipeP1.hitboxRONALDSkill2Right.intersects(Game.trainer.hitboxTR)
					|| Game.PhellipeP1.hitboxRONALDSkill2Left.intersects(Game.trainer.hitboxTR)
					|| Game.PhellipeP1.hitboxRONALDSkill2Right.intersects(Game.MaxuelP1.hitboxMX)
					|| Game.PhellipeP1.hitboxRONALDSkill2Left.intersects(Game.MaxuelP1.hitboxMX)
					|| Game.PhellipeP1.hitboxRONALDSkill2Right.intersects(Game.IvanildoP1.hitboxIV)
					|| Game.PhellipeP1.hitboxRONALDSkill2Left.intersects(Game.IvanildoP1.hitboxIV)
					|| Game.PhellipeP1.hitboxRONALDSkill2Right.intersects(Game.ThaianyP1.hitboxTH)
					|| Game.PhellipeP1.hitboxRONALDSkill2Left.intersects(Game.ThaianyP1.hitboxTH)) {

				if (RONALDBAR < 100) {
					Game.PhellipeP1.RONALDBAR += 2;

				}

				if (Game.PhellipeP2.MODERONALD == false) {
					Game.PhellipeP2.RONALDBAR += 5;

				}

				if (Game.PhellipeP1.MODERONALD == false) {
					Game.PhellipeP1.RONALDBAR += 5;

				}

				for (Players playersbrabo : Game.players2) {

					if (playersbrabo.block == true) {

						playersbrabo.life -= 20 / playersbrabo.defesa;
					} else if (playersbrabo.block == false) {
						playersbrabo.life -= 20;

						if (Game.PhellipeP1.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHALTO = true;
							playersbrabo.stunnedalto = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.PhellipeP1.LEFTPUSH) {

							playersbrabo.LEFTPUSHALTO = true;
							playersbrabo.stunnedalto = true;
							playersbrabo.STUNNED = true;

						}
					}

				}

			}
		}

		if (Game.char2 == "PhellipeP2") {

			if (hitboxRONALDSkill2Right.intersects(Game.MoisesP1.hitboxMOI)
					|| hitboxRONALDSkill2Left.intersects(Game.MoisesP1.hitboxMOI)
					|| Game.PhellipeP2.hitboxRONALDSkill2Right.intersects(Game.PhellipeP1.hitboxPH)
					|| Game.PhellipeP2.hitboxRONALDSkill2Left.intersects(Game.PhellipeP1.hitboxPH)
					|| Game.PhellipeP2.hitboxRONALDSkill2Right.intersects(Game.MaxuelP1.hitboxMX)
					|| Game.PhellipeP2.hitboxRONALDSkill2Left.intersects(Game.MaxuelP1.hitboxMX)
					|| Game.PhellipeP2.hitboxRONALDSkill2Right.intersects(Game.IvanildoP1.hitboxIV)
					|| Game.PhellipeP2.hitboxRONALDSkill2Left.intersects(Game.IvanildoP1.hitboxIV)
					|| Game.PhellipeP2.hitboxRONALDSkill2Right.intersects(Game.ThaianyP1.hitboxTH)
					|| Game.PhellipeP2.hitboxRONALDSkill2Left.intersects(Game.ThaianyP1.hitboxTH)) {

				if (RONALDBAR < 100) {
					Game.PhellipeP2.RONALDBAR += 2;

				}

				for (Players playersbrabo : Game.players) {

					if (playersbrabo.block == true) {

						playersbrabo.life -= 20 / playersbrabo.defesa;
					} else if (playersbrabo.block == false) {
						playersbrabo.life -= 20;

						if (Game.PhellipeP2.RIGHTPUSH) {

							playersbrabo.RIGHTPUSHALTO = true;
							playersbrabo.stunnedalto = true;
							playersbrabo.STUNNED = true;
						}

						if (Game.PhellipeP2.LEFTPUSH) {

							playersbrabo.LEFTPUSHALTO = true;
							playersbrabo.stunnedalto = true;
							playersbrabo.STUNNED = true;

						}
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

		if (hitboxPH.intersects(Game.chao01) || (this.hitboxRONALDTRANSFORM.intersects(Game.chao01))) {

			Tanochao = true;

			return true;
		} else

			Tanochao = false;

		return false;

	}

	public boolean isWallLeft() {

		if (hitboxPH.intersects(Game.parede01)) {

			return true;
		} else

			return false;

	}

	public boolean isWallRight() {

		if (hitboxPH.intersects(Game.parede02)) {

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

		if (dirP == left_dirP && jumping && !isDamaged) {
			g.drawImage(leftPlayerJump[indexJump], this.getX() - Camera.x, this.getY() - Camera.y, null);

		}

		if (dirP == right_dirP && jumping && !isDamaged) {
			g.drawImage(rightPlayerJump[indexJump], this.getX() - Camera.x, this.getY() - Camera.y, null);

		}

		if (!isDamaged && !MODERONALD && !RONALDTRANSFORM && !DESTRANSFORM && !jumping) {

			if (parado && dirP == left_dirP) {

				g.drawImage(leftPlayerParado[indexParado], this.getX() - Camera.x, this.getY() - Camera.y, null);

			}

			if (parado && dirP == right_dirP) {

				g.drawImage(rightPlayerParado[indexParado], this.getX() - Camera.x, this.getY() - Camera.y, null);

			}

			if (dirP == left_dirP && !parado && moved) {
				g.drawImage(leftPlayer[indexAndar], this.getX() - Camera.x, this.getY() - Camera.y, null);

			}

			if (dirP == right_dirP && !parado && moved) {
				g.drawImage(rightPlayer[indexAndar], this.getX() - Camera.x, this.getY() - Camera.y, null);

			}

			if (dirP == right_dirP && down && isGround()) {

				g.drawImage(playerAgachadoRight, this.getX() - Camera.x, this.getY() - Camera.y, null);

			}

			if (dirP == left_dirP && down && isGround()) {

				g.drawImage(playerAgachadoLeft, this.getX() - Camera.x, this.getY() - Camera.y, null);

			}

		}

		if (attack1 && !attack1offcooldown && !attack3HAP && !attack2HAP && !block && !STUNNED && !MODERONALD) {

			if (dirP == left_dirP && !attack1righthappening) {
				g.drawImage(leftPlayerAttack1[indexAttack1Left], this.getX() - 90 - Camera.x, this.getY() - Camera.y,
						null);

			}

			if (dirP == right_dirP && !attack1lefthappening) {
				g.drawImage(rightPlayerAttack1[indexAttack1Right], this.getX() + 50 - Camera.x, this.getY() - Camera.y,
						null);

			}
		}

		if (attack2 && !attack2offcooldown && !attack3HAP && !attack1HAP && !block && !STUNNED && !MODERONALD) {

			if (dirP == left_dirP && !attack2righthappening) {
				g.drawImage(leftPlayerAttack2[indexAttack2Left], this.getX() - 75 - Camera.x, this.getY() - Camera.y,
						null);

			}

			if (dirP == right_dirP && !attack2lefthappening) {
				g.drawImage(rightPlayerAttack2[indexAttack2Right], this.getX() + 50 - Camera.x, this.getY() - Camera.y,
						null);

			}
		}

		if (attack3 && !attack3offcooldown && !attack1HAP && !attack2HAP && down && !block && !STUNNED && !MODERONALD) {

			if (dirP == left_dirP && !attack3righthappening) {
				g.drawImage(leftPlayerAttack3[indexAttack3Left], this.getX() - 100 - Camera.x,
						this.getY() + 50 - Camera.y, null);

			}

			if (dirP == right_dirP && !attack3lefthappening) {
				g.drawImage(rightPlayerAttack3[indexAttack3Right], this.getX() + 50 - Camera.x,
						this.getY() + 50 - Camera.y, null);

			}

		}

		if (isDamaged && dirP == right_dirP && !MODERONALD) {

			g.drawImage(playerDamageRight, this.getX() - Camera.x, this.getY() - Camera.y, null);
		}
		if (isDamaged && dirP == left_dirP && !MODERONALD) {

			g.drawImage(playerDamageLeft, this.getX() - Camera.x, this.getY() - Camera.y, null);
		}

		if (block && dirP == right_dirP) {

			g.drawImage(Blockright, this.getX() + 25 - Camera.x, this.getY() - Camera.y, null);

		}

		if (block && dirP == left_dirP) {

			g.drawImage(Blockleft, this.getX() - 20 - Camera.x, this.getY() - Camera.y, null);

		}

		if (RONALDTRANSFORM && !MODERONALD) {

			if (dirP == left_dirP) {

				g.drawImage(RonaldTransformleft[indexRONALD], this.getX() - 25 - Camera.x, this.getY() - 17 - Camera.y,
						null);

			}

			if (dirP == right_dirP) {

				g.drawImage(RonaldTransformright[indexRONALD], this.getX() - 20 - Camera.x, this.getY() - 2 - Camera.y,
						null);

			}
		}

		if (DESTRANSFORM) {

			if (dirP == left_dirP) {

				g.drawImage(RonaldDesTransformleft[indexDESTRANS], this.getX() - 25 - Camera.x,
						this.getY() - 17 - Camera.y, null);

			}

			if (dirP == right_dirP) {

				g.drawImage(RonaldDesTransformright[indexDESTRANS], this.getX() - 25 - Camera.x,
						this.getY() - 2 - Camera.y, null);

			}

		}
		if (MODERONALD && !RONALDTRANSFORM) {

			if (!attackingRONALD) {
				if (parado && dirP == left_dirP) {

					g.drawImage(RonaldParadoleft[indexParado], this.getX() - 10 - Camera.x, this.getY() + 6 - Camera.y,
							null);

				}

				if (parado && dirP == right_dirP) {

					g.drawImage(RonaldParadoright[indexParado], this.getX() - 10 - Camera.x, this.getY() + 6 - Camera.y,
							null);

				}

				if (dirP == left_dirP && !parado && moved) {
					g.drawImage(RonaldAndandoleft[indexAndarULT], this.getX() - 10 - Camera.x,
							this.getY() + 7 - Camera.y, null);

				}

				if (dirP == right_dirP && !parado && moved) {
					g.drawImage(RonaldAndandoright[indexAndarULT], this.getX() - 10 - Camera.x,
							this.getY() + 8 - Camera.y, null);

				}

			}

			if (skill1 && !block && !STUNNED && !skill2HAP && !skill1offcooldown) {

				if (dirP == left_dirP) {
					g.drawImage(RonaldSpecialskill1left[indexSkill1LeftULT], this.getX() - 38 - Camera.x,
							this.getY() + 8 - Camera.y, null);

				}

				if (dirP == right_dirP) {
					g.drawImage(RonaldSpecialskill1right[indexSkill1RightULT], this.getX() - 10 - Camera.x,
							this.getY() + 8 - Camera.y, null);

				}
			}

			if (skill2 && !block && !STUNNED && !skill1HAP && !skill2offcooldown) {

				if (dirP == left_dirP) {
					g.drawImage(RonaldSpecialskill2left[indexSkill2LeftULT], this.getX() - 29 - Camera.x,
							this.getY() - 21 - Camera.y, null);

				}

				if (dirP == right_dirP) {
					g.drawImage(RonaldSpecialskill2right[indexSkill2RightULT], this.getX() - 12 - Camera.x,
							this.getY() - 17 - Camera.y - 1, null);

				}
			}

		}

		// HITBOX
		if (Game.char2 == "PhellipeP2") {
			Game.PhellipeP1.hitboxPH.DrawRect(g);
			Game.PhellipeP2.hitboxPH.DrawRect(g);
			Game.PhellipeP2.hitboxAttack1Left.DrawRect(g);
			Game.PhellipeP2.hitboxAttack1Right.DrawRect(g);
			Game.PhellipeP2.hitboxAttack2Right.DrawRect(g);
			Game.PhellipeP2.hitboxAttack2Left.DrawRect(g);
			Game.PhellipeP2.hitboxAttack3Right.DrawRect(g);
			Game.PhellipeP2.hitboxAttack3Left.DrawRect(g);
			Game.PhellipeP2.hitboxRONALDSkill1Left.DrawRect(g);
			Game.PhellipeP2.hitboxRONALDSkill1Right.DrawRect(g);
			Game.PhellipeP2.hitboxRONALDSkill2Left.DrawRect(g);
			Game.PhellipeP2.hitboxRONALDSkill2Right.DrawRect(g);

		}

		if (Game.char1 == "PhellipeP1") {

			Game.PhellipeP1.hitboxPH.DrawRect(g);
			Game.PhellipeP1.hitboxAttack1Left.DrawRect(g);
			Game.PhellipeP1.hitboxAttack1Right.DrawRect(g);
			Game.PhellipeP1.hitboxAttack2Right.DrawRect(g);
			Game.PhellipeP1.hitboxAttack2Left.DrawRect(g);
			Game.PhellipeP1.hitboxAttack3Right.DrawRect(g);
			Game.PhellipeP1.hitboxAttack3Left.DrawRect(g);
			Game.PhellipeP1.hitboxRONALDSkill1Left.DrawRect(g);
			Game.PhellipeP1.hitboxRONALDSkill1Right.DrawRect(g);
			Game.PhellipeP1.hitboxRONALDSkill2Left.DrawRect(g);
			Game.PhellipeP1.hitboxRONALDSkill2Right.DrawRect(g);

		}

	}

}
