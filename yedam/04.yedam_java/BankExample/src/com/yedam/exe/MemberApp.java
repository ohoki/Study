package com.yedam.exe;

import java.util.Scanner;

import com.yedam.account.AccountService;
import com.yedam.member.MemberService;

public class MemberApp {
	Scanner sc = new Scanner(System.in);
	MemberService ms = new MemberService();
	AccountService as = new AccountService();
	
	public MemberApp() {
		memberRun();
	}

	private void memberRun() {
		boolean flag = true;
		while(flag) {
			menu();
			String selectNo = sc.nextLine();
			
			switch(selectNo) {
			case "1" :
				ms.getAccountInfo();
				break;
			case "2" :
				as.inoutMoney();
				break;
			case "3" :
				as.transfetMoney();
				break;
			case "4" :
				flag = false;
				MemberService.memberInfo = null;
				break;
			}
		}
	}

	private void menu() {
		System.out.println("1. 계좌 조회 | 2. 입출금 | 3. 이체 | 4. 뒤로가기");
		
	}
	
	
}
