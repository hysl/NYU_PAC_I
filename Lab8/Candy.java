/*
Helen Li
November 8, 2017
*/

public class Candy extends DessertItem
{
	private double weight;
	private int pricePerPound;

	public Candy(String name, double weight, int pricePerPound)
	{
		super(name);
		this.weight = weight;
		this.pricePerPound = pricePerPound;
	}

	public int getCost()
	{
		return (int)(Math.round(pricePerPound * weight));
	}

	public double getWeight()
	{
		return weight;
	}

	public int getPricePerPound()
	{
		return pricePerPound;
	}
}
