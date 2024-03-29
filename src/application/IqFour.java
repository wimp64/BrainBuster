package application;

import application.Mathematics.MathResultCheck;
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

public class IqFour {
	Timeline timeLine;

	int Counter = 15;
	int remain_counter = Counter;

	Scene scene1;
	Stage currentStage;
	Stage s;
	Scene sc;

	Button back;
	Button timer = new Button();
	Button b1 = new Button();
	Button b2 = new Button();
	Button b3 = new Button();
	Button b4 = new Button();

	Text timeT = new Text();
	Text b1T = new Text();
	Text b2T = new Text();
	Text b3T = new Text();
	Text b4T = new Text();
	Text EngT = new Text();
	
	Label quest = new Label();
	Label choose = new Label();

	Image Arrow = new Image("arrow.png");
	Image ruler = new Image("iqFour/ruler.png");
	Image clock = new Image("IqFour/clock.png");
	Image ease = new Image("IqFour/ease.png");
	Image markers = new Image("IqFour/markers.png");
	Image iq4MM = new Image("IqFour/iq4MM.png");
	Image a1 =new Image("IqFour/a1.png");
	Image a2 = new Image("IqFour/a2.png");
	Image a3 = new Image("IqFour/a3.png");
	Image a4 = new Image("IqFour/a4.png");
	Image choMM = new Image("IqFour/cho.png");
	
	ImageView backArrow = new ImageView(Arrow);
	ImageView rulerImg = new ImageView(ruler);
	ImageView clockImg = new ImageView(clock);
	ImageView easeImg = new ImageView(ease);
	ImageView markersImg = new ImageView(markers);
	ImageView iq4MMImg = new ImageView(iq4MM);
	ImageView a1Img = new ImageView(a1);
	ImageView a2Img = new ImageView(a2);
	ImageView a3Img = new ImageView(a3);
	ImageView a4Img = new ImageView(a4);
	ImageView choMMImg = new ImageView(choMM);
	
	StackPane root;
	StackPane rectangle;
	StackPane recS;

	boolean languageChange;// delete true
	boolean nonesense = false;

	public void switchToIqQuestions(ActionEvent event, boolean languageChange,StackPane proot) {
		remain_counter = Counter;
		this.languageChange = languageChange;
		root = new StackPane();
		root.setStyle("-fx-background-color: #F0F5FF");

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
//		root.setStyle("-fx-background-color: #F0F5FF");
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

		StackPane.setAlignment(quest, Pos.CENTER_LEFT);
		StackPane.setMargin(quest, new Insets(0, 0, 0, 100));

		recS = new StackPane();
		recS.setStyle("-fx-background-color:#FF4444");
		recS.setMaxWidth(300);
		StackPane.setMargin(recS, new Insets(0, 0, 400, 704));
		recS.setMaxHeight(52);

		rectangle = new StackPane();
		rectangle.setStyle("-fx-background-color:#124BFF;" + "-fx-background-radius:25px;");
		rectangle.setMaxWidth(356);
		StackPane.setMargin(rectangle, new Insets(0, 0, 0, 700));
		rectangle.setMaxHeight(356);

		b1.setMaxSize(155, 77);
		b1.getStyleClass().add("b_hover");
		StackPane.setAlignment(b1, Pos.TOP_LEFT);
		StackPane.setMargin(b1, new Insets(25, 0, 0, 25));
		b1.setOnAction(e -> {
			IqQuestions.switchToIqQuestions(e, languageChange,root);
			timeLine.stop();
			rectangle.getChildren().clear();
			recS.getChildren().clear();
		});
		b2.setMaxSize(155, 77);
		b2.getStyleClass().add("strange_b");
		StackPane.setAlignment(b2, Pos.CENTER_LEFT);
		StackPane.setMargin(b2, new Insets(0, 0, 0, 25));
		b2.setOnAction(e -> {
			IqQuestions.switchToIqQuestions(e, languageChange,root);
			timeLine.stop();
			rectangle.getChildren().clear();
			recS.getChildren().clear();
		});
		
		b3.setMaxSize(83, 77);
		b3.getStyleClass().add("b_hover");
		StackPane.setAlignment(b3, Pos.CENTER_RIGHT);
		StackPane.setMargin(b3, new Insets(0, 25, 0, 0));
		b3.setOnAction(e -> {
			IqQuestions.switchToIqQuestions(e, languageChange,root);
			timeLine.stop();
			rectangle.getChildren().clear();
			recS.getChildren().clear();
		});
		
		b4.setMaxSize(83, 77);
		b4.setOnAction(e -> {
			IqResultCheck.check();
			timeLine.stop();
			IqQuestions.switchToIqQuestions(e, languageChange,root);
			rectangle.getChildren().clear();
			recS.getChildren().clear();
		});
		b4.getStyleClass().add("b_hover");
		StackPane.setAlignment(b4, Pos.BOTTOM_CENTER);
		StackPane.setMargin(b4, new Insets(0, 0, 25, 0));

		rectangle.getChildren().addAll(b1, b2, b3, b4);

		clockImg = new ImageView(clock);
		clockImg.setFitWidth(90);
		clockImg.setFitHeight(100);
		StackPane.setMargin(clockImg, new Insets(0, 100, -450, 0));

		timer.getStyleClass().add("timerF");
		timer.setMaxSize(140, 60);
		StackPane.setMargin(timer, new Insets(0, 0, -450, 0));

		StackPane.setAlignment(rulerImg, Pos.TOP_CENTER);
		StackPane.setMargin(rulerImg, new Insets(50, 0, 0, 0));
		StackPane.setAlignment(easeImg, Pos.BOTTOM_RIGHT);

		StackPane.setAlignment(markersImg, Pos.BOTTOM_LEFT);

		root.getChildren().addAll(recS, back, rectangle, rulerImg, easeImg, markersImg, timer, clockImg);
	}

