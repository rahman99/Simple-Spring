package belajar.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import belajar.spring.domain.Triangle;

public class DemoSimpleSpring {

	public static void main(String[] args) {
		
//		demoTanpaSpring();
		
		demoDenganSpring();
	}
	
	public static void demoTanpaSpring(){
		Triangle triangle = new Triangle();
		triangle.draw();
	}
	
	public static void demoDenganSpring(){
		/**
		 * method draw pada triangle di panggil dengan cara meng-inject file applicationContext.xml
		 * file ini berisi konfigurasi spring yang berelasi dengan class apa saja, inilah yang dinamakan sebagai dependency injection.
		 * triangle pada baris ctx.getBean("triangle") adalah memanggil id bean yang ada pada applicationContext
		 */
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		Triangle triangle = ctx.getBean("triangle", Triangle.class);
		/**
		 * pada baris yang di comment di atas, bisa juga di ganti seperti pada baris di bawah
		 * yaitu pendefinisian Triangle.class di ganti dengan casting Object
		 */
		Triangle triangle = (Triangle) ctx.getBean("triangle");
		
		
		triangle.draw();
		
		/**
		 * saat memanggil method getTriagleType, maka spring akan mengecek pada applicationContext.xml
		 * pada bean dengan id='triangle' apakah ada nilai property yang dengan name = type
		 * nilai type di sesuaikan dengan nama variable di class Triangle.
		 */
		triangle.getTriangleType();
	}

}
