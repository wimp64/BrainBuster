package application;

import application.Mathematics.MathResultCheck;
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

public class IqSeventeen{
	Timeline timeLine;

	int Counter = 13;
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
	Text a1T = new Text();
	Text a2T = new Text();
	Text a3T = new Text();
	Text a4T = new Text();
	Text EngT = new Text();
	
	Label two = new Label();
	Label five = new Label();
	Label ten = new Label();
	Label seventeen = new Label();
	Label quest = new Label();

	Image Arrow = new Image("arrow.png");
	Image book3 = new Image("IqSeventeen/book3.png");
	Image clock = new Image("IqSeventeen/clock.png");
	Image book2 = new Image("IqSeventeen/book2.png");
	Image book1 = new Image("IqSeventeen/book1.png");

	ImageView backArrow = new ImageView(Arrow);
	ImageView book3Img = new ImageView(book3);
	ImageView clockImg = new ImageView(clock);
	ImageView book2Img = new ImageView(book2);
	ImageView book1Img = new ImageView(book1);
	ImageView iq10MMImg = new ImageView(new Image("IqSeventeen/iq17MM.png"));
	ImageView a1Img = new ImageView(new Image("IqSeventeen/a1.png"));
	ImageView a2Img = new ImageView(new Image("IqSeventeen/a2.png"));
	ImageView a3Img = new ImageView(new Image("IqSeventeen/a3.png"));
	ImageView a4Img = new ImageView(new Image("IqSeventeen/a4.png"));
	
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
		root.setStyle("-fx-background-color: #15555D");

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
//		root.setStyle("-fx-background-color: #15555D");
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
			cat.switchToScene1(a, application.Mathematics.MathResult.scV, languageChange);
			timeLine.stop();
			rt.setAngle(0);
			rt1.setAngle(0);
			rt2.setAngle(0);
			rectangle.getChildren().clear();
			MathResultCheck.correct=0;
			MathResultCheck.percent=0;
			MathResultCheck.result=0;
			IqQuestions.point=-1;
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
			if(a.equals("15")) {
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
		Font ans_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 36);
		ans.setFont(ans_font);

		submitT.setText("Submit");
		submit.setGraphic(submitT);
		Font sub_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 26);
		submitT.setFont(sub_font);
		
		quest = new Label();
		if (languageChange) {
			
			iq10MMImg.setVisible(false);
			a1Img.setVisible(false);
			a2Img.setVisible(false);
			a3Img.setVisible(false);
			a4Img.setVisible(false);
			
			EngT.setVisible(true);
			a1T.setVisible(true);
			a2T.setVisible(true);
			a3T.setVisible(true);
			a4T.setVisible(true);
			
			
			Font num_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 80);
			a1T.setText("3");
			a1T.setFill(Color.WHITE);
			a2T.setText("6");
			a2T.setFill(Color.WHITE);
			a3T.setText("9");
			a3T.setFill(Color.WHITE);
			a4T.setText("12");
			a4T.setFill(Color.WHITE);
			a1T.setFont(num_font);
			a2T.setFont(num_font);
			a3T.setFont(num_font);
			a4T.setFont(num_font);
			
			two.setGraphic(a1T);

			five.setGraphic(a2T);
		
			ten.setGraphic(a3T);

			seventeen.setGraphic(a4T);
			
			EngT.setText("Which number comes next:");
			quest.setGraphic(EngT);
			Font quest_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 35);
			EngT.setFont(quest_font);
			EngT.setFill(Color.BLACK);
			rectangle.getChildren().add(quest);

			root.getChildren().addAll( two, five, ten, seventeen);
			nonesense = true;
		} else {
			if (nonesense == true) {
				iq10MMImg.setVisible(true);
				a1Img.setVisible(true);
				a2Img.setVisible(true);
				a3Img.setVisible(true);
				a4Img.setVisible(true);
				
				EngT.setVisible(false);
				a1T.setVisible(false);
				a2T.setVisible(false);
				a3T.setVisible(false);
				a4T.setVisible(false);
				
			}
			quest.setGraphic(iq10MMImg);
			two.setGraphic(a1Img);
			five.setGraphic(a2Img);
			ten.setGraphic(a3Img);
			seventeen.setGraphic(a4Img);
			rectangle.getChildren().add(iq10MMImg);
			root.getChildren().addAll(two,five,ten,seventeen);
		}
	}
}
