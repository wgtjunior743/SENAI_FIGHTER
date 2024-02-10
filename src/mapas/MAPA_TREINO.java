package mapas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import items.pc;
import main.Game;
import menus.SELECAO;

public class MAPA_TREINO {

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

		g.drawImage(Game.mapa01.getMAPA_01_FUNDO(0, 0, Game.WIDTH * Game.SCALE, 500), 0, 0, null, null);
		g.drawImage(Game.mapa01.getMAPA_01_CHAO(0, 0, Game.WIDTH * Game.SCALE, 300), 0, +475, null, null);

		Game.trainer.render(g);

		if (Game.char1 == "MoisesP1") {

			Game.MoisesP1.render(g);

		}

		if (Game.char1 == "PhellipeP1") {

			Game.PhellipeP1.render(g);

		}
		
		Game.ui.renderPorrada(g);

		if (Game.char1 == "MoisesP1") {

			Game.ui.renderPlayerMOI1(g);

		}

		if (Game.char1 == "PhellipeP1") {

			Game.ui.renderPlayerPH1(g);

		}

		if (Game.char1 == "MaxuelP1") {

			Game.MaxuelP1.render(g);

		}
		
		if (Game.char1 == "IvanildoP1") {

			Game.IvanildoP1.render(g);

		}
		
		if (Game.char1 == "ThaianyP1") {

			Game.ThaianyP1.render(g);

		}


		if (Game.char1 == "MaxuelP1") {

			Game.ui.renderPlayerMAX1(g);

		}
		
		if (Game.char1 == "IvanildoP1") {

			Game.ui.renderPlayerIV1(g);

		}
		
		if (Game.char1 == "ThaianyP1") {

			Game.ui.renderPlayerTH1(g);

		}
		
	

	}

}
