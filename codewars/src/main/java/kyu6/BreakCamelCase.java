package kyu6;

public class BreakCamelCase {

	public static String camelCase(String input) {
		String splitByCapitalLetter = "(?=\\p{Upper})";
		return input.replaceAll(splitByCapitalLetter, " $0");
	}

	public static String camelCaseBestPractices(String input) {
		return input.replaceAll("([A-Z])", " $1");
	}

}
