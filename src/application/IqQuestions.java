package application;

import java.util.Random;

import javafx.event.ActionEvent;

public class IqQuestions {
	static int NOQ = 20;
	static IqOne iqOne = new IqOne();
	static IqTwo iqTwo = new IqTwo();
	static IqThree iqThree = new IqThree();
	static Difficulty df = new Difficulty();
	static int generatedNumber = -1;
	static Random random = new Random();
	static int point = -1;

	static void switchToIqQuestions(ActionEvent e, boolean languageChange) {
		point++;
		int RandomNum;
		do {
			RandomNum = random.nextInt(3) + 1;
		} while (RandomNum == generatedNumber);

		generatedNumber = RandomNum;
		int[] check = new int[4];
		System.out.println(point);
		check[point] = generatedNumber;

		if (point == 3) {
			for (int i = 0; i < 3; i++) {
				if (generatedNumber == check[i]) {
					System.out.println(point);
					System.out.println("succeed");
					break;
				}
				if (conditionToStopLoop()) {
					df.switchToDifficulty(e, languageChange);
					return; // Stop the entire program
				}
			}
		}
		System.out.println("generated Number" + generatedNumber);
		try {
			switch (generatedNumber) {
			case 1:
				iqOne.switchToIqQuestions(e, languageChange);
				break;
			case 2:
				iqTwo.switchToIqQuestions(e, languageChange);
				break;
			case 3:
				iqThree.switchToIqQuestions(e, languageChange);
				break;
			default:
				System.out.println("error generated");
			}
		} catch (Exception ea) {
			ea.printStackTrace();
		}
	}

	public static boolean conditionToStopLoop() {
		// Implement your own condition here
		return true; // Change this condition to meet your requirements
	}
}
