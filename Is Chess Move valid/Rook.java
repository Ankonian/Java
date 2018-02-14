import java.lang.*;
class Rook extends ChessPiece
{
  int col;
  int row;
  char s;
  public Rook(int c, int r, char p)
  {
    super(c, r, p);
    this.col = c;
    this.row = r;
    this.s = p;
  }
  boolean isAttacking(ChessPiece c)
  {
    if((this.col == c.col || this.row == c.row))
    return true;
    else
    return false;
  }
  boolean checkPathKing(LinkedList ll, ChessPiece k)
  {
    boolean clear = false; // clear is true if have clear path to attack king
    int tempCol = 0;
    int tempRow = 0;
    if(this.isAttacking(k))
    {
      tempCol = this.col;
      tempRow = this.row;
      if(k.col > tempCol && k.row == tempRow)
      {
        while(k.col != tempCol)
        {
          ChessPiece dummy = new ChessPiece(tempCol + 1, tempRow, ' ');
          dummy = ll.find(dummy);
          if(dummy.color != ' ' && k.col == dummy.col)
          {
            clear = true;
            break;
          }
          else if(dummy.color != ' ' && k.col != dummy.col)
          {
            break;
          }
          else
          {
            tempCol++;
          }
        }
      }
      else if(k.col < tempCol && k.row == tempRow)
      {
        while(k.col != tempCol)
        {
          ChessPiece dummy = new ChessPiece(tempCol - 1, tempRow, ' ');
          dummy = ll.find(dummy);
          if(dummy.color != ' ' && k.col == dummy.col)
          {
            clear = true;
            break;
          }
          else if(dummy.color != ' ' && k.col != dummy.col)
          {
            break;
          }
          else
          {
            tempCol--;
          }
        }
      }
      else if(k.col == tempCol && k.row > tempRow)
      {
        while(k.row != tempRow)
        {
          ChessPiece dummy = new ChessPiece(tempCol, tempRow + 1, ' ');
          dummy = ll.find(dummy);
          if(dummy.color != ' ' && k.row == dummy.row)
          {
            clear = true;
            break;
          }
          else if(dummy.color != ' ' && k.row != dummy.row)
          {
            break;
          }
          else
          {
            tempRow++;
          }
        }
      }
      else if(k.col == tempCol && k.row < tempRow)
      {
        while(k.row != tempRow)
        {
          ChessPiece dummy = new ChessPiece(tempCol, tempRow - 1, ' ');
          dummy = ll.find(dummy);
          if(dummy.color != ' ' && k.row == dummy.row)
          {
            clear = true;
            break;
          }
          else if(dummy.color != ' ' && k.row != dummy.row)
          {
            break;
          }
          else
          {
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
      if(n.col > this.col && n.row == this.row)
      {
        while(n.col != this.col)
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
      else if(n.col < this.col && n.row == this.row)
      {
        while(n.col != this.col)
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
      else if(n.col == this.col && n.row > this.row)
      {
        while(n.row != this.row)
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
      else if(n.col == this.col && n.row < this.row)
      {
        while(n.row != this.row)
        {
          ChessPiece temp = new ChessPiece(this.col, this.row - 1, ' ');
          temp = ll.find(temp);
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
