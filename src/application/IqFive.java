package application;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.converter.IntegerStringConverter;

public class IqFive {
	Timeline timeLine;

	int Counter = 25;
	int remain_counter = Counter;

	Scene scene1;
	Stage currentStage;
	Stage s;
	Scene sc;

	Button back;
	Button timer = new Button();
	Button submit = new Button();

	Text timeT = new Text();
	Text submitT = new Text();

	Label quest = new Label();
	Label miles = new Label();
	Label awardT = new Label();

	Image Arrow = new Image("arrow.png");
	Image clock = new Image("IqFive/clock.png");
	Image road = new Image("IqFive/road.png");
	Image car = new Image("IqFive/car2.png");
	Image w1 = new Image("IqFive/wheel.png");
	Image w2 = new Image("IqFive/wheel.png");
	Image clouds = new Image("IqFive/clouds.png");
	Image eaistein = new Image("Profile/eaistein.png");
	Image cele1 = new Image("IqFive/cele1.png");
	Image cele2 = new Image("IqFive/cele2.png");

	ImageView backArrow = new ImageView(Arrow);
	ImageView clockImg = new ImageView(clock);
	ImageView roadImg = new ImageView(road);
	ImageView carImg = new ImageView(car);
	ImageView w1Img = new ImageView(w1);
	ImageView w2Img = new ImageView(w2);
	ImageView cloudsImg = new ImageView(clouds);
	ImageView eaisteinImg = new ImageView(eaistein);
	ImageView cele1Img = new ImageView(cele1);
	ImageView cele2Img = new ImageView(cele2);

	TextField ans = new TextField();

	StackPane root;
	StackPane noti;

	boolean languageChange;// delete true
	boolean nonesense = false;

	public void switchToIqQuestions(ActionEvent event, boolean languageChange) {
		remain_counter = Counter;
		this.languageChange = languageChange;
		root = new StackPane();
		root.setStyle("-fx-background-color: #04345C");
		notification();
		Counting();
		elements();
		lan_change();
		// Retrieve the stage from the event source
		currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();

		scene1 = new Scene(root, currentStage.getWidth(), currentStage.getHeight());
		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		scene1.getStylesheets().add(getClass().getResource("IqQuestion.css").toExternalForm());
		currentStage.setScene(scene1);
		currentStage.show();
	}

	/* This is only for developing part */
//	public void start(Stage primaryStage) throws Exception {
//		root = new StackPane();
//		root.setStyle("-fx-background-color: #04345C");
//		notification();
//		Counting();
//		elements();
//		lan_change();
//		scene1 = new Scene(root, 1366, 766);
//		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//		scene1.getStylesheets().add(getClass().getResource("IqQuestion.css").toExternalForm());
//		primaryStage.setScene(scene1);
//		primaryStage.show();
//	}
//
//	public static void main(String[] args) {
//		launch(args);
//	}
	/* This is only for developing part */

