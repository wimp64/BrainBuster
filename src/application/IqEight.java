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
import javafx.scene.control.*;

public class IqEight{
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
	
	Label quest = new Label();
	
	Image Arrow = new Image("arrow.png");
	Image boy = new Image("IqEight/boy.png");
	Image clock = new Image("IqSix/clock.png");
	Image play = new Image("IqEight/play.png");
	Image easy = new Image("IqEight/Easy.png");

	
	ImageView backArrow = new ImageView(Arrow);
	ImageView boyImg = new ImageView(boy);
	ImageView clockImg = new ImageView(clock);
	ImageView playImg = new ImageView(play);
	ImageView easyImg = new ImageView(easy);
	
	StackPane root;
	StackPane rectangle = new StackPane();
	
	boolean languageChange;
	boolean nonesense = false;

	public void switchToIqQuestions(ActionEvent event, boolean languageChange,StackPane proot) {
		remain_counter = Counter;
		this.languageChange = languageChange;
		root = new StackPane();
		root.setStyle("-fx-background-color: #039D53");
		
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
//		root.setStyle("-fx-background-color: #039D53");
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
		
		rectangle.setMaxSize(640, 160);
		rectangle.setStyle("-fx-background-color:#FFE8A8; -fx-background-radius:25px;");
		StackPane.setMargin(rectangle, new Insets(0,0,500,0));
		
		StackPane.setMargin(b1, new Insets(80,0,300,0));
		StackPane.setMargin(b2, new Insets(80,0,100,0));
		StackPane.setMargin(b3, new Insets(80,0,-100,0));
		StackPane.setMargin(b4, new Insets(80,0,-300,0));
		
		b1.setMaxSize(514, 80);
		
		b2.setMaxSize(514, 80);
		b3.setMaxSize(514, 80);
		b4.setMaxSize(514, 80);

		b1.getStyleClass().add("bBut");
		b2.getStyleClass().add("bBut");
		b3.getStyleClass().add("bBut");
		b3.setOnAction(e->{
			IqResultCheck.check();
			timeLine.stop();
			IqQuestions.switchToIqQuestions(e, languageChange,root);
		});
		b4.getStyleClass().add("bBut");
		
		StackPane.setAlignment(boyImg, Pos.BOTTOM_RIGHT);
		StackPane.setAlignment(easyImg, Pos.BOTTOM_LEFT);
		StackPane.setAlignment(playImg, Pos.TOP_RIGHT);
		
		root.getChildren().addAll( back,boyImg,easyImg,playImg,b1,b2,b3,b4,rectangle);
	}

	void lan_click() {
		languageChange = !languageChange;
		lan_change();
	}
	void Counting() {
		Button over = new Button();
		over.setOnAction(e->{
			IqQuestions.switchToIqQuestions(e, languageChange,root);
			IqResultCheck.check();
			timeLine.stop();
		});
		over.setVisible(false);
		root.getChildren().add(over);
		clockImg = new ImageView(clock);
		StackPane.setMargin(clockImg, new Insets(0, 1000, 450, 0));

		timer.getStyleClass().add("timer");
		timer.setMaxSize(140, 60);
		StackPane.setMargin(timer, new Insets(0, 900, 450, 0));
		
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
			
			quest.setText("Choose the synonym for\r\n"
					+ "\t\"ephemeral\"");
			Font quest_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 30);
			quest.setFont(quest_font);
			rectangle.getChildren().add(quest);
			
			b1T.setText("Lasting");
			b1T.setFont(quest_font);
			b1T.setFill(Color.WHITE);
			b1.setGraphic(b1T);
			
			b2T.setText("Eternal");
			b2T.setFont(quest_font);
			b2T.setFill(Color.WHITE);
			b2.setGraphic(b2T);
			
			b3T.setText("Fleeting");
			b3T.setFont(quest_font);
			b3T.setFill(Color.WHITE);
			b3.setGraphic(b3T);
			
			b4T.setText("Permanent");
			b4T.setFont(quest_font);
			b4T.setFill(Color.WHITE);
			b4.setGraphic(b4T);
			
			root.getChildren().addAll();

			nonesense = true;
		} else {
			if (nonesense == true) {
				
			}

			root.getChildren().addAll();
		}
	}
}
