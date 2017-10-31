package project1;

public class Square {
	int sideLength;
	public Square() {
		this.sideLength = 1;
	}
	public Square(int length) {
		this.sideLength = length;
	}
	
	public int Area() {
		return sideLength * sideLength;
	}
}
