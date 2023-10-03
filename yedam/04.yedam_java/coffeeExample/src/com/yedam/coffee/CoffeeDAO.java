package com.yedam.coffee;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class CoffeeDAO extends DAO {
	//싱글톤 (접속 수 제한)
	private static CoffeeDAO coffeeDao = null;
	
	private CoffeeDAO() {
		
	}
	
	public static CoffeeDAO getInstance() {
		if(coffeeDao == null) {
			coffeeDao = new CoffeeDAO();
		}
		return coffeeDao;
	}
		
	//메뉴 조회
	public List<Coffee> getCoffes() {
		List<Coffee> list = new ArrayList<>();
		Coffee cf = null;
		
		try {
			conn();
			String sql = "SELECT * FROM coffee";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {   //조회된 결과에 대한 컬럼 내용
				cf = new Coffee();
				cf.setCoffeeMenu(rs.getString("coffee_menu"));
				cf.setCoffeePrice(rs.getInt("coffee_price"));
				cf.setCoffeeExplain(rs.getString("coffee_explain"));
				cf.setCoffeeSales(rs.getInt("coffee_sales"));
				
				list.add(cf);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			    disconn();
		}
		return list;
	}
		
	//메뉴 상세 조회
	public Coffee getCoffee(String coffee) {
		Coffee cf = null;
		
		try {
			conn();
			String sql = "SELECT * FROM coffee WHERE coffee_menu = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, coffee);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cf = new Coffee();
				cf.setCoffeeMenu(rs.getString("coffee_menu"));
				cf.setCoffeePrice(rs.getInt("coffee_price"));
				cf.setCoffeeExplain(rs.getString("coffee_explain"));
				cf.setCoffeeSales(rs.getInt("coffee_sales"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return cf;
	}
	
	//메뉴 등록
	public int insertCoffee(Coffee cf) {
		int result = 0;
		
		try {
			conn();
			
			String sql = "INSERT INTO coffee VALUES(?,?,?,0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cf.getCoffeeMenu());
			pstmt.setInt(2, cf.getCoffeePrice());
			pstmt.setString(3, cf.getCoffeeExplain());
			
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	//판매
	public int sellCoffee(String coffee) {
		int result = 0;
		
		try {
			conn();
			
			String sql = "UPDATE coffee SET coffee_sales = coffee_sales + 1 WHERE coffee_menu = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, coffee);
			
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	//삭제
	public int deleteCoffee(String coffee) {
		int result = 0;
		
		try {
			conn();
			
			String sql = "DELETE FROM coffee WHERE coffee_menu = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, coffee);
			
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	//매출
	public List<Coffee> totalSales() {
		List<Coffee> list = new ArrayList<>();
		Coffee cf = null;
		
		try {
			conn();
			
			String sql = "SELECT coffee_menu, coffee_sales, coffee_price FROM coffee";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cf= new Coffee();
				cf.setCoffeeMenu(rs.getString("coffee_menu"));
				cf.setCoffeeSales(rs.getInt("coffee_sales"));
				cf.setCoffeePrice(rs.getInt("coffee_price"));
				list.add(cf);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
}
