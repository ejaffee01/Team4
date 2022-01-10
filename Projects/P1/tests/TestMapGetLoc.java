import junit.framework.*;
import java.awt.Color;
import java.io.*;


public class TestMapGetLoc extends TestCase {
	
	public void testMapGetLoc() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		PacMan pacman = frame.addPacMan(new Location(1, 1));
		assertTrue(frame.getMap().getLoc(new Location(1, 1)).contains( Map.Type.PACMAN));
	}
}
