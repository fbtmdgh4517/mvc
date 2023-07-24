package com.mvc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mvc.common.DBCon;

public class MovieInfoRepository {
	
	public List<Map<String, String>> selectMovieInfoList() {
		List<Map<String, String>> movieInfoList = new ArrayList<>();
		try(Connection con = DBCon.getCon()) {
			String sql = "SELECT * FROM MOVIE_INFO WHERE 1=1";
			try(PreparedStatement pstmt = con.prepareStatement(sql)) {
				try(ResultSet rs = pstmt.executeQuery()) {
					while(rs.next()) {
						Map<String, String> movieInfo = new HashMap<>();
						movieInfo.put("miNum", rs.getString("MI_NUM"));
						movieInfo.put("miTitle", rs.getString("MI_TITLE"));
						movieInfo.put("miDesc", rs.getString("MI_DESC"));
						movieInfo.put("miGenre", rs.getString("MI_GENRE"));
						movieInfo.put("miCredate", rs.getString("MI_CREDATE"));
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
		try(Connection con = DBCon.getCon()) {
			String sql = "SELECT * FROM MOVIE_INFO WHERE 1=1 AND MI_NUM = ?";
			try(PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, miNum);
				try(ResultSet rs = pstmt.executeQuery()) {
					if(rs.next()) {
						Map<String, String> movieInfo = new HashMap<>();
						movieInfo.put("miNum", rs.getString("MI_NUM"));
						movieInfo.put("miTitle", rs.getString("MI_TITLE"));
						movieInfo.put("miDesc", rs.getString("MI_DESC"));
						movieInfo.put("miGenre", rs.getString("MI_GENRE"));
						movieInfo.put("miCredate", rs.getString("MI_CREDATE"));
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
	
	public int insertMovieInfo(Map<String, String> param) {
		Connection con = DBCon.getCon();
		String sql = "INSERT INTO MOVIE_INFO(MI_TITLE, MI_DESC, MI_GENRE, MI_CREDATE, MI_CNT) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, param.get("miTitle"));
			pstmt.setString(2, param.get("miDesc"));
			pstmt.setString(3, param.get("miGenre"));
			pstmt.setString(4, param.get("miCredate"));
			pstmt.setString(5, param.get("miCnt"));
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateMovieInfo(Map<String, String> param) {
		Connection con = DBCon.getCon();
		String sql = "UPDATE MOVIE_INFO SET MI_TITLE = ?, MI_DESC = ?, MI_GENRE = ?, MI_CREDATE = ?, MI_CNT = ? WHERE MI_NUM = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, param.get("miTitle"));
			pstmt.setString(2, param.get("miDesc"));
			pstmt.setString(3, param.get("miGenre"));
			pstmt.setString(4, param.get("miCredate"));
			pstmt.setString(5, param.get("miCnt"));
			pstmt.setString(6, param.get("miNum"));
			int result = pstmt.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteMovieInfo(String miNum) {
		Connection con = DBCon.getCon();
		String sql = "DELETE FROM MOVIE_INFO WHERE MI_NUM = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, miNum);
			int result = pstmt.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
