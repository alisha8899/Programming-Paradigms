package problem2;

class Toll implements TollBooth
{
	int numberOfTrucks;
	Truck[] truck;
	
	public Toll()
	{
		numberOfTrucks = 0;
		truck = new Truck[5]; 
	}

	public void calculate(Truck x)
	{
		
		if(numberOfTrucks >= 4)
		{
			numberOfTrucks = 4;
		}
		
		truck[numberOfTrucks] = x;
		
		int axels = x.getAxles();
		double weight = x.getWeight();
		double fee = 5*axels + 10*((weight/1000));
		numberOfTrucks = numberOfTrucks + 1;
		System.out.println("Truck arrival - Axles: " + axels + " Total Weight: " + weight + " Toll due: " + fee);
		
	}

	public void collect()
	{
		System.out.println("*** Collecting receipts  ***");
		displayData();
		numberOfTrucks = 0;
	}
	public void displayData()
	{
		double total = 0; 
		for(int i = 0; i < numberOfTrucks; i++) {
			Truck a = truck[i];
			int axels = a.getAxles();
			double weight = a.getWeight();
			double fee = 5*axels + 10*((weight/1000));
			total += fee;
		}
		System.out.println("Trucks: " + numberOfTrucks + " Total Money: " + total);	
	}
	
	public void listOfTrucks()
	{
		System.out.println("List of Trucks :" + numberOfTrucks);
		for(int i = 0; i < numberOfTrucks; i++) {
			System.out.println("Truck: " + i + 1);
			Truck a = truck[i];
			int axels = a.getAxles();
			double weight = a.getWeight();
			double fee = 5*axels + 10*((weight/1000));
			
			System.out.println("Truck arrival - Axles: " + axels + " Total Weight : " + weight + " Toll due : " + fee);
		}
	}
}
