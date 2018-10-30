package boardObj;

import java.util.ArrayList;

/**
 * A Section is a 3x3 group of cells.
 * @author Niklaas
 *
 */
public class Section extends Grouping
{	
	
	Section()
	{
		super();
	}
	
	@Override
	void findPointers()
	{
		ArrayList<ArrayList<Integer>> result = findOccurances();
		for(int i = 0; i < result.size(); i++)
		{
			boolean sameRow = true;
			boolean sameCol = true;
			int previousRow = (result.get(i).get(0))/3;
			int previousCol = (result.get(i).get(0))%3;
			for( int j = 0 ; j< result.get(i).size(); j++)
			{
				if(previousRow != (result.get(i).get(j))/3)
				{
					sameRow = false;
				}
				if(previousCol != (result.get(i).get(j))%3)
				{
					sameCol = false;
				}
			}
			if(sameRow&& result.get(i).size()>1)
			{
				for(int j = 0; j< values.get(result.get(i).get(0)).row.values.size(); j++)
				{
					if(!values.get(result.get(i).get(0)).row.values.get(j).sec.equals(this))
					{
						values.get(result.get(i).get(0)).row.values.get(j).removeNumber(i+1);
					}
				}
			}
			
			if(sameCol&& result.get(i).size()>1)
			{
				for(int j = 0; j< values.get(result.get(i).get(0)).col.values.size(); j++)
				{
					if(!values.get(result.get(i).get(0)).col.values.get(j).sec.equals(this))
					{
						values.get(result.get(i).get(0)).col.values.get(j).removeNumber(i+1);
					}
				}
			}
		}
			}
}
