import java.util.*;
import java.io.*;
import java.lang.*;
class ChessMoves
{
  public static void main(String[] args) throws IOException
  {
    //a fool-proof(I hope) checker to see if the command matches the desired format
    if(args.length < 2)
    {
      System.out.println("Usage: java -jar ChessMove.jar <input file> <output file>");
      System.exit(1);
    }
    Scanner in = new Scanner(new File(args[0]));
    PrintWriter out = new PrintWriter(new File(args[1]));
    while(in.hasNextLine())
    {
      //create linked list
      LinkedList ll = new LinkedList();

      //eliminate all the whitespaces from the input
      String line = in.nextLine().trim();
      line = line.replaceAll("\\s+","");

      //create a char array to store the input line
      char[] board = new char[line.length()];

      //storing all the char in a char array so I can convert to int easier
      for(int i = 0; i < line.length(); i++)
        board[i] = line.charAt(i);
      //before iterator hits the colon, keep storing the chesspieces in linked list
      int i;
      for(i = 0; board[i] != ':'; i+=3)
      {
        if(board[i] == 'k' || board[i] == 'K')
        {
          int count = i;
          char piece = board[i];
          int col = Character.getNumericValue(board[++count]);
          int row = Character.getNumericValue(board[++count]);
          ChessPiece c = new King(col, row, piece);
          ll.insert(c);
        }
        if(board[i] == 'q' || board[i] == 'Q')
        {
          int count = i;
          char piece = board[i];
          int col = Character.getNumericValue(board[++count]);
          int row = Character.getNumericValue(board[++count]);
          ChessPiece c = new Queen(col, row, piece);
          ll.insert(c);
        }
        if(board[i] == 'r' || board[i] == 'R')
        {
          int count = i;
          char piece = board[i];
          int col = Character.getNumericValue(board[++count]);
          int row = Character.getNumericValue(board[++count]);
          ChessPiece c = new Rook(col, row, piece);
          ll.insert(c);
        }
        if(board[i] == 'b' || board[i] == 'B')
        {
          int count = i;
          char piece = board[i];
          int col = Character.getNumericValue(board[++count]);
          int row = Character.getNumericValue(board[++count]);
          ChessPiece c = new Bishop(col, row, piece);
          ll.insert(c);
        }
        if(board[i] == 'n' || board[i] == 'N')
        {
          int count = i;
          char piece = board[i];
          int col = Character.getNumericValue(board[++count]);
          int row = Character.getNumericValue(board[++count]);
          ChessPiece c = new Knight(col, row, piece);
          ll.insert(c);
        }
      }
      //to skip over the colon since the loop above stop at colon
      i+=1;
		boolean legal = true;
    //ll.traverse();
      int numElements = 0;
      for(int j = i; j < board.length; j++)
        numElements+=j;
        int moveCount = 1;
        boolean isPrevWhite = false;
        boolean isWhite = false;
        while(i < board.length)
        {
          //read in numbers four at a time and start determining if this move is legal
          int moveCol = Character.getNumericValue(board[i]);
          int moveRow = Character.getNumericValue(board[i + 1]);
          ChessPiece move = new ChessPiece(moveCol, moveRow, ' ');
          int destCol = Character.getNumericValue(board[i + 2]);
          int destRow = Character.getNumericValue(board[i + 3]);
          ChessPiece dest = new ChessPiece(destCol, destRow, ' ');
          ChessPiece previous = new ChessPiece(moveCol, moveRow, ' ');

          //if the find method return a chesspiece with a char that's not a white space, there's a piece at that position
          if(ll.find(move).color != ' ')
          {
            move = ll.find(move);
            dest = ll.find(dest);
            //check color, check if this move is the first move
            if(moveCount == 1)
            {
              //if the first piece that move is a white piece, it's a legal move
              if(Character.isLowerCase(move.color))
              {
                isWhite = true;
                //if it passed checkPath() which will also move the piece
                boolean check = move.checkPath(ll, dest);
                if(check)
                {
                  //check King
                  ChessPiece king = findKing(ll, isWhite);
                  if(!checkMate(king, ll))
                  {
                    isPrevWhite = isWhite;
                    moveCount++;
                  }
                  else
                  {
                    out.println(previous.col + " " + previous.row + " " + dest.col + " " + dest.row + " " + "illegal");
                    legal = false;
                    break;
                  }
                }
                else
                {
                  out.println(previous.col + " " + previous.row + " " + dest.col + " " + dest.row + " " + "illegal");
                  legal = false;
                  break;
                }
              }
              else
              {
                out.println(move.col + " " + move.row + " " + dest.col + " " + dest.row + " " + "illegal");
                legal = false;
                break;
              }
            }
            else if(moveCount > 1)
            {
              //if it's not the first piece check if the current piece color different from last piece that moved
              isWhite = Character.isLowerCase(move.color);
              if(isPrevWhite != isWhite)
              {
                if(move.checkPath(ll, dest))
                {
                  ChessPiece king = findKing(ll, isWhite);
                  boolean checkM = checkMate(king, ll);
                  if(!checkM)
                  {
                    isPrevWhite = isWhite;
                    moveCount++;
                  }
                  else
                  {
                    out.println(previous.col + " " + previous.row + " " + dest.col + " " + dest.row + " " + "illegal");
                    legal = false;
                    break;
                  }
                }
                else
                {
                  out.println(previous.col + " " + previous.row + " " + dest.col + " " + dest.row + " " + "illegal");
                  legal = false;
                  break;
                }
              }
              else
              {
                out.println(move.col + " " + move.row + " " + dest.col + " " + dest.row + " " + "illegal");
                legal = false;
                break;
              }
            }
          }
          else
          {
            out.println(move.col + " " + move.row + " " + dest.col + " " + dest.row + " " + "illegal");
            legal = false;
            break;
          }
          i += 4;
        }
        if(legal)
        {
		      out.println("legal");
		    }
      }
      //close input output files
      in.close();
      out.close();
    }

    //check if king is being attacked after moving current piece
    public static boolean checkMate(ChessPiece k, LinkedList l)
    {
      boolean check = false;
      Node current = l.head;
      while(current != null)
      {
        if((Character.isLowerCase(current.val.color) != Character.isLowerCase(k.color)) && current.val.checkPathKing(l, k))
        {
          check = true;
        }
        current = current.next;
      }
      return check;
    }
    public static ChessPiece findKing(LinkedList l, boolean isWhite)
    {
      Node current = l.head;
      ChessPiece temp = new ChessPiece(0, 0, ' ');
      while(current != null)
      {
        if(isWhite)
        {
          if(current.val.color == 'k')
            temp = current.val;
        }
        else
        {
          if(current.val.color == 'K')
            temp = current.val;
        }
        current = current.next;
      }
      return temp;
    }
}
