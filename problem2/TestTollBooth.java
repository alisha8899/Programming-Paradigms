package problem2;

public class TestTollBooth {

public static void main(String [] args){
	TollBooth booth = new Toll();

	Truck ford = new FordTruck(5, 12500); // 5 axles and 12000 kilograms
	Truck nissan = new NissanTruck(2, 5000); // 2 axles and 5000kg

	
	booth.calculate(ford);
	booth.calculate(nissan);

	booth.calculate(ford);
	booth.calculate(nissan);

	booth.calculate(ford);
	booth.displayData();
	
	booth.calculate(nissan);
		
	booth.collect();

	booth.displayData();

	}
}
