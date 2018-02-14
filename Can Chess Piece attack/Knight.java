import java.lang.*;
class Knight extends ChessPiece
{
  int col;
  int row;
  char s;
  public Knight(int c, int r, char p)
  {
    super(c, r, p);
    this.col = c;
    this.row = r;
    this.s = p;
  }
  boolean isAttacking(ChessPiece c)
  {
    if((this.col == Math.abs(c.col + 1) && this.row == Math.abs(c.row + 2)) || (this.col == Math.abs(c.col - 1) && this.row == Math.abs(c.row + 2)) || (this.col == Math.abs(c.col + 1) && this.row == Math.abs(c.row - 2)) || (this.col == Math.abs(c.col - 1) && this.row == Math.abs(c.row - 2)) ||
    (this.col == Math.abs(c.col + 2) && this.row == Math.abs(c.row + 1)) || (this.col == Math.abs(c.col - 2) && this.row == Math.abs(c.row + 1)) || (this.col == Math.abs(c.col + 2) && this.row == Math.abs(c.row - 1)) || (this.col == Math.abs(c.col - 2) && this.row == Math.abs(c.row - 1)))
    {
      return true;
    }
    else
      return false;
  }
}
