package application;

import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class test extends Application {
	private Pane notificationPane;
	private TranslateTransition notificationTransition;
	Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage; // Declare and initialize primaryStage

		Pane root = new Pane();
		Scene scene = new Scene(root, 400, 300);

		Button showNotificationButton = new Button("Show Notification");
		showNotificationButton.setOnAction(event -> showNotification());

		notificationPane = createNotificationPane();
		root.getChildren().addAll(showNotificationButton, notificationPane);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Custom Notification App");
		primaryStage.show();
	}

	private Pane createNotificationPane() {
		Pane pane = new Pane();
		pane.setPrefSize(400, 40);
		pane.setStyle("-fx-background-color: #2196F3; -fx-background-radius: 5;");

		Text text = new Text("You answered correctly! Yay!");
		text.setFill(Color.WHITE);
		text.setFont(Font.font(16));
		text.setLayoutX(10);
		text.setLayoutY(25);

		pane.getChildren().add(text);
		pane.setLayoutX((400 - pane.getPrefWidth()) / 2);
		pane.setLayoutY(-pane.getPrefHeight());

		return pane;
	}

	private void showNotification() {
		notificationTransition = new TranslateTransition(Duration.seconds(1), notificationPane);
		notificationTransition.setFromY(-notificationPane.getPrefHeight());
		notificationTransition.setToY(0);

		notificationTransition.setOnFinished(event -> {
			PauseTransition delay = new PauseTransition(Duration.seconds(5));
			delay.setOnFinished(e -> hideNotification());
			delay.play();
		});

		notificationTransition.play();
	}

	private void hideNotification() {
		notificationTransition.setFromY(0);
		notificationTransition.setToY(-notificationPane.getPrefHeight());

		notificationTransition.play();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
