package com.visa.training.shapes;

public class Rectangle {
	private int width,height;
	final String shapeName = "Rectangle";
	public Rectangle(int width,int height) {
		// TODO Auto-generated constructor stub
		this.width = width;
		this.height = height;
	}        
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public float computeArea() {
		return width*height;
	}
	public String getShapeName() {
		return shapeName;
	}
}
