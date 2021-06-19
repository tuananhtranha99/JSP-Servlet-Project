package com.tuananh.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.tuananh.dao.INewsDAO;
import com.tuananh.mapper.NewsMapper;
import com.tuananh.model.NewsModel;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO {

	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		String sql = "select * from news where categoryid = ?";
		return query(sql, new NewsMapper(), categoryId);
	}

	@Override
	public Long save(NewsModel newsModel) {
		String sql = "Insert into news(title, content, categoryid) values (?, ?, ?)";
		return insert(sql, newsModel.getTitle(), newsModel.getContent(), newsModel.getCategoryId());
	}

	@Override
	public NewsModel findOne(Long id) {
		String sql = "select * from news where id = ?";
		List<NewsModel> news = query(sql, new NewsMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void update(NewsModel updateNews) {
		StringBuilder sql = new StringBuilder("Update news set ");
		sql.append("title = ?,");
		sql.append(" content = ?,");
		sql.append(" thumbnail = ?,");
		sql.append(" shortdescription = ?,");
		sql.append(" categoryid = ?,");
		sql.append(" createddate = ?,");
		sql.append(" createdby = ?");
		sql.append(" where id = ?");
		update(sql.toString(), updateNews.getTitle(), updateNews.getContent(), updateNews.getThumbnail(),
				updateNews.getShortDescription(), updateNews.getCategoryId(),
				updateNews.getCreatedDate(), updateNews.getCreatedBy(), updateNews.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "delete from news where id = ?";
		update(sql, id);
		
	}

}
