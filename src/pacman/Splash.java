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


/**
 * This state is active when the Game is over. In this state, the ball is
 * neither drawn nor updated; and a gameover banner is displayed. A timer
 * automatically transitions back to the StartUp State.
 * 
 * Transitions From PlayingState
 * 
 * Transitions To StartUpState
 */
class Splash extends BasicGameState {
	

	private int timer;
	
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) {
		timer = 8000;
	}

	
	@Override
	public void render(GameContainer container, StateBasedGame game,
			Graphics g) throws SlickException {

		PacManGame bg = (PacManGame)game;
		
		g.drawImage(ResourceManager.getImage(PacManGame.FISH_FISH_RSC), (bg.ScreenWidth/3)-90,
				bg.ScreenHeight/12);
		g.drawString("COY-FISH GAMES", (bg.ScreenWidth/2)-65, (bg.ScreenHeight/2)+65);
		g.drawString("Created By: Tyler Coy", (bg.ScreenWidth/2)-100, (bg.ScreenHeight/2)+85);

	}

	@Override
	public void update(GameContainer container, StateBasedGame game,
			int delta) throws SlickException {
		Input input = container.getInput();
		if (input.isKeyDown(Input.KEY_N))
			game.enterState(PacManGame.MENU, new EmptyTransition(), new HorizontalSplitTransition() );
		
		if(input.isKeyDown(Input.KEY_ESCAPE))
			game.enterState(PacManGame.MENU, new EmptyTransition(), new HorizontalSplitTransition() );
		
		timer -= delta;
		if (timer <= 0)
			game.enterState(PacManGame.MENU, new EmptyTransition(), new HorizontalSplitTransition() );

		// check if there are any finished explosions, if so remove them

	}

	@Override
	public int getID() {
		return PacManGame.SPLASH;
	}
	
}