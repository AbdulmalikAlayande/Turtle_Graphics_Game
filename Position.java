package Turtle;

public class Position {
	
	private int row;
	private int column;
	
	public Position(int x_axis, int y_axis) {
		row = x_axis;
		column = y_axis;
	}
	
	public int getRow() {
		return row;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public void setColumn(int column) {
		this.column = column;
	}
	
	@Override
	public String toString() {
		return "Position{" +
        "row=" + row + 
        "column=" + column +
		"}";
	}
	@Override
	public boolean equals(Object anyObject){
		if (anyObject.getClass() != this.getClass()) return false;
		Position theObject = (Position) anyObject;
		return row == theObject.row && column == theObject.column;
	}
}
