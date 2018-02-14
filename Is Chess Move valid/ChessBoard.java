import java.util.*;
import java.io.*;
import java.lang.*;
class ChessBoard
{
  public static void main(String[] args) throws IOException
  {
    //a fool-proof(I hope) checker to see if the command matches the desired format
    //int moveCount = 1;
    if(args.length < 2)
    {
      System.out.println("Usage: java -jar ChessBoard.jar <input file> <output file>");
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
	//System.out.println(line);
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
        //    System.out.println("move col: "+ move.col + " move row: "+move.row+" move color: "+move.color);
            dest = ll.find(dest);
        //    System.out.println("dest col: "+ dest.col + " dest row: "+dest.row+" dest color: "+dest.color);
            //check color, check if this move is the first move
            if(moveCount == 1)
            {
              //if the first piece that move is a white piece, it's a legal move
              if(Character.isLowerCase(move.color))
              {
          //      System.out.println("move: "+move.color);
                isWhite = true;
                //if it passed checkPath() which will also move the piece
                boolean check = move.checkPath(ll, dest);
            //    System.out.println("checkPath: " + check);
                if(check)
                {
              //    System.out.println("After checkPath:");
              //    ll.traverse();
                  //check King
                //  System.out.println("made it");
                  ChessPiece king = findKing(ll, isWhite);
                  if(!checkMate(king, ll))
                  {
                    isPrevWhite = isWhite;
              //      System.out.println("isPrevWhite: "+isPrevWhite);
              //      System.out.println("isWhite: "+isWhite);
              //      ll.traverse();
                    moveCount++;
            //        System.out.println(moveCount);
                  }
                  else
                  {
				//	System.out.println("hi1");
					//ll.traverse();
                    out.println(previous.col + " " + previous.row + " " + dest.col + " " + dest.row + " " + "illegal");
        //            System.out.println();
                    legal = false;
                    break;
                  }
                }
                else
                {
				//  System.out.println("hi2");
				 // ll.traverse();
                  out.println(previous.col + " " + previous.row + " " + dest.col + " " + dest.row + " " + "illegal");
        //          System.out.println();
                  legal = false;
                  break;
                }
              }
              else
              {
			//	System.out.println("hi3");
				//ll.traverse();
                out.println(move.col + " " + move.row + " " + dest.col + " " + dest.row + " " + "illegal");
        //        System.out.println();
                legal = false;
                break;
              }
        //      System.out.println("moveCount: "+moveCount);
        //      System.out.println("isPrevWhite: "+ isPrevWhite);
        //      System.out.println("isWhite: " + isWhite);
            }
            else if(moveCount > 1)
            {
              //if it's not the first piece check if the current piece color different from last piece that moved
              isWhite = Character.isLowerCase(move.color);
        //      System.out.println("isPrevWhite: "+ isPrevWhite);
        //      System.out.println("isWhite: " + isWhite);
        //      System.out.println(move.color);
      //        System.out.println("i: "+i);
        //      System.out.println("made it to else");
              if(isPrevWhite != isWhite)
              {
                // boolean checkPath2 = move.checkPath(ll, dest);
                // System.out.println("made to second move");
                // System.out.println("checkPath2: " + checkPath2);
                if(move.checkPath(ll, dest))
                {
                  //check king
                //  System.out.println("check");
                //ll.traversse();
                  ChessPiece king = findKing(ll, isWhite);
        //          System.out.println("King color: "+king.color);
                  boolean checkM = checkMate(king, ll);
        //          System.out.println("checkMate: "+checkM);
                  if(!checkM)
                  {
                    isPrevWhite = isWhite;
                 //   ll.traverse();
                    moveCount++;
                  }
                  else
                  {
				//	System.out.println("hi1");
				//	ll.traverse();
                    out.println(previous.col + " " + previous.row + " " + dest.col + " " + dest.row + " " + "illegal");
          //          System.out.println();
                    legal = false;
                    break;
                  }
                }
                else
                {
				//  System.out.println("hi2");
				//  ll.traverse();
                  out.println(previous.col + " " + previous.row + " " + dest.col + " " + dest.row + " " + "illegal");
                  //System.out.println();
                  legal = false;
                  break;
                }
              }
              else
              {
			//	System.out.println("hi3");
				//ll.traverse();
                out.println(move.col + " " + move.row + " " + dest.col + " " + dest.row + " " + "illegal");
        //        System.out.println();
                legal = false;
                break;
              }
            }
          }
          else
          {
		//	System.out.println("hi4");
			//ll.traverse();
            out.println(move.col + " " + move.row + " " + dest.col + " " + dest.row + " " + "illegal");
      //      System.out.println();
            legal = false;
            break;
          }
        //  System.out.println("moveCount: "+moveCount);
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
      //  System.out.println("Current color: "+current.val.color);
      //  System.out.println("k color: "+k.color);
        if((Character.isLowerCase(current.val.color) != Character.isLowerCase(k.color)) && current.val.checkPathKing(l, k))
        {
          check = true;
      //    System.out.println("check: "+check);
        }
        current = current.next;
      }
      //System.out.println(check + " check?");
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
