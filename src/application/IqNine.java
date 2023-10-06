package application;

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

public class IqNine extends Application {
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
	
	
	ImageView backArrow = new ImageView(Arrow);
	ImageView dogsImg = new ImageView(dogs);
	ImageView clockImg = new ImageView(clock);
	ImageView pawsImg = new ImageView(paws);
	ImageView dogImg = new ImageView(dog);
	
	StackPane root;

	boolean languageChange=true;
	boolean nonesense = false;

	public void switchToDifficulty(ActionEvent event, boolean languageChange) {
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
	}
	
	/*This is only for developing part*/
	public void start(Stage primaryStage) throws Exception {
		root = new StackPane();
		root.setStyle("-fx-background-color: #6F615A");
		
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
			cat.switchToScene1(a, 1, languageChange);
		});
		backArrow.setFitWidth(40);
		backArrow.setFitHeight(30);

		back.setGraphic(backArrow);
		StackPane.setAlignment(back, Pos.TOP_LEFT);
		StackPane.setMargin(back, new Insets(30, 0, 0, 30));// top right bottom left
		
		StackPane rectangle = new StackPane();
		rectangle.setStyle("-fx-background-color:white;" + "-fx-background-radius:25px;");
		rectangle.setMaxWidth(1212);
		StackPane.setMargin(rectangle, new Insets(0, 0, 200, 0));
		rectangle.setMaxHeight(307);
		
		yes.getStyleClass().add("yesBut");
		yes.setMaxSize(230, 115);
		StackPane.setMargin(yes, new Insets(300, 700, 0, 0));

		no.getStyleClass().add("noBut");
		no.setMaxSize(230, 115);
		StackPane.setMargin(no, new Insets(300, -700, 0, 0));
		no.setOnAction(e -> {
			timeLine.stop();
			IqQuestions.switchToIqQuestions(e, languageChange,root);
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

			root.getChildren().addAll();

			nonesense = true;
		} else {
			if (nonesense == true) {
				
			}

			root.getChildren().addAll();
		}
	}
}
