package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.scene.layout.StackPane;

public class IqQuestions {
	static int NOQ = 20;
	static IqOne iqOne = new IqOne();
	static IqTwo iqTwo = new IqTwo();
	static IqThree iqThree = new IqThree();
	static IqFour iqFour = new IqFour();
	static IqFive iqFive = new IqFive();
	static IqSix iqSix = new IqSix();
	static IqSeven iqSeven = new IqSeven();
	static IqEight iqEight = new IqEight();
	static IqNine iqNine = new IqNine();
	static IqTen iqTen = new IqTen();
	static IqEleven iqEleven = new IqEleven();
	static IqTwelve iqTwelve = new IqTwelve();
	static IqThirteen iqThirteen = new IqThirteen();
	static IqFourteen iqFourteen = new IqFourteen();
	static IqFifteen iqFifteen = new IqFifteen();
	static IqSixteen iqSixteen = new IqSixteen();
	static IqSeventeen iqSeventeen = new IqSeventeen();
	static IqEighteen iqEighteen = new IqEighteen();
	static IqNinteen iqNinteen = new IqNinteen();
	static IqTwenty iqTwenty = new IqTwenty();
	
	static Difficulty df = new Difficulty();
	static IqResult iqr = new IqResult();
	
	static Random random = new Random();
	static int point = -1;
	static List<Integer> check = new ArrayList<>();
	static boolean checker = true;

	static void switchToIqQuestions(ActionEvent e, boolean languageChange,StackPane proot) {
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
				iqr.switchToDifficulty(e, languageChange, proot);
				return;
			}
		}
		try {
			switch (check.get(point)) {
			case 1:
				System.out.println("Iq one");
				iqOne.switchToIqQuestions(e, languageChange,proot);
				
				break;
			case 2:
				System.out.println("Iq two");
				iqTwo.switchToIqQuestions(e, languageChange,proot);
				
				break;
			case 3:
				System.out.println("Iq three");
				iqThree.switchToIqQuestions(e, languageChange,proot);
				
				break;
			case 4:
				System.out.println("Iq four");
				iqFour.switchToIqQuestions(e, languageChange,proot);
				
				break;
			case 5:
				System.out.println("Iq five");
				iqFive.switchToIqQuestions(e, languageChange,proot);
				
				break;
			case 6:
				System.out.println("Iq six");
				iqSix.switchToIqQuestions(e, languageChange,proot);
				
				break;
			case 7:
				System.out.println("Iq seven");
				iqSeven.switchToIqQuestions(e, languageChange,proot);
				
				break;
			case 8:
				System.out.println("Iq eight");
				iqEight.switchToIqQuestions(e, languageChange,proot);
				
				break;
			case 9:
				System.out.println("Iq nine");
				iqNine.switchToDifficulty(e, languageChange,proot);
				
				break;
			case 10:
				System.out.println("Iq ten");
				iqTen.switchToDifficulty(e, languageChange, proot);
				
				break;
			case 11:
				System.out.println("Iq eleven");
				iqEleven.switchToIqQuestions(e, languageChange, proot);
				
				break;
			case 12:
				System.out.println("Iq twelve");
				iqTwelve.switchToIqQuestions(e, languageChange, proot);
				
				break;
			case 13:
				System.out.println("Iq thirteen");
				iqThirteen.switchToIqQuestions(e, languageChange, proot);
				
				break;
			case 14:
				System.out.println("Iq fourteen");
				iqFourteen.switchToIqQuestions(e, languageChange, proot);
				
				break;
			case 15:
				System.out.println("Iq fifteen");
				iqFifteen.switchToDifficulty(e, languageChange, proot);
				
				break;
			case 16:
				System.out.println("Iq Sixteen");
				iqSixteen.switchToIqQuestions(e, languageChange, proot);
				
				break;
			case 17:
				System.out.println("Iq Seventeen");
				iqSeventeen.switchToIqQuestions(e, languageChange, proot);
				
				break;
			case 18:
				System.out.println("Iq Eighteen");
				iqEighteen.switchToDifficulty(e, languageChange, proot);
				
				break;
			case 19:
				System.out.println("Iq Ninteen");
				iqNinteen.switchToIqQuestions(e, languageChange, proot);
				
				break;
			case 20:
				System.out.println("Iq Twenty");
				iqTwenty.switchToDifficulty(e, languageChange, proot);
				
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
