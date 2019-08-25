/*
Helen Li
November 22, 2017
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class GameOfLife
{
	public static final int M = 25;
	public static final int N = 75;

	public static void main (String [] args)
	{
		char[][] gen1 = new char[M + 2][N + 2];

		Scanner consoleReader = new Scanner(System.in);
		Scanner fileReader = null;

		boolean validInput = false;

		int genNum = 0;
		String action = "";

		while (validInput == false)
		{
			System.out.println();
			System.out.print("Enter a filename: ");
			String filename = consoleReader.next();
			File file = new File(filename);

			try
			{
				fileReader = new Scanner(file);
				validInput = true;
			}
			catch (FileNotFoundException e)
			{
				System.out.println("Error! File " + file + " does not exist! Try again!");
			}
		}

		for (int row = 0; row < gen1.length; row++)
		{
			if (row == 0 || row == (gen1.length - 1))
			{
				for (int col = 0; col < gen1[0].length; col++)
				{
					gen1[row][col] = '.';
				}
			}
			else
			{
				String readLine = fileReader.nextLine();
				readLine = "." + readLine + ".";
				gen1[row] = readLine.toCharArray();
			}
		}

		printGen(gen1, genNum);

		while (action.equals(""))
		{
			System.out.println("What would you like to do?");
			System.out.println("[1] Generate the next generation");
			System.out.println("[2] Terminate the program");
			System.out.print("\nUser Input: ");
			action = consoleReader.next();

			switch (action)
			{
				case "1":
					char[][] nextGen = new char[M + 2][N + 2];
					genNum++;

					for (int row = 0; row < nextGen.length; row++)
					{
						for (int col = 0; col < nextGen[0].length; col++)
						{
							if (row == 0 || row == (nextGen.length - 1))
							{
								nextGen[row][col] = '.';
							}
							else if (col == 0 || col == (nextGen[0].length - 1))
							{
								nextGen[row][col] = '.';
							}
							else
							{
								if (gen1[row][col] == 'X')
								{
									if (checkNeighbors(gen1, row, col) == 2 || checkNeighbors(gen1, row, col) == 3)
										nextGen[row][col] = 'X';
									else
										nextGen[row][col] = '.';
								}
								else if (gen1[row][col] == '.')
								{
									if (checkNeighbors(gen1, row, col) == 3)
										nextGen[row][col] = 'X';
									else
										nextGen[row][col] = '.';
								}
							}
						}
					}

					if (isEmpty(nextGen) == true)
					{
						printGen(nextGen, genNum);
						System.out.println("Generation #" + genNum + " is empty! Game Over!\n");
						System.out.println("Thanks for playing! Bye bye!\n");
						break;
					}
					else if (isSame(gen1, nextGen) == true)
					{	
						printGen(nextGen, genNum);
						System.out.println("Generation #" + genNum + " is the same as Generation #" + (genNum - 1) + "! Game Over!\n");
						System.out.println("Thanks for playing! Bye bye!\n");
						break;
					}
					else
					{
						printGen(nextGen, genNum);
						gen1 = nextGen;
						action = "";
						break;
					}
				case "2":
					System.out.println("\nExiting Game Of Life...");
					printGen(gen1, genNum);
					System.out.println("Thanks for playing! Bye bye!\n");
					break;
				default:
					System.out.println("\nInvalid input! Try Again!\n");
					action = "";
					break;
			}
		}
	}

	public static void printGen(char[][] gen, int genNum)
	{
		System.out.println("\nGeneration #" + genNum + ":\n");
		
		for (int row = 1; row <= M; row++)
		{
			for (int col = 1; col <= N; col++)
			{
				System.out.print(gen[row][col]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static int checkNeighbors(char[][] gen, int row, int col)
	{
		int neighbors = 0;

		for (int i = -1; i <= 1; i++)
		{
			for (int j = -1; j <= 1; j++)
			{
				if (i == 0 && j == 0)
					neighbors = neighbors;
				else if (gen[row + i][col + j] == 'X')
					neighbors++;
			}
		}
		return neighbors;
	}

	public static boolean isEmpty(char[][] gen)
	{
		for (int row = 0; row < gen.length; row++)
		{
			for (int col = 0; col < gen[0].length; col++)
			{
				if (gen[row][col] == 'X')
					return false;
			}
		}
		return true;
	}

	public static boolean isSame(char[][] gen1, char[][] gen2)
	{
		for (int row = 0; row < gen1.length; row++)
		{
			for (int col = 0; col < gen2[0].length; col++)
			{
				if (gen1[row][col] != gen2[row][col])
					return false;
			}
		}
		return true;
	}
}
