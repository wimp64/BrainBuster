package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
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
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.StringConverter;

public class IqFourteen{
	Timeline timeLine;

	int Counter = 22;
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


	Image Arrow = new Image("arrow.png");
	Image rec = new Image("IqFourteen/rec.png");
	Image doodle = new Image("IqFourteen/doodle.png");
	Image clock = new Image("IqFourteen/clock.png");
	Image plus = new Image("IqFourteen/plus.png");
	Image circle = new Image("IqFourteen/circle.png");
	Image ques = new Image("IqFourteen/quesImg.png");
	
	ImageView backArrow = new ImageView(Arrow);
	ImageView recImg = new ImageView(rec);
	ImageView doodleImg = new ImageView(doodle);
	ImageView clockImg = new ImageView(clock);
	ImageView plusImg = new ImageView(plus);
	ImageView circleImg = new ImageView(circle);
	ImageView quesImg = new ImageView(ques);
	
	TextField ans = new TextField();

	StackPane root;
	StackPane rectangle;

	boolean languageChange;// delete true
	boolean nonesense = false;

	public void switchToIqQuestions(ActionEvent event, boolean languageChange,StackPane proot) {
		remain_counter = Counter;
		this.languageChange = languageChange;
		root = new StackPane();
		root.setStyle("-fx-background-color: WHITE");

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
		proot.getChildren().clear();
	}

	/* This is only for developing part */
//	public void start(Stage primaryStage) throws Exception {
//		root = new StackPane();
//		root.setStyle("-fx-background-color: WHITE");
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


		rectangle = new StackPane();
		rectangle.setStyle("-fx-background-color:white;");
		rectangle.setMaxWidth(800);
		StackPane.setMargin(rectangle, new Insets(0, 0, 250, 0));
		rectangle.setMaxHeight(87);

		StackPane.setAlignment(quesImg, Pos.CENTER);
		
		ans.setMaxWidth(90);
		ans.setMaxHeight(90);
		Platform.runLater(() -> {
			ans.requestFocus();
			ans.positionCaret(0);
		});
		ans.getStyleClass().add("ansText");
		StringConverter<String> converter = new StringConverter<String>() {
			public String toString(String s) {
				return s;
			}
			public String fromString(String s) {
				return s;
			}
		};
		TextFormatter<String> tf = new TextFormatter<>(converter, null, change -> {
			String newText = change.getControlNewText();
			if (newText.matches("[ABCDabcd]?")) {
				newText = newText.toUpperCase();
				change.setText(newText);
				return change;
			}
			return null;
		});
		ans.setAlignment(Pos.CENTER);
		ans.setTextFormatter(tf);
		StackPane.setMargin(ans, new Insets(300, 0, 0, 0));

		submit.getStyleClass().add("subButFourteen");
		submitT.setFill(Color.WHITE);
		submit.setOnMouseEntered(e -> {
			submitT.setFill(Color.BLACK);
		});
		submit.setOnMouseExited(e -> {
			submitT.setFill(Color.WHITE);
		});
		submit.setMaxSize(125, 50);
		StackPane.setMargin(submit, new Insets(300, 0, 0, 300));
		submit.setOnAction(e -> {
			String a = ans.getText();
			System.out.println(a);
			if(a.equals("BB") || a.equals("bb") || a.equals("B") || a.equals("b")) {
				IqResultCheck.check();
			}
			timeLine.stop();
			IqQuestions.switchToIqQuestions(e, languageChange,root);
		});
		recImg = new ImageView(rec);
		StackPane.setAlignment(recImg, Pos.TOP_RIGHT);

		doodleImg = new ImageView(doodle);
		StackPane.setAlignment(doodleImg, Pos.BOTTOM_CENTER);
		StackPane.setMargin(doodleImg, new Insets(0, 0, 0, 0));

		clockImg = new ImageView(clock);
		StackPane.setMargin(clockImg, new Insets(0, 0, 565, 0));

		timer.getStyleClass().add("timerFourteen");
		timer.setMaxSize(140, 60);
		StackPane.setMargin(timer, new Insets(0, 0, 450, 0));

		plusImg = new ImageView(plus);
		StackPane.setAlignment(plusImg, Pos.BOTTOM_RIGHT);

		circleImg = new ImageView(circle);
		StackPane.setAlignment(circleImg, Pos.BOTTOM_LEFT);

		root.getChildren().addAll( back, rectangle, ans, recImg, doodleImg, plusImg, circleImg,
				submit, timer,clockImg,quesImg);
	}

	void lan_click() {
		languageChange = !languageChange;
		lan_change();
	}

	void Counting() {
		Button over = new Button();
		over.setOnAction(e->{
			IqQuestions.switchToIqQuestions(e, languageChange,root);
		});
		over.setVisible(false);
		root.getChildren().add(over);
		Font Mathematics_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 30);
		timeT.setFont(Mathematics_font);
		timeT.setText(Integer.toString(Counter));
		timer.setGraphic(timeT);
		timeT.setFill(Color.BLACK);
		timeLine = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
			remain_counter--;
			timeT.setText(Integer.toString(remain_counter));
			timer.setGraphic(timeT);
			if (remain_counter == 10) {
				timeT.setFill(Color.RED);
			}
			if (remain_counter <= 0) {
				timeLine.stop();
				over.fire();
			}
		}));
		timeLine.setCycleCount(Counter);
		timeLine.play();
	}

	private void lan_change() {
		quest = new Label();
		if (languageChange) {
			quest.setText("Which of the following shapes is the odd one out?");
			Font quest_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 30);
			quest.setFont(quest_font);
			quest.setTextFill(Color.BLACK);
			rectangle.getChildren().add(quest);

			Font ans_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 36);
			ans.setFont(ans_font);

			submitT.setText("Submit");
			submit.setGraphic(submitT);
			Font sub_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 26);
			submitT.setFont(sub_font);
			root.setOnKeyPressed(event -> {
				if (event.getCode() == KeyCode.ENTER) {
					submit.fire();
				}
			});
			root.getChildren().addAll();
			nonesense = true;
		} else {
			if (nonesense == true) {

			}


			root.getChildren().addAll();
		}
	}
}
