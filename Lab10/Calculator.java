/*
Helen Li
December 15, 2017
*/

import java.util.Scanner;

public class Calculator
{
	public static void main (String args[])
	{
		Scanner input = new Scanner(System.in);

		boolean moreInput = true;

		while (moreInput)
		{
			System.out.println("\nEnter an infix expression:");
			String action = input.nextLine();

			try
			{
				Converter converter = new Converter(action);
				String postFix = converter.toPostFix();
				double result = calculate(postFix);
				
				System.out.println("\nThe postfix expression is: " + postFix);
				System.out.println("\nAnswer: " + result);
			}
			catch (PostFixException ex)
			{
				System.out.println("\n" + ex.getMessage());
			}

			System.out.println("\nWould you like to evaluate another infix expression?");
			System.out.print("Press \"Y\" to continue: ");
			String nextAction = input.nextLine();
			switch (nextAction)
			{
				case "Y": case "y":
					break;
				default:
					moreInput = false;
					System.out.println("\nExiting program...");
					System.out.println("\nBye Bye!\n");
					break;
			}
		}
	}

	public static double calculate(String postFix) throws PostFixException
	{
		ArrayStack<Integer> stack = new ArrayStack<Integer>();

		int operand1;
		int operand2;
		String operator;
		int result = 0;
		int current;

		Scanner token = new Scanner(postFix);

		while (token.hasNext())
		{
			if (token.hasNextInt())
			{
				current = token.nextInt();
				if (stack.isFull())
					throw new PostFixException("Error! Stack Overflow!");
				stack.push(current);
			}
			else
			{
				operator = token.next();

				operand2 = stack.top();
				stack.pop();

				operand1 = stack.top();
				stack.pop();

				if (operator.equals("+"))
					result = operand1 + operand2;
				else if (operator.equals("-"))
					result = operand1 - operand2;
				else if (operator.equals("*"))
					result = operand1 * operand2;
				else if (operator.equals("/"))
					result = operand1 / operand2;
				else if (operator.equals("^"))
					result = (int)Math.pow(operand1, operand2);

				stack.push(result);
			}
		}
		return result;
	}
}
