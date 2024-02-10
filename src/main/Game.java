package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

import collisions.Box;
import entities.Entity;
import entities.Ivanildo;
import entities.Maxuel;
import entities.Moises;
import entities.Phellipe;
import entities.Players;
import entities.SacoDeBrunnada;
import entities.Thaiany;
import graficos.Caras;
import graficos.MapaIcon;
import graficos.Spritesheet;
import graficos.UI;
import items.Bullets;
import items.dados;
import items.html;
import items.mirault;
import items.mouse;
import items.nuvem;
import items.pc;
import items.robo;
import items.roteador;
import items.roteadorUP;
import items.thayulthorizontal;
import items.thayultvertical;
import mapas.MAPA_01;
import mapas.MAPA_01SHOW;
import mapas.MAPA_TREINO;
import menus.Menus;
import menus.SELECAO;
import menus.TREINOSELECAO;

public class Game extends Canvas implements Runnable, KeyListener {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	public static JFrame frame;
	private Thread thread;
	private boolean isRunning = true;

	/** TAMANHO DA TELA E ESCALA DELA(PARA FICAR BEM PIXELADO) **/

	public static final int WIDTH = 300;
	public static final int HEIGHT = 200;
	public static final int SCALE = 3;

	/** --- **/

	private BufferedImage image;

	public static List<Entity> entities;

	public static List<Players> players;
	public static List<Players> players2;

	public static List<mouse> mouses;
	public static List<pc> pcs;
	public static List<roteador> rots;
	public static List<roteadorUP> rotsup;

	public static List<pc> pcs2;
	public static List<roteador> rots2;
	public static List<roteadorUP> rotsup2;
	public static List<mouse> mouses2;

	public static List<Bullets> bullets;

	public static List<mirault> miras;

	public static List<robo> robos;

	public static List<html> blocohtml;

	public static List<dados> dadosvarios;

	public static List<nuvem> nuvens;

	public static List<thayulthorizontal> ulthoriz;

	public static List<thayultvertical> ultverti;

	public static double delta = 0;// DELTA IMPORTANTE NO RUN

	// CONTADOR

	public static int countdown = 4; // Valor inicial do contador
	public static boolean showFightMessage = true; // Variável para controlar se a mensagem "LUTEM!" deve ser exibida

	public static Moises MOI;

	public static Spritesheet moisesultparado;

	public static Spritesheet blockleft;

	public static Spritesheet blockright;

	public static Spritesheet mouseright;

	public static Spritesheet mouseleft;

	public static Spritesheet pcright;

	public static Spritesheet pcleft;

	public static Spritesheet RONALDskill2;

	public static Spritesheet RONALDtransform;

	public static Spritesheet RONALDmode;

	public static Spritesheet spritesheet;

	public static Spritesheet spritesheet2;

	public static Spritesheet spritesheet3;

	public static Spritesheet spritesheetboneco;

	public static Spritesheet maxuelandando;

	public static Spritesheet maxuelpulando;

	public static Spritesheet maxuelsetas;

	public static Spritesheet ataque1ph;

	public static Spritesheet ataque1phinv;

	public static Spritesheet fundoselecao;

	public static Spritesheet fundoselecaomapa;

	public static Spritesheet selecaopersonagem;

	public static Spritesheet selecaoamarelo;

	public static Spritesheet selecaovermelho;

	public static Spritesheet MAPAPRIMEIRO;

	public static Spritesheet jogarbotao;

	public static Spritesheet sairbotao;

	public static Spritesheet creditobotao;

	public static Spritesheet opcaobotao;

	public static Spritesheet treinobotao;

	public static Spritesheet creditos1;

	public static Spritesheet creditos2;

	public static Spritesheet continuarfundo;

	public static Spritesheet controles1;

	public static Spritesheet controles2;

	public static Spritesheet continuarbutao;

	public static Spritesheet controlebutao;

	public static Spritesheet menubutao;

	public static Spritesheet voltarbutao;

	public static Spritesheet maxuelresto;

	public static Spritesheet mira;

	public static Spritesheet ivanildo;

	public static Spritesheet ivanildoult;

	public static Spritesheet ivanildoultinverso;

	public static Spritesheet ivanildoskill1;

	public static Spritesheet ivanildoskill2;

	public static Spritesheet thaiany;

	public static Spritesheet thaianypuloinverso;

	public static Spritesheet thaianyattack3inverso;

	public static Spritesheet dadosprite;

	public static Spritesheet nuvemsprite;

	public static Spritesheet ulthorizontal;

	public static Spritesheet ultvertical;

	public static Caras PhellipeP1SELEC;

	public static Caras PhellipeP2SELEC;

	public static Caras MoisesP1SELEC;

	public static Caras MoisesP2SELEC;

	public static MAPA_01 mapa01;

	public static MAPA_01 mapatreino;

	public static Players player;

	public static SacoDeBrunnada trainer;

	public static Moises MoisesP1;

	public static Moises MoisesP2;

	public static Phellipe PhellipeP1;

	public static Phellipe PhellipeP2;

	public static Maxuel MaxuelP1;

	public static Maxuel MaxuelP2;

	public static Ivanildo IvanildoP1;

	public static Ivanildo IvanildoP2;

	public static Thaiany ThaianyP1;

	public static Thaiany ThaianyP2;

	public static roteador roteadorp1;

	public static roteadorUP roteadorUP;

	public static Box chao01;

	public static Box parede01;

	public static Box parede02;

	public static Random rand;

	public static mirault mirabrabis;

	/*
	 * 
	 * PLAYER 1 : PhellipeP1 MoisesP1
	 * 
	 * 
	 * E PLAYER 2; PhellipeP2 MoisesP2
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	// MODO DEBUG
	// public static String char1 = "ThaianyP1";

	// public static String char2 = "trainer";

	// public static String gameState = "TREINO";

	// MODO DO COMEÇO

	public static String char1;

	public static String char2;

	public static String gameState = "MENU";

	/*
	 * ESTADOS DO GAME:
	 * 
	 * MENU
	 * 
	 * SELECAO
	 * 
	 * MAPA_01SHOW
	 * 
	 */
	private boolean showMessageGameover = true;
	private int framesGameOver = 0;

	public static boolean reset = false;
	private boolean restartGame = false;

	public Menus menu;

	public SELECAO selec;

	public static TREINOSELECAO selecT;

	// public TREINO treino;

	public MAPA_01SHOW mapa01show;

	private long lastSkill1;
	private int cooldownTime4;
	private boolean skill1offcooldown;
	private boolean startoffcooldown;

	// START

	private long lastStart = 0;
	private int cooldownStart = 1000;
	private boolean startempo = false;
	private long lastwins = 0;
	private int cooldownwins = 2000;
	private boolean starwins = false;

	private int countartempowins = 0;
	public static int countdownwins;

	public MAPA_TREINO mapatreinoshow;

	private Moises fatality;

	public static boolean showWinMessage = true;

	// WINS
	public static boolean MoisesP2wins = false;
	public static boolean PhellipeP2wins = false;
	public static boolean MoisesP1wins = false;
	public static boolean PhellipeP1wins = false;

	public static Spritesheet FundoImage;

	public static Spritesheet rotright;

	public static UI ui;
	public static UI ui2;

	public static Spritesheet VIDA;

	public static Spritesheet VIDAINVERSO;

	public static Spritesheet ENERGIA;

	public static Spritesheet ENERGIAINVERSO;

	public static Spritesheet TituloImage;

	public static MapaIcon Mapa01Icon;
	public static MapaIcon Mapa02Icon;
	public static MapaIcon Mapa03Icon;

