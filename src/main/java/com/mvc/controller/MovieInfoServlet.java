package com.mvc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.CommonView;
import com.mvc.repository.MovieInfoRepository;

public class MovieInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieInfoRepository miRepo = new MovieInfoRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = CommonView.getCmd(request);
		if("list".equals(uri)) {
			request.setAttribute("movieInfoList", miRepo.selectMovieInfoList());
		} else if("view".equals(uri)) {
			request.setAttribute("movieInfo", miRepo.selectMovieInfo(request.getParameter("miNum")));
		} else if("insert".equals(uri)) {
		} else if("update".equals(uri)) {
			request.setAttribute("movieInfo", miRepo.selectMovieInfo(request.getParameter("miNum")));
		} else if("delete".equals(uri)) {
		}
		CommonView.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = CommonView.getCmd(request);
		if("insert".equals(uri)) {
			Map<String, String> movieInfo = new HashMap<>();
			movieInfo.put("miNum", request.getParameter("miNum"));
			movieInfo.put("miTitle", request.getParameter("miTitle"));
			movieInfo.put("miDesc", request.getParameter("miDesc"));
			movieInfo.put("miGenre", request.getParameter("miGenre"));
			movieInfo.put("miCredate", request.getParameter("miCredate"));
			movieInfo.put("miCnt", request.getParameter("miCnt"));
			int result = miRepo.insertMovieInfo(movieInfo);
			request.setAttribute("msg", "등록 실패");
			request.setAttribute("url", "/movie-info/insert");
			if(result == 1) {
				request.setAttribute("msg", "등록 성공");
				request.setAttribute("url", "/movie-info/list");
			}
		} else if("update".equals(uri)) {
			Map<String, String> movieInfo = new HashMap<>();
			movieInfo.put("miNum", request.getParameter("miNum"));
			movieInfo.put("miTitle", request.getParameter("miTitle"));
			movieInfo.put("miDesc", request.getParameter("miDesc"));
			movieInfo.put("miGenre", request.getParameter("miGenre"));
			movieInfo.put("miCredate", request.getParameter("miCredate"));
			movieInfo.put("miCnt", request.getParameter("miCnt"));
			int result = miRepo.updateMovieInfo(movieInfo);
			request.setAttribute("msg", "수정 실패");
			request.setAttribute("url", "/movie-info/update?miNum=" + request.getParameter("miNum"));
			if(result == 1) {
				request.setAttribute("msg", "수정 성공");
				request.setAttribute("url", "/movie-info/list");				
			}
		} else if("delete".equals(uri)) {
			int result = miRepo.deleteMovieInfo(request.getParameter("miNum"));
			request.setAttribute("msg", "삭제 실패");
			request.setAttribute("url", "/movie-info/view?miNum=" + request.getParameter("miNum"));
			if(result == 1) {
				request.setAttribute("msg", "삭제 성공");
				request.setAttribute("url", "/movie-info/list");
			}
		}
		CommonView.goMassagePage(request, response);
	}

}
