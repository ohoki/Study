package homework;

public class ObesityInfo extends StandardWeightInfo{
	double obesity;
	
	ObesityInfo(String name, int cm, int kg) {
		super(name, cm, kg);
	}

	@Override
	public void getInformation() {
		String result;
		getObesity();
		
		if(obesity >= 25.0) {
			result = "비만";
		} else if(obesity >= 23.0) {
			result = "과체중";
		} else if(obesity >= 18.5) {
			result = "정상";
		} else {
			result = "저체중";
		}
		
		System.out.println("이름 : " + name + " 키 : " + cm + " 몸무게 : " + kg + " 비만도 : "+ result);
	}
	
	public double getObesity() {
		this.obesity = ( (super.kg - super.StandardWeight)/StandardWeight * 100 );
		
		return obesity;
	}

}
