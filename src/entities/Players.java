package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import collisions.Box;
import main.Game;
import world.Camera;

public class Players extends Entity {


	protected boolean attack2righthappening;
	protected boolean attack2lefthappening;

	protected boolean attack3righthappening;
	protected boolean attack3lefthappening;
	
	public boolean SETA = false;
	
	public boolean dead = false;
	
	public boolean START = true;
	public boolean stunnedbaixo = false;
	public boolean stunnedbaixoreverso = false;
	public boolean stunnedmedio = false;
	public boolean stunnedalto = false;
	public boolean stunnedexplosion = false;
	public boolean stunned0gravity = false;
	public boolean stunnedHAKAI = false;

	public boolean STUNNED = false;

	protected boolean LEFTPUSHBAIXO;
	protected boolean RIGHTPUSHBAIXO;

	protected boolean LEFTPUSHENDBAIXO;
	protected boolean RIGHTPUSHENDBAIXO;

	protected boolean LEFTPUSHBAIXOREVERSO;
	protected boolean LEFTPUSHENDBAIXOREVERSO;

	protected boolean RIGHTPUSHBAIXOREVERSO;
	protected boolean RIGHTPUSHENDBAIXOREVERSO;

	protected boolean LEFTPUSHZEROGRAVITY;
	protected boolean LEFTPUSHENDZEROGRAVITY;

	protected boolean RIGHTPUSHZEROGRAVITY;
	protected boolean RIGHTPUSHENDZEROGRAVITY;

	
	//BOTEI STATIC VAI DAR PROBLEMA?
	
	public boolean LEFTPUSHMEDIO;
	protected boolean LEFTPUSHENDMEDIO;

	public boolean RIGHTPUSHMEDIO;
	protected boolean RIGHTPUSHENDMEDIO;

	protected boolean LEFTPUSHENDALTO;
	protected boolean LEFTPUSHALTO;

	protected boolean RIGHTPUSHENDALTO;
	protected boolean RIGHTPUSHALTO;

	public boolean RIGHTPUSHENDEXPLOSION;
	public boolean RIGHTPUSHEXPLOSION;

	public boolean LEFTPUSHENDEXPLOSION;
	public boolean LEFTPUSHEXPLOSION;

	public double rightspeed = 1.4;
	public double leftspeed = 1.4;

	public int mx, my;

	public boolean jumping = true, falling;
	public double gravity = 2;

	

	// COOLDOWNS

	protected long lastAttack;
	protected long cooldownTime;
	protected boolean attack1offcooldown;

	protected long lastJump;
	protected long cooldownTimeJump;
	protected boolean jumpoffcooldown;

	protected long lastAttack2;
	protected int cooldownTime2;
	protected boolean attack2offcooldown;

	protected long lastAttack3;
	protected int cooldownTime3;
	protected boolean attack3offcooldown;

	protected long lastSkill1;
	protected boolean skill1offcooldown;
	protected int cooldownTime4;

	protected long lastSkill2;
	protected boolean skill2offcooldown;
	protected int cooldownTime5;
	
	

	protected long lastSeta;
	protected boolean setaoffcooldown;
	protected int cooldownTime6;
	

	// ANDAR
	protected int framesAndar;
	protected int maxFramesAndar;
	protected int indexAndar;
	protected int maxIndexAndar;
	// PULO
	protected int maxFramesJump;
	protected int framesJump;
	protected int indexJump;
	protected int maxIndexJump;

	// PARADO
	protected int framesParado;
	protected int maxFramesParado;
	protected int indexParado;
	protected int maxIndexParado;

	// ATTACK 1
	protected int framesAttack1;
	protected int maxFramesAttack1;
	protected int indexAttack1Right;
	protected int indexAttack1Left;
	protected int maxIndexAttack1;

	// ATTACK 2

	protected int indexAttack2Left;
	protected int framesAttack2;
	protected int maxIndexAttack2;
	protected int indexAttack2Right;

	// ATTACK 3

	protected int framesAttack3;
	protected int maxFramesAttack3;
	protected int indexAttack3Right;
	protected int indexAttack3Left;
	protected int maxIndexAttack3;

	//SKILL 1
	protected int framesSkill1;
	protected int maxFramesSkill1;
	protected int maxIndexSkill1;
	protected int indexSkill1Right;
	protected int indexSkill1Left;
	
	
	//SKILL 2
	protected int indexSkill2Right;
	protected int indexSkill2Left;
	protected int maxIndexSkill2;
	protected int framesSkill2;
	protected int maxFramesSkill2;

	
	
	
	// ATTACK1 COOLDOWN
	protected int attack1cdframes;
	protected int attack1cdmaxframes;

