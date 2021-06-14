package com.tuananh.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import com.tuananh.dao.ICategoryDAO;
import com.tuananh.daoimpl.CategoryDAO;
import com.tuananh.model.CategoryModel;
import com.tuananh.service.ICategoryService;

public class CategoryService implements ICategoryService{
	
	@Inject
	private ICategoryDAO categoryDAO;
	
	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		return categoryDAO.findAll();
	}

}
