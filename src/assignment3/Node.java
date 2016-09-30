/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * <Robert Bolt>
 * <rob329>
 * <16465>
 * <Devisriram Akhil Mujje>
 * <dam4335>
 * <16470>
 * Slip days used: <0>
 * Git URL: https://github.com/rob329/Project_3_Word_Ladder.git
 * Fall 2016
 */
package assignment3;

public class Node<String> {

	private Node<String> parent = null;
	private String word = null;

	/**
	 * Node(String word) Creates a Node object and assigns the given word
	 * 
	 * @param word
	 *            word that Node holds for Word Ladder
	 */
	public Node(String word) {
		this.word = word;
	}

	/**
	 * Node(String word, Node<String> parent)
	 * Creates a Node object and assigns
	 * the given word and parent to it
	 * 
	 * @param word
	 *            word that Node holds for Word Ladder
	 * @param parent
	 *            parent of the newly created Node
	 */
	public Node(String word, Node<String> parent) {
		this.word = word;
		this.parent = parent;
	}

	/**
	 * getParent()
	 * Returns the parent of this node
	 * @return parent of this node
	 */
	public Node<String> getParent() {
		return this.parent;
	}

	/**
	 * setParent(Node<String> parent)
	 * Sets the parent of this child Node	 * 
	 * @param parent parent of this Node
	 */
	public void setParent(Node<String> parent) {
		this.parent = parent;
	}

	/**
	 * getWord()
	 * Returns the word that this Node holds
	 * @return the word that this Node holds
	 */
	public String getWord() {
		return this.word;
	}

	/**
	 * setWord(String word)
	 * Sets the word for this Node
	 * @param word value that Node will hold
	 */
	public void setWord(String word) {
		this.word = word;
	}

}
