import java.awt.Color;
import junit.framework.*;
import java.io.*;

public class TestMapAttack extends TestCase {

	public void testMapAttack() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Ghost ghost = frame.addGhost(new Location(3, 3), "Danny Phantom", Color.green);
		PacMan pacman = frame.addPacMan(new Location(2, 3));
		assertTrue(frame.getMap().attack("Danny Phantom"));
	}
}
