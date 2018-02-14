import java.lang.*;
class Bishop extends ChessPiece
{
  int col;
  int row;
  char s;
  Bishop(int c, int r, char p)
  {
    super(c, r, p);
    this.col = c;
    this.row = r;
    this.s = p;
  }
  boolean isAttacking(ChessPiece c)
  {
    if(Math.abs(this.col - c.col) == Math.abs(this.row - c.row))
      return true;
    else
      return false;
  }
}
