package boardObj;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents the individual cells. 
 * Knows which groupings it is part of, and all possible values it could have.
 * @author Niklaas
 *
 */
public class Cell
{
	Column col;
	Row row;
	Section sec;
	ArrayList<Integer> value;
	
	/**
	 * A constructor used to create an empty cell
	 * @param col
	 * @param row
	 * @param sec
	 */
	Cell(Column col, Row row, Section sec)
	{
		this.col = col;
		col.values.add(this);
		this. row = row;
		row.values.add(this);
		this. sec = sec;
		sec.values.add(this);
		value = new ArrayList<Integer>();
		value.add(1);
		value.add(2);
		value.add(3);
		value.add(4);
		value.add(5);
		value.add(6);
		value.add(7);
		value.add(8);
		value.add(9);
		
	}
	
	/**
	 * A constructor used to create a cell that already has a value
	 * @param col
	 * @param row
	 * @param sec
	 * @param value
	 */
	Cell(Column col, Row row, Section sec, int value)
	{
		this.col = col;
		col.values.add(this);		
		this. row = row;
		row.values.add(this);
		this. sec = sec;
		sec.values.add(this);
		this.value = new ArrayList<Integer>();
		this.value.add(value);				
	}
	
	/**
	 * A constructor used to create a deep copy of the cell
	 * @param copy
	 */
	public Cell(Cell copy)
	{
		this.col = copy.col;
		this.row = copy.row;
		this.sec = copy.sec;
		this.value = new ArrayList<Integer>();
		for(Iterator<Integer> i = copy.value.iterator(); i.hasNext();)
		{
			value.add(i.next());
		}
		
	}
	
	/**
	 * A constructor used to make a cell without groupings for testing purposes.
	 * @param value 
	 */
	public Cell(int[] value)
	{
		this.value = new ArrayList<Integer>();
		for(int i = 0; i < value.length;i++)
		{
			this.value.add(value[i]);
		}
	}
	
	public String toString()
	{
		String result = "[";		
		for(int i = 0; i < this.value.size(); i++)
		{
			result += this.value.get(i) +", ";
		}		
		result = result +"]";
		return result;
	}
	
	public void removeNumber(Integer i)
	{
		value.remove(i);
	}
	
	public boolean hasNumber(int target)
	{
		boolean result = false;
		for(int i = 0; i< value.size() ; i++)
		{
			if(value.get(i)==target)
			{
				result = true;
			}
		}
		
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;		
		return true;
	}
	
	
}
