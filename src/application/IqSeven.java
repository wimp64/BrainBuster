package application;

import application.Mathematics.MathResultCheck;
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
import javafx.application.*;
import javafx.scene.control.*;

public class IqSeven extends Application{
	Timeline timeLine;

	int Counter = 30;
	int remain_counter = Counter;
	
	Scene scene1;
	Stage currentStage;
	Stage s;
	Scene sc;

	Button back;
	Button timer = new Button();
	
	StackPane backButtons;
	Button dBut0 = new Button();
	Button dBut1 = new Button();
	Button dBut2 = new Button();
	Button dBut3 = new Button();
	Button dBut4 = new Button();
	Button dBut5 = new Button();
	Button dBut6 = new Button();
	Button dBut7 = new Button();
	Button dBut8 = new Button();
	
	StackPane backButtonsA;
	Button dBut0A = new Button();
	Button dBut1A = new Button();
	Button dBut2A = new Button();
	Button dBut3A = new Button();
	Button dBut4A = new Button();
	Button dBut5A = new Button();
	Button dBut7A = new Button();
	
	Text timeT = new Text();
	Text EngT = new Text();
	Label quest = new Label();
	
	Image Arrow = new Image("arrow.png");
	Image boy = new Image("IqSeven/boy.png");
	Image clock = new Image("IqSix/clock.png");
	Image fruit = new Image("IqSeven/fruit.png");
	Image girl = new Image("IqSeven/girl.png");
	Image Q0 = new Image("IqSeven/Q0.png");
	Image Q1 = new Image("IqSeven/Q1.png");
	Image Q2 = new Image("IqSeven/Q2.png");
	Image Q3 = new Image("IqSeven/Q3.png");
	Image Q4 = new Image("IqSeven/Q4.png");
	Image Q5 = new Image("IqSeven/Q5.png");
	Image Q6 = new Image("IqSeven/Q6.png");
	Image Q7 = new Image("IqSeven/Q7.png");
	Image A5 = new Image("IqSeven/A5.png");
	Image A7 = new Image("IqSeven/A7.png");
	Image Question = new Image("IqSeven/QuestionMark.png");
	Image iq7MM = new Image("IqSeven/iq7MM.png");
	
	ImageView backArrow = new ImageView(Arrow);
	ImageView boyImg = new ImageView(boy);
	ImageView clockImg = new ImageView(clock);
	ImageView fruitImg = new ImageView(fruit);
	ImageView girlImg = new ImageView(girl);
	ImageView Q0Img = new ImageView(Q0);
	ImageView Q1Img = new ImageView(Q1);
	ImageView Q2Img = new ImageView(Q2);
	ImageView Q2AImg = new ImageView(Q2);
	ImageView Q2ACloneImg = new ImageView(Q2);
	ImageView Q3Img = new ImageView(Q3);
	ImageView Q3AImg = new ImageView(Q3);
	ImageView Q3ACloneImg = new ImageView(Q3);
	ImageView Q4Img = new ImageView(Q4);
	ImageView Q4AImg = new ImageView(Q4);
	ImageView Q4ACloneImg = new ImageView(Q4);
	ImageView Q5Img = new ImageView(Q5);
	ImageView Q5AImg = new ImageView(Q5);
	ImageView Q5ACloneImg = new ImageView(Q5);
	ImageView Q6Img = new ImageView(Q6);
	ImageView Q7Img = new ImageView(Q7);
	ImageView Q7AImg = new ImageView(Q7);
	ImageView Q7ACloneImg = new ImageView(Q7);
	ImageView A7Img = new ImageView(A7);
	ImageView A7CloneImg = new ImageView(A7);
	ImageView A5Img = new ImageView(A5);
	ImageView A5CloneImg = new ImageView(A5);
	ImageView QuestionImg = new ImageView(Question);
	ImageView iq7MMImg = new ImageView(iq7MM);
	
	StackPane root;
	StackPane rectangle = new StackPane();
	
	boolean languageChange=true;
	boolean nonesense = false;

