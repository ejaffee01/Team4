import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManInRange extends TestCase {

	public void testPacManInRange() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
                Ghost godel = frame.addGhost(new Location(2, 3), "godel", Color.red);
                Ghost escher = frame.addGhost(new Location(4, 4), "escher", Color.red);
                Pacman bach = frame.addPacman(new Location(3, 3));

                assertTrue(godel.is_pacman_in_range());
		assertFalse(escher.is_pacman_in_range());

	}
}
