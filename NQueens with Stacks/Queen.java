import java.util.*;
import java.io.*;
import java.lang.*;
class Queen
{
  int col;
  int row;
  public Queen(int c, int r)
  {
    col = c;
    row = r;
  }
  public boolean isAttacking(Stack<Queen> s)
  {
    for(Queen i : s)
    {
      if(this.col == i.col || this.row == i.row)
      {
		  // System.out.println("this: "+this.col+" "+this.row);
		  // System.out.println("i: "+i.col + " "+i.row);
		  // System.out.println(true+"\n");
        return true;
      }
      else if(Math.abs(this.col - i.col) == Math.abs(this.row - i.row))
      {
		  // System.out.println("this: "+this.col+" "+this.row);
		  // System.out.println("i: "+i.col + " "+i.row);
		  // System.out.println(true+"\n");
        return true;
      }
    }
    return false;
  }
}
