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
class PacManDead extends Entity {
	public Animation PacMandeath;
	private int countdown;
	private Vector velocity;
	private int nexttile;
	private int currentile;

	public PacManDead(final float x, final float y) {
		super(x,y);
		PacMandeath = new Animation(ResourceManager.getSpriteSheet(PacManGame.DE_DE_RSC, 28, 28),240);
		addAnimation(PacMandeath);
		//addImageWithBoundingBox(ResourceManager.getImage(PacManGame.PACMAN_PACMAN_RSC));
		countdown=0;
	}

	public void setVelocity(final Vector v) {
		velocity = v;
	}
	
	public void moveleft(final int delta, float x, float y, PacManObj pac){
		this.velocity=new Vector(-.5f,0);
		this.update(delta);
	}
	
	public void update(final int delta) {
		translate(velocity.scale(delta));
		
	}
	
}
