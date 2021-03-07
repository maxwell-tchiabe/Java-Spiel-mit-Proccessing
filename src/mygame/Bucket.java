package mygame;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

public class Bucket implements DrawImage {
	
	String picture_path = "bucket.png";
	int place_y = 400;
	float time = 30;
	float x;
	float y;
	PImage image;
	
	Bucket(PImage h){
		image = h;
	}
	

	@Override
	public void drawing(PGraphics g) {
		g.image(image,x,y);
		
	}

	@Override
	public void update(PApplet p) {
		y= place_y; 
		x= p.mouseX;
		drawing(p.g);
		
	}
	
	public boolean iskollision(float kollision_x, float kollision_y) {
		float rand_x= x- (image.width/2);
		float rand_y= y- (image.height/2);
		
		if(kollision_x> rand_x && kollision_x< rand_x+image.width && kollision_y> rand_y && kollision_y< rand_y+image.height) {
			 return true; 
		}else {
			return false;
		}
	}
	
	


	

}
