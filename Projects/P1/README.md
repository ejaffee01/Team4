# Project 1: PacMan

Aiden Stern, Chiebuka Ohams, Jacob James, Lucas Balangero

## Table of Contents  
**[PacMan in Action](#pacman-in-action)**<br> 
**[Running PacMan](#running-pacman)**<br> 
**[PacMan Class Functions](#pacman-class-functions)**<br> 
**[Ghost Class Functions](#ghost-class-functions)**<br>
**[Map Class Functions](#map-class-functions)**<br> 

## PacMan in Action

(Image or video of Pacman Playing)

![screenshot of PacMan](https://github.com/cmsc388T-winter22/Team4/blob/main/Projects/P1/src/assets/pacman.png)
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
- **Description**: This method returns all the valid moves that PacMan can make given his current position.
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
  pacman.myLoc ∈ {(9,12), (10,11), (10,12)}
  ```
- **testPacManMove()**: (DESCRIPTION HERE)

### is_ghost_in_range()

- **Type**: `() -> Bool`
- **Description**: This method checks its surroundings to see if any Ghosts are in attack range. The attack radius of a ghost is 1 which means that a ghost at location <img src="https://render.githubusercontent.com/render/math?math=(x, y)"> can attack PacMan as long as PacMan is located at <img src="https://render.githubusercontent.com/render/math?math=(x \pm 1, y \pm 1)">. If any Ghosts are in the attack range, this method returns true otherwise it returns false.

- **Examples**:
  ```java
  //ghost at location (9,11)
  //pacman at location (9,12)
  pacman.is_ghost_in_range() -> true
  ```
- **testPacManInRange()**: (DESCRIPTION HERE)

### consume()

- **Type**: `() -> JComponent`
- **Description**: This method checks to see if there is a 'power-cookie' located in Pacman's current <img src="https://render.githubusercontent.com/render/math?math=(x, y)"> coordinate. If there is, this method calls the eatCookie method from the Map Class, and returns the cookie component if the cookie a consumed, and null otherwise.
- **Examples**:

```java
//pacman at location (9,12)
//cookie NOT at location (9,12)
pacman.consume() -> null
```
- **testConsume()**: (DESCRIPTION HERE)
<br><br>
## Ghost Class Functions

In this section, you must create a class for the ghosts that are moving around the map. The class and constructor are given to you in the Ghost.java file. Each team member should choose one of the following functions to complete and create a feature-item branch off of the FTR-ghost feature branch.

### get_valid_moves()

- **Type**: `() -> ArrayList<Location>`
- **Description**: This function returns an arraylist of possible locations that a ghost can move to from its current location. Ghosts cannot move through walls, but they can move through other ghosts or PacMan.
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
  ghost.myLoc ∈ {(9,12), (10,11), (10,12)}
  ```
- **testGhostMove()**: (DESCRIPTION HERE)

### is_pacman_in_range()

- **Type**: `() -> Bool`
- **Description**: This function checks its surroundings to see if PacMan is in attack range. The attack radius of a ghost is 1 which means that a ghost at location <img src="https://render.githubusercontent.com/render/math?math=(x, y)"> can attack PacMan as long as PacMan is located at <img src="https://render.githubusercontent.com/render/math?math=(x \pm 1, y \pm 1)">. If PacMan is in the attack range, this function returns true otherwise it returns false.

- **Examples**:
  ```java
  //ghost at location (9,11)
  //pacman at location (9,12)
  ghost.is_pacman_in_range() -> true
  ```
- **testGhostInRange()**: (DESCRIPTION HERE)

### attack()

- **Type**: `() -> Bool`
- **Description**: This function checks to see if PacMan is in the attack range by using the is_pacman_in_range method and attacks PacMan if it is in range. This function returns true if the attack was successful and false otherwise.

- **Examples**:
  ```java
  //ghost at location (9,11)
  //pacman at location (9,12)
  ghost.attack() -> true
  ```
- **testAttack()**: (DESCRIPTION HERE)
<br><br>
## Map Class Functions

The Map Class uses Java GUI to create the visual represenation of our game. For this project, we have given you most the code for the GUI with the exception of 4 methods which you will have to write. The goal of this section is to develop the interaction between pacman and walls and cookies as well as attacking ghosts.

### move(String name, Location loc, Type type)

- **Type**: `(String name, Location loc, Type type) -> Bool`
- **Description**: The method takes a name, location, and type and put the object specified by the name at the location. If the function is able to successfull move the object it returns true, otherwise it returns false.
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
- **testMapGetLoc()**: (DESCRIPTION HERE)

### attack(String name)

- **Type**: `(String name) -> Bool`
- **Description**: The method controls ghosts attacking pacman. If the ghost was able to successfully attack pacman and update the display to do so return true, otherwise return false.

```java
 //ghost named clyde at location (9,11)
 //pacman at location (9,12)
 Map.attack("clyde") -> true
```
- **testMapAttack()**: (DESCRIPTION HERE)

### eatCookie(String Name)

- **Type**: `() -> JComponent`
- **Description**: The method controls Pacman eating a cookie. When the function is able to successfully update display to eat a cookie it returns the Cookie component that has been eaten, otherwise it returns null.

```java
 //cookie NOT at location (4,6)
 //pacman at location (4,6)
 Map.eatCookie("pacman") -> null
```
- **testMapEatCookie()**: (DESCRIPTION HERE)
