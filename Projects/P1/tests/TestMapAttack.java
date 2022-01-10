import java.awt.Color;
import junit.framework.*;

public class TestMapAttack extends TestCase {

	public void testMapAttack() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		frame.addGhost(new Location(3, 3), "Phantom", Color.green);
		frame.addPacMan(new Location(3, 2));

		assertTrue(frame.getMap().attack("Phantom"));
	}
}
