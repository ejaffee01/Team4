import junit.framework.*;
import java.awt.Color;
import java.io.*;


public class TestMapMove extends TestCase{

	public void testMapMove() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		PacMan pacman = frame.addPacMan(new Location(1, 1));

		Ghost ghost = frame.addGhost(new Location(1, 1), "Test Ghost", Color.red);

		boolean gresult = frame.getMap().move("Test Ghost", new Location (1,3), Map.Type.GHOST);

		//Should fail since pacman cannot move from y=1 to y=3
		assertFalse(gresult);


		gresult = frame.getMap().move("Test Ghost", new Location (1,2), Map.Type.GHOST);
		//Should pass since ghost can move from y=1 to y=2
		assertTrue(gresult);

		//Checks if ghost is in new location
		assertTrue(frame.getMap().getLoc(new Location(1,2)).contains(Map.Type.GHOST));
	}
}
