package homework;

import java.util.Scanner;

public class RandomGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = (int)(Math.random()*2)+1;
		
		Keypad game = null;
		
		if(num == 1) {
			game = new RPGgame();
		} else if(num == 2) {
			game = new ArcadeGame();
		}
		
		System.out.println("============================================================================================");
		System.out.println("<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
		System.out.println("============================================================================================");
		
		int selectNum = 0;
		
		while(selectNum != 9) {
			System.out.println("choice>>");
			selectNum = Integer.parseInt(sc.nextLine());
			
			switch (selectNum) {
			case 1: {
				game.leftUpButton();
				break;
			}
			case 2: {
				game.leftDownButton();
				break;
			}
			case 3: {
				game.rightUpButton();
				break;
			}
			case 4: {
				game.rightDownButton();
				break;
			}
			case 5: {
				game.changeMode();
				break;
			}
			case 0: {
				if(game instanceof RPGgame) {
					game = new ArcadeGame();
				} else if(game instanceof ArcadeGame) {
					game = new RPGgame();
				}
			}
			case 9: {
				System.out.println("EXIT");
				break;
			}
			
			}
			
			
		}
		
	}

}
