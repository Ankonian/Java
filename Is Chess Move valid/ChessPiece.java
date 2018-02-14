import java.lang.*;
class ChessPiece
{
	int col;
	int row;
	char color;
	public ChessPiece(int c, int r, char p)
	{
		this.col = c;
		this.row = r;
		this.color = p;
	}
	boolean isAttacking(ChessPiece c)
	{
		return false;
	}
	boolean checkPathKing(LinkedList ll, ChessPiece k)
	{
		return false;
	}
	boolean checkPath(LinkedList ll, ChessPiece n)
	{
		return false;
	}
}
