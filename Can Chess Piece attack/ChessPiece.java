import java.lang.*;
class ChessPiece
{
	int col;
	int row;
	char s;
	public ChessPiece(int c, int r, char p)
	{
		this.col = c;
		this.row = r;
		this.s = p;
	}
	boolean isAttacking(ChessPiece c)
	{
		return false;
	}
}
