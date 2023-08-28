package application;

import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Category {

	Scene scene1;
	Stage currentStage;
	Stage s;
	Scene sc;

	Button back;
	Button lan_button;
	Button math_button;
	Button math_in_button;
	Button lg_button;
	Button lg_in_button;
	Button iq_button;
	Button iq_in_button;
	Button ach_button;
	Button ach_in_button;
	public static Button profile;
	Button name;

	Text Myanmar;
	Text English;
	Text Lan;
	Text Math;
	Text Logic;
	Text IQ;
	Text Ach;

	Image Lang = new Image("lang.png");
	Image Arrow = new Image("arrow.png");
	Image Boy = new Image("boy.png");
	Image Girl = new Image("girl.png");
	Image Flat = new Image("flat.png");
	Image G_board = new Image("greenBoard.png");
	Image CatText = new Image("catText.png");
	Image CatTextM = new Image("catTextM.png");
	Image M_Math = new Image("m_math.png");
	Image M_Logic = new Image("m_logic.png");
	Image M_IQ = new Image("m_iq.png");
	Image M_Ach = new Image("m_ach.png");
	Image M_MathB = new Image("m_mathB.png");
	Image M_LogicB = new Image("m_logicB.png");
	Image M_IQB = new Image("m_iqB.png");
	Image M_AchB = new Image("m_achB.png");
	Image Moon = new Image("moon.png");
	Image Cone = new Image("cone.png");
	Image Pyramid = new Image("pyramid.png");
	Image Rookie = new Image("rookie.png");
	Image Cele = new Image("celeRope.png");

	ImageView langText = new ImageView(Lang);
	ImageView backArrow = new ImageView(Arrow);
	ImageView boyStand = new ImageView(Boy);
	ImageView girlStand = new ImageView(Girl);
	ImageView flat = new ImageView(Flat);
	ImageView gBoard = new ImageView(G_board);
	ImageView catText = new ImageView(CatText);
	ImageView catTextM = new ImageView(CatTextM);
	ImageView m_Math = new ImageView(M_Math);
	ImageView m_Logic = new ImageView(M_Logic);
	ImageView m_IQ = new ImageView(M_IQ);
	ImageView m_Ach = new ImageView(M_Ach);
	ImageView m_MathB = new ImageView(M_MathB);
	ImageView m_LogicB = new ImageView(M_LogicB);
	ImageView m_IQB = new ImageView(M_IQB);
	ImageView m_AchB = new ImageView(M_AchB);
	ImageView moonImg = new ImageView(Moon);
	ImageView coneImg = new ImageView(Cone);
	ImageView pyramidImg = new ImageView(Pyramid);
	ImageView rookieImg = new ImageView(Rookie);
	ImageView celeImg = new ImageView(Cele);

	StackPane root;

	boolean languageChange;
	boolean nonesense = false;

	public void switchToScene1(ActionEvent event, int SelectValue, boolean lanSwap) {
		languageChange = lanSwap;

		root = new StackPane();
		root.setStyle("-fx-background-color: #F79630");
		profile();
		elements();
		mathematics();
		logic();
		iq_test();
		achievement();
		lan_change();
		// Retrieve the stage from the event source
		currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
		scene1 = new Scene(root);
		currentStage.setWidth(currentStage.getWidth());
		currentStage.setHeight(currentStage.getHeight());
		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		currentStage.setScene(scene1);
		currentStage.show();
	}

	private void back(ActionEvent event) {
		s = currentStage;
		currentStage.setHeight(s.getHeight());
		currentStage.setWidth(s.getWidth());
		currentStage.setScene(Main.scene);
		currentStage.show();
	}

	private void profile() {
		profile = new Button();
		profile.getStyleClass().add("circular-button");
		profile.setPrefSize(125, 125);
		StackPane.setAlignment(profile, Pos.TOP_RIGHT);
		StackPane.setMargin(profile, new Insets(25, 450, 0, 0));
		profile.setOnAction(e -> {
			Stage news = new Stage();
			Profile p = new Profile();
			try {
				p.start(news, languageChange);
			} catch (Exception a) {

			}
		});
		name = new Button();
		name.getStyleClass().add("name");
		name.setPrefSize(375, 75);
		StackPane.setAlignment(name, Pos.TOP_RIGHT);
		StackPane.setMargin(name, new Insets(55, 150, 0, 0));

		Text test = new Text("Rookie");
		Font Mathematics_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 26);
		test.setFont(Mathematics_font);
		test.setFill(Color.WHITE);
		name.setGraphic(test);

		rookieImg = new ImageView(Rookie);
		rookieImg.setFitWidth(55);
		rookieImg.setFitHeight(77);

		profile.setGraphic(rookieImg);

		root.getChildren().addAll(name, profile);
	}

	private void elements() {
		back = new Button();
		back.getStyleClass().add("lets_start");
		back.setPrefSize(60, 60);
		back.setOnAction(a -> back(a));
		backArrow.setFitWidth(40);
		backArrow.setFitHeight(30);
		back.setGraphic(backArrow);
		StackPane.setAlignment(back, Pos.TOP_LEFT);
		StackPane.setMargin(back, new Insets(30, 0, 0, 30));// top right bottom left

		lan_button = new Button();
		lan_button.setPrefSize(78, 39);
		lan_button.getStyleClass().add("lets_start");
		lan_button.setOnAction(e -> lan_click());
		StackPane.setAlignment(lan_button, Pos.TOP_LEFT);
		StackPane.setMargin(lan_button, new Insets(100, 0, 0, 210));

		flat.setFitWidth(128);
		flat.setFitHeight(30);
		StackPane.setAlignment(flat, Pos.BOTTOM_LEFT);
		StackPane.setMargin(flat, new Insets(0, 0, 125, 25));
		TranslateTransition tt0 = new TranslateTransition();
		tt0.setByY(-50);
		tt0.setCycleCount(TranslateTransition.INDEFINITE);
		tt0.setAutoReverse(true);
		tt0.setNode(flat);
		tt0.setDuration(Duration.seconds(10));

		boyStand.setFitWidth(102);
		boyStand.setFitHeight(211);
		StackPane.setAlignment(boyStand, Pos.BOTTOM_LEFT);
		StackPane.setMargin(boyStand, new Insets(0, 0, 140, 35));
		TranslateTransition tt = new TranslateTransition();
		tt.setByY(-50);
		tt.setCycleCount(TranslateTransition.INDEFINITE);
		tt.setAutoReverse(true);
		tt.setNode(boyStand);
		tt.setDuration(Duration.seconds(10));

		girlStand.setFitWidth(111);
		girlStand.setFitHeight(211);
		StackPane.setAlignment(girlStand, Pos.CENTER_RIGHT);
		StackPane.setMargin(girlStand, new Insets(0, 25, 0, 0));
		TranslateTransition tt1 = new TranslateTransition();
		tt1.setByY(50);
		tt1.setCycleCount(TranslateTransition.INDEFINITE);
		tt1.setAutoReverse(true);
		tt1.setNode(girlStand);
		tt1.setDuration(Duration.seconds(10));

		gBoard.setFitWidth(490);
		gBoard.setFitHeight(370);
		StackPane.setAlignment(gBoard, Pos.CENTER);
		StackPane.setMargin(gBoard, new Insets(0, 450, 0, 0));

		moonImg.setFitWidth(128);
		moonImg.setFitHeight(116);
		StackPane.setAlignment(moonImg, Pos.BOTTOM_CENTER);
		StackPane.setMargin(moonImg, new Insets(0, 450, 50, 0));
		RotateTransition rotateMoon = new RotateTransition();
		rotateMoon.setByAngle(-360);
		rotateMoon.setDuration(Duration.seconds(20));
		rotateMoon.setCycleCount(RotateTransition.INDEFINITE);
		rotateMoon.setAutoReverse(false);
		rotateMoon.setNode(moonImg);

		coneImg.setFitWidth(77);
		coneImg.setFitHeight(81);
		StackPane.setAlignment(coneImg, Pos.TOP_RIGHT);
		StackPane.setMargin(coneImg, new Insets(50, 50, 0, 0));
		RotateTransition rotateCone = new RotateTransition();
		rotateCone.setByAngle(360);
		rotateCone.setDuration(Duration.seconds(20));
		rotateCone.setCycleCount(RotateTransition.INDEFINITE);
		rotateCone.setAutoReverse(false);
		rotateCone.setNode(coneImg);
		ScaleTransition stc = new ScaleTransition();
		stc.setToX(1.5);
		stc.setToY(1.5);
		stc.setAutoReverse(true);
		stc.setCycleCount(ScaleTransition.INDEFINITE);
		stc.setDuration(Duration.seconds(5));
		stc.setNode(coneImg);

		pyramidImg.setFitWidth(92);
		pyramidImg.setFitHeight(65);
		StackPane.setAlignment(pyramidImg, Pos.BOTTOM_RIGHT);
		StackPane.setMargin(pyramidImg, new Insets(0, 25, 25, 0));
		RotateTransition rotatePyramid = new RotateTransition();
		rotatePyramid.setByAngle(360);
		rotatePyramid.setDuration(Duration.seconds(20));
		rotatePyramid.setCycleCount(RotateTransition.INDEFINITE);
		rotatePyramid.setAutoReverse(false);
		rotatePyramid.setNode(pyramidImg);

		celeImg = new ImageView(Cele);
		celeImg.setFitWidth(338);
		celeImg.setFitHeight(142);
		StackPane.setAlignment(celeImg, Pos.TOP_CENTER);
		StackPane.setMargin(celeImg, new Insets(0, 180, 0, 0));
		Rotate rt = new Rotate(-5);
		celeImg.getTransforms().add(rt);

		ParallelTransition parallelTransition = new ParallelTransition();
		parallelTransition.getChildren().addAll(rotateMoon, stc, rotateCone, rotatePyramid, tt, tt0, tt1);
		parallelTransition.play();

		root.getChildren().addAll(celeImg, lan_button, back, flat, boyStand, girlStand, gBoard, moonImg, coneImg,
				pyramidImg);
	}

	void lan_click() {
		languageChange = !languageChange;
		lan_change();
	}

	private void mathematics() {
		math_in_button = new Button();
		math_in_button.setPrefSize(410, 65);
		math_in_button.getStyleClass().add("category_in_button");

		math_button = new Button();
		math_button.setPrefSize(470, 105);
		math_button.getStyleClass().add("category_button");
		math_button.setGraphic(math_in_button);
		math_button.setOnMouseEntered(e -> {
			math_in_button.setStyle("-fx-background-color: WHITE;");
			if (languageChange) {
				Math.setFill(Color.BLACK);
			} else {
				m_MathB = new ImageView(M_MathB);
				m_MathB.setFitWidth(145);
				m_MathB.setFitHeight(40);
				math_in_button.setGraphic(m_MathB);
			}
		});
		math_button.setOnMouseExited(e -> {
			math_in_button.setStyle("-fx-background-color: BLACK;");
			if (languageChange) {
				Math.setFill(Color.WHITE);
			} else {
				math_in_button.setGraphic(m_Math);
			}
		});
		StackPane.setAlignment(math_button, Pos.CENTER_RIGHT);
		StackPane.setMargin(math_button, new Insets(0, 150, 300, 0));

		math_button.setOnAction(event -> {
			Difficulty d = new Difficulty();
			d.switchToDifficulty(event, languageChange,root);
		});
		root.getChildren().addAll(math_button);
	}

	private void logic() {
		lg_in_button = new Button();
		lg_in_button.setPrefSize(410, 65);
		lg_in_button.getStyleClass().add("category_in_button");

		lg_button = new Button();
		lg_button.setPrefSize(470, 105);
		lg_button.getStyleClass().add("category_button");
		lg_button.setGraphic(lg_in_button);
		lg_button.setOnMouseEntered(e -> {
			lg_in_button.setStyle("-fx-background-color: WHITE;");
			if (languageChange) {
				Logic.setFill(Color.BLACK);
			} else {
				m_LogicB = new ImageView(M_LogicB);
				m_LogicB.setFitWidth(115);
				m_LogicB.setFitHeight(45);
				lg_in_button.setGraphic(m_LogicB);
			}
		});
		lg_button.setOnMouseExited(e -> {
			lg_in_button.setStyle("-fx-background-color: BLACK;");
			if (languageChange) {
				Logic.setFill(Color.WHITE);
			} else {
				lg_in_button.setGraphic(m_Logic);
			}
		});
		StackPane.setAlignment(lg_button, Pos.CENTER_RIGHT);
		StackPane.setMargin(lg_button, new Insets(0, 150, 25, 0));

		lg_button.setOnAction(event -> {
			Difficulty d = new Difficulty();
			d.switchToDifficulty(event, languageChange,root);
			root.getChildren().clear();
		});

		root.getChildren().addAll(lg_button);
	}

	private void iq_test() {
		iq_in_button = new Button();
		iq_in_button.setPrefSize(410, 65);
		iq_in_button.getStyleClass().add("category_in_button");

		iq_button = new Button();
		iq_button.setPrefSize(470, 105);
		iq_button.getStyleClass().add("category_button");
		iq_button.setGraphic(iq_in_button);
		iq_button.setOnMouseEntered(e -> {
			iq_in_button.setStyle("-fx-background-color: WHITE;");
			if (languageChange) {
				IQ.setFill(Color.BLACK);
			} else {
				m_IQB = new ImageView(M_IQB);
				m_IQB.setFitWidth(210);
				m_IQB.setFitHeight(60);
				iq_in_button.setGraphic(m_IQB);
			}
		});
		iq_button.setOnMouseExited(e -> {
			iq_in_button.setStyle("-fx-background-color: BLACK;");
			if (languageChange) {
				IQ.setFill(Color.WHITE);
			} else {
				iq_in_button.setGraphic(m_IQ);
			}
		});
		StackPane.setAlignment(iq_button, Pos.CENTER_RIGHT);
		StackPane.setMargin(iq_button, new Insets(0, 150, -250, 0));
		iq_button.setOnAction(event -> {
			IqQuestions.switchToIqQuestions(event, languageChange,root);
		});

		root.getChildren().addAll(iq_button);
	}

	private void achievement() {
		ach_in_button = new Button();
		ach_in_button.setPrefSize(410, 65);
		ach_in_button.getStyleClass().add("category_in_button");

		ach_button = new Button();
		ach_button.setPrefSize(470, 105);
		ach_button.getStyleClass().add("category_button");
		ach_button.setGraphic(ach_in_button);
		ach_button.setOnMouseEntered(e -> {
			ach_in_button.setStyle("-fx-background-color: WHITE;");
			if (languageChange) {
				Ach.setFill(Color.BLACK);
			} else {
				m_AchB = new ImageView(M_AchB);
				m_AchB.setFitWidth(120);
				m_AchB.setFitHeight(55);
				ach_in_button.setGraphic(m_AchB);
			}
		});
		ach_button.setOnMouseExited(e -> {
			ach_in_button.setStyle("-fx-background-color: BLACK;");
			if (languageChange) {
				Ach.setFill(Color.WHITE);
			} else {
				ach_in_button.setGraphic(m_Ach);
			}
		});
		StackPane.setAlignment(ach_button, Pos.CENTER_RIGHT);
		StackPane.setMargin(ach_button, new Insets(0, 150, -525, 0));

		root.getChildren().addAll(ach_button);
	}

	private void lan_change() {
		if (languageChange) {
			langText.setVisible(false);
			catTextM.setVisible(false);
			m_Math.setVisible(false);
			m_Logic.setVisible(false);
			m_IQ.setVisible(false);
			m_Ach.setVisible(false);

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

			Math = new Text("MATHEMATICS");
			Font Mathematics_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 23);
			Math.setFont(Mathematics_font);
			Math.setFill(Color.WHITE);
			math_in_button.setGraphic(Math);

			Logic = new Text("LOGIC");
			Logic.setFont(Mathematics_font);
			Logic.setFill(Color.WHITE);
			lg_in_button.setGraphic(Logic);

			IQ = new Text("IQ");
			IQ.setFont(Mathematics_font);
			IQ.setFill(Color.WHITE);
			iq_in_button.setGraphic(IQ);

			Ach = new Text("ACHIEVEMENT");
			Ach.setFont(Mathematics_font);
			Ach.setFill(Color.WHITE);
			ach_in_button.setGraphic(Ach);

			catText = new ImageView(CatText);
			catText.setFitWidth(366);
			catText.setFitHeight(271);
			StackPane.setAlignment(catText, Pos.CENTER);
			StackPane.setMargin(catText, new Insets(0, 450, 0, 0));

			root.getChildren().addAll(Lan, catText);
			nonesense = true;
		} else {
			if (nonesense == true) {
				Lan.setVisible(false);
				Math.setVisible(false);
				Logic.setVisible(false);
				IQ.setVisible(false);
				Ach.setVisible(false);
				catText.setVisible(false);
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

			catTextM = new ImageView(CatTextM);
			catTextM.setFitWidth(335);
			catTextM.setFitHeight(290);
			StackPane.setAlignment(catTextM, Pos.CENTER);
			StackPane.setMargin(catTextM, new Insets(0, 450, 0, 0));

			m_Math = new ImageView(M_Math);
			m_Math.setFitWidth(145);
			m_Math.setFitHeight(40);
			math_in_button.setGraphic(m_Math);

			m_Logic = new ImageView(M_Logic);
			m_Logic.setFitWidth(115);
			m_Logic.setFitHeight(45);
			lg_in_button.setGraphic(m_Logic);

			m_IQ = new ImageView(M_IQ);
			m_IQ.setFitWidth(210);
			m_IQ.setFitHeight(60);
			iq_in_button.setGraphic(m_IQ);

			m_Ach = new ImageView(M_Ach);
			m_Ach.setFitWidth(120);
			m_Ach.setFitHeight(55);
			ach_in_button.setGraphic(m_Ach);

			root.getChildren().addAll(langText, catTextM);
		}
	}
}
