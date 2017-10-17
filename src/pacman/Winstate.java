package pacman;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import jig.ResourceManager;

public class Winstate extends BasicGameState {
	PacManGame pg;
	int timer = 10000;
	int state =0;
	int count=0;
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	public void enter(GameContainer container, StateBasedGame game) {
		pg = (PacManGame)game;
		container.setSoundOn(false);
		ResourceManager.getSound(PacManGame.Siren_Siren_RSC).stop();
		ResourceManager.getSound(PacManGame.Scared_Scared_RSC).stop();
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		if(state==0)
		g.drawImage(ResourceManager.getImage(PacManGame.MAZE_MAZE_RSC),0, 48);
		
		if(state==1)
		g.drawImage(ResourceManager.getImage(PacManGame.Win_Win_RSC),0,48);
		
		
		pg.pacman.render(g);
		pg.pacman.setX(pg.winx);
		pg.pacman.setY(pg.winy);
		pg.pacman.PacManAni.setCurrentFrame(2);
		pg.pacman.PacManAni.stop();
		
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
		timer-=delta;
		if(timer<8000 && count ==0){
			state=1;
			count++;
		}
		
		if(timer<7000 && count == 1){
			state=0;
			count++;
		}
		
		if(timer<6000 && count==2){
			state=1;
			count++;
		}
		
		if(timer<5000 && count ==3){
			state=0;
			count++;
			
		}
		
		if(timer<4000 && count ==4){
			state=1;
			count++;
		}
		
		if(timer<3000 && count ==5){
			state=0;
			count++;
		}
		
		if(timer<2000 && count ==6){
			state=1;
			count++;
		}
		
		if(timer<1000 && count ==7){
			state=0;
			count++;
		}
		
		if(timer<0 && count ==8){
			//change level to level 2
			System.out.println("Next Level");
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}

}
