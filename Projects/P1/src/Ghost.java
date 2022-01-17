import java.util.HashSet;
import java.util.ArrayList;

public class Ghost{
	String myName;
	Location myLoc;
	Map myMap;

	public Ghost(String name, Location loc, Map map) {
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
		if (!myMap.getLoc(locUp).contains(Map.Type.WALL)){
			moves.add(locUp);
		}
		if (!myMap.getLoc(locDown).contains(Map.Type.WALL)){
			moves.add(locUp);
		}
		if (!myMap.getLoc(locRight).contains(Map.Type.WALL)){
			moves.add(locDown);
		}
		if (!myMap.getLoc(locLeft).contains(Map.Type.WALL)){
			moves.add(locDown);
		}
		
		return moves;
	}

	public boolean move() {
		ArrayList<Location> to_check = this.get_valid_moves();
		if(to_check.size() > 0){
			myLoc = to_check.get(0);
			if (myMap.move(myName, myLoc, Map.Type.GHOST)) {
				return false;
			}
			return true;
		}
		return true;
	}

	public boolean is_pacman_in_range() { 
		if (myMap.getLoc(myLoc.shift( 0, -1)).contains(Map.Type.GHOST) ||
                    myMap.getLoc(myLoc.shift( 0,  1)).contains(Map.Type.GHOST) ||
                    myMap.getLoc(myLoc.shift(-1,  0)).contains(Map.Type.GHOST) ||
                    myMap.getLoc(myLoc.shift( 1,  0)).contains(Map.Type.GHOST)) {
                        return true;
                }

		return false;
	}

	public boolean attack() {
		return (this.is_pacman_in_range() && this.myMap.attack(this.myName));
	}
}
