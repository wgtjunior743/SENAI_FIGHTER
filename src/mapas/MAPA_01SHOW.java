package mapas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import items.pc;
import main.Game;
import menus.SELECAO;

public class MAPA_01SHOW {

	public void render(Graphics g, Graphics g2) {
		Graphics2D g21 = (Graphics2D) g;

		Game.PhellipeP1.up = false;
		Game.PhellipeP2.up = false;
		Game.MoisesP1.up = false;
		Game.MoisesP2.up = false;

		SELECAO.selec = false;

		Game.parede01.Draw(g);
		Game.parede02.Draw(g);
		Game.chao01.Draw(g);

		// g.drawImage(Game.mapa01.getMAPA_01_FUNDO(0, 0, Game.WIDTH * Game.SCALE, 500),
		// 0, 0, null, null);
		// g.drawImage(Game.mapa01.getMAPA_01_CHAO(0, 0, Game.WIDTH * Game.SCALE, 300),
		// 0, +475, null, null);

		g.drawImage(Game.MAPAPRIMEIRO.getSprite(0, 0, 900, 600), 0, 0, null, null);

		if (Game.char1 == "MoisesP1" && Game.MoisesP1.dead == false) {

			Game.MoisesP1.render(g);

		}

		if (Game.char2 == "MoisesP2" && Game.MoisesP2.dead == false) {

			Game.MoisesP2.render(g);

		}

		if (Game.char1 == "PhellipeP1" && Game.PhellipeP1.dead == false) {

			Game.PhellipeP1.render(g);
		}

		if (Game.char2 == "PhellipeP2" && Game.PhellipeP2.dead == false) {

			Game.PhellipeP2.render(g);

		}

		if (Game.char1 == "MaxuelP1" && Game.MaxuelP1.dead == false) {

			Game.MaxuelP1.render(g);

		}

		if (Game.char2 == "MaxuelP2" && Game.MaxuelP2.dead == false) {

			Game.MaxuelP2.render(g);

		}

		if (Game.char1 == "IvanildoP1" && Game.IvanildoP1.dead == false) {

			Game.IvanildoP1.render(g);

		}

		if (Game.char2 == "IvanildoP2" && Game.IvanildoP2.dead == false) {

			Game.IvanildoP2.render(g);

		}

		if (Game.char1 == "ThaianyP1" && Game.ThaianyP1.dead == false) {

			Game.ThaianyP1.render(g);

		}

		if (Game.char2 == "ThaianyP2" && Game.ThaianyP2.dead == false) {

			Game.ThaianyP2.render(g);

		}

		if (Game.MoisesP1wins == true) {
			if (Game.showWinMessage == true) {
				Font font = new Font("Arial", Font.BOLD, 50);
				g.setFont(font);
				g.setColor(Color.BLACK);
				g.drawString("Moises P1 WINS!", 320, 200);
			}

		}

		if (Game.MoisesP2wins == true) {
			if (Game.showWinMessage == true) {
				Font font = new Font("Arial", Font.BOLD, 50);
				g.setFont(font);
				g.setColor(Color.BLACK);
				g.drawString("Moises P2 WINS!", 320, 200);
			}

		}

		if (Game.PhellipeP1wins == true) {

			if (Game.showWinMessage == true) {
				Font font = new Font("Arial", Font.BOLD, 50);
				g.setFont(font);
				g.setColor(Color.BLACK);
				g.drawString("Phellipe P1 WINS!", 320, 200);
			}

		}

		if (Game.PhellipeP2wins == true) {

			if (Game.showWinMessage == true) {

				Font font = new Font("Arial", Font.BOLD, 50);
				g.setFont(font);
				g.setColor(Color.BLACK);
				g.drawString("Phellipe P2 WINS!", 320, 200);
			}

		}

		if (Game.MoisesP1.START == true || Game.MoisesP2.START == true || Game.PhellipeP1.START == true
				|| Game.PhellipeP2.START == true) {

			Font font = new Font("Arial", Font.BOLD, 50);
			g.setFont(font);
			g.setColor(Color.BLACK);

			if (Game.countdown > 0) {
				g.drawString(String.valueOf(Game.countdown), 400, 200);
			} else if (Game.showFightMessage) {
				g.drawString("LUTEM!", 345, 200);
			}

		}

		if (Game.char2 == "IvanildoP2") {

			Game.ui.renderPlayerIV2(g);
		}
		
		if (Game.char2 == "ThaianyP2") {

			Game.ui.renderPlayerTH2(g);
		}
		
		if (Game.char2 == "MaxuelP2") {

			Game.ui.renderPlayerMAX2(g);
		}

		if (Game.char2 == "MoisesP2") {

			Game.ui.renderPlayerMOI2(g);
		}

		if (Game.char2 == "PhellipeP2") {

			Game.ui.renderPlayerPH2(g);
		}

		if (Game.char1 == "ThaianyP1") {

			Game.ui.renderPlayerTH1(g);

		}
		
		if (Game.char1 == "IvanildoP1") {

			Game.ui.renderPlayerIV1(g);

		}

		if (Game.char1 == "MaxuelP1") {

			Game.ui.renderPlayerMAX1(g);

		}

		if (Game.char1 == "MoisesP1") {

			Game.ui.renderPlayerMOI1(g);

		}

		if (Game.char1 == "PhellipeP1") {

			Game.ui.renderPlayerPH1(g);

		}

	}

}
