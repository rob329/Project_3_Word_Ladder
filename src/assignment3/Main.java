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

import java.util.*;
import java.io.*;

public class Main {

	// static variables and constants only here.
	public static ArrayList<String> going;
	public static ArrayList<String> dfs_ladder;
	public static ArrayList<String> dfs_searched;
	public static final String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
			"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
	public static final int word_length = 5;
	public static int dfs_length_pointer = 0;
	public static int dfs_alphabet_pointer = -1;
	public static int dfs_count = 0;

	/**
	 * @author Akhil Mujje and Robert Bolt
	 *  Sets up Word Ladder program Takes
	 * commands from users and returns a word ladder produced by
	 * Breadth-First Search or terminates program.
	 */
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
		going = parse(kb); // takes in user commands

		 printLadder(getWordLadderDFS("found", "stomp"));
		//printLadder(getWordLadderBFS(going.get(0), going.get(1))); //prints BFS ladder based on inputs from user
	}

	/**
	 * Creates initial static variable or constants for Word Ladder program
	 */
	public static void initialize() {
		//initializes some static variables
		going = new ArrayList<String>();
		dfs_ladder = new ArrayList<String>();
		dfs_searched = new ArrayList<String>();
	}

	/**
	 * Checks for user commands and responds appropriately
	 * @param keyboard  Scanner connected to System.in
	 * @return ArrayList of 2 Strings containing start word and end word. If
	 *         command is /quit, return empty ArrayList.
	 */
	public static ArrayList<String> parse(Scanner keyboard) {

		String word = keyboard.next();
		if (word.equals("/quit")) { //if user enters "/quit", terminate program
			System.exit(0);
		}
		String word2 = keyboard.next();
		if (word2.equals("/quit")) {
			System.exit(0);
		}
		ArrayList<String> inputs = new ArrayList<String>();
		inputs.add(word);
		inputs.add(word2);
		return inputs;
	}
	/**
	 * Gets a word ladder by using DFS
	 * @param start start word
	 * @param end end word
	 * @return the arraylist of the word ladder produced by DFS
	 */
	public static ArrayList<String> getWordLadderDFS(String start, String end) {

		Set<String> dict = makeDictionary();
		start = start.toUpperCase(); //make start and end uppercase since words in dict are uppercase
		end = end.toUpperCase();

		if (dict.contains(start) && (!(dfs_searched.contains(start)))) { //if a word is in the dictionary and is NOT already included,
			dfs_ladder.add(start);
			dfs_count++;															//add it to word ladder
			
		}

		dfs_searched.add(start); //add this new start to searched array

		//pointer incrementals for traversing alphabet array and the the position of the word
		dfs_alphabet_pointer++;
		if (dfs_alphabet_pointer == alphabet.length) {
			dfs_length_pointer++;
			dfs_alphabet_pointer = 0;
		}
		if (dfs_length_pointer == word_length) {
			dfs_length_pointer = 0;
			dfs_alphabet_pointer = 0;
			dfs_count--;

		}
		//returns empty ladder if start != word and no words cannot be found
		if (dfs_count == 0) {
			dfs_ladder.clear();
			return dfs_ladder;
		}
		//if start == word, return word ladder containing words
		if (start.equals(end)) {
			dfs_ladder.add(start);
			return dfs_ladder;
		}
		//else, call method recursively in DFS manner
		return getWordLadderDFS(dfs_ladder.get(dfs_count - 1).substring(0, dfs_length_pointer)
				+ alphabet[dfs_alphabet_pointer].charAt(0)
				+ dfs_ladder.get(dfs_count - 1).substring(dfs_length_pointer + 1), end);
	}

	/**
	 * Gets a word ladder by using BFS
	 * @param start start word
	 * @param end end word
	 * @return the arraylist of word ladder produced by BFS
	 */
	public static ArrayList<String> getWordLadderBFS(String start, String end) {
		//make start and end uppercase to match with words in dict
		start = start.toUpperCase();
		end = end.toUpperCase();
		
		//create local variables
		Node<String> parent = new Node<String>(start, null);
		Set<String> dict = makeDictionary();
		ArrayList<String> ladder = new ArrayList<String>();
		ArrayList<Node<String>> queue = new ArrayList<Node<String>>();

		String check = "";
		boolean finish = false;

		//double for loop to traverse across the letters of the alphabet for each position of word based on its length
		for (int i = 0; i < word_length; i++)
			for (int j = 0; j < alphabet.length; j++) {

				check = start.substring(0, i) + alphabet[j].charAt(0) + start.substring(i + 1);
				if (check.equals(end)) {
					finish = true;
					ladder.add(start);
					ladder.add(end);
					return ladder;
				}

				if (dict.contains(check) && (!(check.equals(start)))) {
					dict.remove(check);
					Node<String> addition = new Node<String>(check, parent);
					queue.add(addition);
				}
			}

		while (!finish) {

			for (int k = 0; k < queue.size(); k++) {

				for (int i = 0; i < word_length; i++)
					for (int j = 0; j < alphabet.length; j++) {
						Node<String> nd = queue.get(k);
						check = (nd.getWord()).substring(0, i) + alphabet[j].charAt(0)
								+ (nd.getWord()).substring(i + 1);
						if (check.equals(end)) {
							finish = true;
							k = queue.size() + 1;
							i = word_length + 1;
							j = alphabet.length + 1;

						}

						if (dict.contains(check) && (!(check.equals(nd.getWord())))) {
							dict.remove(check);
							Node<String> addition = new Node<String>(check, nd);
							queue.add(addition);
						}
					}

			}
			if (queue.size() == 0) {
				ladder.clear();
				return ladder;
			}
			if (!(queue.get(queue.size() - 1).getWord().equals(end))) {
				ladder.clear();
				return ladder;
			}

			Node<String> end_node = queue.get(queue.size() - 1).getParent();
			ladder.add(end);
			while (!(start.equals(end_node.getWord()))) {
				ladder.add(end_node.getWord());
				end_node = end_node.getParent();
			}
			ladder.add(start);
			ArrayList<String> done = new ArrayList<String>();
			int length = ladder.size();
			int L = 0;
			int F = length - 1;
			while (L < length) {
				done.add(ladder.get(F));
				L++;
				F--;
			}
			return done;
		}
		return ladder;

	}

	/**
	 * Makes dictionary in a Set<String>
	 * @return the dictionary
	 */
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

	/**
	 * Prints the given ladder in appropriate format
	 * @param ladder word ladder that is going to be printed
	 */
	public static void printLadder(ArrayList<String> ladder) {
		if (ladder.size() == 0) {
			System.out.println("no word ladder could not be found between " + going.get(0) + " and " + going.get(1));
		} else if (ladder.size() == 2) {
			String first = ladder.get(0).toLowerCase();
			String last = ladder.get((ladder.size() - 1)).toLowerCase();
			System.out.println("A " + 0 + "-rung word ladder exists between " + first + " and " + last + ".\n" + first
					+ "\n" + last);
			return;
		} else {
			String first = ladder.get(0).toLowerCase();
			String last = ladder.get((ladder.size() - 1)).toLowerCase();
			System.out.println(
					"A " + (ladder.size() - 2) + "-rung word ladder exists between " + first + " and " + last + ".");
			for (int i = 0; i < ladder.size(); i++) {
				System.out.println(ladder.get(i).toLowerCase());
			}
		}
	}

}
