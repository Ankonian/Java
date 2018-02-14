import java.util.*;
import java.io.*;
import java.lang.*;
class ChessBoard
{
  public static void main(String[] args) throws IOException
  {
    //a fool-proof(I hope) checker to see if the command matches the desired format
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

      //create a char array to store the input line
      char[] board = new char[line.length()];

      //storing all the char in a char array so I can convert to int easier
      for(int i = 0; i < line.length(); i++)
        board[i] = line.charAt(i);
      //store the first two numbers as a coordinate with an empty char
      int ecol = Character.getNumericValue(board[0]);
      int erow = Character.getNumericValue(board[1]);
      ChessPiece temp = new ChessPiece(ecol, erow, ' ');

      //store every three input as a ChessPiece and throw that ChessPiece into a new Node
       for(int j = 3; j < board.length; j += 3)
       {
         //if the letter detected is q or Q, store the coordinates and the letter in Queen class
         if(board[j] == 'q' || board[j] == 'Q')
         {
           int count = j;
           char piece = board[j];
           int col = Character.getNumericValue(board[++count]);
           int row = Character.getNumericValue(board[++count]);
           ChessPiece c = new Queen(col, row, piece);
           ll.insert(c);
         }
         //if the letter detected is k or K, store the coordinates and the letter in King class
         if(board[j] == 'k' || board[j] == 'K')
         {
           int count = j;
           char piece = board[j];
           int col = Character.getNumericValue(board[++count]);
           int row = Character.getNumericValue(board[++count]);
           ChessPiece c = new King(col, row, piece);
           ll.insert(c);
         }
         //if the letter detected is r or R, store the coordinates and the letter in Rook class
         if(board[j] == 'r' || board[j] == 'R')
         {
           int count = j;
           char piece = board[j];
           int col = Character.getNumericValue(board[++count]);
           int row = Character.getNumericValue(board[++count]);
           ChessPiece c = new Rook(col, row, piece);
           ll.insert(c);
         }
         //if the letter detected is n or N, store the coordinates and the letter in Knight class
         if(board[j] == 'n' || board[j] == 'N')
         {
           int count = j;
           char piece = board[j];
           int col = Character.getNumericValue(board[++count]);
           int row = Character.getNumericValue(board[++count]);
           ChessPiece c = new Knight(col, row, piece);
           ll.insert(c);
         }
         //if the letter detected is b or B, store the coordinates and the letter in Bishop class
         if(board[j] == 'b' || board[j] == 'B')
         {
           int count = j;
           char piece = board[j];
           int col = Character.getNumericValue(board[++count]);
           int row = Character.getNumericValue(board[++count]);
           ChessPiece c = new Bishop(col, row, piece);
           ll.insert(c);
         }
       }
       //if find() return a ChessPiece with char not empty, that means it found a piece at that position.
       //Store the found piece to attack to check if it will attack other pieces
       ChessPiece attack = ll.find(temp);
       Node current = ll.head;
       Node invalidTest = ll.head;
       //checker to check what color this piece is
       boolean isWhite = Character.isLowerCase(attack.s);
       //checker to check if there are two pieces in the linked list on the same coordinates
       boolean sameCoordinate = false;
       //a nested while loop to compare each piece with all other pieces to see if two pieces have the same coordinates
       while(invalidTest != null)
       {
         Node i = invalidTest.next;
         while(i != null)
         {
           //if there is two pieces with the same col and row, these two are in the same spot
           if(invalidTest.val.col == i.val.col && invalidTest.val.row == i.val.row)
           {
             sameCoordinate = true;
           }
           i = i.next;
         }
         invalidTest = invalidTest.next;
       }

        //if there are two pieces on the same coordinate, print Invalid
        if(sameCoordinate)
        {
          out.println("Invalid");
        }
        //if no two pieces on the same spot, print out the attacking letter first
        else
        {
          if(ll.find(temp).s != ' ')
          {
            out.print(attack.s + " ");
            boolean attacked = false;
            while(current != null)
            {
              boolean check = Character.isLowerCase(current.val.s);
              //if the two pieces are not the same color, i can check is the two pieces attacking
              if(check != isWhite)
              {
                //if pieces did attack, print y and set attacked to true
                if(attack.isAttacking(current.val))
                {
                  attacked = true;
                  out.println("y");
                }
              }
              current = current.next;
            }
            //if none of the pieces had been attacked, print n
            if(!attacked)
              out.println("n");
            }
          else
          {
            out.println("-");
          }
        }
      //if no piece found on the position, print -

    }
    //close input output files
    in.close();
    out.close();
  }
}
