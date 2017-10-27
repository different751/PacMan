package pacman;


import org.newdawn.slick.Animation;

import jig.Entity;
import jig.ResourceManager;

public class Energydot extends Entity {
	public Animation enrani;
	//use render instead
	
	public Energydot(){
		
		//addImageWithBoundingBox(ResourceManager.getImage(PacManGame.DOT_DOT_RSC));
		enrani = new Animation(ResourceManager.getSpriteSheet(PacManGame.ENR_ENR_RSC, 16, 16),1);
		enrani.setLooping(false);
		
		
	}

}

