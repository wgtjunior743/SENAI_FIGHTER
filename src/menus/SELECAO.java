package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.Game;

public class SELECAO {

	public String[] options = new String[5];

	public String[] options2 = new String[5];

	public int currentOption = 0;
	public int currentOption2 = 0;
	public int maxOption;

	public int maxOption2 = options2.length - 1;

	public static boolean player1 = false;

	public static boolean player2 = false;

	public boolean right, left;

	public static boolean enter;

	public boolean right2, left2, enter2;

	public static boolean stop1 = false;

	public static boolean stop2 = false;

	public static boolean space;

	public static boolean selec = false, finalselec = false, finalselecconfir = false;

	public static boolean PH1 = false, PH2 = false, MOI1 = false, MOI2 = false, IV1 = false, IV2 = false, TH1 = false,
			TH2 = false, MX1 = false, MX2 = false;

	public void optionselec() {

		if (!selec) {

			maxOption = 5 - 1;

			options[0] = "personagem1";
			options[1] = "personagem2";
			options[2] = "personagem3";
			options[3] = "personagem4";
			options[4] = "personagem5";

			options2[0] = "personagem1";
			options2[1] = "personagem2";
			options2[2] = "personagem3";
			options2[3] = "personagem4";
			options2[4] = "personagem5";

		} 
		
		
		if (selec) {

			maxOption = 3 - 1;
			options[0] = "mapa1";
			options[1] = "mapa2";
			options[2] = "mapa3";

			

		}
		
		if(selec && !finalselecconfir) {
			
			currentOption = 0;
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

		if (left2) {
			left2 = false;
			currentOption2--;
			if (currentOption2 < 0)
				currentOption2 = maxOption2;
		}
		if (right2) {
			right2 = false;
			currentOption2++;
			if (currentOption2 > maxOption2)
				currentOption2 = 0;
		}

		if (enter) {

			if (options[currentOption] == "personagem1" && !PH2) {

				stop1 = true;
				Game.char1 = "PhellipeP1";
				PH1 = true;
				enter = false;
				player1 = true;

			}

			if (options[currentOption] == "personagem2" && !IV2) {

				stop1 = true;
				Game.char1 = "IvanildoP1";
				IV1 = true;
				enter = false;
				player1 = true;

			}

			if (options[currentOption] == "personagem3" && !TH2) {

				stop1 = true;
				Game.char1 = "ThaianyP1";
				TH1 = true;
				enter = false;
				player1 = true;

			}

			if (options[currentOption] == "personagem4" && !MX2) {

				stop1 = true;
				Game.char1 = "MaxuelP1";
				MX1 = true;
				enter = false;
				player1 = true;

			}

			if (options[currentOption] == "personagem5" && !MOI2) {
				stop1 = true;
				Game.char1 = "MoisesP1";
				MOI1 = true;
				enter = false;
				player1 = true;

			}

		}

		if (enter2) {
			if (options2[currentOption2] == "personagem1" && !PH1) {
				stop2 = true;
				Game.char2 = "PhellipeP2";
				PH2 = true;
				enter2 = false;
				player2 = true;
			}

			if (options2[currentOption2] == "personagem2" && !IV1) {
				stop2 = true;
				Game.char2 = "IvanildoP2";
				IV2 = true;
				enter2 = false;
				player2 = true;
			}
			
			if (options2[currentOption2] == "personagem3" && !TH1) {
				stop2 = true;
				Game.char2 = "ThaianyP2";
				TH2 = true;
				enter2 = false;
				player2 = true;
			}

			if (options2[currentOption2] == "personagem4" && !MX1) {

				stop2 = true;
				Game.char2 = "MaxuelP2";
				MX2 = true;
				enter2 = false;
				player2 = true;

			}

			

			if (options2[currentOption2] == "personagem5" && !MOI1) {
				stop2 = true;
				Game.char2 = "MoisesP2";
				MOI2 = true;
				enter2 = false;
				player2 = true;
			}
		}
		if (player1 && player2) {

			selec = true;

		}

		if (selec) {

			if (space) {

				finalselecconfir = true;
			}

		}

		if (finalselecconfir) {

			stop1 = false;
			stop2 = false;

			if (enter && options[currentOption] == "mapa1") {
				Game.gameState = "MAPA_01SHOW";
				selec = false;
			}

			if (enter && options[currentOption] == "mapa2") {
				enter = false;

			}

			if (enter && options[currentOption] == "mapa3") {
				enter = false;

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

			g.drawImage(Game.selecaopersonagem.getSprite(0, 0, 550, 100), 150, 475, null, null);

			g.setColor(Color.white);
			g.setFont(new Font("arial", Font.BOLD, 24));
			g.drawString("P1", 50, 175);
			g.drawString("P2", 750, 175);

			// CURRENT OPTION 1

			if (options[currentOption] == "personagem1" && !selec) {
				g.drawImage(Game.selecaoamarelo.getSprite(0, 0, 100, 100), 155, 325, null, null);

				g.drawImage(Game.spritesheet2.getSprite(2, 2, 39, 76), 50, 242, null, null);
				g.setFont(new Font("arial", Font.BOLD, 25));
				g.drawString("Phillipe", 50, 225);
			}
			if (options[currentOption] == "personagem2"  && !selec) {

				g.drawImage(Game.selecaoamarelo.getSprite(0, 0, 100, 100), 265, 325, null, null);
				g.drawImage(Game.ivanildo.getSprite(30, 1655, 70, 110), 40, 231, null, null);
				g.setFont(new Font("arial", Font.BOLD, 25));
				g.drawString("Ivanildo", 50, 225);

			}

			if (options[currentOption] == "personagem3"  && !selec) {
				g.drawImage(Game.selecaoamarelo.getSprite(0, 0, 100, 100), 375, 325, null, null);
				g.drawImage(Game.thaiany.getSprite(29, 1560, 41, 90), 55, 232, null, null);
				g.setFont(new Font("arial", Font.BOLD, 25));
				g.drawString("Thaiany", 50, 225);
			}

			if (options[currentOption] == "personagem4"  && !selec) {
				g.drawImage(Game.selecaoamarelo.getSprite(0, 0, 100, 100), 485, 325, null, null);
				g.drawString("Maxuel", 50, 220);
				g.drawImage(Game.spritesheet3.getSprite(29, 1165, 75, 110), 32, 232, null, null);

			}

			if (options[currentOption] == "personagem5"  && !selec) {
				g.drawImage(Game.selecaoamarelo.getSprite(0, 0, 100, 100), 595, 325, null, null);
				g.setFont(new Font("arial", Font.BOLD, 25));
				g.drawString("Moisés", 50, 225);

				g.drawImage(Game.spritesheet.getSprite(22, 141, 56, 80), 50, 238, null, null);
				// g.drawImage
			}

			// CURRENT OPTION 2

			if (options[currentOption2] == "personagem1"  && !selec) {
				g.drawImage(Game.selecaovermelho.getSprite(0, 0, 100, 100), 155, 475, null, null);

				g.setFont(new Font("arial", Font.BOLD, 25));
				g.drawString("Phillipe", 750, 225);
				g.drawImage(Game.spritesheet2.getSprite(2, 82, 39, 76), 785, 242, null, null);

			}
			if (options[currentOption2] == "personagem2"  && !selec) {

				g.drawImage(Game.selecaovermelho.getSprite(0, 0, 100, 100), 265, 475, null, null);
				g.drawImage(Game.ivanildo.getSprite(99, 1780, 70, 110), 770, 214, null, null);
				g.setFont(new Font("arial", Font.BOLD, 25));
				g.drawString("Ivanildo", 750, 225);

			}

			if (options[currentOption2] == "personagem3"  && !selec) {
				g.drawImage(Game.selecaovermelho.getSprite(0, 0, 100, 100), 375, 475, null, null);
				g.drawImage(Game.thaiany.getSprite(70, 1420, 41, 90), 775, 232, null, null);
				g.setFont(new Font("arial", Font.BOLD, 25));
				g.drawString("Thaiany", 750, 225);
			}

			if (options[currentOption2] == "personagem4"  && !selec) {
				g.drawImage(Game.selecaovermelho.getSprite(0, 0, 100, 100), 485, 475, null, null);
				g.drawImage(Game.spritesheet3.getSprite(108, 1424, 75, 110), 772, 221, null, null);
				g.setFont(new Font("arial", Font.BOLD, 25));
				g.drawString("Maxuel", 750, 225);

			}

			if (options[currentOption2] == "personagem5"  && !selec) {
				g.drawImage(Game.selecaovermelho.getSprite(0, 0, 100, 100), 595, 475, null, null);
				g.setFont(new Font("arial", Font.BOLD, 25));
				g.drawString("Moisés", 750, 225);
				g.drawImage(Game.spritesheet.getSprite(22, 20, 56, 80), 770, 238, null, null);
				// g.drawImage

			}

			if (selec) {

				if (Game.char1 == "PhellipeP1") {

					g.drawImage(Game.selecaoamarelo.getSprite(0, 0, 100, 100), 155, 325, null, null);

					g.drawImage(Game.spritesheet2.getSprite(2, 2, 39, 76), 50, 242, null, null);
					g.setFont(new Font("arial", Font.BOLD, 25));
					g.drawString("Phillipe", 50, 225);
				}

				if (Game.char1 == "MoisesP1") {
					g.drawImage(Game.selecaoamarelo.getSprite(0, 0, 100, 100), 595, 325, null, null);
					g.setFont(new Font("arial", Font.BOLD, 25));
					g.drawString("Moisés", 50, 225);

					g.drawImage(Game.spritesheet.getSprite(22, 141, 56, 80), 50, 238, null, null);
				}

				if (Game.char2 == "PhellipeP2") {
					g.drawImage(Game.selecaovermelho.getSprite(0, 0, 100, 100), 155, 475, null, null);
					g.setFont(new Font("arial", Font.BOLD, 25));
					g.drawString("Phillipe", 750, 225);
					g.drawImage(Game.spritesheet2.getSprite(2, 82, 39, 76), 785, 242, null, null);

				}

				if (Game.char2 == "MoisesP2") {

					g.drawImage(Game.selecaovermelho.getSprite(0, 0, 100, 100), 595, 475, null, null);
					g.setFont(new Font("arial", Font.BOLD, 25));
					g.drawString("Moisés", 750, 225);
					g.drawImage(Game.spritesheet.getSprite(22, 20, 56, 80), 770, 238, null, null);
				}

				if (Game.char1 == "MaxuelP1") {

					g.drawImage(Game.selecaoamarelo.getSprite(0, 0, 100, 100), 485, 325, null, null);
					g.setFont(new Font("arial", Font.BOLD, 25));
					g.drawString("Maxuel", 50, 220);
					g.drawImage(Game.spritesheet3.getSprite(29, 1165, 75, 110), 32, 232, null, null);
				}
				
				if (Game.char2 == "MaxuelP2") {

					g.drawImage(Game.selecaovermelho.getSprite(0, 0, 100, 100), 485, 475, null, null);
					g.drawImage(Game.spritesheet3.getSprite(108, 1424, 75, 110), 772, 221, null, null);
					g.setFont(new Font("arial", Font.BOLD, 25));
					g.drawString("Maxuel", 750, 225);
				}


	
				if (Game.char1 == "IvanildoP1") {

					g.drawImage(Game.selecaoamarelo.getSprite(0, 0, 100, 100), 265, 325, null, null);
					g.drawImage(Game.ivanildo.getSprite(30, 1655, 70, 110), 40, 231, null, null);
					g.setFont(new Font("arial", Font.BOLD, 25));
					g.drawString("Ivanildo", 50, 225);
				}

				if (Game.char1 == "ThaianyP1") {

					g.drawImage(Game.selecaoamarelo.getSprite(0, 0, 100, 100), 375, 325, null, null);
					g.drawImage(Game.thaiany.getSprite(29, 1560, 41, 90), 55, 232, null, null);
					g.setFont(new Font("arial", Font.BOLD, 25));
					g.drawString("Thaiany", 50, 225);
				}

				

				if (Game.char2 == "IvanildoP2") {

					
					g.drawImage(Game.selecaovermelho.getSprite(0, 0, 100, 100), 265, 475, null, null);
					g.drawImage(Game.ivanildo.getSprite(99, 1780, 70, 110), 770, 214, null, null);
					g.setFont(new Font("arial", Font.BOLD, 25));
					g.drawString("Ivanildo", 750, 225);
				}

				if (Game.char2 == "ThaianyP2") {

					g.drawImage(Game.selecaovermelho.getSprite(0, 0, 100, 100), 375, 475, null, null);
					g.drawImage(Game.thaiany.getSprite(70, 1420, 41, 90), 775, 232, null, null);
					g.setFont(new Font("arial", Font.BOLD, 25));
					g.drawString("Thaiany", 750, 225);
					
				}

				g.setFont(new Font("arial", Font.BOLD, 30));
				g.drawString("APERTE ESPAÇO SE DESEJA FINALIZAR A SELEÇÃO", 50, 320);

			}

		} else if (selec && finalselecconfir) {

			g.drawImage(Game.fundoselecaomapa.getSprite(0, 0, 900, 600), 0, 0, null, null);

			g.setColor(Color.white);
			g.setFont(new Font("arial", Font.BOLD, 30));
			g.drawString("Escolha o mapa", 300, 50);

			g.setColor(Color.white);
			g.fillRect(200, 100, 100, 100);
			g.drawImage(Game.Mapa01Icon.getIcon(0, 0, 100, 100), 200, 100, null, null);

			g.setColor(Color.white);
			g.fillRect(400, 100, 100, 100);

			g.setColor(Color.white);
			g.fillRect(600, 100, 100, 100);

			if (options[currentOption] == "mapa1") {
				g.drawString(">", 180, 150);
			}

			if (options[currentOption] == "mapa2") {
				g.drawString(">", 380, 150);
			}

			if (options[currentOption] == "mapa3") {
				g.drawString(">", 580, 150);
			}

		}
	}

}
