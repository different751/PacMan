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
	public Animation PacMandeath;
	public Animation PacManLeft;
	public Animation PacManDown;
	public Animation PacManUp;
	private int countdown;
	private Vector velocity;
	private int nexttile;
	private int currentile;

	public PacManObj(final float x, final float y, final float vx, final float vy) {
		super(x,y);
		PacManAni = new Animation(ResourceManager.getSpriteSheet(PacManGame.PACMAN_PACMAN_RSC, 28, 28),75);
		PacMandeath = new Animation(ResourceManager.getSpriteSheet(PacManGame.DE_DE_RSC, 28, 28),240);
		PacManLeft = new Animation (ResourceManager.getSpriteSheet(PacManGame.PML_PML_RSC, 28, 28),75);
		PacManDown = new Animation (ResourceManager.getSpriteSheet(PacManGame.PMD_PMD_RSC, 28, 28),75);
		PacManUp = new Animation (ResourceManager.getSpriteSheet(PacManGame.PMU_PMU_RSC, 28, 28),75);
		//addAnimation(PacManLeft);
		PacManAni.setLooping(true);
		PacManLeft.setLooping(true);
		PacManDown.setLooping(true);
		PacManUp.setLooping(true);
		//addImageWithBoundingBox(ResourceManager.getImage(PacManGame.PACMAN_PACMAN_RSC));
		countdown=0;
		velocity= new Vector(vx,vy);
		//ResourceManager.getSound(BounceGame.BANG_EXPLOSIONSND_RSC).play();
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