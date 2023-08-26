package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javafx.event.ActionEvent;

public class IqQuestions {
	static int NOQ = 20;
	static IqOne iqOne = new IqOne();
	static IqTwo iqTwo = new IqTwo();
	static IqThree iqThree = new IqThree();
	static IqFour iqFour = new IqFour();
	static IqFive iqFive = new IqFive();
	static Difficulty df = new Difficulty();
	static Random random = new Random();
	static int point = -1;
	static List<Integer> check = new ArrayList<>();
	static boolean checker = true;

	static void switchToIqQuestions(ActionEvent e, boolean languageChange) {
		point++;
		if (checker == true) {
			int maxNumber = 5; // Maximum number to generate (exclusive)
			int numberOfNumbers = 5; // Number of unique random numbers to generate

			Random random = new Random();

			while (check.size() < numberOfNumbers) {
				int randomNumber = random.nextInt(maxNumber) + 1;
				if (!check.contains(randomNumber)) {
					check.add(randomNumber);
				}
			}

			// Shuffle the list to get random order
			Collections.shuffle(check);
			checker = false;
		}
		System.out.println(point);
		if (point == 5) {
			checker = true;
			point = -1;
			if (conditionToStopLoop()) {
				df.switchToDifficulty(e, languageChange);
				return;
			}
		}
		try {
			switch (check.get(point)) {
			case 1:
				iqOne.switchToIqQuestions(e, languageChange);
				break;
			case 2:
				iqTwo.switchToIqQuestions(e, languageChange);
				break;
			case 3:
				iqThree.switchToIqQuestions(e, languageChange);
				break;
			case 4:
				iqFour.switchToIqQuestions(e, languageChange);
				break;
			case 5:
				iqFive.switchToIqQuestions(e, languageChange);
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
