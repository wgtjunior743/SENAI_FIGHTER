package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import entities.Ivanildo;
import entities.Maxuel;
import entities.Moises;
import entities.Phellipe;
import entities.SacoDeBrunnada;
import entities.Thaiany;
import main.Game;
import net.coobird.thumbnailator.Thumbnails;

public class Menus {

	public static String[] options = new String[5];

	public BufferedImage[] jogarbotao = new BufferedImage[2];
	public BufferedImage[] treinarbotao = new BufferedImage[2];
	public BufferedImage[] opcaobotao = new BufferedImage[2];
	public BufferedImage[] creditobotao = new BufferedImage[2];
	public BufferedImage[] sairbotao = new BufferedImage[2];

	public BufferedImage[] creditos = new BufferedImage[2];

	public BufferedImage[] continuarbotao = new BufferedImage[2];
	public BufferedImage[] controlesbotao = new BufferedImage[2];
	public BufferedImage[] menubotao = new BufferedImage[2];
	public BufferedImage[] voltarbotao = new BufferedImage[2];

	public int currentOption = 0;
	public int maxOption = 3 - 1;

	public boolean creditoSHOW = false;

	BufferedImage image;
	public boolean up, down, enter;

	public boolean controlesSHOW = false;

	private boolean part1 = true;

	private boolean part2 = false;

	private boolean creditoSHOWBACK;

	private boolean part1on;

	private boolean part2on;

	public boolean space;

	private boolean change;

	public static boolean pause = false;

	public void pause() {

		if (pause == false) {

			maxOption = 5 - 1;
			options[0] = "novo jogo";
			options[1] = "treino";
			options[2] = "opções";
			options[3] = "credito";
			options[4] = "sair";

		} else if (pause == true) {

			maxOption = 3 - 1;

			options[0] = "continuar";
			options[1] = "controles";
			options[2] = "sairmenu";

		}

		if (pause == true && controlesSHOW) {

			maxOption = 0;

			options[0] = "voltar";

		}

	}

	public void tick() {

		pause();

		if (up) {
			up = false;
			currentOption--;
			if (currentOption < 0)
				currentOption = maxOption;
		}
		if (down) {
			down = false;
			currentOption++;
			if (currentOption > maxOption)
				currentOption = 0;
		}

		if (creditoSHOW) {

			if (space && !part2) {
				space = false;
				part2 = true;
			}

			if (space && part2) {
				space = false;
				part1 = true;
				part2 = false;
			}

		}

		if (enter)

		{
			enter = false;
			if (options[currentOption] == "treino") {
				Game.gameState = "TREINOSELECAO";
				up = false;
			}

			if (options[currentOption] == "credito") {
				creditoSHOW = true;
				up = false;
			}

			if (options[currentOption] == "novo jogo") {
				Game.gameState = "SELECAO";
				up = false;
			} else if (options[currentOption] == "continuar" && Game.selecT.TREINOATIVADO == false) {
				Game.gameState = "MAPA_01SHOW";
				up = false;

			} else if (options[currentOption] == "continuar" && Game.selecT.TREINOATIVADO == true) {
				Game.gameState = "TREINO";
				up = false;

			} else if (options[currentOption] == "controles") {
				controlesSHOW = true;
				down = true;

			} else if (options[currentOption] == "voltar") {
				controlesSHOW = false;
			} else if (options[currentOption] == "sair") {
				System.exit(1);
			} else if (options[currentOption] == "sairmenu") {
				SELECAO.finalselecconfir = false;
				SELECAO.finalselec = false;
				SELECAO.space = false;
				SELECAO.enter = false;
				Game.char1 = "";
				Game.char2 = "";
				Game.countdown = 4;
				pause = false;
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
				
				Game.MaxuelP1 = new Maxuel(0, 50, 70, 95, Game.spritesheet3.getSprite(35, 1153, 70, 95));
				Game.MaxuelP2 = new Maxuel(160, 50, 70, 95, Game.spritesheet3.getSprite(35, 1153, 70, 95));

				Game.MoisesP1 = new Moises(0, 50, 53, 80, Game.spritesheet.getSprite(32, 0, 53, 80));
				Game.PhellipeP1 = new Phellipe(0, 50, 30, 76, Game.spritesheet2.getSprite(0, 0, 30, 76));

				Game.MoisesP2 = new Moises(160, 50, 53, 80, Game.spritesheet.getSprite(32, 0, 53, 80));
				Game.PhellipeP2 = new Phellipe(160, 50, 30, 76, Game.spritesheet2.getSprite(0, 0, 30, 76));
	

				
				Game.MoisesP1.dead = false;
				Game.PhellipeP2.dead = false;
				Game.MoisesP2.dead = false;
				Game.PhellipeP1.dead = false;
				
				Game.countdownwins = 0;
				Game.showFightMessage = true;

			}

		}
	}

