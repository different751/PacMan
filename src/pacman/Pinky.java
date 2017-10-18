package pacman;



import jig.Entity;
import jig.ResourceManager;
import jig.Vector;

import org.newdawn.slick.Animation;






/**
 * A class representing a transient explosion. The game should monitor
 * explosions to determine when they are no longer active and remove/hide
 * them at that point.
 */
class Pinky extends Entity {
	public Animation inkani;
	public int countdown;
	public int state=-1;
	public Vector velocity;
	public int nexttile;
	public int currenttilex=14;
	public int currenttiley=11;
	public int nexttilex=0;
	public int nexttiley=0;
	public int check=0;
	public float pinkx=232;
	public float pinky=280;
	public int desired=0;
	public int current=0;
	public int key=0;
	public int outcount=49;

	public Pinky(final float x, final float y) {
		super(x,y);
		inkani = new Animation(ResourceManager.getSpriteSheet(PacManGame.PL_PL_RSC, 28, 28),100);
		addAnimation(inkani);
		inkani.setLooping(true);
		//addImageWithBoundingBox(ResourceManager.getImage(PacManGame.PACMAN_PACMAN_RSC));
		countdown=0;
		//ResourceManager.getSound(BounceGame.BANG_EXPLOSIONSND_RSC).play();
	}

	
	public void choice(int mazex, int mazey, PacManGame pg){
		//System.out.println("SDLFSLDKFJ");
		if(state==0){
			
		
			 if(currenttilex < mazex){
				//move right
				
				desired =4;
				this.move(pg);
			}
			 
			 if(currenttiley < mazey){
				//move down
					desired =2;
					this.move(pg);
			 }
			 
		
			  if(currenttilex > mazex){
				//move left
					desired=3;
					this.move(pg);
	
			}
			 if(currenttiley> mazey){
				//move up
				  
					desired=1;
					this.move(pg);
				
			}
		}
		
		if(state==1){
			
			if(check>0){
				pinkx-=1.6;
				check-=1;
				pg.pinky.setX(pinkx);
			}
			else{
				state=0;
				currenttilex=nexttilex;
			}
			
			
		}
		if(state==2){
			if(check>0){
				pinkx+=1.6;
				check-=1;
				pg.pinky.setX(pinkx);
			}
			else{
				state=0;
				currenttilex=nexttilex;
			}
		}
		if(state==3){
			if(check>0){
				pinky-=1.6;
				check-=1;
				pg.pinky.setY(pinky);
			}
			else{
				state=0;
				currenttiley=nexttiley;
			}
		}
		if(state==4){
			
			if(check>0){
				pinky+=1.6;
				check-=1;
				pg.pinky.setY(pinky);
			}
			else{
				state=0;
				currenttiley=nexttiley;
			}
		}
		
	}
	
	private void move(PacManGame pg){
		if(desired==3){
			if(pg.maze[currenttiley][currenttilex-1]!=1){
				state=1;
				nexttilex=currenttilex-1;
				nexttiley=currenttiley;
				key=3;
				check=10;
				current=3;
				return;
			}
			else if(current==3){
				//state=3;
				return;
			}
			return;
		}
		
		if(desired==1){
			if(pg.maze[currenttiley-1][currenttilex]!=1){
				state=3;
				nexttilex=currenttilex;
				nexttiley=currenttiley-1;
				key=1;
				check=10;
				current=1;
				return;
			}
			else if(current==1){
				//state=0;
				return;
			}
			
			return;
		}
		
		if(desired==2){
			if(pg.maze[currenttiley+1][currenttilex]!=1){
				state=4;
				nexttilex=currenttilex;
				nexttiley=currenttiley+1;
				key=2;
				check=10;
				current=2;
				return;
			}
			else if(current==2){
				//state=0;
				return;
			}
			return;
		}
		
		if(desired==4){
			if(pg.maze[currenttiley][currenttilex+1]!=1){
				state=2;
				nexttilex=currenttilex+1;
				nexttiley=currenttiley;
				key=4;
				check=10;
				current=4;
				return;
			}
			else if(current==4){
				//state=0;
				return;
			}
			return;
		}
		return;
	}
	
	public void movefromhome(PacManGame pg){
		if(outcount>0){
			if(outcount>48){
			pinkx+=1;
			outcount-=1;
			pg.pinky.setX(pinkx);
			}
			else{
				pinky-=1;
				outcount-=1;
				pg.pinky.setY(pinky);
			}
		}
		else if(state==-1){
			state=0;
		}
		
	}
	
	
	public int getPinkymazex(){
		return(currenttilex);
	}
	
	public int getPinkymazey(){
		return(currenttiley);
	}
	
	public void update(final int delta) {
		translate(velocity.scale(delta));
		
	}
	
}

