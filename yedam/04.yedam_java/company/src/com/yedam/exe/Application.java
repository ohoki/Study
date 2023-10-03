package com.yedam.exe;

import java.util.Scanner;

import com.yedam.department.Departments;
import com.yedam.department.DepartmentsService;
import com.yedam.employees.EmployeesService;

public class Application {
	
	//run 메소드 안에서 메뉴 선택 용도
	int selectNo = 0;
	Scanner sc = new Scanner(System.in);
	
	public Application() {
		run();
	}
	
	private void run() {
		
		while(selectNo != 3) {
			menu();
			
			switch (selectNo) {
			case 1:
				employees();
				break;
			case 2:
				departments();
				break;
			case 3:
				System.out.println("end of program");
				break;	
			}
		}
	}
	
	private void departments() {
		//departments 정보
		int departmentMenu = 0;
		DepartmentsService dp = new DepartmentsService();
		while(departmentMenu != 4) {
			System.out.println("====================================================");
			System.out.println("1. 모든 부서 조회  |  2. 부서 조회  |  3. 등록  |  4. 종료");
			System.out.println("====================================================");
			
			departmentMenu = Integer.parseInt(sc.nextLine());
			
			if(departmentMenu == 1) {
				dp.getDeptList();
			}else if(departmentMenu == 2) {
				dp.getDepartment();
			}else if(departmentMenu == 3) {
				dp.insertDept();
			}else if(departmentMenu == 4) {
				System.out.println("부서 업무 종료");
			}
		}
		
	}
	
	
	private void employees() {
		//employees CRUD 진행
		int employeesMenu = 0;
		//CRUD 관련 내용
		EmployeesService es = new EmployeesService();
		while(employeesMenu != 4) {
			System.out.println("====================================================");
			System.out.println("1. 모든 사원 조회  |  2. 사원 조회  |  3. 등록  |  4. 종료");
			System.out.println("====================================================");
			
			employeesMenu = Integer.parseInt(sc.nextLine());
			
			switch(employeesMenu) {
			case 1:
				es.getEmployeesList();
				break;
			case 2:
				es.getEmployee();
				break;
			case 3:
				es.insertEmp();
				break;	
			case 4:
				System.out.println("사원 업무 종료");
				break;	
			}
		}
		
	}

	private void menu() {
		System.out.println("☆★☆★☆★ 회사 정보 프래그램 ☆★☆★☆★");
		System.out.println(" 1. 부서  |  2. oo  |  3. 종료");
		System.out.println("☆★☆★☆★ 회사 정보 프래그램 ☆★☆★☆★");
		System.out.println("입력>");
		selectNo = Integer.parseInt(sc.nextLine());
	}
}
