package homework;

import java.util.*;

public class ChoiYoungHo_homework_230511 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Product[] products = null;
		
		while(true) {
			System.out.println("============================================================");
			System.out.println("1.상품 수 입력 | 2.상품 및 가격 입력 | 3.제품별 가격 | 4.분석 | 5.종료");
			System.out.println("============================================================");
			
			System.out.println("항목의 번호를 입력해주세요>");
			int selectNo = Integer.parseInt(scanner.nextLine());
			
			if(selectNo == 1) {
				
				System.out.println("상품의 수를 입력해주세요>");
				int pdNum = Integer.parseInt(scanner.nextLine());
				products = new Product[pdNum];
				
			} else if(selectNo == 2) {
				
				for(int i=0; i<products.length; i++) {
					products[i] = new Product();
					
					System.out.println("상품명을 입력해주세요>");
					products[i].pdName = scanner.nextLine();
					
					System.out.println("상품의 가격을 입력해주세요>");
					products[i].price = Integer.parseInt(scanner.nextLine());
				}
				
			} else if(selectNo == 3) {
				
				for(int i=0; i<products.length; i++) {
					System.out.println((i+1) + "번째 상품의 정보");
					products[i].getInfo();
					System.out.println();
				}
				
			} else if(selectNo == 4) {
				
				int total = 0;
				int max = products[0].price;
				int maxIdx = 0;
				
				for(int i=0; i<products.length; i++) {
					
					total += products[i].price;
					
					if(max < products[i].price) {
						max = products[i].price;
						maxIdx = i;
					}
				}
				
				System.out.println("최고 가격을 가지는 제품 : " + products[maxIdx].pdName);
				System.out.println("최고 가격의 제품을 제외한 제품들의 총합 : " + (total - max));
				
			} else if(selectNo == 5) {
				
				System.out.println("프로그램을 종료합니다.");
				break;
				
			} else {
				System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해 주세요.");
			}
			
		}
	}
}
