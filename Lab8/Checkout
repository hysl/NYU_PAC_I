/*
Helen Li
November 8, 2017
*/

public class Checkout
{
	private DessertItem[] dessertItems;
	private int numberOfItems;

	public Checkout()
	{
		dessertItems = new DessertItem[100];
		numberOfItems = 0;
	}

	public void enterItem(DessertItem item)
	{
		dessertItems[numberOfItems] = item;
		numberOfItems++;
	}

	public void clear()
	{
		dessertItems = new DessertItem[100];
		numberOfItems = 0;
	}

	public int numberOfItems()
	{
		return numberOfItems;
	}

	public int totalCost()
	{
		int sum = 0;
		for (int i = 0; i < numberOfItems; i++)
		{
			sum += dessertItems[i].getCost();
		}
		return sum;
	}

	public int totalTax()
	{
		return (int)(Math.round(totalCost() * (DessertShoppe.TAX_RATE / 100)));
	}

	public java.lang.String toString()
	{
		String result = "";
		int receiptWidth = DessertShoppe.MAX_ITEM_NAME_SIZE + DessertShoppe.COST_WIDTH;

		result += "\n     " + DessertShoppe.STORE_NAME + "\n";
		result += "     " + "--------------------" + "\n\n";

		for (int i = 0; i < numberOfItems; i++)
		{
			String dessertName = dessertItems[i].getName();
			String dessertPrice = DessertShoppe.cents2dollarsAndCents(dessertItems[i].getCost());

			if (dessertPrice.length() > DessertShoppe.COST_WIDTH)
			{
				dessertPrice = dessertPrice.substring(0, DessertShoppe.COST_WIDTH);
			}

			if (dessertItems[i] instanceof Candy)
			{
				String candyWeight = String.format("%.2f", ((Candy)dessertItems[i]).getWeight());
				result += candyWeight + " lbs. @ " + 
					DessertShoppe.cents2dollarsAndCents(((Candy)dessertItems[i]).getPricePerPound()) + " /lb.\n";
				while (dessertName.length() < receiptWidth - dessertPrice.length())
				{
					dessertName += " ";
				}
				result += dessertName + dessertPrice + "\n";
			}

			else if (dessertItems[i] instanceof Cookie)
			{
				result += ((Cookie)dessertItems[i]).getNumber() + " @ " +
					DessertShoppe.cents2dollarsAndCents(((Cookie)dessertItems[i]).getPricePerDozen()) + " /dz.\n";
				while (dessertName.length() < receiptWidth - dessertPrice.length())
				{
					dessertName += " ";
				}
				result += dessertName + dessertPrice + "\n";
			}

			else if (dessertItems[i] instanceof Sundae)
			{
				String checkToppingName = ((Sundae)dessertItems[i]).getToppingName();
				checkToppingName += " Sundae with";
				if (checkToppingName.length() <= DessertShoppe.MAX_ITEM_NAME_SIZE)
					checkToppingName = checkToppingName;
				else
					checkToppingName = checkToppingName.substring(0,DessertShoppe.MAX_ITEM_NAME_SIZE);
				result += checkToppingName + "\n";
				while (dessertName.length() < receiptWidth - dessertPrice.length())
				{
					dessertName += " ";
				}
				result += dessertName + dessertPrice + "\n";
			}

			else
			{
				while (dessertName.length() < receiptWidth - dessertPrice.length())
				{
					dessertName += " ";
				}
				result += dessertName + dessertPrice + "\n";
			}
		}

		String tax = "\nTax";
		String findTax = DessertShoppe.cents2dollarsAndCents(totalTax());
		while (tax.length() <= receiptWidth - findTax.length())
		{
			tax += " ";
		}
		result += tax + findTax + "\n";

		String cost = "Total Cost";
		String findCost = DessertShoppe.cents2dollarsAndCents(totalTax() + totalCost());
		while (cost.length() < receiptWidth - findCost.length())
		{
			cost += " ";
		}
		result += cost + findCost;

		return result;
	}
}
