package belajar.spring.jdbc;

import java.util.List;

import belajar.spring.domain.FlatShape;

public interface FlatShapeDAO {

	public List<FlatShape> getAllShape();
	public void save(FlatShape flatShape);
	public void delete(int id);
	public void update(FlatShape flatShape);
}
