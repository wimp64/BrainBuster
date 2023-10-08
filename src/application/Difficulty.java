package application;

import application.Mathematics.switchingQuestionForDiffMath;
import application.Mathematics.switchingQuestionForEasyMath;
import application.Mathematics.switchingQuestionForNormalMath;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Difficulty {
	Scene scene1;
	Stage currentStage;
	Stage s;
	Scene sc;

	Button back;
	Button lan_button;
	Button ez;
	Button nm;
	Button df;
	Button square;

	Text Myanmar;
	Text English;
	Text Lan;
	Text ezEng;
	Text nmEng;
	Text dfEng;
	Text DText;

	Image Lang = new Image("lang.png");
	Image Arrow = new Image("arrow.png");
	Image Be = new Image("Difficult/Be.png");
	Image Bn = new Image("Difficult/BN.png");
	Image Bd = new Image("Difficult/BD.png");
	Image Dear = new Image("Difficult/dear.png");
	Image TKid = new Image("Difficult/TKid.png");
	Image SKid = new Image("Difficult/SKid.png");
	Image Pyramid = new Image("pyramid.png");
	Image Question = new Image("question.png");

	ImageView langText = new ImageView(Lang);
	ImageView backArrow = new ImageView(Arrow);
	ImageView BeImg = new ImageView(Be);
	ImageView BnImg = new ImageView(Bn);
	ImageView BdImg = new ImageView(Bd);
	ImageView DearImg = new ImageView(Dear);
	ImageView TKidImg = new ImageView(TKid);
	ImageView SKidImg = new ImageView(SKid);
	ImageView pyramidImg = new ImageView(Pyramid);
	ImageView questionImg = new ImageView(Question);
	ImageView DEng = new ImageView(new Image("Difficult/Difficult_Eng.png"));
	ImageView DMM = new ImageView(new Image("Difficult/Difficult_MM.png"));
	ImageView elvl = new ImageView(new Image("Difficult/elvl.png"));
	ImageView nlvl = new ImageView(new Image("Difficult/nlvl.png"));
	ImageView dlvl = new ImageView(new Image("Difficult/Dlvl.png"));

	StackPane root;

	boolean languageChange;///////////////////////// to delete true
	boolean nonesense = false;
	boolean choose;
	public void switchToDifficulty(ActionEvent event, boolean languageChange,StackPane proot,boolean choose) {
		this.languageChange = languageChange;
		this.choose = choose;
		root = new StackPane();
		root.setStyle("-fx-background-color: #2385C4");

		elements();
		Easy_button();
		Normal_button();
		Difficult_button();
		lan_change();
		// Retrieve the stage from the event source
		currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();

		scene1 = new Scene(root, currentStage.getWidth(), currentStage.getHeight());
		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		currentStage.setScene(scene1);
		proot.getChildren().clear();
		currentStage.show();
	}

	/* This is only for developing part */
//	public void start(Stage primaryStage) throws Exception {
//		root = new StackPane();
//		root.setStyle("-fx-background-color: #2385C4");
//		elements();
//		Easy_button();
//		Normal_button();
//		Difficult_button();
//		lan_change();
//		scene1 = new Scene(root, 1366, 766);
//		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//		primaryStage.setScene(scene1);
//		primaryStage.show();
//	}
//
//	public static void main(String[] args) {
//		launch(args);
//	}
	/* This is only for developing part */

	private void elements() {
		back = new Button();
		back.getStyleClass().add("lets_start");
		back.setPrefSize(60, 60);
		back.setOnAction(a -> {
			Category cat = new Category();
			cat.switchToScene1(a, 1, languageChange);
			root.getChildren().clear();
		});
		backArrow.setFitWidth(40);
		backArrow.setFitHeight(30);

		back.setGraphic(backArrow);
		StackPane.setAlignment(back, Pos.TOP_LEFT);
		StackPane.setMargin(back, new Insets(30, 0, 0, 30));// top right bottom left

		lan_button = new Button();
		lan_button.setPrefSize(78, 39);
		lan_button.getStyleClass().add("lets_start");
		StackPane.setAlignment(lan_button, Pos.TOP_LEFT);
		StackPane.setMargin(lan_button, new Insets(100, 0, 0, 210));
		lan_button.setOnAction(e -> lan_click());

		square = new Button();
		square.setPrefWidth(320);
		square.setPrefHeight(300);
		StackPane.setAlignment(square, Pos.CENTER);
		StackPane.setMargin(square, new Insets(0, 0, 0, 500));
		square.getStyleClass().add("SQUARE");

		DearImg.setFitWidth(140);
		DearImg.setFitHeight(180);
		StackPane.setAlignment(DearImg, Pos.BOTTOM_LEFT);

		TKidImg.setFitWidth(170);
		TKidImg.setFitHeight(250);
		StackPane.setAlignment(TKidImg, Pos.BOTTOM_RIGHT);
		TranslateTransition tt1 = new TranslateTransition();
		tt1.setByY(-50);
		tt1.setCycleCount(TranslateTransition.INDEFINITE);
		tt1.setAutoReverse(true);
		tt1.setNode(TKidImg);
		tt1.setDuration(Duration.seconds(10));

		SKidImg.setFitWidth(165);
		SKidImg.setFitHeight(185);
		StackPane.setAlignment(SKidImg, Pos.TOP_RIGHT);
		TranslateTransition tt2 = new TranslateTransition();
		tt2.setByX(-200);
		tt2.setCycleCount(TranslateTransition.INDEFINITE);
		tt2.setAutoReverse(true);
		tt2.setNode(SKidImg);
		tt2.setDuration(Duration.seconds(5));
		TranslateTransition tt2s = new TranslateTransition();
		tt2s.setByY(50);
		tt2s.setCycleCount(TranslateTransition.INDEFINITE);
		tt2s.setAutoReverse(true);
		tt2s.setNode(SKidImg);
		tt2s.setDuration(Duration.seconds(10));

		pyramidImg.setFitWidth(100);
		pyramidImg.setFitHeight(65);
		StackPane.setAlignment(pyramidImg, Pos.TOP_CENTER);
		StackPane.setMargin(pyramidImg, new Insets(100, 0, 0, 0));
		RotateTransition rotatePyramid = new RotateTransition();
		rotatePyramid.setByAngle(360);
		rotatePyramid.setDuration(Duration.seconds(20));
		rotatePyramid.setCycleCount(RotateTransition.INDEFINITE);
		rotatePyramid.setAutoReverse(false);
		rotatePyramid.setNode(pyramidImg);

		questionImg.setFitWidth(110);
		questionImg.setFitHeight(155);
		StackPane.setAlignment(questionImg, Pos.BOTTOM_CENTER);
		StackPane.setMargin(questionImg, new Insets(0, 0, 55, 250));
		RotateTransition rotateQuestion = new RotateTransition();
		rotateQuestion.setByAngle(360);
		rotateQuestion.setDuration(Duration.seconds(20));
		rotateQuestion.setCycleCount(RotateTransition.INDEFINITE);
		rotateQuestion.setAutoReverse(false);
		rotateQuestion.setNode(questionImg);

		ParallelTransition parallelTransition = new ParallelTransition();
		parallelTransition.getChildren().addAll(tt1, tt2, tt2s, rotatePyramid, rotateQuestion);
		parallelTransition.play();

		root.getChildren().addAll(lan_button, back, square, DearImg, TKidImg, SKidImg, pyramidImg, questionImg);
	}

	void Easy_button() {
		ez = new Button();
		ez.getStyleClass().add("Ez_Btn");
		ez.setPrefSize(370, 94);
		StackPane.setAlignment(ez, Pos.CENTER_LEFT);
		StackPane.setMargin(ez, new Insets(0, 0, 300, 150));
		ez.setOnAction(e->{
			if(choose) {
				switchingQuestionForEasyMath.switchToQuestions(e, languageChange, root);
			}
			else {
				System.out.println("LogicE");
			}
		});
		Rectangle line = new Rectangle();
		line.setWidth(250);
		line.setHeight(10);
		line.setFill(Color.WHITE);

		ez.setOnMousePressed(e -> {
			line.setFill(Color.web("#00FF2A"));
		});
		ez.setOnMouseReleased(e -> {
			line.setFill(Color.WHITE);
		});
		ez.setOnMouseEntered(e -> {
			BeImg.setFitWidth(200);
			BeImg.setFitHeight(200);
			square.setGraphic(BeImg);
		});
		ez.setOnMouseExited(e -> {
			square.setGraphic(null);
			if (languageChange) {
				DEng.setFitWidth(270);
				DEng.setFitHeight(140);
				square.setGraphic(DEng);
			} else {
				DMM.setFitWidth(230);
				DMM.setFitHeight(140);
				square.setGraphic(DMM);
			}
		});

		StackPane.setAlignment(line, Pos.CENTER_LEFT);
		StackPane.setMargin(line, new Insets(0, 0, 150, 210));

		root.getChildren().addAll(ez, line);
	}

	void Normal_button() {
		nm = new Button();
		nm.getStyleClass().add("Nm_Btn");
		nm.setPrefSize(370, 94);
		nm.setOnAction(e->{
			if(choose) {
				switchingQuestionForNormalMath.switchToQuestions(e, languageChange, root);
			}
			else {
				System.out.println("LogicN");
			}
		});
		StackPane.setAlignment(nm, Pos.CENTER_LEFT);
		StackPane.setMargin(nm, new Insets(0, 0, 0, 150));

		Rectangle line1 = new Rectangle();
		line1.setWidth(250);
		line1.setHeight(10);
		line1.setFill(Color.WHITE);

		nm.setOnMousePressed(e -> {
			line1.setFill(Color.web("#00FF2A"));
		});
		nm.setOnMouseReleased(e -> {
			line1.setFill(Color.WHITE);
		});
		nm.setOnMouseEntered(e -> {
			BnImg.setFitWidth(200);
			BnImg.setFitHeight(200);
			square.setGraphic(BnImg);
		});
		nm.setOnMouseExited(e -> {
			square.setGraphic(null);
			if (languageChange) {
				DEng.setFitWidth(270);
				DEng.setFitHeight(140);
				square.setGraphic(DEng);
			} else {
				DMM.setFitWidth(230);
				DMM.setFitHeight(140);
				square.setGraphic(DMM);
			}
		});

		StackPane.setAlignment(line1, Pos.CENTER_LEFT);
		StackPane.setMargin(line1, new Insets(0, 0, -150, 210));

		root.getChildren().addAll(nm, line1);
	}

	void Difficult_button() {
		df = new Button();
		df.getStyleClass().add("Df_Btn");
		df.setPrefSize(370, 94);
		df.setOnAction(e->{
			if(choose) {
				switchingQuestionForDiffMath.switchToQuestions(e, languageChange, root);
			}
			else {
				System.out.println("LogicD");
			}
		});
		StackPane.setAlignment(df, Pos.CENTER_LEFT);
		StackPane.setMargin(df, new Insets(0, 0, -300, 150));

		Rectangle line2 = new Rectangle();
		line2.setWidth(250);
		line2.setHeight(10);
		line2.setFill(Color.WHITE);
		df.setOnMousePressed(e -> {
			line2.setFill(Color.web("#00FF2A"));
		});
		df.setOnMouseReleased(e -> {
			line2.setFill(Color.WHITE);
		});
		df.setOnMouseEntered(e -> {
			BdImg.setFitWidth(200);
			BdImg.setFitHeight(200);
			square.setGraphic(BdImg);
		});
		df.setOnMouseExited(e -> {
			square.setGraphic(null);
			if (languageChange) {
				DEng.setFitWidth(270);
				DEng.setFitHeight(140);
				square.setGraphic(DEng);
			} else {
				DMM.setFitWidth(230);
				DMM.setFitHeight(140);
				square.setGraphic(DMM);
			}
		});

		StackPane.setAlignment(line2, Pos.CENTER_LEFT);
		StackPane.setMargin(line2, new Insets(0, 0, -450, 210));

		root.getChildren().addAll(df, line2);
	}

	void lan_click() {
		languageChange = !languageChange;
		lan_change();
	}

	private void lan_change() {
		if (languageChange) {
			langText.setVisible(false);

			Lan = new Text("Language:");
			Font lan_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 20);
			Lan.setFont(lan_font);
			Lan.setFill(Color.WHITE);
			StackPane.setAlignment(Lan, Pos.TOP_LEFT);
			StackPane.setMargin(Lan, new Insets(105, 0, 0, 90));

			English = new Text("ENG");
			Font English_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 20);
			English.setFont(English_font);
			English.setFill(Color.WHITE);
			lan_button.setGraphic(English);

			ezEng = new Text("EASY");
			Font D_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 40);
			ezEng.setFont(D_font);
			ezEng.setFill(Color.WHITE);
			ez.setGraphic(ezEng);

			nmEng = new Text("NORMAL");
			nmEng.setFont(D_font);
			nmEng.setFill(Color.WHITE);
			nm.setGraphic(nmEng);

			dfEng = new Text("DIFFICULT");
			dfEng.setFont(D_font);
			dfEng.setFill(Color.WHITE);
			df.setGraphic(dfEng);

			DEng.setFitWidth(270);
			DEng.setFitHeight(140);
			square.setGraphic(DEng);

			root.getChildren().addAll(Lan);

			nonesense = true;
		} else {
			if (nonesense == true) {
				Lan.setVisible(false);
			}
			langText = new ImageView(Lang);
			langText.setFitWidth(130);
			langText.setFitHeight(20);
			StackPane.setAlignment(langText, Pos.TOP_LEFT);
			StackPane.setMargin(langText, new Insets(110, 0, 0, 70));

			Myanmar = new Text("Myan");
			Font English_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 20);
			Myanmar.setFont(English_font);
			Myanmar.setFill(Color.WHITE);
			lan_button.setGraphic(Myanmar);

			DMM.setFitWidth(230);
			DMM.setFitHeight(140);
			square.setGraphic(DMM);

			elvl.setFitWidth(250);
			elvl.setFitHeight(45);
			ez.setGraphic(elvl);

			nlvl.setFitWidth(200);
			nlvl.setFitHeight(45);
			nm.setGraphic(nlvl);

			dlvl.setFitWidth(250);
			dlvl.setFitHeight(45);
			df.setGraphic(dlvl);
			root.getChildren().addAll(langText);
		}
	}
}
