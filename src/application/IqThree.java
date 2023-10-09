package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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

public class IqThree {
	Timeline timeLine;

	int Counter = 15;
	int remain_counter = Counter;

	Scene scene1;
	Stage currentStage;
	Stage s;
	Scene sc;

	Button back;
	Button timer = new Button();
	Button John = new Button();
	Button Mark = new Button();
	Button Alex = new Button();

	Text timeT = new Text();
	Text JohnT = new Text();
	Text MarkT = new Text();
	Text AlexT = new Text();

	Label quest = new Label();

	Image Lang = new Image("lang.png");
	Image Arrow = new Image("arrow.png");
	Image graffi = new Image("IqThree/graffi.png");
	Image clock = new Image("IqTwo/clock.png");
	Image twoBoys = new Image("IqThree/twoBoys.png");
	Image girl = new Image("IqThree/girl.png");
	Image iqThreeMM = new Image("IqThree/iq3MM.png");
	Image a1 =new Image("IqThree/a1.png");
	Image a2 = new Image("IqThree/a2.png");
	Image a3 = new Image("IqThree/a3.png");
	
	ImageView backArrow = new ImageView(Arrow);
	ImageView graffiImg = new ImageView(graffi);
	ImageView clockImg = new ImageView(clock);
	ImageView twoBoysImg = new ImageView(twoBoys);
	ImageView girlImg = new ImageView(girl);
	ImageView iqThreeMMImg = new ImageView(iqThreeMM);
	ImageView a1Img = new ImageView(a1);
	ImageView a2Img = new ImageView(a2);
	ImageView a3Img = new ImageView(a3);
	
	StackPane root;
	StackPane rectangle;

	boolean languageChange;// delete true
	boolean nonesense = false;

	public void switchToIqQuestions(ActionEvent event, boolean languageChange,StackPane proot) {
		remain_counter = Counter;
		this.languageChange = languageChange;
		root = new StackPane();
		root.setStyle("-fx-background-color: #F79630");

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

	/* This is only for developing part */
//	public void start(Stage primaryStage) throws Exception {
//		root = new StackPane();
//		root.setStyle("-fx-background-color: #F79630");
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
	/* This is only for developing part */

	private void elements() {
		back = new Button();
		back.getStyleClass().add("lets_start");
		back.setPrefSize(60, 60);
		Category cat = new Category();
		back.setOnAction(a -> {
			cat.switchToScene1(a, application.Mathematics.MathResult.scV, languageChange);
			timeLine.stop();
			rectangle.getChildren().clear();
		});
		backArrow.setFitWidth(40);
		backArrow.setFitHeight(30);

		back.setGraphic(backArrow);
		StackPane.setAlignment(back, Pos.TOP_LEFT);
		StackPane.setMargin(back, new Insets(30, 0, 0, 30));// top right bottom left

		rectangle = new StackPane();
		rectangle.setStyle("-fx-background-color:WHITE;" + "-fx-background-radius:25px;");
		rectangle.setMaxWidth(1160);
		StackPane.setMargin(rectangle, new Insets(0, 0, 200, 0));
		rectangle.setMaxHeight(170);

		John.setMaxSize(257, 87);
		StackPane.setMargin(John, new Insets(150, 750, 0, 0));
		John.getStyleClass().add("Ez_Btn");
		John.setOnAction(e -> {
			IqQuestions.switchToIqQuestions(e, languageChange,root);
			timeLine.stop();
			rectangle.getChildren().clear();
		});

		Mark.setMaxSize(257, 87);
		StackPane.setMargin(Mark, new Insets(150, 0, 0, 0));
		Mark.getStyleClass().add("Nm_Btn");
		Mark.setOnAction(e -> {
			IqResultCheck.check();
			IqQuestions.switchToIqQuestions(e, languageChange,root);
			timeLine.stop();
			rectangle.getChildren().clear();
		});

		Alex.setMaxSize(257, 87);
		StackPane.setMargin(Alex, new Insets(150, 0, 0, 750));
		Alex.getStyleClass().add("Df_Btn");
		Alex.setOnAction(e -> {
			IqQuestions.switchToIqQuestions(e, languageChange,root);
			timeLine.stop();
			rectangle.getChildren().clear();
		});

		clockImg = new ImageView(clock);
		clockImg.setFitWidth(90);
		clockImg.setFitHeight(100);
		StackPane.setMargin(clockImg, new Insets(0, 100, -450, 0));

		timer.getStyleClass().add("timer");
		timer.setMaxSize(140, 60);
		StackPane.setMargin(timer, new Insets(0, 0, -450, 0));

		StackPane.setAlignment(graffiImg, Pos.TOP_RIGHT);

		StackPane.setAlignment(twoBoysImg, Pos.BOTTOM_RIGHT);

		StackPane.setAlignment(girlImg, Pos.BOTTOM_LEFT);

		root.getChildren().addAll(John, Alex, Mark, back, rectangle, graffiImg, twoBoysImg, girlImg, timer,
				clockImg);
	}

	void lan_click() {
		languageChange = !languageChange;
		lan_change();
	}

	void Counting() {
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
				John.fire();
			}
		}));
		timeLine.setCycleCount(Counter);
		timeLine.play();
	}

	private void lan_change() {
		quest = new Label();
		if (languageChange) {

			quest.setText("If John is taller than Mark, and Mark is shorter than Alex, \r\n"
					+ "\t\t\twho is the shortest among the three?");
			Font quest_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 35);
			quest.setFont(quest_font);
			rectangle.getChildren().add(quest);

			JohnT.setText("John");
			Font person_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 40);
			JohnT.setFill(Color.WHITE);
			JohnT.setFont(person_font);
			John.setGraphic(JohnT);

			MarkT.setText("Mark");
			MarkT.setFill(Color.WHITE);
			MarkT.setFont(person_font);
			Mark.setGraphic(MarkT);

			AlexT.setText("Alex");
			AlexT.setFill(Color.WHITE);
			AlexT.setFont(person_font);
			Alex.setGraphic(AlexT);

			root.getChildren().addAll();
			nonesense = true;
		} else {
			if (nonesense == true) {
				
			}
			rectangle.getChildren().add(iqThreeMMImg);
			John.setGraphic(a1Img);
			Mark.setGraphic(a2Img);
			Alex.setGraphic(a3Img);
			
			root.getChildren().addAll();
		}
	}
}
