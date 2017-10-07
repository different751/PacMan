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
	
	PacManGame pg;
	PacManObj pacman = new PacManObj();
	dots food = new dots();
	Energydot enrdot = new Energydot();

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		//PacManAni = new Animation(ResourceManager.getSpriteSheet(PacManGame.PACMAN_PACMAN_RSC, 28, 28),75);
	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) {
		pg = (PacManGame)game;
		
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
		pacman.PacManAni.getCurrentFrame().getFlippedCopy(true, false).drawCentered(224, 424);
		
		for(int i=0;i<31;i++){
			for(int z=0;z<28;z++){
				if(pg.maze[i][z]==0){
					//g.drawImage(ResourceManager.getImage(PacManGame.DOT_DOT_RSC), (z * 16) +6,(i*16)+52);
					food.dotani.getCurrentFrame().drawCentered((z * 16) +8,(i*16)+56);
					
				}
				
				if(pg.maze[i][z]==2){
					//g.drawImage(ResourceManager.getImage(PacManGame.ENR_ENR_RSC), (z * 16) +6,(i*16)+52);
					enrdot.enrani.getCurrentFrame().drawCentered((z * 16) +8,(i*16)+56);
				}
			}
		}
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game,
			int delta) throws SlickException {

		Input input = container.getInput();
		PacManGame bg = (PacManGame)game;
		
		
		if(input.isKeyPressed(Input.KEY_W) || input.isKeyPressed(Input.KEY_UP)){
			pacman.setPosition(pacman.getX(), pacman.getY()-1);
			
		}

		if(input.isKeyPressed(Input.KEY_S) || input.isKeyPressed(Input.KEY_DOWN)){
			System.out.println(pacman.getY());
			
		}

		if(input.isKeyPressed(Input.KEY_A) || input.isKeyPressed(Input.KEY_LEFT)){
	
		}

		if(input.isKeyPressed(Input.KEY_D) || input.isKeyPressed(Input.KEY_RIGHT)){
	
		}
		
		
		
		
		pacman.PacManAni.update(delta);
		
		
		
		
		//bg.ball.update(delta);

		

	}

	@Override
	public int getID() {
		return PacManGame.STARTUPSTATE;
	}
	
}

