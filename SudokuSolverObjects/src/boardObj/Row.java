package boardObj;

import java.util.ArrayList;

public class Row extends Grouping
{
	
	Row()
	{
		super();
	}

	@Override
	void findPointers()
	{		
		ArrayList<ArrayList<Integer>> result = findOccurances();
		for(int i = 0; i < result.size(); i++)
		{
			boolean same = true;		
			int previous = (result.get(i).get(0))/3;			
			for( int j = 0 ; j< result.get(i).size(); j++)
			{
				if(previous != (result.get(i).get(j))/3)
				{
					same = false;
				}
			}
			if(same&& result.get(i).size()>1)
			{
				for(int j = 0; j< values.get(result.get(i).get(0)).sec.values.size(); j++)
				{
					if(!values.get(result.get(i).get(0)).sec.values.get(j).row.equals(this))
					{
						values.get(result.get(i).get(0)).sec.values.get(j).removeNumber(i+1);
					}
				}
			}
		}
	}
	
}
