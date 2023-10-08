package application;

public class IqResultCheck {
	static double correct=0;
	static double result=0;
	static double percent=0;
	static void check() {
		++correct;
		result = correct;
		System.out.println("result: "+correct);
	}
	static double getScore() {
		correct = (correct/20) * 100;
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
