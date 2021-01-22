package bookmaker.utils;

import java.sql.Timestamp;
import java.util.Date;

public class Log {

	public static String info(String msg) {
		String newMsg = timestamp() + " [INFO] " + msg;
		System.out.println(newMsg);
		
		return newMsg;
	}
	
	
	public static String system(String msg) {
		String newMsg = timestamp() + " [SYST] " + msg;
		System.out.println(newMsg);
		
		return newMsg;
	}
	
	public static String game(String msg) {
		String newMsg = timestamp() + " [GAME] " + msg;
		System.out.println(newMsg);
		
		return newMsg;
	}
	
	public static String xml(String msg) {
		String newMsg = timestamp() + " [INFO][XML] " + msg;
		System.out.println(newMsg);
		
		return newMsg;
	}
	
	protected static String timestamp() {
		String defPattern = "yyyy-MM-dd HH:mm:ss.SSS";
		
		Timestamp ts = new Timestamp(new Date().getTime());
		
		String tsString = "" + ts;
		while (tsString.length() < defPattern.length()) {
			tsString += '0';
		}
		
		return "[" + tsString + "]";
	}
}
