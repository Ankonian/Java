import java.lang.*;
class Rook extends ChessPiece
{
  int col;
  int row;
  char s;
  public Rook(int c, int r, char p)
  {
    super(c, r, p);
    this.col = c;
    this.row = r;
    this.s = p;
  }
  boolean isAttacking(ChessPiece c)
  {
    if(this.col == c.col || this.row == c.row)
      return true;
    else
      return false;
  }
}
