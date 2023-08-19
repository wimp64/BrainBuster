package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class test extends Application {
	Timeline timeline;
	private static final int COUNTDOWN_SECONDS = 15;
	private int remainingSeconds = COUNTDOWN_SECONDS;
	private Label timerLabel = new Label();

	@Override
	public void start(Stage primaryStage) {
		StackPane root = new StackPane(timerLabel);
		Scene scene = new Scene(root, 200, 100);

		timerLabel.setStyle("-fx-font-size: 24px;");
		updateTimerLabel();

		timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
			remainingSeconds--;
			updateTimerLabel();
			System.out.println(remainingSeconds);
			if (remainingSeconds <= 0) {
				timeline.stop();
			}
		}));
		timeline.setCycleCount(COUNTDOWN_SECONDS);
		timeline.play();

		primaryStage.setTitle("Countdown Timer");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void updateTimerLabel() {
		timerLabel.setText("Time left: " + remainingSeconds + " seconds");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
