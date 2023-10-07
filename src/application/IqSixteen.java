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

public class IqSixteen{
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

	Label two = new Label();
	Label five = new Label();
	Label ten = new Label();
	Label seventeen = new Label();
	Label quest = new Label();

	Image Arrow = new Image("arrow.png");
	Image book3 = new Image("IqSixteen/book3.png");
	Image clock = new Image("IqSixteen/clock.png");
	Image book2 = new Image("IqSixteen/book2.png");
	Image book1 = new Image("IqSixteen/book1.png");

	ImageView backArrow = new ImageView(Arrow);
	ImageView book3Img = new ImageView(book3);
	ImageView clockImg = new ImageView(clock);
	ImageView book2Img = new ImageView(book2);
	ImageView book1Img = new ImageView(book1);

	TextField ans = new TextField();

	StackPane root;
	StackPane rectangle;

	boolean languageChange;// delete true
	boolean nonesense = false;
	
	Rotate rt;
	Rotate rt1;
	Rotate rt2;
	public void switchToIqQuestions(ActionEvent event, boolean languageChange,StackPane proot) {
		remain_counter = Counter;
		this.languageChange = languageChange;
		root = new StackPane();
		root.setStyle("-fx-background-color: #0097B2");

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
//		root.setStyle("-fx-background-color: #0097B2");
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
		rectangle.setStyle("-fx-background-color:white;" + "-fx-background-radius:25px;");
		rectangle.setMaxWidth(586);
		StackPane.setMargin(rectangle, new Insets(0, 0, 200, 0));
		rectangle.setMaxHeight(87);

		rt = new Rotate(315, 0, 0);
		two.getTransforms().add(rt);
		StackPane.setMargin(two, new Insets(200, 700, 0, 0));

		rt1 = new Rotate(25, 0, 0);
		five.getTransforms().add(rt1);
		StackPane.setMargin(five, new Insets(200, 300, 0, 0));

		StackPane.setMargin(ten, new Insets(100, 0, 0, 0));

		rt2 = new Rotate(180 + 90 + 75, 0, 0);
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
			timeLine.stop();
			rt.setAngle(0);
			rt1.setAngle(0);
			rt2.setAngle(0);
			String a = ans.getText();
			if(a.equals("29")) {
				IqResultCheck.check();
			}
			IqQuestions.switchToIqQuestions(e, languageChange,root);
		});
		book3Img = new ImageView(book3);
		StackPane.setAlignment(book3Img, Pos.TOP_RIGHT);

		clockImg = new ImageView(clock);
		StackPane.setMargin(clockImg, new Insets(0, 120, 450, 0));

		timer.getStyleClass().add("timer");
		timer.setMaxSize(140, 60);
		StackPane.setMargin(timer, new Insets(0, 0, 450, 0));

		book2Img = new ImageView(book2);
		StackPane.setAlignment(book2Img, Pos.BOTTOM_RIGHT);

		book1Img = new ImageView(book1);
		StackPane.setAlignment(book1Img, Pos.BOTTOM_LEFT);
		
		root.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				submit.fire();
			}
		});
		
		root.getChildren().addAll(back, rectangle, ans, book3Img, book2Img, book1Img,
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
			rt.setAngle(0);
			rt1.setAngle(0);
			rt2.setAngle(0);
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

			two.setText("2");
			Font num_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 80);
			two.setFont(num_font);
			two.setTextFill(Color.WHITE);

			five.setText("6");
			five.setFont(num_font);
			five.setTextFill(Color.WHITE);

			ten.setText("12");
			ten.setFont(num_font);
			ten.setTextFill(Color.WHITE);

			seventeen.setText("20");
			seventeen.setFont(num_font);
			seventeen.setTextFill(Color.WHITE);

			quest.setText("Complete the number series:");
			Font quest_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 35);
			quest.setFont(quest_font);
			quest.setTextFill(Color.BLACK);
			rectangle.getChildren().add(quest);

			Font ans_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 36);
			ans.setFont(ans_font);

			submitT.setText("Submit");
			submit.setGraphic(submitT);
			Font sub_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 26);
			submitT.setFont(sub_font);
			
			root.getChildren().addAll( two, five, ten, seventeen);
			nonesense = true;
		} else {
			if (nonesense == true) {
				
			}
			
			root.getChildren().addAll();
		}
	}
}
