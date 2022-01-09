import java.awt.Color;
import junit.framework.*;

public class TestMapAttack extends TestCase{

	public void testMapAttack() {
		NoFrame frame = new NoFrame();
		Ghost ghost = new Ghost(new Location(3, 3), "Danny Phantom", Color.green);
		Pacman pacman = new Pacman(new Location(3, 2));
		assertTrue(frame.getMap().attack("Danny Phantom"));
	}
}
