package com.tuananh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tuananh.model.NewsModel;

public class NewsMapper implements RowMapper<NewsModel>{

	@Override
	public NewsModel mapRow(ResultSet resultSet) {
		try {
			NewsModel news = new NewsModel();
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setContent(resultSet.getString("content"));
			news.setCategoryId(resultSet.getLong("categoryid"));
			return news;
		} catch (SQLException e) {
			return null;
		}
		
	}

}
