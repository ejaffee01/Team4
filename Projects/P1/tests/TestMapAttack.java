import java.awt.Color;
import junit.framework.*;

public class TestMapAttack extends TestCase throws FileNotFoundException{

	public void testMapAttack() {
		NoFrame frame = new NoFrame();
		Ghost ghost = new Ghost(new Location(3, 3), "Phantom", Color.green);
		frame.addGhost(new Location(3, 3), "Phantom", Color.green);
		
		PacMan pacman = new Pacman(new Location(3, 2));
		frame.addPacMan(new Location(3, 2));

		assertTrue(frame.getMap().attack("Phantom"));
	}
}
