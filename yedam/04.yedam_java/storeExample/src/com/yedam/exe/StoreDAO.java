package com.yedam.exe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yedam.common.DAO;

public class StoreDAO extends DAO{
	Scanner sc = new Scanner(System.in);
    //싱 글 톤
	private static StoreDAO storeInfo = null;
	
	private StoreDAO() {
		
	}
	
	public static StoreDAO getInstance() {
		if(storeInfo == null) {
			storeInfo = new StoreDAO();
		}
		return storeInfo;
	}
	
//모든 가게 정보 조회
	public List<Store> getStores() {
		List<Store> list = new ArrayList<>();
		
		try {
			conn();
			String sql = "SELECT * FROM store ORDER BY store_id";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Store st = new Store();
				st.setStoreId(rs.getInt("store_id"));
				st.setStoreName(rs.getString("store_name"));
				st.setStoreTel(rs.getString("store_tel"));
				st.setStoreAddr(rs.getString("store_addr"));
				st.setStorSales(rs.getInt("store_sales"));
				
				list.add(st);	
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	
//지역구별 매출 합계
	public List<Store> getStoreSales() {
		List<Store> list = new ArrayList<>();
			Store st = null;
		
		try {
			conn();
			String sql = "SELECT SUBSTR(store_addr, 1, 2) store_addr, SUM(store_sales) total FROM store GROUP BY SUBSTR(store_addr, 1, 2)";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				st = new Store();
				st.setStoreAddr(rs.getString("store_addr"));
				st.setSalesSum(rs.getInt("total"));
				
				list.add(st);	
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	
//가게 정보 입력
	public int insertStore(Store store) {
		int result = 0;
		
		try {
			conn();
			String sql = "INSERT INTO store VALUES( (SELECT COUNT(*)+1 FROM store) , ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, store.getStoreName());
			pstmt.setString(2, store.getStoreTel());
			pstmt.setString(3, store.getStoreAddr());
			pstmt.setInt(4, store.getStorSales());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
//매출 수정
	public int updateSales(Store store) {
		int result = 0;
		
		try {
			conn();
			String sql = "UPDATE store SET store_sales = ? WHERE store_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, store.getStorSales());
			pstmt.setInt(2, store.getStoreId());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
}
