package belajar.spring.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class TriangleInjectObject {

	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	public void draw(){
		System.out.println("point 1 = ("+getPointA().getX()+","+getPointA().getY()+")");
		System.out.println("point 2 = ("+getPointB().getX()+","+getPointB().getY()+")");
		System.out.println("point 3 = ("+getPointC().getX()+","+getPointC().getY()+")");
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}
	
	/**
	 * saat menggunakan annotation @autowire maka pada applicationContext.xml cukup di definisikan bean pointC saja,
	 * jadi ref pada bean id = "triangleInjectObject" tidak harus di tambahkan lagi.
	 */

//	@Autowired
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	
	
}
