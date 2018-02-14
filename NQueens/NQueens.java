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
		while(in.hasNext())
		{
				//inspired by my roommate, since in the N queens problem only one queen will occupy each column.
				//A one-dimensional array is enough to keep track of both columns and rows
				int boardSize = Integer.parseInt(in.next());
				int[] qcols = new int[boardSize];

				int inputColumns = Integer.parseInt(in.next()) - 1;
				int inputRows = Integer.parseInt(in.next());

			//set the position of the first queen given by the input file
			qcols[inputColumns] = inputRows;

			//calling nQueens to start to placing process
			//if there is a solution, print out the coordinates in (x1 y1 x2 y2 ....)
			//if no solution or the board can't be filled with one queen in each column, print no solution
			if(nQueens(0, qcols))
			{
				for(int i = 1; i <= qcols.length; i++)
					out.print(i + " " + qcols[i - 1]+ " ");
				out.println();
			}
			else
			{
				out.println("No Solution");
			}
		}
		//close the files
		in.close();
		out.close();
	}

	static boolean nQueens(int n, int[] qcols)
	{
		//base case
		if(n >= qcols.length)
			return true;
		//find a free row that a queen can place
		//keep trying to look for a free space until all spaces was went through or found a free spot
		//if there's no free spot, set the row number to 0 and return false
		if(qcols[n] == 0)
		{
			do
			{
				qcols[n] = qcols[n] + 1;
			} while (qcols[n] <= qcols.length && !nQueens(n, qcols));
			if(qcols[n] > qcols.length)
			{
				qcols[n] = 0;
				return false;
			}
		}
		//the once isAttacking() method implemented.
		//Since it's only a 1D array, we don't need to check if there's two queens on the same column.
		//We just need to check if two queens are on the same row and the same diagonal
		//to check if they are the same row, simply check the value inside the qcols[] since the row numbers are stored inside qcols
		//To check if they are the same diagonal, find the absolute value of the delta of the index number and two numbers inside the cell
		for(int i = n; i >= 0; i--)
		{
			if(i != n && (qcols[i] == qcols[n] || Math.abs(i - n) == Math.abs(qcols[i] - qcols[n])))
				return false;
		}
		return nQueens(n + 1, qcols);
	}
}
