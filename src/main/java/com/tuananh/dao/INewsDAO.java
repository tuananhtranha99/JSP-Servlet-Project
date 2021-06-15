package com.tuananh.dao;

import java.util.List;

import com.tuananh.model.NewsModel;

public interface INewsDAO {
	List<NewsModel> findByCategoryId(Long categoryId);
}
