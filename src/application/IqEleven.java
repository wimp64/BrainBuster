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

public class IqEleven{
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
	Button submit = new Button();

	Text Myanmar;
	Text English;
	Text Lan;
	Text timeT = new Text();
	Text submitT = new Text();

	Label two = new Label();
	Label five = new Label();
	Label ten = new Label();
	Label seventeen = new Label();
	Label quest = new Label();

	Image Lang = new Image("lang.png");
	Image Arrow = new Image("arrow.png");
	Image lightbulb = new Image("IqEleven/lightbulb.png");
	Image bottom = new Image("IqEleven/bottom.png");
	Image clock = new Image("IqEleven/clock.png");
	Image haha = new Image("IqEleven/haha.png");
	Image pen = new Image("IqEleven/pen.png");

	ImageView langText = new ImageView(Lang);
	ImageView backArrow = new ImageView(Arrow);
	ImageView lightbulbImg = new ImageView(lightbulb);
	ImageView bottomImg = new ImageView(bottom);
	ImageView clockImg = new ImageView(clock);
	ImageView hahaImg = new ImageView(haha);
	ImageView penImg = new ImageView(pen);

	TextField ans = new TextField();

	StackPane root;
	StackPane rectangle;

	boolean languageChange=true;// delete true
	boolean nonesense = false;

	public void switchToIqQuestions(ActionEvent event, boolean languageChange,StackPane proot) {
		remain_counter = Counter;
		this.languageChange = languageChange;
		root = new StackPane();
		root.setStyle("-fx-background-color: #39385B");

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
//		root.setStyle("-fx-background-color: #39385B");
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
		rectangle.setStyle("-fx-background-color:white;" + "-fx-background-radius:25px;");
		rectangle.setMaxWidth(950);
		StackPane.setMargin(rectangle, new Insets(0, 0, 200, 0));
		rectangle.setMaxHeight(87);

		Rotate rt = new Rotate(180 + 90 +75, 0, 0);
		two.getTransforms().add(rt);
		StackPane.setMargin(two, new Insets(200, 700, 0, 0));

		Rotate rt1 = new Rotate(25, 0, 0);
		five.getTransforms().add(rt1);
		StackPane.setMargin(five, new Insets(200, 300, 0, 0));

		StackPane.setMargin(ten, new Insets(100, 0, 0, 0));

		Rotate rt2 = new Rotate(180 + 90 + 75, 0, 0);
		seventeen.getTransforms().add(rt2);
		StackPane.setMargin(seventeen, new Insets(200, -400, 0, 0));

		ans.setMaxWidth(90);
		ans.setMaxHeight(90);
		Platform.runLater(() -> {
			ans.requestFocus();
			ans.positionCaret(0);
		});
		ans.getStyleClass().add("ansText");
		TextFormatter<Integer> tf = new TextFormatter<>(new IntegerStringConverter(), null, change -> {
			String newText = change.getControlNewText();
			if (newText.matches("\\d{0,2}")) {
				return change;
			}
			return null;
		});
		ans.setAlignment(Pos.CENTER_RIGHT);
		ans.setTextFormatter(tf);
		StackPane.setMargin(ans, new Insets(180, -800, 0, 0));

		submit.getStyleClass().add("subBut");
		submitT.setFill(Color.BLACK);
		submit.setOnMouseEntered(e -> {
			submitT.setFill(Color.WHITE);
		});
		submit.setOnMouseExited(e -> {
			submitT.setFill(Color.BLACK);
		});
		submit.setMaxSize(125, 50);
		StackPane.setMargin(submit, new Insets(350, -800, 0, 0));
		submit.setOnAction(e -> {
			String eq = ans.getText();
			if(eq.equals("25")) {
				IqResultCheck.check();
			}
			timeLine.stop();
			IqQuestions.switchToIqQuestions(e, languageChange,root);
		});
		lightbulbImg = new ImageView(lightbulb);
		StackPane.setAlignment(lightbulbImg, Pos.TOP_RIGHT);
		StackPane.setMargin(lightbulbImg, new Insets(100,150,0,0));

		bottomImg = new ImageView(bottom);
		StackPane.setAlignment(bottomImg, Pos.TOP_LEFT);
		StackPane.setMargin(bottomImg, new Insets(200, 0, 0, 50));

		clockImg = new ImageView(clock);
		clockImg.setFitWidth(90);
		clockImg.setFitHeight(100);
		StackPane.setMargin(clockImg, new Insets(0, 100, 450, 0));

		timer.getStyleClass().add("timer");
		timer.setMaxSize(140, 60);
		StackPane.setMargin(timer, new Insets(0, 0, 450, 0));

		hahaImg = new ImageView(haha);
		StackPane.setAlignment(hahaImg, Pos.BOTTOM_RIGHT);

		penImg = new ImageView(pen);
		StackPane.setAlignment(penImg, Pos.BOTTOM_LEFT);
		StackPane.setMargin(penImg, new Insets(0, 0, 100, 100));

		root.getChildren().addAll(lan_button, back, rectangle, ans, lightbulbImg, bottomImg, hahaImg, penImg,
				submit, timer, clockImg);
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

			two.setText("1");
			Font num_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 80);
			two.setFont(num_font);
			two.setTextFill(Color.WHITE);

			five.setText("4");
			five.setFont(num_font);
			five.setTextFill(Color.WHITE);

			ten.setText("9");
			ten.setFont(num_font);
			ten.setTextFill(Color.WHITE);

			seventeen.setText("16");
			seventeen.setFont(num_font);
			seventeen.setTextFill(Color.WHITE);

			quest.setText("Identify the next number in the sequence:");
			Font quest_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 40);
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
			root.getChildren().addAll(Lan, two, five, ten, seventeen);
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
