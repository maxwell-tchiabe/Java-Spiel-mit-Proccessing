package mygame;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

public class Enemy  implements DrawImage{
	String picture_path= "wall_brick.png";
	float window_large= 500;
	float start_y= -1000;
	float move= 3;
	float x;
	float y;
	PImage image;
	PApplet g;
	
	Enemy(PImage h,PApplet p){
		image = h;
		putEnemy(p);
	
      }
	public void putEnemy(PApplet g) {
		x= g.random(window_large);
		y= g.random(start_y);
		//drawing(g.g);
	}
	
	
	public void moving(PApplet p) {
		y=y+move;
		if(y>500) {
			putEnemy(p);
		}
	}
	public float gibx() {
		return x;
	}
	public float giby() {
		return y;
	}
	
		
	
	@Override
	public void drawing(PGraphics g) {
		g.image(image, x,y);
		
	}
	@Override
	public void update(PApplet p) {
		drawing(p.g);
		moving(p);
		
	}

}
