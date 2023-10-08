package application;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
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
import javafx.util.*;
import javafx.scene.control.*;

public class IqResult{
	
	Scene scene1;
	Stage currentStage;
	String s;
	String s1;
	String s2;
	
	Scene sc;

	Button back;
	
	Label result;
	Label excellent = new Label();
	Label r2Label = new Label();
	Label r3Label = new Label();
	
	Image Arrow = new Image("IqResult/home.png");
	Image brain = new Image("IqResult/brain.png");
	Image brainR = new Image("IqResult/brainR.png");

	
	ImageView backArrow = new ImageView(Arrow);
	ImageView brainImg = new ImageView(brain);
	ImageView brainRImg = new ImageView(brainR);
	
	StackPane root;
	StackPane rectangle1 = new StackPane();
	StackPane rectangle2 = new StackPane();
	StackPane r1 = new StackPane();
	StackPane r2 = new StackPane();
	StackPane r3 = new StackPane();
	
	ProgressIndicator pi = new ProgressIndicator();
	double targetValue;
	int resultValue;
	double percentValue;
	
	boolean languageChange;
	boolean nonesense = false;
	
	public void switchToDifficulty(ActionEvent event, boolean languageChange,StackPane proot) {
		s = String.valueOf(IqResultCheck.getScore());
		s1 = String.valueOf(IqResultCheck.getResult());
		s2 = String.valueOf(IqResultCheck.getPercent());
		
		percentValue = Double.parseDouble(s2);
		targetValue = Double.parseDouble(s);
		resultValue = (int) Double.parseDouble(s1);
		
		this.languageChange = languageChange;
		root = new StackPane();
		root.setStyle("-fx-background-color: #2385C4");
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
//		root.setStyle("-fx-background-color: #2385C4");
//		
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
		back.getStyleClass().add("lets_startR");
		back.setPrefSize(60, 60);
		back.setOnAction(a -> {
			Category cat = new Category();
			cat.switchToScene1(a, 1, languageChange);
			rectangle1.getChildren().clear();
			rectangle2.getChildren().clear();
			r1.getChildren().clear();
			r2.getChildren().clear();
			r3.getChildren().clear();
			IqResultCheck.correct=0;
			IqResultCheck.percent=0;
			IqResultCheck.result=0;
		});
		backArrow.setFitWidth(40);
		backArrow.setFitHeight(40);
		
		back.setGraphic(backArrow);
		StackPane.setAlignment(back, Pos.CENTER_RIGHT);
		StackPane.setMargin(back, new Insets(0, 150, 0, 0));// top right bottom left
		
		incicate();
		if(!rectangle1.getChildren().contains(pi)) {
			rectangle1.getChildren().add(pi);
		}
		rectangle1.setMaxWidth(306);
		rectangle1.setStyle("-fx-background-color:WHITE; -fx-background-radius:25px;");
		rectangle1.setMaxHeight(330);
		StackPane.setMargin(rectangle1, new Insets(0,900,0,0));
		
		rectangle2.setMaxWidth(618);
		rectangle2.setStyle("-fx-background-color:WHITE; -fx-background-radius:25px;");
		rectangle2.setMaxHeight(540);
		StackPane.setMargin(rectangle2, new Insets(0,0,0,200));
		
		r1.setMaxWidth(500);
		r1.setStyle("-fx-background-color:#603D27; -fx-background-radius:25px;");
		r1.setMaxHeight(380);
		StackPane.setMargin(r1, new Insets(0,0,100,0));

		
		r2.setMaxWidth(233);
		r2.setStyle("-fx-background-color:#603D27; -fx-background-radius:25px;");
		r2.setMaxHeight(76);
		StackPane.setMargin(r2, new Insets(400,0,0,-300));

		
		r3.setMaxWidth(233);
		r3.setStyle("-fx-background-color:#603D27; -fx-background-radius:25px;");
		r3.setMaxHeight(76);
		StackPane.setMargin(r3, new Insets(400,0,0,300));
		if(!rectangle2.getChildren().contains(r1)) {
			rectangle2.getChildren().addAll(r1);
		}
		if(!rectangle2.getChildren().contains(r2)) {
			rectangle2.getChildren().addAll(r2);
		}
		if(!rectangle2.getChildren().contains(r3)) {
			rectangle2.getChildren().addAll(r3);
		}
		
		StackPane.setAlignment(brainImg, Pos.BOTTOM_LEFT);
		StackPane.setAlignment(brainRImg, Pos.BOTTOM_RIGHT);
		
		root.getChildren().addAll(brainImg,brainRImg,back,rectangle1,rectangle2);
	}
	private void incicate() {
	
		excellent.visibleProperty().bind(pi.progressProperty().isEqualTo((long) 1.0));

		
		excellent.setStyle("-fx-background-color:WHITE;");
		StackPane.setAlignment(excellent, Pos.BOTTOM_CENTER);
		StackPane.setMargin(excellent, new Insets(0,0,19,0));
		
		pi.getStyleClass().add("cpi");
		pi.setMaxSize(280, 280);
        Duration duration = Duration.seconds(2); // Animation duration (in this case, 3 seconds)
        System.out.println("Target value: "+targetValue);
        // Create a Timeline to animate the ProgressIndicator to the target value
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(pi.progressProperty(), 0)),
                new KeyFrame(duration, new KeyValue(pi.progressProperty(), targetValue))
        );
        BooleanBinding isTargetReached = Bindings.createBooleanBinding(
                () -> pi.getProgress() >= targetValue,
                pi.progressProperty()
        );
        r3Label.visibleProperty().bind(isTargetReached);
        isTargetReached.addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                r3.setStyle("-fx-background-color:#F79630; -fx-background-radius:25px; -fx-border-radius:25px; -fx-border-width:4px;"
                		+ "-fx-border-color:black;");
            } else {
            	r3.setStyle("-fx-background-color:#603D27; -fx-background-radius:25px;");
            }
        });
        timeline.play();
	}
	private void result_filter() {
		
		if(resultValue<=20 && resultValue>=15) {
		result.setText(" Congratulation!\n"
				+ "    You correct "+resultValue+"\n\tout of 20\n       questions.");
		}else if(resultValue<=15 && resultValue>=10) {
			result.setText(" Nice!Not bad at all.\n"
					+ "    You correct "+resultValue+"\n\tout of 20\n       questions.");
		}else if(resultValue<=10 && resultValue>=5) {
			result.setText(" Try it harder!Kiddo.\n"
					+ "    You correct "+resultValue+"\n\tout of 20\n       questions.");
		}else {
			result.setText("Oops!Don't worry,\nyou still have\nroom for improvement\n"
					+ "You correct "+resultValue+" out of 20\nquestions.");
		}

		if(percentValue<=100 && percentValue>=90) {
			r3Label.setText("Genius IQ");
		}else if(percentValue<=90 && percentValue>=50) {
			r3Label.setText("High IQ");
		}else if(percentValue<=50 && percentValue>=20) {
			r3Label.setText("BRIGHT");
		}else if(percentValue<=20 && percentValue>=10) {
			r3Label.setText("AVERAGE IQ");
		}else {
			r3Label.setText("LOW IQ");
		}
	}
	private void lan_change() {
		result = new Label();
		if (languageChange) {
			excellent.setText("EXCELLENT!!");
			Font quest_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 24);
			excellent.setFont(quest_font);
			
			Font quest_font1 = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 40);
			result_filter();
			result.setTextFill(Color.WHITE);
			result.setFont(quest_font1);
			StackPane.setAlignment(result, Pos.CENTER);
			StackPane.setMargin(result, new Insets(0,0,70,200));
			if(!r1.getChildren().contains(result)) {
				r1.getChildren().add(result);
			}
			Font quest_font2 = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 30);
			r2Label.setFont(quest_font2);
			r2Label.setTextFill(Color.WHITE);
			r2Label.setText("IQ RESULT:");
			if(!r2.getChildren().contains(r2Label)) {
				r2.getChildren().add(r2Label);
			}
	
			Font quest_font3 = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 30);
			r3Label.setFont(quest_font3);
			r3Label.setTextFill(Color.WHITE);
				r3.getChildren().add(r3Label);
			

			rectangle1.getChildren().add(excellent);
			root.getChildren().addAll(result);

			nonesense = true;
		} else {
			if (nonesense == true) {
				
			}
			root.getChildren().addAll();
		}
	}
}
