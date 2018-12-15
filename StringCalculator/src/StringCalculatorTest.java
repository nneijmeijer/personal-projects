import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	@Test
	void test() {
		int test = StringCalculator.add("1,2,5");
		assertEquals(8, test);
	}

}
