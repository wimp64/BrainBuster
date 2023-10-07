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

public class IqThirteen{
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
	
	Label quest;
	
	Image Arrow = new Image("arrow.png");
	Image cloud = new Image("IqThirteen/tiger.png");
	Image clock = new Image("IqThirteen/clock.png");
	Image cubes = new Image("IqThirteen/owl.png");
	Image scissor = new Image("IqThirteen/cow.png");
	Image b1s = new Image("IqThirteen/cat.png");
	Image b2s = new Image("IqThirteen/dog.png");
	Image b3s = new Image("IqThirteen/lion.png");
	Image b4s = new Image("IqThirteen/snake.png");
	
	ImageView backArrow = new ImageView(Arrow);
	ImageView cloudImg = new ImageView(cloud);
	ImageView clockImg = new ImageView(clock);
	ImageView cubesImg = new ImageView(cubes);
	ImageView scissorImg = new ImageView(scissor);
	ImageView b1Img = new ImageView(b1s);
	ImageView b2Img = new ImageView(b2s);
	ImageView b3Img = new ImageView(b3s);
	ImageView b4Img = new ImageView(b4s);
	
	StackPane root;
	StackPane rectangle = new StackPane();
	
	boolean languageChange;
	boolean nonesense = false;

	public void switchToIqQuestions(ActionEvent event, boolean languageChange,StackPane proot) {
		remain_counter = Counter;
		this.languageChange = languageChange;
		root = new StackPane();
		root.setStyle("-fx-background-color: #A1C5C4");
		
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
//		root.setStyle("-fx-background-color: #A1C5C4");
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
		
		rectangle.setMaxWidth(1083);
		rectangle.setStyle("-fx-background-color:#E7F2D6;");
		rectangle.setMaxHeight(86);
		StackPane.setMargin(rectangle, new Insets(0,0,350,0));
		StackPane.setAlignment(cloudImg, Pos.BOTTOM_RIGHT);
		StackPane.setAlignment(scissorImg, Pos.BOTTOM_LEFT);
		StackPane.setAlignment(cubesImg, Pos.TOP_RIGHT);
		
		b1.setMaxSize(256, 223);
		b1.getStyleClass().add("choiceButTh");
		b1.setGraphic(b1Img);
		StackPane.setMargin(b1, new Insets(75,1000,0,0));
		
		b2.setMaxSize(256, 223);
		b2.getStyleClass().add("choiceButTh");
		b2.setGraphic(b2Img);
		StackPane.setMargin(b2, new Insets(75,330,0,0));
		
		b3.setMaxSize(256, 223);
		b3.getStyleClass().add("choiceButTh");
		b3.setGraphic(b3Img);
		StackPane.setMargin(b3, new Insets(75,-330,0,0));
		
		b4.setMaxSize(256, 223);
		b4.getStyleClass().add("choiceButTh");
		b4.setGraphic(b4Img);
		b4.setOnAction(e->{
			IqQuestions.switchToIqQuestions(e, languageChange,root);
			timeLine.stop();
		});
		StackPane.setMargin(b4, new Insets(75,-1000,0,0));
		
		root.getChildren().addAll( back,cloudImg,scissorImg,cubesImg,rectangle,b1,b2,b3,b4);
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
		StackPane.setMargin(clockImg, new Insets(0, 100, 550, 0));

		timer.getStyleClass().add("timer");
		timer.setMaxSize(140, 60);
		StackPane.setMargin(timer, new Insets(0, 0, 550, 0));
		
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
			
			quest.setText("Choose which is least like the others:");
			Font quest_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 33);
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
