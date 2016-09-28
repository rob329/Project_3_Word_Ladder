package assignment3;

public class Node {
	String word = "";
	boolean marked; 
	Node parent;

 Node(String start, Node parent) {
	this.word = start;
	this.marked = false;
	this.parent = parent;
}


}
