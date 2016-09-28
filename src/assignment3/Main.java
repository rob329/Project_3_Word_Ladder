/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * <Robert Bolt>
 * <rob329>
 * <Student1 5-digit Unique No.>
 * <Akhil Mujje>
 * <dam4335>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Git URL: 
 * Fall 2016
 */

package assignment3;

import java.util.*;
import java.io.*;
import java.util.ArrayList;  
import java.util.LinkedList;  
import java.util.Queue; 

public class Main {
<<<<<<< HEAD

=======
	public static final String[] alphabet = {"A","B","C","D","E","F", "G", "H", "I", "J", "K",
		"L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z" }; 
>>>>>>> master
	// static variables and constants only here.
	public static final String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
			"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
	public static final int word_length = 5;

	public static void main(String[] args) throws Exception {

		Scanner kb; // input Scanner for commands
		PrintStream ps; // output file
		// If arguments are specified, read/write from/to files instead of Std
		// IO.
		if (args.length != 0) {
			kb = new Scanner(new File(args[0]));
			ps = new PrintStream(new File(args[1]));
			System.setOut(ps); // redirect output to ps
		} else {
			kb = new Scanner(System.in);// default from Stdin
			ps = System.out; // default to Stdout
		}
		initialize();
<<<<<<< HEAD

=======
		getWordLadderBFS("START","END");
>>>>>>> master
		// TODO methods to read in words, output ladder

		getWordLadderBFS("stone", "sad");
	}

	public static void initialize() {
		// initialize your static variables or constants here.
		// We will call this method before running our JUNIT tests. So call it
		// only once at the start of main.

	}

	/**
	 * @param keyboard
	 *            Scanner connected to System.in
	 * @return ArrayList of 2 Strings containing start word and end word. If
	 *         command is /quit, return empty ArrayList.
	 */
	public static ArrayList<String> parse(Scanner keyboard) {
		// TO DO
		return null;
	}

	public static ArrayList<String> getWordLadderDFS(String start, String end) {

		// Returned list should be ordered start to end. Include start and end.
		// Return empty list if no ladder.
		// TODO some code
		Set<String> dict = makeDictionary();
		// TODO more code

		return null; // replace this line later with real return
	}
<<<<<<< HEAD

	public static ArrayList<String> getWordLadderBFS(String start, String end) {
		start = start.toUpperCase();
		// TODO some code
		Set<String> dict = makeDictionary();

		Node<String> startNode = new Node<String>(start);
		
		
		String check = "";
		for (int i = 0; i < word_length; i++)
			for (int j = 0; j < alphabet.length; j++) {
	//			if (start.charAt(i) != alphabet[j].charAt(0)){
					check = start.substring(0, i) + alphabet[j].charAt(0)+ start.substring(i+1);
					if(dict.contains(check)){
					 startNode.addChild(check, startNode);					 
					}
				
				

			}

		
		Node<String> childNode2 = new Node<String>("Child 2");
		childNode2.setParent(startNode);

		if (dict.contains("AGONY")) {
			System.out.println("agony");

=======
	
    public static ArrayList<String> getWordLadderBFS(String start, String end) { 	
    	Set<String> dict = makeDictionary();
    	Queue<Node> queue = new LinkedList<Node>();
    	Node startNode = new Node(start, null);
    	queue.add(startNode);
    	//while(!queue.isEmpty()){
    		for(int i=0 ; i < start.length() ;i++){
    			for(int j =0; j < alphabet.length ; j++){
    				String Add = start.substring(0,i) + alphabet[j] + start.substring(i+1, start.length());
    				Node newNode = new Node(Add, startNode);
    				if(dict.contains(Add) && !(queue.contains(newNode)) ){
    					System.out.println(Add);
      					queue.add(newNode);
    			}
    			
    		}
    	
    	}
    	//}
		// TODO some code
		
		if(dict.contains("ABAYA")){
			System.out.println("Yes");
>>>>>>> master
		}

		// TODO more code

		return null; // replace this line later with real return
	}
<<<<<<< HEAD

	public static Set<String> makeDictionary() {
=======
   
	public static Set<String>  makeDictionary () {
>>>>>>> master
		Set<String> words = new HashSet<String>();
		Scanner infile = null;
		try {
			infile = new Scanner(new File("five_letter_words.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary File not Found!");
			e.printStackTrace();
			System.exit(1);
		}
		while (infile.hasNext()) {
			words.add(infile.next().toUpperCase());
		}
		return words;
	}

	public static void printLadder(ArrayList<String> ladder) {

	}
	// TODO
	// Other private static methods here
}
