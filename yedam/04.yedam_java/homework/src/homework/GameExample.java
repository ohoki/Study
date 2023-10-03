package homework;

public class GameExample {

	public static void main(String[] args) {
		Keypad rpg = new RPGgame();
		
		rpg.leftUpButton();
		rpg.rightUpButton();
		rpg.changeMode();
		rpg.rightUpButton();
		rpg.rightDownButton();
		rpg.leftDownButton();
		rpg.changeMode();
		rpg.rightDownButton();

		System.out.println("=============================================");
		
		Keypad arcade = new ArcadeGame();
		
		arcade.leftUpButton();
		arcade.rightUpButton();
		arcade.leftDownButton();
		arcade.changeMode();
		arcade.rightUpButton();
		arcade.leftUpButton();
		arcade.rightDownButton();
	}

}
