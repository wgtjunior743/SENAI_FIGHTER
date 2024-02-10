package entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.Game;
import world.Camera;



public class Entity {
	
	protected double x;
	public double y;
	protected int width;
	protected int height;
	protected BufferedImage sprite;


	public Entity(int x, int y, int width, int height, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprite = sprite;

	

	}



	public void setX(int newX) {
		this.x = newX;
	}

	public void setY(int newY) {
		this.y = newY;
	}

	public int getX() {

		return (int) this.x;

	}

	public int getY() {

		return (int) this.y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void tick() {
	
		
	}

	

	public void render(Graphics g) {

		// COM CAMERA

		g.drawImage(sprite, this.getX() - Camera.x, this.getY() - Camera.y, null);

		// VER O TAMANHO DA HITBOx
		// g.setColor(Color.red);
		// g.fillRect(this.getX() + maskx - Camera.x,this.getY() + masky -Camera.y,
		// mwidth, mheight);

		// SEM CAMERA

		/*
		 * g.drawImage(sprite, this.getX(), this.getY() ,null);
		 */
	}

}
