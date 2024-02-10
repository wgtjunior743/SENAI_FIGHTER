package items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import collisions.Box;
import entities.Entity;
import main.Game;
import world.Camera;

public class mirault extends Entity {

	public double speed = 2;

	public BufferedImage mira;

	public boolean rightULT;

	public boolean leftULT;

	public boolean upULT;

	public boolean downULT;
	
	public int xbrabo;
	
	public int positiony;

	public mirault(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);

		mira = Game.mira.getSprite(0, 0, 40, 40);

	}

	public void tick() {

		/*
		if (rightULT) {

			xbrabo = (int) x;
			
			xbrabo += speed;

			x = xbrabo;
		}

		if (leftULT) {

			x -= speed;
		}

		if (upULT) {

			y -= speed;
		}

		if (downULT) {

			y += speed;
		}

	*/
		
		
		if (Game.MaxuelP1.MAXULT == false&&Game.MaxuelP1.ult <= 0) {

			Game.miras.remove(this);

		}
		
		
	}

	public void render(Graphics g) {

		g.drawImage(mira, getX() - Camera.x, getY() + 100 - Camera.y, 40, 40, null);

	}
	
	

}
