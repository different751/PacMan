package pacman;

import jig.Entity;
import jig.ResourceManager;
import jig.Vector;

import org.newdawn.slick.Animation;





/**
 * A class representing a transient explosion. The game should monitor
 * explosions to determine when they are no longer active and remove/hide
 * them at that point.
 */
class PacManObj extends Entity {
	public Animation PacManAni;
	private int countdown;
	

	public PacManObj() {
		PacManAni = new Animation(ResourceManager.getSpriteSheet(PacManGame.PACMAN_PACMAN_RSC, 28, 28),75);
		PacManAni.setLooping(true);
		countdown=0;
		//ResourceManager.getSound(BounceGame.BANG_EXPLOSIONSND_RSC).play();
	}

	
	public void update(final int delta) {
		update(delta);
	}
	
}