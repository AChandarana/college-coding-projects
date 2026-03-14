// Copyright 2025 Alex Chandarana

public class Shape implements Comparable<Shape> {
	// Used enums to define shape types
	enum shapeType {
		Rectangle, RightTriangle, Circle;
	}
	private double area, radius, length, width, base, height;
	private shapeType type;
	public Shape(double radius) {
		this.area = (Math.PI * radius * radius);
		this.radius = radius;
		this.type = shapeType.Circle;
	}
	public Shape(double length, double width, boolean isTriangle) {
		if (isTriangle) {
			this.area = (length * width) / 2;
			this.base = length;
			this.height = width;
			this.type = shapeType.RightTriangle;
		} else {
			this.area = (length * width);
			this.length = length;
			this.width = width;
			this.type = shapeType.Rectangle;
		}
	}
	public shapeType getShape() {
		return this.type;
	}
	public double getArea() {
		return this.area;
	}
	public int compareTo(Shape shape) {
		if (shape.area > this.area) {
			return -1;
		}
		if (shape.area < this.area) {
			return 1;
		}
		
		// Returns 0 if the shapes are equal and the areas are equal
		if (this.type == shape.type) {
			return 0;
		}
		if (this.type == shapeType.Circle) {
			return -1;
		}
		if (shape.type == shapeType.Circle) {
			return 1;
		}
		if (this.type == shapeType.Rectangle) {
			return -1;
		}
		if (shape.type == shapeType.Rectangle) {
			return 1;
		}
		if (this.type == shapeType.RightTriangle) {
			return -1;
		}
		if (shape.type == shapeType.RightTriangle) {
			return 1;
		}
		return 0;
	}

	public String toString() {
		if (this.type == shapeType.Circle)
			return ("Circle\tRadius: ") + this.radius;
		if (this.type == shapeType.Rectangle)
			return ("Rectangle\tLength: ") + this.length + ("\tWidth: ") + this.width;
		if (this.type == shapeType.RightTriangle)
			return ("Right Triangle\tBase: ") + this.base + ("\tHeight: ") + this.height;
		else return "";
	}
}