	private void elements() {

		root.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				submit.fire();
			}
		});

		back = new Button();
		back.getStyleClass().add("lets_start");
		back.setPrefSize(60, 60);
		Category cat = new Category();
		back.setOnAction(a -> {
			cat.switchToScene1(a, 1, languageChange);
		});
		backArrow.setFitWidth(40);
		backArrow.setFitHeight(30);

		back.setGraphic(backArrow);
		StackPane.setAlignment(back, Pos.TOP_LEFT);
		StackPane.setMargin(back, new Insets(30, 0, 0, 30));// top right bottom left

		StackPane.setMargin(cloudsImg, new Insets(0, 0, 300, 0));
		cloudsImg.setOpacity(0.85);
		StackPane.setMargin(quest, new Insets(0, 0, 300, 0));
		ans.setMaxWidth(125);
		ans.setMaxHeight(90);
		Platform.runLater(() -> {
			ans.requestFocus();
			ans.positionCaret(0);
		});
		ans.getStyleClass().add("ansText");
		TextFormatter<Integer> tf = new TextFormatter<>(new IntegerStringConverter(), null, change -> {
			String newText = change.getControlNewText();
			if (newText.matches("\\d{0,3}")) {
				return change;
			}
			return null;
		});
		ans.setAlignment(Pos.CENTER_RIGHT);
		ans.setTextFormatter(tf);
		StackPane.setMargin(ans, new Insets(200, 0, 0, 0));
		StackPane.setMargin(miles, new Insets(200, 0, 0, 230));
		submit.getStyleClass().add("subButFive");
		submitT.setFill(Color.WHITE);
		submit.setOnMouseEntered(e -> {
			submitT.setFill(Color.BLACK);
		});
		submit.setOnMouseExited(e -> {
			submitT.setFill(Color.WHITE);
		});
		submit.setMaxSize(125, 50);
		StackPane.setMargin(submit, new Insets(200, 0, 0, 500));
		submit.setOnAction(e -> {
			String input = ans.getText();
			if (!input.isEmpty()) {
				if (Integer.parseInt(input) == 120) {
					showNoti(e);
				}
			} else {
				IqQuestions.switchToIqQuestions(e, languageChange);
			}
			timeLine.stop();
		});

		clockImg = new ImageView(clock);
		clockImg.setFitWidth(80);
		clockImg.setFitHeight(80);
		StackPane.setMargin(clockImg, new Insets(50, 100, 0, 1000));

		timer.getStyleClass().add("timer");
		timer.setMaxSize(140, 60);
		StackPane.setMargin(timer, new Insets(50, 0, 0, 1000));

		StackPane.setMargin(roadImg, new Insets(450, 0, 0, 0));

		StackPane.setMargin(carImg, new Insets(535, 700, 0, 0));

		StackPane.setMargin(w1Img, new Insets(620, 1081, 0, 0));
		StackPane.setMargin(w2Img, new Insets(620, 735, 0, 0));

		RotateTransition rt = new RotateTransition();
		rt.setNode(w1Img);
		rt.setByAngle(360);
		rt.setDuration(Duration.seconds(0.5));
		rt.setAutoReverse(false);
		rt.setCycleCount(RotateTransition.INDEFINITE);
		rt.play();

		RotateTransition rt1 = new RotateTransition();
		rt1.setNode(w2Img);
		rt1.setByAngle(360);
		rt1.setDuration(Duration.seconds(0.6));
		rt1.setAutoReverse(false);
		rt1.setCycleCount(RotateTransition.INDEFINITE);
		rt1.play();

		TranslateTransition tt2 = new TranslateTransition(Duration.seconds(5), carImg);
		tt2.setByX(900);
		TranslateTransition ttw1 = new TranslateTransition(Duration.seconds(5), w1Img);
		ttw1.setByX(900);
		TranslateTransition ttw2 = new TranslateTransition(Duration.seconds(5), w2Img);
		ttw2.setByX(900);

		TranslateTransition tt3 = new TranslateTransition(Duration.seconds(5), carImg);
		tt3.setByX(-900);
		TranslateTransition ttw1R = new TranslateTransition(Duration.seconds(5), w1Img);
		ttw1R.setByX(-900);
		TranslateTransition ttw2R = new TranslateTransition(Duration.seconds(5), w2Img);
		ttw2R.setByX(-900);

		ScaleTransition st1 = new ScaleTransition(Duration.millis(1), carImg);
		st1.setToX(-1);
		TranslateTransition move = new TranslateTransition(Duration.ZERO, carImg);
		move.setByX(-210);
		move.setDelay(Duration.seconds(0.5));
		ParallelTransition stM = new ParallelTransition();
		stM.getChildren().addAll(st1, move);

		FadeTransition stw1 = new FadeTransition(Duration.seconds(0.5), w1Img);
		FadeTransition stw2 = new FadeTransition(Duration.seconds(0.5), w2Img);

		SequentialTransition sq = new SequentialTransition();
		sq.getChildren().addAll(tt2, stM, tt3);
		sq.setCycleCount(SequentialTransition.INDEFINITE);
		sq.setNode(carImg);

		SequentialTransition sqw1 = new SequentialTransition();
		sqw1.getChildren().addAll(ttw1, stw1, ttw1R);
		sqw1.setCycleCount(SequentialTransition.INDEFINITE);
		sqw1.setNode(w1Img);

		SequentialTransition sqw2 = new SequentialTransition();
		sqw2.getChildren().addAll(ttw2, stw2, ttw2R);
		sqw2.setCycleCount(SequentialTransition.INDEFINITE);
		sqw2.setNode(w1Img);

		ParallelTransition parallelTransition = new ParallelTransition();
		parallelTransition.getChildren().addAll(sq, sqw1, sqw2);
		parallelTransition.play();

		root.getChildren().addAll(noti, back, ans, submit, timer, clockImg, roadImg, carImg, w1Img, w2Img, cloudsImg);
		cloudsImg.toBack();
	}

	void flip_image() {

	}

	void lan_click() {
		languageChange = !languageChange;
		lan_change();
	}

	void Counting() {
		Font Mathematics_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 30);
		timeT.setFont(Mathematics_font);
		timeT.setText(Integer.toString(Counter));
		timer.setGraphic(timeT);
		timeLine = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
			remain_counter--;
			timeT.setText(Integer.toString(remain_counter));
			timer.setGraphic(timeT);
			if (remain_counter == 10) {
				timeT.setFill(Color.RED);
			}
			if (remain_counter <= 0) {
				timeLine.stop();
				submit.fire();
			}
		}));
		timeLine.setCycleCount(Counter);
		timeLine.play();
	}

	private void notification() {
		noti = new StackPane();
		noti.setMaxWidth(613);
		noti.setMaxHeight(141);
		StackPane.setAlignment(noti, Pos.TOP_CENTER);
		StackPane.setMargin(noti, new Insets(-200, 0, 0, 0));
		noti.getStyleClass().add("noti");
		noti.setVisible(false);

		Button award = new Button();
		award.setMaxSize(100, 100);
		award.setStyle("-fx-background-color: #FFCC00; -fx-background-radius: 50%;");
		StackPane.setAlignment(award, Pos.CENTER_LEFT);
		StackPane.setMargin(award, new Insets(0, 0, 0, 25));

		eaisteinImg.setFitWidth(55);
		eaisteinImg.setFitHeight(70);
		award.setGraphic(eaisteinImg);

		StackPane.setAlignment(cele1Img, Pos.BOTTOM_LEFT);
		StackPane.setMargin(cele1Img, new Insets(0, 0, 15, 140));

		StackPane.setAlignment(cele2Img, Pos.TOP_RIGHT);
		StackPane.setMargin(cele2Img, new Insets(15, 50, 0, 0));

		noti.getChildren().addAll(award, cele1Img, cele2Img);
	}

	private void showNoti(ActionEvent ea) {
		noti.setVisible(true);
		TranslateTransition down = new TranslateTransition();
		down.setByY(200);
		down.setDuration(Duration.seconds(1));
		down.setNode(noti);

		PauseTransition pause = new PauseTransition();
		pause.setDuration(Duration.seconds(4));

		ScaleTransition shake = new ScaleTransition();
		shake.setNode(noti);
		shake.setToX(0.9);
		shake.setToY(0.9);
		shake.setAutoReverse(true);
		shake.setCycleCount(4);
		shake.setDuration(Duration.seconds(1));

		ParallelTransition pt = new ParallelTransition();
		pt.getChildren().addAll(pause, shake);

		TranslateTransition up = new TranslateTransition();
		up.setByY(-200);
		up.setDuration(Duration.seconds(1));
		up.setNode(noti);

		down.setOnFinished(e -> pt.play());
		pause.setOnFinished(e -> up.play());
		down.play();
		up.setOnFinished(e -> {
			IqQuestions.switchToIqQuestions(ea, languageChange);
		});
	}

	private void lan_change() {
		if (languageChange) {
			Font ans_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 36);
			ans.setFont(ans_font);

			submitT.setText("Submit");
			submit.setGraphic(submitT);
			Font sub_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 26);
			submitT.setFont(sub_font);

			quest.setText("If a car travels at a speed of 60 mph for 2 hours,\n\t\t\thow far does it travel?");
			Font quest_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 36);
			quest.setFont(quest_font);

			miles.setText("miles");
			miles.setFont(sub_font);
			miles.setTextFill(Color.WHITE);

			awardT.setText("Congratulation!\r\n" + " Little Eaistein...");
			Font award_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 26);
			awardT.setFont(award_font);

			noti.getChildren().add(awardT);
			root.getChildren().addAll(quest, miles);
			nonesense = true;
		} else {
			if (nonesense == true) {

			}

			root.getChildren().addAll();
		}
	}
}
