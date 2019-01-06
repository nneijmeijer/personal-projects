package boardObj;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GroupingTest {

	Row test1;
	int[][] numbers = new int[][]{{ 1, 3, 2, 8, 9 },{ 1, 3, 2, 7, 8, 9 },	{ 1 },	{ 1, 3, 2 },	{ 3 },	{ 1, 3, 2, 4, 5,6, 8, 9 },	{ 1, 3, 2, 4, 5 }};

	
	@BeforeEach
	void setUp() throws Exception {
		

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testClearDuplicates() {
		test1 = new Row();
		Cell[] testCells = new Cell[7];
		Cell cell1 = new Cell(numbers[2]);
		Cell cell2 = new Cell(numbers[4]);
		test1.values.add(cell1);
		test1.values.add(cell2);
		for (int i = 0; i < 7; i++) {
			testCells[i] = new Cell(numbers[0]);
			test1.values.add(testCells[i]);
		}
		test1.clearDuplicates();
		//System.out.println(test1.toString());
		assertEquals(test1.toString(),
				"[1, ][3, ][2, 8, 9, ][2, 8, 9, ][2, 8, 9, ][2, 8, 9, ][2, 8, 9, ][2, 8, 9, ][2, 8, 9, ]");
	}

	@Test
	void testFindOccurances() {
		test1 = new Row();
		Cell[] testCells = new Cell[7];
		Cell cell1 = new Cell(numbers[5]);
		Cell cell2 = new Cell(numbers[6]);
		test1.values.add(cell1);
		test1.values.add(cell2);
		for (int i = 0; i < 7; i++) {
			testCells[i] = new Cell(numbers[i]);
			test1.values.add(testCells[i]);
		}
		test1.clearDuplicates();
		ArrayList<ArrayList<Integer>> result = test1.findOccurances();
		//System.out.println(result.toString());
		assertEquals(result.toString(),
				"[[4], [0, 1, 2, 3, 5, 7, 8], [6], [0, 1, 7, 8], [0, 1, 7, 8], [0, 7], [3], [0, 2, 3, 7], [0, 2, 3, 7]]");
	}

	@Test
	void testFindSets() {
		test1 = new Row();
		Cell[] testCells = new Cell[7];
		Cell cell1 = new Cell(numbers[0]);
		Cell cell2 = new Cell(numbers[5]);
		test1.values.add(cell1);
		test1.values.add(cell2);
		for (int i = 0; i < 7; i++) {
			testCells[i] = new Cell(numbers[i]);
			test1.values.add(testCells[i]);
		}
		test1.clearDuplicates();
		//System.out.println(test1.toString());
		test1.findSets();
		//System.out.println(test1.toString());
		assertEquals(test1.toString(),
				"[2, 8, 9, ][4, 5, 6, ][2, 8, 9, ][2, 7, 8, 9, ][1, ][2, ][3, ][4, 5, 6, ][4, 5, ]");
	}

	@Test
	void testFindSingles() {
		test1 = new Row();
		Cell[] testCells = new Cell[7];
		Cell cell1 = new Cell(numbers[0]);
		Cell cell2 = new Cell(numbers[5]);
		test1.values.add(cell1);
		test1.values.add(cell2);
		for (int i = 0; i < 7; i++) {
			testCells[i] = new Cell(numbers[i]);
			test1.values.add(testCells[i]);
		}
		test1.clearDuplicates();
		//System.out.println(test1.toString());
		test1.findSingles();
		//System.out.println(test1.toString());
		assertEquals(test1.toString(),
				"[2, 8, 9, ][2, 4, 5, 6, 8, 9, ][2, 8, 9, ][7, ][1, ][2, ][3, ][2, 4, 5, 6, 8, 9, ][2, 4, 5, ]");
	}

}
