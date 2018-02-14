import java.lang.*;
class King extends ChessPiece
{
  int col;
  int row;
  char s;
  public King(int c, int r, char p)
  {
    super(c, r, p);
    this.col = c;
    this.row = r;
    this.s = p;
  }
  boolean isAttacking(ChessPiece c)
  {
    //check if there's a piece one away from col and row and diagonal
    boolean attack;
    if((this.col == c.col + 1 && this.row == c.row) || (this.col == c.col - 1 && this.row == c.row) || (this.row == c.row + 1 && this.col == c.col) || (this.row == c.row - 1 && this.col == c.col) ||
    (this.row == c.row - 1 && this.col == c.col - 1) || (this.row == c.row - 1 && this.col == c.col + 1) || (this.row == c.row + 1 && this.col == c.col - 1) || (this.row == c.row + 1 && this.col == c.col + 1))
      attack = true;
    attack = false;
    return attack;
  }
}
