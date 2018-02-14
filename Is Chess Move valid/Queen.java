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
    System.out.println("this: "+this.col+" "+this.row+" c: "+c.col+" "+c.row);
    if(this.col == c.col || this.row == c.row)
    {
      return true;
    }
    else if((Math.abs(this.col - c.col) == Math.abs(this.row - c.row)))
    {
      return true;
    }
    //if not matched all check cases, Queen is not attacking that specific piece.
    else
    {
      return false;
    }
  }
  boolean checkPathKing(LinkedList ll, ChessPiece k)
  {
    System.out.println("checkPathKing");
    boolean clear = false;
    int tempCol = 0;
    int tempRow = 0;
    System.out.println("King: Col: " + k.col + " Row: " + k.row);
    if(this.isAttacking(k))
    {
      System.out.println("isAttackingfasdfasdf");
      tempCol = this.col;
      tempRow = this.row;
      if(k.col > tempCol && k.row > tempRow)
      {
        System.out.println("clear is ++++");
        while(k.col != tempCol && k.row != tempRow)
        {
          ChessPiece dummy = new ChessPiece(tempCol + 1, tempRow + 1, ' ');
          dummy = ll.find(dummy);
          System.out.println("dummy: "+dummy.col+" "+dummy.row+" "+dummy.color);
          System.out.println("dummy.col != k.col: "+(dummy.col == k.col)+" dummy.row != k.row: "+(dummy.row == k.row));
          if(dummy.color != ' ' && dummy.col == k.col && dummy.row == k.row)
          {
            System.out.println("clear is ++++");
            clear = true;
            System.out.println("clear: "+clear);
            break;
          }
          else if(dummy.color != ' ' && dummy.col != k.col && dummy.row != k.row)
          {
           System.out.println("break\n");
            break;
          }
          else
          {
            tempCol++;
            tempRow++;
            System.out.println("Something");
          }
        }
      }
      else if(k.col < tempCol && k.row > tempRow)
      {
        System.out.println("queen");
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
            System.out.println("not at destination");
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
      else if(k.col > tempCol && k.row == tempRow)
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
    //pseudo code atm, dont know if it work lol
    boolean clear = false;
    System.out.println("checkPath this: wfasdfasfas "+this.col+" "+this.row);
    //if there's no chess piece at destination
    // if(n.color == ' ')
    // {
    //   System.out.println("lol");
    //   ll.traverse();
    //   if(this.isAttacking(n))
    //   {
    //     System.out.println("blah");
    //     ChessPiece temp = new ChessPiece(n.col, n.row, ' ');
    //     ll.replace(this, temp);
    //     ll.traverse();
    //     clear = true;
    //   }
    // }
    //if there is a chess piece at destination
    // else
    // {
      System.out.println("blah");
      if(this.isAttacking(n))
      {
        //System.out.println("nasdfsdfasdfadfaszafasdfwfegw45rgtgyaertgawefwegfergsfhaejkflwrfglkgrtuwaegiergwefrouy2egiu\n");
        if(n.col > this.col && n.row > this.row)
        {
          while(n.col != this.col && n.row != this.row)
          {
            ChessPiece temp = new ChessPiece(this.col + 1, this.row + 1, ' ');
            temp = ll.find(temp);
            if(temp.color != ' ') //if there's a piece in the next spot this current piece is trying to move to
            {
              //System.out.println("temp: "+temp.col+" "+temp.row+" "+temp.color);
              if(this.col + 1 == n.col && this.row + 1 == n.row)
              {
                //System.out.println("next spot is dest");
                if(Character.isLowerCase(n.color) != Character.isLowerCase(this.color))
                {
                  System.out.println("captured: ");
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
                  System.out.println("same color piece at destination");
                  break;
                }
              }
              else
              {
                System.out.println("not at destination");
                break;
              }
            }
            else
            {
              System.out.println("Something");
              this.col++;
              this.row++;
              ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
              temp3 = ll.find(temp3);
              ll.replace(this, temp3);
            }
          }
          //System.out.println("col "+ this.col + " " + "row " + this.row);
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
                  //System.out.println("deleted: ");
                  clear = true;
                }
                else
                {
                  System.out.println("same color piece at destination");
                  break;
                }
              }
              else
              {
                System.out.println("not at destination");
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
                  //System.out.println("deleted: ");
                  clear = true;
                }
                else
                {
                  System.out.println("same color piece at destination");
                  break;
                }
              }
              else
              {
                System.out.println("not at destination");
                break;
              }
            }
            else
            {
              //System.out.println("col up row down");
              this.col++;
              this.row--;
              ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
              temp3 = ll.find(temp3);
              ll.replace(this, temp3);
              ll.traverse();
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
            System.out.println("temp: "+temp.col+" "+temp.row+" "+temp.color);
            if(temp.color != ' ') //if there's a piece in the next spot this current piece is trying to move to
            {
              System.out.println("lower diag");
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
                  //System.out.println("deleted: ");
                  clear = true;
                }
                else
                {
                  System.out.println("same color piece at destination");
                  break;
                }
              }
              else
              {
                System.out.println("not at destination");
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
            ll.traverse();
            clear = true;
          }
        }
        else if(n.col > this.col && n.row == this.row)
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
                  System.out.println("before deleting: ");
                  ll.traverse();
                  this.col++;
                  ChessPiece temp2 = new ChessPiece(n.col, n.row, ' ');
                  temp2 = ll.find(temp2);
                  ll.replace(this, temp2);
  				        ll.delete(n);
                  System.out.println("deleted: ");
                  ll.traverse();
                  System.out.println("after deleteing: ");
                  ll.traverse();
                  clear = true;
                }
                else
                {
                  System.out.println("same color piece at destination");
                  break;
                }
              }
              else
              {
                System.out.println("not at destination");
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
                  //System.out.println("before deleting: ");
                  //ll.traverse();
                  this.col--;
                  ChessPiece temp2 = new ChessPiece(n.col, n.row, ' ');
                  temp2 = ll.find(temp2);
                  ll.replace(this, temp2);
  				        ll.delete(n);
                  System.out.println("deleted: ");
                  ll.traverse();
                  System.out.println("after deleteing: ");
                  ll.traverse();
                  clear = true;
                }
                else
                {
                  System.out.println("same color piece at destination");
                  break;
                }
              }
              else
              {
                System.out.println("not at destination");
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
                  System.out.println("deleted: ");
                  clear = true;
                }
                else
                {
                  System.out.println("same color piece at destination");
                  break;
                }
              }
              else
              {
                System.out.println("not at destination");
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
            //System.out.println("temp: col: "+ temp.col+" row: "+temp.row+" color: "+temp.color);
            if(temp.color != ' ') //if there's a piece in the next spot this current piece is trying to move to
            {
              if(this.row - 1 == n.row)
              {
                if(Character.isLowerCase(n.color) != Character.isLowerCase(this.color))
                {
                  ////System.out.println("before deleting: ");
                  //ll.traverse();
                  this.row--;
                  ChessPiece temp2 = new ChessPiece(n.col, n.row, ' ');
                  temp2 = ll.find(temp2);
                  ll.replace(this, temp2);
  				        ll.delete(n);
                  //System.out.println("deleted: ");
                  //ll.traverse();
                  //System.out.println("after deleteing: ");
                  //ll.traverse();
                  clear = true;
                }
                else
                {
                  System.out.println("same color piece at destination");
                  break;
                }
              }
              else
              {
                System.out.println("not at destination");
                break;
              }
            }
            else
            {
              //System.out.println("Not there yet");
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
    //}
    System.out.println("clear: "+clear);
    return clear;
  }
}
