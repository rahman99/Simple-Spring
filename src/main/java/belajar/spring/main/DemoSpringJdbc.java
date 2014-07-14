package belajar.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import belajar.spring.domain.FlatShape;
import belajar.spring.jdbc.FlatShapeDAO;

public class DemoSpringJdbc {

	public static void main(String[] args) {
		int input_ID = 21;
		String input_Name="Limas";
		
		// TODO demo Spring JDBC
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		FlatShapeDAO flatShapeDao  = (FlatShapeDAO) ctx.getBean("flatshapeDAO");
		
		FlatShape addList = new FlatShape();
		addList.setId(input_ID);
		addList.setName(input_Name);
		
		try {
			flatShapeDao.save(addList);
		} catch (Exception e) {
			System.out.println("Can't be save because id = " + addList.getId() + " exist");
		}
		
		flatShapeDao.update(addList);
		
		flatShapeDao.delete(input_ID);
		
		flatShapeDao.getAllShape();
	}

}
