package it.marteEngine.test.zombieEscape.state;

import it.marteEngine.ME;
import it.marteEngine.ResourceManager;
import it.marteEngine.State;
import it.marteEngine.entity.Entity;

import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.util.Log;

public class WaitState implements State {

	private Entity e;

	private int radar = 300;
	private Circle radarCircle;

	public WaitState(Entity zombie) {
		this.e = zombie;
	}

	public void init() {
		Log.debug("i'm waiting");
		radarCircle = new Circle(e.x + e.width / 2, e.y + e.height / 2, radar);
	}

	public void update(GameContainer container, int delta) {
		radarCircle = new Circle(e.x + e.width / 2, e.y + e.height / 2, radar);
		List<Entity> onSight = e.intersect(radarCircle);
		if (onSight != null && !onSight.isEmpty()) {
			Log.debug("enemy on sight!");
			e.stateManager.enter(AlertState.class);
		}
	}

	public void render(Graphics g) {
		g.drawImage(e.getCurrentImage(), e.x, e.y);

		// render status image on top left of parent image
		g.drawImage(ResourceManager.getImage("wait"), e.x - 10, e.y - 10);
		if (ME.debugEnabled) {
			g.draw(radarCircle);
		}

	}

}
