package boardObj;

import java.util.ArrayList;
import java.util.Iterator;

public class Board
{
	ArrayList<Row> rows;
	public ArrayList<Column> columns;
	ArrayList<Section> sections;
	public ArrayList<Cell> cells;

	/**
	 * Creates a new board with the provided values and sets up all cells and groupings.
	 * @param values
	 */
	public Board(int[][] values)
	{
		rows = new ArrayList<Row>();
		columns = new ArrayList<Column>();
		sections = new ArrayList<Section>();
		cells = new ArrayList<Cell>();
		for (int x = 0; x < values.length; x++)
		{
			Row currentRow = new Row();
			rows.add(currentRow);
			Section currentSection;
			Cell currentCell;
			for (int y = 0; y < values[x].length; y++)
			{
				Column currentCol;
				if (x == 0)
				{
					currentCol = new Column();
					columns.add(currentCol);
				}
				else
				{
					currentCol = columns.get(y);
				}
				if (y % 3 == 0 && x% 3 == 0)
				{
					currentSection = new Section();
					sections.add(currentSection);
				}
				else
				{
					currentSection = sections.get((int)(Math.floor(y/3) + Math.floor(x/3)*3));
				}
				if (values[x][y] == 0)
				{
					currentCell = new Cell(currentCol, currentRow,
							currentSection);
					cells.add(currentCell);
				}
				else
				{
					currentCell = new Cell(currentCol, currentRow,
							currentSection, values[x][y]);
					cells.add(currentCell);
				}
			}
		}
	}
	
	/**
	 * Calls clearDuplicates on every single Grouping on the board
	 */
	public void filterValues()
	{
		for(int i = 0; i < 9 ; i++)
		{
			columns.get(i).clearDuplicates();
			rows.get(i).clearDuplicates();
			sections.get(i).clearDuplicates();
		}
	}
	
	public String toString()
	{
		String result = "";
		for(Iterator<Row> i = rows.iterator(); i.hasNext(); )
		{
			result+=i.next().toString();
			
			result+= "\n";
		}
		return result;		
	}
	
	/**
	 * Finds every value that only occurs once in a grouping and sets the cell they occur in to that value
	 */
	public void filterSingles()
	{
		ArrayList<ArrayList<Integer>> finder;
		for(int i = 0 ; i <9 ; i++)
		{
			columns.get(i).findSingles();
			rows.get(i).findSingles();
			sections.get(i).findSingles();
			
		}
	}
	
	/**
	 * Calls findSets on every single Grouping on the board
	 */
	public void findPatterns()
	{
		for(int i = 0; i < 9 ; i++)
		{
				columns.get(i).findSets();
				rows.get(i).findSets();				
				sections.get(i).findSets();
		}
		
	}
	
}
