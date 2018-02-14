import java.util.*;
import java.io.*;
import java.lang.*;
class NQueens
{
	public static void main(String[] args) throws IOException
	{
		//Got idea from the previous labs on how to read input file and write output file
		if(args.length < 2)
		{
			System.out.println("Usage: java -jar NQueens.jar <input file> <output file>");
			System.exit(1);
		}
		//open files
		Scanner in = new Scanner(new File(args[0]));
		PrintWriter out = new PrintWriter(new File(args[1]));

		while(in.hasNextLine())
		{
				String line = in.nextLine();
				String[] tokens = line.split("\\s+");
				int boardSize = Integer.parseInt(tokens[0]);
//				System.out.println("boardSize: "+boardSize);
				Stack<Queen> stack = new Stack<Queen>();
				Stack<Queen> temp = new Stack<Queen>();
				Stack<Queen> temp2 = new Stack<Queen>();
//				System.out.println(boardSize);
				//store all the current numbers in the line into the stack
				int i = 0;
				int stackSize = 0;
				int startSize = 0;
				int[] num = new int[tokens.length];

				for(int j = 1; j < num.length; j++)
				{
					num[j] = Integer.parseInt(tokens[j]);
//					System.out.println(num[j]);
				}

//				System.out.println("finish");
				for(i = 1; i < num.length; i+=2)
				{
					int col = num[i];
					int row = num[i+1];
//					System.out.println(col + " " + row);
					Queen q = new Queen(col, row);
					stack.push(q);
					temp.push(q);
					temp2.push(q);
					stackSize++;
					startSize++;
				}
				//check if placed queen is out of board size
				boolean outOfBound = false;
				for(Queen b : stack);
				{
					Queen t = temp2.pop();
					if(t.col > boardSize || t.row > boardSize)
					{
						outOfBound = true;
					}
				}
				//check if placed queen is attacking other placed queens
				boolean placedQueenAttack = false;
				for(Queen a : stack)
				{
					Queen t = temp.pop();
					if(t.isAttacking(temp))
					{
						placedQueenAttack = true;
					}
				}
				if(placedQueenAttack || outOfBound)
				{
					out.println("No solution");
				}
				else
				{
					if(nQueens(boardSize, stack, stackSize, startSize))
					{
						for(Queen k : stack)
						{
							System.out.println("col "+k.col+" row "+k.row);
						}
						int[] solution = new int[boardSize];
						for(Queen j : stack)
						{
							solution[j.col - 1] = j.row;
						}
						for(int j = 0; j < solution.length; j++)
						{
							out.print((j + 1) + " " + solution[j] + " ");
						}
						out.println();
					}
					else
					{
						out.println("No solution");
					}
				}
			}
		//close the files
		in.close();
		out.close();
	}

	static boolean find(Queen q, Stack<Queen> s)
	{
		boolean found = false;
		for(Queen i : s)
		{
			if(q.col == i.col)
			{
				found = true;
			}
		}
		return found;
	}
	static boolean nQueens(int n, Stack<Queen> s, int stackSize, int startSize)
	{
		//iterate col
		for(int i = 1; i <= n; i++)
		{
			//iterate row
			for(int j = 1; j <= n; j++)
			{
				//if one of the pre-placed queen is popped, the board is invalid
				boolean canPutPiece = false;
				System.out.println("StartSize: "+startSize + " StackSize: "+stackSize);
				if(startSize > stackSize)
				{
//					System.out.println("popped one orignal piece");
					return false;
				}
				else
				{
					//make a temp queen with current col and row
					Queen q = new Queen(i, j);
					//if there's a queen at the same col
					if(find(q, s))
					{
//						System.out.println("Two queens at same col "+ q.col + " " + q.row);
						break;
					}
					//check if the current queen is attacking any other queens
					if(!q.isAttacking(s))
					{
						System.out.println("push "+q.col+" "+q.row);
						s.push(q);
						stackSize++;
						break;
					}
					while(j == n && stackSize >= startSize)
					{
						System.out.println("j "+ j + " n "+n);
						System.out.println("pop");
						Queen fail = s.pop();
//						System.out.println("popped");
						i = fail.col;
						j = fail.row;
						System.out.println("new j "+j);
						stackSize--;
					}
					//so it will check stackSize and start size before the loop ends
					if(startSize > stackSize)
					{
	//					System.out.println("popped one orignal piece");
						return false;
					}
				}
			}
		}
		return true;
	}
}