	public Game() {
		rand = new Random();
		addKeyListener(this);
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		initFrame();
		// Inicializando Objetos

		ui = new UI();
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

		player = new Players(framesGameOver, framesGameOver, framesGameOver, framesGameOver, image);

		players = new ArrayList<Players>();
		players2 = new ArrayList<Players>();

		pcs = new ArrayList<pc>();
		mouses = new ArrayList<mouse>();
		rots = new ArrayList<roteador>();
		rotsup = new ArrayList<roteadorUP>();

		pcs2 = new ArrayList<pc>();
		mouses2 = new ArrayList<mouse>();
		rots2 = new ArrayList<roteador>();
		rotsup2 = new ArrayList<roteadorUP>();

		bullets = new ArrayList<Bullets>();
		miras = new ArrayList<mirault>();

		blocohtml = new ArrayList<html>();
		robos = new ArrayList<robo>();

		dadosvarios = new ArrayList<dados>();
		nuvens = new ArrayList<nuvem>();

		ulthoriz = new ArrayList<thayulthorizontal>();

		ultverti = new ArrayList<thayultvertical>();

		selecaopersonagem = new Spritesheet("/selecaopersonagensv2.png");
		fundoselecao = new Spritesheet("/fundoselecao.png");
		fundoselecaomapa = new Spritesheet("/fundoselecaomapa.png");
		selecaoamarelo = new Spritesheet("/selecaoamarelo.png");
		selecaovermelho = new Spritesheet("/selecaovermelho.png");

		VIDA = new Spritesheet("/barradevidav3inverso.png");

		VIDAINVERSO = new Spritesheet("/barradevidav3.png");

		ENERGIA = new Spritesheet("/barradeenergias.png");

		ENERGIAINVERSO = new Spritesheet("/barradeenergiasinverso.png");

		mapa01 = new MAPA_01("/fundomapa01.png", "/chaomapa01.png");

		mapatreino = new MAPA_01("/fundomapa01.png", "/chaomapa01.png");

		RONALDskill2 = new Spritesheet("/ronaldskill2.png");

		RONALDtransform = new Spritesheet("/ronaldtransform.png");

		RONALDmode = new Spritesheet("/ronaldspritesheet.png");

		moisesultparado = new Spritesheet("/moiseultparado.png");

		ataque1ph = new Spritesheet("/attackph.png");
		ataque1phinv = new Spritesheet("/attackphinverso.png");

		mouseright = new Spritesheet("/moises-habilidades3.png");
		mouseleft = new Spritesheet("/moises-habilidade3inverso.png");

		blockright = new Spritesheet("/bloquearanimacao.png");
		blockleft = new Spritesheet("/bloquearanimacaoinverso.png");

		pcright = new Spritesheet("/moisespc.png");

		rotright = new Spritesheet("/moisesroteador.png");

		spritesheet = new Spritesheet("/moisesspritesheet.png");
		spritesheet2 = new Spritesheet("/phellipespritesheetv3.png");
		spritesheet3 = new Spritesheet("/maxuelspritesheet.png");

		spritesheetboneco = new Spritesheet("/spritesheetboneco.png");

		maxuelandando = new Spritesheet("/maxuel-andandospritesheet.png");
		maxuelpulando = new Spritesheet("/maxuel-pulandospritesheet.png");
		maxuelsetas = new Spritesheet("/maxuelsetas.png");

		PhellipeP1SELEC = new Caras("/phellipecara.png");
		PhellipeP2SELEC = new Caras("/phellipecarainverso.png");
		MoisesP1SELEC = new Caras("/moisescara.png");
		MoisesP2SELEC = new Caras("/moisescarainverso.png");

		FundoImage = new Spritesheet("/menufundov2.jpg");
		TituloImage = new Spritesheet("/titulo.png");

		MAPAPRIMEIRO = new Spritesheet("/mapabrabo01.png");

		jogarbotao = new Spritesheet("/jogarclaro.png");

		sairbotao = new Spritesheet("/sair.png");

		creditobotao = new Spritesheet("/creditosbotao.png");

		opcaobotao = new Spritesheet("/opcoes.png");

		treinobotao = new Spritesheet("/treino.png");

		creditos1 = new Spritesheet("/creditos1v2.png");

		creditos2 = new Spritesheet("/creditos2v2.png");

		continuarfundo = new Spritesheet("/continuarfundo.png");

		controles1 = new Spritesheet("/controles1.png");

		controles2 = new Spritesheet("/controles2.png");

		continuarbutao = new Spritesheet("/continuar.png");

		controlebutao = new Spritesheet("/controlesbutao.png");

		menubutao = new Spritesheet("/menubotao.png");

		voltarbutao = new Spritesheet("/voltar.png");

		maxuelresto = new Spritesheet("/maxuelspritefaltando.png");

		ivanildo = new Spritesheet("/ivanildospritesheet.png");

		mira = new Spritesheet("/mirault.png");

		ivanildoult = new Spritesheet("/ivanildoultspritesheet.png");

		ivanildoultinverso = new Spritesheet("/ultinversogrande.png");

		ivanildoskill1 = new Spritesheet("/magia-prof1.png");

		ivanildoskill2 = new Spritesheet("/robospritesheet.png");

		thaiany = new Spritesheet("/thayspritesheet.png");

		thaianypuloinverso = new Spritesheet("/thaynepuloinverso.png");

		thaianyattack3inverso = new Spritesheet("/thayattack3inverso.png");

		dadosprite = new Spritesheet("/habilidade.png");

		nuvemsprite = new Spritesheet("/habilidade2.png");

		ultvertical = new Spritesheet("/ult1.png");

		ulthorizontal = new Spritesheet("/ult2.png");

		Mapa01Icon = new MapaIcon("/mapaicon.png");
		Mapa02Icon = new MapaIcon("");
		Mapa03Icon = new MapaIcon("");

		// MoisesP1 = new Moises( X = 0, Y = 150, LARGURA = 53, ALTURA = 80,
		// spritesheet.getSprite(POSICAO X NO SPRITE = 32, POSICAO Y no SPRITE 0, ALTURA
		// DO SPRITE = 53, LARGURA DO SPRITE = 80));

		MoisesP1 = new Moises(0, 30, 53, 80, spritesheet.getSprite(32, 0, 53, 80));
		MoisesP2 = new Moises(270, 60, 53, 80, spritesheet.getSprite(32, 0, 53, 80));

		PhellipeP1 = new Phellipe(0, 40, 30, 76, spritesheet2.getSprite(10, 0, 30, 76));
		PhellipeP2 = new Phellipe(250, 30, 30, 76, spritesheet2.getSprite(0, 0, 30, 76));

		MaxuelP1 = new Maxuel(0, 60, 70, 95, spritesheet3.getSprite(35, 1153, 70, 95));
		MaxuelP2 = new Maxuel(160, 50, 70, 95, spritesheet3.getSprite(35, 1153, 70, 95));

		IvanildoP1 = new Ivanildo(0, 40, 70, 95, ivanildo.getSprite(35, 1153, 70, 95));
		IvanildoP2 = new Ivanildo(160, 60, 70, 95, ivanildo.getSprite(35, 1153, 70, 95));

		ThaianyP1 = new Thaiany(0, 60, 70, 95, thaiany.getSprite(30, 0, 70, 95));
		ThaianyP2 = new Thaiany(160, 40, 70, 95, thaiany.getSprite(30, 0, 70, 95));

		trainer = new SacoDeBrunnada(160, 150, 53, 80, spritesheetboneco.getSprite(0, 0, 53, 80));

		// ADICIONANDO OS PLAYERS A DUAS LISTAS

		players.add(MoisesP1);
		players.add(PhellipeP1);
		players.add(MaxuelP1);
		players.add(IvanildoP1);
		players.add(ThaianyP1);

		players2.add(MoisesP2);
		players2.add(PhellipeP2);
		players2.add(MaxuelP2);
		players2.add(IvanildoP2);
		players2.add(ThaianyP2);
		players2.add(trainer);

		// HITBOX DO CHÃO DO JOGO

		chao01 = new Box(0, +375, Game.WIDTH * Game.SCALE, 300, Color.red);
		parede01 = new Box(50, +275, 20, 200, Color.blue);
		parede02 = new Box(800, +275, 20, 200, Color.magenta);

		menu = new Menus();
		selec = new SELECAO();
		mapa01show = new MAPA_01SHOW();
		selecT = new TREINOSELECAO();
		mapatreinoshow = new MAPA_TREINO();

	}

