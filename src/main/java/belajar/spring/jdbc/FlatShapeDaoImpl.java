package belajar.spring.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import belajar.spring.domain.FlatShape;

public class FlatShapeDaoImpl implements FlatShapeDAO{

	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<FlatShape> getAllShape() {
		String queryList="SELECT id, name FROM flatshape";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<FlatShape> flatShapes= new ArrayList<FlatShape>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(queryList);
		
		for(Map<String, Object> flatShapeRows : rows){
			FlatShape shape = new FlatShape();
			shape.setId(Integer.parseInt(String.valueOf(flatShapeRows.get("id"))));
			shape.setName(String.valueOf(flatShapeRows.get("name")));
			flatShapes.add(shape);
		}
		
		System.out.println(flatShapes);
		return flatShapes;
	}
	

	public void save(FlatShape flatShape) {
		String query = "insert into flatshape (id, name) values (?,?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Object[] args = new Object[] {flatShape.getId(), flatShape.getName()};
		
		int out = jdbcTemplate.update(query, args);
		
		if(out!=0)
			System.out.println("Saving with ID = "+flatShape.getId()+" Success");
		else
			System.out.println("Saving with ID = "+flatShape.getId()+ " Failed");
	}

	public void delete(int id) {
		String query = "Delete From flatshape where id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		int out = jdbcTemplate.update(query, id);
		if(out!=0)
			System.out.println("Deleted with ID = "+id+" Success");
		else
			System.out.println("Deleted with ID = "+id+ " Failed");
	}

	public void update(FlatShape flatShape) {
		String query = "update flatshape set name = ? where id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Object[] args = new Object[] {flatShape.getName(), flatShape.getId()};
		
		int out = jdbcTemplate.update(query, args);
		
		if(out!=0)
			System.out.println("update with ID = "+flatShape.getId()+" Success");
		else
			System.out.println("update with ID = "+flatShape.getId()+ " Failed");
		
	}

}
