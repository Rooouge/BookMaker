package bookmaker.format;

import java.util.Arrays;
import java.util.List;

public class ASCII {

	private static final List<Integer> ONE = Arrays.asList(new Integer[] {33,39,44,46,58,59,105,124});
	private static final List<Integer> TWO = Arrays.asList(new Integer[] {96,108});
	private static final List<Integer> THREE = Arrays.asList(new Integer[] {32,34,40,41,42,73,91,93,116,123,125});
	private static final List<Integer> FOR = Arrays.asList(new Integer[] {60,62,102,107});
	private static final List<Integer> SIX = Arrays.asList(new Integer[] {64,126});
	
	
	public static boolean isValid(String s) {
		return getWidth(s) <= 113;
	}
	
	public static String getValid(String s) {
		while(!isValid(s)) {
			s = s.substring(0, s.length() - 1);
		}
		
		return s;
	}
	
	/**
	 * Returns the width in pixels of the string s with the default Minecraft font. Each character has a 1:6 width. A row could have a maximum width of 113 pixels
	 */
	public static int getWidth(String s) {
		if(s == null)
			return -1;
		
		int width = 0;
		
		for(int i = 0; i < s.length(); i++) {
			width += getWidth(s.charAt(i));
//			System.out.println("" + width);
		}
		
		width += s.length() - 1; //Extra pixels spacing each characters from the others
		
//		System.out.println(width);
		return width;
	}
	
	private static int getWidth(char c) {
//		System.out.print("'" + c + "' (" + (int) c +  ") : ");
		
		if(ONE.contains((int) c))
			return 1;
		
		if(TWO.contains((int) c))
			return 2;
		
		if(THREE.contains((int) c))
			return 3;
		
		if(FOR.contains((int) c))
			return 4;
		
		if(SIX.contains((int) c))
			return 6;
		
		return 5;
	}
}
