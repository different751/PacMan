package pacman;


import org.newdawn.slick.Animation;

import jig.Entity;
import jig.ResourceManager;

public class dots extends Entity {
	public Animation dotani;
	//PacManGame.ResourceManager.loadImage(DOT_DOT_RSC);
	
	public dots(){
		//super(x,y);
		//addImageWithBoundingBox(ResourceManager.getImage(PacManGame.DOT_DOT_RSC));
		dotani = new Animation(ResourceManager.getSpriteSheet(PacManGame.DOT_DOT_RSC, 4, 4),1);
		dotani.setLooping(false);
		
		
	}

}
