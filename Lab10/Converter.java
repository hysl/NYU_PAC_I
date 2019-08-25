/*
Helen Li
December 15, 2017
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Converter
{
	private String inFix;

	public Converter (String inFix)
	{
		this.inFix = inFix;
	}

	public String toPostFix() throws PostFixException
	{
		ArrayStack<String> stack = new ArrayStack<String>();
		List<String> newInFix;

		String postFix = "";
		String prevOp;

		try
		{
			newInFix = parse(inFix.toCharArray());
		}
		catch (PostFixException ex)
		{
			throw new PostFixException(ex.getMessage());
		}

		for (String current: newInFix)
		{
			if (stack.isFull())
				throw new PostFixException("Error! Stack overflow!");
			else if (isOperand(current))
				postFix += current + " ";
			else if (current.equals("("))
				stack.push(current);
			else if (current.equals(")"))
			{
				if (stack.isEmpty())
					throw new PostFixException("Error! Stack underflow - missing opening parentheses");
				
				else
				{
					while (!stack.isEmpty())
					{
						prevOp = stack.top();
						if (!prevOp.equals("("))
						{
							postFix += prevOp + " ";
							stack.pop(); 
						}
						else	
							break;
					}
		
					if (stack.isEmpty())
						throw new PostFixException("Error! Stack underflow - missing opening parentheses");
					else
						stack.pop();
				}
			}
			else if (isOperator(current))
			{
				if (stack.isEmpty())
					stack.push(current);
				else
				{
					while (!stack.isEmpty())
					{
						prevOp = stack.top();
						if (!precedence(prevOp, current) && !prevOp.equals("("))
						{
							postFix += prevOp + " ";
							stack.pop();
						}
						else
							break;
					}
					stack.push(current);
				}
			}
			else
				postFix = postFix;
		}
	
		while (!stack.isEmpty())
		{
			prevOp = stack.top();
			if (!prevOp.equals("("))
			{
				postFix += prevOp + " ";
				stack.pop();
			}
		
			else
				throw new PostFixException("Error! Stack underflow - missing closing parentheses");
		}
		return postFix;
	}

	private boolean precedence(String prevOp, String currentOp)
	{
		if (currentOp.equals("^"))
		{
			return (prevOp.equals("*") || prevOp.equals("/") ||
					prevOp.equals("+") || prevOp.equals("-") ||
					prevOp.equals("("));
		}
		else if (currentOp.equals("*") || currentOp.equals("/"))
		{
			return (prevOp.equals("+") || prevOp.equals("-") ||
					prevOp.equals("("));
		}
		else if (currentOp.equals("+") || currentOp.equals("-"))
			return prevOp.equals("(");
		else
			return false;
	}

	private static List<String> parse(char[] input) throws PostFixException
	{
	    List<String> parsed = new ArrayList<String>();
	    for (int i = 0; i < input.length; i++) 
	    {
	        char c = input[i];
	        if (Character.isDigit(c)) 
	        {
	            String number = input[i] + "";
	            for (int j = i + 1; j < input.length; j++) 
	            {
	                if (Character.isDigit(input[j])) 
	                {
	                    number += input[j];
	                    i = j;
	                } 
	                else 
	                    break;
	            }
	            parsed.add(number);
	        } 
	        else if (c == '*' || c == '/' || c == '+' || c == '-' || 
	                 c == '^' || c == '(' || c == ')') 
	        {
	            parsed.add(c + "");
	        }
	        else if (c == ' ');
	        else
	        	throw new PostFixException("Error! Illegal operator: " + c);
	    }
	    return parsed;
	}

	private boolean isOperand(String curr)
	{
		try
		{
			Integer.parseInt(curr);
		}
		catch (NumberFormatException ex)
		{
			return false;
		}
		return true;
	}

	private boolean isOperator(String curr)
	{
		switch (curr)
		{
			case "+": case "-": case "*": case "/": case "^":
				return true;
			default:
				return false;
		}
	}
}
