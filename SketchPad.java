package Turtle;

public class SketchPad {
	private int[][] floor;
	
	public SketchPad(int row, int column) {
		floor = new int[row][column];
	}
	
	public int[][] getFloor() {
		return floor;
	}
	
	public void display() {
		for (var row : floor)   {
			for (var column : row) {
				if (column == 1) System.out.print("*, ");
				if (column == 0) System.out.print(" ");
			}
			System.out.println();
		}
	}
}
