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
	public static final int LEVEL1 = 1;
	public static final int WINSTATE = 2;
	
	public static final String MAZE_MAZE_RSC = "PacMan/resource/pacmaze.png";
	public static final String PACMAN_PACMAN_RSC = "PacMan/resource/pacman_spritesheet.png";
	public static final String DOT_DOT_RSC = "PacMan/resource/pacdot.png";
	public static final String ENR_ENR_RSC = "PacMan/resource/pacenergy.png";
	public static final String BL_BL_RSC = "PacMan/resource/blinkyleft.png";
	public static final String BU_BU_RSC = "PacMan/resource/blinkyup.png";
	public static final String BD_BD_RSC = "PacMan/resource/blinkydown.png";
	public static final String IL_IL_RSC = "PacMan/resource/inkyleft.png";
	public static final String IU_IU_RSC = "PacMan/resource/inkyup.png";
	public static final String ID_ID_RSC = "PacMan/resource/inkydown.png";
	public static final String PL_PL_RSC = "PacMan/resource/pinkyleft.png";
	public static final String PU_PU_RSC = "PacMan/resource/pinkyup.png";
	public static final String PD_PD_RSC = "PacMan/resource/pinkydown.png";
	public static final String CL_CL_RSC = "PacMan/resource/clydeleft.png";
	public static final String CU_CU_RSC = "PacMan/resource/clydeup.png";
	public static final String CD_CD_RSC = "PacMan/resource/clydedown.png";
	public static final String Death_Death_RSC = "PacMan/resource/death.wav";
	public static final String Scared_Scared_RSC = "PacMan/resource/scared.wav";
	public static final String Siren_Siren_RSC = "PacMan/resource/test1.wav";
	public static final String Waka_Waka_RSC = "PacMan/resource/test2.wav";
	public static final String Win_Win_RSC = "PacMan/resource/pacwinmaze.png";
	//public static final String 
	
	


	public final int ScreenWidth;
	public final int ScreenHeight;
	public final int Screen4;
	private int dotcheck=0;
	private int enrdotcheck=0;
	//public PacManObj pacman;
	//public dots food[];
	
	//1 is wall, 0 is dot, 2 is energy dot, 3 is blank, 4 is wall but not for ghost
	//5 will be used for fruit
	int maze[][] = {
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
			{1,2,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,2,1},
			{1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,1},
			{1,0,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,1},
			{1,0,0,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,0,1,1,1,1,1,3,1,1,3,1,1,1,1,1,0,1,1,1,1,1,1},
			{1,1,1,1,1,1,0,1,1,1,1,1,3,1,1,3,1,1,1,1,1,0,1,1,1,1,1,1},
			{1,1,1,1,1,1,0,1,1,3,3,3,3,3,3,3,3,3,3,1,1,0,1,1,1,1,1,1},
			{1,1,1,1,1,1,0,1,1,3,1,1,1,1,1,1,1,1,3,1,1,0,1,1,1,1,1,1},
			{1,1,1,1,1,1,0,1,1,3,1,3,3,3,3,3,3,1,3,1,1,0,1,1,1,1,1,1},
			{3,3,3,3,3,3,0,3,3,3,1,3,3,3,3,3,3,1,3,3,3,0,3,3,3,3,3,3},//midpoint
			{1,1,1,1,1,1,0,1,1,3,1,3,3,3,3,3,3,1,3,1,1,0,1,1,1,1,1,1},
			{1,1,1,1,1,1,0,1,1,3,1,1,1,1,1,1,1,1,3,1,1,0,1,1,1,1,1,1},
			{1,1,1,1,1,1,0,1,1,3,3,3,3,3,3,3,3,3,3,1,1,0,1,1,1,1,1,1},
			{1,1,1,1,1,1,0,1,1,3,1,1,1,1,1,1,1,1,3,1,1,0,1,1,1,1,1,1},
			{1,1,1,1,1,1,0,1,1,3,1,1,1,1,1,1,1,1,3,1,1,0,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
			{1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
			{1,2,0,0,1,1,0,0,0,0,0,0,0,7,7,0,0,0,0,0,0,0,1,1,0,0,2,1},
			{1,1,1,0,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,0,1,1,1},
			{1,1,1,0,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,0,1,1,1},
			{1,0,0,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1},
			{1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
	};
	
	
	PacManObj pacman;
	Blinky blinky;
	Inky inky;
	Pinky pinky;
	Clyde clyde;
	float winx;
	float winy;
	//Energydot enrdot[];
	//dots dot[];


	

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
	
		//addState(new StartUpState());
		addState(new level1());
		addState(new Winstate());
		
		
		
		
		// the sound resource takes a particularly long time to load,
		// we preload it here to (1) reduce latency when we first play it
		// and (2) because loading it will load the audio libraries and
		// unless that is done now, we can't *disable* sound as we
		// attempt to do in the startUp() method.
		
		ResourceManager.loadImage(MAZE_MAZE_RSC);
		ResourceManager.loadImage(Win_Win_RSC);
		ResourceManager.loadImage(PACMAN_PACMAN_RSC);
		ResourceManager.loadImage(DOT_DOT_RSC);
		ResourceManager.loadImage(ENR_ENR_RSC);
		ResourceManager.loadImage(BL_BL_RSC);
		ResourceManager.loadImage(BU_BU_RSC);
		ResourceManager.loadImage(BD_BD_RSC);
		ResourceManager.loadImage(IL_IL_RSC);
		ResourceManager.loadImage(IU_IU_RSC);
		ResourceManager.loadImage(ID_ID_RSC);
		ResourceManager.loadImage(PL_PL_RSC);
		ResourceManager.loadImage(PU_PU_RSC);
		ResourceManager.loadImage(PD_PD_RSC);
		ResourceManager.loadImage(CL_CL_RSC);
		ResourceManager.loadImage(CU_CU_RSC);
		ResourceManager.loadImage(CD_CD_RSC);
		ResourceManager.loadSound(Death_Death_RSC);
		ResourceManager.loadSound(Scared_Scared_RSC);
		ResourceManager.loadSound(Siren_Siren_RSC);
		ResourceManager.loadSound(Waka_Waka_RSC);
		
		//food=new dots[244];
		
		pacman = new PacManObj(232,424,0,0);
		blinky = new Blinky(232,232);
		inky = new Inky(192,280);
		pinky = new Pinky(224,280);
		clyde = new Clyde(256,280);
		//enrdot=new Energydot[4];
		//dot=new dots[241];
		
		
	
		
		
		

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
