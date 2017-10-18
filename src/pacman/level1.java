package pacman;

import jig.ResourceManager;
import jig.Vector;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.HorizontalSplitTransition;
import org.newdawn.slick.tiled.TiledMap;







public class level1 extends BasicGameState {

	
	PacManGame pg;
	dots food = new dots();
	Energydot enrdot = new Energydot();
	float pacx=232;
	float pacy=424;
	int tileheight=16;
	int tilewidth=16;
	int currenttilex;
	int currenttiley;
	int nexttile;
	int key=0;
	float previousx=0;
	float previousy=0;
	int tileup=0;
	int tileleft=0;
	int tileright=0;
	int tiledown=0;
	int flag=0;
	int startingx=14;
	int startingy=23;
	int mazex=14;
	int mazey=23;
	int nextmazex=0;
	int nextmazey=0;
	int check;
	int countdown=500;
	int otherflag=0;
	int timer=18000;
	int desired=0;
	int current=0;
	int inkyflag=0;
	int pinkyflag=0;
	int clydeflag=0;
	int state=0;
	int scaredtimer=0;
	int scaredflag=0;
	int mazescared=0;
	int winstate=244;
	int fruittiley=17;
	int fruittilex=14;
	int fruittimer=25000;
	int fruit=0;
	//use render instead

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) {
		pg = (PacManGame)game;
		
		// currenttilex=(int) ((pg.pacman.getX()-8)/16);
		 //currenttiley=(int) ((pg.pacman.getY()-56)/16);
		 currenttilex=14;
		 currenttiley=23;
		
		container.setSoundOn(true);
		ResourceManager.getSound(PacManGame.Death_Death_RSC).stop();
		ResourceManager.getSound(PacManGame.Siren_Siren_RSC).loop();
		 pg.pacman.setX(232);
		 pacx=232;
		 pacy=424;
		 pg.pacman.setY(424);
		 
		 
		 //blinky stuff
		 pg.blinky.setX(232);
		 pg.blinky.blinkx=232;
		 pg.blinky.blinky=232;
		 pg.blinky.setY(232);
		 pg.blinky.currenttilex=14;
		 pg.blinky.currenttiley=11;
		 pg.blinky.state=0;
		 pg.blinky.nexttilex=0;
		 pg.blinky.nexttiley=0;
		 pg.blinky.check=0;
		 pg.blinky.desired=0;
		 pg.blinky.current=0;
		 pg.blinky.key=0;
		 
		 //inky stuff
		 pg.inky.setX(192);
		 pg.inky.inkx=192;
		 pg.inky.inky=280;
		 pg.inky.setY(280);
		 pg.inky.currenttilex=14;
		 pg.inky.currenttiley=11;
		 pg.inky.state=-1;
		 pg.inky.nexttilex=0;
		 pg.inky.nexttiley=0;
		 pg.inky.check=0;
		 pg.inky.desired=0;
		 pg.inky.current=0;
		 pg.inky.key=0;
		 pg.inky.outcount=88;
		 
		 //pinky stuff
		 pg.pinky.setX(224);
		 pg.pinky.pinkx=224;
		 pg.pinky.pinky=280;
		 pg.pinky.setY(280);
		 pg.pinky.currenttilex=14;
		 pg.pinky.currenttiley=11;
		 pg.pinky.state=-1;
		 pg.pinky.nexttilex=0;
		 pg.pinky.nexttiley=0;
		 pg.pinky.check=0;
		 pg.pinky.desired=0;
		 pg.pinky.current=0;
		 pg.pinky.key=0;
		 pg.pinky.outcount=56;
		 
		 //clyde stuff
		 pg.clyde.setX(256);
		 pg.clyde.clydex=256;
		 pg.clyde.clydey=280;
		 pg.clyde.setY(280);
		 pg.clyde.currenttilex=14;
		 pg.clyde.currenttiley=11;
		 pg.clyde.state=-1;
		 pg.clyde.nexttilex=0;
		 pg.clyde.nexttiley=0;
		 pg.clyde.check=0;
		 pg.clyde.desired=0;
		 pg.clyde.current=0;
		 pg.clyde.key=0;
		 pg.clyde.outcount=72;
		 


		 



		 
		//ResourceManager.getSound(PacManGame.Waka_Waka_RSC).loop();
		 
		 
		 //add all of blinkys and other ghost starting variables
			
			key=0;
			previousx=0;
			previousy=0;
			tileup=0;
			tileleft=0;
			tileright=0;
			tiledown=0;
			flag=0;
			startingx=14;
			startingy=23;
			mazex=14;
			mazey=23;
			nextmazex=0;
			nextmazey=0;
			check=0;
			countdown=500;
			otherflag=0;
			timer=18000;
			desired=0;
			current=0;
			inkyflag=0;
			pinkyflag=0;
			clydeflag=0;
			state=0;
			scaredtimer=0;
			scaredflag=0;
			mazescared=0;
			winstate=244;
			fruittiley=17;
			fruittilex=14;
			fruittimer=25000;
			fruit=0;
		
	}


	@Override
	public void render(GameContainer container, StateBasedGame game,
			Graphics g) throws SlickException {
		
		
		
		
		
		g.drawImage(ResourceManager.getImage(PacManGame.MAZE_MAZE_RSC),0, 48);	
	
		g.drawString("Score: " + pg.score, 310, 30);
		g.drawString("High Score: " + pg.scorearray[0], 16, 30);
		
		
		for(int i=0;i<31;i++){
			for(int z=0;z<28;z++){
				if(pg.maze[i][z]==0){
					
					food.dotani.getCurrentFrame().drawCentered((z * 16) +8,(i*16)+56);
					
					
				}
				
				if(pg.maze[i][z]==2){
					
					enrdot.enrani.getCurrentFrame().drawCentered((z * 16) +8,(i*16)+56);
					
				}
				
				if(pg.maze[i][z]==8){
					if(fruit==0){
						g.drawImage(ResourceManager.getImage(PacManGame.CH_CH_RSC),(z * 16) +8,(i*16)+50);
					}
					else if(fruit==1){
						g.drawImage(ResourceManager.getImage(PacManGame.PE_PE_RSC),(z * 16) +8,(i*16)+50);
					}
					else if(fruit==2){
						g.drawImage(ResourceManager.getImage(PacManGame.ST_ST_RSC),(z * 16) +8,(i*16)+50);
					}
					
					
					
				}
				
			}
		}
		
		
		
		
		
		pg.pacman.render(g);
		pg.blinky.render(g);
		pg.inky.render(g);
		pg.pinky.render(g);
		pg.clyde.render(g);
		
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game,
			int delta) throws SlickException {

		Input input = container.getInput();
		PacManGame pg = (PacManGame)game;
		
			
		
		currenttilex=(int) (((pg.pacman.getX())-8)/16);
		currenttiley=(int) ((pg.pacman.getY()-56)/16);
		
		tileup=currenttiley-1;
		tiledown=currenttiley+1;
		tileright=currenttilex+1;
		tileleft=currenttilex;
		
		if(mazex==pg.blinky.getblinkmazex() || mazex==pg.pinky.getPinkymazex() || mazex==pg.inky.getInkymazex() || mazex==pg.clyde.getPinkymazex()){
			if(mazey==pg.blinky.getblinkmazey() || mazey==pg.pinky.getPinkymazey() || mazey==pg.inky.getInkymazey() || mazey==pg.clyde.getPinkymazey()){
				pg.winx=pacx;
				pg.winy=pacy;
				pg.lives--;
				pg.enterState(PacManGame.GAMEOVERSTATE);
			}
		}
		
		
		if(input.isKeyPressed(Input.KEY_T) ){
			System.out.println(currenttilex +","+ currenttiley + " Maze element: "+ pg.maze[currenttiley][currenttilex]);
			System.out.println("LEFT"+ " Maze element: "+ pg.maze[currenttiley][currenttilex-1]);
			System.out.println("RIGHT"+ " Maze element: "+ pg.maze[currenttiley][currenttilex+1]);
			System.out.println("DOWN"+ " Maze element: "+ pg.maze[currenttiley+1][currenttilex]);
			System.out.println("UP"+ " Maze element: "+ pg.maze[currenttiley-1][currenttilex]);
			System.out.println("desired "+desired);
			System.out.println("current "+current);
		}
		
		
	
		if(state==0){
			
		//if((input.isKeyPressed(Input.KEY_W) || input.isKeyPressed(Input.KEY_UP) || key==1)  ){
		if((input.isKeyPressed(Input.KEY_W) || input.isKeyPressed(Input.KEY_UP) )  ){
			desired=1;
			System.out.println("W");
			this.move(desired);
		}
		else if(key==1){
			this.move(desired);
		}
			
			
		
		if((input.isKeyPressed(Input.KEY_S) || input.isKeyPressed(Input.KEY_DOWN) ) ){
			desired=2;
			System.out.println("S");
			this.move(desired);
		}
		else if(key==2){
			this.move(desired);
		}
			

		
		if((input.isKeyPressed(Input.KEY_A) || input.isKeyPressed(Input.KEY_LEFT) )  ){
			desired=3;
			System.out.println("A");
			this.move(desired);
			
		}
		else if(key==3){
			//System.out.println("A");
			this.move(desired);
		}
		
		if((input.isKeyPressed(Input.KEY_D) || input.isKeyPressed(Input.KEY_RIGHT)) ){
			desired=4;
			System.out.println("D");
			this.move(desired);
		}
		else if(key==4){
			this.move(desired);
		}
			
			
		}
		
		if(state==1){
			
			if(check>0){
				pacx-=1.6;
				check-=1;
				pg.pacman.setX(pacx);
				pg.maze[mazey][mazex]=-1;
				
				if(check==0 && mazescared == 0){
					if(ResourceManager.getSound(PacManGame.Waka_Waka_RSC).playing() == false){
						ResourceManager.getSound(PacManGame.Waka_Waka_RSC).play();
						
					}
					winstate--;
					pg.score+=10;
				}
				else if(check==0 && mazescared==2){
						
						scaredflag=1;
						ResourceManager.getSound(PacManGame.Siren_Siren_RSC).stop();
							ResourceManager.getSound(PacManGame.Scared_Scared_RSC).loop();
							
							System.out.println("HELP");
						
						if(ResourceManager.getSound(PacManGame.Waka_Waka_RSC).playing() == false){
							ResourceManager.getSound(PacManGame.Waka_Waka_RSC).play();
							
						}
						scaredtimer=4000;
						winstate--;
						pg.score+=50;
				}
				else if(check == 0 && mazescared==8){
					pg.score+=500;
				}
				
			}
			else{
				state=0;
				mazex=nextmazex;
			}
			
			
		}
		if(state==2){
			if(check>0){
				pacx+=1.6;
				check-=1;
				pg.pacman.setX(pacx);
				pg.maze[mazey][mazex]=-1;
				
				if(check==0 && mazescared == 0){
					if(ResourceManager.getSound(PacManGame.Waka_Waka_RSC).playing() == false){
						ResourceManager.getSound(PacManGame.Waka_Waka_RSC).play();
						
					}
					winstate--;
					pg.score+=10;
				}
				else if(check == 0 && mazescared == 2){
						
						scaredflag=1;
							ResourceManager.getSound(PacManGame.Siren_Siren_RSC).stop();
							ResourceManager.getSound(PacManGame.Scared_Scared_RSC).loop();
							
							//System.out.println("HELP");
						
						if(ResourceManager.getSound(PacManGame.Waka_Waka_RSC).playing() == false){
							ResourceManager.getSound(PacManGame.Waka_Waka_RSC).play();
							
						}
						scaredtimer=4000;
						winstate--;
						pg.score+=50;
				}
				else if(check == 0 && mazescared==8){
					pg.score+=500;
				}
			}
			else{
				state=0;
				mazex=nextmazex;
			}
		}
		if(state==3){
			if(check>0){
				pacy-=1.6;
				check-=1;
				pg.pacman.setY(pacy);
				pg.maze[mazey][mazex]=-1;
				
				if(check==0 && mazescared==0){
					if(ResourceManager.getSound(PacManGame.Waka_Waka_RSC).playing() == false){
						ResourceManager.getSound(PacManGame.Waka_Waka_RSC).play();
						
					}
					winstate--;
					pg.score+=10;
				}
				else if(check==0 && mazescared==2){
						
						scaredflag=1;
						ResourceManager.getSound(PacManGame.Siren_Siren_RSC).stop();
							ResourceManager.getSound(PacManGame.Scared_Scared_RSC).loop();
							
							//System.out.println("HELP");
					
						if(ResourceManager.getSound(PacManGame.Waka_Waka_RSC).playing() == false){
							ResourceManager.getSound(PacManGame.Waka_Waka_RSC).play();
							}
						scaredtimer=4000;
						winstate--;
						pg.score+=50;
				}
				else if(check == 0 && mazescared==8){
					pg.score+=500;
				}
			}
			else{
				state=0;
				mazey=nextmazey;
			}
		}
		if(state==4){
			
			if(check>0){
				pacy+=1.6;
				check-=1;
				pg.pacman.setY(pacy);
				pg.maze[mazey][mazex]=-1;
				
				if(check==0 && mazescared==0){
					
					if(ResourceManager.getSound(PacManGame.Waka_Waka_RSC).playing() == false){
						ResourceManager.getSound(PacManGame.Waka_Waka_RSC).play();
						
					}
					winstate--;
					pg.score+=10;
				}
				else if(check==0 && mazescared==2){
						
						scaredflag=1;
						ResourceManager.getSound(PacManGame.Siren_Siren_RSC).stop();
							ResourceManager.getSound(PacManGame.Scared_Scared_RSC).loop();
							
							//System.out.println("HELP");
						
						if(ResourceManager.getSound(PacManGame.Waka_Waka_RSC).playing() == false){
							ResourceManager.getSound(PacManGame.Waka_Waka_RSC).play();
							
						}
						scaredtimer=4000;
						winstate--;
						pg.score+=50;
				}
				else if(check == 0 && mazescared==8){
					pg.score+=500;
				}
			}
			else{
				state=0;
				mazey=nextmazey;
			}
			
			
		}
		
		
		
		
		
		
		pg.blinky.choice(mazex, mazey, pg);
		
		timer -=delta;
		if(timer<12000){
			pg.inky.movefromhome(pg);
			inkyflag=1;
		}
		
		if(inkyflag==1){
			pg.inky.choice(mazex, mazey, pg);
		}
		
		if(timer<6000){
			pg.pinky.movefromhome(pg);
			pinkyflag=1;
		}
		
		if(pinkyflag==1){
			pg.pinky.choice(mazex, mazey, pg);
		}
		
		if(timer < 0){
			pg.clyde.movefromhome(pg);
			clydeflag=1;
		}
		
		if(clydeflag==1){
			pg.clyde.choice(mazex, mazey, pg);
		}
		
		
		scaredtimer-=delta;
		//System.out.println(scaredtimer + "," +scaredflag);
		if(scaredtimer<0 && scaredflag==1){
			ResourceManager.getSound(PacManGame.Scared_Scared_RSC).stop();
			ResourceManager.getSound(PacManGame.Siren_Siren_RSC).loop();
			scaredflag=0;
			//mazescared=0;
			
		}
		
		if(winstate==0){
			pg.winx=pacx;
			pg.winy=pacy;
			this.winstate();
		}
		
		fruittimer-=delta;
		if(fruittimer<0){
			if(pg.maze[fruittiley][fruittilex]==3){
				pg.maze[fruittiley][fruittilex]=8;
				fruittimer=10000;
			}else{
				pg.maze[fruittiley][fruittilex]=3;
				fruit++;
				if(fruit==3)
					fruit=0;
				
				fruittimer=25000;
			}
		}

	}
	
	public void move(int desired){
				
		
		if(desired==3){
			if(pg.maze[mazey][mazex-1]!=1){
				state=1;
				mazescared = pg.maze[mazey][mazex-1];
				nextmazex=mazex-1;
				nextmazey=mazey;
				key=3;
				check=10;
				current=3;
				return;
			}
			else if(current==3){
				key=0;
				return;
			}
			return;
		}
		
		if(desired==1){
			if(pg.maze[mazey-1][mazex]!=1){
				state=3;
				mazescared = pg.maze[mazey-1][mazex];
				nextmazex=mazex;
				nextmazey=mazey-1;
				key=1;
				check=10;
				current=1;
				return;
			}
			else if(current==1){
				key=0;
				return;
			}
			
			return;
		}
		
		if(desired==2){
			if(pg.maze[mazey+1][mazex]!=1){
				state=4;
				mazescared = pg.maze[mazey+1][mazex];
				nextmazex=mazex;
				nextmazey=mazey+1;
				key=2;
				check=10;
				current=2;
				return;
			}
			else if(current==2){
				key=0;
				return;
			}
			return;
		}
		
		if(desired==4){
			if(pg.maze[mazey][mazex+1]!=1){
				state=2;
				mazescared = pg.maze[mazey][mazex+1];
				nextmazex=mazex+1;
				nextmazey=mazey;
				key=4;
				check=10;
				current=4;
				return;
			}
			else if(current==4){
				key=0;
				return;
			}
			return;
		}
		return;
	}
	
	public void winstate(){
		pg.enterState(PacManGame.WINSTATE);
	}
	


	@Override
	public int getID() {
		return PacManGame.LEVEL1;
	}
	
}

