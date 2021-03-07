package mygame;
 

import processing.sound.*;
import processing.core.PApplet;
import processing.core.PFont;

public class MyGame extends PApplet {

	public static void main(String[] args) {
		PApplet.runSketch(new String[] {""}, new MyGame());
		}
	SoundFile file;
	SoundFile coin;
	SoundFile hit;
	
	float window_large= 500;
	float start_y= -1000;
	float move = 3;
	
	float x;
	float y;
	
	
	int number_enemy=100;
	int number_gold=80;
	float point_x=25;
	float point_y=25;
	float time_x = 280;
	float time_y = 25;
	float timeEnd_x = 150;
	float timeEnd_y = 150;
	PFont zigBlack;
	
	
	
	
	
	 float time= 20;
	int point;
	Enemy[] enemyArray;
	Bucket bucket;
	Gold[] goldArray;
	//Gold gold;
	Background background;
	public void settings() {
		size(500,500);
	}
	public void setup() {
		
		file = new SoundFile(this,"venus.wav");
		coin = new SoundFile(this,"hit.wav");
		hit = new SoundFile(this,"coin.wav");
		file.loop();
		 size(500,500);
		 
		  zigBlack = createFont("Ziggurat-Black", 25);
		  textFont(zigBlack);
		  fill(0);
		
		
		
		noCursor();
		imageMode(CENTER);
		
		
		
		
		background = new Background(loadImage("GameCube - The Legend of Zelda Four Swords Adventures - Four Sword Sanctuary Portal Entrance.png"));
		bucket= new Bucket(loadImage("bucket.png"));
		goldArray = new Gold[number_gold];
		for(int i = 0; i<number_gold; i++ ) {
			goldArray[i]= new Gold(loadImage("coin_1.png"),this);
			
			
		}
		enemyArray = new Enemy[number_enemy];
		for(int i=0;i<number_enemy;i++) {
			enemyArray[i]= new Enemy(loadImage("wall_brick.png"),this);
		
		
		}
		point= 0;
		
	}
	public void draw() {
		
		
		background.drawing(this.g);
		bucket.update(this);
		
		if(time >0) {
		for(int i = 0; i<number_gold; i++ ) {
			goldArray[i].update(this);
			if(bucket.iskollision(goldArray[i].gibx(), goldArray[i].giby())) {
				goldArray[i].putGold(this);
				//goldArray[i].moving(this);
				point++;
				hit.play();
		}
		}
		
		for(int i = 0; i<number_enemy; i++ ) {
			enemyArray[i].update(this);
			if(bucket.iskollision(enemyArray[i].gibx(), enemyArray[i].giby())) {
				enemyArray[i].putEnemy(this);
				//enemyArray[i].moving(this);
				point -= 2;
				coin.play();
				
			}
		}
		fill(499,654,76);
		text("PUNKTE : "+point,point_x, point_y);
		
		putTime();
		text("ZEIT: "+ time,time_x, time_y);
		 
		 
		
		}else {
			text("GAME OVER  ",timeEnd_x, timeEnd_y);
			if (keyPressed) {
				if(keyCode== DOWN) {
					restart();
				}
				
				 
			}
			if(point<0) {
				text(" BAD PLAYER",150,180);
			} else {
				text(" gratulation: "+point+" GOLD gesammelt",60,180);
			}
		}
		
	}


		
		 

	public void putTime() {
		time = time - (1/ frameRate);
	}
	
	public void restart() {

		background.drawing(this.g);
		bucket.update(this);
		
		if(time >0) {
		for(int i = 0; i<number_gold; i++ ) {
			goldArray[i].update(this);
			if(bucket.iskollision(goldArray[i].gibx(), goldArray[i].giby())) {
				goldArray[i].putGold(this);
				//goldArray[i].moving(this);
				point++;
				hit.play();
		}
		}
		
		for(int i = 0; i<number_enemy; i++ ) {
			enemyArray[i].update(this);
			if(bucket.iskollision(enemyArray[i].gibx(), enemyArray[i].giby())) {
				enemyArray[i].putEnemy(this);
				//enemyArray[i].moving(this);
				point -= 2;
				hit.play();
				
			}
		}
		fill(499,654,76);
		text("PUNKTE : "+point,point_x, point_y);
		
		putTime();
		text("ZEIT: "+ time,time_x, time_y);
		 
		 
		
		}else {
			text("GAME OVER  ",timeEnd_x, timeEnd_y);
			if(point<0) {
				text(" BAD PLAYER",150,180);
			} else {
				text(" gratulation: "+point+" GOLD gesammelt",60,180);
			}
		}
	}
		
	
	
	
	
	
	
	}

	


