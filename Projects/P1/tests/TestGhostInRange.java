import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostInRange extends TestCase {

	public void testGhostInRange() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Ghost ghost = frame.addGhost(new Location(2, 3), "ghost", Color.red);
		PacMan pacman = frame.addPacMan(new Location(3, 3));

		assertTrue(pacman.is_ghost_in_range());
	}
}