	public void render(Graphics g) throws IOException {

		jogarbotao[0] = Game.jogarbotao.getSprite(0, 0, 72, 25);
		jogarbotao[1] = Game.jogarbotao.getSprite(72, 0, 72, 25);

		treinarbotao[0] = Game.treinobotao.getSprite(0, 0, 72, 25);
		treinarbotao[1] = Game.treinobotao.getSprite(72, 0, 72, 25);

		opcaobotao[0] = Game.opcaobotao.getSprite(0, 0, 72, 25);
		opcaobotao[1] = Game.opcaobotao.getSprite(72, 0, 72, 25);

		creditobotao[0] = Game.creditobotao.getSprite(0, 0, 72, 25);
		creditobotao[1] = Game.creditobotao.getSprite(72, 0, 72, 25);

		sairbotao[0] = Game.sairbotao.getSprite(0, 0, 72, 25);
		sairbotao[1] = Game.sairbotao.getSprite(72, 0, 72, 25);

		// creditos[0] = Game.creditos.getSprite(0, 0, 900, 600);
		// creditos[1] = Game.creditos.getSprite(900, 0, 900, 600);

		continuarbotao[0] = Game.continuarbutao.getSprite(0, 0, 144, 25);
		continuarbotao[1] = Game.continuarbutao.getSprite(144, 0, 144, 25);

		controlesbotao[0] = Game.controlebutao.getSprite(0, 0, 144, 25);
		controlesbotao[1] = Game.controlebutao.getSprite(144, 0, 144, 25);

		menubotao[0] = Game.menubutao.getSprite(0, 0, 144, 25);
		menubotao[1] = Game.menubutao.getSprite(144, 0, 144, 25);

		voltarbotao[0] = Game.voltarbutao.getSprite(0, 0, 144, 25);
		voltarbotao[1] = Game.voltarbutao.getSprite(144, 0, 144, 25);

		if (pause == false && !creditoSHOW) {

			// g.drawImage(resize(Game.FundoImage.getSprite(0, 0, 1000,
			// 1000),900,600),0,0,null,null);

			g.drawImage(Game.FundoImage.getSprite(0, 0, 900, 600), 0, 0, null, null);

			// NOME DO GAME
			g.drawImage(Game.TituloImage.getSprite(0, 0, 200, 200), 250, -50, 450, 450, null, null);

		} else if (pause == true) {

			g.drawImage(Game.continuarfundo.getSprite(0, 0, 900, 600), 0, 0, null, null);

		}

		// OPÇÕES
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.BOLD, 24));
		if (pause == false && !creditoSHOW) {

			// g.drawString("Jogar", (Game.WIDTH * Game.SCALE) / 2 - 50, 350);

			g.drawImage(jogarbotao[1], (Game.WIDTH * Game.SCALE) / 2 - 50, 325, 100, 25, null);

			// g.drawString("Treinar", (Game.WIDTH * Game.SCALE) / 2 - 50, 400);

			g.drawImage(treinarbotao[1], (Game.WIDTH * Game.SCALE) / 2 - 50, 375, 100, 25, null);

			// g.drawString("Opções", (Game.WIDTH * Game.SCALE) / 2 - 50, 450);

			g.drawImage(opcaobotao[1], (Game.WIDTH * Game.SCALE) / 2 - 50, 425, 100, 25, null);

			// g.drawString("Sair", (Game.WIDTH * Game.SCALE) / 2 - 40, 500);
			g.drawImage(creditobotao[1], (Game.WIDTH * Game.SCALE) / 2 - 50, 475, 100, 25, null);

			g.drawImage(sairbotao[1], (Game.WIDTH * Game.SCALE) / 2 - 50, 525, 100, 25, null);
		}

		if (pause && !controlesSHOW) {

			g.drawImage(continuarbotao[1], (Game.WIDTH * Game.SCALE) / 2 - 80, 150, null);

			g.drawImage(controlesbotao[1], (Game.WIDTH * Game.SCALE) / 2 - 80, 300, null);

			g.drawImage(menubotao[1], (Game.WIDTH * Game.SCALE) / 2 - 80, 450, null);

			// g.drawString("Continuar", (Game.WIDTH * Game.SCALE) / 2 - 50, 150);
			// g.drawString("Controles", (Game.WIDTH * Game.SCALE) / 2 - 50, 200);
			// g.drawString("Sair para o menu", (Game.WIDTH * Game.SCALE) / 2 - 20, 250);
		}

		if (pause == false && !creditoSHOW) {

			// g.drawString("Treinar", (Game.WIDTH * Game.SCALE) / 2 - 50, 400);

			// g.drawString("Opções", (Game.WIDTH * Game.SCALE) / 2 - 50, 450);

			// g.drawString("Sair", (Game.WIDTH * Game.SCALE) / 2 - 40, 500);

			if (options[currentOption] == "novo jogo") {
				g.drawImage(jogarbotao[0], (Game.WIDTH * Game.SCALE) / 2 - 50, 325, 100, 25, null);
			} else if (options[currentOption] == "treino")
				g.drawImage(treinarbotao[0], (Game.WIDTH * Game.SCALE) / 2 - 50, 375, 100, 25, null);
			else if (options[currentOption] == "opções") {
				g.drawImage(opcaobotao[0], (Game.WIDTH * Game.SCALE) / 2 - 50, 425, 100, 25, null);
			} else if (options[currentOption] == "credito") {
				g.drawImage(creditobotao[0], (Game.WIDTH * Game.SCALE) / 2 - 50, 475, 100, 25, null);
			} else if (options[currentOption] == "sair") {
				g.drawImage(sairbotao[0], (Game.WIDTH * Game.SCALE) / 2 - 50, 525, 100, 25, null);
			}
		} else if (pause && !controlesSHOW) {

			if (options[currentOption] == "continuar") {
				g.drawImage(continuarbotao[0], (Game.WIDTH * Game.SCALE) / 2 - 80, 150, null);
			} else if (options[currentOption] == "controles") {
				g.drawImage(controlesbotao[0], (Game.WIDTH * Game.SCALE) / 2 - 80, 300, null);
			} else if (options[currentOption] == "sairmenu") {
				g.drawImage(menubotao[0], (Game.WIDTH * Game.SCALE) / 2 - 80, 450, null);
			}
		}

		if (creditoSHOW) {

			if (part1) {
				g.drawImage(Game.creditos1.getSprite(0, 0, 900, 600), 0, 0, null, null);

			}

			if (part2) {

				g.drawImage(Game.creditos2.getSprite(0, 0, 900, 600), 0, 0, null, null);
			}

		}

		if (controlesSHOW) {

			if (options[currentOption] == "voltar") {

				g.drawImage(voltarbotao[0], (Game.WIDTH * Game.SCALE) / 2 - 90, 475, null);

				// g.drawString(">", (Game.WIDTH * Game.SCALE) / 2 - 90, 500);
			}
		}

		if (controlesSHOW) {

			g.drawImage(Game.controles1.getSprite(0, 0, 144, 144), 500, 200, 200, 200, null, null);

			g.drawImage(Game.controles2.getSprite(0, 0, 144, 144), 175, 200, 200, 200, null, null);

		}

	}

}
