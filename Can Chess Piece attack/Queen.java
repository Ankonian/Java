import java.lang.*;
class Queen extends ChessPiece
{
  int col;
  int row;
  char s;
  public Queen(int c, int r, char p)
  {
    super(c, r, p);
    this.col = c;
    this.row = r;
    this.s = p;
  }
  public boolean isAttacking(ChessPiece c)
  {
    //check col, row, and diagonal to see if attacking
    if(this.col == c.col || this.row == c.row || (Math.abs(this.col - c.col) == Math.abs(this.row - c.row)))
      return true;
    //if not matched all check cases, Queen is not attacking that specific piece.
    else
      return false;
  }
}
