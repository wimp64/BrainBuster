package application;

import application.Mathematics.MathResultCheck;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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

public class IqTen{
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
	Text b4T = new Text();
	
	Image Arrow = new Image("arrow.png");
	Image goalPost = new Image("IqTen/goalPost.png");
	Image clock = new Image("IqTen/clock.png");
	Image goal = new Image("IqTen/goal.png");
	Image boots = new Image("IqTen/boots.png");
	Image QEng = new Image("IqTen/IqTenEng.png");
	
	ImageView backArrow = new ImageView(Arrow);
	ImageView goalPostImg = new ImageView(goalPost);
	ImageView clockImg = new ImageView(clock);
	ImageView goalImg = new ImageView(goal);
	ImageView bootsImg = new ImageView(boots);
	ImageView QEngImg = new ImageView(QEng);
	ImageView iq10MMImg = new ImageView(new Image("IqTen/iq10MM.png"));
	ImageView a1Img = new ImageView(new Image("IqTen/a1.png"));
	ImageView a2Img = new ImageView(new Image("IqTen/a2.png"));
	ImageView a3Img = new ImageView(new Image("IqTen/a3.png"));
	
	StackPane root;
	StackPane rectangle;
	
	boolean languageChange;
	boolean nonesense = false;

	public void switchToDifficulty(ActionEvent event, boolean languageChange,StackPane proot) {
		remain_counter = Counter;
		this.languageChange = languageChange;
		root = new StackPane();
		root.setStyle("-fx-background-color: #00892C");
		
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
//		root.setStyle("-fx-background-color: #00892C");
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
		rectangle.setMaxWidth(440);
		StackPane.setMargin(rectangle, new Insets(0, 600, 0, 0));
		StackPane.setAlignment(rectangle, Pos.CENTER);
		rectangle.setMaxHeight(420);
		
		StackPane.setMargin(b1, new Insets(80,-600,300,0));
		StackPane.setMargin(b2, new Insets(80,-600,100,0));
		StackPane.setMargin(b3, new Insets(80,-600,-100,0));
		
		StackPane.setAlignment(b1,Pos.CENTER);
		StackPane.setAlignment(b2,Pos.CENTER);
		StackPane.setAlignment(b3,Pos.CENTER);
		
		b1.setMaxSize(514, 80);
		b2.setMaxSize(514, 80);
		b3.setMaxSize(514, 80);
		
		b1.getStyleClass().add("bButT");
		b2.getStyleClass().add("bButT");
		b3.getStyleClass().add("bButT");
		
		b1.setOnAction(e->{
			timeLine.stop();
			IqQuestions.switchToIqQuestions(e, languageChange,root);
			rectangle.getChildren().clear();
		});
		b2.setOnAction(e->{
			IqResultCheck.check();
			timeLine.stop();
			IqQuestions.switchToIqQuestions(e, languageChange,root);
			rectangle.getChildren().clear();
		});
		b3.setOnAction(e->{
			timeLine.stop();
			IqQuestions.switchToIqQuestions(e, languageChange,root);
			rectangle.getChildren().clear();
		});
		StackPane.setAlignment(goalPostImg, Pos.BOTTOM_RIGHT);
		StackPane.setAlignment(bootsImg, Pos.BOTTOM_LEFT);
		StackPane.setAlignment(goalImg, Pos.TOP_RIGHT);
		
		root.getChildren().addAll( back,goalPostImg,bootsImg,goalImg,rectangle,b1,b2,b3);
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
		StackPane.setMargin(clockImg, new Insets(0, 100, 470, 550));

		timer.getStyleClass().add("timer");
		timer.setMaxSize(140, 60);
		StackPane.setMargin(timer, new Insets(0, 0, 450, 550));
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
			iq10MMImg.setVisible(false);
			a1Img.setVisible(false);
			a2Img.setVisible(false);
			a3Img.setVisible(false);
			
			QEngImg.setVisible(true);
			b1T.setVisible(true);
			b2T.setVisible(true);
			b3T.setVisible(true);
			
			Font quest_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 30);
			
			b1T.setText("100");
			b1T.setFont(quest_font);
			b1T.setFill(Color.BLACK);
			b1.setGraphic(b1T);
			
			b2T.setText("50");
			b2T.setFont(quest_font);
			b2T.setFill(Color.BLACK);
			b2.setGraphic(b2T);
			
			b3T.setText("150");
			b3T.setFont(quest_font);
			b3T.setFill(Color.BLACK);
			b3.setGraphic(b3T);
			
			rectangle.getChildren().add(QEngImg);
			root.getChildren().addAll();

			nonesense = true;
		} else {
			if (nonesense == true) {
				iq10MMImg.setVisible(true);
				a1Img.setVisible(true);
				a2Img.setVisible(true);
				a3Img.setVisible(true);
				
				QEngImg.setVisible(false);
				b1T.setVisible(false);
				b2T.setVisible(false);
				b3T.setVisible(false);
			}
			rectangle.getChildren().add(iq10MMImg);
			b1.setGraphic(a1Img);
			b2.setGraphic(a2Img);
			b3.setGraphic(a3Img);
			root.getChildren().addAll();
		}
	}
}
