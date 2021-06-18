package com.tuananh.daoimpl;

import java.util.List;

import com.tuananh.dao.ICategoryDAO;
import com.tuananh.mapper.CategoryMapper;
import com.tuananh.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

	

	@Override
	public List<CategoryModel> findAll() {
		String sql = "select * from category";
		return query(sql,new CategoryMapper());
	}
}
