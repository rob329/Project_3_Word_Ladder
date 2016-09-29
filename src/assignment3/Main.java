package assignment3;

import java.util.*;


import java.io.*;


public class Main {


	public static ArrayList<String> going;

	

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
			
			going = parse(kb);
			ArrayList<String> fun = new ArrayList();
			fun = getWordLadderBFS(going.get(0), going.get(1));
			printLadder(fun);
			
		}

		

		// TODO methods to read in words, output ladder



	public static void initialize() {
		going = new ArrayList<String>();
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
		String word = keyboard.next();
		if (word.equals("/quit")){System.exit(0);}
		String word2 = keyboard.next();
		if (word2.equals("/quit")){System.exit(0);}
		ArrayList<String> inputs = new ArrayList<String>();
		inputs.add(word);
		inputs.add(word2);
		return inputs;
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
		ArrayList<String> ladder = new ArrayList<String>();
		ArrayList<Node> queue = new ArrayList<Node>();

		String check = "";
		String head = start;

		boolean finish = false;
		int q = 0;
		int counter = 0;

		for (int i = 0; i < word_length; i++){
			for (int j = 0; j < alphabet.length; j++) {

				check = head.substring(0, i) + alphabet[j].charAt(0) + head.substring(i + 1);
				if (check.equals(end)){
					finish = true;
					ladder.add(start);
					ladder.add(end);
					return ladder;
					}
				if (dict.contains(check) && (!(check.equals(start)))) {
					dict.remove(check);
					Node addition = new Node(check, parent);
					queue.add(addition);
					// System.out.println(check);

				}
			}
	}
		while (!finish) {

			for (int k = 0; k < queue.size(); k++) {

				for (int i = 0; i < word_length; i++)
					for (int j = 0; j < alphabet.length; j++) {
						Node nd = queue.get(k);
						check = ((String) nd.getWord()).substring(0, i) + alphabet[j].charAt(0)
								+ ((String) nd.getWord()).substring(i + 1);
						if (check.equals(end)) {
							finish = true;
							k = queue.size() + 1;
							i = word_length + 1;
							j = alphabet.length + 1;
							// System.out.println(check);

						}

						if (dict.contains(check) && (!(check.equals((String) nd.getWord())))) {
							dict.remove(check);
							Node addition = new Node(check, nd);
							queue.add(addition);
							// System.out.println(check);

						}
					}

			}
			if (queue.size() == 0) {
				return null;
			}
			if (!(queue.get(queue.size() - 1).getWord().equals(end))) {
				return null;
			}

		


			Node end_node = queue.get(queue.size() - 1).getParent();
			ladder.add(end);
			while (!(start.equals(end_node.getWord()))) {
				ladder.add((String) end_node.getWord());
				// System.out.println(end_node.getWord());
				end_node = end_node.getParent();
			}
			ladder.add(start);
			ArrayList<String> done = new ArrayList<String>();
			int length = ladder.size();
			int L = 0;
			int F = length - 1;
			while(L < length){
				done.add(ladder.get(F));
				L++;
				F--;
			}
			return done;

		}
		
		return ladder;

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
			if (ladder == null){
				System.out.println("no word ladder could not be found between " + going.get(0) + " and " + going.get(1));
			}
			else if(ladder.size() == 2){
				String first = ladder.get(0).toLowerCase();
				String last = ladder.get((ladder.size() - 1)).toLowerCase();
				System.out.println("A "+ 0 +"-rung word ladder exists between " + first + " and " + last + ".\n" + first + "\n" + last );
				return;
			}
			else{
			String first = ladder.get(0).toLowerCase();
			String last = ladder.get((ladder.size() - 1)).toLowerCase();
			System.out.println("A "+ (ladder.size() - 2) +"-rung word ladder exists between " + first + " and " + last + "." );
			for (int i = 0; i < ladder.size(); i++) {
				System.out.println(ladder.get(i).toLowerCase());
			}
			}
		}
		// TODO
		// Other private static methods here

	}