	void lan_click() {
		languageChange = !languageChange;
		lan_change();
	}

	void Counting() {
		Button auto = new Button();
		auto.setOnAction(e -> {
			IqQuestions.switchToIqQuestions(e, languageChange,root);
			timeLine.stop();
			rectangle.getChildren().clear();
		});
		auto.setVisible(false);
		root.getChildren().add(auto);
		Font Mathematics_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 30);
		timeT.setFont(Mathematics_font);
		timeT.setFill(Color.WHITE);
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
				auto.fire();
			}
		}));
		timeLine.setCycleCount(Counter);
		timeLine.play();
	}

	private void lan_change() {
		if (languageChange) {
			iq4MMImg.setVisible(false);
			choMMImg.setVisible(false);
			a1Img.setVisible(false);
			a2Img.setVisible(false);
			a3Img.setVisible(false);
			a4Img.setVisible(false);
			
			EngT.setVisible(true);
			b1T.setVisible(true);
			b2T.setVisible(true);
			b3T.setVisible(true);
			b4T.setVisible(true);
			choose.setVisible(true);
			
			EngT.setText("Solve\n" + "\t3 x (8 + 4) - 6 / 2");
			Font quest_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 55);
			EngT.setFont(quest_font);
			EngT.setFill(Color.web("#124BFF"));
			quest.setGraphic(EngT);
			
			choose.setText("Choose Answer:");
			Font choose_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 35);
			choose.setFont(choose_font);
			choose.setTextFill(Color.BLACK);
			recS.getChildren().add(choose);

			b1T.setText("140");
			Font b_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 40);
			b1T.setFont(b_font);
			b1T.setFill(Color.web("#FF4444"));
			b1.setGraphic(b1T);

			b2T.setText("225");
			b2T.setFill(Color.web("#FF4444"));
			b2T.setFont(b_font);
			b2.setGraphic(b2T);

			b3T.setText("14");
			b3T.setFill(Color.web("#FF4444"));
			b3T.setFont(b_font);
			b3.setGraphic(b3T);

			b4T.setText("33");
			b4T.setFill(Color.web("#FF4444"));
			b4T.setFont(b_font);
			b4.setGraphic(b4T);

			root.getChildren().addAll(quest);
			nonesense = true;
		} else {
			if (nonesense == true) {
				iq4MMImg.setVisible(true);
				choMMImg.setVisible(true);
				a1Img.setVisible(true);
				a2Img.setVisible(true);
				a3Img.setVisible(true);
				a4Img.setVisible(true);
				
				EngT.setVisible(false);
				b1T.setVisible(false);
				b2T.setVisible(false);
				b3T.setVisible(false);
				b4T.setVisible(false);
				choose.setVisible(false);
			}
			quest.setGraphic(iq4MMImg);
			recS.getChildren().add(choMMImg);
			b1.setGraphic(a1Img);
			b2.setGraphic(a2Img);
			b3.setGraphic(a3Img);
			b4.setGraphic(a4Img);
			
			root.getChildren().addAll(quest);
		}
	}
}
