package kyu6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BreakCamelCaseTest {

	public static final String INCORRECT = "Incorrect";

	@Test
	public void tests() {
		assertEquals(INCORRECT, "camel Casing", BreakCamelCase.camelCase("camelCasing"));
		assertEquals(INCORRECT, "camel Casing Test", BreakCamelCase.camelCase("camelCasingTest"));
		assertEquals(INCORRECT, "camelcasingtest", BreakCamelCase.camelCase("camelcasingtest"));
	}
}