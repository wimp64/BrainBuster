package application.Logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.scene.layout.StackPane;
import application.Mathematics.*;
public class switchingQuestionForNormalLogic {
	static _1LogicN oneLogic = new _1LogicN();
	static _2LogicN twoLogic = new _2LogicN();
	static _3LogicN threeLogic = new _3LogicN();
	static _4LogicN fourLogic = new _4LogicN();
	static _5LogicN fiveLogic = new _5LogicN();

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
			case 1:oneLogic.switchToDifficulty(e, languageChange, proot);
			break;
		case 2:twoLogic.switchToDifficulty(e, languageChange, proot);
			break;
		case 3:threeLogic.switchToDifficulty(e, languageChange, proot);
			break;
		case 4:fourLogic.switchToDifficulty(e, languageChange, proot);
			break;
		case 5:fiveLogic.switchToDifficulty(e, languageChange, proot);
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
