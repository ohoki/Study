package com.yedam.employees;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeesService {
	//실행 <-> 데이터를 가공 <-> DB(DAO)
	//가운데서 중재하는 역할
	Scanner sc = new Scanner(System.in);
	//전체 조회
	public void getEmployeesList() {
		List<Employees> list = EmployeesDAO.getInstance().getEmployeesList();
	
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}
	
	//단건 조회
	public void getEmployee() {
		System.out.println("사번 입력>");
		int empId = Integer.parseInt(sc.nextLine());
		Employees emp = EmployeesDAO.getInstance().getEmployee(empId);
		
		if(emp != null) { //데이터가 조회가 되었을 경우
			System.out.println("employeeID : " + emp.getEmployeeId());
			System.out.println("lastName : " + emp.getLastName());
			System.out.println("email : " + emp.getEmail());
			System.out.println("hireDate : " + emp.getHireDate());
			System.out.println("jobID : " + emp.getJobId());
		}else { //데이터가 조회 되지 않은 경우
			System.out.println("존재하지 않는 사번입니다.");
		}
	}
	
	//등록
	public void insertEmp() {
		Employees emp = new Employees();
		
		System.out.println("====사 원 등 록====");
		
		System.out.println("사번>");
		emp.setEmployeeId(Integer.parseInt(sc.nextLine()));
		
		System.out.println("이름>");
		emp.setLastName(sc.nextLine());
		
		System.out.println("이메일");
		emp.setEmail(sc.nextLine());
		
		System.out.println("입사일>");
		emp.setHireDate(Date.valueOf(sc.nextLine()));
		
		System.out.println("직책>");
		emp.setJobId(sc.nextLine());
		
		int result = EmployeesDAO.getInstance().insertEmp(emp);
		
		if(result > 0) {
			System.out.println("사원 입력 완료");
		} else {
			System.out.println("사원 입력 실패");
		}
	}
}
