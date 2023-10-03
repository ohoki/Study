class Accounting {
	public double valueOfSupply;
	public double vatRate;
	public double expensRate;
	double[] dividendRates = new double[3];
	
	public double getVAT() {
		return valueOfSupply*vatRate;
	}
	
	public double getTotal() {
		return valueOfSupply + getVAT();
	}
	
	public double getExpense() {
		return valueOfSupply*expensRate;
	}
	
	public double getIncome() {
		return valueOfSupply - getExpense();
	}

    public void print() {
		
		double dividend1;
		double dividend2;
		double dividend3;
		
		if (getIncome() > 10000.0) {
			dividendRates[0] = 0.5;
			dividendRates[1] = 0.3;
			dividendRates[2] = 0.2;
		} else {
			dividendRates[0] = 1.0;
			dividendRates[1] = 0;
			dividendRates[2] = 0;
		}
		
		System.out.println("Value of supply: "+valueOfSupply);
		System.out.println("VAT: "+getVAT() );
		System.out.println("Total: "+getTotal() );
		System.out.println("Expense: "+getExpense() );
		System.out.println("Income: "+getIncome() );
		
		int i = 0;
		while (i < dividendRates.length) {
			System.out.println("Dividend: "+(getIncome() * dividendRates[i]) );
			i = i + 1;
		}
	}
	}

public class AccountingApp {
	
	public static void main(String[] args) {
		
		//static을 빼면 클래스 그 자체로 사용하진 못한다(error 발생)
//		Accounting.valueOfSupply = Double.parseDouble(args[0]);
//		Accounting.vatRate = 0.1;
//		Accounting.expensRate = 0.3;
//		Accounting.print();	
		
		//인스턴스(instance)를 사용하려면 클래스의 필드에서 static을 빼야함
		Accounting a1 = new Accounting();
		a1.valueOfSupply = 27900.0;
		a1.vatRate = 0.2;
		a1.expensRate = 0.4;
		a1.print();
		
		Accounting a2 = new Accounting();
		a2.valueOfSupply = 42500.0;
		a2.vatRate = 0.1;
		a2.expensRate = 0.2;
		a2.print();
	}
}