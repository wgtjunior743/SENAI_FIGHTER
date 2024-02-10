package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.Game;

public class TREINOSELECAO {

	public String[] options = new String[5];

	public int currentOption = 0;

	public int maxOption;

	public static boolean TREINOATIVADO = false;

	public static boolean player1 = false;

	public boolean right, left;

	public static boolean enter;

	public boolean right2, left2, enter2;

	public static boolean stop1 = false;

	public static boolean stop2 = false;

	public static boolean space;

	public static boolean selec = false, finalselec = false, finalselecconfir = false;

	public void optionselec() {

		if (!selec) {

			maxOption = 5 - 1;

			options[0] = "personagem1";
			options[1] = "personagem2";
			options[2] = "personagem3";
			options[3] = "personagem4";
			options[4] = "personagem5";

		}

	}

	public void tick() {

		optionselec();

		if (left) {
			left = false;
			currentOption--;
			if (currentOption < 0)
				currentOption = maxOption;
		}
		if (right) {
			right = false;
			currentOption++;
			if (currentOption > maxOption)
				currentOption = 0;
		}

		if (enter) {

			if (options[currentOption] == "personagem1") {

				Game.char1 = "PhellipeP1";
				TREINOATIVADO = true;
				Game.gameState = "TREINO";
				enter = false;
				player1 = true;

			}

			if (options[currentOption] == "personagem2") {

				Game.char1 = "IvanildoP1";
				TREINOATIVADO = true;
				Game.gameState = "TREINO";
				enter = false;
				player1 = true;

			}

			if (options[currentOption] == "personagem3") {

				Game.char1 = "ThaianyP1";
				TREINOATIVADO = true;
				Game.gameState = "TREINO";
				enter = false;
				player1 = true;

			}

			if (options[currentOption] == "personagem4") {

				Game.char1 = "MaxuelP1";
				TREINOATIVADO = true;
				Game.gameState = "TREINO";
				enter = false;
				player1 = true;

			}

			if (options[currentOption] == "personagem5") {

				Game.char1 = "MoisesP1";
				Game.gameState = "TREINO";
				TREINOATIVADO = true;
				enter = false;
				player1 = true;

			}

		}

	}

	public void render(Graphics g) {

		/*
		 * 
		 * g.drawString("P1", 50, 400); g.drawString("P2", 750, 400);
		 */

		if (!selec || !finalselecconfir) {

			g.drawImage(Game.fundoselecao.getSprite(0, 0, 900, 600), 0, 0, null, null);

			g.drawImage(Game.selecaopersonagem.getSprite(0, 0, 550, 100), 150, 325, null, null);

			g.setColor(Color.white);
			g.setFont(new Font("arial", Font.BOLD, 24));
			g.drawString("P1", 50, 175);
			g.drawString("P2", 750, 175);

			g.drawString("Treinador", 750, 215);

			g.drawImage(Game.spritesheetboneco.getSprite(25, 170, 50, 90), 750, 228, null, null);

			// CURRENT OPTION 1

			if (options[currentOption] == "personagem1") {
				g.drawImage(Game.selecaoamarelo.getSprite(0, 0, 100, 100), 155, 325, null, null);

				g.drawImage(Game.spritesheet2.getSprite(2, 2, 39, 76), 50, 242, null, null);
				g.setFont(new Font("arial", Font.BOLD, 25));
				g.drawString("Phillipe", 50, 225);
			}
			if (options[currentOption] == "personagem2") {

				g.drawImage(Game.selecaoamarelo.getSprite(0, 0, 100, 100), 265, 325, null, null);
				g.drawImage(Game.ivanildo.getSprite(30, 1655, 70, 110), 40, 231, null, null);
				g.setFont(new Font("arial", Font.BOLD, 25));
				g.drawString("Ivanildo", 50, 225);
			}

			if (options[currentOption] == "personagem3") {
				g.drawImage(Game.selecaoamarelo.getSprite(0, 0, 100, 100), 375, 325, null, null);

				g.drawImage(Game.thaiany.getSprite(29, 1560, 41, 90), 55, 231, null, null);
				g.setFont(new Font("arial", Font.BOLD, 25));
				g.drawString("Thaiany", 50, 225);
			}

			if (options[currentOption] == "personagem4") {
				g.drawImage(Game.selecaoamarelo.getSprite(0, 0, 100, 100), 485, 325, null, null);
				g.drawString("Maxuel", 50, 220);
				g.drawImage(Game.spritesheet3.getSprite(29, 1165, 75, 110), 32, 232, null, null);
			}

			if (options[currentOption] == "personagem5") {
				g.drawImage(Game.selecaoamarelo.getSprite(0, 0, 100, 100), 595, 325, null, null);
				g.setFont(new Font("arial", Font.BOLD, 25));
				g.drawString("Moisés", 50, 225);

				g.drawImage(Game.spritesheet.getSprite(22, 141, 56, 80), 50, 238, null, null);
				// g.drawImage
			}

			// CURRENT OPTION 2

		}

	}

}
