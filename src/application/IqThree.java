package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class IqThree {
	Timeline timeLine;

	int Counter = 15;
	int remain_counter = Counter;

	Scene scene1;
	Stage currentStage;
	Stage s;
	Scene sc;

	Button back;
	Button lan_button;
	Button timer = new Button();
	Button John = new Button();
	Button Mark = new Button();
	Button Alex = new Button();

	Text Myanmar;
	Text English;
	Text Lan;
	Text timeT = new Text();
	Text JohnT = new Text();
	Text MarkT = new Text();
	Text AlexT = new Text();

	Label quest = new Label();

	Image Lang = new Image("lang.png");
	Image Arrow = new Image("arrow.png");
	Image graffi = new Image("IqThree/graffi.png");
	Image clock = new Image("IqTwo/clock.png");
	Image twoBoys = new Image("IqThree/twoBoys.png");
	Image girl = new Image("IqThree/girl.png");

	ImageView langText = new ImageView(Lang);
	ImageView backArrow = new ImageView(Arrow);
	ImageView graffiImg = new ImageView(graffi);
	ImageView clockImg = new ImageView(clock);
	ImageView twoBoysImg = new ImageView(twoBoys);
	ImageView girlImg = new ImageView(girl);

	StackPane root;
	StackPane rectangle;

	boolean languageChange;// delete true
	boolean nonesense = false;

	public void switchToIqQuestions(ActionEvent event, boolean languageChange) {
		this.languageChange = languageChange;
		root = new StackPane();
		root.setStyle("-fx-background-color: #F79630");

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
//		root.setStyle("-fx-background-color: #F79630");
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

		lan_button = new Button();
		lan_button.setPrefSize(78, 39);
		lan_button.getStyleClass().add("lets_start");
		StackPane.setAlignment(lan_button, Pos.TOP_LEFT);
		StackPane.setMargin(lan_button, new Insets(100, 0, 0, 210));
		lan_button.setOnAction(e -> lan_click());

		rectangle = new StackPane();
		rectangle.setStyle("-fx-background-color:WHITE;" + "-fx-background-radius:25px;");
		rectangle.setMaxWidth(1160);
		StackPane.setMargin(rectangle, new Insets(0, 0, 200, 0));
		rectangle.setMaxHeight(170);

		John.setMaxSize(257, 87);
		StackPane.setMargin(John, new Insets(150, 750, 0, 0));
		John.getStyleClass().add("Ez_Btn");
		John.setOnAction(e -> {
			IqQuestions.switchToIqQuestions(e, languageChange);
			timeLine.stop();
		});

		Mark.setMaxSize(257, 87);
		StackPane.setMargin(Mark, new Insets(150, 0, 0, 0));
		Mark.getStyleClass().add("Nm_Btn");
		Mark.setOnAction(e -> {
			IqQuestions.switchToIqQuestions(e, languageChange);
			timeLine.stop();
		});

		Alex.setMaxSize(257, 87);
		StackPane.setMargin(Alex, new Insets(150, 0, 0, 750));
		Alex.getStyleClass().add("Df_Btn");
		Alex.setOnAction(e -> {
			IqQuestions.switchToIqQuestions(e, languageChange);
			timeLine.stop();
		});

		clockImg = new ImageView(clock);
		clockImg.setFitWidth(90);
		clockImg.setFitHeight(100);
		StackPane.setMargin(clockImg, new Insets(0, 100, -450, 0));

		timer.getStyleClass().add("timer");
		timer.setMaxSize(140, 60);
		StackPane.setMargin(timer, new Insets(0, 0, -450, 0));

		StackPane.setAlignment(graffiImg, Pos.TOP_RIGHT);

		StackPane.setAlignment(twoBoysImg, Pos.BOTTOM_RIGHT);

		StackPane.setAlignment(girlImg, Pos.BOTTOM_LEFT);

		root.getChildren().addAll(John, Alex, Mark, lan_button, back, rectangle, graffiImg, twoBoysImg, girlImg, timer,
				clockImg);
	}

	void lan_click() {
		languageChange = !languageChange;
		lan_change();
	}

	void Counting() {
		Font Mathematics_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 30);
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
				John.fire();
			}
		}));
		timeLine.setCycleCount(Counter);
		timeLine.play();
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

			quest.setText("If John is taller than Mark, and Mark is shorter than Alex, \r\n"
					+ "\t\t\twho is the shortest among the three?");
			Font quest_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 35);
			quest.setFont(quest_font);
			rectangle.getChildren().add(quest);

			JohnT.setText("John");
			Font person_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 40);
			JohnT.setFill(Color.WHITE);
			JohnT.setFont(person_font);
			John.setGraphic(JohnT);

			MarkT.setText("Mark");
			MarkT.setFill(Color.WHITE);
			MarkT.setFont(person_font);
			Mark.setGraphic(MarkT);

			AlexT.setText("Alex");
			AlexT.setFill(Color.WHITE);
			AlexT.setFont(person_font);
			Alex.setGraphic(AlexT);

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

			root.getChildren().addAll(langText);
		}
	}
}
