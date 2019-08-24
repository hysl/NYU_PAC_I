/*
Helen Li
November 1, 2017
*/

import java.util.Random;

public class CarWithOOP
{
	private char carColor;
	private int xPosition;
	private int yPosition;
	private boolean currentIgnition;

	public CarWithOOP()
	{
		carColor = assignColor();
		xPosition = randomizePosition();
		yPosition = randomizePosition();
		currentIgnition = false;
	}

	public int randomizePosition()
	{
		return (1 + (int)(Math.random() * 20));
	}

	public char assignColor()
	{
		int color = 1 + (int)(Math.random() * 5);
		switch (color)
		{
			case 1:
				carColor = 'R';
				break;
			case 2:
				carColor = 'G';
				break;
			case 3:
				carColor = 'B';
				break;
			case 4:
				carColor = 'W';
				break;
			case 5:
				carColor = 'S';
				break;
		}
		return carColor;
	}

	public void moveHorizontal(int moveH)
	{
		if (currentIgnition == false)
		{
			System.out.println("\nError! Ignition is OFF! Try again!");
		}
		else
		{
			if (((xPosition + moveH) >= 1) && ((xPosition + moveH) <= 20))
			{
				xPosition = xPosition + moveH;
			}
			else
			{
				System.out.println("\nError! Out of range! Try again!");
			}
		}
	}

	public void moveVertical(int moveV)
	{
		if (currentIgnition == false)
		{
			System.out.println("\nError! Ignition is OFF! Try again!");
		}
		else
		{
			if (((yPosition + moveV) >= 1) && ((yPosition + moveV) <= 20))
			{
				yPosition = yPosition + moveV;
			}
			else
			{
				System.out.println("\nError! Out of range! Try again!");
			}
		}
	}

	public void ignitionSwitch()
	{
		currentIgnition = (!currentIgnition);
	}

	public String getColor()
	{
		return (Character.toString(carColor));
	}

	public boolean getIgnition()
	{
		return currentIgnition;
	}

	public int getX()
	{
		return xPosition;
	}

	public int getY()
	{
		return yPosition;
	}

	public String toString()
	{
		String currentState = "";
		currentState += "\n";
		
		switch(getColor())
		{
			case "R":
				currentState += "Color: Red\n";
				break;
			case "G":
				currentState += "Color: Green\n";
				break;
			case "B":
				currentState += "Color: Blue\n";
				break;
			case "W":
				currentState += "Color: White\n";
				break;
			case "S":
				currentState += "Color: Silver\n";
				break;
		}

		if (getIgnition() == false)
		{
			currentState += "Ignition: OFF\n";
		}
		else
		{
			currentState += "Ignition: ON\n";
		}

		currentState += ("Location: (" + getX() + ", " + getY() + ")\n");

		for (int yCoord = 1; yCoord <= 20; yCoord++)
		{
			for (int xCoord = 1; xCoord <= 20; xCoord++)
			{
				if (yCoord == getY() && xCoord == getX())
				{
					currentState += (getColor() + " ");
				}
				else
				{
					currentState += "- ";
				}
			}
			currentState += "\n";
		}

		return currentState;
	}
}
