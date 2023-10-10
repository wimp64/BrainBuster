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

public class IqTwo{
	Timeline timeLine;

	int Counter = 20;
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
	Image balloon1 = new Image("IqTwo/balloon1.png");
	Image balloon2 = new Image("IqTwo/balloon2.png");
	Image clock = new Image("IqTwo/clock.png");
	Image girl = new Image("IqTwo/girl.png");
	Image pencil = new Image("IqTwo/pencil.png");
	Image iqTwoMM = new Image("IqTwo/iqTwoMM.png");
	Image a1 = new Image("IqTwo/a1.png");
	Image a2 = new Image("IqTwo/a2.png");
	Image a3 = new Image("IqTwo/a3.png");
	Image a4 = new Image("IqTwo/a4.png");
	
	ImageView backArrow = new ImageView(Arrow);
	ImageView balloon1Img = new ImageView(balloon1);
	ImageView balloon2Img = new ImageView(balloon2);
	ImageView clockImg = new ImageView(clock);
	ImageView girlImg = new ImageView(girl);
	ImageView pencilImg = new ImageView(pencil);
	ImageView iqTwoMMImg = new ImageView(iqTwoMM);
	ImageView a1Img = new ImageView(a1);
	ImageView a2Img = new ImageView(a2);
	ImageView a3Img = new ImageView(a3);
	ImageView a4Img = new ImageView(a4);
	
	TextField ans = new TextField();

	StackPane root;
	StackPane rectangle;

	boolean languageChange;// delete true
	boolean nonesense = false;
	
	Rotate rt;
	Rotate rtM;
	Rotate rt1;
	Rotate rt1M;
	Rotate rt2;
	Rotate rt2M;
	public void switchToIqQuestions(ActionEvent event, boolean languageChange,StackPane proot) {
		remain_counter = Counter;
		this.languageChange = languageChange;
		root = new StackPane();
		root.setStyle("-fx-background-color: #23844C");

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
//		root.setStyle("-fx-background-color: #23844C");
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
		Font ans_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 36);
		ans.setFont(ans_font);
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
			cat.switchToScene1(a, application.Mathematics.MathResult.scV, languageChange);
			timeLine.stop();
			rt.setAngle(0);
			rt1.setAngle(0);
			rt2.setAngle(0);
			rectangle.getChildren().clear();
			IqResultCheck.correct=0;
			IqResultCheck.percent=0;
			IqResultCheck.result=0;
			IqQuestions.point=-1;
		});
		backArrow.setFitWidth(40);
		backArrow.setFitHeight(30);

		back.setGraphic(backArrow);
		StackPane.setAlignment(back, Pos.TOP_LEFT);
		StackPane.setMargin(back, new Insets(30, 0, 0, 30));// top right bottom left

		rectangle = new StackPane();
		rectangle.setStyle("-fx-background-color:black;" + "-fx-background-radius:25px;");
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
			if(a.equals("26")) {
				IqResultCheck.check();
			}
			IqQuestions.switchToIqQuestions(e, languageChange,root);
		});
		balloon1Img = new ImageView(balloon1);
		StackPane.setAlignment(balloon1Img, Pos.TOP_RIGHT);

		balloon2Img = new ImageView(balloon2);
		StackPane.setAlignment(balloon2Img, Pos.TOP_LEFT);
		StackPane.setMargin(balloon2Img, new Insets(200, 0, 0, 0));

		clockImg = new ImageView(clock);
		clockImg.setFitWidth(90);
		clockImg.setFitHeight(100);
		StackPane.setMargin(clockImg, new Insets(0, 100, 450, 0));

		timer.getStyleClass().add("timer");
		timer.setMaxSize(140, 60);
		StackPane.setMargin(timer, new Insets(0, 0, 450, 0));

		girlImg = new ImageView(girl);
		StackPane.setAlignment(girlImg, Pos.BOTTOM_RIGHT);

		pencilImg = new ImageView(pencil);
		StackPane.setAlignment(pencilImg, Pos.BOTTOM_LEFT);
		StackPane.setMargin(pencilImg, new Insets(0, 0, 100, 100));

		root.getChildren().addAll(back, rectangle, ans, balloon1Img, balloon2Img, girlImg, pencilImg,
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
			rectangle.getChildren().clear();
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
			a1Img.setVisible(false);
			a2Img.setVisible(false);
			a3Img.setVisible(false);
			a4Img.setVisible(false);
			iqTwoMMImg.setVisible(false);
			
			EngT.setVisible(true);
			a1T.setVisible(true);
			a2T.setVisible(true);
			a3T.setVisible(true);
			a4T.setVisible(true);
			

			Font num_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 80);
			a1T.setText("2");
			a1T.setFill(Color.WHITE);
			a2T.setText("5");
			a2T.setFill(Color.WHITE);
			a3T.setText("10");
			a3T.setFill(Color.WHITE);
			a4T.setText("17");
			a4T.setFill(Color.WHITE);
			a1T.setFont(num_font);
			a2T.setFont(num_font);
			a3T.setFont(num_font);
			a4T.setFont(num_font);
			
			two.setGraphic(a1T);

			five.setGraphic(a2T);
		
			ten.setGraphic(a3T);

			seventeen.setGraphic(a4T);
			
			EngT.setText("Complete the Sequence:");
			quest.setGraphic(EngT);
			Font quest_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 35);
			EngT.setFont(quest_font);
			EngT.setFill(Color.WHITE);
			rectangle.getChildren().add(quest);


			submitT.setText("Submit");
			submit.setGraphic(submitT);
			Font sub_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 26);
			submitT.setFont(sub_font);
			
			root.getChildren().addAll( two, five, ten, seventeen);
			nonesense = true;
		} else {
			if (nonesense == true) {
				a1Img.setVisible(true);
				a2Img.setVisible(true);
				a3Img.setVisible(true);
				a4Img.setVisible(true);
				iqTwoMMImg.setVisible(true);
				
				EngT.setVisible(false);
				a1T.setVisible(false);
				a2T.setVisible(false);
				a3T.setVisible(false);
				a4T.setVisible(false);
				
			}
			two.setGraphic(a1Img);
			five.setGraphic(a2Img);
			ten.setGraphic(a3Img);
			seventeen.setGraphic(a4Img);
			rectangle.getChildren().add(iqTwoMMImg);
			
			submitT.setText("Submit");
			submit.setGraphic(submitT);
			Font sub_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 26);
			submitT.setFont(sub_font);
			
			root.getChildren().addAll(two,five, ten, seventeen);
		}
	}
}
