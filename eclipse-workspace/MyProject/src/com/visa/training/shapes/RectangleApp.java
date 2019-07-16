package com.visa.training.shapes;

public class RectangleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle r1 = new Rectangle(3,4);
		System.out.print("width: ");
		System.out.println(r1.getWidth());
		System.out.print("Area: ");
		System.out.println(r1.computeArea());


		Rectangle r2 = new Rectangle(5,6);
		System.out.print("width: ");
		System.out.println(r2.getWidth());
		System.out.print("Area: ");
		System.out.println(r2.computeArea());
	}

}
