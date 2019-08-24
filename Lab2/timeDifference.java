/*
Helen Li
September 20, 2017
*/

import java.util.Scanner;

public class timeDifference 
{
	public static void main (String args[]) 
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter first time: ");
		int num1 = input.nextInt();
		System.out.print("Enter second time: ");
		int num2 = input.nextInt();
		
		int firstHour = (num1 / 10000) * 3600;
		int firstMin = ((num1 / 100) % 100) * 60;
		int firstSec = num1 % 100;

		int secondHour = (num2 / 10000) * 3600;
		int secondMin = ((num2 / 100) % 100) * 60;
		int secondSec = num2 % 100;

		int diff = (firstHour + firstMin + firstSec) - (secondHour + secondMin + secondSec);

		int diffHour = (diff / 3600) * 10000;
		int diffMin = ((diff / 60) - ((diff / 3600) * 60)) * 100;
		int diffSec = diff % 60;

		int newDiff = diffHour + diffMin + diffSec;

		System.out.println("Time difference: " + newDiff);
	}
}
