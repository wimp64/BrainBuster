package application;

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

public class IqTwo extends Application {
	Scene scene1;
	Stage currentStage;
	Stage s;
	Scene sc;

	Button back;
	Button lan_button;

	Text Myanmar;
	Text English;
	Text Lan;

	Image Lang = new Image("lang.png");
	Image Arrow = new Image("arrow.png");

	ImageView langText = new ImageView(Lang);
	ImageView backArrow = new ImageView(Arrow);

	StackPane root;

	boolean languageChange;
	boolean nonesense = false;

	public void switchToIqQuestions(ActionEvent event, boolean languageChange) {
		this.languageChange = languageChange;
		root = new StackPane();
		root.setStyle("-fx-background-color: BLACK");

		elements();
		lan_change();
		// Retrieve the stage from the event source
		currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();

		scene1 = new Scene(root, currentStage.getWidth(), currentStage.getHeight());
		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		currentStage.setScene(scene1);
		currentStage.show();
	}

	/* This is only for developing part */
	public void start(Stage primaryStage) throws Exception {
		root = new StackPane();
		root.setStyle("-fx-background-color: BLACK");
		elements();
		lan_change();
		scene1 = new Scene(root, 1366, 766);
		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene1);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	/* This is only for developing part */

	private void elements() {
		back = new Button();
		back.getStyleClass().add("lets_start");
		back.setPrefSize(60, 60);
		Category cat = new Category();
		back.setOnAction(a -> {
			cat.switchToScene1(a, 1, languageChange);
		});
		backArrow.setFitWidth(40);
		backArrow.setFitHeight(30);

		back.setGraphic(backArrow);
		StackPane.setAlignment(back, Pos.TOP_LEFT);
		StackPane.setMargin(back, new Insets(30, 0, 0, 30));// top right bottom left

		lan_button = new Button();
		lan_button.setPrefSize(78, 39);
		lan_button.getStyleClass().add("lets_start");
		StackPane.setAlignment(lan_button, Pos.TOP_LEFT);
		StackPane.setMargin(lan_button, new Insets(100, 0, 0, 210));
		lan_button.setOnAction(e -> lan_click());
		root.getChildren().addAll(lan_button, back);
	}

	void lan_click() {
		languageChange = !languageChange;
		lan_change();
	}

	private void lan_change() {
		if (languageChange) {
			langText.setVisible(false);

			Lan = new Text("Language:");
			Font lan_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 20);
			Lan.setFont(lan_font);
			Lan.setFill(Color.WHITE);
			StackPane.setAlignment(Lan, Pos.TOP_LEFT);
			StackPane.setMargin(Lan, new Insets(105, 0, 0, 90));

			English = new Text("ENG");
			Font English_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 20);
			English.setFont(English_font);
			English.setFill(Color.WHITE);
			lan_button.setGraphic(English);

			root.getChildren().addAll(Lan);

			nonesense = true;
		} else {
			if (nonesense == true) {
				Lan.setVisible(false);
			}
			langText = new ImageView(Lang);
			langText.setFitWidth(130);
			langText.setFitHeight(20);
			StackPane.setAlignment(langText, Pos.TOP_LEFT);
			StackPane.setMargin(langText, new Insets(110, 0, 0, 70));

			Myanmar = new Text("Myan");
			Font English_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 20);
			Myanmar.setFont(English_font);
			Myanmar.setFill(Color.WHITE);
			lan_button.setGraphic(Myanmar);

			root.getChildren().addAll(langText);
		}
	}
}
