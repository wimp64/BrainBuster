package application;

import java.util.prefs.Preferences;

public class test {
	Preferences pre = Preferences.userRoot().node(this.getClass().getName());

	public static void main(String[] args) {
		test t = new test();
		String s1 = "s1";

		System.out.println(t.pre.getBoolean(s1, false));
		t.pre.remove(s1);
		t.pre.putBoolean(s1, true);

	}
}
