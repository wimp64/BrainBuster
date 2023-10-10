package application;

import application.Mathematics.MathResultCheck;
import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
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

public class IqEighteen{
	Timeline timeLine;

	int Counter = 25;
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
	
	Text timeT = new Text();
	Text b1T = new Text();
	Text b2T = new Text();
	Text b3T = new Text();
	
	Image Arrow = new Image("arrow.png");
	Image clock = new Image("IqEighteen/clock.png");
	Image river = new Image("IqEighteen/river.png");
	Image boat = new Image("IqEighteen/boat.png");
	Image quesEng = new Image("IqEighteen/quesEng.png");
	
	ImageView backArrow = new ImageView(Arrow);
	ImageView clockImg = new ImageView(clock);
	ImageView boatImg = new ImageView(boat);
	ImageView riverImg = new ImageView(river);
	ImageView quesEngImg = new ImageView(quesEng);
	ImageView iq18MMImg = new ImageView(new Image("IqEighteen/iq18MM.png"));
	ImageView a1Img = new ImageView(new Image("IqEighteen/a1.png"));
	ImageView a2Img = new ImageView(new Image("IqEighteen/a2.png"));
	ImageView a3Img = new ImageView(new Image("IqEighteen/a3.png"));
	
	StackPane root;
	
	TranslateTransition tt2 = new TranslateTransition(Duration.seconds(5), boatImg);
	SequentialTransition sq;
	
	boolean languageChange;
	boolean nonesense = false;

	public void switchToDifficulty(ActionEvent event, boolean languageChange,StackPane proot) {
		remain_counter = Counter;
		this.languageChange = languageChange;
		root = new StackPane();
		root.setStyle("-fx-background-color: #6B5F11");
		
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
	
	/*This is only for developing part*/
//	public void start(Stage primaryStage) throws Exception {
//		root = new StackPane();
//		root.setStyle("-fx-background-color: #6B5F11");
//		
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
	/*This is only for developing part*/

	private void elements() {
		back = new Button();
		back.getStyleClass().add("lets_start");
		back.setPrefSize(60, 60);
		back.setOnAction(a -> {
			Category cat = new Category();
			cat.switchToScene1(a, application.Mathematics.MathResult.scV, languageChange);
			timeLine.stop();
			sq.stop();
			boatImg.setTranslateX(0);
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
		
		StackPane.setMargin(boatImg, new Insets(400, 900, 0, 0));
		
		StackPane.setMargin(riverImg, new Insets(450, 0, 0, 0));
		
		StackPane.setMargin(quesEngImg, new Insets(0,0,300,0));
		StackPane.setMargin(iq18MMImg, new Insets(0,0,300,0));
		StackPane.setMargin(b1, new Insets(100,500,0,0));
		StackPane.setMargin(b2, new Insets(100,0,0,0));
		StackPane.setMargin(b3, new Insets(100,-500,0,0));
		
		b1.setMaxSize(230, 66);
		b1.setOnAction(e->{
			timeLine.stop();
			IqQuestions.switchToIqQuestions(e, languageChange,root);
			sq.stop();
			boatImg.setTranslateX(0);
		});
		b2.setMaxSize(230, 66);
		b2.setOnAction(e->{
			timeLine.stop();
			IqResultCheck.check();
			IqQuestions.switchToIqQuestions(e, languageChange,root);
			sq.stop();
			boatImg.setTranslateX(0);
		});
		b3.setMaxSize(230, 66);
		b3.setOnAction(e->{
			timeLine.stop();
			IqQuestions.switchToIqQuestions(e, languageChange,root);
			sq.stop();
			boatImg.setTranslateX(0);
		});
		b1.getStyleClass().add("bButFift");
		b2.getStyleClass().add("bButFift");
		b3.getStyleClass().add("bButFift");
		
		tt2.setFromX(0);
		ScaleTransition st0 = new ScaleTransition(Duration.millis(1), boatImg);
		st0.setToX(1);
		tt2.setByX(900);
		
		ScaleTransition st1 = new ScaleTransition(Duration.millis(1), boatImg);
		st1.setToX(-1);
		
		TranslateTransition tt3 = new TranslateTransition(Duration.seconds(5), boatImg);
		tt3.setByX(-900);

		sq = new SequentialTransition();
		sq.getChildren().addAll(st0,tt2, st1, tt3);
		sq.setCycleCount(SequentialTransition.INDEFINITE);
		sq.setNode(boatImg);
		sq.play();
		root.getChildren().addAll( back,riverImg,boatImg,b1,b2,b3);
	}

	void lan_click() {
		languageChange = !languageChange;
		lan_change();
	}
	void Counting() {
		Button over = new Button();
		over.setOnAction(e->{
			timeLine.stop();
			IqQuestions.switchToIqQuestions(e, languageChange,root);
			sq.stop();
			boatImg.setTranslateX(0);
		});
		over.setVisible(false);
		root.getChildren().add(over);
		clockImg = new ImageView(clock);
		StackPane.setMargin(clockImg, new Insets(0, 100, 300, 900));

		timer.getStyleClass().add("timer");
		timer.setMaxSize(140, 60);
		StackPane.setMargin(timer, new Insets(0, 0, 300, 900));
		timeT.setFill(Color.BLACK);
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
				over.fire();
			}
		}));
		timeLine.setCycleCount(Counter);
		timeLine.play();
		
		root.getChildren().addAll(timer,clockImg);
	}
	
	private void lan_change() {
		if (languageChange) {
			b1T.setVisible(true);
			b2T.setVisible(true);
			b3T.setVisible(true);
			quesEngImg.setVisible(true);
			iq18MMImg.setVisible(false);
			a1Img.setVisible(false);
			a2Img.setVisible(false);
			a3Img.setVisible(false);
			Font quest_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 30);
			
			b1T.setText("More");
			b1T.setFont(quest_font);
			b1T.setFill(Color.WHITE);
			b1.setGraphic(b1T);
			
			b2T.setText("Less");
			b2T.setFont(quest_font);
			b2T.setFill(Color.WHITE);
			b2.setGraphic(b2T);
			
			b3T.setText("Same");
			b3T.setFont(quest_font);
			b3T.setFill(Color.WHITE);
			b3.setGraphic(b3T);
			
			root.getChildren().addAll(quesEngImg);

			nonesense = true;
		} else {
			if (nonesense == true) {
				b1T.setVisible(false);
				b2T.setVisible(false);
				b3T.setVisible(false);
				quesEngImg.setVisible(false);
				iq18MMImg.setVisible(true);
				a1Img.setVisible(true);
				a2Img.setVisible(true);
				a3Img.setVisible(true);
			}
			b1.setGraphic(a1Img);
			b2.setGraphic(a2Img);
			b3.setGraphic(a3Img);
			
			root.getChildren().addAll(iq18MMImg);
		}
	}
}
