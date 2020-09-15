package problem1;

class Toll implements TollBooth
{
	int numberOfTrucks;
	double recipts;

	public Toll()
	{
		numberOfTrucks = 0;
		recipts =  0;
	}

	public void calculate(Truck x)
	{
		int axels = x.getAxles();
		double weight = x.getWeight();
		double fee = 5*axels + 10*((weight/1000));
		numberOfTrucks = numberOfTrucks + 1;
		recipts = recipts + fee;
		System.out.println("Truck arrival - Axles: " + axels + " Total Weight : " + weight + " Toll due : " + fee);
	}

	public void collect()
	{
		System.out.println("*** Collecting receipts  ***");
		displayData();
		numberOfTrucks = 0;
		recipts = 0;
	}
	public void displayData()
	{
		System.out.println("Totals since last collection - Receipts: " + recipts + " Trucks: " + numberOfTrucks);
	}
}
