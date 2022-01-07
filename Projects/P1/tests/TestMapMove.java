import junit.framework.*;
import java.awt.Color;
import java.io.*;
import static org.junit.Assert.*;

public class TestMapMove {

	public void testMapMove() throws FileNotFoundException{
		NoFrame frame = new NoFrame();

		Ghost ghost = frame.addGhost(new Location(1, 1), "Test Ghost", Color.red);
		Map map = new Map(30);
		boolean gmove = map.move("Test Ghost", new Location (1,2), Map.Type.GHOST);

		assertTrue(gmove);
	}
}
