package mygame;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

public class Gold implements DrawImage {
	String picture_path= "coin_1.png";
	float window_large= 500;
	float start_y= -1000;
	float move = 3;
	
	float x;
	float y;
	PImage bild;
	PApplet g;
	
	Gold(PImage h,PApplet p){
		bild = h;
	putGold(p);
		
      }
	public void putGold(PApplet p) {
		x= p.random(window_large);
		y= p.random(start_y);
		//drawing(p.g);
	}

	
	public void moving(PApplet p) {
		y=y+move;
		if(y>window_large) {
			putGold(p);
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
		g.image(bild, x,y);
		
	}
	@Override
	public void update(PApplet p) {
		drawing(p.g);
		moving(p);
		
	}
	
		
	

}
