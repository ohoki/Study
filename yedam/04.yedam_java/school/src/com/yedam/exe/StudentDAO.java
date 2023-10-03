package com.yedam.exe;

import java.util.ArrayList;
import java.util.List;

import com.sun.jdi.VMDisconnectedException;
import com.yedam.common.DAO;

public class StudentDAO extends DAO{
	//싱 글 톤
	private static StudentDAO stdDao = null;
	
	private StudentDAO() {
		
	}
	
	public static StudentDAO getInstance() {
		if(stdDao == null) {
			stdDao = new StudentDAO();
		}
		return stdDao;
	}
	
	//전체 조회
	public List<Student> getStudentList() {
		List<Student> list = new ArrayList<>();
		Student std =null;
		
		try {
			conn();
			String sql = "SELECT * FROM student";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				std = new Student();
				std.setStdId(rs.getInt("std_id"));
				std.setStdName(rs.getString("std_name"));
				std.setStdMajor(rs.getString("std_major"));
				std.setStdPoint(rs.getInt("std_point"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	
	//단건 조회
	public Student getStudent(int stdId) {
		Student std = null;
		
		try {
			conn();
			String sql = "SELECT * FROM student WHERE std_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stdId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				std = new Student();
				std.setStdId(rs.getInt("std_id"));
				std.setStdName(rs.getString("std_name"));
				std.setStdMajor(rs.getString("std_major"));
				std.setStdPoint(rs.getInt("std_point"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return std;
	}
	
	//등록
	public int insertStd(Student std) {
		int result = 0;
		
		try {
			conn();
			String sql = "INSERT INTO student VALUES (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, std.getStdId());
			pstmt.setString(2, std.getStdName());
			pstmt.setString(3, std.getStdMajor());
			pstmt.setInt(4, std.getStdPoint());
			
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	//삭제
	public int deleteStd(int stdId) {
		int result = 0;
		
		try {
			conn();
			String sql = "DELETE FROM student WHERE std_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stdId);
			
			result = pstmt.executeUpdate(); // 정상작동 -> 1 오작동 -> 0
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
		return result;
	}
	//변경
	public int modifyMajor(Student std) {
		int result = 0;
		
		try {
			conn();
			String sql = "UPDATE student SET std_major = ? WHERE std_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, std.getStdMajor());
			pstmt.setInt(2, std.getStdId());
			
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	
	
	
}
