import java.lang.*;
class Bishop extends ChessPiece
{
  int col;
  int row;
  char color;
  Bishop(int c, int r, char p)
  {
    super(c, r, p);
    this.col = c;
    this.row = r;
    this.color = p;
  }
  boolean isAttacking(ChessPiece c)
  {
    //System.out.println("c: " + c.col + " " + c.row);
    //System.out.println("this: " + this.col + " " + this.row);
    if(Math.abs(this.col - c.col) == Math.abs(this.row - c.row))
    return true;
    else
    return false;
  }
  boolean checkPathKing(LinkedList ll, ChessPiece k)
  {
    boolean clear = false;
    int tempCol = 0;
    int tempRow = 0;
    if(this.isAttacking(k))
    {
      System.out.println("bishop top left");
      tempCol = this.col;
      tempRow = this.row;
      if(k.col > tempCol && k.row > tempRow)
      {
        while(k.col != tempCol && k.row != tempRow)
        {
          ChessPiece dummy = new ChessPiece(tempCol + 1, tempRow + 1, ' ');
          dummy = ll.find(dummy);
          if(dummy.color != ' ' && dummy.col == k.col && dummy.row == k.row)
          {
            clear = true;
            break;
          }
          else if(dummy.color != ' ' && dummy.col != k.col && dummy.row != k.row)
          {
            break;
          }
          else
          {
            tempCol++;
            tempRow++;
          }
        }
      }
      else if(k.col < tempCol && k.row > tempRow)
      {

        while(k.col != tempCol && k.row != tempRow)
        {
          ChessPiece dummy = new ChessPiece(tempCol - 1, tempRow + 1, ' ');
          dummy = ll.find(dummy);
          if(dummy.color != ' ' && dummy.col == k.col && dummy.row == k.row)
          {
            clear = true;
            break;
          }
          else if(dummy.color != ' ' && dummy.col != k.col && dummy.row != k.row)
          {
            break;
          }
          else
          {
            tempCol--;
            tempRow++;
          }
        }
      }
      else if(k.col > tempCol && k.row < tempRow)
      {
        while(k.col != tempCol && k.row != tempRow)
        {
          ChessPiece dummy = new ChessPiece(tempCol + 1, tempRow - 1, ' ');
          dummy = ll.find(dummy);
          if(dummy.color != ' ' && dummy.col == k.col && dummy.row == k.row)
          {
            clear = true;
            break;
          }
          else if(dummy.color != ' ' && dummy.col != k.col && dummy.row != k.row)
          {
            break;
          }
          else
          {
            tempCol++;
            tempRow--;
          }
        }
      }
      else if(k.col < tempCol && k.row < tempRow)
      {

        while(k.col != tempCol && k.row != tempRow)
        {

          ChessPiece dummy = new ChessPiece(tempCol - 1, tempRow - 1, ' ');
          dummy = ll.find(dummy);
          if(dummy.color != ' ' && dummy.col == k.col && dummy.row == k.row)
          {
            System.out.println("bishop");
            clear = true;
            break;
          }
          else if(dummy.color != ' ' && dummy.col != k.col && dummy.row != k.row)
          {
            break;
          }
          else
          {
            tempCol--;
            tempRow--;
          }
        }
      }
    }
    else
    {
      clear = false;
    }
    return clear;
  }
  boolean checkPath(LinkedList ll, ChessPiece n)
  {
    boolean clear = false;
    if(this.isAttacking(n))
    {
      if(n.col > this.col && n.row > this.row)
      {
        while(n.col != this.col && n.row != this.row)
        {
          ChessPiece temp = new ChessPiece(this.col + 1, this.row + 1, ' ');
          temp = ll.find(temp);
          if(temp.color != ' ') //if there's a piece in the next spot this current piece is trying to move to
          {
            if(this.col + 1 == n.col && this.row + 1 == n.row)
            {
              if(Character.isLowerCase(n.color) != Character.isLowerCase(this.color))
              {
                this.col += 1;
                this.row += 1;
                ChessPiece temp2 = new ChessPiece(n.col, n.row, ' ');
                temp2 = ll.find(temp2);
                ll.replace(this, temp2);
                ll.delete(n);
                clear = true;
              }
              else
              {
                break;
              }
            }
            else
            {
              break;
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
        }
        if(this.col == n.col && this.row == n.row)
        {
          clear = true;
        }
      }
      else if(n.col < this.col && n.row > this.row)
      {
        while(n.col != this.col && n.row != this.row)
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
                ChessPiece temp2 = new ChessPiece(this.col, this.row, ' ');
                temp2 = ll.find(temp2);
                ll.replace(this, temp2);
                ll.delete(n);
                clear = true;
              }
              else
              {
                break;
              }
            }
            else
            {
              break;
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
        }
        if(this.col == n.col && this.row == n.row)
        {
          clear = true;
        }
      }
      else if(n.col > this.col && n.row < this.row)
      {

        while(n.col != this.col && n.row != this.row)
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
                clear = true;
              }
              else
              {
                break;
              }
            }
            else
            {
              break;
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
        }
        if(this.col == n.col && this.row == n.row)
        {
          clear = true;
        }
      }
      else if(n.col < this.col && n.row < this.row)
      {
        while(n.col != this.col && n.row != this.row)
        {
          ChessPiece temp = new ChessPiece(this.col - 1, this.row - 1, ' ');
          temp = ll.find(temp);
          if(temp.color != ' ') //if there's a piece in the next spot this current piece is trying to move to
          {
            if(this.col - 1 == n.col && this.row - 1 == n.row)
            {
              if(Character.isLowerCase(n.color) != Character.isLowerCase(this.color))
              {
                n.col--;
                n.row--;
                ChessPiece temp2 = new ChessPiece(n.col, n.row, ' ');
                temp2 = ll.find(temp2);
                ll.replace(this, temp2);
                ll.delete(n);
                clear = true;
              }
              else
              {
                break;
              }
            }
            else
            {
              break;
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
