package com.visa.training.shapes;
/*6. Create a class called Circle with following members :
an int type data member called radius
a constructor to accept the radius
a method called getShapeName() which returns "Circle"
a method named computeArea() which returns the area of a the circle
Create a class CircleApp (with a main) which instantiates and displays areas of circle objects with different radii
Create a class called Rectangle with following members : 
two int type data members called width and height
a constructor to accept the width and height
a method called getShapeName() which returns "Rectangle"
a method named computeArea() which returns the area of a the rectangle
Create a class RectangleApp (with a main) which instantiates and displays areas of rectangle objects with different sizes
In both of the above classes, should the user be able to directly access the fields?
What would be the impact of providing setter methods in these classes? Say if we were to introduce a 'draw' method?
Complete the above before reading/proceeding further

7.  Create a class called ShapesApp which wants to maintain an array (mixed) which contains objects of type both rectangle and circle (and any other shapes that will get developed later).
The ShapesApp class wants to have a method 'displayShape' to which you should be able to pass objects of type both circle and rectangle (and any other shapes that will get developed later).
Create a class Shape to which both Circle and Rectangle can substitute. What abstraction should Shape class have?
*/
public class Circle {
	private double radius;
	final String shapeName = "Circle";
	public Circle(double rad) {
		// TODO Auto-generated constructor stub
		this.radius = rad;
	}                        
	public double computeArea() {
		double PI = (double)3.142;
		return PI*radius*radius;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public String getShapeName() {
		return shapeName;
	}
}
