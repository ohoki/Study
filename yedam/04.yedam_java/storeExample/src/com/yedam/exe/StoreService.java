package com.yedam.exe;

import java.util.List;
import java.util.Scanner;

public class StoreService {
	Scanner sc = new Scanner(System.in);
	
	//모든 가게 정보 조회
	public void getStores() {
		List<Store> list = StoreDAO.getInstance().getStores();
		
		for(int i=0; i<list.size(); i++) {
			System.out.println("====== "+ (i+1) + "번 가게 ======");
			System.out.println("가게 ID : "  + list.get(i).getStoreId());
			System.out.println("가게 이름 : " + list.get(i).getStoreName());
			System.out.println("가게 번호 : " + list.get(i).getStoreTel());
			System.out.println("가게 주소 : " + list.get(i).getStoreAddr());
			System.out.println("가게 매출 : " + list.get(i).getStorSales());
		}
	}
	
	//지역구 별 매출 합계
	public void getStoreSales() {
		List<Store> list = StoreDAO.getInstance().getStoreSales();
		
		for(int i=0; i<list.size(); i++) {
			System.out.print("가게 지역 : "  + list.get(i).getStoreAddr());
			System.out.println("\t매출 : " + list.get(i).getSalesSum());
		}
	}
	
	
	//가게 정보 입력
	public void insertStore() {
		Store store = new Store();
		
		System.out.println("===== 가게 정보 입력 =====");
		
		System.out.println("가게 이름>");
		store.setStoreName(sc.nextLine());
		System.out.println("가게 번호>");
		store.setStoreTel(sc.nextLine());
		System.out.println("가게 주소>");
		store.setStoreAddr(sc.nextLine());
		System.out.println("가게 매출>");
		store.setStorSales(Integer.parseInt(sc.nextLine()));
		
		int result = StoreDAO.getInstance().insertStore(store);
		
		if(result > 0) {
			System.out.println("가게 정보가 입력되었습니다.");
		} else {
			System.out.println("가게 정보가 입력되지 않았습니다.");
		}
	}
	
	//매출 수정
	public void updateSales() {
		Store store = new Store();
		
		System.out.println("수정할 가게 ID>");
		store.setStoreId(Integer.parseInt(sc.nextLine()));
		System.out.println("매출>");
		store.setStorSales(Integer.parseInt(sc.nextLine()));
		
		int result = StoreDAO.getInstance().updateSales(store);
		
		if(result > 0) {
			System.out.println("매출이 수정되었습니다.");
		} else {
			System.out.println("매출 수정에 실패하셨습니다.");
		}
	}
}