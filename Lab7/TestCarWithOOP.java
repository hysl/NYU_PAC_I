/*
Helen Li
November 1, 2017
*/

import java.util.Scanner;

public class TestCarWithOOP
{
	public static void main (String [] args)
	{
		Scanner input = new Scanner(System.in);
		CarWithOOP [] testCar = new CarWithOOP[10];

		for (int i = 0; i < 10; i++)
		{
			testCar[i] = new CarWithOOP();
		}

		String action = "";
		int carIndex;
		System.out.println();

		while (action.equals(""))
		{
			System.out.println("Which car would you like to use? (Choose from 1-10)");
			System.out.print("Input: ");
			int carNum = input.nextInt();
			if (carNum < 1 || carNum > 10)
			{
				System.out.println("\nError! Invalid car number! Try again!\n");
				action = "";
				continue;
			}
			else
				carIndex = carNum - 1;
			
			System.out.println("\nCar #" + (carIndex + 1) + " Information:");
			System.out.println(testCar[carIndex].toString());
			
			System.out.println("What would you like to do?\n");
			System.out.println("Turn ignition on/off [1]");
			System.out.println("\t    Move car [2]");
			System.out.println("\t  Change car [3]");
			System.out.println("\tQuit program [Q]\n");
			System.out.print("\tUser input: ");
			action = input.next();

			switch (action)
			{
				case "1":
					testCar[carIndex].ignitionSwitch();
					System.out.println("\nCar #" + (carIndex + 1) + " Information:");
					System.out.println(testCar[carIndex].toString());
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
								testCar[carIndex].moveHorizontal(moveH);
								System.out.println("\nCar #" + (carIndex + 1) + " Information:");
								System.out.println(testCar[carIndex].toString());
								action = "";
								break;
							case "V": case "v":
								System.out.print("\nEnter a movement distance: ");
								int moveV = input.nextInt();
								testCar[carIndex].moveVertical(moveV);
								System.out.println("\nCar #" + (carIndex + 1) + " Information:");
								System.out.println(testCar[carIndex].toString());
								action = "";
								break;
							default:
								System.out.println("\nInvalid Direction! Try again!");
								direction = "";
								break;
						}
					}
					break;
				case "3":
					System.out.println("\nCar #" + (carIndex + 1) + " Information:");
					System.out.println(testCar[carIndex].toString());
					action = "";
					break;
				case "Q": case "q":
					System.out.println("\nExiting Car Simulator...");
					System.out.println("\nCar #" + (carIndex + 1) + " Information:");
					System.out.println(testCar[carIndex].toString());
					System.out.println("Bye Bye!\n");
					break;
				default:
					System.out.println("\nInvalid Selection! Try again!");
					System.out.println("\nCar #" + (carIndex + 1) + " Information:");
					System.out.println(testCar[carIndex].toString());
					action = "";
					break;
			}
		}
	}
}
