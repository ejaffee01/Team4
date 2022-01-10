import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostMove extends TestCase {

	public void testGhostMove() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Ghost ghost  = frame.addGhost(new Location(1, 1), "Danny Phantom", Color.green);
		assertEquals(ghost.move(), true);
	}
}
