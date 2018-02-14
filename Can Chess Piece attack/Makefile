ChessBoard: ChessBoard.class ChessPiece.class LinkedList.class Node.class King.class Queen.class Bishop.class Rook.class Knight.class
	echo Main-class: ChessBoard > Manifest
	jar cvfm ChessBoard.jar Manifest ChessBoard.class ChessPiece.class LinkedList.class Node.class  King.class Queen.class Bishop.class Rook.class Knight.class
	rm Manifest

ChessBoard.class: ChessBoard.java
	javac -Xlint ChessBoard.java

ChessPiece.class: ChessPiece.java
	javac -Xlint ChessPiece.java

LinkedList.class: LinkedList.java
	javac -Xlint LinkedList.java

Node.class: Node.java
	javac -Xlint Node.java

Queen.class: Queen.java
	javac -Xlint Queen.java

King.class: King.java
	javac -Xlint King.java

Bishop.class: Bishop.java
	javac -Xlint Bishop.java

Rook.class: Rook.java
	javac -Xlint Rook.java

Knight.class: Knight.java
	javac -Xlint Knight.java
clean:
	rm -f ChessBoard.jar ChessBoard.class ChessPiece.class LinkedList.class Node.class King.class Queen.class Bishop.class Rook.class Knight.class
