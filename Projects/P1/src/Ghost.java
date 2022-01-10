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
		return null;
	}

	public boolean move() {
		ArrayList<Location> to_check = this.get_valid_moves();
		if(to_check.size() > 0){
			myLoc = to_check.get(0);
			if (myMap.move(myName, myLoc, Map.Type.GHOST)){
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean is_pacman_in_range() { 
		return false;
	}

	public boolean attack() {
		return false;
	}
}
