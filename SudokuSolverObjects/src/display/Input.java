package display;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import boardObj.Board;
import boardObj.Cell;

public class Input {

	/**
	 * Takes a file name, parses the contents of that file, constructs a board using those contents, 
	 * and then loops through the file until nothing was changed in a loop.
	 * Currently breaks if the file is not 9x9 csv file with 0 representing empty cells.   
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a file name: ");
		System.out.flush();
		String filename = scanner.nextLine();
		File file = new File(filename);
		BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\" + file));

		String st;
		int[][] numbers = new int[9][9];
		int row = 0;
		while ((st = br.readLine()) != null && row < numbers.length) {
			numbers[row] = parseLineToIntArray(st);
			row++;
			System.out.println(st);
		}
		Board board = new Board(numbers);
		ArrayList<Cell> previous = new ArrayList<Cell>();
		boolean changed = true;
		while (changed) {
			previous.clear();
			for (Iterator<Cell> i = board.cells.iterator(); i.hasNext();) {
				previous.add(new Cell(i.next()));
			}
			while (changed) {
				previous.clear();
				for (Iterator<Cell> i = board.cells.iterator(); i.hasNext();) {
					previous.add(new Cell(i.next()));
				}
				board.filterValues();
				board.filterSingles();
				System.out.println(board.toString());
				if (board.cells.equals(previous)) {
					changed = false;
				}
			}
			changed = true;
			board.findPatterns();
			System.out.println(board.toString());
			if (board.cells.equals(previous)) {
				changed = false;
			}
		}
		System.out.println(board.toString());
		System.out.println();

	}

	/**
	 * Taken from stack overflow
	 * used to parse csv file
	 * @param arr
	 * @return
	 */
	static int[] toIntArray(String[] arr) {
		int[] ints = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (!arr[i].equals("")) {
				ints[i] = Integer.parseInt(arr[i]);
			}
		}
		return ints;
	}

	/**
	 * Taken from stack overflow
	 * used to parse csv file
	 * @param arr
	 * @return
	 */
	static int[] parseLineToIntArray(String line) {
		return toIntArray(line.split(","));
	}
}