	public void switchToIqQuestions(ActionEvent event, boolean languageChange,StackPane proot) {
		remain_counter = Counter;
		this.languageChange = languageChange;
		root = new StackPane();
		root.setStyle("-fx-background-color: #B7B7B7");
		
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
	public void start(Stage primaryStage) throws Exception {
		root = new StackPane();
		root.setStyle("-fx-background-color: #B7B7B7");
		Counting();
		elements();
		lan_change();
		scene1 = new Scene(root, 1366, 766);
		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		scene1.getStylesheets().add(getClass().getResource("IqQuestion.css").toExternalForm());
		primaryStage.setScene(scene1);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	/*This is only for developing part*/

	private void elements() {
		back = new Button();
		back.getStyleClass().add("lets_start");
		back.setPrefSize(60, 60);
		back.setOnAction(a -> {
			Category cat = new Category();
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
		
		rectangle.setStyle("-fx-background-color:WHITE; -fx-background-radius:25px;");
		rectangle.setMaxSize(460, 90);
		StackPane.setMargin(rectangle, new Insets(0,0,550,550));
		backButtons();
		backButtonsA();
		StackPane.setAlignment(boyImg, Pos.BOTTOM_RIGHT);
		StackPane.setAlignment(girlImg, Pos.BOTTOM_LEFT);
		StackPane.setAlignment(fruitImg, Pos.TOP_RIGHT);
		
		root.getChildren().addAll( back,boyImg,girlImg,fruitImg,backButtons,backButtonsA,rectangle);
	}
	void backButtons() {
		backButtons = new StackPane();
		StackPane.setMargin(backButtons, new Insets(0,550,0,0));
		backButtons.setMaxSize(405, 372);
		
		dBut0.setMaxSize(124, 114);
		StackPane.setAlignment(dBut0, Pos.TOP_LEFT);
		
		dBut1.setMaxSize(124, 114);
		StackPane.setAlignment(dBut1, Pos.TOP_CENTER);
		
		dBut2.setMaxSize(124, 114);
		StackPane.setAlignment(dBut2, Pos.TOP_RIGHT);
		
		dBut3.setMaxSize(124, 114);
		StackPane.setAlignment(dBut3, Pos.CENTER_LEFT);
		
		dBut4.setMaxSize(124, 114);
		StackPane.setAlignment(dBut4, Pos.CENTER);
		
		dBut5.setMaxSize(124, 114);
		StackPane.setAlignment(dBut5, Pos.CENTER_RIGHT);
		
		dBut6.setMaxSize(124, 114);
		StackPane.setAlignment(dBut6, Pos.BOTTOM_LEFT);
		
		dBut7.setMaxSize(124, 114);
		StackPane.setAlignment(dBut7, Pos.BOTTOM_CENTER);
		
		dBut8.setMaxSize(124, 114);
		StackPane.setAlignment(dBut8, Pos.BOTTOM_RIGHT);
		
		dBut0.setGraphic(Q0Img);
		dBut1.setGraphic(Q1Img);
		dBut2.setGraphic(Q2Img);
		dBut3.setGraphic(Q3Img);
		dBut4.setGraphic(Q4Img);
		dBut5.setGraphic(Q5Img);
		dBut6.setGraphic(Q6Img);
		dBut7.setGraphic(Q7Img);
		dBut8.setGraphic(QuestionImg);
		
		dBut0.getStyleClass().add("But");
		dBut1.getStyleClass().add("But");
		dBut2.getStyleClass().add("But");
		dBut3.getStyleClass().add("But");
		dBut4.getStyleClass().add("But");
		dBut5.getStyleClass().add("But");
		dBut6.getStyleClass().add("But");
		dBut7.getStyleClass().add("But");
		dBut8.getStyleClass().add("But");
		
		backButtons.getChildren().addAll(dBut0,dBut1,dBut2,dBut3,dBut4,dBut5,dBut6,dBut7,dBut8);
	}
	void backButtonsA() {
		backButtonsA = new StackPane();
		StackPane.setMargin(backButtonsA, new Insets(0,-550,0,0));
		backButtonsA.setMaxSize(405, 372);
		
		dBut0A.setMaxSize(124, 114);
		StackPane.setAlignment(dBut0A, Pos.TOP_LEFT);
		dBut0A.setOnMouseEntered(e->{
			dBut8.setGraphic(Q5ACloneImg);
		});
		dBut0A.setOnMouseExited(e->{
			dBut8.setGraphic(QuestionImg);
		});
		
		dBut1A.setMaxSize(124, 114);
		StackPane.setAlignment(dBut1A, Pos.TOP_CENTER);
		dBut1A.setOnMouseEntered(e->{
			dBut8.setGraphic(Q2ACloneImg);
		});
		dBut1A.setOnMouseExited(e->{
			dBut8.setGraphic(QuestionImg);
		});
		
		dBut2A.setMaxSize(124, 114);
		StackPane.setAlignment(dBut2A, Pos.TOP_RIGHT);
		dBut2A.setOnMouseEntered(e->{
			dBut8.setGraphic(Q3ACloneImg);
		});
		dBut2A.setOnMouseExited(e->{
			dBut8.setGraphic(QuestionImg);
		});
		
		dBut3A.setMaxSize(124, 114);
		StackPane.setAlignment(dBut3A, Pos.CENTER_LEFT);
		dBut3A.setOnMouseEntered(e->{
			dBut8.setGraphic(Q7ACloneImg);
		});
		dBut3A.setOnMouseExited(e->{
			dBut8.setGraphic(QuestionImg);
		});
		
		dBut4A.setMaxSize(124, 114);
		StackPane.setAlignment(dBut4A, Pos.CENTER);
		dBut4A.setOnMouseEntered(e->{
			dBut8.setGraphic(Q4ACloneImg);
		});
		dBut4A.setOnMouseExited(e->{
			dBut8.setGraphic(QuestionImg);
		});
		
		dBut5A.setMaxSize(124, 114);
		StackPane.setAlignment(dBut5A, Pos.CENTER_RIGHT);
		dBut5A.setOnMouseEntered(e->{
			dBut8.setGraphic(A5CloneImg);
		});
		dBut5A.setOnMouseExited(e->{
			dBut8.setGraphic(QuestionImg);
		});
		
		dBut7A.setMaxSize(124, 114);
		StackPane.setAlignment(dBut7A, Pos.BOTTOM_CENTER);
		dBut7A.setOnMouseEntered(e->{
			dBut8.setGraphic(A7CloneImg);
		});
		dBut7A.setOnMouseExited(e->{
			dBut8.setGraphic(QuestionImg);
		});
		dBut7A.setOnAction(e->{
			IqResultCheck.check();
			timeLine.stop();
			rectangle.getChildren().clear();
			IqQuestions.switchToIqQuestions(e, languageChange,root);
		});
		
		dBut0A.setGraphic(Q5AImg);
		dBut0A.setOnAction(e->{
			timeLine.stop();
			rectangle.getChildren().clear();
			IqQuestions.switchToIqQuestions(e, languageChange,root);
		});
		dBut1A.setGraphic(Q2AImg);
		dBut1A.setOnAction(e->{
			timeLine.stop();
			rectangle.getChildren().clear();
			IqQuestions.switchToIqQuestions(e, languageChange,root);
		});
		dBut2A.setGraphic(Q3AImg);
		dBut2A.setOnAction(e->{
			timeLine.stop();
			rectangle.getChildren().clear();
			IqQuestions.switchToIqQuestions(e, languageChange,root);
		});
		dBut3A.setGraphic(Q7AImg);
		dBut3A.setOnAction(e->{
			timeLine.stop();
			rectangle.getChildren().clear();
			IqQuestions.switchToIqQuestions(e, languageChange,root);
		});
		dBut4A.setGraphic(Q4AImg);
		dBut4A.setOnAction(e->{
			timeLine.stop();
			rectangle.getChildren().clear();
			IqQuestions.switchToIqQuestions(e, languageChange,root);
		});
		dBut5A.setGraphic(A5Img);
		dBut5A.setOnAction(e->{
			timeLine.stop();
			rectangle.getChildren().clear();
			IqQuestions.switchToIqQuestions(e, languageChange,root);
		});
		dBut7A.setGraphic(A7Img);
		
		dBut0A.getStyleClass().add("ButA");
		dBut1A.getStyleClass().add("ButA");
		dBut2A.getStyleClass().add("ButA");
		dBut3A.getStyleClass().add("ButA");
		dBut4A.getStyleClass().add("ButA");
		dBut5A.getStyleClass().add("ButA");
		dBut7A.getStyleClass().add("ButA");
		
		backButtonsA.getChildren().addAll(dBut0A,dBut1A,dBut2A,dBut3A,dBut4A,dBut5A,dBut7A);
	}
	void lan_click() {
		languageChange = !languageChange;
		lan_change();
	}
	void Counting() {
		Button over = new Button();
		over.setOnAction(e->{
			IqQuestions.switchToIqQuestions(e, languageChange,root);
			rectangle.getChildren().clear();
		});
		over.setVisible(false);
		root.getChildren().add(over);
		clockImg = new ImageView(clock);
		StackPane.setMargin(clockImg, new Insets(0, 650, 550, 0));

		timer.getStyleClass().add("timer");
		timer.setMaxSize(140, 60);
		StackPane.setMargin(timer, new Insets(0, 550, 550, 0));
		
		Font Mathematics_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 30);
		timeT.setFont(Mathematics_font);
		timeT.setText(Integer.toString(Counter));
		timeT.setFill(Color.BLACK);
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
		quest = new Label();
		if (languageChange) {
			iq7MMImg.setVisible(false);
			EngT.setVisible(true);
			EngT.setText("\tWhich of the following figures \r\n"
					+ "should be replaced at question mark?");
			quest.setGraphic(EngT);
			Font quest_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 20);
			EngT.setFont(quest_font);
			rectangle.getChildren().add(quest);
			
			root.getChildren().addAll();

			nonesense = true;
		} else {
			if (nonesense == true) {
				iq7MMImg.setVisible(true);
				EngT.setVisible(false);
			}
			quest.setGraphic(iq7MMImg);
			rectangle.getChildren().add(quest);
			root.getChildren().addAll();
		}
	}
}
