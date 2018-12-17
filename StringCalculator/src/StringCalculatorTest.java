import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	@Test
	void testCSV() {
		int test = StringCalculator.add("1,2,5");
		assertEquals(8, test);
		test = StringCalculator.add("6,3,4");
		assertEquals(13, test);
	}

	@Test
	void testNL() {
		int test = StringCalculator.add("1\n,2,5");
		assertEquals(8, test);
		test = StringCalculator.add("6\n,3,\n4");
		assertEquals(13, test);
	}
	
	@Test
	void testDelimeter() {
		int test = StringCalculator.add("//;\n1;3;4");
		assertEquals(8, test);
		test = StringCalculator.add("//$\n1$2$3");
		assertEquals(6, test);
	}
}
