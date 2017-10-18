package pacman;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import jig.ResourceManager;

public class Gameoverstate extends BasicGameState {
	PacManGame pg;
	
	int timer = 1500;
	int state =0;
	int count=0;
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	public void enter(GameContainer container, StateBasedGame game) {
		pg = (PacManGame)game;
		timer=2000;
		state=0;
		container.setSoundOn(true);
		ResourceManager.getSound(PacManGame.Siren_Siren_RSC).stop();
		ResourceManager.getSound(PacManGame.Scared_Scared_RSC).stop();
		
		
		//pg.pacdead.addAnimation(pg.pacman.PacMandeath);
		//pg.pacdead.PacMandeath.setCurrentFrame(0);
		//make new pacman dead obj with animation so it doesnt interfer with the other one
		
		//pg.pacdead.PacMandeath.setLooping(false);
		ResourceManager.getSound(PacManGame.Death_Death_RSC).play();
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		g.drawImage(ResourceManager.getImage(PacManGame.MAZE_MAZE_RSC),0, 48);
		
		
		if(state==0)
			g.drawImage(ResourceManager.getImage(PacManGame.DE_DE_RSC), pg.winx-16, pg.winy-16);
		if(state==1)
			g.drawImage(ResourceManager.getImage(PacManGame.DE1_DE1_RSC), pg.winx-16, pg.winy-16);
		if(state==2)
			g.drawImage(ResourceManager.getImage(PacManGame.DE2_DE2_RSC), pg.winx-16, pg.winy-16);		
		if(state==3)
			g.drawImage(ResourceManager.getImage(PacManGame.DE3_DE3_RSC), pg.winx-16, pg.winy-16);
			
		if(state==4)
			g.drawImage(ResourceManager.getImage(PacManGame.DE4_DE4_RSC), pg.winx-16, pg.winy-16);
			
		if(state==5)
			g.drawImage(ResourceManager.getImage(PacManGame.DE5_DE5_RSC), pg.winx-16, pg.winy-16);
		
		if(state==6)
			g.drawImage(ResourceManager.getImage(PacManGame.DE6_DE6_RSC), pg.winx-16, pg.winy-16);
		
		
		
		
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		// TODO Auto-generated method stub
		//pg.pacman.PacMandeath.stopAt(6);
		//pg.pacman.PacMandeath.
		timer-=delta;
		if(timer<1760){
			state=1;
		}
		
		if(timer<1520){
			state=2;
		}
		
		if(timer<1280){
			state=3;
		}
		
		if(timer<1040){
			state=4;
		}
		
		if(timer<800){
			state=5;
		}
		
		if(timer<560){
			state=6;
		}
		
		
		
		if(timer<0){
			//pg.pacdead.removeAnimation(pg.pacdead.PacMandeath);
			//pg.pacdead.PacMandeath.setCurrentFrame(0);
			if(pg.lives==0){
				System.out.println("PASS");
				pg.enterState(PacManGame.HIGHSCORESTATE);
			}
			else{
				System.out.println(pg.winx + "," + pg.winy);
				pg.enterState(PacManGame.LEVEL1);
			}
		}
	
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 3;
	}

}
