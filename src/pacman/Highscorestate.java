package pacman;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.HorizontalSplitTransition;

import java.io.*;
import java.util.Arrays;

public class Highscorestate extends BasicGameState {
	int intscores[];

	PacManGame pg;
	int timer;
	
	boolean ishigh = false;

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		
		
	}
	
	public void enter(GameContainer container, StateBasedGame game){
		intscores=new int[10];
		timer = 8000;
		pg = (PacManGame)game;
		pg.lives=3;
		
		this.scoretoint();
		for(int i=0;i<10;i++){
			if(pg.score>intscores[i]){
					ishigh =true;
			}
		}
		
		if(ishigh){
			intscores[9]=pg.score;
		}
		//for(int i=0;i<10;i++){
			//System.out.println(intscores[i]);
		//}
		
		this.shiftscore();
		this.write();
		pg.score=0;
		pg.i=0;
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		
		g.drawString("TOP SCORES", 192, 224);
		for(int i=1;i<11;i++){
			g.drawString((i)+" : "+intscores[i-1], 192, 224+(16*i));
		}
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		// TODO Auto-generated method stub
		timer -= delta;
		if (timer <= 0)
			game.enterState(PacManGame.MENU, new EmptyTransition(), new HorizontalSplitTransition() );

		// check if there are any finished explosions, if so remove them
		
	}
	
	public void write(){
		try {
            FileWriter filewriter = new FileWriter(pg.file);

            BufferedWriter buffwriter = new BufferedWriter(filewriter);

            for(int i=0;i<9;i++){
            	buffwriter.write("" + intscores[i] + "\n");
            }
            
            buffwriter.write("" + intscores[9]);
            buffwriter.close();
        }
        catch(IOException ex) {
            System.out.println( "Error writing to file");
        }
	}
	
	public void scoretoint(){
		for(int i=0;i<10;i++){
			intscores[i]=Integer.parseInt(pg.scorearray[i]);
			//System.out.println(intscores[i]);
			//System.out.println(pg.scorearray);
		}
	}
	
	public void shiftscore(){
		int temp=0;
		for (int i = 0; i < 9; i++){
            for (int z = 0; z < 9-i; z++){
                if (intscores[z] < intscores[z+1]){
                    temp = intscores[z];
                    intscores[z] = intscores[z+1];
                    intscores[z+1] = temp;
                }
            }
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 4;
	}

}
