package com.yedam.exe;

import java.util.List;
import java.util.Scanner;

public class StudentService {
	Scanner sc = new Scanner(System.in);
	
	//전체 학생 조회
	public void getStudentList() {
		List<Student> list = StudentDAO.getInstance().getStudentList();
		
		if(list.size() == 0) {
			System.out.println("| 입력된 정보가 없습니다.");
		} else {
			for(int i=0; i<list.size(); i++) {
				System.out.println("======================================================");
				System.out.println("|" + "학번 : " + list.get(i).getStdId());
				System.out.println("|" + "이름 : " + list.get(i).getStdName());
				System.out.println("|" + "전공 : " + list.get(i).getStdName());
				System.out.println("|" + "점수 : " + list.get(i).getStdPoint());
			}
		}
	}
	
	//단건 조회
	public void getStudent() {
		System.out.println("==========================================================");
		System.out.println("| 학번 입력>");
		int stdId = Integer.parseInt(sc.nextLine());
		
		Student std = StudentDAO.getInstance().getStudent(stdId);
		
		if(std != null ) {
			System.out.println("==========================================================");
			System.out.println("|" + "학번 : " + std.getStdId());
			System.out.println("|" + "이름 : " + std.getStdName());
			System.out.println("|" + "전공 : " + std.getStdMajor());
			System.out.println("|" + "점수 : " + std.getStdPoint());
		} else {
			System.out.println("| 조회되는 정보가 없습니다.");
		}
	}
	
	//학생 등록
	public void insertStd() {
		Student std = new Student();
		System.out.println("==========================================================");
		System.out.println("| 학번 >");
		std.setStdId(Integer.parseInt(sc.nextLine()));
		System.out.println("| 이름 >");
		std.setStdName(sc.nextLine());
		System.out.println("| 전공 >");
		std.setStdMajor(sc.nextLine());
		System.out.println("| 점수 >");
		std.setStdPoint(Integer.parseInt(sc.nextLine()));
		
		int result = StudentDAO.getInstance().insertStd(std);
		
		if(result > 0) {
			System.out.println(" 학생 정보 입력 완료 ");
		} else {
			System.out.println(" 학생 정보 입력 실패 ");
		}
	}	
	
	//학생 삭제
	public void deleteStd() {
		System.out.println("==========================================================");
		System.out.println("| 학번 >");
		int stdId = Integer.parseInt(sc.nextLine());
		int result = StudentDAO.getInstance().deleteStd(stdId);
		
		if(result > 0) {
			System.out.println(" 학생 정보 삭제 완료 ");
		} else {
			System.out.println(" 학생 정보 삭제 실패 ");
		}
		
	}
	//학생 변경
	public void updateStd() {
		Student std = new Student();
		System.out.println("==========================================================");
		System.out.println("| 학번 >");
		std.setStdId(Integer.parseInt(sc.nextLine()));
		System.out.println("| 전공 >");
		std.setStdName(sc.nextLine());
		
		int result = StudentDAO.getInstance().modifyMajor(std);
		
		if(result > 0) {
			System.out.println(" 학생 전공 수정 완료 ");
		} else {
			System.out.println(" 학생 전공 수정 실패 ");
		}
	}
	
}
