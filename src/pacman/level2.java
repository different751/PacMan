package pacman;



import jig.ResourceManager;
import jig.Vector;

import java.util.ArrayList;
import java.util.Random;

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







public class level2 extends BasicGameState {

	
	PacManGame pg;
	dots food = new dots();
	Energydot enrdot = new Energydot();
	float pacx=232;
	float pacy=456;
	int currentkey=3;
	int previouskey=0;
	int tileheight=16;
	int tilewidth=16;
	int currenttilex;
	int currenttiley;
	int nexttile;
	int key=3;
	float previousx=0;
	float previousy=0;
	int tileup=0;
	int tileleft=0;
	int tileright=0;
	int tiledown=0;
	int flag=0;
	int startingx=14;
	int startingy=25;
	int mazex=14;
	int mazey=25;
	int nextmazex=0;
	int nextmazey=0;
	int check;
	int countdown=500;
	int otherflag=0;
	int timer=26000;
	int desired=0;
	int current=0;
	int inkyflag=0;
	int pinkyflag=0;
	int clydeflag=0;
	int state=0;
	int scaredtimer=0;
	int scaredflag=0;
	int mazescared=0;
	//int winstate=251;
	int fruittiley=17;
	int fruittilex=14;
	int fruittimer=25000;
	int fruit=0;
	int secondcheck=-1;
	int wrapflag=0;
	int fruitcounter=0;
	int statecounter=30000;
	int blinkystateflag=0;
	int inkystateflag=0;
	int pinkystateflag=0;
	int clydestateflag=0;
	int blinkydeadflag=0;
	int inkydeadflag=0;
	int pinkydeadflag=0;
	int clydedeadflag=0;
	int animationrightflag=0;
	int animationleftflag=0;
	int animationupflag=0;
	int animationdownflag=0;
	int removeflaginky=0;
	int removeflagclyde=0;
	int removeflagblinky=0;
	int removeflagpinky=0;
	
	
	Random rand = new Random();
	//use render instead

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) {
		pg = (PacManGame)game;
		
		// currenttilex=(int) ((pg.pacman2.getX()-8)/16);
		 //currenttiley=(int) ((pg.pacman2.getY()-56)/16);
		 currenttilex=14;
		 currenttiley=25;
		
		container.setSoundOn(true);
		ResourceManager.getSound(PacManGame.Waka_Waka_RSC).stop();
		ResourceManager.getSound(PacManGame.Siren_Siren_RSC).stop();
		ResourceManager.getSound(PacManGame.Scared_Scared_RSC).stop();
		ResourceManager.getSound(PacManGame.Death_Death_RSC).stop();
		ResourceManager.getSound(PacManGame.Death_Death_RSC).stop();
		ResourceManager.getSound(PacManGame.Siren_Siren_RSC).loop();
		 pg.pacman2.setX(232);
		 pacx=232;
		 pacy=456;
		 pg.pacman2.setY(456);
		 pg.pacman.PacManAni.restart();
		 
		 
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
		 


		 



		 
		//ResourceManager.getSound(pacman2Game.Waka_Waka_RSC).loop();
		 
		 
		 //add all of blinkys and other ghost starting variables
			
			key=3;
			previousx=0;
			previousy=0;
			tileup=0;
			tileleft=0;
			tileright=0;
			tiledown=0;
			flag=0;
			startingx=14;
			startingy=25;
			mazex=14;
			mazey=25;
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
			//winstate=320;
			fruittiley=17;
			fruittilex=14;
			fruittimer=25000;
			fruit=0;
			
			
			blinkystateflag=0;
			inkystateflag=0;
			pinkystateflag=0;
			clydestateflag=0;
			statecounter=30000;
			blinkydeadflag=0;
			inkydeadflag=0;
			pinkydeadflag=0;
			clydedeadflag=0;
			animationrightflag=0;
			animationleftflag=0;
			animationupflag=0;
			animationdownflag=0;
			removeflaginky=0;
			removeflagclyde=0;
			removeflagblinky=0;
			removeflagpinky=0;
			
			
			pg.blinky.removeAnimation(pg.blinky.Blinkdead);
			pg.blinky.removeAnimation(pg.blinky.Blinkscared);
			pg.blinky.removeAnimation(pg.blinky.Blinkright);
			pg.blinky.removeAnimation(pg.blinky.Blinkup);
			pg.blinky.removeAnimation(pg.blinky.Blinkani);
			pg.blinky.removeAnimation(pg.blinky.Blinkdown);
			pg.clyde.removeAnimation(pg.clyde.clydedead);
			pg.clyde.removeAnimation(pg.clyde.clydescared);
			pg.clyde.removeAnimation(pg.clyde.clyderight);
			pg.clyde.removeAnimation(pg.clyde.clydeup);
			pg.clyde.removeAnimation(pg.clyde.clydeani);
			pg.clyde.removeAnimation(pg.clyde.clydedown);
			pg.inky.removeAnimation(pg.inky.inkdead);
			pg.inky.removeAnimation(pg.inky.inkscared);
			pg.inky.removeAnimation(pg.inky.inkright);
			pg.inky.removeAnimation(pg.inky.inkup);
			pg.inky.removeAnimation(pg.inky.inkani);
			pg.inky.removeAnimation(pg.inky.inkdown);
			pg.pinky.removeAnimation(pg.pinky.pinkdead);
			pg.pinky.removeAnimation(pg.pinky.pinkscared);
			pg.pinky.removeAnimation(pg.pinky.pinkright);
			pg.pinky.removeAnimation(pg.pinky.pinkup);
			pg.pinky.removeAnimation(pg.pinky.pinkani);
			pg.pinky.removeAnimation(pg.pinky.pinkdown);
			pg.inky.addAnimation(pg.inky.inkani);
			pg.pinky.addAnimation(pg.pinky.pinkani);
			pg.clyde.addAnimation(pg.clyde.clydeani);
			pg.inky.deadflag=0;
			pg.pinky.deadflag=0;
			pg.clyde.deadflag=0;
			pg.blinky.deadflag=0;
			pg.previouskey=0;
			pg.nextkey=0;
			
		
	}


	@Override
	public void render(GameContainer container, StateBasedGame game,
			Graphics g) throws SlickException {
		
		
		
		
		
		g.drawImage(ResourceManager.getImage(PacManGame.lv2_lv2_RSC),0, 48);	
	
		g.drawString("Score: " + pg.score, 310, 30);
		g.drawString("High Score: " + pg.scorearray[0], 16, 30);
		
		
		for(int i=0;i<31;i++){
			for(int z=0;z<28;z++){
				if(pg.maze2[i][z]==0){
					
					food.dotani.getCurrentFrame().drawCentered((z * 16) +8,(i*16)+56);
					
					
				}
				
				if(pg.maze2[i][z]==2){
					
					enrdot.enrani.getCurrentFrame().drawCentered((z * 16) +8,(i*16)+56);
					
				}
				
				if(pg.maze2[i][z]==8){
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
		
		for(int i=1; i<pg.lives;i++){
			g.drawImage(ResourceManager.getImage(PacManGame.LIVE_LIVE_RSC),(i*32)-24 , 545);
		}
		
		
		
		
		pg.pacman2.render(g);
		
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
		
		pg.currentlevel=2;
		//System.out.println(winstate);
		
		currenttilex=(int) (((pg.pacman2.getX())-8)/16);
		currenttiley=(int) ((pg.pacman2.getY()-56)/16);
		
		tileup=currenttiley-1;
		tiledown=currenttiley+1;
		tileright=currenttilex+1;
		tileleft=currenttilex;
		
		if(pg.score>3000 && pg.livesflag==0){
			pg.lives++;
			pg.livesflag=1;
		}
		
		if(mazex==pg.blinky.getblinkmazex()){
			if(mazey==pg.blinky.getblinkmazey() ){
				if(scaredflag==1){
					if(blinkydeadflag==0){
						pg.score+=300;
						ResourceManager.getSound(PacManGame.GDS_GDS_RSC).play();
					}
					blinkydeadflag=1;
					pg.blinky.scaredflag=0;
					pg.blinky.deadflag=1;
					
				}else{
				pg.winx=pacx;
				pg.winy=pacy;
				pg.lives--;
				pg.enterState(PacManGame.GAMEOVERSTATE);
				}
			}
				
		}
		
		if(mazex==pg.clyde.getclydemazex()){
			if(mazey==pg.clyde.getclydemazey() ){
				if(scaredflag==1){
					if(clydedeadflag==0){
						pg.score+=300;
						ResourceManager.getSound(PacManGame.GDS_GDS_RSC).play();
					}
					clydedeadflag=1;
					pg.clyde.scaredflag=0;
					pg.clyde.deadflag=1;
					
				}else{
					pg.winx=pacx;
					pg.winy=pacy;
					pg.lives--;
					pg.enterState(PacManGame.GAMEOVERSTATE);
				}
			}
		}
		
		if(mazex==pg.pinky.getPinkymazex()){
			if(mazey==pg.pinky.getPinkymazey() ){
				if(scaredflag==1){
					if(pinkydeadflag==0){
						pg.score+=300;
						ResourceManager.getSound(PacManGame.GDS_GDS_RSC).play();
					}
					pinkydeadflag=1;
					pg.pinky.scaredflag=0;
					pg.pinky.deadflag=1;
					
				}else{
					pg.winx=pacx;
					pg.winy=pacy;
					pg.lives--;
					pg.enterState(PacManGame.GAMEOVERSTATE);
				}
			}
		}
		
		if(mazex==pg.inky.getInkymazex()){
			if(mazey==pg.inky.getInkymazey() ){
				if(scaredflag==1){
					if(inkydeadflag==0){
						pg.score+=300;
						ResourceManager.getSound(PacManGame.GDS_GDS_RSC).play();
					}
					inkydeadflag=1;
					pg.inky.scaredflag=0;
					pg.inky.deadflag=1;
				}else{
					pg.winx=pacx;
					pg.winy=pacy;
					pg.lives--;
					pg.enterState(PacManGame.GAMEOVERSTATE);
				}
			}
		}
		
		
		//System.out.println(key);
		
		
	
		if(state==0){
		//if((input.isKeyPressed(Input.KEY_W) || input.isKeyPressed(Input.KEY_UP) || key==1)  ){
		if((input.isKeyPressed(Input.KEY_W) || input.isKeyPressed(Input.KEY_UP) || pg.nextkey==1)  ){
			//desired=1;
			//key=1;
			pg.nextkey=1;
	
			System.out.println("W");
			this.move(1);
		}
		else if(key==1){
			this.move(1);
		}

			
			
		
		if((input.isKeyPressed(Input.KEY_S) || input.isKeyPressed(Input.KEY_DOWN)|| pg.nextkey==2) ){
			//desired=2;
			//key=2;
			pg.nextkey=2;
			
			System.out.println("S");
			this.move(2);
		}
		else if(key==2){
			this.move(2);
		}
		
			

		
		if((input.isKeyPressed(Input.KEY_A) || input.isKeyPressed(Input.KEY_LEFT)||pg.nextkey==3)  ){
			//desired=3;
			//key=3;
			pg.nextkey=3;
			
			System.out.println("A");
			this.move(3);
			
		}
		else if(key==3){
			this.move(3);
		}
		
		
		if((input.isKeyPressed(Input.KEY_D) || input.isKeyPressed(Input.KEY_RIGHT)||pg.nextkey==4 ) ){
			pg.nextkey=4;
			System.out.println("D");
			this.move(4);
		}
		else if(key==4){
			this.move(4);
		}
		
			
		}
		
		if (input.isKeyDown(Input.KEY_N))
			game.enterState(PacManGame.LEVEL1, new EmptyTransition(), new HorizontalSplitTransition() );
		
		if(input.isKeyDown(Input.KEY_ESCAPE))
			game.enterState(PacManGame.MENU, new EmptyTransition(), new HorizontalSplitTransition() );
		
		if(state==1){
			
			if(check>0){
				pacx-=1.6;
				check-=1;
				pg.pacman2.setX(pacx);
				pg.maze2[mazey][mazex]=-1;
				
				if(check==0 && mazescared == 0){
					if(ResourceManager.getSound(PacManGame.Waka_Waka_RSC).playing() == false){
						ResourceManager.getSound(PacManGame.Waka_Waka_RSC).play();
						
					}
					pg.winstatelvl2--;
					pg.score+=10;
				}
				else if(check==0 && mazescared==2){
						
						scaredflag=1;
						pg.blinky.scaredflag=1;
						pg.clyde.scaredflag=1;
						pg.inky.scaredflag=1;
						pg.pinky.scaredflag=1;
						ResourceManager.getSound(PacManGame.Siren_Siren_RSC).stop();
						if(ResourceManager.getSound(PacManGame.Scared_Scared_RSC).playing()==false)
							ResourceManager.getSound(PacManGame.Scared_Scared_RSC).loop();
							
							System.out.println("HELP");
						
						if(ResourceManager.getSound(PacManGame.Waka_Waka_RSC).playing() == false){
							ResourceManager.getSound(PacManGame.Waka_Waka_RSC).play();
							
						}
						scaredtimer=4000;
						pg.winstatelvl2--;
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
				pg.pacman2.setX(pacx);
				pg.maze2[mazey][mazex]=-1;
				
				if(check==0 && mazescared == 0){
					if(ResourceManager.getSound(PacManGame.Waka_Waka_RSC).playing() == false){
						ResourceManager.getSound(PacManGame.Waka_Waka_RSC).play();
						
					}
					pg.winstatelvl2--;
					pg.score+=10;
				}
				else if(check == 0 && mazescared == 2){
						
						scaredflag=1;
						pg.blinky.scaredflag=1;
						pg.clyde.scaredflag=1;
						pg.inky.scaredflag=1;
						pg.pinky.scaredflag=1;
							ResourceManager.getSound(PacManGame.Siren_Siren_RSC).stop();
							if(ResourceManager.getSound(PacManGame.Scared_Scared_RSC).playing()==false)
							ResourceManager.getSound(PacManGame.Scared_Scared_RSC).loop();
							
							//System.out.println("HELP");
						
						if(ResourceManager.getSound(PacManGame.Waka_Waka_RSC).playing() == false){
							ResourceManager.getSound(PacManGame.Waka_Waka_RSC).play();
							
						}
						scaredtimer=4000;
						pg.winstatelvl2--;
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
				pg.pacman2.setY(pacy);
				pg.maze2[mazey][mazex]=-1;
				
				if(check==0 && mazescared==0){
					if(ResourceManager.getSound(PacManGame.Waka_Waka_RSC).playing() == false){
						ResourceManager.getSound(PacManGame.Waka_Waka_RSC).play();
						
					}
					pg.winstatelvl2--;
					pg.score+=10;
				}
				else if(check==0 && mazescared==2){
						
						scaredflag=1;
						pg.blinky.scaredflag=1;
						pg.clyde.scaredflag=1;
						pg.inky.scaredflag=1;
						pg.pinky.scaredflag=1;
						ResourceManager.getSound(PacManGame.Siren_Siren_RSC).stop();
						if(ResourceManager.getSound(PacManGame.Scared_Scared_RSC).playing()==false)
							ResourceManager.getSound(PacManGame.Scared_Scared_RSC).loop();
							
							//System.out.println("HELP");
					
						if(ResourceManager.getSound(PacManGame.Waka_Waka_RSC).playing() == false){
							ResourceManager.getSound(PacManGame.Waka_Waka_RSC).play();
							}
						scaredtimer=4000;
						pg.winstatelvl2--;
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
				pg.pacman2.setY(pacy);
				pg.maze2[mazey][mazex]=-1;
				
				if(check==0 && mazescared==0){
					
					if(ResourceManager.getSound(PacManGame.Waka_Waka_RSC).playing() == false){
						ResourceManager.getSound(PacManGame.Waka_Waka_RSC).play();
						
					}
					pg.winstatelvl2--;
					pg.score+=10;
				}
				else if(check==0 && mazescared==2){
						
						scaredflag=1;
						pg.blinky.scaredflag=1;
						pg.clyde.scaredflag=1;
						pg.inky.scaredflag=1;
						pg.pinky.scaredflag=1;
						ResourceManager.getSound(PacManGame.Siren_Siren_RSC).stop();
						if(ResourceManager.getSound(PacManGame.Scared_Scared_RSC).playing()==false)
							ResourceManager.getSound(PacManGame.Scared_Scared_RSC).loop();
							
							//System.out.println("HELP");
						
						if(ResourceManager.getSound(PacManGame.Waka_Waka_RSC).playing() == false){
							ResourceManager.getSound(PacManGame.Waka_Waka_RSC).play();
							
						}
						scaredtimer=4000;
						pg.winstatelvl2--;
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
		
		if(state==5){
			if(check>0){
				System.out.println("HERE");
				pacx+=1.6;
				check-=1;
				pg.pacman2.setX(pacx);
				mazex=2;
				mazey=14;
			}
			else if(check<=0 && wrapflag ==0){
				System.out.println("HERE2");
				pg.pacman2.setX(0);
				pacx=0;
				secondcheck=25;
				wrapflag=1;
			}
			
			if(secondcheck>0){
				System.out.println("HERE3");
				pacx+=1.6;
				secondcheck-=1;
				pg.pacman2.setX(pacx);
			}
			else if(secondcheck<=0 && wrapflag==1){
				mazex=2;
				mazey=14;
				state=0;
			}
			
		}
		if(state==6){
			if(check>0){
				System.out.println("HERE");
				pacx-=1.6;
				check-=1;
				pg.pacman2.setX(pacx);
				mazex=25;
				mazey=14;
			}
			else if(check<=0 && wrapflag ==0){
				System.out.println("HERE2");
				pg.pacman2.setX(0);
				pacx=448;
				secondcheck=25;
				wrapflag=1;
			}
			
			if(secondcheck>0){
				System.out.println("HERE3");
				pacx-=1.6;
				secondcheck-=1;
				pg.pacman2.setX(pacx);
			}
			else if(secondcheck<=0 && wrapflag==1){
				mazex=25;
				mazey=14;
				state=0;
			}
		}
		
		
		
		
		
		
		statecounter-=delta;
		if(statecounter>10000 && scaredflag==0 && blinkydeadflag==0){
			pg.blinky.choice2(mazex, mazey, pg);
		}
		
		if( statecounter<=10000 && blinkystateflag==0 && scaredflag==0 && blinkydeadflag==0){
				pg.blinky.choice2(26, 1, pg);
				if(pg.blinky.currenttilex==26 && pg.blinky.currenttiley==1){
					blinkystateflag=1;
				}
			
		}
		
		if(statecounter<=10000 && blinkystateflag==1 && scaredflag==0 && blinkydeadflag==0){
			pg.blinky.choice2(20, 5, pg);
			if(pg.blinky.currenttilex==20 && pg.blinky.currenttiley==5){
				blinkystateflag=0;
			}
		}
		
		if(scaredflag==1){
			//pg.blinky.scaredflag=1;
			if(blinkystateflag==0 && blinkydeadflag==0){
				pg.blinky.choice2(26, 1, pg);
				if(pg.blinky.currenttilex==26 && pg.blinky.currenttiley==1){
					blinkystateflag=1;
				}
			
			}
		
			if(blinkystateflag==1 && blinkydeadflag==0){
			pg.blinky.choice2(1, 29, pg);
				if(pg.blinky.currenttilex==1 && pg.blinky.currenttiley==29){
					blinkystateflag=0;
				}
			}

		}
		
		if(blinkydeadflag==1){
			pg.blinky.choice2(14, 14, pg);
			if(pg.blinky.currenttilex==14 && pg.blinky.currenttiley==14){
				blinkydeadflag=0;
				pg.blinky.deadflag=0;
				
			}
		}
		
		if(statecounter<0){
			statecounter=30000;
		}
		
		timer -=delta;
		if(timer<12000){
			pg.inky.movefromhome(pg);
			inkyflag=1;
		}
		
		if(inkyflag==1 && scaredflag==0 && blinkydeadflag==0){
			if(statecounter>10000){
//			if(removeflaginky==0)
//				pg.inky.removeAnimation(pg.inky.inkani);
//				removeflaginky=1;
				pg.inky.choice2(mazex, mazey, pg);
			}
			
			if( statecounter<=10000 && inkystateflag==0 && scaredflag==0 && blinkydeadflag==0){
					pg.inky.choice2(26, 29, pg);
					if(pg.inky.currenttilex==26 && pg.inky.currenttiley==29){
						inkystateflag=1;
					}
				
			}
			
			if(statecounter<=10000 && inkystateflag==1 && scaredflag==0 && blinkydeadflag==0){
				pg.inky.choice2(20, 25, pg);
				if(pg.inky.currenttilex==20 && pg.inky.currenttiley==25){
					inkystateflag=0;
				}
			}
			//pg.inky.choice2(mazex, mazey, pg);
		}
		
		if(scaredflag==1 && inkyflag==1 && blinkydeadflag==0){
			if(inkystateflag==0){
				pg.inky.choice2(26, 29, pg);
				if(pg.inky.currenttilex==26 && pg.inky.currenttiley==29){
					inkystateflag=1;
				}
			
			}
		
			if(inkystateflag==1){
			pg.inky.choice2(1, 1, pg);
				if(pg.inky.currenttilex==1 && pg.inky.currenttiley==1){
					inkystateflag=0;
				}
			}
			
		}
		
		if(inkydeadflag==1){
			pg.inky.choice2(14, 14, pg);
			if(pg.inky.currenttilex==14 && pg.inky.currenttiley==14){
				inkydeadflag=0;
				pg.inky.deadflag=0;
			}
		}
		
		
		
		if(timer<6000){
			pg.pinky.movefromhome(pg);
			pinkyflag=1;
		}
		
		if(pinkyflag==1 && pinkydeadflag==0){
			if(statecounter>10000 && scaredflag==0){
//				if(removeflagpinky==0)
//					pg.pinky.removeAnimation(pg.pinky.pinkani);
//					removeflagpinky=1;
				pg.pinky.choice2(mazex, mazey, pg);
			}
			
			if( statecounter<=10000 && pinkystateflag==0 && scaredflag==0 && pinkydeadflag==0){
					pg.pinky.choice2(1, 1, pg);
					if(pg.pinky.currenttilex==1 && pg.pinky.currenttiley==1){
						pinkystateflag=1;
					}
				
			}
			
			if(statecounter<=10000 && pinkystateflag==1 && scaredflag==0 && pinkydeadflag==0){
				pg.pinky.choice2(7, 5, pg);
				if(pg.pinky.currenttilex==7 && pg.pinky.currenttiley==5){
					pinkystateflag=0;
				}
			}
			//pg.pinky.choice2(mazex, mazey, pg);
		}
		
		if(scaredflag==1 && pinkyflag==1 && pinkydeadflag==0){
			if(pinkystateflag==0){
				pg.pinky.choice2(6, 17, pg);
				if(pg.pinky.currenttilex==6 && pg.pinky.currenttiley==17){
					pinkystateflag=1;
				}
			
			}
		
			if(pinkystateflag==1){
			pg.pinky.choice2(21, 17, pg);
				if(pg.pinky.currenttilex==21 && pg.pinky.currenttiley==17){
					pinkystateflag=0;
				}
			}
			
		}
		
		if(pinkydeadflag==1){
			pg.pinky.choice2(14, 14, pg);
			if(pg.pinky.currenttilex==14 && pg.pinky.currenttiley==14){
				pinkydeadflag=0;
				pg.pinky.deadflag=0;
			}
		}
		
		
		if(timer < 0){
			pg.clyde.movefromhome(pg);
			clydeflag=1;
		}
		
		if(clydeflag==1 && clydedeadflag==0){
			if(statecounter>10000 && scaredflag==0){
//				if(removeflagclyde==0)
//					pg.clyde.removeAnimation(pg.clyde.clydeani);
//					removeflagclyde=1;
				pg.clyde.choice2(mazex, mazey, pg);
			}
			
			if( statecounter<=10000 && clydestateflag==0 && scaredflag==0 && clydedeadflag==0){
					pg.clyde.choice2(1, 29, pg);
					if(pg.clyde.currenttilex==1 && pg.clyde.currenttiley==29){
						clydestateflag=1;
					}
				
			}
			
			if(statecounter<=10000 && clydestateflag==1 && scaredflag==0 && clydedeadflag==0){
				pg.clyde.choice2(7, 25, pg);
				if(pg.clyde.currenttilex==7 && pg.clyde.currenttiley==25){
					clydestateflag=0;
				}
			}
			//pg.clyde.choice2(mazex, mazey, pg);
		}
		
		if(scaredflag==1 && clydeflag==1 && clydedeadflag==0){
			if(clydestateflag==0){
				pg.clyde.choice2(13, 5, pg);
				if(pg.clyde.currenttilex==13 && pg.clyde.currenttiley==5){
					clydestateflag=1;
				}
			
			}
		
			if(clydestateflag==1){
			pg.clyde.choice2(13, 25, pg);
				if(pg.clyde.currenttilex==13 && pg.clyde.currenttiley==25){
					clydestateflag=0;
				}
			}
			
		}
		
		if(clydedeadflag==1){
			pg.clyde.choice2(14, 14, pg);
			if(pg.clyde.currenttilex==14 && pg.clyde.currenttiley==14){
				clydedeadflag=0;
				pg.clyde.deadflag=0;
			}
		}
		
		
		
		scaredtimer-=delta;
		//System.out.println(scaredtimer + "," +scaredflag);
		if(scaredtimer<0 && scaredflag==1){
			ResourceManager.getSound(PacManGame.Scared_Scared_RSC).stop();
			ResourceManager.getSound(PacManGame.Siren_Siren_RSC).loop();
			scaredflag=0;
			pg.blinky.scaredflag=0;
			pg.inky.scaredflag=0;
			pg.clyde.scaredflag=0;
			pg.pinky.scaredflag=0;
			//mazescared=0;
			
		}
		
		if(pg.winstatelvl2==0){
			pg.winx=pacx;
			pg.winy=pacy;
			this.winstate();
		}
		
		fruittimer-=delta;
		if(fruittimer<0){
			if(pg.maze2[fruittiley][fruittilex]==3){
				pg.maze2[fruittiley][fruittilex]=8;
				fruittimer=10000;
			}else{
				pg.maze2[fruittiley][fruittilex]=3;
				fruit++;
				if(fruit==3)
					fruit=0;
				
				fruittimer=25000;
			}
		}

	}
	
	public void move(int desired){
		System.out.println("PREVIOUS KEY :" +pg.previouskey);
		if(desired==3){
			if(pg.maze2[mazey][mazex]==6){
				state=6;
				check=20;
				wrapflag=0;
				return;
			}
			if(pg.maze2[mazey][mazex-1]!=1){
				if(animationleftflag==0){
					animationdownflag=0;
					animationrightflag=0;
					animationupflag=0;
					pg.pacman2.removeAnimation(pg.pacman2.PacManDown);
					pg.pacman2.removeAnimation(pg.pacman2.PacManAni);
					pg.pacman2.removeAnimation(pg.pacman2.PacManUp);
					pg.pacman2.addAnimation(pg.pacman2.PacManLeft);
					pg.previouskey=key;
					animationleftflag=1;
				}
				state=1;
				
				mazescared = pg.maze2[mazey][mazex-1];
				nextmazex=mazex-1;
				nextmazey=mazey;
				key=3;
				check=10;
				current=3;
				return;
			}
			if(current==3){
				//key=pg.previouskey;
				return;
			}
			return;
		}
		
		if(desired==1){
			if(pg.maze2[mazey-1][mazex]!=1){
				if(animationupflag==0){
					animationdownflag=0;
					animationleftflag=0;
					animationrightflag=0;
					pg.pacman2.removeAnimation(pg.pacman2.PacManDown);
					pg.pacman2.removeAnimation(pg.pacman2.PacManAni);
					pg.pacman2.removeAnimation(pg.pacman2.PacManLeft);
					pg.pacman2.addAnimation(pg.pacman2.PacManUp);
					pg.previouskey=key;
					animationupflag=1;
				}
				state=3;
				mazescared = pg.maze2[mazey-1][mazex];
				nextmazex=mazex;
				nextmazey=mazey-1;
				key=1;
				check=10;
				current=1;
				return;
			}
			if(current==1){
				//key=0;
				//key=pg.previouskey;
				return;
			}
			
			return;
		}
		
		if(desired==2){
			if(pg.maze2[mazey+1][mazex]!=1){
				if(animationdownflag==0){
					animationleftflag=0;
					animationrightflag=0;
					animationupflag=0;
					pg.pacman2.removeAnimation(pg.pacman2.PacManUp);
					pg.pacman2.removeAnimation(pg.pacman2.PacManLeft);
					pg.pacman2.removeAnimation(pg.pacman2.PacManAni);
					pg.pacman2.addAnimation(pg.pacman2.PacManDown);
					pg.previouskey=key;
					animationdownflag=1;
				}
				state=4;
				mazescared = pg.maze2[mazey+1][mazex];
				nextmazex=mazex;
				nextmazey=mazey+1;
				key=2;
				check=10;
				current=2;
				return;
			}
			if(current==2){
				//key=0;
				//key=pg.previouskey;
				return;
			}
			return;
		}
		
		if(desired==4){
			if(pg.maze2[mazey][mazex]==5){
				System.out.println("MADE IT");
				state=5;
				check=20;
				wrapflag=0;
				return;
			}
			if(pg.maze2[mazey][mazex+1]!=1){
				if(animationrightflag==0){
					animationdownflag=0;
					animationleftflag=0;
					animationupflag=0;
					pg.pacman2.removeAnimation(pg.pacman2.PacManLeft);
					pg.pacman2.removeAnimation(pg.pacman2.PacManUp);
					pg.pacman2.removeAnimation(pg.pacman2.PacManDown);
					pg.pacman2.addAnimation(pg.pacman2.PacManAni);
					pg.previouskey=key;
					animationrightflag=1;
				}
				
				state=2;
				mazescared = pg.maze2[mazey][mazex+1];
				nextmazex=mazex+1;
				nextmazey=mazey;
				key=4;
				check=10;
				current=4;
				return;
			}
			if(current==4){
				//key=0;
				System.out.println("HEYasdlfjaasdfkasjdfla");
				//key=pg.previouskey;
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
		return PacManGame.LEVEL2;
	}
	
}

