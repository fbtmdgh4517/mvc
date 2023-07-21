package com.mvc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieInfoRepository {
	private static String DRIVER = "org.mariadb.jdbc.Driver";
	private static String URL = "jdbc:mariadb://localhost:3306/kd";
	private static String USER = "root";
	private static String PWD = "kd1824java";
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List<Map<String, String>> selectMovieInfoList() {
		List<Map<String, String>> movieInfoList = new ArrayList<>();
		try(Connection con = DriverManager.getConnection(URL, USER, PWD)) {
			String sql = "SELECT * FROM MOVIE_INFO WHERE 1=1";
			try(PreparedStatement pstmt = con.prepareStatement(sql)) {
				try(ResultSet rs = pstmt.executeQuery()) {
					while(rs.next()) {
						Map<String, String> movieInfo = new HashMap<>();
						movieInfo.put("miNum", rs.getString("MI_NUM"));
						movieInfo.put("miTitle", rs.getString("MI_TITLE"));
						movieInfo.put("miDesc", rs.getString("MI_DESC"));
						movieInfo.put("miGenre", rs.getString("MI_GENRE"));
						movieInfo.put("miCreDate", rs.getString("MI_CREDATE"));
						movieInfo.put("miCnt", rs.getString("MI_CNT"));
						movieInfoList.add(movieInfo);
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return movieInfoList;
	}
	
	public Map<String, String> selectMovieInfo(String miNum) {
		try(Connection con = DriverManager.getConnection(URL, USER, PWD)) {
			String sql = "SELECT * FROM MOVIE_INFO WHERE 1=1";
			try(PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, miNum);
				try(ResultSet rs = pstmt.executeQuery()) {
					if(rs.next()) {
						Map<String, String> movieInfo = new HashMap<>();
						movieInfo.put("miNum", rs.getString("MI_NUM"));
						movieInfo.put("miTitle", rs.getString("MI_TITLE"));
						movieInfo.put("miDesc", rs.getString("MI_DESC"));
						movieInfo.put("miGenre", rs.getString("MI_GENRE"));
						movieInfo.put("miCreDate", rs.getString("MI_CREDATE"));
						movieInfo.put("miCnt", rs.getString("MI_CNT"));
						return movieInfo;
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
