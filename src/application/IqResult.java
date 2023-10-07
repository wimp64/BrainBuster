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
import javafx.util.*;
import javafx.scene.control.*;

public class IqResult{
	
	Scene scene1;
	Stage currentStage;
	String s;
	Scene sc;

	Button back;
	
	Label result;
	
	Image Arrow = new Image("arrow.png");

	
	ImageView backArrow = new ImageView(Arrow);
	
	StackPane root;

	boolean languageChange;
	boolean nonesense = false;
	
	public void switchToDifficulty(ActionEvent event, boolean languageChange,StackPane proot) {
		s = String.valueOf(IqResultCheck.getScore());
		this.languageChange = languageChange;
		root = new StackPane();
		root.setStyle("-fx-background-color: #EDC7A3");
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
//		root.setStyle("-fx-background-color: #EDC7A3");
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
		
		root.getChildren().addAll( back);
	}
	
	private void lan_change() {
		result = new Label();
		if (languageChange) {
			
			System.out.println(s);
			result.setText(s);
			root.getChildren().addAll(result);

			nonesense = true;
		} else {
			if (nonesense == true) {
				
			}

			root.getChildren().addAll();
		}
	}
}
