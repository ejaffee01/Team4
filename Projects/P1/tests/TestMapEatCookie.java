import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapEatCookie extends TestCase {
	
	public void testMapEatCookie() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
        frame.initPlayers();
        this.assertNotNull(frame.getMap().eatCookie("pacman"));
	}
}
