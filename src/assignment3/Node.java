package assignment3;

import java.util.ArrayList;

public class Node<String> {

	//private ArrayList<Node<String>> children = new ArrayList<Node<String>>();
	private Node<String> parent = null;
	private String word = null;
	
	public Node(String word){
		this.word = word;
	}

	public Node(String word, Node<String> parent){
		this.word = word;
		this.parent = parent;
	}
	
	
	//public ArrayList<Node<String>> getChildren(){
	//	return children;
	//}
	
	public Node<String> getParent(){
		return this.parent;
	}
	public void setParent(Node<String> parent){		
		this.parent = parent;
	}
	
	//public void addChild(String word){
	//	Node<String> child = new Node<String>(word);
	//	child.setParent(this);
	//	this.children.add(child);
	//}
	
	//public void addChild(Node<String> child) {
        //child.setParent(this);
      //  this.children.add(child);
    //}
	
	public String getWord(){
		return this.word;
	}
	
	public void setWord(String word){
		this.word = word;
	}
	
	
	
	
	
	
}
