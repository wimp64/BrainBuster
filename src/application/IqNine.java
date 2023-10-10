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

public class IqNine{
	Timeline timeLine;

	int Counter = 15;
	int remain_counter = Counter;
	
	Scene scene1;
	Stage currentStage;
	Stage s;
	Scene sc;

	Button back;
	Button yes = new Button();
	Button no = new Button();
	Button timer = new Button();
	
	Text timeT = new Text();
	Text yesT;
	Text noT;

	Image Arrow = new Image("arrow.png");
	Image dogs = new Image("IqNine/dogs.png");
	Image clock = new Image("IqNine/clock.png");
	Image paws = new Image("IqNine/paws.png");
	Image dog = new Image("IqNine/dog.png");
	Image IqNine = new Image("IqNine/IqNineEng.png");
	Image iq9MM = new Image("IqNine/iq9MM.png");
	Image yesMM = new Image("IqNine/yes.png");
	Image noMM = new Image("IqNine/no.png");
	
	ImageView backArrow = new ImageView(Arrow);
	ImageView dogsImg = new ImageView(dogs);
	ImageView clockImg = new ImageView(clock);
	ImageView pawsImg = new ImageView(paws);
	ImageView dogImg = new ImageView(dog);
	ImageView IqNineEng = new ImageView(IqNine);
	ImageView iq9MMImg =  new ImageView(iq9MM);
	ImageView yesMMImg = new ImageView(yesMM);
	ImageView noMMImg = new ImageView(noMM);
	
	StackPane root;
	StackPane rectangle;
	
	boolean languageChange;
	boolean nonesense = false;

	public void switchToDifficulty(ActionEvent event, boolean languageChange,StackPane proot) {
		remain_counter = Counter;
		this.languageChange = languageChange;
		root = new StackPane();
		root.setStyle("-fx-background-color: #6F615A");
		
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
//		root.setStyle("-fx-background-color: #6F615A");
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
		rectangle.setMaxWidth(1212);
		StackPane.setMargin(rectangle, new Insets(0, 0, 200, 0));
		rectangle.setMaxHeight(307);
		
		yes.getStyleClass().add("yesButN");
		yes.setMaxSize(230, 115);
		StackPane.setMargin(yes, new Insets(300, 700, 0, 0));
		yes.setOnAction(e->{
			timeLine.stop();
			IqQuestions.switchToIqQuestions(e, languageChange,root);
			rectangle.getChildren().clear();
		});
		no.getStyleClass().add("noButN");
		no.setMaxSize(230, 115);
		StackPane.setMargin(no, new Insets(300, -700, 0, 0));
		no.setOnAction(e -> {
			timeLine.stop();
			IqResultCheck.check();
			IqQuestions.switchToIqQuestions(e, languageChange,root);
			rectangle.getChildren().clear();
		});
		
		StackPane.setAlignment(dogsImg, Pos.BOTTOM_RIGHT);
		StackPane.setAlignment(dogImg, Pos.BOTTOM_LEFT);
		StackPane.setAlignment(pawsImg, Pos.TOP_RIGHT);
		
		root.getChildren().addAll( back,dogsImg,dogImg,pawsImg,yes,no,rectangle);
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
		clockImg.setFitWidth(85);
		clockImg.setFitHeight(81);
		StackPane.setMargin(clockImg, new Insets(300, 125, 0, 0));

		timer.getStyleClass().add("timer");
		timer.setMaxSize(140, 60);
		StackPane.setMargin(timer, new Insets(300, 0, 0, 0));
		
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
		if (languageChange) {
			iq9MMImg.setVisible(false);
			yesMMImg.setVisible(false);
			noMMImg.setVisible(false);
			
			IqNineEng.setVisible(true);
			yesT.setVisible(true);
			noT.setVisible(true);
			
			Font Yes_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 40);
			yesT = new Text("YES");
			yesT.setFont(Yes_font);
			yesT.setFill(Color.WHITE);
			yes.setGraphic(yesT);

			noT = new Text("NO");
			noT.setFont(Yes_font);
			noT.setFill(Color.WHITE);
			no.setGraphic(noT);
			
			rectangle.getChildren().add(IqNineEng);
			root.getChildren().addAll();

			nonesense = true;
		} else {
			if (nonesense == true) {
				iq9MMImg.setVisible(true);
				yesMMImg.setVisible(true);
				noMMImg.setVisible(true);
				
				IqNineEng.setVisible(false);
				yesT.setVisible(false);
				noT.setVisible(false);
			}
			rectangle.getChildren().add(iq9MMImg);
			yes.setGraphic(yesMMImg);
			no.setGraphic(noMMImg);
			root.getChildren().addAll();
		}
	}
}
