package mygame;
import processing.core.PGraphics;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

public class Background   {
	String picture_path= "GameCube.jpg" ;
	PImage background ;
	
    
	
    Background(PImage h ){
		background = h;
    }
	
		
		
	
	public void drawing(PGraphics g ) {
		
		g.image(background ,250,250,g.width+20,g.height+20);


		
	
	}
}
