import javax.swing.JOptionPane;

import org.opentutorials.iot.DimmingLights;
import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.Lighting;
import org.opentutorials.iot.Security;

public class OkJavaGoInHomeInput {

	// parameter(매개변수)
	//main(String[] args); 에서 args는 문자열의 배열인 매개변수이고
	//args의 입력값은 'run configuration'에서 arguments탭에서 값을 입력한다.
	//이방법이 보편적인 입력값을 넣는방법이다.(매번 입력값을 팝업으로 입력하는수고를 덜수있다)
	public static void main(String[] args) {
		
		String id = args[0];          //JOptionPane.showInputDialog("Enter a ID");
		String bright = args[1];      //JOptionPane.showInputDialog("Enter a Bright Level");
		
		//Elevator call
		Elevator myElevator = new Elevator(id);
		myElevator.callForUp(1);
		
		//Security off
		Security mySecurity = new Security(id);
		mySecurity.off();
		
		//Light on
		Lighting hallLamp = new Lighting(id+" / Hall Lamp");
		hallLamp.on();
		
		Lighting floorLamp = new Lighting(id+" / Floor Lamp");
		floorLamp.on();
		
		DimmingLights moodLamp = new DimmingLights(id+" / Mood Lamp");
		moodLamp.setBright(Double.parseDouble(bright));
		moodLamp.on();
	}

}
