package application;

import java.util.prefs.Preferences;

public class test {
	Preferences pre = Preferences.userRoot().node(this.getClass().getName());

	public static void main(String[] args) {
		test t = new test();
		String s1 = "s1";

		t.pre.putInt(s1, 16);
		System.out.println(t.pre.getBoolean(s1, false));
		System.out.println(t.pre.getInt(s1, 1));
		t.pre.remove(s1);

	}
}