	public void initFrame() {

		frame = new JFrame();// Cria uma nova instância de JFrame, que é uma janela de aplicativo no Java
								// Swing.

		frame.add(this); // Adiciona o componente atual (que deve ser uma instância da classe que contém
							// esse método) à janela frame. Isso significa que o componente será exibido
							// dentro da janela.

		frame.setResizable(false);// Define a janela frame para ser não redimensionável pelo usuário. Isso impede
									// que o usuário altere o tamanho da janela manualmente.

		frame.pack();// Redimensiona a janela frame para se ajustar automaticamente ao tamanho
						// preferido do componente contido nela. Isso garante que o componente seja
						// exibido corretamente dentro da janela.

		frame.setLocationRelativeTo(null);// Define a posição da janela frame no centro da tela. Ao passar null como
											// argumento, a janela é centralizada em relação à tela do monitor.

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Define a operação padrão que ocorrerá quando o usuário
																// fechar a janela frame. Nesse caso, é definido para
																// EXIT_ON_CLOSE, o que faz com que o programa seja
																// encerrado completamente quando a janela for fechada.

		frame.setVisible(true);// Torna a janela frame visível, exibindo-a na tela.

	}

	public synchronized void start() {

		thread = new Thread(this);// Cria uma nova instância de Thread ou seja um Encadeamento de Execução e passa
									// o componente atual (que deve
									// implementar a interface Runnable) como argumento. Isso cria uma nova thread
									// que será responsável por executar o código contido no componente.

		isRunning = true; // Define a booleana responsável por manter o loop do jogo no run

		thread.start(); // Inicia a thread recém-criada, fazendo com que o método run() do componente
						// seja executado em paralelo.

	}

