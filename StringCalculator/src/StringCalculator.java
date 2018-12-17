
public class StringCalculator {

	public static int[] stringToInt(String numbers)
	{		
		String[] splitNumbers = numbers.replaceAll("\n", "").split(",");
		int[] results = new int[splitNumbers.length];
		for(int i =0; i < splitNumbers.length; i ++)
		{
			results[i] = Integer.parseInt(splitNumbers[i]);			
		}
		
		return results;
	}
	
	public static int calculator(int[] numbers)
	{
		int result = 0;
		for(int i = 0; i < numbers.length ; i++)
		{
			result +=numbers[i];
		}
		return result;
	}
	
	public static int add(String numbers)
	{
		return calculator(stringToInt(numbers));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
