package problem1;

class FordTruck implements Truck
{
	int axels;
	double weight;

	FordTruck( int axels, double weight)
	{
		this.axels = axels;
		this.weight = weight;
	}
	public int getAxles()
	{
		return this.axels;
	}
	public double getWeight()
	{
		return this.weight;
	}
}
