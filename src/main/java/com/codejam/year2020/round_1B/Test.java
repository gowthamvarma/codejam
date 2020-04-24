package com.codejam.year2020.round_1B;
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		System.out.println("Start");
		List<Point> pList = new ArrayList<Point>();
		List<Point> pListNext = null;
		pList.add(new Point(0, 0,""));
		for (int i = 0; i < 4 ; i++) {
			pListNext = new ArrayList<Point>();
			for (Point point : pList) {
				pListNext.add(new Point(point.x, (int)(point.y + Math.pow(2,i)), point.direction + "N"));
				pListNext.add(new Point(point.x, (int)(point.y - Math.pow(2,i)), point.direction + "S"));
				pListNext.add(new Point((int)(point.x + Math.pow(2,i)), point.y, point.direction + "W"));
				pListNext.add(new Point((int)(point.x - Math.pow(2,i)), point.y, point.direction + "E"));
			}
			pList = pListNext;
			for (Point point : pListNext) {
				System.out.println(point);
			}
			System.out.println("----");
		}
		
		
	}
}

class Point2{
	int x;
	int y;
	String direction;
	
	public Point2(int x,int y,String direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}
