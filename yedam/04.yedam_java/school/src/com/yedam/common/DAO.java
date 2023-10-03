package com.yedam.common;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	//DAO - Data(DB) Access Object
	//JDBC를 통해서 JAVA<->DB가 연결이 된다.
	
	//java -> DB 연결할 때 쓰는 객체
	protected Connection conn = null;
	
	//Query문(SQL, 질의)을 가지고 실행하는 객체
	protected PreparedStatement pstmt = null;
	
	//Query문(SQL, 질의)을 가지고 실행하는 객체
	protected Statement stmt = null;
	
	//SELECT(조회) 결과 값을 반환하는 객체
	protected ResultSet rs = null;
	
	//DB 접속 정보
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "HR";
	String pw = "1234";
	
	//DB 연결 메소드 // 변수와 메소드의 이름이 같아도 상관없음 (저장 장소가 다름)
	public void conn() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//DB 연결 해제 (연결의 역순으로 조회 -> 실행 -> 검색) //else if 문 쓰면 제대로 실행 안될 수도 있음
	public void disconn() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
