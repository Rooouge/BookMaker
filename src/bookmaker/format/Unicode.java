package bookmaker.format;

public class Unicode {

	
	public static String validate(String text) {
		return text
				.replace("'", "\\\\u0027");
	}
}
