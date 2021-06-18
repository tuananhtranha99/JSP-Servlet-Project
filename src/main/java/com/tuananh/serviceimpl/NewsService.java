package com.tuananh.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import com.tuananh.dao.INewsDAO;
import com.tuananh.model.NewsModel;
import com.tuananh.service.INewsService;

public class NewsService implements INewsService{
	@Inject
	private INewsDAO newsDAO;
	
	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		return newsDAO.findByCategoryId(categoryId);
	}

	@Override
	public NewsModel save(NewsModel newsModel) {
		Long newsId = newsDAO.save(newsModel);
		return newsDAO.findOne(newsId);
	}

}
