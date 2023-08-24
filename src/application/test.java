package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class test extends Application {

	@Override
	public void start(Stage primaryStage) {
		StackPane root = new StackPane();

		Rectangle blackRectangle = new Rectangle(0, 0, 0, primaryStage.getHeight());
		blackRectangle.setFill(Color.BLACK);
		blackRectangle.widthProperty().bind(primaryStage.widthProperty().divide(2));

		Rectangle whiteRectangle = new Rectangle(0, 0, 0, primaryStage.getHeight());
		whiteRectangle.setFill(Color.WHITE);
		whiteRectangle.widthProperty().bind(primaryStage.widthProperty().divide(2));
		whiteRectangle.translateXProperty().bind(primaryStage.widthProperty().divide(2));

		root.getChildren().addAll(blackRectangle, whiteRectangle);

		Scene scene = new Scene(root, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Half Black Half White Background");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
