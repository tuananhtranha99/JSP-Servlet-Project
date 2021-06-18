package com.tuananh.service;

import java.util.List;

import com.tuananh.model.NewsModel;

public interface INewsService {
	List<NewsModel> findByCategoryId(Long categoryId);
	NewsModel save(NewsModel newsModel);
}
