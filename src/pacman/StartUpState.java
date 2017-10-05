package pacman;

import jig.ResourceManager;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.HorizontalSplitTransition;



class StartUpState extends BasicGameState {

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) {
		
		
		container.setSoundOn(false);
		
	}


	@Override
	public void render(GameContainer container, StateBasedGame game,
			Graphics g) throws SlickException {
		
		//PacManGame bg = (PacManGame)game;
		g.drawImage(ResourceManager.getImage(PacManGame.MAZE_MAZE_RSC),
				0, 48);		
		
		//g.drawImage(ResourceManager.getImage(PacManGame.PACMAN_PACMAN_RSC),
				//224, 313);	
	}

	@Override
	public void update(GameContainer container, StateBasedGame game,
			int delta) throws SlickException {

		Input input = container.getInput();
		PacManGame bg = (PacManGame)game;
		
		
		
		
		
		//bg.ball.update(delta);

		

	}

	@Override
	public int getID() {
		return PacManGame.STARTUPSTATE;
	}
	
}
