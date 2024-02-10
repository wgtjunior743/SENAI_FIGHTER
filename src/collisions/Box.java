package collisions;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Box extends Rectangle{
	

	Color color;
	
	public Box(int x, int y, int width, int height, Color color){
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		
		
	}
	
	
	public void Draw(Graphics g) {
		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.width, this.height);
		
	}
	
	public void DrawRect(Graphics g) {
		g.drawRect(this.x, this.y, this.width, this.height);
		
	}

	public void refresh() {
		
		
	}
	
}
