package pacman;



import jig.Entity;
import jig.ResourceManager;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import java.io.*;
import java.util.Scanner;


public class PacManGame extends StateBasedGame {
	
	//public static final int STARTUPSTATE = 7;
	//public static final int PLAYINGSTATE = 4;
	//public static final int GAMEOVERSTATE = 5;
	public static final int LEVEL1 = 1;
	public static final int WINSTATE = 2;
	public static final int GAMEOVERSTATE =3;
	public static final int HIGHSCORESTATE=4;
	public static final int LEVEL2= 5;
	public static final int MENU=6;
	public static final int SPLASH=7;
	
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
	public static final String CH_CH_RSC = "PacMan/resource/cherry.png";
	public static final String PE_PE_RSC = "PacMan/resource/peach.png";
	public static final String ST_ST_RSC = "PacMan/resource/Strawberry.png";
	public static final String DE1_DE1_RSC = "PacMan/resource/pacdead1.png";
	public static final String DE2_DE2_RSC = "PacMan/resource/pacdead2.png";
	public static final String DE3_DE3_RSC = "PacMan/resource/pacdead3.png";
	public static final String DE4_DE4_RSC = "PacMan/resource/pacdead4.png";
	public static final String DE5_DE5_RSC = "PacMan/resource/pacdead5.png";
	public static final String DE6_DE6_RSC = "PacMan/resource/pacdead6.png";
	public static final String DE_DE_RSC = "PacMan/resource/pacsingle.png";
	public static final String LIVE_LIVE_RSC = "PacMan/resource/paclives.png";
	public static final String lv2_lv2_RSC = "PacMan/resource/2ndlvl.png";
	public static final String lv2w_lv2w_RSC = "PacMan/resource/2ndlvlwin.png";
	public static final String title_title_RSC = "PacMan/resource/title.png";
	public static final String FISH_FISH_RSC = "PacMan/resource/coyfish.png";
	public static final String GD_GD_RSC = "PacMan/resource/scared.png";
	public static final String GDS_GDS_RSC = "PacMan/resource/ghostdeath.wav";
	public String file = "highscore.txt";
	
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
			{3,6,3,3,3,3,0,3,3,3,1,3,3,3,3,3,3,1,3,3,3,0,3,3,3,3,5,3},//midpoint
			{1,1,1,1,1,1,0,1,1,3,1,3,3,3,3,3,3,1,3,1,1,0,1,1,1,1,1,1},
			{1,1,1,1,1,1,0,1,1,3,1,1,1,1,1,1,1,1,3,1,1,0,1,1,1,1,1,1},
			{1,1,1,1,1,1,0,1,1,3,3,3,3,3,3,3,3,3,3,1,1,0,1,1,1,1,1,1},
			{1,1,1,1,1,1,0,1,1,3,1,1,1,1,1,1,1,1,3,1,1,0,1,1,1,1,1,1},
			{1,1,1,1,1,1,0,1,1,3,1,1,1,1,1,1,1,1,3,1,1,0,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
			{1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
			{1,2,0,0,1,1,0,0,0,0,0,0,0,0,7,0,0,0,0,0,0,0,1,1,0,0,2,1},
			{1,1,1,0,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,0,1,1,1},
			{1,1,1,0,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,0,1,1,1},
			{1,0,0,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1},
			{1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
	};
	
	int mazecopy[][] = new int[31][28];
	
	int maze2[][]={
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1},
			{1,2,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,2,1},
			{1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,0,1,1,3,1,1,1,1,1,1,1,1,3,1,1,0,1,1,1,1,0,1},
			{1,0,1,1,1,1,0,1,1,3,1,1,1,1,1,1,1,1,3,1,1,0,1,1,1,1,0,1},
			{1,0,1,1,1,1,0,1,1,3,0,0,0,0,0,0,0,0,3,1,1,0,1,1,1,1,0,1},
			{1,0,0,0,0,0,0,1,1,3,1,1,1,1,1,1,1,1,3,1,1,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,0,1,1,3,1,1,1,1,1,1,1,1,3,1,1,0,1,1,1,1,0,1},
			{1,0,1,1,1,1,0,1,1,3,3,3,3,3,3,3,3,3,3,1,1,0,1,1,1,1,0,1},
			{1,0,1,1,1,1,0,1,1,3,1,1,1,1,1,1,1,1,3,1,1,0,1,1,1,1,0,1},
			{1,0,0,0,0,0,0,1,1,3,1,3,3,3,3,3,3,1,3,1,1,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,0,3,3,3,1,3,3,3,3,3,3,1,3,3,3,0,1,1,1,1,0,1},//midpoint
			{1,0,1,1,1,1,0,1,1,3,1,3,3,3,3,3,3,1,3,1,1,0,1,1,1,1,0,1},
			{1,0,1,1,1,1,0,1,1,3,1,1,1,1,1,1,1,1,3,1,1,0,1,1,1,1,0,1},
			{1,0,0,0,0,0,0,1,1,3,3,3,3,3,3,3,3,3,3,1,1,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,0,1,1,3,1,1,1,1,1,1,1,1,3,1,1,0,1,1,1,1,0,1},
			{1,0,1,1,1,1,0,1,1,3,1,1,1,1,1,1,1,1,3,1,1,0,1,1,1,1,0,1},
			{1,0,1,1,1,1,0,1,1,3,0,0,0,0,0,0,0,0,3,1,1,0,1,1,1,1,0,1},
			{1,0,0,0,0,0,0,1,1,3,1,1,3,1,1,3,1,1,3,1,1,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,0,1,1,3,1,1,3,1,1,3,1,1,3,1,1,0,1,1,1,1,0,1},
			{1,2,1,1,1,1,0,1,1,3,1,1,3,1,1,3,1,1,3,1,1,0,1,1,1,1,2,1},
			{1,0,1,1,1,1,0,1,1,3,1,1,3,1,1,3,1,1,3,1,1,0,1,1,1,1,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1},
			{1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1},
			{1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
	};
	
	int maze2copy[][]= new int[31][28];
	
	int maze2cando[][] = {
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1},
			{1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1},
			{1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,1},
			{1,0,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,1},
			{1,0,1,1,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0,1,1,0,1,1,1,1,0,1},
			{1,0,0,0,0,0,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,1},
			{1,0,1,1,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0,1,1,0,1,1,1,1,0,1},
			{1,0,1,1,1,1,0,1,1,0,1,1,1,1,0,1,1,1,0,1,1,0,1,1,1,1,0,1},
			{1,0,0,0,0,0,0,1,1,0,1,3,3,3,0,3,3,1,0,1,1,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,0,0,0,0,1,3,3,3,0,3,3,1,0,0,0,0,1,1,1,1,0,1},//midpoint
			{1,0,1,1,1,1,0,1,1,0,1,3,3,3,3,3,3,1,0,1,1,0,1,1,1,1,0,1},
			{1,0,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,1},
			{1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,1},
			{1,0,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,1},
			{1,0,1,1,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0,1,1,0,1,1,1,1,0,1},
			{1,0,0,0,0,0,0,1,1,0,1,1,0,1,1,0,1,1,0,1,1,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,0,1,1,0,1,1,0,1,1,0,1,1,0,1,1,0,1,1,1,1,0,1},
			{1,0,1,1,1,1,0,1,1,0,1,1,0,1,1,0,1,1,0,1,1,0,1,1,1,1,0,1},
			{1,0,1,1,1,1,0,1,1,0,1,1,0,1,1,0,1,1,0,1,1,0,1,1,1,1,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1},
			{1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1},
			{1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}	
	};
	
	int mazecando[][] = {
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
			{1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
			{1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,1},
			{1,0,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,1},
			{1,0,0,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1},
			{1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1},
			{1,1,1,1,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0,1,1,0,1,1,1,1,1,1},
			{1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,1,1,1,0,1,1,0,1,1,1,1,1,1},
			{1,1,1,1,1,1,0,1,1,0,1,0,0,0,0,0,0,1,0,1,1,0,1,1,1,1,1,1},
			{0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},//midpoint
			{1,1,1,1,1,1,0,1,1,0,1,0,0,0,0,0,0,1,0,1,1,0,1,1,1,1,1,1},
			{1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1},
			{1,1,1,1,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0,1,1,0,1,1,1,1,1,1},
			{1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1},
			{1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
			{1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
			{1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,1},
			{1,1,1,0,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,0,1,1,1},
			{1,1,1,0,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,0,1,1,1},
			{1,0,0,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1},
			{1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
			
	};
	
	
	PacManObj pacman;
	PacManDead pacdead;
	Blinky blinky;
	Inky inky;
	Pinky pinky;
	Clyde clyde;
	
	PacManObj pacman2;
	PacManDead pacdead2;
	Blinky blinky2;
	Inky inky2;
	Pinky pinky2;
	Clyde clyde2;
	
	
	
	float winx;
	float winy;
	int score=0;
	int highscore;
	int currentlevel=1;
	int lives=3;
	int i=0;
	int livesflag=0;
	String line = null;
	String scorearray[];
	ClassLoader classloader = Thread.currentThread().getContextClassLoader();
	InputStream is = classloader.getResourceAsStream("PacMan/highscore.txt");
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
	
		
		addState(new Splash());
		addState(new Menu());
		addState(new level2());
		addState(new level1());
		addState(new Winstate());
		addState(new Gameoverstate());
		addState(new Highscorestate());
		
		
		
		
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
		ResourceManager.loadSound(GDS_GDS_RSC);
		ResourceManager.loadImage(ST_ST_RSC);
		ResourceManager.loadImage(CH_CH_RSC);
		ResourceManager.loadImage(PE_PE_RSC);
		ResourceManager.loadImage(DE1_DE1_RSC);
		ResourceManager.loadImage(DE2_DE2_RSC);
		ResourceManager.loadImage(DE3_DE3_RSC);
		ResourceManager.loadImage(DE4_DE4_RSC);
		ResourceManager.loadImage(DE5_DE5_RSC);
		ResourceManager.loadImage(DE6_DE6_RSC);
		ResourceManager.loadImage(LIVE_LIVE_RSC);
		ResourceManager.loadImage(lv2_lv2_RSC);
		ResourceManager.loadImage(lv2w_lv2w_RSC);
		ResourceManager.loadImage(title_title_RSC);
		ResourceManager.loadImage(FISH_FISH_RSC);
		ResourceManager.loadImage(GD_GD_RSC);
		
		
		//food=new dots[244];
		
		pacman = new PacManObj(232,424,0,0);
		pacdead = new PacManDead(232,424);
		blinky = new Blinky(232,232);
		inky = new Inky(192,280);
		pinky = new Pinky(224,280);
		clyde = new Clyde(256,280);
		
		pacman2 = new PacManObj(232,536,0,0);
		pacdead2 = new PacManDead(232,424);
		blinky2 = new Blinky(232,232);
		inky2 = new Inky(192,280);
		pinky2 = new Pinky(224,280);
		clyde2 = new Clyde(256,280);
		
		
		
		scorearray = new String[10];
		//enrdot=new Energydot[4];
		//dot=new dots[241];
		
		
		
		for(int v=0;v<31;v++){
			for(int z=0;z<28;z++){
				mazecopy[v][z]=maze[v][z];
				maze2copy[v][z]=maze2[v][z];
			}
		}

        
    
		
		
	
		
		
		

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
