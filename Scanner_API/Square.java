public class Square{
	private float sideLength;

	//Constructor
	public Square(float sideLength){
		this.sideLength = sideLength;
	}

	//Getters and setters
	public float getSideLenghth(){
		return this.sideLength;
	}

	public void setSideLength(float sideLength){
		this.sideLength = sideLength;
	}

	public double calcArea(){
		return Math.pow(this.sideLength, 2);
	}
}