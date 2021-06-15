package com.tuananh.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tuananh.dao.INewsDAO;
import com.tuananh.model.CategoryModel;
import com.tuananh.model.NewsModel;

public class NewsDAO implements INewsDAO{

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/new_servlet_jdbc";
			String user = "root";
			String password = "hongminh";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}

	}
	
	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		List<NewsModel> results = new ArrayList<>();
		String sql = "select * from news where categoryid = ?";

		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setLong(1, categoryId);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					NewsModel news = new NewsModel();
					news.setId(resultSet.getLong("id"));
					news.setTitle(resultSet.getString("title"));
					results.add(news);
				}

				return results;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				return null;
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
					if (statement != null) {
						statement.close();
					}
					if (resultSet != null) {
						resultSet.close();
					}
				} catch (SQLException e) {
					return null;
				}
			}

		}
		return null;
	}

}
