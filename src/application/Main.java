package application;

import java.util.Optional;

import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	Stage primaryStage;
	public static Scene scene;
	StackPane root;

	Text brain;
	Text buster;
	Text w1;
	Text ls;
	Text Lan;
	Text English;
	Text Myanmar = new Text();

	Label selectLabel;
	Button lets_start;
	Button Eng;
	Button selectButtonNode;
	ButtonType selectButton;

	public static boolean lanSwap = true;
	boolean nonesense = false;

	Image MainText = new Image("MainT.png");
	Image CenterText = new Image("CenterT.png");
	Image Brain = new Image("Brain.png");
	Image Lets = new Image("lets.png");
	Image Lang = new Image("lang.png");
	Image Donut = new Image("donut.png");
	Image Donut0 = new Image("donut0.png");
	Image Cone = new Image("cone.png");
	Image Square = new Image("square.png");
	Image Question = new Image("question.png");
	Image Moon = new Image("moon.png");
	Image Rain = new Image("rain.png");

	ImageView mainText = new ImageView(MainText);
	ImageView centerText = new ImageView(CenterText);
	ImageView letsText = new ImageView(Lets);
	ImageView langText = new ImageView(Lang);
	ImageView donutImg = new ImageView(Donut);
	ImageView donut0Img = new ImageView(Donut0);
	ImageView coneImg = new ImageView(Cone);
	ImageView squareImg = new ImageView(Square);
	ImageView questionImg = new ImageView(Question);
	ImageView moonImg = new ImageView(Moon);
	ImageView rainImg = new ImageView(Rain);

	Category cat = new Category();

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		root = new StackPane();
		scene = new Scene(root, 1366, 766);
		primaryStage.setScene(scene);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		root.setStyle("-fx-background-color: #2385C4;");
		primaryStage.show();
		letStart();
		LanSwitch();
		root.getChildren().add(Eng);
		LanguageChanged();
		styleElements();
	}

	public static void main(String[] args) {
		launch(args);
	}

	void styleElements() {
		Rectangle lineRec = new Rectangle();
		lineRec.setWidth(413);
		lineRec.setHeight(16);
		lineRec.setFill(Color.web("#F6D448"));
		root.setAlignment(Pos.CENTER_LEFT);
		StackPane.setMargin(lineRec, new Insets(350, 0, 0, 150));

		ImageView brain = new ImageView(Brain);
		brain.setFitHeight(325);
		brain.setFitWidth(320);
		StackPane.setAlignment(brain, Pos.CENTER_RIGHT);

		Rectangle centerRec = new Rectangle(475, 380);
		centerRec.setArcHeight(70);
		centerRec.setArcWidth(70);
		centerRec.setFill(Color.WHITE);
		centerRec.setOpacity(0.3);
		StackPane.setAlignment(centerRec, Pos.CENTER);
		StackPane.setMargin(centerRec, new Insets(0, 0, 0, 300));

		donutImg.setFitWidth(140);
		donutImg.setFitHeight(100);
		StackPane.setAlignment(donutImg, Pos.TOP_LEFT);
		StackPane.setMargin(donutImg, new Insets(100, 0, 0, 400));
		TranslateTransition ttD = new TranslateTransition();
		ttD.setByY(50);
		ttD.setCycleCount(TranslateTransition.INDEFINITE);
		ttD.setAutoReverse(true);
		ttD.setNode(donutImg);
		ttD.setDuration(Duration.seconds(10));

		donut0Img.setFitWidth(130);
		donut0Img.setFitHeight(115);
		StackPane.setAlignment(donut0Img, Pos.TOP_CENTER);
		StackPane.setMargin(donut0Img, new Insets(50, 0, 0, 250));
		ScaleTransition st = new ScaleTransition();
		st.setToX(1.2);
		st.setToY(1.2);
		st.setAutoReverse(true);
		st.setCycleCount(ScaleTransition.INDEFINITE);
		st.setDuration(Duration.seconds(1.5));
		st.setNode(donut0Img);

		coneImg.setFitWidth(100);
		coneImg.setFitHeight(105);
		StackPane.setAlignment(coneImg, Pos.TOP_RIGHT);
		StackPane.setMargin(coneImg, new Insets(50, 50, 0, 0));
		RotateTransition rotateCone = new RotateTransition();
		rotateCone.setByAngle(360);
		rotateCone.setDuration(Duration.seconds(20));
		rotateCone.setCycleCount(RotateTransition.INDEFINITE);
		rotateCone.setAutoReverse(false);
		rotateCone.setNode(coneImg);
		ScaleTransition stc = new ScaleTransition();
		stc.setToX(1.5);
		stc.setToY(1.5);
		stc.setAutoReverse(true);
		stc.setCycleCount(ScaleTransition.INDEFINITE);
		stc.setDuration(Duration.seconds(5));
		stc.setNode(coneImg);

		squareImg.setFitWidth(120);
		squareImg.setFitHeight(100);
		StackPane.setAlignment(squareImg, Pos.BOTTOM_CENTER);
		StackPane.setMargin(squareImg, new Insets(0, 250, 50, 0));
		TranslateTransition tt = new TranslateTransition();
		tt.setByX(-100);
		tt.setCycleCount(TranslateTransition.INDEFINITE);
		tt.setAutoReverse(true);
		tt.setNode(squareImg);
		tt.setDuration(Duration.seconds(10));

		questionImg.setFitWidth(110);
		questionImg.setFitHeight(155);
		StackPane.setAlignment(questionImg, Pos.BOTTOM_CENTER);
		StackPane.setMargin(questionImg, new Insets(0, 0, 55, 250));
		RotateTransition rotateQuestion = new RotateTransition();
		rotateQuestion.setByAngle(360);
		rotateQuestion.setDuration(Duration.seconds(20));
		rotateQuestion.setCycleCount(RotateTransition.INDEFINITE);
		rotateQuestion.setAutoReverse(false);
		rotateQuestion.setNode(questionImg);

		moonImg.setFitWidth(150);
		moonImg.setFitHeight(130);
		StackPane.setAlignment(moonImg, Pos.BOTTOM_RIGHT);
		StackPane.setMargin(moonImg, new Insets(0, 100, 80, 0));
		RotateTransition rotateMoon = new RotateTransition();
		rotateMoon.setByAngle(-360);
		rotateMoon.setDuration(Duration.seconds(20));
		rotateMoon.setCycleCount(RotateTransition.INDEFINITE);
		rotateMoon.setAutoReverse(false);
		rotateMoon.setNode(moonImg);

		rainImg.setFitWidth(123);
		rainImg.setFitHeight(133);
		StackPane.setAlignment(rainImg, Pos.BOTTOM_LEFT);

		ParallelTransition parallelTransition = new ParallelTransition();
		parallelTransition.getChildren().addAll(rotateCone, rotateMoon, rotateQuestion, tt, ttD, st, stc);
		parallelTransition.play();

		root.getChildren().addAll(rainImg, lineRec, brain, centerRec, donutImg, donut0Img, coneImg, squareImg,
				questionImg, moonImg);
	}

	void letStart() {
		lets_start = new Button();
		lets_start.getStyleClass().add("lets_start");
		lets_start.setPrefSize(180, 83);
		StackPane.setMargin(lets_start, new Insets(500, 0, 0, 90));
		lets_start.setOnAction(event -> {
			AgeAccept(event);
		});
		root.getChildren().add(lets_start);
	}

	private void AgeAccept(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("This is an information dialog box.");

		// Set the alert's modality
		alert.initModality(Modality.APPLICATION_MODAL);

		ComboBox<Integer> ageBox = new ComboBox<>();
		for (int i = 1; i <= 18; i++) {
			ageBox.getItems().addAll(i);
		}
		ageBox.setPrefSize(75, 25);
		ageBox.setStyle("-fx-font-size: 16px;");
		ageBox.getSelectionModel().selectLast();

		DialogPane dialogPane = alert.getDialogPane();
		dialogPane.getButtonTypes().setAll(selectButton);

		alert.getButtonTypes().setAll(selectButton);

		Image Bear = new Image("Bear.png");
		ImageView alertLogo = new ImageView(Bear);
		alertLogo.setFitWidth(90);
		alertLogo.setFitHeight(90);
		alert.setGraphic(alertLogo);

		StackPane alertPane = new StackPane();
		alertPane.setAlignment(Pos.CENTER_LEFT);
		StackPane.setMargin(ageBox, new Insets(0, 0, 0, 200));
		alertPane.getChildren().addAll(selectLabel, ageBox);
		StackPane.setMargin(selectLabel, new Insets(0, 0, 0, 5));

		dialogPane.setContent(alertPane);

		// Apply custom CSS to change the dialog background color to black
		dialogPane.setStyle("-fx-background-color: #FFD93D;");

		selectButtonNode = (Button) dialogPane.lookupButton(selectButton);

		if (selectButtonNode != null) {
			selectButtonNode.setPrefSize(125, 50);
			selectButtonNode.setStyle(
					"-fx-background-color: #DF5A1C;" + "-fx-border-radius: 200;" + "-fx-background-radius: 50;"
							+ "-fx-font-size: 19px;" + "-fx-text-fill: WHITE;" + "-fx-font-family: 'Poppins';");

			selectButtonNode.setOnMousePressed(e -> {
				selectButtonNode.setScaleX(0.96);
				selectButtonNode.setScaleY(0.96);
			});

			selectButtonNode.setOnMouseReleased(e -> {
				selectButtonNode.setScaleX(1.0);
				selectButtonNode.setScaleY(1.0);
			});

			selectButtonNode.setOnMouseEntered(e -> {
				selectButtonNode.setStyle(
						"-fx-background-color: #20AB2E;" + "-fx-border-radius: 200;" + "-fx-background-radius: 50;"
								+ "-fx-font-size: 19px;" + "-fx-text-fill: WHITE;" + "-fx-font-family: 'Poppins';");
			});

			selectButtonNode.setOnMouseExited(e -> {
				selectButtonNode.setStyle(
						"-fx-background-color: #DF5A1C;" + "-fx-border-radius: 200;" + "-fx-background-radius: 50;"
								+ "-fx-font-size: 19px;" + "-fx-text-fill: WHITE;" + "-fx-font-family: 'Poppins';");
			});
		}
		// Show the dialog box and wait for user response
		Optional<ButtonType> result = alert.showAndWait();

		// Optional: Handle the Select button click event
		if (result.isPresent() && result.get() == selectButton) {
			int selectValue = ageBox.getValue();
			cat.switchToScene1(event, selectValue, lanSwap);
		}
	}

	void LanSwitch() {
		Eng = new Button();
		Eng.getStyleClass().add("lets_start");
		Eng.setPrefSize(78, 39);
		StackPane.setAlignment(Eng, Pos.TOP_LEFT);
		StackPane.setMargin(Eng, new Insets(100, 0, 0, 210));
		Eng.setOnAction(event -> LanClick());
		// root.getChildren().add(Eng);
	}

	void LanClick() {
		lanSwap = !lanSwap;
		LanguageChanged();
	}

	void LanguageChanged() {

		if (lanSwap) {
			mainText.setVisible(false);
			centerText.setVisible(false);
			letsText.setVisible(false);
			langText.setVisible(false);
			Myanmar.setVisible(false);

			brain = new Text("BRAIN");
			buster = new Text("BUSTER");
			Font custom_brain_buster_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 100);
			brain.setFont(custom_brain_buster_font);
			brain.setFill(Color.WHITE);
			buster.setFont(custom_brain_buster_font);
			buster.setFill(Color.WHITE);

			StackPane.setMargin(brain, new Insets(0, 0, 0, 90));// top right bottom left
			StackPane.setMargin(buster, new Insets(200, 0, 0, 90));
			root.setAlignment(Pos.CENTER_LEFT);

			w1 = new Text("   \"Welcome to\nthe Brain Buster\n      game! Let's\n  begin the fun.\"");
			Font w_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 40);
			w1.setFont(w_font);
			w1.setFill(Color.WHITE);
			StackPane.setAlignment(w1, Pos.CENTER);
			StackPane.setMargin(w1, new Insets(0, 0, 0, 300));

			ls = new Text("Let's Start");
			Font ls_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 25);
			ls.setFont(ls_font);
			ls.setFill(Color.WHITE);

			lets_start.setGraphic(ls);

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
			Eng.setGraphic(English);

			Font select_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 16);
			selectLabel = new Label("Please select your age.");
			selectLabel.setFont(select_font);
			selectLabel.setTextFill(Color.BLACK);

			selectButton = new ButtonType("Select");

			root.getChildren().addAll(brain, buster, w1, Lan);
			nonesense = true;
		} else {
			if (nonesense == true) {
				Lan.setVisible(false);
				English.setVisible(false);
				brain.setVisible(false);
				buster.setVisible(false);
				w1.setVisible(false);
				ls.setVisible(false);
			}
			;
			mainText = new ImageView(MainText);
			mainText.setFitWidth(400);
			mainText.setFitHeight(275);

			root.setAlignment(Pos.CENTER_LEFT);
			StackPane.setMargin(mainText, new Insets(60, 0, 0, 90));

			centerText = new ImageView(CenterText);
			centerText.setFitWidth(400);
			centerText.setFitHeight(275);

			StackPane.setAlignment(centerText, Pos.CENTER);
			StackPane.setMargin(centerText, new Insets(0, 0, 0, 300));

			letsText = new ImageView(Lets);
			letsText.setFitWidth(120);
			letsText.setFitHeight(45);

			lets_start.setGraphic(letsText);

			langText = new ImageView(Lang);
			langText.setFitWidth(130);
			langText.setFitHeight(20);
			StackPane.setAlignment(langText, Pos.TOP_LEFT);
			StackPane.setMargin(langText, new Insets(110, 0, 0, 70));

			Myanmar = new Text("Myan");
			Font English_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 20);
			Myanmar.setFont(English_font);
			Myanmar.setFill(Color.WHITE);
			Eng.setGraphic(Myanmar);

			root.getChildren().addAll(mainText, centerText, langText);
		}
	}
}
