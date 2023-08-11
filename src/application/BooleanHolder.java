package application;

public class BooleanHolder {
	private static boolean lan = true;
	
	public static boolean getBool() {
		return lan;
	}
	public static void setBool(boolean sb) {
		lan = sb;
	}
}
