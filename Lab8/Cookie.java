/*
Helen Li
November 8, 2017
*/

public class Cookie extends DessertItem
{
	private int number;
	private int pricePerDozen;

	public Cookie(String name, int number, int pricePerDozen)
	{
		super(name);
		this.number = number;
		this.pricePerDozen = pricePerDozen;
	}

	public int getCost()
	{
		return (int)(Math.round((number / 12.0) * pricePerDozen));
	}

	public int getNumber()
	{
		return number;
	}

	public int getPricePerDozen()
	{
		return pricePerDozen;
	}
}
