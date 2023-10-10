package application.Mathematics;

public class MathResultCheck {
	public static double correct=0;
	public static double result=0;
	public static double percent=0;
	public static void check() {
		++correct;
		result = correct;
		System.out.println("result: "+correct);
	}
	static double getScore() {
		correct = (correct/5) * 100;
		percent = correct;
		correct = correct/100;
		return correct;
	}
	static double getResult() {
		return result;
	}
	static double getPercent() {
		return percent;
	}
}
