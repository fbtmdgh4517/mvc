package com.mvc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
	// 메인 메소드가 실행하기 전에 기억하려면 스태틱을 써야됨, 스태틱이 편한데 쓸때도 있고 안 쓸때도 있는 이유는 메모리가 감당이 안되서
	// 스태틱은 고유적인거에서 주로 사용하는 것 같음
	private static String DRIVER_NAME = "org.mariadb.jdbc.Driver";
	private static String URL = "jdbc:mariadb://localhost:3306/kd";
	private static String USER = "root";
	private static String PWD = "kd1824java";
	
	static {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getCon() {
		try {
			return DriverManager.getConnection(URL, USER, PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		Connection con = DBCon.getCon();
		System.out.println(con);
	}
}
