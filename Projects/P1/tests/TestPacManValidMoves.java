import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestPacManValidMoves extends TestCase {
	
	public void testPacManValidMoves() throws FileNotFoundException{
		ArrayList<Location> result = new ArrayList<Location>();
		//MainFrame frame = new MainFrame();
		NoFrame frame = new NoFrame();
		
		PacMan pac = frame.addPacMan(new Location(1,1));
		
		//put pacman on a corner (1,1), and u should get back (1,2) and (2,1)
		result.add(new Location(1,2));
		result.add(new Location(2,1));
		
		assertEquals(pac.get_valid_moves(), result);
		
	}
}
