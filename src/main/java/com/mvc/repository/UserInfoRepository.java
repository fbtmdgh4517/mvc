package com.mvc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInfoRepository {
	private String DRIVER = "org.mariadb.jdbc.Driver";
	private String URL = "jdbc:mariadb://localhost:3306/kd";
	private String USER = "root";
	private String PWD = "kd1824java";
	
	public UserInfoRepository() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List<Map<String, String>> selectUserInfoList() {
		List<Map<String, String>> userInfoList = new ArrayList<>();
		try(Connection con = DriverManager.getConnection(URL, USER, PWD)){
			String sql = "SELECT * FROM USER_INFO WHERE 1=1";
			try(PreparedStatement pstmt = con.prepareStatement(sql)) {
				try(ResultSet rs = pstmt.executeQuery()) {
					while(rs.next()) {
						Map<String, String> userInfo = new HashMap<>();
						userInfo.put("uiNum", rs.getString("UI_NUM"));
						userInfo.put("uiId", rs.getString("UI_ID"));
						userInfo.put("uiPwd", rs.getString("UI_PWD"));
						userInfo.put("uiName", rs.getString("UI_NAME"));
						userInfoList.add(userInfo);
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return userInfoList;
	}
	
	public Map<String, String> selectUserInfo(String uiNum) {
		try(Connection con = DriverManager.getConnection(URL, USER, PWD)) {
			String sql = "SELECT * FROM USER_INFO WHERE 1=1 AND UI_NUM = ?";
			try(PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, uiNum);
				try(ResultSet rs = pstmt.executeQuery()) {
					if(rs.next()) {
						Map<String, String> userInfo = new HashMap<>();
						userInfo.put("uiNum", rs.getString("UI_NUM"));
						userInfo.put("uiId", rs.getString("UI_ID"));
						userInfo.put("uiPwd", rs.getString("UI_PWD"));
						userInfo.put("uiName", rs.getString("UI_NAME"));
						return userInfo;
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
