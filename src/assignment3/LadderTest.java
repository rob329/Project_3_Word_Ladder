package assignment3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

public class LadderTest {

	@Test
	public void test() {
		Main test = new Main();
		ArrayList<String> result = test.getWordLadderBFS("smart" , "money");
		assertEquals(result.size() , 11);
	}
	@Test
	public void testBFS1() {
		ArrayList<String> res = Main.getWordLadderBFS("hello", "cells");
		Main.printLadder(res);
		assertFalse(res == null || res.size() == 0);
		assertTrue(res.size() < 4);
		}
	
	@Test
	public void testnull() {
		ArrayList<String> res = Main.getWordLadderBFS("aloof", "cells");
		assertEquals(res , null);
		}
	
	@Test
	public void testNeighbor() {
		ArrayList<String> res = Main.getWordLadderBFS("start", "smart");
		Main.printLadder(res);
		assertFalse(res == null || res.size() == 0);
		assertTrue(res.size() < 3);
		}
}
