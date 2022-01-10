import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;


public class TestGhostValidMoves extends TestCase {

	public void testGhostValidMoves() throws FileNotFoundException{
		//put ghost on a corner (1,1), and u should get back (1,2) and (2,1)
		ArrayList<Location> result = new ArrayList<Location>();
		//MainFrame frame = new MainFrame();
		NoFrame frame = new NoFrame();
		
		Ghost ghost = frame.addGhost(new Location(1,1), "Test Ghost", Color.red);
		
		//put pacman on a corner (1,1), and u should get back (1,2) and (2,1)
		result.add(new Location(1,2));
		result.add(new Location(2,1));
		
		assertEquals(ghost.get_valid_moves(), result);
	}
}
