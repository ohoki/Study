package com.yedam.variable;

public class Casting {
	
	public static void main(String[] args) {
		//자동 형 변환========================================================================
		byte bValue = 10;
		int iValue = bValue;
		
		System.out.println("iValue : " + iValue);
		
		char charValue = '가';
		iValue = charValue;
		
		System.out.println("'가'의 유니코드 : " + iValue);
		
		iValue = 50;
		long lValue = iValue;
		System.out.println("lValue : " + lValue);
		
		double dValue = lValue;
		System.out.println("dValue : " + dValue);
		
	
		//명시적 형 변환=============================================================================
		int iVar = 127;
		byte bVar = (byte)iVar;
		
		int iVar2 = 44032;
		char charVar = (char)iVar2;
		System.out.println("charVar : " + charVar);
		
		double dVar = 3.14;
		iVar2 = (int)dVar;
		
		System.out.println("iVar2 : " + iVar2);  //3	
		
	}
}
