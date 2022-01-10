import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;

public class PacMan{
	String myName;
	Location myLoc;
	Map myMap;
	Location shift; 

	public PacMan(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		ArrayList<Location> moves = new ArrayList<Location>();

		Location locUp = new Location(myLoc.x, myLoc.y+1);
		Location locDown = new Location(myLoc.x, myLoc.y-1);
		Location locRight = new Location(myLoc.x+1, myLoc.y);
		Location locLeft = new Location(myLoc.x-1, myLoc.y);
		//Tests if adjacent locations are hitting a wall
		if (!myMap.getLoc(locUp).contains(Map.Type.WALL) && !myMap.getLoc(locUp).contains(Map.Type.GHOST)){
			moves.add(locUp);
		}
		if (!myMap.getLoc(locDown).contains(Map.Type.WALL) && !myMap.getLoc(locDown).contains(Map.Type.GHOST)){
			moves.add(locDown);
		}
		if (!myMap.getLoc(locRight).contains(Map.Type.WALL) && !myMap.getLoc(locRight).contains(Map.Type.GHOST) ){
			moves.add(locRight);
		}
		if (!myMap.getLoc(locLeft).contains(Map.Type.WALL) && !myMap.getLoc(locLeft).contains(Map.Type.GHOST)){
			moves.add(locLeft);
		} 

		return moves;
	}

	public boolean move() {
		return false;
	}

	public boolean is_ghost_in_range() { 
		return false;
	}

	public JComponent consume() { 
 		return null;
	}
}
