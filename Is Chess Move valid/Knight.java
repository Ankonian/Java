import java.lang.*;
class Knight extends ChessPiece
{
  int col;
  int row;
  char color;
  public Knight(int c, int r, char p)
  {
    super(c, r, p);
    this.col = c;
    this.row = r;
    this.color = p;
  }
  boolean isAttacking(ChessPiece c)
  {
    int attackRow[] = {-1, 1, -1, 1, -2, -2, 2, 2}; // possible attack row positions
    int attackCol[] = {-2, -2, 2, 2, -1, 1, -1, 1}; // possible attack col positions

    for(int i = 0; i < 8; i++) {
      if(this.row + attackRow[i] == c.row && this.col + attackCol[i] == c.col) {
        return true;
      }
    }
    return false;
  }
  boolean checkPathKing(LinkedList ll, ChessPiece n)
  {
    System.out.println("this: "+this.col+" "+this.row+" "+this.color);
    System.out.println("n: "+n.col+" "+n.row+" "+n.color);
    boolean clear = false;
    if(this.isAttacking(n))
    {
      System.out.println("blah");
      clear = true;
    }
    return clear;
  }
  boolean checkPath(LinkedList ll, ChessPiece n)
  {
    //since knights can jump past chess pieces, no need to worry about the path it will take, just check if the piece at destination has the same color as it
    boolean clear = false;
    System.out.println("this: "+this.col+" "+this.row+" "+this.color);
    System.out.println("n: "+n.col+" "+n.row+" "+n.color);
    if(this.isAttacking(n) && n.color == ' ')
    {
      clear = true;
      ChessPiece temp = new ChessPiece(n.col, n.row, ' ');
      ll.replace(this, temp);
      this.col = temp.col;
      this.row = temp.row;
    }
    else if(this.isAttacking(n) && (Character.isLowerCase(this.color) != Character.isLowerCase(n.color)))
    {
      clear = true;
      ChessPiece temp = new ChessPiece(n.col, n.row, ' ');
      ll.find(temp);
      System.out.println("temp knight: "+temp.col+" "+temp.row);
      ll.replace(this, temp);
      this.col = temp.col;
      this.row = temp.row;
      System.out.println("this knight: "+this.col+" "+this.row);
      ll.delete(n);
    }
    return clear;
  }
}
