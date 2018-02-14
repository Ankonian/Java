class LinkedList
{
	Node head;
	public LinkedList()
	{
		head = null;
	}
	void insert(ChessPiece newNode)
	{
		Node latest = new Node(newNode);
		latest.next = head;
		head = latest;
	}
	void delete(ChessPiece n)
	{
			Node temp = head;
			Node prev = null;
			//if head node is to be deleted
			if(temp != null && temp.val == n)
			{
				head = temp.next;
				return;
			}
			while(temp != null && temp.val != n)
			{
				prev = temp;
				temp = temp.next;
			}
			if(temp == null)
				return;

			prev.next = temp.next;
	}
	ChessPiece find(ChessPiece n)
	{
		Node current = head;
		ChessPiece target = n;
		while(current != null)
		{
			if(current.val.col == n.col && current.val.row == n.row)
			{
				System.out.println("Linked List: "+current.val.col+" "+current.val.row);
				target = current.val;
			}
			current = current.next;
		}
		return target;
	}
	//debugging method that
	void traverse()
	{
		Node current = head;
		while(current != null)
		{
			System.out.println(current.val.color + ": " + current.val.col + " " + current.val.row);
			current = current.next;
		}
	}
	void replace(ChessPiece original, ChessPiece replacement)
	{
		Node current = head;
		while(current != null)
		{
			if(current.val.col == original.col && current.val.row == original.row && current.val.color == original.color)
			{
				//System.out.println("current: "+current.val.col+" "+current.val.row+" "+current.val.color);
				//System.out.println("replacement: "+replacement.col+" "+replacement.row+" "+replacement.color);
				current.val.col = replacement.col;
				current.val.row = replacement.row;
				break;
			}
			current = current.next;
		}
	}
}
