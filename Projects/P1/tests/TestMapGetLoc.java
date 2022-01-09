import junit.framework.*;
import java.awt.Color;
import java.io.*;


public class TestMapGetLoc extends TestCase {
	
	public void testMapGetLoc() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		PacMan pacman = frame.addPacMan(new Location(1, 1));
		assertEquals(frame.getLoc(new Location(1, 1)), Map.Type.PACMAN);
	}
}
