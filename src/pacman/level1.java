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
	//private Animation PacManAni;
	//PacManObj pacman = new PacManObj();
	//loadImage(PacManGame.DOT_DOT_RSC);
	
	PacManGame pg;
	//PacManObj pacman = new PacManObj();
	dots food = new dots();
	Energydot enrdot = new Energydot();
	//int pacx=232;
	//int pacy=424;
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
	int timer=0;
	int desired=0;
	int current=0;
	

	
	
	int state=0;
	//use render instead

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
		//PacManAni = new Animation(ResourceManager.getSpriteSheet(PacManGame.PACMAN_PACMAN_RSC, 28, 28),75);
	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) {
		pg = (PacManGame)game;
		 currenttilex=(int) ((pg.pacman.getX()-8)/16);
		 currenttiley=(int) ((pg.pacman.getY()-56)/16);
		container.setSoundOn(false);
		
	}


	@Override
	public void render(GameContainer container, StateBasedGame game,
			Graphics g) throws SlickException {
		
		
		
		//PacManGame bg = (PacManGame)game;
		
		g.drawImage(ResourceManager.getImage(PacManGame.MAZE_MAZE_RSC),0, 48);	
		//g.drawImage(ResourceManager.getImage(PacManGame.DOT_DOT_RSC),200,200);
		
		
		//g.drawImage(ResourceManager.getImage(PacManGame.PACMAN_PACMAN_RSC), map.
		
		//g.drawImage(ResourceManager.getImage(PacManGame.PACMAN_PACMAN_RSC),224, 313);	]
		//pacman.PacManAni.draw(224,313);
		
		//pacman.PacManAni.getCurrentFrame().getFlippedCopy(true, false).drawCentered(pacx, pacy);
		//pacman.PacManAni.getCurrentFrame().getFlippedCopy(true, false).drawCentered(224,517);
		/*if(state==0){
			pacman.PacManAni.getCurrentFrame().getFlippedCopy(true, false).drawCentered(pacx, pacy);
		}
		
		if(state==1){
			for(int i=1;i<17;i++){
				pacx--;
				pacman.PacManAni.getCurrentFrame().getFlippedCopy(true, false).drawCentered(pacx, pacy);
			}
			//pacx=pacx-8;
			state=0;
			
		}*/
		
		
		
		for(int i=0;i<31;i++){
			for(int z=0;z<28;z++){
				if(pg.maze[i][z]==0){
					//g.drawImage(ResourceManager.getImage(PacManGame.DOT_DOT_RSC), (z * 16) +6,(i*16)+52);
					food.dotani.getCurrentFrame().drawCentered((z * 16) +8,(i*16)+56);
					//food.dotani.getCurrentFrame().drawCentered((z * 16),(i*16)+48);
					//food.dotani.getCurrentFrame().drawCentered((z * 16),(i*16));
					
				}
				
				if(pg.maze[i][z]==2){
					//g.drawImage(ResourceManager.getImage(PacManGame.ENR_ENR_RSC), (z * 16) +6,(i*16)+52);
					enrdot.enrani.getCurrentFrame().drawCentered((z * 16) +8,(i*16)+56);
					//pg.enrdot.render(g);
				}
				
			}
		}
		
		
		
		
		//pg.pacman.addAnimation(pg.pacman.PacManAni);
		//pg.pacman.PacManAni.getCurrentFrame().getFlippedCopy(true, false);
		pg.pacman.render(g);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game,
			int delta) throws SlickException {

		Input input = container.getInput();
		PacManGame pg = (PacManGame)game;
		//System.out.println(pg.maze[13][22]);
			
		//previousx=currenttilex*16;
		//previousy=currenttiley*16;
		currenttilex=(int) (((pg.pacman.getX())-8)/16);
		currenttiley=(int) ((pg.pacman.getY()-56)/16);
		
		tileup=currenttiley-1;
		tiledown=currenttiley+1;
		tileright=currenttilex+1;
		tileleft=currenttilex;
		
		
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
			/*
			nexttile=currenttiley;
			//System.out.println("W:  Current X:" + (currenttilex) +","+ "Current Y: " + (currenttiley));
			//System.out.println("W  Nexttile for Y: " + nexttile);
			//System.out.println("WHAT IS IN ARRARY: " + pg.maze[nexttile][currenttilex]);
			//test for collision
			
			if(pg.maze[mazey-1][mazex]!=1){
				state=3;
				nextmazex=mazex;
				nextmazey=mazey-1;
				key=1;
				check=10;
			}
			else{
				key=0;
			}
			*/
			
		//}

		//if((input.isKeyPressed(Input.KEY_S) || input.isKeyPressed(Input.KEY_DOWN) || key==2) ){
		if((input.isKeyPressed(Input.KEY_S) || input.isKeyPressed(Input.KEY_DOWN) ) ){
			desired=2;
			System.out.println("S");
			this.move(desired);
		}
		else if(key==2){
			this.move(desired);
		}
			/*
			nexttile=currenttiley+1;
			//System.out.println("S:  Current X:" + (currenttilex) +","+ "Current Y: " + (currenttiley));
			//System.out.println("S  Nexttile for Y: " + nexttile);
			//System.out.println("WHAT IS IN ARRARY: " + pg.maze[nexttile][currenttilex]);
			
			if(pg.maze[mazey+1][mazex]!=1){
				state=4;
				nextmazex=mazex;
				nextmazey=mazey+1;
				key=2;
				check=10;
			}
			else{
				key=0;
			}*/
			
		//}

		//if((input.isKeyPressed(Input.KEY_A) || input.isKeyPressed(Input.KEY_LEFT) || key==3)  ){
		if((input.isKeyPressed(Input.KEY_A) || input.isKeyPressed(Input.KEY_LEFT) )  ){
			desired=3;
			System.out.println("A");
			this.move(desired);
			
		}
		else if(key==3){
			//System.out.println("A");
			this.move(desired);
		}
			/*
			
			//System.out.println("A:  Current X:" + (mazex) +","+ "Current Y: " + (mazey));
			
			//System.out.println("A  Nexttile for x: " + (mazex-1));
			//System.out.println("WHAT IS IN ARRARY: " + pg.maze[currenttiley][nexttile]);
			
			
			if(pg.maze[mazey][mazex-1]!=1){
				state=1;
				nextmazex=mazex-1;
				nextmazey=mazey;
				key=3;
				check=10;
				
			}
			else{
				key=0;
			}
			*/
		//}

		//if((input.isKeyPressed(Input.KEY_D) || input.isKeyPressed(Input.KEY_RIGHT) || key==4) ){
		if((input.isKeyPressed(Input.KEY_D) || input.isKeyPressed(Input.KEY_RIGHT)) ){
			desired=4;
			System.out.println("D");
			this.move(desired);
		}
		else if(key==4){
			this.move(desired);
		}
			/*
			nexttile=currenttilex+1;
			//System.out.println("D:  Current X:" + (currenttilex) +","+ "Current Y: " + (currenttiley));
			
			//System.out.println("D  Nexttile for x: " + nexttile);
			//System.out.println("WHAT IS IN ARRARY: " + pg.maze[currenttiley][nexttile]);
			if(pg.maze[mazey][mazex+1]!=1){
				state=2;
				nextmazex=mazex+1;
				nextmazey=mazey;
				key=4;
				check=10;
			}
			else{
				key=0;
			}
			
			
		}*/
		//}
		}
		
		if(state==1){
			
			if(check>0){
				pacx-=1.6;
				check-=1;
				pg.pacman.setX(pacx);
			}
			else{
				pg.maze[mazey][mazex]=-1;
				state=0;
				mazex=nextmazex;
			}
			
			
		}
		if(state==2){
			if(check>0){
				pacx+=1.6;
				check-=1;
				pg.pacman.setX(pacx);
			}
			else{
				pg.maze[mazey][mazex]=-1;
				state=0;
				mazex=nextmazex;
			}
		}
		if(state==3){
			if(check>0){
				pacy-=1.6;
				check-=1;
				pg.pacman.setY(pacy);
			}
			else{
				pg.maze[mazey][mazex]=-1;
				state=0;
				mazey=nextmazey;
			}
		}
		if(state==4){
			
			if(check>0){
				pacy+=1.6;
				check-=1;
				pg.pacman.setY(pacy);
			}
			else{
				pg.maze[mazey][mazex]=-1;
				state=0;
				mazey=nextmazey;
			}
		}
		
		
		
		
		
		//pacman.PacManAni.update(delta);
		//pg.pacman.update(delta);
		
		
		
		
		//bg.ball.update(delta);

		

	}
	
	public void move(int desired){
				
		
		if(desired==3){
			if(pg.maze[mazey][mazex-1]!=1){
				state=1;
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

	@Override
	public int getID() {
		return PacManGame.LEVEL1;
	}
	
}

