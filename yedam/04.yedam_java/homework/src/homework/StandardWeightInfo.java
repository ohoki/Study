package homework;

public class StandardWeightInfo extends Human{
	double StandardWeight;
	
	StandardWeightInfo(String name, int cm, int kg) {
		super(name, cm, kg);	
	}
	
	public double getStandardWeight() {
		this.StandardWeight = ( (super.cm - 100) *0.9 );
		
		return StandardWeight;
	}

	@Override
	public void getInformation() {
		getStandardWeight();
		System.out.println("이름 : " + name + " 키 : " + cm + " 표준체중 : " + StandardWeight );
	}
}
