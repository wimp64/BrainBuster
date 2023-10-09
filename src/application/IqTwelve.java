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

public class IqTwelve{
	Timeline timeLine;

	int Counter = 20;
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
	
	Label quest;
	
	Image Arrow = new Image("arrow.png");
	Image cloud = new Image("IqTwelve/Face2.png");
	Image clock = new Image("IqTwelve/clock.png");
	Image cubes = new Image("IqTwelve/Face1.png");
	Image scissor = new Image("IqTwelve/Face1.png");
	Image Ques = new Image("IqTwelve/QuestionImg.png");
	
	ImageView backArrow = new ImageView(Arrow);
	ImageView cloudImg = new ImageView(cloud);
	ImageView clockImg = new ImageView(clock);
	ImageView cubesImg = new ImageView(cubes);
	ImageView scissorImg = new ImageView(scissor);
	ImageView QuesImg = new ImageView(Ques);
	ImageView iq12MMImg = new ImageView(new Image("IqTwelve/iq12MM.png"));
	ImageView a1Img = new ImageView(new Image("IqTwelve/a1.png"));
	ImageView a2Img = new ImageView(new Image("IqTwelve/a2.png"));
	ImageView a3Img = new ImageView(new Image("IqTwelve/a3.png"));
	
	StackPane root;
	StackPane rectangle = new StackPane();
	
	boolean languageChange;
	boolean nonesense = false;

	public void switchToIqQuestions(ActionEvent event, boolean languageChange,StackPane proot) {
		remain_counter = Counter;
		this.languageChange = languageChange;
		root = new StackPane();
		root.setStyle("-fx-background-color: #FFE8A8");
		
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
//		root.setStyle("-fx-background-color: #FFE8A8");
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
			rectangle.getChildren().clear();
		});
		backArrow.setFitWidth(40);
		backArrow.setFitHeight(30);

		back.setGraphic(backArrow);
		StackPane.setAlignment(back, Pos.TOP_LEFT);
		StackPane.setMargin(back, new Insets(30, 0, 0, 30));// top right bottom left
		
		rectangle.setMaxWidth(1083);
		rectangle.setStyle("-fx-background-color:WHITE;");
		rectangle.setMaxHeight(86);
		StackPane.setMargin(rectangle, new Insets(0,0,350,0));
		StackPane.setAlignment(cloudImg, Pos.BOTTOM_RIGHT);
		StackPane.setAlignment(scissorImg, Pos.BOTTOM_LEFT);
		StackPane.setAlignment(cubesImg, Pos.TOP_RIGHT);
		StackPane.setAlignment(QuesImg, Pos.CENTER);
		
		StackPane.setMargin(b1, new Insets(300,400,0,0));
		StackPane.setMargin(b2, new Insets(450,0,0,0));
		StackPane.setMargin(b3, new Insets(300,-400,0,0));
		
		StackPane.setAlignment(b1, Pos.CENTER);
		StackPane.setAlignment(b2, Pos.CENTER);
		StackPane.setAlignment(b3, Pos.CENTER);
		
		b1.setMaxSize(360, 65);
		b1.setOnAction(e->{
			timeLine.stop();
			rectangle.getChildren().clear();
			IqQuestions.switchToIqQuestions(e, languageChange, root);
		});
		b2.setMaxSize(360, 65);
		b2.setOnAction(e->{
			IqResultCheck.check();
			timeLine.stop();
			rectangle.getChildren().clear();
			IqQuestions.switchToIqQuestions(e, languageChange, root);
		});
		b3.setMaxSize(360, 65);
		b3.setOnAction(e->{
			timeLine.stop();
			rectangle.getChildren().clear();
			IqQuestions.switchToIqQuestions(e, languageChange, root);
		});
		b1.getStyleClass().add("bButTw");
		b2.getStyleClass().add("bButTw");
		b3.getStyleClass().add("bButTw");
		
		root.getChildren().addAll( b1,b2,b3,back,cloudImg,scissorImg,cubesImg,rectangle,QuesImg);
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
			
			quest.setText("Which of the following images continue the pattern?");
			Font quest_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 33);
			quest.setFont(quest_font);
			rectangle.getChildren().add(quest);
			
			b1T.setText("Only A");
			b1T.setFont(quest_font);
			b1.setGraphic(b1T);
			
			b2T.setText("All of them");
			b2T.setFont(quest_font);
			b2.setGraphic(b2T);
			
			b3T.setText("Only A & B");
			b3T.setFont(quest_font);
			b3.setGraphic(b3T);
			
			root.getChildren().addAll();

			nonesense = true;
		} else {
			if (nonesense == true) {
				
			}
			quest.setGraphic(iq12MMImg);
			rectangle.getChildren().add(quest);
			b1.setGraphic(a1Img);
			b2.setGraphic(a2Img);
			b3.setGraphic(a3Img);
			
			root.getChildren().addAll();
		}
	}
}
