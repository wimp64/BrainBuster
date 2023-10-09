package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.stage.Stage;
import javafx.util.Duration;

public class IqOne {
	int Counter = 15;
	int remain_counter = Counter;

	Timeline timeLine;

	Scene scene1;
	Stage currentStage;
	Stage s;
	Scene sc;

	Button back;
	Button yes = new Button();
	Button no = new Button();
	Button timer = new Button();

	Text yesT;
	Text noT;
	Text timeT = new Text();

	Image Lang = new Image("lang.png");
	Image Arrow = new Image("arrow.png");
	Image time = new Image("IqOne/timer.png");
	Image IqOneEng = new Image("IqOne/IqOneTEng.png");
	Image flowerOne = new Image("IqOne/flowerOne.png");
	Image flowerTwo = new Image("IqOne/flowerTwo.png");
	Image flowerG = new Image("IqOne/flowerG.png");
	Image flowerB = new Image("IqOne/flowerB.png");
	Image yesMM = new Image("IqOne/yesMM.png");
	Image noMM = new Image("IqOne/noMM.png");
	Image iqMM = new Image("IqONe/IqOneMM.png");
	
	ImageView backArrow = new ImageView(Arrow);
	ImageView timeImg = new ImageView(time);
	ImageView flowerOneImg = new ImageView(flowerOne);
	ImageView flowerTwoImg = new ImageView(flowerTwo);
	ImageView flowerGImg = new ImageView(flowerG);
	ImageView flowerBImg = new ImageView(flowerB);
	ImageView IqOneEngImg = new ImageView(IqOneEng);
	ImageView yesMMImg = new ImageView(yesMM);
	ImageView noMMImg = new ImageView(noMM);
	ImageView iqOneMMImg = new ImageView(iqMM);
	
	StackPane root;
	StackPane rectangle;
	
	boolean languageChange;// delete true
	boolean nonesense = false;

	public void switchToIqQuestions(ActionEvent event, boolean languageChange,StackPane proot) {
		remain_counter = Counter;
		this.languageChange = languageChange;
		root = new StackPane();
		root.setStyle("-fx-background-color: #F8ABEB");

		elements();
		lan_change();
		Counting();
		// Retrieve the stage from the event source
		currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();

		scene1 = new Scene(root, currentStage.getWidth(), currentStage.getHeight());
		scene1.getStylesheets().add(getClass().getResource("IqQuestion.css").toExternalForm());
		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		currentStage.setScene(scene1);
		currentStage.show();
		proot.getChildren().clear();
	}

	/* This is only for developing part */
//	public void start(Stage primaryStage) throws Exception {
//		root = new StackPane();
//		root.setStyle("-fx-background-color: #F8ABEB");
//		elements();
//		lan_change();
//		Counting();
//		scene1 = new Scene(root, 1366, 766);
//		scene1.getStylesheets().add(getClass().getResource("IqQuestion.css").toExternalForm());
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
		Category cat = new Category();
		back.setOnAction(a -> {
			cat.switchToScene1(a, application.Mathematics.MathResult.scV, languageChange);
			timeLine.stop();
		});
		backArrow.setFitWidth(40);
		backArrow.setFitHeight(30);

		back.setGraphic(backArrow);
		StackPane.setAlignment(back, Pos.TOP_LEFT);
		StackPane.setMargin(back, new Insets(30, 0, 0, 30));// top right bottom left

		rectangle = new StackPane();
		rectangle.setStyle("-fx-background-color:white;" + "-fx-background-radius:25px;");
		rectangle.setMaxWidth(1212);
		StackPane.setMargin(rectangle, new Insets(0, 0, 200, 0));
		rectangle.setMaxHeight(307);


		flowerOneImg.setFitWidth(180);
		flowerOneImg.setFitHeight(128);
		StackPane.setMargin(flowerOneImg, new Insets(400, 1150, 0, 0));

		flowerTwoImg.setFitWidth(145);
		flowerTwoImg.setFitHeight(177);
		StackPane.setMargin(flowerTwoImg, new Insets(400, -1100, 0, 0));

		flowerGImg.setFitWidth(76);
		flowerGImg.setFitHeight(100);
		StackPane.setMargin(flowerGImg, new Insets(650, 700, 0, 0));

		flowerBImg.setFitWidth(75);
		flowerBImg.setFitHeight(100);
		StackPane.setMargin(flowerBImg, new Insets(650, -700, 0, 0));

		yes.getStyleClass().add("yesBut");
		yes.setMaxSize(230, 115);
		yes.setOnAction(e->{
			timeLine.stop();
			IqQuestions.switchToIqQuestions(e, languageChange,root);
		});
		StackPane.setMargin(yes, new Insets(400, 700, 0, 0)); 

		no.getStyleClass().add("noBut");
		no.setMaxSize(230, 115);
		StackPane.setMargin(no, new Insets(400, -700, 0, 0));
		no.setOnAction(e -> {
			IqResultCheck.check();
			timeLine.stop();
			IqQuestions.switchToIqQuestions(e, languageChange,root);		
		});
		
		timeImg.setFitWidth(85);
		timeImg.setFitHeight(100);
		StackPane.setMargin(timeImg, new Insets(400, 100, 0, 0));

		timer.getStyleClass().add("timer");
		timer.setMaxSize(140, 60);
		StackPane.setMargin(timer, new Insets(400, 0, 0, 0));

		root.getChildren().addAll(back, rectangle, yes, no, timer, timeImg, flowerOneImg, flowerTwoImg, flowerGImg,
				flowerBImg);
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
		if (languageChange) {
			IqOneEngImg.setVisible(true);
		
			
			
			yesMMImg.setVisible(false);
			noMMImg.setVisible(false);
			iqOneMMImg.setVisible(false);
			
			Font Yes_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 40);
			yesT = new Text("YES");
			yesT.setVisible(true);
			yesT.setFont(Yes_font);
			yesT.setFill(Color.WHITE);
			yes.setGraphic(yesT);

			noT = new Text("NO");
			noT.setVisible(true);
			noT.setFont(Yes_font);
			noT.setFill(Color.WHITE);
			no.setGraphic(noT);
			
			IqOneEngImg.setFitWidth(1150);
			IqOneEngImg.setFitHeight(200);
			rectangle.getChildren().add(IqOneEngImg);
			
			root.getChildren().addAll();

			nonesense = true;
		} else {
			if (nonesense == true) {
				yesMMImg.setVisible(true);
				noMMImg.setVisible(true);
				iqOneMMImg.setVisible(true);
				
				IqOneEngImg.setVisible(false);
				noT.setVisible(false);
				yesT.setVisible(false);
			}
			yes.setGraphic(yesMMImg);
			no.setGraphic(noMMImg);
			rectangle.getChildren().add(iqOneMMImg);
			root.getChildren().addAll();
		}
	}
}
