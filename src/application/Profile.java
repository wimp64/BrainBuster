package application;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

	public void start(Stage stage) throws Exception {
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
		controller.cancel.setText("CANCEL");
		controller.cancel.setStyle("-fx-text-fill:WHITE");
		controller.cancel.setFont(bottom_font);

		controller.okBtn.setText("OK");
		controller.okBtn.setStyle("-fx-text-fill:WHITE");
		controller.okBtn.setFont(bottom_font);

		controller.titleLabel.setText("Select Your Profile Picture");
		controller.titleLabel.setFont(title_font);
		controller.titleLabel.setStyle("-fx-text-fill:WHITE");
	}

	@FXML
	private void windowClose() {
		Stage stage = (Stage) cancel.getScene().getWindow();
		stage.close();
	}
}
