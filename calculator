/*
Helen Li
September 27, 2017
*/

import java.util.Scanner;

public class calculator
{
	public static void main (String args [])
	{
		double num1, num2, num3, ans;
		ans = 0; 					// clear answer
		String operator = ""; 		// clear operator

		Scanner input = new Scanner(System.in);

		System.out.print("1st input: ");
		num1 = input.nextDouble();

		System.out.print("op: ");
		operator = input.next();

		switch (operator)
		{
			case "x": 				// user can exit program at the first opportunity
				System.out.println("Exiting... Bye!");
				break;				// program ends, will not enter while loop
			case "c": 				// user can clear calculator at the first opportunity
				ans = 0;			// clear answer
				System.out.println("Calculator cleared.");
				System.out.println("ans: " + ans);
				operator = "";		// clear operator to enter while loop below
				break;
			case "+":				// user can add, prompt user to enter 2nd input, and add
				System.out.print("2nd input: ");
				num2 = input.nextDouble();
				ans = num1 + num2;
				System.out.println("ans: " + ans);
				operator = "";		// clear operator to enter while loop below
				break;
			case "-":				// user can subtract, prompt user to enter 2nd input, and subtract
				System.out.print("2nd input: ");
				num2 = input.nextDouble();
				ans = num1 - num2;
				System.out.println("ans: " + ans);
				operator = "";		// clear operator to enter while loop below
				break;
			case "*":				// user can multiply, prompt user to enter 2nd input, and multiply
				System.out.print("2nd input: ");
				num2 = input.nextDouble();
				ans = num1 * num2;
				System.out.println("ans: " + ans);
				operator = "";		// clear operator to enter while loop below
				break;
			case "/":				// user can divide, prompt user to enter 2nd input, and divide
				System.out.print("2nd input: ");
				num2 = input.nextDouble();
				if (num2 == 0)		// catch error, cannot divide by 0
				{
					System.out.println("Error! Cannot divide by 0. Try again.");
					ans = num1;		// buffer value will be the value of num1
				}
				else
				{
					ans = num1 / num2;
					System.out.println("ans: " + ans);
				}
				operator = "";		// clear operator to enter while loop below
				break;
			default:				// catch error, unknown operators
				System.out.println("Error! Unknown operator \"" + operator + "\". Try again.");
				ans = num1;			// buffer value will be the value of num1
				operator = "";		// clear operator to enter while loop below
				break;
		}

		while (operator.equals(""))
		{
			System.out.print("op: ");
			operator = input.next();

			switch (operator)
			{
				case "x":			// user can exit program when they desire
					System.out.println("Exiting... Bye!");
					break;
				case "c":			// user can clear calculator when they desire
					ans = 0;		// clear answer
					System.out.println("Calculator cleared.");
					System.out.println("ans: " + ans);
					operator = "";	// clear operator, while loop continues
					break;
				case "+":			// user can add buffer to the new input number
					System.out.print("more input: ");
					num3 = input.nextDouble();
					ans = ans + num3;
					System.out.println("ans: " + ans);
					operator = "";	// clear operator, while loop continues
					break;
				case "-":			// user can subtract buffer with the new input number
					System.out.print("more input: ");
					num3 = input.nextDouble();
					ans = ans - num3;
					System.out.println("ans: " + ans);
					operator = "";	// clear operator, while loop continues
					break;
				case "*":			// user can multiply buffer with the new input number
					System.out.print("more input: ");
					num3 = input.nextDouble();
					ans = ans * num3;
					System.out.println("ans: " + ans);
					operator = "";	// clear operator, while loop continues
					break;
				case "/":			// user can divide buffer with the new input number
					System.out.print("more input: ");
					num3 = input.nextDouble();
					if (num3 == 0)	// catch error, cannot divide by 0. Previous ans remains as buffer
					{
						System.out.println("Error! Cannot divide by 0. Try again.");
					}
					else
					{
						ans = ans / num3;
						System.out.println("ans: " + ans);
					}
					operator = "";	// clear operator, while loop continues
					break;
				default:			// catch error, unknown operators. Previous ans remains as buffer
					System.out.println("Error! Unknown operator \"" + operator + "\". Try again.");
					operator = "";	// clear operator, while loop continues
					break;
			}
		}
	}
}
