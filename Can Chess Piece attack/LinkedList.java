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
	ChessPiece find(ChessPiece n)
	{
//		boolean found = false;
		Node current = head;
		ChessPiece target = n;
		// ChessPiece target = new ChessPiece(0, 0, 'k');
		while(current != null)
		{
			if(current.val.col == n.col && current.val.row == n.row)
			{
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
			System.out.println(current.val.col + " " + current.val.row);
			current = current.next;
		}
	}
}
