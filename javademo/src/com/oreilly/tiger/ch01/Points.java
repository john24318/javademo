package com.oreilly.tiger.ch01;

class Point2D {
	protected int x, y;

	public Point2D() {
		this.x = 0;
		this.y = 0;
	}

	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Point3D extends Point2D {
	protected int z;

	public Point3D(int x, int y) {
		this(x, y, 0);
	}

	public Point3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

class Position2D {
	Point2D location;

	public Position2D() {
		this.location = new Point2D();
	}

	public Position2D(int x, int y) {
		this.location = new Point2D(x, y);
	}

	public Point2D getLocation() {
		return location;
	}
}

class Position3D extends Position2D {
	Point3D location;

	public Position3D(int x, int y, int z) {
		this.location = new Point3D(x, y, z);
	}

	public Point3D getLocation() {
		return location;
	}
}