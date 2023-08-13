package application;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Profile extends Application {
	@FXML
	private Button cancel;

	@FXML
	private Button okBtn;

	@FXML
	private Label titleLabel;

	@FXML
	private StackPane zero;

	@FXML
	private StackPane one;

	private StackPane selectedPane = null;

	Image eai = new Image("Profile/eaistein.png");
	Image cc = new Image("Profile/cancel.png");
	Image ok = new Image("Profile/Okay.png");
	Image select = new Image("Profile/SelectYour.png");

	ImageView ProfileImg = new ImageView(eai);
	ImageView ccImg = new ImageView(cc);
	ImageView okImg = new ImageView(ok);
	ImageView selectImg = new ImageView(select);

	String colorCode = "WHITE";
	Stage stage;
	boolean languageChange;

	public void start(Stage stage, boolean lan) throws Exception {
		languageChange = lan;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("profile.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		scene.setFill(Color.TRANSPARENT);
		bottomBar(loader);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}

	private void bottomBar(FXMLLoader loader) {
		Profile controller = loader.getController();
		Font bottom_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 15);
		Font title_font = Font.loadFont(getClass().getResourceAsStream("/Poppin.ttf"), 16);

		if (languageChange) {
			controller.cancel.setText("CANCEL");
			controller.cancel.setStyle("-fx-text-fill:WHITE");
			controller.cancel.setFont(bottom_font);

			controller.okBtn.setText("OK");
			controller.okBtn.setStyle("-fx-text-fill:WHITE");
			controller.okBtn.setFont(bottom_font);

			controller.titleLabel.setText("Select Your Profile Picture");
			controller.titleLabel.setFont(title_font);
			controller.titleLabel.setStyle("-fx-text-fill:WHITE");
		} else {
			ImageView ccImg = new ImageView(cc);
			ccImg.setFitWidth(65);
			ccImg.setFitHeight(25);

			ImageView okImg = new ImageView(ok);
			okImg.setFitWidth(65);
			okImg.setFitHeight(25);

			ImageView selectImg = new ImageView(select);
			selectImg.setFitWidth(100);
			controller.titleLabel.setAlignment(Pos.CENTER);
			selectImg.setFitHeight(25);

			controller.cancel.setGraphic(ccImg);
			controller.okBtn.setGraphic(okImg);
			controller.titleLabel.setGraphic(selectImg);
		}
	}

	@FXML
	private void windowClose() {
		stage = (Stage) cancel.getScene().getWindow();
		stage.close();
	}

	ImageView im;

	@FXML
	private void windowOk() {
		stage = (Stage) okBtn.getScene().getWindow();
		stage.close();

		Category.profile.setGraphic(im);

		Category.profile.setStyle("-fx-background-color:" + colorCode);
	}

	@FXML
	void choose(MouseEvent event) {
		StackPane clickPane = (StackPane) event.getSource();
		im = (ImageView) ((StackPane) event.getSource()).getChildren().get(0);

		ObservableList<String> styleClasses = clickPane.getStyleClass();

		if (selectedPane != null) {
			ObservableList<String> styleClassesSelect = selectedPane.getStyleClass();
			if (styleClassesSelect.contains("middle-ch-bg-eai-choose")) {
				selectedPane.getStyleClass().remove("middle-ch-bg-eai-choose");
			} else {
				selectedPane.getStyleClass().remove("middle-ch-bg-choose");
			}
		}

		if (styleClasses.contains("middle-ch-bg-eai")) {
			colorCode = "#EFE400";
			clickPane.getStyleClass().add("middle-ch-bg-eai-choose");
		} else {
			colorCode = "WHITE";
			clickPane.getStyleClass().add("middle-ch-bg-choose");
		}
		selectedPane = clickPane;
	}

	@Override
	public void start(Stage arg0) throws Exception {

	}
}
