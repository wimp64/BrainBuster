package application;

public class IqResultCheck {
	static double correct=0;
	static void check() {
		++correct;
		System.out.println("result: "+correct);
	}
	static double getScore() {
		return correct;
	}
}
