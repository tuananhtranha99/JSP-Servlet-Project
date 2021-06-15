package com.tuananh.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tuananh.model.UserModel;
import com.tuananh.service.ICategoryService;
import com.tuananh.service.INewsService;
import com.tuananh.serviceimpl.CategoryService;
import com.tuananh.serviceimpl.NewsService;

@WebServlet(urlPatterns = {"/trang-chu"})
public class HomeController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Inject
	private ICategoryService categoryService;
	
	@Inject
	private INewsService newsService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long categoryId =  1L;
		req.setAttribute("news", newsService.findByCategoryId(categoryId));
		req.setAttribute("categories", categoryService.findAll());
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
}