	public synchronized void stop() {
		isRunning = false;// Define a variável booleana ""isRunning" como false interrompendo o loop do
							// jogo.
		try {
			thread.join();// - Aguarda até que a thread em execução (thread) seja finalizada. Isso é feito
							// chamando o método join() da thread atual. O bloco do try catch trata qualquer
							// exceção InterruptedException que possa ocorrer durante o processo de
							// interrupção da thread.
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		Game game1 = new Game();
		game1.start();

	}

	public void startCountdown() {

		long time = System.currentTimeMillis();
		if (time > lastStart + cooldownStart) {

			startempo = true;

			if (startempo == true) {
				countdown--;
			}

			lastStart = time;
		} else
			startempo = false;

		if (countdown == -1) {
			showFightMessage = false;
		}

	}

	public void winsCountdown() {

		long time = System.currentTimeMillis();
		if (time > lastwins + cooldownwins) {

			starwins = true;

			if (starwins == true) {
				countdownwins++;
			}

			lastwins = time;
		} else
			starwins = false;

		if (countdownwins == 2) {
			showWinMessage = false;
		}

	}

	public void tick() {

		if (gameState == "TREINO") {

			chao01 = new Box(0, +475, Game.WIDTH * Game.SCALE, 300, Color.red);
			parede01 = new Box(0, +275, 20, 200, Color.blue);
			parede02 = new Box(880, +275, 20, 200, Color.magenta);

			MoisesP1.START = false;
			PhellipeP1.START = false;
			MaxuelP1.START = false;
			IvanildoP1.START = false;
			ThaianyP1.START = false;

			MoisesP1.energy = 100;
			MoisesP1.ult = 100;
			ThaianyP1.ult = 100;
			IvanildoP1.ult = 100;

			for (int i = 0; i < mouses.size(); i++) {
				mouses.get(i).tick();
			}

			for (int i = 0; i < pcs.size(); i++) {
				pcs.get(i).tick();
			}

			for (int i = 0; i < rots.size(); i++) {
				rots.get(i).tick();
			}

			for (int i = 0; i < rotsup.size(); i++) {
				rotsup.get(i).tick();
			}

			for (int i = 0; i < mouses2.size(); i++) {
				mouses2.get(i).tick();
			}

			for (int i = 0; i < pcs2.size(); i++) {
				pcs2.get(i).tick();
			}

			for (int i = 0; i < rots2.size(); i++) {
				rots2.get(i).tick();
			}

			for (int i = 0; i < rotsup2.size(); i++) {
				rotsup2.get(i).tick();
			}

			for (int i = 0; i < bullets.size(); i++) {
				bullets.get(i).tick();
			}

			for (int i = 0; i < miras.size(); i++) {
				miras.get(i).tick();
			}

			for (int i = 0; i < robos.size(); i++) {
				robos.get(i).tick();
			}

			for (int i = 0; i < blocohtml.size(); i++) {
				blocohtml.get(i).tick();
			}

			for (int i = 0; i < dadosvarios.size(); i++) {
				dadosvarios.get(i).tick();
			}

			for (int i = 0; i < nuvens.size(); i++) {
				nuvens.get(i).tick();
			}

			for (int i = 0; i < ultverti.size(); i++) {
				ultverti.get(i).tick();
			}

			for (int i = 0; i < ulthoriz.size(); i++) {
				ulthoriz.get(i).tick();
			}

			if (char1 == "MoisesP1") {

				MoisesP1.tick();

			}

			if (char1 == "PhellipeP1") {

				PhellipeP1.tick();

			}

			if (char1 == "MaxuelP1") {

				MaxuelP1.tick();

			}

			if (char1 == "IvanildoP1") {

				IvanildoP1.tick();

			}

			if (char1 == "ThaianyP1") {

				ThaianyP1.tick();
			}

			trainer.tick();

		}

		if (gameState == "MAPA_01SHOW") {

			chao01 = new Box(0, +375, Game.WIDTH * Game.SCALE, 300, Color.red);
			parede01 = new Box(50, +275, 20, 200, Color.blue);
			parede02 = new Box(800, +275, 20, 200, Color.magenta);

			// MoisesP1.dirM = MoisesP1.left_dirM;
			// MoisesP2.dirM = MoisesP2.right_dirM;

			for (int i = 0; i < mouses.size(); i++) {
				mouses.get(i).tick();
			}

			for (int i = 0; i < pcs.size(); i++) {
				pcs.get(i).tick();
			}

			for (int i = 0; i < rots.size(); i++) {
				rots.get(i).tick();
			}

			for (int i = 0; i < rotsup.size(); i++) {
				rotsup.get(i).tick();
			}

			for (int i = 0; i < mouses2.size(); i++) {
				mouses2.get(i).tick();
			}

			for (int i = 0; i < pcs2.size(); i++) {
				pcs2.get(i).tick();
			}

			for (int i = 0; i < rots2.size(); i++) {
				rots2.get(i).tick();
			}

			for (int i = 0; i < rotsup2.size(); i++) {
				rotsup2.get(i).tick();
			}

			for (int i = 0; i < bullets.size(); i++) {
				bullets.get(i).tick();
			}

			for (int i = 0; i < miras.size(); i++) {
				miras.get(i).tick();
			}

			for (int i = 0; i < robos.size(); i++) {
				robos.get(i).tick();
			}

			for (int i = 0; i < blocohtml.size(); i++) {
				blocohtml.get(i).tick();
			}

			for (int i = 0; i < dadosvarios.size(); i++) {
				dadosvarios.get(i).tick();
			}

			for (int i = 0; i < nuvens.size(); i++) {
				nuvens.get(i).tick();
			}

			for (int i = 0; i < ultverti.size(); i++) {
				ultverti.get(i).tick();
			}

			for (int i = 0; i < ulthoriz.size(); i++) {
				ulthoriz.get(i).tick();
			}

			if (char1 == "MoisesP1") {

				MoisesP1.tick();

			}

			if (char2 == "MoisesP2") {

				MoisesP2.tick();

			}

			if (char1 == "PhellipeP1") {

				PhellipeP1.tick();

			}

			if (char2 == "PhellipeP2") {

				PhellipeP2.tick();

			}

			if (char1 == "MaxuelP1") {

				MaxuelP1.tick();

			}

			if (char2 == "MaxuelP2") {

				MaxuelP2.tick();

			}

			if (char1 == "IvanildoP1") {

				IvanildoP1.tick();

			}

			if (char2 == "IvanildoP2") {

				IvanildoP2.tick();

			}

			if (char1 == "ThaianyP1") {

				ThaianyP1.tick();
			}

			if (char2 == "ThaianyP2") {

				ThaianyP2.tick();
			}

			// STARTAR OS 3,2,1 LUTAR

			if (MoisesP1.START == true || MoisesP2.START == true || PhellipeP1.START == true
					|| PhellipeP2.START == true) {

				startCountdown();
			}

			// IFS DAS TELAS DE WIN

			if (MoisesP1.dead && char2 == "MoisesP2" || PhellipeP1.dead && char2 == "MoisesP2") {

				MoisesP2wins = true;

				winsCountdown();

				for (Players playersteste : players) {

				}

				for (Players playersteste : players2) {

				}

				if (countdownwins == 2) {

					SELECAO.finalselecconfir = false;
					SELECAO.finalselec = false;
					SELECAO.space = false;
					SELECAO.enter = false;
					Game.char1 = "";
					Game.char2 = "";
					Game.countdown = 4;
					Menus.pause = false;
					SELECAO.player1 = false;
					SELECAO.player2 = false;
					SELECAO.selec = false;
					TREINOSELECAO.selec = false;
					Game.selecT.TREINOATIVADO = false;

					SELECAO.player1 = false;
					SELECAO.player2 = false;
					SELECAO.selec = false;
					TREINOSELECAO.selec = false;
					Game.selecT.TREINOATIVADO = false;
					SELECAO.stop1 = false;
					SELECAO.stop2 = false;

					Game.players.removeAll(Game.players);
					Game.players2.removeAll(Game.players2);

					Game.pcs.removeAll(Game.pcs);
					Game.pcs2.removeAll(Game.pcs2);
					Game.rots.removeAll(Game.rots);
					Game.rots2.removeAll(Game.rots2);

					Game.MaxuelP1 = new Maxuel(0, 150, 70, 95, Game.spritesheet3.getSprite(35, 1153, 70, 95));
					Game.MaxuelP2 = new Maxuel(160, 150, 70, 95, Game.spritesheet3.getSprite(35, 1153, 70, 95));

					Game.MoisesP1 = new Moises(0, 50, 53, 80, Game.spritesheet.getSprite(32, 0, 53, 80));
					Game.PhellipeP1 = new Phellipe(0, 50, 30, 76, Game.spritesheet2.getSprite(0, 0, 30, 76));

					Game.MoisesP2 = new Moises(160, 50, 53, 80, Game.spritesheet.getSprite(32, 0, 53, 80));
					Game.PhellipeP2 = new Phellipe(160, 50, 30, 76, Game.spritesheet2.getSprite(0, 0, 30, 76));


					Game.IvanildoP1 = new Ivanildo(0, 50, 70, 95, Game.ivanildo.getSprite(35, 1153, 70, 95));
					Game.IvanildoP2 = new Ivanildo(160, 40, 70, 95, Game.ivanildo.getSprite(35, 1153, 70, 95));

					Game.ThaianyP1 = new Thaiany(0,50 ,70 ,95, Game.thaiany.getSprite(30, 0, 70, 95));
					Game.ThaianyP2 = new Thaiany(160,40 , 70,95, Game.thaiany.getSprite(30, 0, 70, 95));
					
					Game.trainer = new SacoDeBrunnada(160, 50, 53, 80, Game.spritesheetboneco.getSprite(0, 0, 53, 80));
					Game.players2.add(Game.trainer);

					Game.players.add(Game.MoisesP1);
					Game.players.add(Game.PhellipeP1);
					Game.players.add(Game.MaxuelP1);
					Game.players.add(Game.IvanildoP1);
					Game.players.add(Game.ThaianyP1);

					Game.players2.add(Game.MoisesP2);
					Game.players2.add(Game.PhellipeP2);
					Game.players2.add(Game.MaxuelP2);
					Game.players2.add(Game.IvanildoP2);
					Game.players2.add(Game.ThaianyP2);

					Game.MoisesP1.dead = false;
					Game.PhellipeP2.dead = false;
					Game.MoisesP2.dead = false;
					Game.PhellipeP1.dead = false;

					MoisesP2wins = false;
					PhellipeP2wins = false;

					PhellipeP1wins = false;
					MoisesP1wins = false;

					countdownwins = 0;
					showFightMessage = true;
				}

			}

			if (MoisesP1.dead && char2 == "PhellipeP2" || PhellipeP1.dead && char2 == "PhellipeP2") {

				PhellipeP2wins = true;

				winsCountdown();

				if (countdownwins == 2) {

					SELECAO.finalselecconfir = false;
					SELECAO.finalselec = false;
					SELECAO.space = false;
					SELECAO.enter = false;
					Game.char1 = "";
					Game.char2 = "";
					Game.countdown = 4;
					Menus.pause = false;
					SELECAO.player1 = false;
					SELECAO.player2 = false;
					SELECAO.selec = false;
					TREINOSELECAO.selec = false;
					Game.selecT.TREINOATIVADO = false;

					SELECAO.player1 = false;
					SELECAO.player2 = false;
					SELECAO.selec = false;
					TREINOSELECAO.selec = false;
					Game.selecT.TREINOATIVADO = false;
					SELECAO.stop1 = false;
					SELECAO.stop2 = false;

					Game.players.removeAll(Game.players);
					Game.players2.removeAll(Game.players2);

					gameState = "MENU";

					Game.pcs.removeAll(Game.pcs);
					Game.pcs2.removeAll(Game.pcs2);
					Game.rots.removeAll(Game.rots);
					Game.rots2.removeAll(Game.rots2);

					Game.MaxuelP1 = new Maxuel(0, 50, 70, 95, Game.spritesheet3.getSprite(35, 1153, 70, 95));
					Game.MaxuelP2 = new Maxuel(160, 50, 70, 95, Game.spritesheet3.getSprite(35, 1153, 70, 95));

					Game.MoisesP1 = new Moises(0, 50, 53, 80, Game.spritesheet.getSprite(32, 0, 53, 80));
					Game.PhellipeP1 = new Phellipe(0, 50, 30, 76, Game.spritesheet2.getSprite(0, 0, 30, 76));

					Game.MoisesP2 = new Moises(160, 50, 53, 80, Game.spritesheet.getSprite(32, 0, 53, 80));
					Game.PhellipeP2 = new Phellipe(160, 50, 30, 76, Game.spritesheet2.getSprite(0, 0, 30, 76));

					Game.trainer = new SacoDeBrunnada(160, 50, 53, 80, Game.spritesheetboneco.getSprite(0, 0, 53, 80));
					Game.players2.add(Game.trainer);

					Game.players.add(Game.MoisesP1);
					Game.players.add(Game.PhellipeP1);
					Game.players.add(Game.MaxuelP1);

					Game.players2.add(Game.MoisesP2);
					Game.players2.add(Game.PhellipeP2);
					Game.players2.add(Game.MaxuelP2);

					Game.MoisesP1.dead = false;
					Game.PhellipeP2.dead = false;
					Game.MoisesP2.dead = false;
					Game.PhellipeP1.dead = false;
					Game.MaxuelP1.dead = false;
					Game.MaxuelP2.dead = false;
					Game.IvanildoP1.dead = false;
					Game.IvanildoP2.dead = false;
					Game.ThaianyP1.dead = false;
					Game.ThaianyP2.dead = false;

					MoisesP2wins = false;
					PhellipeP2wins = false;

					PhellipeP1wins = false;
					MoisesP1wins = false;

					gameState = "MENU";

					countdownwins = 0;
					showFightMessage = true;
				}

			}

			if (MoisesP2.dead && char1 == "MoisesP1" || PhellipeP2.dead && char1 == "MoisesP1") {

				MoisesP1wins = true;

				winsCountdown();

				if (countdownwins == 2) {
					SELECAO.finalselecconfir = false;
					SELECAO.finalselec = false;
					SELECAO.space = false;
					SELECAO.enter = false;
					Game.char1 = "";
					Game.char2 = "";
					Game.countdown = 4;
					Menus.pause = false;
					SELECAO.player1 = false;
					SELECAO.player2 = false;
					SELECAO.selec = false;
					TREINOSELECAO.selec = false;
					Game.selecT.TREINOATIVADO = false;

					SELECAO.stop1 = false;
					SELECAO.stop2 = false;

					gameState = "MENU";

					Game.players.removeAll(Game.players);
					Game.players2.removeAll(Game.players2);

					Game.pcs.removeAll(Game.pcs);
					Game.pcs2.removeAll(Game.pcs2);
					Game.rots.removeAll(Game.rots);
					Game.rots2.removeAll(Game.rots2);

					Game.MaxuelP1 = new Maxuel(0, 50, 70, 95, Game.spritesheet3.getSprite(35, 1153, 70, 95));
					Game.MaxuelP2 = new Maxuel(160, 50, 70, 95, Game.spritesheet3.getSprite(35, 1153, 70, 95));

					Game.MoisesP1 = new Moises(0, 50, 53, 80, Game.spritesheet.getSprite(32, 0, 53, 80));
					Game.PhellipeP1 = new Phellipe(0, 50, 30, 76, Game.spritesheet2.getSprite(0, 0, 30, 76));

					Game.MoisesP2 = new Moises(160, 50, 53, 80, Game.spritesheet.getSprite(32, 0, 53, 80));
					Game.PhellipeP2 = new Phellipe(160, 50, 30, 76, Game.spritesheet2.getSprite(0, 0, 30, 76));

					Game.trainer = new SacoDeBrunnada(160, 50, 53, 80, Game.spritesheetboneco.getSprite(0, 0, 53, 80));
					Game.players2.add(Game.trainer);

					Game.players.add(Game.MoisesP1);
					Game.players.add(Game.PhellipeP1);
					Game.players.add(Game.MaxuelP1);

					Game.players2.add(Game.MoisesP2);
					Game.players2.add(Game.PhellipeP2);
					Game.players2.add(Game.MaxuelP2);

					Game.MoisesP1.dead = false;
					Game.PhellipeP2.dead = false;
					Game.MoisesP2.dead = false;
					Game.PhellipeP1.dead = false;

					MoisesP2wins = false;
					PhellipeP2wins = false;

					PhellipeP1wins = false;
					MoisesP1wins = false;

					countdownwins = 0;
					showFightMessage = true;
				}

			}

			if (MoisesP2.dead && char1 == "PhellipeP1" || PhellipeP2.dead && char1 == "PhellipeP1") {

				PhellipeP1wins = true;

				winsCountdown();

				if (countdownwins == 2) {

					SELECAO.finalselecconfir = false;
					SELECAO.finalselec = false;
					SELECAO.space = false;
					Game.char1 = "";
					Game.char2 = "";
					Menus.pause = false;
					SELECAO.selec = false;
					countdown = 4;
					gameState = "MENU";
					countdownwins = 0;
					showWinMessage = true;
					showFightMessage = true;

					SELECAO.player1 = false;
					SELECAO.player2 = false;
					SELECAO.selec = false;
					TREINOSELECAO.selec = false;
					Game.selecT.TREINOATIVADO = false;
					SELECAO.stop1 = false;
					SELECAO.stop2 = false;

					players.removeAll(players);
					players2.removeAll(players);

					pcs.removeAll(pcs);
					pcs2.removeAll(pcs2);
					rots.removeAll(rots);
					rots2.removeAll(rots2);

					MoisesP1 = new Moises(0, 50, 53, 80, spritesheet.getSprite(32, 0, 53, 80));
					PhellipeP1 = new Phellipe(0, 50, 30, 76, spritesheet2.getSprite(0, 0, 30, 76));

					MoisesP2 = new Moises(160, 50, 53, 80, spritesheet.getSprite(32, 0, 53, 80));
					PhellipeP2 = new Phellipe(160, 50, 30, 76, spritesheet2.getSprite(0, 0, 30, 76));

					players.add(MoisesP1);
					players.add(PhellipeP1);

					players2.add(MoisesP2);
					players2.add(PhellipeP2);

					MoisesP1.dead = false;
					PhellipeP2.dead = false;
					MoisesP2.dead = false;
					PhellipeP1.dead = false;

					MoisesP2wins = false;
					PhellipeP2wins = false;

					PhellipeP1wins = false;
					MoisesP1wins = false;

					countdownwins = 0;
					showFightMessage = true;
				}

			}
			

			/*
			 * if (char2 == "PhellipeP2") {
			 * 
			 * PhellipeP2.tick();
			 * 
			 * }
			 * 
			 * if (char1 == "PhellipeP1") {
			 * 
			 * PhellipeP1.tick();
			 * 
			 * }
			 * 
			 * if (char1 == "MoisesP1") {
			 * 
			 * MoisesP1.tick();
			 * 
			 * }
			 * 
			 * if (char2 == "MoisesP2") {
			 * 
			 * MoisesP2.tick();
			 * 
			 * }
			 */

			/*
			 * if (Player.life == 0 || Player2.life == 0) {
			 * 
			 * players.removeAll(players); players2.removeAll(players2); }
			 * 
			 * 
			 * if (players.size() == 0 || players2.size() == 0) {
			 * 
			 * gameState = "MENU";
			 * 
			 * }
			 */

			/*
			 * if (MoisesP1.life <= 0 || PhellipeP2.life <= 0 || MoisesP2.life <= 0 ||
			 * PhellipeP1.life <= 0) {
			 * 
			 * 
			 * 
			 * SELECAO.finalselecconfir = false; SELECAO.finalselec = false; SELECAO.space =
			 * false; Game.char1 = ""; Game.char2 = ""; Menus.pause = false; SELECAO.selec =
			 * false; gameState = "MENU"; }
			 */

			/*
			 * if (MoisesP1.dead || PhellipeP2.dead || MoisesP2.dead || PhellipeP1.dead) {
			 * 
			 * SELECAO.finalselecconfir = false; SELECAO.finalselec = false; SELECAO.space =
			 * false; Game.char1 = ""; Game.char2 = ""; Menus.pause = false; SELECAO.selec =
			 * false; gameState = "MENU";
			 * 
			 * players.removeAll(players); players2.removeAll(players);
			 * 
			 * pcs.removeAll(pcs); pcs2.removeAll(pcs2); rots.removeAll(rots);
			 * rots2.removeAll(rots2);
			 * 
			 * MoisesP1 = new Moises(0, 150, 53, 80, spritesheet.getSprite(32, 0, 53, 80));
			 * PhellipeP1 = new Phellipe(0, 150, 30, 76, spritesheet2.getSprite(0, 0, 30,
			 * 76));
			 * 
			 * MoisesP2 = new Moises(160, 150, 53, 80, spritesheet.getSprite(32, 0, 53,
			 * 80)); PhellipeP2 = new Phellipe(160, 150, 30, 76, spritesheet2.getSprite(0,
			 * 0, 30, 76));
			 * 
			 * players.add(MoisesP1); players.add(PhellipeP1);
			 * 
			 * players2.add(MoisesP2); players2.add(PhellipeP2);
			 * 
			 * MoisesP1.dead = false; PhellipeP2.dead = false; MoisesP2.dead = false;
			 * PhellipeP1.dead = false;
			 * 
			 * }
			 * 
			 */

		}

		if (gameState == "MENU") {

			menu.tick();

		}
		if (gameState == "SELECAO") {

			selec.tick();

		}

		if (gameState == "TREINOSELECAO") {

			selecT.tick();

		}

	}

	public void render() throws IOException {

		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = image.getGraphics();
		Graphics2D g3 = (Graphics2D) g;

		// COR DE FUNDO

		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, WIDTH, HEIGHT);

		/*
		 * 
		 * //CIRCULO
		 * 
		 * g.setColor(Color.RED); g.fillOval(125, 50, 75, 75);
		 * 
		 * 
		 * 
		 */

		// Renderização do Jogo

		/*
		 * for (int i = 0; i < players.size(); i++) {
		 * 
		 * Player e = players.get(i); e.render(g); }
		 * 
		 * for (int i = 0; i < players2.size(); i++) {
		 * 
		 * Player2 e = players2.get(i); e.render(g); }
		 */

		// RENDERIZAÇÃO DE STRINGS

		/*
		 * g.setFont(new Font("Arial", Font.BOLD, 20)); g.setColor(Color.white);
		 * g.drawString("Olá  ", 140, 80);
		 */

		// PERSONAGEM

		// ANIMAÇÃO PERSONAGEm

		// PERSONAGEM RODANDO

		// ILUMINAÇÃO ALPHA
		/*
		 * g2.setColor(new Color(0, 0, 0, 180)); g2.fillRect(0, 0, WIDTH, HEIGHT);
		 */
		/** --- **/

		/*
		 * g2.rotate(Math.toRadians(90), 90 + 8, 90 + 8); g.drawImage(player, 90, 90,
		 * null);
		 * 
		 */

		/** --- **/

		/** ATIVAR O MODE DEBUG PARA VER MUDANÇAS EM TEMPO REAL (PRECISA SALVAR) **/

		/* USAR PARA MELHORAR A PERFORMANCE */

		// UI RENDER

		g.dispose();

		/** --- **/

		/*
		 * g.fillRect(20, 20, 50, 50); g.setColor(Color.WHITE); g.fillRect(50, 20, 12,
		 * 34); g.setColor(Color.CYAN); g.fillRect(60, 41, 10, 67);
		 * g.setColor(Color.BLACK); g.fillRect(10, 23, 40, 25);
		 */

		g = bs.getDrawGraphics();

		if (gameState == "MENU") {
			menu.render(g);

		} else if (gameState == "SELECAO") {
			selec.render(g);

		} else if (gameState == "MAPA_01SHOW") {
			mapa01show.render(g, g3);
		} else if (gameState == "TREINOSELECAO") {
			selecT.render(g);
		} else if (gameState == "TREINO") {
			mapatreinoshow.render(g, g3);
		}

		bs.show();

	}

