import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;

public class Map{

	public enum Type {
		EMPTY,
		PACMAN,
		GHOST,
		WALL,
		COOKIE		
	}
	
	private HashMap<Location, HashSet<Type>> field;
	private boolean gameOver;
	private int dim;

	private HashMap<String, Location> locations;
	private HashMap<String, JComponent> components; 
	private HashSet<Type> emptySet;
	private HashSet<Type> wallSet; 

	private int cookies = 0;

	public Map(int dim){
		gameOver = false;
		locations = new HashMap<String, Location>();
		components = new HashMap<String, JComponent>();
		field = new HashMap<Location, HashSet<Type>>();

		emptySet = new HashSet<Type>();
		wallSet = new HashSet<Type>();
		emptySet.add(Type.EMPTY);
		wallSet.add(Type.WALL);
		this.dim = dim;
	}


	public void add(String name, Location loc, JComponent comp, Type type) {
		locations.put(name, loc);
		components.put(name, comp);
		if (!field.containsKey(loc)) field.put(loc, new HashSet<Type>());
		field.get(loc).add(type);
	}

	public int getCookies() {
		return cookies;
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
		
	public boolean move(String name, Location loc, Type type) {
		Location oldLoc = locations.get(name);
		if (type == (Map.Type.PACMAN)){
			PacMan pac = new PacMan(name, oldLoc, this);
			
			if (pac.get_valid_moves().contains(loc)){
				//update locations, components, and field
				locations.put(name, loc);
				//use the setLocation method for the component to move it to the new location
				components.get(name).setLocation(loc.x,loc.y);
				field.get(loc).add(type);
				return true;
			}
			else{
				return false;
			}
		}else if (type == (Map.Type.GHOST)){
			Ghost ghost = new Ghost(name, oldLoc, this);
			if (ghost.get_valid_moves().contains(loc)){
				//update locations, components, and field
				locations.put(name, loc);
				//use the setLocation method for the component to move it to the new location
				components.get(name).setLocation(loc.x,loc.y);
				field.get(loc).add(type);
				
				return true;
			}
			else{
				return false;
			}
		}else {
			return false;
		}
	}
	
	public HashSet<Type> getLoc(Location loc) {
		return field.get(loc);
	}

	public boolean attack(String Name) {
		if (locations.containsKey(Name) && move(Name, locations.get("pacman"), Type.GHOST)) {
			//update gameOver
			this.gameOver = true;
		}
		return gameOver;
	}
	
	public JComponent eatCookie(String name) {
        Location location = this.locations.get(name);
        HashSet<Type> objects = this.getLoc(location);
	    if (!(objects.contains(Map.Type.COOKIE) && objects.contains(Map.Type.PACMAN))) {
            return null;
        }
        //the id for a cookie at (10, 1) is tok_x10_y1
        String key = String.format("tok_x%d_y%d", location.x, location.y);
        //update locations, components, field, and cookies
        this.locations.remove(key);
        objects.remove(Map.Type.COOKIE);
        this.cookies += 1;
        return this.components.remove(key);
	}
}
