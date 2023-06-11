package Turtle;

import static Turtle.Direction.*;
public class Turtle {
	private Position position = new Position(0, 0);
	
	private Direction direction = EAST;
	private boolean penIsDown;
	
	public boolean isPenDown() {
		return penIsDown;
	}
	
	public void movePenDown() {
		penIsDown = true;
	}
	
	public void movePenUp() {
		penIsDown = false;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public void turnRight() {
		if (direction == WEST) face(NORTH);
		else if (direction == SOUTH) face(WEST);
		else if (direction == EAST) face(SOUTH);
		else face(EAST);
		
	}
	
	private void face(Direction newDirection) {
		direction = newDirection;
	}
	
	public void turnLeft() {
		if (direction == SOUTH) face(EAST);
		else if (direction == WEST) face(SOUTH);
		else if (direction == NORTH) face(WEST);
		else if (direction == EAST) face(NORTH);
	}
	
	public Position getPosition() {
		return position;
	}
	
	private void moveForward(int numberOfMoves) {
		if (direction == EAST) moveHorizontallyBy(numberOfMoves);
		if (direction == WEST) moveHorizontallyBy(-numberOfMoves);
	}
	
	public void moveHorizontallyBy(int numberOfMoves) {
		position.setColumn(position.getColumn() + numberOfMoves);
	}
	
	public void moveForward(int movement, SketchPad sketchPad) {
		if (penIsDown) writeOnMovingForward(sketchPad, movement);
		moveForward(movement);
	}
	
	private void moveBackward(int numberOfMoves) {
		if (direction == EAST) moveHorizontallyBy(-numberOfMoves);
		if (direction == WEST) moveHorizontallyBy(numberOfMoves);
	}
	
	public void  moveBackWard(int numberOfMoves, SketchPad sketchPad){
		if (penIsDown)
			writeOnMovingBackward(sketchPad, numberOfMoves);
		moveBackward(numberOfMoves);
		
	}
	
	private void writeOnMovingBackward(SketchPad sketchPad, int numberOfMoves) {
		int[][] floor= sketchPad.getFloor();
		if (direction == EAST) writeWestwardsMovingBackWard(numberOfMoves, floor);
		if (direction == WEST) writeEastWardsMovingBackward(numberOfMoves, floor);
	}
	
	private void writeWestwardsMovingBackWard(int numberOfMoves, int[][] floor) {
		
	}
	
	private void writeEastWardsMovingBackward(int numberOfMoves, int[][] floor) {
	
	}
	
	private void writeOnMovingForward(SketchPad sketchPad, int movement) {
		var floor = sketchPad.getFloor();
		if (direction == EAST) writeEastWardsMovingForward(movement, floor);
		if (direction == WEST) writeWestWardsMovingForward(movement, floor);
	}
	
	private void writeWestWardsMovingForward(int movement, int[][] floor) {
		int row = position.getRow();
		int currentColumn = position.getColumn();
		for (int column = currentColumn; column > currentColumn - movement; column--) {
			floor[row][column] = 1;
		}
	}
	
	private void writeEastWardsMovingForward(int numberOfMoves, int[][] floor) {
		int row = position.getRow();
		int currentColumn = position.getColumn();
		for (int column = currentColumn; column < numberOfMoves + currentColumn; column++) {
			floor[row][column] = 1;
		}
	}
	
	
	public void moveForwardIfDirectionIsWest(int numberOfMoves) {
		if (direction == WEST)
			moveHorizontallyBy(-numberOfMoves);
	}
	
	public void moveBackwardIfDirectionIsEast(int numberOfMoves) {
		if (direction == EAST)
			position.setColumn(position.getColumn() - numberOfMoves);
	}
	
	public void moveBackwardIfDirectionIsWest(int numberOfMoves) {
		if (direction == WEST)
			position.setColumn(position.getColumn() + numberOfMoves);
	}
	
	public void moveUpwardFacingNorth(int numberOfMoves) {
		if (direction == NORTH)
			position.setRow(position.getRow() - numberOfMoves);
	}
	
	public void moveDownwardFacingSouth(int numberOfMoves) {
		if (direction == SOUTH)
			position.setRow(position.getRow() + numberOfMoves);
	}
}