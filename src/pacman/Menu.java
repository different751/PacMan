package pacman;

import jig.ResourceManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
class Menu extends BasicGameState {
	

	
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) {
		PacManGame pg = (PacManGame)game;
		for(int i=0;i<31;i++){
			for(int z=0;z<28;z++){
				pg.maze[i][z]=pg.mazecopy[i][z];
				pg. maze2[i][z]=pg. maze2copy[i][z];
			}
		}
		
		try {
            FileReader filereader = new FileReader(pg.file);

            BufferedReader buffreader = new BufferedReader(filereader);

            while((pg.line = buffreader.readLine()) != null) {
                pg.scorearray[pg.i]=pg.line;
                pg.i++;
            }   

            // Always close files.
            buffreader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file");                  
        }
	}

	
	@Override
	public void render(GameContainer container, StateBasedGame game,
			Graphics g) throws SlickException {

		PacManGame pg = (PacManGame)game;
		
		g.drawImage(ResourceManager.getImage(PacManGame.title_title_RSC), (pg.ScreenWidth/5)-135,
				pg.ScreenHeight/12);
		g.drawString("Press 'Space' To Play", (pg.ScreenWidth/2)-100, (pg.ScreenHeight/3)+15);
		//g.drawString("Press 'd' For Demo Mode", (pg.ScreenWidth/2)-100, (pg.ScreenHeight/3)+35);
		g.drawString("Press 'c' For Credits", (pg.ScreenWidth/2)-100, (pg.ScreenHeight/3)+55);
		
		g.drawString("How To Play", (pg.ScreenWidth/2)-60, (pg.ScreenHeight/2)+40);
		g.drawString("Move PacMan left by 'a' or 'left arrow'", (pg.ScreenWidth/2)-180, (pg.ScreenHeight/2)+60);
		g.drawString("Move PacMan right by 'd' or 'right arrow'", (pg.ScreenWidth/2)-192, (pg.ScreenHeight/2)+80);
		g.drawString("Move PacMan up by 'w' or 'up arrow'", (pg.ScreenWidth/2)-160, (pg.ScreenHeight/2)+100);
		g.drawString("Move PacMan down by 's' or 'down arrow'", (pg.ScreenWidth/2)-183, (pg.ScreenHeight/2)+120);
		g.drawString("Try to eat all the pellets without being caught", (pg.ScreenWidth/2)-213, (pg.ScreenHeight/2)+140);
		g.drawString("Escape to main menu by pressing 'Esc'", (pg.ScreenWidth/2)-170, (pg.ScreenHeight/2)+160);
		g.drawString("Press 'n' to skip levels", (pg.ScreenWidth/2)-113, (pg.ScreenHeight/2)+180);

	}

	@Override
	public void update(GameContainer container, StateBasedGame game,
			int delta) throws SlickException {
		Input input = container.getInput();
		PacManGame pg = (PacManGame)game;
		//pg.demo=0;
		
		
		if (input.isKeyDown(Input.KEY_SPACE))
			game.enterState(PacManGame.LEVEL2, new EmptyTransition(), new HorizontalSplitTransition() );
		
		
		
		if(input.isKeyDown(Input.KEY_C))
			game.enterState(PacManGame.SPLASH,new EmptyTransition(),new HorizontalSplitTransition());
		// check if there are any finished explosions, if so remove them
		//if (input.isKeyDown(Input.KEY_N))
			//game.enterState(PacManGame.STARTUPSTATE, new EmptyTransition(), new HorizontalSplitTransition() );

	}

	@Override
	public int getID() {
		return PacManGame.MENU;
	}
	
}