	public void run() {
		long lastTime = System.nanoTime();// Recebe o valor atual do tempo em nanossegundos //Sera utilizado para
											// calcular a diferente de tempo entre as atualizações do jogo

		double amountOfTicks = 60.0;// Define o numero deseja de atualizações por segundo que nesse caso é 60

		double ns = 1000000000 / amountOfTicks;// ns é declarada e calcula a quantidade tempo em nanossegundos que cada
												// atualização deve levar, no caso 1 bilhão divido pelo número de
												// atualizações que programa quer

		int frames = 0;// Vai contar quantos quadros são renderizas em um segundo

		double timer = System.currentTimeMillis(); // Timer recebe o valor do tempo atual em milissegundos e será
													// utlizada para controlar quando o FPS vai ser exibido

		requestFocus(); // Faz com que não seja necessário clicar no programa para realizar ações (pede
						// foco no programa)

		while (isRunning) { // Iniciar um loop que é inciado pelo game.Start que vai ser a execução do jogo

			long now = System.nanoTime(); // A variável now é declarada e recebe o valor atual do tempo em
											// nanossegundos , ela é usada para calcular a diferença de tempo entre as
											// atualizações do jogo.

			delta += (now - lastTime) / ns;// A variável delta é incrementada pelo tempo decorrido desde a última
											// atualização do jogo, dividido por ns. Isso ajuda a controlar o momento
											// das atualizações e garantir que ocorram aproximadamente na taxa desejada.

			lastTime = now;// A variável lastTime é atualizada para armazenar o valor de now, representando
							// o tempo atual, para ser usado na próxima iteração do loop.

			if (delta >= 1) {// Verifica se delta (tempo acumulado) é maior ou igual a 1. Isso indica que
				// é hora de realizar uma atualização do estado do jogo.

				tick();// Chama a função tick(), que é responsável por atualizar o estado do jogo, como
						// a posição dos objetos, a lógica do jogo, a detecção de hibox e etc
				try {
					render();// Chama o metodo responsável por renderizar o jogo
				} catch (IOException e) {
					e.printStackTrace();
				}
				frames++;// Incrementa o contador de frames
				delta--;// Decrementa delta significando que a atualização foi realizada
			}

			if (System.currentTimeMillis() - timer >= 1000) {

				System.out.println("FPS: " + frames);
				frames = 0;
				timer += 1000;

			}
		}

		stop();// Chama o metodo stop que termina o jogo
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			if (char2 == "MoisesP2") {
				MoisesP2.right = true;

			}

			if (char2 == "PhellipeP2") {
				PhellipeP2.right = true;

			}

			if (char2 == "IvanildoP2") {
				IvanildoP2.right = true;

			}

			if (char2 == "MaxuelP2") {
				MaxuelP2.right = true;

			}

			if (char2 == "ThaianyP2") {
				ThaianyP2.right = true;

			}

			if (gameState == "SELECAO" && SELECAO.stop2 == false) {
				selec.right2 = true;
			}
			if (gameState == "TREINOSELECAO") {
				selecT.right = true;
			}

		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			if (char2 == "MoisesP2") {
				MoisesP2.left = true;

			}

			if (char2 == "PhellipeP2") {
				PhellipeP2.left = true;

			}

			if (char2 == "IvanildoP2") {
				IvanildoP2.left = true;

			}

			if (char2 == "MaxuelP2") {
				MaxuelP2.left = true;

			}

			if (char2 == "ThaianyP2") {
				ThaianyP2.left = true;

			}

			if (gameState == "SELECAO" && SELECAO.stop2 == false) {
				selec.left2 = true;
			}

			if (gameState == "TREINOSELECAO") {
				selecT.left = true;
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_A) {

			if (char1 == "MoisesP1") {

				MoisesP1.left = true;

			}

			if (char1 == "PhellipeP1") {

				PhellipeP1.left = true;

			}

			if (char1 == "MaxuelP1") {

				MaxuelP1.left = true;

			}

			if (char1 == "IvanildoP1") {

				IvanildoP1.left = true;

			}

			if (char1 == "ThaianyP1") {

				ThaianyP1.left = true;

			}
			if (gameState == "SELECAO" && SELECAO.stop1 == false) {
				selec.left = true;
			}

			for (mirault mira : miras) {

				mira.leftULT = true;

			}

		}

		if (e.getKeyCode() == KeyEvent.VK_D) {

			if (char1 == "MoisesP1") {

				MoisesP1.right = true;
			}

			if (char1 == "PhellipeP1") {

				PhellipeP1.right = true;
			}

			if (char1 == "MaxuelP1") {

				MaxuelP1.right = true;

			}

			if (char1 == "IvanildoP1") {

				IvanildoP1.right = true;

			}

			if (char1 == "ThaianyP1") {

				ThaianyP1.right = true;

			}

			for (mirault mira : miras) {

				mira.rightULT = true;

			}

			if (gameState == "SELECAO" && SELECAO.stop1 == false) {
				selec.right = true;
			}

		}

		if (e.getKeyCode() == KeyEvent.VK_W) {

			if (char1 == "MoisesP1") {

				MoisesP1.up = true;

			}

			if (char1 == "PhellipeP1") {

				PhellipeP1.up = true;
			}

			if (gameState == "MENU") {
				menu.up = true;
			}

			if (char1 == "MaxuelP1") {

				MaxuelP1.up = true;

			}

			if (char1 == "ThaianyP1") {

				ThaianyP1.up = true;

			}

			if (char1 == "IvanildoP1") {

				IvanildoP1.up = true;

			}

			for (mirault mira : miras) {

				mira.upULT = true;

			}

		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {

			if (char2 == "PhellipeP2") {

				PhellipeP2.up = true;
			}

			if (char2 == "MoisesP2") {

				MoisesP2.up = true;
			}

			if (char2 == "IvanildoP2") {
				IvanildoP2.up = true;

			}

			if (char2 == "MaxuelP2") {
				MaxuelP2.up = true;

			}

			if (char2 == "ThaianyP2") {
				ThaianyP2.up = true;

			}

			if (gameState == "MENU") {
				menu.up = true;
			}

		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {

			if (gameState == "MENU") {
				menu.down = true;
			}

			if (char2 == "PhellipeP2") {

				PhellipeP2.down = true;
			}

			if (char2 == "MoisesP2") {

				MoisesP2.down = true;
			}

			if (char2 == "IvanildoP2") {
				IvanildoP2.down = true;

			}

			if (char2 == "MaxuelP2") {
				MaxuelP2.down = true;

			}

			if (char2 == "ThaianyP2") {
				ThaianyP2.down = true;

			}

		}

		if (e.getKeyCode() == KeyEvent.VK_S) {

			if (char1 == "PhellipeP1") {
				PhellipeP1.down = true;

			}

			if (char1 == "MoisesP1") {

				MoisesP1.down = true;
			}

			if (char1 == "MaxuelP1") {

				MaxuelP1.down = true;
			}

			if (char1 == "IvanildoP1") {

				IvanildoP1.down = true;

			}

			if (char1 == "ThaianyP1") {

				ThaianyP1.down = true;

			}

			for (mirault mira : miras) {

				mira.downULT = true;

			}

		}

		if (e.getKeyCode() == KeyEvent.VK_F) {

			if (char1 == "MoisesP1" && Game.MoisesP1.STUNNED == false) {

				MoisesP1.block = true;
			}

			if (char1 == "PhellipeP1" && Game.PhellipeP1.STUNNED == false) {

				PhellipeP1.block = true;
			}

			if (char1 == "MaxuelP1" && Game.MaxuelP1.STUNNED == false) {

				MaxuelP1.block = true;

			}

			if (char1 == "IvanildoP1" && Game.IvanildoP1.STUNNED == false) {

				IvanildoP1.block = true;

			}

			if (char1 == "ThaianyP1" && Game.ThaianyP1.STUNNED == false) {

				ThaianyP1.block = true;

			}

		}

		if (e.getKeyCode() == KeyEvent.VK_NUMPAD0) {

			if (char2 == "PhellipeP2" && Game.PhellipeP2.STUNNED == false) {
				PhellipeP2.block = true;

			}

			if (char2 == "MoisesP2" && Game.MoisesP2.STUNNED == false) {

				MoisesP2.block = true;

			}

			if (char2 == "IvanildoP2" && Game.IvanildoP2.STUNNED == false) {
				IvanildoP2.block = true;

			}

			if (char2 == "MaxuelP2" && Game.MaxuelP2.STUNNED == false) {
				MaxuelP2.block = true;

			}

			if (char2 == "ThaianyP2" && Game.ThaianyP2.STUNNED == false) {
				ThaianyP2.block = true;

			}

		}

		if (e.getKeyCode() == KeyEvent.VK_R) {

			this.reset = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			if (gameState == "MENU") {

				menu.enter = true;
			}

		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {

			if (gameState == "SELECAO") {

				selec.space = true;
			}

			if (gameState == "MENU") {

				menu.space = true;
			}

		}

		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {

			if (gameState == "MENU") {
				gameState = "MENU";
				menu.creditoSHOW = false;

			}

			if (gameState == "SELECAO") {
				gameState = "MENU";
				SELECAO.player1 = true;
				SELECAO.finalselecconfir = false;
				SELECAO.finalselec = false;
				SELECAO.space = false;
				Game.char1 = "";
				Game.char2 = "";
				SELECAO.selec = false;
				TREINOSELECAO.selec = false;
				SELECAO.player1 = false;
				SELECAO.player2 = false;
				SELECAO.selec = false;
				TREINOSELECAO.selec = false;
				Game.selecT.TREINOATIVADO = false;
				SELECAO.stop1 = false;
				SELECAO.stop2 = false;

				SELECAO.PH1 = false;
				SELECAO.PH2 = false;
				SELECAO.MOI1 = false;
				SELECAO.MOI2 = false;
				SELECAO.IV1 = false;
				SELECAO.IV2 = false;
				SELECAO.TH1 = false;
				SELECAO.TH2 = false;
				SELECAO.MX1 = false;
				SELECAO.MX2 = false;

			}

			if (gameState == "TREINOSELECAO") {
				gameState = "MENU";
				SELECAO.player1 = true;
				SELECAO.finalselecconfir = false;
				SELECAO.finalselec = false;
				SELECAO.space = false;
				Game.char1 = "";
				Game.char2 = "";
				SELECAO.selec = false;
				TREINOSELECAO.selec = false;
			}

			if (gameState == "MAPA_01SHOW" || gameState == "TREINO") {
				gameState = "MENU";
				menu.pause = true;
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_NUMPAD1) {

			if (char2 == "PhellipeP2") {
				PhellipeP2.attack1 = true;

			}

			if (char2 == "MoisesP2") {
				MoisesP2.attack1 = true;

			}

			if (char2 == "IvanildoP2") {
				IvanildoP2.attack1 = true;

			}

			if (char2 == "MaxuelP2") {
				MaxuelP2.attack1 = true;

			}

			if (char2 == "ThaianyP2") {
				ThaianyP2.attack1 = true;

			}

			if (gameState == "SELECAO") {

				selec.enter2 = true;
			}

		}

		if (e.getKeyCode() == KeyEvent.VK_NUMPAD2) {

			if (char2 == "PhellipeP2") {
				PhellipeP2.attack2 = true;

			}

			if (char2 == "MoisesP2") {
				MoisesP2.attack2 = true;

			}

			if (char2 == "IvanildoP2") {
				IvanildoP2.attack2 = true;

			}

			if (char2 == "MaxuelP2") {
				MaxuelP2.attack2 = true;

			}

			if (char2 == "ThaianyP2") {
				ThaianyP2.attack2 = true;

			}

		}

		if (e.getKeyCode() == KeyEvent.VK_NUMPAD3) {

			if (char2 == "PhellipeP2") {
				PhellipeP2.attack3 = true;

			}
			if (char2 == "MoisesP2") {
				MoisesP2.attack3 = true;

			}

			if (char2 == "IvanildoP2") {
				IvanildoP2.attack3 = true;

			}

			if (char2 == "MaxuelP2") {
				MaxuelP2.attack3 = true;

			}

			if (char2 == "ThaianyP2") {
				ThaianyP2.attack3 = true;

			}
		}

		if (e.getKeyCode() == KeyEvent.VK_NUMPAD4) {

			if (char2 == "PhellipeP2") {
				PhellipeP2.skill1 = true;

			}
			if (char2 == "MoisesP2") {
				MoisesP2.skill1 = true;

			}

			if (char2 == "IvanildoP2") {
				IvanildoP2.skill1 = true;

			}

			if (char2 == "MaxuelP2") {
				MaxuelP2.skill1 = true;

			}

			if (char2 == "ThaianyP2") {
				ThaianyP2.skill1 = true;

			}

		}

		if (e.getKeyCode() == KeyEvent.VK_NUMPAD5) {

			if (char2 == "MoisesP2") {
				MoisesP2.skill2 = true;

			}

			if (char2 == "PhellipeP2") {
				PhellipeP2.skill2 = true;

			}

			if (char2 == "IvanildoP2") {
				IvanildoP2.skill2 = true;

			}

			if (char2 == "MaxuelP2") {
				MaxuelP2.skill2 = true;

			}

			if (char2 == "ThaianyP2") {
				ThaianyP2.skill2 = true;

			}

		}

		if (e.getKeyCode() == KeyEvent.VK_NUMPAD6) {

			if (char2 == "MoisesP2") {
				MoisesP2.skillult = true;

			}
			if (char2 == "IvanildoP2") {
				IvanildoP2.skillult = true;

			}

			if (char2 == "MaxuelP2") {
				MaxuelP2.skillult = true;

			}

			if (char2 == "ThaianyP2") {
				ThaianyP2.skillult = true;

			}

		}

		if (e.getKeyCode() == KeyEvent.VK_J) {

			if (char1 == "MoisesP1") {
				MoisesP1.attack1 = true;

			}

			if (gameState == "SELECAO") {

				selec.enter = true;
			}

			if (gameState == "TREINOSELECAO") {

				selecT.enter = true;
			}

			if (char1 == "PhellipeP1") {
				PhellipeP1.attack1 = true;

			}

			if (char1 == "MaxuelP1") {

				MaxuelP1.attack1 = true;

			}

			if (char1 == "IvanildoP1") {

				IvanildoP1.attack1 = true;

			}

			if (char1 == "ThaianyP1") {

				ThaianyP1.attack1 = true;

			}

		}

		if (e.getKeyCode() == KeyEvent.VK_K) {

			if (char1 == "MoisesP1") {
				MoisesP1.attack2 = true;

			}

			if (char1 == "PhellipeP1") {
				PhellipeP1.attack2 = true;

			}

			if (char1 == "MaxuelP1") {

				MaxuelP1.attack2 = true;

			}

			if (char1 == "IvanildoP1") {

				IvanildoP1.attack2 = true;

			}
			if (char1 == "ThaianyP1") {

				ThaianyP1.attack2 = true;

			}

		}

		if (e.getKeyCode() == KeyEvent.VK_L) {

			if (char1 == "MoisesP1") {
				MoisesP1.attack3 = true;

			}

			if (char1 == "PhellipeP1") {
				PhellipeP1.attack3 = true;

			}

			if (char1 == "MaxuelP1") {

				MaxuelP1.attack3 = true;

			}

			if (char1 == "IvanildoP1") {

				IvanildoP1.attack3 = true;

			}
			if (char1 == "ThaianyP1") {

				ThaianyP1.attack3 = true;

			}

		}

		if (e.getKeyCode() == KeyEvent.VK_U) {

			if (char1 == "MoisesP1") {
				MoisesP1.skill1 = true;

			}

			if (char1 == "PhellipeP1") {
				PhellipeP1.skill1 = true;

			}

			if (char1 == "MaxuelP1") {

				MaxuelP1.skill1 = true;

			}

			if (char1 == "IvanildoP1") {

				IvanildoP1.skill1 = true;

			}
			if (char1 == "ThaianyP1") {

				ThaianyP1.skill1 = true;

			}

		}
		if (e.getKeyCode() == KeyEvent.VK_I) {

			if (char1 == "MoisesP1") {
				MoisesP1.skill2 = true;

			}

			if (char1 == "PhellipeP1") {
				PhellipeP1.skill2 = true;

			}

			if (char1 == "MaxuelP1") {

				MaxuelP1.skill2 = true;

			}

			if (char1 == "IvanildoP1") {

				IvanildoP1.skill2 = true;

			}

			if (char1 == "ThaianyP1") {

				ThaianyP1.skill2 = true;

			}
		}

		if (e.getKeyCode() == KeyEvent.VK_O) {

			if (char1 == "MoisesP1") {
				MoisesP1.skillult = true;

				if (MoisesP1.skillult) {

					MoisesP1.skillultHAKAI = true;
				}

			}

			if (char1 == "MaxuelP1") {

				MaxuelP1.skillult = true;

			}

			if (char1 == "IvanildoP1") {

				IvanildoP1.skillult = true;

			}

			if (char1 == "ThaianyP1") {

				ThaianyP1.skillult = true;

			}

		}

	}

	/// RELEASED

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			if (char2 == "PhellipeP2") {
				PhellipeP2.right = false;

			}

			if (char2 == "MoisesP2") {
				MoisesP2.right = false;

			}

			if (char2 == "IvanildoP2") {
				IvanildoP2.right = false;

			}

			if (char2 == "MaxuelP2") {
				MaxuelP2.right = false;

			}

			if (char2 == "ThaianyP2") {
				ThaianyP2.right = false;

			}

		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			if (char2 == "PhellipeP2") {
				PhellipeP2.left = false;

			}

			if (char2 == "MoisesP2") {
				MoisesP2.left = false;

			}

			if (char2 == "IvanildoP2") {
				IvanildoP2.left = false;

			}

			if (char2 == "MaxuelP2") {
				MaxuelP2.left = false;

			}

			if (char2 == "ThaianyP2") {
				ThaianyP2.left = false;

			}
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {

			if (char2 == "PhellipeP2") {
				PhellipeP2.up = false;

			}

			if (char2 == "MoisesP2") {
				MoisesP2.up = false;

			}

			if (char2 == "IvanildoP2") {
				IvanildoP2.up = false;

			}

			if (char2 == "MaxuelP2") {
				MaxuelP2.up = false;

			}

			if (char2 == "ThaianyP2") {
				ThaianyP2.up = false;

			}

			if (gameState == "MENU") {

				menu.up = false;
			}

		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {

			if (gameState == "SELECAO") {

				selec.space = false;
			}

			if (gameState == "MENU") {

				menu.space = false;
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_D) {

			if (char1 == "PhellipeP1") {
				PhellipeP1.right = false;

			}

			if (char1 == "MoisesP1") {
				MoisesP1.right = false;

			}
			if (char1 == "MaxuelP1") {
				MaxuelP1.right = false;

			}

			if (char1 == "IvanildoP1") {

				IvanildoP1.right = false;

			}

			if (char1 == "ThaianyP1") {

				ThaianyP1.right = false;

			}

			for (mirault mira : miras) {

				mira.rightULT = false;

			}

		}

		if (e.getKeyCode() == KeyEvent.VK_A) {

			if (char1 == "PhellipeP1") {
				PhellipeP1.left = false;

			}

			if (char1 == "MoisesP1") {
				MoisesP1.left = false;

			}

			if (char1 == "MaxuelP1") {
				MaxuelP1.left = false;

			}

			if (char1 == "IvanildoP1") {

				IvanildoP1.left = false;

			}

			if (char1 == "ThaianyP1") {

				ThaianyP1.left = false;

			}

			for (mirault mira : miras) {

				mira.leftULT = false;

			}

		}

		if (e.getKeyCode() == KeyEvent.VK_W) {

			if (char1 == "PhellipeP1") {
				PhellipeP1.up = false;

			}

			if (char1 == "MoisesP1") {
				MoisesP1.up = false;

			}

			if (char1 == "MaxuelP1") {
				MaxuelP1.up = false;

			}

			if (char1 == "IvanildoP1") {

				IvanildoP1.up = false;

			}
			if (char1 == "ThaianyP1") {

				ThaianyP1.up = false;

			}

			for (mirault mira : miras) {

				mira.upULT = false;

			}

		}

		if (e.getKeyCode() == KeyEvent.VK_NUMPAD1) {

			if (gameState == "SELECAO") {

				selec.enter2 = false;
			}

		}

		if (e.getKeyCode() == KeyEvent.VK_F) {

			MoisesP1.block = false;
			PhellipeP1.block = false;
			MaxuelP1.block = false;
			IvanildoP1.block = false;
			if (char1 == "ThaianyP1") {

				ThaianyP1.right = false;

			}
		}

		if (e.getKeyCode() == KeyEvent.VK_J) {

			if (gameState == "SELECAO") {

				selec.enter = false;
			}

			if (gameState == "TREINOSELECAO") {

				selecT.enter = false;
			}

		}

		if (e.getKeyCode() == KeyEvent.VK_O) {

			MaxuelP1.skillult = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_NUMPAD6) {

			MaxuelP2.skillult = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_NUMPAD0) {

			MoisesP2.block = false;
			PhellipeP2.block = false;

			if (char2 == "IvanildoP2") {
				IvanildoP2.block = false;

			}

			if (char2 == "MaxuelP2") {
				MaxuelP2.block = false;

			}

			if (char2 == "ThaianyP2") {
				ThaianyP2.block = false;

			}
		}

		if (e.getKeyCode() == KeyEvent.VK_J) {

		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {

			MoisesP2.down = false;

			if (PhellipeP2.attack3HAP == false) {
				PhellipeP2.down = false;

			}

			if (MaxuelP2.attack3HAP == false) {
				MaxuelP2.down = false;

			}

			if (IvanildoP2.attack3HAP == false) {
				IvanildoP2.down = false;

			}

			if (ThaianyP2.attack3HAP == false) {
				ThaianyP2.down = false;

			}
		}

		if (e.getKeyCode() == KeyEvent.VK_S) {

			MoisesP1.down = false;
			MoisesP1.downHAP = false;

			if (PhellipeP1.attack3HAP == false) {
				PhellipeP1.down = false;

			}

			if (MaxuelP1.attack3HAP == false) {

				MaxuelP1.down = false;

			}

			if (IvanildoP1.attack3HAP == false) {
				IvanildoP1.down = false;

			}

			if (ThaianyP1.attack3HAP == false) {
				ThaianyP1.down = false;

			}

			for (mirault mira : miras) {

				mira.downULT = false;

			}
		}

	}

}
