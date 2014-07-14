package belajar.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import belajar.spring.domain.TriangleInjectObject;

public class DemoSpringInjectObject {

	public static void main(String[] args) {

		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		TriangleInjectObject triangle = (TriangleInjectObject) ctx.getBean("triangleInjectObject");
		triangle.draw();
	}

}
