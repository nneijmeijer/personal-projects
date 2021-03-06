package boardObj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * A grouping is a set of nine Cells that once the program has finished executing will only have one
 * of each possible number.
 * @author Niklaas
 *
 */
public abstract class Grouping
{
	ArrayList<Cell> values;
	
	Grouping()
	{
		values = new ArrayList<Cell>();
	}
	
	/**
	 * If a Cell in the Grouping only as one value, clear that value from every other Cell in the Grouping 
	 */
	void clearDuplicates()
	{
		for(int i = 0; i < values.size() ; i++)
		{
			if(values.get(i).value.size() == 1)
			{
				for(int j = 0; j < values.size() ; j++)
				{
					if(j!= i)
					{
						values.get(j).removeNumber(values.get(i).value.get(0));
					}
				}
			}
		}
	}
	
	/**
	 * Finds where each value can occur in the grouping
	 * @return A list of where each number appears in each grouping.
	 */
	ArrayList<ArrayList<Integer>> findOccurances()
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < 9 ; i++)
		{
			result.add(new ArrayList<Integer>());
		}
		//i loops through the cells in the Grouping, j loops through the values in those cells
		for(int i = 0; i < values.size() ; i++)
		{
			for(int j = 0; j< values.get(i).value.size();j++)
			{
				result.get(values.get(i).value.get(j)-1).add(i);
			}
		}
		return result;
	}
	
	
	/**
	 * Finds all pointing sets.
	 * First gets the number of occurrences, then determines if any numbers 
	 * occur in exactly the same places. It will then set the possible 
	 * values to the appropriate numbers
	 */ 
	void findSets()
	{
		ArrayList<ArrayList<Integer>> occurances = findOccurances();
		for(int i = 0; i < occurances.size() ; i++)
		{
			int count = 1;
			ArrayList<Integer> matches = new ArrayList<>();
			matches.add(i+1);
			for(int j = 0; j< occurances.size();j++)
			{
				if(j!=i)
				{
					if(occurances.get(i).containsAll(occurances.get(j)))
					{
						if(occurances.get(j).size() !=1)
						{
						count++;
						matches.add(j+1);
						}
					}
				}
			}			
			if(count == occurances.get(matches.get(0)-1).size() && count >1 )
			{
				for(int j = 0; j < occurances.get(i).size(); j++)
				{
					ArrayList<Integer> numsToRemove = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6,7,8,9));				
					numsToRemove.removeAll(matches);
					values.get(occurances.get(i).get(j)).value.removeAll(numsToRemove	);						
				}
			}
		}
		this.findPointers();
	}
	
	@Override
	public String toString() {
		String result = "";
		for(Iterator<Cell> j =this.values.iterator();j.hasNext();)
		{
			result+=j.next().toString();
			
		}
		return result;
	}

	void findSingles()
	{
		ArrayList<ArrayList<Integer>> finder = findOccurances();
		for(int j = 0; j < 9; j++)
		{
			if(finder.get(j).size()==1)
			{
				values.get(finder.get(j).get(0)).value.clear();
				values.get(finder.get(j).get(0)).value.add(j+1);
			}
		}
	}
	
	/**
	 * A method that determines if all occurrences of a value in a grouping are also in another grouping
	 * and if so, eliminates all other occurrences of that value in the other grouping,
	 */
	abstract void findPointers();
}
