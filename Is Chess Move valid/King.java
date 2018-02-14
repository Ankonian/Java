import java.lang.*;
class King extends ChessPiece
{
  int col;
  int row;
  char color;
  public King(int c, int r, char p)
  {
    super(c, r, p);
    this.col = c;
    this.row = r;
    this.color = p;
  }
  boolean isAttacking(ChessPiece c)
  {
    //check if there's a piece one away from col and row and diagonal
    boolean attack = false;
    if(((this.col == c.col + 1 && this.row == c.row) || (this.col == c.col - 1 && this.row == c.row) || (this.row == c.row + 1 && this.col == c.col) || (this.row == c.row - 1 && this.col == c.col) ||
    (this.row == c.row - 1 && this.col == c.col - 1) || (this.row == c.row - 1 && this.col == c.col + 1) || (this.row == c.row + 1 && this.col == c.col - 1) || (this.row == c.row + 1 && this.col == c.col + 1))
    && (this.color != c.color))
    attack = true;
    return attack;
  }

  boolean checkPath(LinkedList ll, ChessPiece n)
  {
    //pseudo code atm, dont know if it work lol
    //pseudo code atm, dont know if it work lol
    boolean clear = false;
    //if there's no chess piece at destination
      if(this.isAttacking(n))
      {

        //System.out.println("n: "+n.col+" "+n.row+" "+n.color);
        //System.out.println("this: "+this.col+" "+this.row+" "+this.color);
        if(n.col > this.col && n.row > this.row)
        {

          ChessPiece temp = new ChessPiece(this.col + 1, this.row + 1, ' ');
          temp = ll.find(temp);
          if(temp.color != ' ') //if there's a piece in the next spot this current piece is trying to move to
          {
            if(this.col + 1 == n.col && this.row + 1 == n.row)
            {
              if(Character.isLowerCase(n.color) != Character.isLowerCase(this.color))
              {
                //System.out.println("captured: ");
                this.col += 1;
                this.row += 1;
                ChessPiece temp2 = new ChessPiece(n.col, n.row, ' ');
                temp2 = ll.find(temp2);
                ll.replace(this, temp2);
                ll.delete(n);
                //System.out.println("deleted: ");
                clear = true;
              }
              else
              {
                //System.out.println("same color piece at destination");
              }
            }
            else
            {
              //System.out.println("not at destination");
            }
          }
          else
          {
            this.col++;
            this.row++;
            ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
            temp3 = ll.find(temp3);
            ll.replace(this, temp3);
          }
          if(this.col == n.col && this.row == n.row)
          {
            clear = true;
          }
          //System.out.println("col "+ this.col + " " + "row " + this.row);
        }
        else if(n.col < this.col && n.row > this.row)
        {

          ChessPiece temp = new ChessPiece(this.col - 1, this.row + 1, ' ');
          temp = ll.find(temp);
          if(temp.color != ' ') //if there's a piece in the next spot this current piece is trying to move to
          {
            if(this.col - 1 == n.col && this.row + 1 == n.row)
            {
              if(Character.isLowerCase(n.color) != Character.isLowerCase(this.color))
              {
                this.col--;
                this.row++;
                ChessPiece temp2 = new ChessPiece(n.col, n.row, ' ');
                temp2 = ll.find(temp2);
                ll.replace(this, temp2);
                ll.delete(n);
                //System.out.println("deleted: ");
                clear = true;
              }
              else
              {
                //System.out.println("same color piece at destination");
              }
            }
            else
            {
              //System.out.println("not at destination");
            }
          }
          else
          {
            this.col--;
            this.row++;
            ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
            temp3 = ll.find(temp3);
            ll.replace(this, temp3);
          }
          if(this.col == n.col && this.row == n.row)
          {
            clear = true;
          }
        }
        else if(n.col > this.col && n.row < this.row)
        {

          ChessPiece temp = new ChessPiece(this.col + 1, this.row - 1, ' ');
          temp = ll.find(temp);
          if(temp.color != ' ') //if there's a piece in the next spot this current piece is trying to move to
          {
            if(this.col + 1 == n.col && this.row - 1 == n.row)
            {
              if(Character.isLowerCase(n.color) != Character.isLowerCase(this.color))
              {
                this.col++;
                this.row--;
                ChessPiece temp2 = new ChessPiece(n.col, n.row, ' ');
                temp2 = ll.find(temp2);
                ll.replace(this, temp2);
                ll.delete(n);
                //System.out.println("deleted: ");
                clear = true;
              }
              else
              {
                //System.out.println("same color piece at destination");
              }
            }
            else
            {
              //System.out.println("not at destination");
            }
          }
          else
          {
            this.col++;
            this.row--;
            ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
            temp3 = ll.find(temp3);
            ll.replace(this, temp3);
          }
          if(this.col == n.col && this.row == n.row)
          {
            clear = true;
          }
        }
        else if(n.col < this.col && n.row < this.row)
        {
          System.out.println("n: "+n.col+" "+n.row);
          ChessPiece temp = new ChessPiece(this.col - 1, this.row - 1, ' ');
          temp = ll.find(temp);
          //System.out.println("temp: "+temp.col+" "+temp.row+" "+temp.color);
          if(temp.color != ' ') //if there's a piece in the next spot this current piece is trying to move to
          {
            //System.out.println("lol");
            if(this.col - 1 == n.col && this.row - 1 == n.row)
            {
              if(Character.isLowerCase(n.color) != Character.isLowerCase(this.color))
              {
                this.col--;
                this.row--;

                ChessPiece temp2 = new ChessPiece(n.col, n.row, ' ');
                temp2 = ll.find(temp2);
                ll.replace(this, temp2);
                ll.delete(n);
                //System.out.println("deleted: ");
                clear = true;
              }
              else
              {
                //System.out.println("same color piece at destination");
              }
            }
            else
            {
              //System.out.println("not at destination");
            }
          }
          else
          {
            this.col--;
            this.row--;
            ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
            temp3 = ll.find(temp3);
            ll.replace(this, temp3);
          }
          if(this.col == n.col && this.row == n.row)
          {
            clear = true;
          }
        }
        else if(n.col > this.col && n.row == this.row)
        {

          ChessPiece temp = new ChessPiece(this.col + 1, this.row, ' ');
          temp = ll.find(temp);
          if(temp.color != ' ') //if there's a piece in the next spot this current piece is trying to move to
          {
            if(this.col + 1 == n.col)
            {
              if(Character.isLowerCase(n.color) != Character.isLowerCase(this.color))
              {
                this.col++;
                ChessPiece temp2 = new ChessPiece(n.col, n.row, ' ');
                temp2 = ll.find(temp2);
                ll.replace(this, temp2);
                ll.delete(n);
                //System.out.println("deleted: ");
                clear = true;
              }
              else
              {
                //System.out.println("same color piece at destination");
              }
            }
            else
            {
              //System.out.println("not at destination");
            }
          }
          else
          {
            this.col++;
            ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
            temp3 = ll.find(temp3);
            ll.replace(this, temp3);
          }
          if(this.col == n.col && this.row == n.row)
          {
            clear = true;
          }
        }
        else if(n.col < this.col && n.row == this.row)
        {

          ChessPiece temp = new ChessPiece(this.col - 1, this.row, ' ');
          temp = ll.find(temp);
          if(temp.color != ' ') //if there's a piece in the next spot this current piece is trying to move to
          {
            if(this.col - 1 == n.col)
            {
              if(Character.isLowerCase(n.color) != Character.isLowerCase(this.color))
              {
                this.col--;
                ChessPiece temp2 = new ChessPiece(n.col, n.row, ' ');
                temp2 = ll.find(temp2);
                ll.replace(this, temp2);
                ll.delete(n);
                //System.out.println("deleted: ");
                clear = true;
              }
              else
              {
                //System.out.println("same color piece at destination");
              }
            }
            else
            {
              //System.out.println("not at destination");
            }
          }
          else
          {
            this.col--;
            ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
            temp3 = ll.find(temp3);
            ll.replace(this, temp3);
          }
          if(this.col == n.col && this.row == n.row)
          {
            clear = true;
          }
        }
        else if(n.col == this.col && n.row > this.row)
        {

          ChessPiece temp = new ChessPiece(this.col, this.row + 1, ' ');
          temp = ll.find(temp);
          if(temp.color != ' ') //if there's a piece in the next spot this current piece is trn.rowing to move to
          {
            if(this.row + 1 == n.row)
            {
              if(Character.isLowerCase(n.color) != Character.isLowerCase(this.color))
              {
                this.row++;
                ChessPiece temp2 = new ChessPiece(n.col, n.row, ' ');
                temp2 = ll.find(temp2);
                ll.replace(this, temp2);
                ll.delete(n);
                //System.out.println("deleted: ");
                clear = true;
              }
              else
              {
                //System.out.println("same color piece at destination");
              }
            }
            else
            {
              //System.out.println("not at destination");
            }
          }
          else
          {
            this.row++;
            ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
            temp3 = ll.find(temp3);
            ll.replace(this, temp3);
          }
          if(this.col == n.col && this.row == n.row)
          {
            clear = true;
          }
        }
        else if(n.col == this.col && n.row < this.row)
        {

          ChessPiece temp = new ChessPiece(this.col, this.row - 1, ' ');
          temp = ll.find(temp);
          //System.out.println("temp: col: "+ temp.col+" row: "+temp.row+" color: "+temp.color);
          if(temp.color != ' ') //if there's a piece in the next spot this current piece is trying to move to
          {
            if(this.row - 1 == n.row)
            {
              if(Character.isLowerCase(n.color) != Character.isLowerCase(this.color))
              {
                this.row--;
                ChessPiece temp2 = new ChessPiece(n.col, n.row, ' ');
                temp2 = ll.find(temp2);
                ll.replace(this, temp2);
                ll.delete(n);
                //System.out.println("deleted: ");
                clear = true;
              }
              else
              {
                //System.out.println("same color piece at destination");
              }
            }
            else
            {
              //System.out.println("not at destination");
            }
          }
          else
          {
            this.row--;
            ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
            temp3 = ll.find(temp3);
            ll.replace(this, temp3);
          }
          if(this.col == n.col && this.row == n.row)
          {
            clear = true;
          }
        }
      }
    return clear;
  }
}
