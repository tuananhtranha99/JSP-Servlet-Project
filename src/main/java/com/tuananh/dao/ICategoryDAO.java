package com.tuananh.dao;

import java.util.List;

import com.tuananh.model.CategoryModel;

public interface ICategoryDAO {
	List<CategoryModel> findAll();
}
