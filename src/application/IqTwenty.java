package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
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

public class IqTwenty{
	Timeline timeLine;

	int Counter = 30;
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
	
	Label quest;
	
	Image Arrow = new Image("arrow.png");
	Image clock = new Image("IqTwenty/clock.png");
	Image quesBlock = new Image("IqTwenty/quesBlock.png");
	Image arrow1 = new Image("IqTwenty/arrow1.png");
	Image arrow2 = new Image("IqTwenty/arrow2.png");
	Image arrow3 = new Image("IqTwenty/arrow3.png");
	Image b1s = new Image("IqTwenty/block1.png");
	Image b2s = new Image("IqTwenty/block2.png");
	Image b3s = new Image("IqTwenty/block3.png");
	
	ImageView backArrow = new ImageView(Arrow);
	ImageView clockImg = new ImageView(clock);
	ImageView quesBlockImg = new ImageView(quesBlock);
	ImageView arrow1Img = new ImageView(arrow1);
	ImageView arrow2Img = new ImageView(arrow2);
	ImageView arrow3Img = new ImageView(arrow3);
	ImageView b1Img = new ImageView(b1s);
	ImageView b2Img = new ImageView(b2s);
	ImageView b3Img = new ImageView(b3s);
	
	StackPane root;
	StackPane rectangle = new StackPane();
	StackPane rectangle1 = new StackPane();
	
	boolean languageChange;
	boolean nonesense = false;

	public void switchToDifficulty(ActionEvent event, boolean languageChange,StackPane proot) {
		remain_counter = Counter;
		this.languageChange = languageChange;
		root = new StackPane();
		root.setStyle("-fx-background-color: BLACK");
		
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
//		root.setStyle("-fx-background-color: BLACK");
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
			cat.switchToScene1(a, 1, languageChange);
		});
		backArrow.setFitWidth(40);
		backArrow.setFitHeight(30);

		back.setGraphic(backArrow);
		StackPane.setAlignment(back, Pos.TOP_LEFT);
		StackPane.setMargin(back, new Insets(30, 0, 0, 30));// top right bottom left
		
		rectangle.setMaxWidth(311);
		rectangle.setStyle("-fx-background-color:WHITE;");
		rectangle.setMaxHeight(277);
		StackPane.setMargin(rectangle, new Insets(0,700,0,0));
		
		rectangle1.setMaxWidth(311);
		rectangle1.setStyle("-fx-background-color:WHITE; -fx-background-radius:25px;");
		rectangle1.setMaxHeight(277);
		if(!rectangle1.getChildren().contains(quesBlockImg)) {
			rectangle1.getChildren().add(quesBlockImg);
		}
		StackPane.setMargin(rectangle1, new Insets(0,0,0,0));
		
		StackPane.setMargin(arrow1Img, new Insets(0,0,250,450));
		StackPane.setMargin(arrow2Img, new Insets(0,0,0,450));
		StackPane.setMargin(arrow3Img, new Insets(0,0,-250,450));
		
		b1.setMaxSize(200, 170);
		b1.getStyleClass().add("choiceButTw");
		b1.setGraphic(b1Img);
		StackPane.setMargin(b1, new Insets(0,0,410,850));
		
		b2.setMaxSize(200, 170);
		b2.setOnAction(e->{
			IqResultCheck.check();
			timeLine.stop();
			IqQuestions.switchToIqQuestions(e, languageChange,root);
		});
		b2.getStyleClass().add("choiceButTw");
		b2.setGraphic(b2Img);
		StackPane.setMargin(b2, new Insets(0,0,0,850));
		
		b3.setMaxSize(200, 170);
		b3.getStyleClass().add("choiceButTw");
		b3.setGraphic(b3Img);
		StackPane.setMargin(b3, new Insets(0,0,-410,850));
		
		
		root.getChildren().addAll(back,rectangle,rectangle1,arrow2Img,arrow1Img,arrow3Img,b1,b2,b3);
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
		clockImg = new ImageView(clock);
		StackPane.setMargin(clockImg, new Insets(0, 100, 480, 0));

		timer.getStyleClass().add("timer");
		timer.setMaxSize(140, 60);
		StackPane.setMargin(timer, new Insets(0, 0, 450, 0));
		
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
		
		root.getChildren().addAll(timer,clockImg);
	}
	
	private void lan_change() {
		quest = new Label();
		if (languageChange) {
			quest.setText("Choose the 3D"
					+ "\nshape formed "
					+ "\nfrom the provided "
					+ "\noptions "
					+ " by folding "
					+ "\nthe given flat "
					+ "\npattern .");
			Font quest_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 24);
			quest.setFont(quest_font);
			rectangle.getChildren().add(quest);

			root.getChildren().addAll();

			nonesense = true;
		} else {
			if (nonesense == true) {
				
			}

			root.getChildren().addAll();
		}
	}
}
