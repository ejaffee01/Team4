# Project 1: PacMan

Aiden Stern, Chiebuka Ohams, Jacob James, Lucas Balangero

## Table of Contents  
**[PacMan in Action](#pacman-in-action)**<br> 
**[Running PacMan](#running-pacman)**<br> 
**[PacMan Class Functions](#pacman-class-functions)**<br> 
**[Ghost Class Functions](#ghost-class-functions)**<br>
**[Map Class Functions](#map-class-functions)**<br> 

## PacMan in Action

![screenshot of PacMan](https://github.com/cmsc388T-winter22/Team4/blob/main/Projects/P1/src/assets/PacManScreenShot.png)
<br><br>

## Running PacMan

To run PacMan from the command line, first make sure to compile the src code with the command:

```bash
javac -cp "src/" src/*.java
```
Then you can run the compiled Java code with the command:
```bash
java -cp "src/" StartMenu
```

Make sure to run these commands from inside the P1 directory

- **javac** - compiles all of the source files
- **java** - runs the StartMenu java program
- **-cp** - specifies the classpaths
<br><br>
## PacMan Class Functions

### get_valid_moves()

- **Type**: `() -> ArrayList`
- **Description**: This method returns all the valid moves that PacMan can make given his current position. This is done by looking above, below to the right and to the left of PacMan, and check if that space contains either a wall or a ghost. If the space does not contain a ghost or a wall, it is added to an array of valid moves which is what will be returned.
- **Examples**:
  ```java
  //pacman at location (9,11)
  pacman.get_valid_moves() -> {(9,12), (10,11), (10,12)}
  ```
- **testPacMantValidMoves()**: This test checks what the result of get_valid_moves would be after we place PacMan on cordinates (1,1). Since the only empty places are (1,2) and (2,1), pac.get_valid_moves() should return an ArrayList of locations (1,2) and (2,1).

### move()

- **Type**: `() -> Bool`
- **Description**: This method uses the get_valid_moves method to find the possible locations that PacMan can move, given his current location. The method then chooses to move in one of those directions. You are free to apply an algorithm here if you would like, but the only requirement is that you move in a valid direction. If PacMan is able to move, this function returns true otherwise it returns false.
- **Examples**:
  ```java
  //pacman at location (9,11)
  pacman.move() -> true
  pacman.myLoc ??? {(9,12), (10,11), (10,12)}
  ```
- **testPacManMove()**: This test makes sure that move() returns true when valid move options are avalible. 

### is_ghost_in_range()

- **Type**: `() -> Bool`
- **Description**: This method checks its surroundings to see if any Ghosts are in attack range. The attack radius of a ghost is 1 which means that a ghost at location <img src="https://render.githubusercontent.com/render/math?math=(x, y)"> can attack PacMan as long as PacMan is located at <img src="https://render.githubusercontent.com/render/math?math=(x \pm 1, y \pm 1)">. If any Ghosts are in the attack range, this method returns true otherwise it returns false. Uses `Map.getLoc()` and `Location.shift()` to check if any of the cardinal directions 1 square away from pacman contain `Map.Type.GHOST.`

- **Examples**:
  ```java
  //ghost at location (9,11)
  //pacman at location (9,12)
  pacman.is_ghost_in_range() -> true
  ```
- **testGhostInRange()**: Creates a ghost with location (2, 3) and Pacman at location (3, 3) then asserts `pacman.is_ghost_in_range()` returns true

### consume()

- **Type**: `() -> JComponent`
- **Description**: This method checks to see if there is a 'power-cookie' located in Pacman's current (x,y) coordinate. If there is, this method calls the eatCookie method from the Map Class, and returns the cookie component if the cookie a consumed, and null otherwise. This is done by calling `Map.getLoc` with PacMan's current location, checking if it includes `Map.Type.COOKIE`, and then calling `Map.eatCookie` if so.
- **Examples**:

```java
//pacman at location (9,12)
//cookie NOT at location (9,12)
pacman.consume() -> null
```
- **testConsume()**: This test adds PacMan directly on top of a cookie at location (1,1), and asserts that `pacman.consume()` does not return `null`.
<br><br>
## Ghost Class Functions

In this section, you must create a class for the ghosts that are moving around the map. The class and constructor are given to you in the Ghost.java file. Each team member should choose one of the following functions to complete and create a feature-item branch off of the FTR-ghost feature branch.

### get_valid_moves()

- **Type**: `() -> ArrayList<Location>`
- **Description**: This function returns an arraylist of possible locations that a ghost can move to from its current location. Ghosts cannot move through walls, but they can move through other ghosts or PacMan. This is done by looking above, below to the right and to the left of the ghost, and check if that space contains either a wall. If it doesn't, then it adds the location to an array of locations in which the ghost can move in. This array is what is returned.
- **Examples**:
  ```java
  //ghost at location (9,11)
  ghost.get_valid_moves() -> {(9,12), (10,11), (10,12)}
  ```
- **testGhostValidMoves()**: This test checks what the result of get_valid_moves would be after we place a Ghost on cordinates (1,1). Since the only empty places are (1,2) and (2,1), ghost.get_valid_moves() should return an ArrayList of locations (1,2) and (2,1).

### move()

- **Type**: `() -> Bool`
- **Description**: This function uses the get_valid_moves function to find the possible locations that a ghost can move to from its current location and chooses to move in one of those directions. You are free to apply an algorithm here if you would like, but the only requirement is that you move in a valid direction. If the ghost is able to move, this function returns true otherwise it returns false.

- **Examples**:
  ```java
  //ghost at location (9,11)
  ghost.move() -> true
  ghost.myLoc ??? {(9,12), (10,11), (10,12)}
  ```
- **testGhostMove()**: This test makes sure that move() returns true when valid move options are avalible.

### is_pacman_in_range()

- **Type**: `() -> Bool`
- **Description**: This function checks its surroundings to see if PacMan is in attack range. The attack radius of a ghost is 1 which means that a ghost at location <img src="https://render.githubusercontent.com/render/math?math=(x, y)"> can attack PacMan as long as PacMan is located at <img src="https://render.githubusercontent.com/render/math?math=(x \pm 1, y \pm 1)">. If PacMan is in the attack range, this function returns true otherwise it returns false. Uses `Map.getLoc()` and `Location.shift()` to check if any of the cardinal directions 1 square away from the current ghost contains `Map.Type.PACMAN.

- **Examples**:
  ```java
  //ghost at location (9,11)
  //pacman at location (9,12)
  ghost.is_pacman_in_range() -> true
  ```
- **testPacmanInRange()**: Creates 2 ghost ghost1 at location (2, 3) and ghost2 at location (4, 4) and Pacman at location (3, 3). Asserts that `ghost1.is_pacman_in_range()` is true and `ghost2.is_pacman_in_range()` is false.

### attack()

- **Type**: `() -> Bool`
- **Description**: This function checks to see if PacMan is in the attack range by calling `is_pacman_in_range` - if PacMan is in attack range, this function calls `Map.attack` with the Ghost object's assigned name and returns the value from `Map.attack`.

- **Examples**:
  ```java
  //ghost at location (9,11)
  //pacman at location (9,12)
  ghost.attack() -> true
  ```
- **testAttack()**: This test initializes a Ghost and PacMan object right next to eachother and asserts that `Ghost.attack` returns true.
<br><br>
## Map Class Functions

The Map Class uses Java GUI to create the visual represenation of our game. For this project, we have given you most the code for the GUI with the exception of 4 methods which you will have to write. The goal of this section is to develop the interaction between pacman and walls and cookies as well as attacking ghosts.

### move(String name, Location loc, Type type)

- **Type**: `(String name, Location loc, Type type) -> Bool`
- **Description**: The method takes a name, location, and type and put the object specified by the name at the location. If the function is able to successfull move the object it returns true, otherwise it returns false. The function checks if the object type is either pacman or ghost and then checks to see if its new location is inside their list of valid moves. If it is, it will update locations, components and field ArrayList's.
- **Examples**:
  ```java
  //pacman at location (2,4)
  map.move("pacman", new Location (2,4), Map.Type.PACMAN) -> true
  ```
- **testMapMove()**: This test first tries to move a ghost from (1,1) to (1,3), which is not a valid move for the ghost, and checks if it fails. It then tries to move the ghost to coordinate (1,2), which is a valid move for the ghost, and checks if its successful. Finally it checks to see if there really is a ghost on new location (1,2).

### getLoc(Location loc)

- **Type**: `(Location loc) -> HashSet<Type>`
- **Description**: For the given location argument, returns what is currently at the location (Empty, Pacman, Cookie, Ghost, Wall).

```java
 //pacman at location (2,4)
 map.getLoc(new Location (2,4) -> Map.Type.PACMAN
```
- **testMapGetLoc()**: This test makes sure that getLoc() accuratley returns a a HashSet with the correct item in the location

### attack(String name)

- **Type**: `(String name) -> Bool`
- **Description**: The method controls ghosts attacking pacman. If the ghost was able to successfully attack pacman and update the display to do so return true, otherwise return false. This function ensures the ghost (w/ name) is on the map (in the location HashMap) and then if it is moves the ghost to pacman's location using the `Map.move()` function and sets `Map.gameOver` to true, otherwise `Map.gameOver` is false.

```java
 //ghost named clyde at location (9,11)
 //pacman at location (9,12)
 Map.attack("clyde") -> true
```
- **testMapAttack()**: Creates Ghost at location (3, 3) and pacman at location (2, 3) and asserts that `Map.attack()` returns true

### eatCookie(String Name)

- **Type**: `() -> JComponent`
- **Description**: The method controls Pacman eating a cookie. This method checks if the objects at PacMan's current location include `Map.Type.COOKIE`, and deletes
that cookie from all relevant fields in the Map class. This method returns `null` if it cannot successfully delete the cookie, or the JComponent associated with the cookie otherwise.

```java
 //cookie NOT at location (4,6)
 //pacman at location (4,6)
 Map.eatCookie("pacman") -> null
```
- **testMapEatCookie()**: This test initalizes PacMan at (1,1) with the default map configuration and asserts that the return value of `Map.eatCookie` is not null.
