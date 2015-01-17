package c02;

import java.util.Arrays;

class Point {	
	float x,y;

	public Point (){
		
	}
	
	public Point(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", toString()="
				+ super.toString() + "]";
	}
		
}


class Line {
	Point begin,end;

	public Line(Point begin, Point end) {
		super();
		this.begin = begin;
		this.end = end;
	}
	
	public float getLineLength(Point begin, Point end) {
		float summa = 0;
		summa+=(end.getX()-begin.getX())*(end.getX()-begin.getX())+(end.getY()-begin.getY())*(end.getY()-begin.getY());
		summa = (float)Math.sqrt(summa);
		return summa;
	}

	@Override
	public String toString() {
		return "Line [begin=" + begin + ", end=" + end + ", getClass()="
				+ super.toString() + "]";
	}				
}

class Polyline {
	Point[] poly = new Point[3];

	public Polyline(Point[] poly) {
		super();
		this.poly = new Point[poly.length];
		for (int i = 0; i < poly.length; i++){			
			this.poly[i] = poly[i];
		}
				
	}

	@Override
	public String toString() {
		return "Polyline [poly=" + Arrays.toString(poly) + ", toString()="
				+ super.toString() + "]";
	}
		
}

public class TestFigure {

	public static void main(String[] args) {
		System.out.println("Test Point");
		Point a = new Point(2,3);
		Point b = new Point(3,4);
		Point c = new Point(5,6);
		System.out.println(a);
		System.out.println("Test Line");
		Line l1 = new Line(a,b);
		System.out.println(l1);
		System.out.println("Test Polyline 3");
	    Point[] poly = new Point[] {a,b,c};
		Polyline p1 = new Polyline(poly);
		System.out.println(p1);
		System.out.println("Test Lengt");
		System.out.println(l1.getLineLength(a, b));

	}

}
