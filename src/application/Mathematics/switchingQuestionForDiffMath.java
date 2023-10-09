package application.Mathematics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.scene.layout.StackPane;

public class switchingQuestionForDiffMath {
	static _1MathD oneMath = new _1MathD();
	static _2MathD twoMath = new _2MathD();
	static _3MathD threeMath = new _3MathD();
	static _4MathD fourMath = new _4MathD();
	static _5MathD fiveMath = new _5MathD();
	
	static int NOQ = 5;
	static Random random = new Random();
	static int point = -1;
	static List<Integer> check = new ArrayList<>();
	static boolean checker = true;

	public static void switchToQuestions(ActionEvent e, boolean languageChange,StackPane proot) {
		point++;
		if (checker == true) {
			int maxNumber = NOQ; // Maximum number to generate
			int numberOfQ = NOQ; // Number of unique random numbers to generate

			Random random = new Random();

			while (check.size() < numberOfQ) {
				int randomNumber = random.nextInt(maxNumber) + 1;
				if (!check.contains(randomNumber)) {
					check.add(randomNumber);
				}
			}

			// Shuffle the list to get random order
			Collections.shuffle(check);
			checker = false;
		}
		if (point == NOQ) {
			checker = true;
			point = -1;
			if (conditionToStopLoop()) {
				MathResult mr = new MathResult();
				mr.switchToDifficulty(e, languageChange, proot);
				return;
			}
		}
		try {
			switch (check.get(point)) {
			case 1:oneMath.switchToDifficulty(e, languageChange, proot);
				break;
			case 2:twoMath.switchToDifficulty(e, languageChange, proot);
				break;
			case 3:threeMath.switchToDifficulty(e, languageChange, proot);
				break;
			case 4:fourMath.switchToDifficulty(e, languageChange, proot);
				break;
			case 5:fiveMath.switchToDifficulty(e, languageChange, proot);
				break;
			default:
				System.out.println("error generated");
			}
		} catch (Exception ea) {
			ea.printStackTrace();
		}
	}
	public static boolean conditionToStopLoop() {

		return true;
	}
}
