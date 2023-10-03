package yhBank.account;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import yhBank.member.Member;
import yhBank.member.MemberDAO;
import yhBank.member.MemberService;

public class AccountService {
	Scanner sc = new Scanner(System.in);
	
	//계좌번호는 "-"포함 13자리의 랜덤 수 
	public String makeAccountNumber() {
		String accountNumber = "";
		
		for(int i=1; i<=13; i++) {
			if(i%5==0) {
				accountNumber += "-";
			} else {
				accountNumber += (int)(Math.random()*10);
			}
		}
		return accountNumber;
	}
	
	//계좌 개설
	public void insertAccount() {
		Account account = new Account();
		
		System.out.println("계좌개설을 시작합니다.");
		
		while(true) {
			if(MemberService.memberInfo.getMemberAuth().equals("A")) {
				System.out.println("계좌를 개설할 ID를 입력해주세요.");
				String id = sc.nextLine();
				
				Member confirmMember = MemberDAO.getInstance().selectMember(id);
				if(confirmMember != null) {
					account.setMemberId(id);
					break;
				} else {
					System.out.println("없는 ID입니다.");
				}
			} else{
				account.setMemberId(MemberService.memberInfo.getMemberId());
				break;
			}
		}
		String accountNumber = makeAccountNumber(); 
		account.setAccountNumber(accountNumber);
		
		while(true) {
			try {
				System.out.println("초기금액을 입금하세요>");
				account.setAccountBalance(Integer.parseInt(sc.nextLine()));
				break;
			}catch(NullPointerException e){
				System.out.println("숫자만 입력해주세요.");
			}
		}
		int result = AccountDAO.getInstance().insertAccount(account);
		
		if(result > 0) {
			System.out.println(account.getMemberId() + "님의 새로운 계좌(" + account.getAccountNumber()+")가 개설되었습니다.");
		} else {
			System.out.println("게좌 개설에 실패하였습니다.");
		}
	}
	
	//계좌 해지
	public void deleteAccount() {
		Account account = new Account();
		
		while(true) {
			if(MemberService.memberInfo.getMemberAuth() == "A") {
				System.out.println("해지할 계좌의 ID를 입력해주세요.");
				String id = sc.nextLine();
				
				Member confirmMember = MemberDAO.getInstance().selectMember(id);
				if(confirmMember != null) {
					account.setMemberId(id);
					break;
				} else {
					System.out.println("없는 ID입니다.");
				}
			} else{
				account.setMemberId(MemberService.memberInfo.getMemberId());
				break;
			}
		}
		System.out.println("해지할 계좌를 입력해주세요.('-'포함)");
		String accountNumber = sc.nextLine();
		account.setAccountNumber(accountNumber);
		
		int result = AccountDAO.getInstance().deleteAccount(account);
		
		if(result > 0) {
			System.out.println(account.getMemberId() + "님의 계좌(" + account.getAccountNumber()+")가 해지되었습니다.");
		} else {
			System.out.println("게좌 해지에 실패하였습니다.");
		}
	}
	
	//계좌 조회
	public void checkAccount() {
		if(MemberService.memberInfo.getMemberAuth().equals("A")) {
			List<Member> list = null;
			System.out.println("회원 전체 정보를 조회합니다.\n");
			list = MemberDAO.getInstance().checkAllAccount();
			
			for(int i = 0; i<list.size(); i++) {
				String auth = "";
				if(list.get(i).getMemberAuth().equals("N")) {
					auth = "일반 회원";
				}else if(list.get(i).getMemberAuth().equals("V")) {
					auth = "특별 회원";
				}else if(list.get(i).getMemberAuth().equals("A")) {
					auth = "관리자";
				}
				String accountNumber = "";
				String accountCDate = "";
				String accountBalance = "";
				if(list.get(i).getAccountNumber() == null) {
					accountNumber = "--";
					accountCDate = "--";
					accountBalance = "--";
				} else {
					accountNumber = list.get(i).getAccountNumber();
					accountCDate = String.valueOf(list.get(i).getAccountCDate());
					accountBalance = list.get(i).getAccountBalance()+"원";
				}
				System.out.println("회원 등급 : " + auth + "ID : " + list.get(i).getMemberId() + " 성함 : " + list.get(i).getMemberName() + " 전화번호 : " + list.get(i).getMemberPhone() + " 주소 : " + list.get(i).getMemberAddr() + " 계좌번호 : " + accountNumber + " 계좌 생성일 : " + accountCDate + " 잔고 : " + accountBalance);
			}
		} else{
			List<Account> list = null;
			System.out.println(MemberService.memberInfo.getMemberId() + "님의 전체 계좌를 조회합니다.\n");
			list = AccountDAO.getInstance().checkMemberAccount(MemberService.memberInfo.getMemberId());
			for(int i=0; i<list.size(); i++) {
				System.out.println("ID : " + list.get(i).getMemberId() + " 계좌번호 : " + list.get(i).getAccountNumber() + " 계좌 생성일 : " + list.get(i).getAccountCDate() + " 잔고 : " + list.get(i).getAccountBalance() + "원");
			}
		}
	}
	
