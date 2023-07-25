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
import com.mvc.repository.UserInfoRepository;

public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoRepository uiRepo = new UserInfoRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = CommonView.getCmd(request);
		if("list".equals(uri)) {
			request.setAttribute("userInfoList", uiRepo.selectUserInfoList());
		} else if("view".equals(uri)) {
			request.setAttribute("userInfo", uiRepo.selectUserInfo(request.getParameter("uiNum")));
		} else if("insert".equals(uri)) {
//			insert가 doGet, doPost 둘다 있는 이유는 doGet에 있는거는 insert 페이지를 가려는거고 doPost에 있는거는 실제 데이터 삭제를 하려는거같음
		} else if("update".equals(uri)) {
			request.setAttribute("userInfo", uiRepo.selectUserInfo(request.getParameter("uiNum")));
		} else if("delete".equals(uri)) {
		}
		CommonView.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 이거 하면 한글 안 깨짐, doGet은 안해도 안 깨짐
		String uri = CommonView.getCmd(request);
		if("insert".equals(uri)) {
			// 대입 할때만 쓸거면 변수를 새로 만들 필요 없고 직접 대입하는게 좋을 수도 있는데 무조건 그런건 아님
//			String uiId = request.getParameter("uiId");
//			String uiPwd = request.getParameter("uiPwd");
//			String uiName = request.getParameter("uiName");
			
			Map<String, String> param = new HashMap<>();
			param.put("uiId", request.getParameter("uiId"));
			param.put("uiPwd", request.getParameter("uiPwd"));
			param.put("uiName", request.getParameter("uiName"));
			int result = uiRepo.insertUserInfo(param);
			request.setAttribute("msg", "등록 실패");
			request.setAttribute("url", "/user-info/insert");
			if(result==1) {
				request.setAttribute("msg", "등록 성공");
				request.setAttribute("url", "/user-info/list");
			}
		} else if("update".equals(uri)) {
			Map<String, String> param = new HashMap<>();
			param.put("uiId", request.getParameter("uiId"));
			param.put("uiPwd", request.getParameter("uiPwd"));
			param.put("uiName", request.getParameter("uiName"));
			param.put("uiNum", request.getParameter("uiNum"));
			int result = uiRepo.updateUserInfo(param);
			request.setAttribute("msg", "수정 실패");
			request.setAttribute("url", "/user-info/update?uiNum=" + request.getParameter("uiNum"));
			if(result==1) {
				request.setAttribute("msg", "수정 성공");
				request.setAttribute("url", "/user-info/list");
			}
		} else if("delete".equals(uri)) {
			String uiNum = request.getParameter("uiNum");
			int result = uiRepo.deleteUserInfo(uiNum);
			request.setAttribute("msg", "삭제 실패");
			request.setAttribute("url", "/user-info/view?uiNum=" + request.getParameter("uiNum"));
			if(result==1) {
				request.setAttribute("msg", "삭제 성공");
				request.setAttribute("url", "/user-info/list");
			}
		}
		CommonView.goMassagePage(request, response);
	}

}
