/*
Helen Li
October 18, 2017
*/

public class SmallInt
{
	private int value;

	public static final int MAXVALUE = 1000;

	public SmallInt (int num) 
	{
		checkNum(num);
	}

	public void checkNum (int num)
	{
		if(num >= 0 && num <= MAXVALUE)
		{
			value = num;
		}
		else
		{
			System.out.println("\nError! Out of range!");
			value = 0;
		}
	}

	public String getDec()
	{
		String empty = "";
		String stringRep = value + empty;
		return stringRep;
	}

	public void setDec(int num)
	{
		checkNum(num);
	}

	public String getBin()
	{
		String binaryString = "";
	
		if(value == 0)
		{
			binaryString = "0";
		}
		else
		{
			int number = value;
			while(number > 0)
			{
				int remainder = number % 2;
				number = (int)(number / 2);
				binaryString = remainder + binaryString;
			}
		}
		return binaryString;
	}

	public String getHex()
	{
		String hexString = "";
	
		if(value == 0)
		{
			hexString = "0";
		}
		else
		{
			int number = value;
			while(number > 0)
			{
				int remainder = number % 16;
				number = (int)(number / 16);
				if(remainder < 10)
				{
					hexString = remainder + hexString;
				}
				else
				{
					hexString = (char)('A' + remainder - 10) + hexString;
				}
			}
		}
		return hexString;
	}

	public static boolean sameValue(String bin, String hex)
	{
		int binaryInt = Integer.parseInt(bin);
		int decimalRep = 0;
		int i = 1;

		while(binaryInt > 0)
		{
			int remainder = binaryInt % 2;
			decimalRep = decimalRep + (remainder * i);
			i = i * 2;
			binaryInt = binaryInt / 10;
		}
		
		SmallInt answer = new SmallInt(decimalRep);
		String binAsHex = answer.getHex();
		if(binAsHex.equals(hex))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
