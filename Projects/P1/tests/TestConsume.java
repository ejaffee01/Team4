import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestConsume extends TestCase {

	public void testConsume() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
        PacMan pacman = frame.addPacMan(new Location(1, 1));
        this.assertNotNull(pacman.consume());
	}
}
