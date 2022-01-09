import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestAttack extends TestCase {

	public void testAttack() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
        Ghost ghost = frame.addGhost(new Location(1, 1));
        PacMan pacMan = frame.addPacMan(new Location(1, 2));
        assertEquals(ghost.attack(), true);
	}
}
