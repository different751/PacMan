package pacman;



import jig.Entity;
import jig.ResourceManager;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class PacManGame extends StateBasedGame {
	
	public static final int STARTUPSTATE = 7;
	//public static final int PLAYINGSTATE = 4;
	//public static final int GAMEOVERSTATE = 5;
	//public static final int LEVEL1 = 1;
	
	public static final String MAZE_MAZE_RSC = "PacMan/resource/pacmaze.png";
	public static final String PACMAN_PACMAN_RSC = "PacMan/resource/pacman_spritesheet.png";
	
	


	public final int ScreenWidth;
	public final int ScreenHeight;
	public final int Screen4;
	 


	

	/**
	 * Create the PacMan frame, saving the width and height for later use.
	 * 
	 * @param title
	 *            the window's title
	 * @param width
	 *            the window's width
	 * @param height
	 *            the window's height
	 */
	public PacManGame(String title, int width, int height) {
		super(title);
		ScreenHeight = height;
		ScreenWidth = width;
		Screen4=width/8;

		Entity.setCoarseGrainedCollisionBoundary(Entity.AABB);
		
				
	}


	@Override
	public void initStatesList(GameContainer container) throws SlickException {
	
		addState(new StartUpState());
		
		
		
		
		// the sound resource takes a particularly long time to load,
		// we preload it here to (1) reduce latency when we first play it
		// and (2) because loading it will load the audio libraries and
		// unless that is done now, we can't *disable* sound as we
		// attempt to do in the startUp() method.
		
		ResourceManager.loadImage(MAZE_MAZE_RSC);
		ResourceManager.loadImage(PACMAN_PACMAN_RSC);
	
		
			
		

	}
	
	public static void main(String[] args) {
		AppGameContainer app;
		try {
			app = new AppGameContainer(new PacManGame("Pac-Man", 448, 576));
			app.setDisplayMode(448, 576, false);
			app.setVSync(true);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}

	}

	
}
