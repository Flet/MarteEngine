package it.marteEngine.test.tiled;

import it.marteEngine.ResourceManager;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Test for Tiled (http://mapeditor.org) support
 * 
 * @author Gornova
 */
public class TiledTest extends StateBasedGame {

	public TiledTest() throws SlickException {
		super("Tiled Integration Test");
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		ResourceManager.loadResources("data/helloWorld/resources.xml");
		addState(new TiledWorld(1, container));
	}

	public static void main(String[] argv) {
		try {
			AppGameContainer container = new AppGameContainer(new TiledTest());
			container.setDisplayMode(800, 600, false);
			container.setTargetFrameRate(60);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}
