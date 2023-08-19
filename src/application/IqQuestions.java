package application;

import java.util.Random;

import javafx.event.ActionEvent;

public class IqQuestions {
	static int NOQ = 20;
	static IqOne iqOne = new IqOne();
	static IqTwo iqTwo = new IqTwo();
	static int generatedNumber = -1;
	static Random random = new Random();

	static void switchToIqQuestions(ActionEvent e, boolean languageChange) {

		int RandomNum;
		do {
			RandomNum = random.nextInt(2) + 1;
		} while (RandomNum == generatedNumber);
		generatedNumber = RandomNum;// generating 1 to 2 numbers
		System.out.println("generated Number" + generatedNumber);
		switch (generatedNumber) {
		case 1:
			System.out.println(1);
			iqOne.switchToIqQuestions(e, languageChange);
			break;
		case 2:
			System.out.println(2);
			iqTwo.switchToIqQuestions(e, languageChange);
			break;
		default:
			System.out.println("error generated");
		}
	}
}
