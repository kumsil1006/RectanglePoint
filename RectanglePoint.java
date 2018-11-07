import java.util.Scanner;

public class RectanglePoint {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		// 8 double variables to get 8 numbers from user
		double x1, y1, x2, y2, x3, y3, x4, y4;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Input 8 numbers(4 points) to make two Rectangles!");
		System.out.println("{(x1,y1),(x2,y2)}, {(x3,y3),(x4,y4)}");
		
		// input 8 numbers that indicate each two Points of two Rectangles(four Points in total)
		x1 = input.nextInt();
		y1 = input.nextInt();
		x2 = input.nextInt();
		y2 = input.nextInt();
		x3 = input.nextInt();
		y3 = input.nextInt();
		x4 = input.nextInt();
		y4 = input.nextInt();


		// rectangle 1 and 2 objects
		Rectangle rectangle1 = new Rectangle(x1,y1,x2,y2);
		Rectangle rectangle2 = new Rectangle(x3,y3,x4,y4);
		
		// an union Rectangle of rectangle 1 and rectangle 2
		Rectangle unionRectangle = rectangle1.union(rectangle2);
		
		// intersection of rectangle 1 and rectangle 2
		Rectangle intersectRectangle = rectangle1.intersect(rectangle2);
		
		// print union rectangle
		System.out.println("Union rectangle");
		System.out.println(unionRectangle.toString());
		
		/*
		 * print intersect rectangle
		 * if there is no intersection, let user knows that there is no intersection
		 * else print the detailed information about intersectRectangle
		 */
		System.out.println("Intersect rectangle");
		
		if(rectangle1.intersect(rectangle2) == null)
			System.out.println("These two obgects rectangle1 and rectangle2 has no intersection");
		else 
			System.out.println(intersectRectangle.toString());

	}

}

// Point class
class Point {
	// fields
	private double x;
	private double y;

	// methods
	// constructor sets x and y value
	public Point(double newX, double newY){
		setX(newX);
		setY(newY);
	}
	// set and get methods to set and get x, y values
	public void setX(double newX){
		this.x = newX;
	}
	public void setY(double newY){
		this.y = newY;
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	
	// toString method to show the top left point
	public String toString(){
		return String.format("This rectangle has top left point is (%.1f, %.1f) "
				, x, y);
	}


}
// Rectangle class
class Rectangle {
	
	// fields
	private Point topLeftPoint = new Point(0,0);
	private Point bottomRightPoint = new Point(0,0);

	private double width = 0;
	private double height = 0;
	
	// methods
	// constructor will initialize 2 fields(topLeftPoint, bottomRightPoint) of this class
	public Rectangle(double x1, double y1, double x2, double y2){	
		
		topLeftPoint.setX(x1);
		topLeftPoint.setY(y1);
		
		bottomRightPoint.setX(x2);
		bottomRightPoint.setY(y2);		
		
	}
	
	// constructor will initialize 2 fields(topLeftPoint, bottomRightPoint) of this class
	public Rectangle(Point p1, Point p2){
		topLeftPoint.setX(p1.getX());
		bottomRightPoint.setX(p2.getX());
		topLeftPoint.setX(p1.getY());
		bottomRightPoint.setY(p2.getY());
		
	}

	// setWidth
	public void setWidth(double x1, double x2){
		this.width = x1-x2;
	}
	// setHeight
	public void setHeight(double y1, double y2){
		this.height = y1-y2;
	}
	//getWidth
	public double getWidth(){
		return width;
	}
	// getHeight
	public double getHeight(){
		return height;
	}
	
	/*
	 * union method takes a rec2 object and return the union of the rec2 and current rectangle object 
	 */
	public Rectangle union(Rectangle rec2){	

		// union rectangle's topLeftPoint(leftSmallX, leftLargeY)
		// union rectangle's bottomRightPoint(rightLargeX, rightSmallY)
		double rightLargeX, leftSmallX, leftLargeY, rightSmallY;
		
		// find out topLeftPoint of union Rectangle
		if(topLeftPoint.getX() < rec2.topLeftPoint.getX())
			leftSmallX = topLeftPoint.getX();
		else
			leftSmallX = rec2.topLeftPoint.getX();
		if(topLeftPoint.getY() > rec2.topLeftPoint.getY())
			leftLargeY = topLeftPoint.getY();
		else 
			leftLargeY = rec2.topLeftPoint.getY();
			
		// find out bottomRightPoint of union Rectangle
		if(bottomRightPoint.getX() < rec2.bottomRightPoint.getX())
			rightLargeX = rec2.bottomRightPoint.getX();
		else
			rightLargeX = bottomRightPoint.getX();
		if(bottomRightPoint.getY() < rec2.bottomRightPoint.getY())
			rightSmallY = bottomRightPoint.getY();
		else
			rightSmallY = rec2.bottomRightPoint.getY();
		
		
		// unionRectangle object
		Rectangle unionRectangle 
			= new Rectangle(leftSmallX, leftLargeY, rightLargeX, rightSmallY);
		
		// set width and height of unionRectangle
		unionRectangle.setWidth(rightLargeX, leftSmallX);
		unionRectangle.setHeight(leftLargeY, rightSmallY);
		
		return unionRectangle;
	}
	
	/*
	 * intersect method takes a rec2 object and return the intersection of the rec2 and current rectangle object 
	 */
	public Rectangle intersect(Rectangle rec2){
		
		// intersect rectangle's topLeftPoint(leftLargeX, leftSmallY)
		// intersect rectangle's bottomRightPoint(rightSmallX, rightLargeY)
		double leftLargeX, rightSmallX, leftSmallY, rightLargeY;
		
		// find out topLeftPoint of intersect Rectangle
		if(topLeftPoint.getX() > rec2.topLeftPoint.getX())
			leftLargeX = topLeftPoint.getX();
		else
			leftLargeX = rec2.topLeftPoint.getX();
		if(topLeftPoint.getY() < rec2.topLeftPoint.getY())
			leftSmallY = topLeftPoint.getY();
		else 
			leftSmallY = rec2.topLeftPoint.getY();
		
		// find out bottomRightPoint of intersect Rectangle
		if(bottomRightPoint.getX() < rec2.bottomRightPoint.getX())
			rightSmallX = bottomRightPoint.getX();
		else 
			rightSmallX = rec2.bottomRightPoint.getX();
		if(bottomRightPoint.getY() > rec2.bottomRightPoint.getY())
			rightLargeY = bottomRightPoint.getY();
		else 
			rightLargeY = rec2.bottomRightPoint.getY();
		
		
		/*
		 * leftLargeX가 rightSmallX보다 크면 둘이 교차하는 점이 없다는 의미이고, 같다면 intersect 사각형이 만들어지는 것이 아니라, 닿는 점/면만 있게 된다.
		 * it means there is no intersection,
		 * so return null
		 */
		if(leftLargeX >= rightSmallX || rightLargeY >= leftSmallY)
			return null;
		
		// else return intersectRectangle, because it means there is an intersection
		else
		{
		Rectangle intersectRectangle = 
				new Rectangle(leftLargeX, leftSmallY, rightSmallX, rightLargeY);

		// set width and height of the intersectRectangle
		intersectRectangle.setWidth(rightSmallX, leftLargeX);
		intersectRectangle.setHeight(leftSmallY, rightLargeY);
		
		return intersectRectangle;
		}
	}
	
	// tosString method to print width and height of rectangle
	public String toString(){
		
		return topLeftPoint.toString() 
				+ String.format("and width = %.1f, height = %.1f%n"
				, getWidth(), getHeight());
				
	}
	
	
}
