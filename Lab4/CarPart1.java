/*
Helen Li
October 4, 2017
*/

import java.util.Scanner;
import java.util.Random;

public class CarPart1
{
	public static void main (String args [])
	{
		Scanner input = new Scanner(System.in);

		String action = "";

		char colorChar = 0;
		char carColor = assignColor(colorChar);

		boolean ignition = true;

		int positionH = 0;
		int xPosition = randomizePosition(positionH);
		int positionV = 0;
		int yPosition = randomizePosition(positionV);

		reportState(carColor, ignition, xPosition, yPosition);

		while (action.equals(""))
		{
			System.out.println("\nWhat would you like to do?\n");
			System.out.println("Turn ignition on/off [1]");
			System.out.println("\t    Move car [2]");
			System.out.println("\tQuit program [Q]\n");
			System.out.print("\tUser input: ");
			action = input.next();

			switch (action)
			{
				case "1":
					ignition = ignitionSwitch(ignition);
					reportState(carColor, ignition, xPosition, yPosition);
					action = "";
					break;
				case "2":
					String direction = "";

					while (direction.equals(""))
					{
						System.out.println("\nIn which direction do you want to move the car?");
						System.out.println("H: Horizontal");
						System.out.println("V: Vertical");
						System.out.print("Direction: ");
						direction = input.next();

						switch (direction)
						{
							case "H": case "h":
								System.out.print("\nEnter a movement distance: ");
								int moveH = input.nextInt();
								xPosition = moveHorizontally(xPosition, moveH, ignition);
								reportState(carColor, ignition, xPosition, yPosition);
								action = "";
								break;
							case "V": case "v":
								System.out.print("\nEnter a movement distance: ");
								int moveV = input.nextInt();
								yPosition = moveVertically(yPosition, moveV, ignition);
								reportState(carColor, ignition, xPosition, yPosition);
								action = "";
								break;
							default:
								System.out.println("\nInvalid Direction! Try again!");
								direction = "";
						}
					}
					break;
				case "Q": case "q":
					System.out.println("\nExiting Car Simulator...");
					reportState(carColor, ignition, xPosition, yPosition);
					System.out.println("\nBye Bye!\n");
					break;
				default:
					System.out.println("\nInvalid Selection! Try again!");
					reportState(carColor, ignition, xPosition, yPosition);
					action = "";
					break;
			}
		}
	}


	public static int randomizePosition (int originalPost)
	{
		originalPost = 1 + (int)(Math.random() * 20);
		return originalPost;
	}


	public static char assignColor (char colorChar)
	{
		int color = 0;
		color = 1 + (int)(Math.random() * 5);

		switch (color)
		{
			case 1:
				colorChar = 'R';
				break;
			case 2:
				colorChar = 'G';
				break;
			case 3:
				colorChar = 'B';
				break;
			case 4:
				colorChar = 'W';
				break;
			case 5:
				colorChar = 'S';
				break;
		}

		return colorChar;
	}


	public static boolean ignitionSwitch (boolean currentIgnition)
	{
		if (currentIgnition == false)
		{
			currentIgnition = true;
		}
		else if (currentIgnition == true)
		{
			currentIgnition = false;
		}
		return currentIgnition;
	}


	public static int moveHorizontally (int xPosition, int moveH, boolean ignition)
	{
		if (ignition == true)
		{
			System.out.println("\nIgnition is OFF! Try again!");
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

		return xPosition;
	}


	public static int moveVertically ( int yPosition, int moveV, boolean ignition)
	{
		if (ignition == true)
		{
			System.out.println("\nIgnition is OFF! Try again!");
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

		return yPosition;
	}


	public static void reportState (char carColor, boolean ignition, int xPosition, int yPosition)
	{
		System.out.println("\nCar Information:\n");

		String colorName = "";

		switch (carColor)
		{
			case 'R':
				colorName = "Red";
				break;
			case 'G':
				colorName = "Green";
				break;
			case 'B':
				colorName = "Black";
				break;
			case 'W':
				colorName = "White";
				break;
			case 'S':
				colorName = "Silver";
				break;
		}

		System.out.println("   Color: " + colorName);

		String ignitionState = "";
		if (ignition == false)
		{
			ignitionState = "ON";
		}
		else
		{
			ignitionState = "OFF";
		}

		System.out.println("Ignition: " + ignitionState);

		System.out.println("Location: (" + xPosition + ", " + yPosition + ")\n");

		for (int yCoord = 1; yCoord <= 20; yCoord++)
		{
			for (int xCoord = 1; xCoord <= 20; xCoord++)
			{
				if (xCoord == xPosition && yCoord == yPosition)
				{
					System.out.print(carColor);
				}
				else
				{
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}
}
