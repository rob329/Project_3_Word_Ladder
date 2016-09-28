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

public class Main {

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

		// TODO methods to read in words, output ladder

		getWordLadderBFS("stone", "money");
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

	public static ArrayList<String> getWordLadderBFS(String start, String end) {

		// TODO some code
		start = start.toUpperCase();
		end = end.toUpperCase();
		Node parent = new Node(start, null);
		Set<String> dict = makeDictionary();

		// Node<String> startNode = new Node<String>(start);
		ArrayList<String> rp = new ArrayList<String>();
		ArrayList<Node> queue = new ArrayList<Node>();

		String check = "";
		String head = start;

		boolean finish = false;
		int q = 0;
		int counter = 0;

		for (int i = 0; i < word_length; i++)
			for (int j = 0; j < alphabet.length; j++) {

				check = head.substring(0, i) + alphabet[j].charAt(0) + head.substring(i + 1);
				if (check.equals(end))
					finish = true;
				if (dict.contains(check) && (!(check.equals(start)))) {
					dict.remove(check);
					Node addition = new Node(check, parent);
					queue.add(addition);
					//System.out.println(check);
					
				}
			}
		
		while (!finish) {

			
			for(int k = 0;k<queue.size();k++){
				for (int i = 0; i < word_length; i++)
					for (int j = 0; j < alphabet.length; j++) {
						Node nd = queue.get(k);
						check = ((String)nd.getWord()).substring(0, i) + alphabet[j].charAt(0) + 
								((String)nd.getWord()).substring(i + 1);
						if (check.equals(end))
							finish = true;
						
						if (dict.contains(check) && (!(check.equals((String)nd.getWord())))) {
							dict.remove(check);
							Node addition = new Node(check, nd);
							queue.add(addition);
							System.out.println(check);
							
						}
					}
				
			}
			

			

			/*
			 * while(q > 0){
			 * 
			 * head = startNode.getChildren().get(counter).getWord(); q--;
			 * counter++; h = h.getChildren().get(counter); break;
			 * 
			 * }
			 */

			// Node<String> childNode2 = new Node<String>("Child 2");
			// childNode2.setParent(startNode);

		}

		return rp;

		// TODO more code

		// replace this line later with real return
	}

	public static Set<String> makeDictionary() {
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
