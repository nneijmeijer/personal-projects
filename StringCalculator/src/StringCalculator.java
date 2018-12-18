
public class StringCalculator {

	public static int[] stringToInt(String numbers) {
		String delimeter = ",";
		if (numbers.startsWith("//")) {
			delimeter = ("\\Q" + numbers.substring(numbers.indexOf("//") + 2, numbers.indexOf("\n"))+"\\E").replaceAll(",", "\\\\E|\\\\Q");
			//delimeter = (numbers.substring(numbers.indexOf("//") + 2, numbers.indexOf("\n"))).replaceAll(",", "|");
			numbers = numbers.substring(numbers.indexOf("\n"));
		}
		String[] splitNumbers = numbers.replaceAll("\n", "").split(delimeter);
		int[] results = new int[splitNumbers.length];		
		for (int i = 0; i < splitNumbers.length; i++) {
			if(!splitNumbers[i].equals(""))
			{
			results[i] = Integer.parseInt(splitNumbers[i]);
			}
		}

		return results;
	}

	public static int calculator(int[] numbers) throws Exception {
		int result = 0;
		String negatives = "Negatives are not allowed: ";
		boolean negativeAppeared = false;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] >= 0) {
				if (numbers[i] <= 1000) {
					result += numbers[i];
				}
			} else {
				negatives += numbers[i] + " ";
				negativeAppeared = true;
			}
		}
		if (negativeAppeared) {
			throw new Exception(negatives);
		}

		return result;
	}

	public static int add(String numbers) {
		int result = -1;
		try {
			result = calculator(stringToInt(numbers));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