	// ATTACK3 COOLDOWN
	protected boolean attack3cd;
	protected int attack3cdframes;
	protected int maxframesattack3cd;

	// START

	protected int Startframes = 0;

	protected int maxFramesStart = 200;

	// TESTE
	public boolean TestBooleanFalsa = false;

	public boolean TestBooleanVerd = true;

	protected int TesteFrames;

	protected int framesattack1teste;

	protected boolean moved = false;

	protected BufferedImage[] rightPlayer;
	protected BufferedImage[] leftPlayer;
	protected BufferedImage[] rightPlayerJump;
	protected BufferedImage[] leftPlayerJump;
	protected BufferedImage[] leftPlayerParado;
	protected BufferedImage[] rightPlayerParado;
	protected BufferedImage[] rightPlayerAttack1;
	protected BufferedImage[] leftPlayerAttack1;
	protected BufferedImage[] rightPlayerAttack2;
	protected BufferedImage[] leftPlayerAttack2;
	protected BufferedImage[] rightPlayerAttack3;
	protected BufferedImage[] leftPlayerAttack3;
	protected BufferedImage[] rightPlayerSkill1;
	protected BufferedImage[] leftPlayerSkill1;
	protected BufferedImage[] rightPlayerSkill2;
	protected BufferedImage[] leftPlayerSkill2;
	
	
	

	public boolean LEFTPUSH;
	public boolean RIGHTPUSH;

	protected boolean SETARPO = false;

	public boolean right, up, left = false, down, block = false, attack1 = false, attack2 = false, attack3 = false,
			skill1 = false, skill2 = false, skillult = false;

	public double defesa = 2;

	public boolean parado = true;

	public boolean attack1move = false;
	public boolean attacking = false;
	public boolean attack1used = false;

	protected BufferedImage playerDamage;

	protected boolean JumpUsed = false;

	public boolean isDamaged = false;
	protected int damageFrames = 0;

	protected boolean Playedonce;

	protected BufferedImage Blockright;
	protected BufferedImage Blockleft;
	protected BufferedImage playerDamageRight;
	protected BufferedImage playerDamageLeft;
	protected BufferedImage playerAgachadoRight;
	protected BufferedImage playerAgachadoLeft;
	protected BufferedImage playerAttack2Right;
	protected BufferedImage playerAttack2Left;
	protected BufferedImage rightPlayerULT;
	protected BufferedImage leftPlayerULT;

	// STUN BAIXO
	public boolean Stunbaixo;
	protected int Stunbaixoframes;
	protected int maxFramesStunbaixo;

	// STUN MEDIO
	public boolean Stunmedio;
	protected int Stunmedioframes;
	protected int maxFramesStunmedio;

	// STUN ALTO
	public boolean Stunalto;
	protected int Stunaltoframes;
	protected int maxFramesStunalto;

	// STUN EXPLOSION
	protected boolean StunExplosion;
	protected int StunExplosionframes;
	protected int maxFramesStunExplosion;

	// STUN REVERSO

	protected boolean Stunbaixorever;
	protected int Stunbaixoreverframes;
	protected int maxFramesStunbaixorever;

	// STUN 0GRAVITY

	protected boolean Stun0gravity;
	protected int Stun0gravityframes;
	protected int maxFramesStun0gravity;

	// STUN HAKAI

	protected boolean StunHAKAI;
	protected int StunHAKAIframes;
	protected int maxFramesStunHAKAI;

	protected boolean Tanochao;

	protected int Attack2frames;
	protected int maxFramesAttack2;
	protected boolean attack1HAP = false;
	public boolean attack2HAP = false;
	public boolean attack3HAP = false;

	public boolean downHAP = false;
	protected boolean Cantattack = false;

	public double life = 200, maxlife = 200;
	public double energy = 0, maxenergy = 100;
	public double ult = 0, maxult = 100;

	protected boolean attack1lefthappening = false;
	protected boolean attack1righthappening = false;

	public Players(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);

	}

	public void tick() {

		start();

	}

	public void start() {

		if (START == true) {

			up = false;
			down = false;
			right = false;
			left = false;
			attack1 = false;
			attack2 = false;
			attack3 = false;
			skill1 = false;
			skill2 = false;
			skillult = false;

			Startframes++;
			while (Startframes == maxFramesStart) {

				Startframes = 0;
				START = false;
			}

		}

	}

	// SEM CAMERA
	/*
	 * if (dir == right_dir) { g.drawImage(rightPlayer[index], this.getX(),
	 * this.getY(), null); }else if(dir == left_dir) {
	 * g.drawImage(leftPlayer[index], this.getX(), this.getY(), null); }
	 * 
	 */

}