	//계좌 이체
	public void transferMoney() {
		String accountNumber = null;
		String fromAccountNumber = null;
		String toAccountNumber = null;
		int balance = 0;
		
		System.out.println("계좌 이체를 실행합니다.");
		checkAccount();
		
		while(true) {
			System.out.println("사용할 계좌번호를 입력해주세요.('-'포함)");
			accountNumber = sc.nextLine().trim();
			if(accountNumber.length() ==  13) {
				fromAccountNumber = accountNumber;
				break;
			} else {
				System.out.println("잘못된 계좌번호입니다. 다시 입력해주세요.");
			}
		}
		while(true) {
			System.out.println("보낼 계좌번호를 입력해주세요.('-'포함)");
			accountNumber = sc.nextLine().trim();
			if(accountNumber.length() ==  13) {
				toAccountNumber = accountNumber;
				break;
			} else {
				System.out.println("잘못된 계좌번호입니다. 다시 입력해주세요.");
			}
		}
		System.out.println("이체할 금액을 입력해주세요>");
		balance = Integer.parseInt(sc.nextLine());
		
		int result = AccountDAO.getInstance().transferMoney(fromAccountNumber, toAccountNumber, balance);
		
		if(result > 0) {
			System.out.println("정상 이체 되었습니다.");
		} else {
			System.out.println("이체에 실패했습니다.");
		}
	}
	
	//입출금
	public void inOutMoney() {
		int balance = 0;
		String accountNumber = null;
		int result = 0;
		int selectNum = 0;
		
		checkAccount();
		System.out.println();
		while(true) {
			System.out.println("사용할 계좌번호를 입력해주세요.('-'포함)");
			accountNumber = sc.nextLine().trim();
			if(accountNumber.length() ==  13) {
				break;
			} else {
				accountNumber = null;
				System.out.println("잘못된 계좌번호입니다. 다시 입력해주세요.");
			}
		}
		while(true) {
			System.out.println("입금 과 출금 중 하나를 선택해 주세요.");
			try {
				System.out.println("1. 입금하기   | 2. 출금하기   ");
				selectNum = Integer.parseInt(sc.nextLine());
				if(selectNum == 1) {
					System.out.println("입금할 금액을 입력해주세요>");
					balance = Integer.parseInt(sc.nextLine());
					result = AccountDAO.getInstance().inoutMoney(accountNumber, balance, 1);
					break;
				}else if(selectNum == 2) {
					System.out.println("출금할 금액을 입력해주세요>");
					balance = Integer.parseInt(sc.nextLine());
					result = AccountDAO.getInstance().inoutMoney(accountNumber, balance, 2);
					break;
				}else {
					System.out.println("메뉴를 다시 선택해주세요.");
				}
			} catch(Exception e) {
				System.out.println("메뉴를 다시 선택해 주세요.");
			}
		}
		if(result > 0) {
			if(selectNum == 1) {
				System.out.println("입금이 완료되었습니다.");
			}else if(selectNum == 2) {
				System.out.println("출금이 완료되었습니다.");
			}
		} else {
			if(selectNum == 1) {
				System.out.println("입금이 실패했습니다.");
			}else if(selectNum == 2) {
				System.out.println("출금이 실패했습니다.");
			}
		}
	}
}
