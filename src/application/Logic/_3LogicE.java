package application.Logic;

import application.IqQuestions;
import application.IqResultCheck;
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
import javafx.scene.*;
import javafx.scene.control.*;
import application.Mathematics.*;
public class _3LogicE extends Application {
	boolean checker = false;
	Scene scene1;
	Stage currentStage;
	Stage s;
	Scene sc;

	Button back;
	Button forward = new Button();
	Button tryagain = new Button();
	
	Button b1 = new Button();
	Button b2 = new Button();
	Button b3 = new Button();
	
	Label tryagainL = new Label();
	
	Image Arrow = new Image("arrow.png");
	Image forw = new Image("Math/forward.png");
	Image teacher = new Image("Logic/head.png");
	Image brain = new Image("Logic/piece.png");
	Image boy = new Image("Logic/cube.png");
	Image cor = new Image("Math/correct.png");
	Image wro = new Image("Math/wrong.png");
	Image corMM = new Image("Math/correctMM.png");
	Image wroMM = new Image("Math/wrongMM.png");
	Image qEng = new Image("Logic/LogicQ/_3LogicQ.png");
	Image qMM = new Image("Logic/LogicQ/_3LogicQMM.png");
	Image tryAgain = new Image("Math/TryagainMM.png");
	
	Image a1 = new Image("Logic/3LogicAns/a1.png");
	Image a2 = new Image("Logic/3LogicAns/a2.png");
	Image a3 = new Image("Logic/3LogicAns/a3.png");
	
	ImageView backArrow = new ImageView(Arrow);
	ImageView forwImg = new ImageView(forw);
	ImageView teacherImg = new ImageView(teacher);
	ImageView brainImg = new ImageView(brain);
	ImageView boyImg = new ImageView(boy);
	ImageView corImg = new ImageView(cor);
	ImageView wroImg = new ImageView(wro);
	ImageView corMMImg = new ImageView(corMM);
	ImageView wroMMImg = new ImageView(wroMM);
	ImageView qEngImg = new ImageView(qEng);
	ImageView qMMImg = new ImageView(qMM);
	ImageView tryAgainImg = new ImageView(tryAgain);
	
	ImageView a1Img = new ImageView(a1);
	ImageView a2Img = new ImageView(a2);
	ImageView a3Img = new ImageView(a3);
	
	StackPane root;
	StackPane rectangle1 = new StackPane();
	StackPane rectangle2 = new StackPane();
	
	application.Category cat = new application.Category();
	boolean languageChange;
	boolean nonesense = false;
	
	int mark=0;
	
	public void switchToDifficulty(ActionEvent event, boolean languageChange,StackPane proot) {
		this.languageChange = languageChange;
		root = new StackPane();
		root.setStyle("-fx-background-color: #163349");

		elements();
		lan_change();
		// Retrieve the stage from the event source
		currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();

		scene1 = new Scene(root, currentStage.getWidth(), currentStage.getHeight());
		scene1.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		scene1.getStylesheets().add(getClass().getResource("/application/Mathematics/Math.css").toExternalForm());
		currentStage.setScene(scene1);
		currentStage.show();
		proot.getChildren().clear();
	}
	
	/*This is only for developing part*/
	public void start(Stage primaryStage) throws Exception {
		root = new StackPane();
		root.setStyle("-fx-background-color: #163349");
		elements();
		lan_change();
		scene1 = new Scene(root, 1366, 766);
		scene1.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		scene1.getStylesheets().add(getClass().getResource("/application/Mathematics/Math.css").toExternalForm());
		primaryStage.setScene(scene1);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	/*This is only for developing part*/

	private void elements() {
		b1.setGraphic(a1Img);
		b2.setGraphic(a2Img);
		b3.setGraphic(a3Img);
		back = new Button();
		back.getStyleClass().add("lets_start");
		back.setPrefSize(60, 60);
		back.setOnAction(a -> {

			cat.switchToScene1(a, 1, languageChange);
		});
		backArrow.setFitWidth(40);
		backArrow.setFitHeight(30);

		back.setGraphic(backArrow);
		StackPane.setAlignment(back, Pos.TOP_LEFT);
		StackPane.setMargin(back, new Insets(30, 0, 0, 30));// top right bottom left
		
		rectangle1.setMaxWidth(508);
		rectangle1.setStyle("-fx-background-color:WHITE; -fx-background-radius:30px;");
		rectangle1.setMaxHeight(467);
		StackPane.setMargin(rectangle1, new Insets(0,650,0,0));
		
		rectangle2.setMaxWidth(290);
		rectangle2.setStyle("-fx-background-color:WHITE; -fx-background-radius:30px;");
		rectangle2.setMaxHeight(70);
		StackPane.setMargin(rectangle2, new Insets(0,0,550,600));
		
		StackPane.setMargin(b1, new Insets(80,400,300,600));
		StackPane.setMargin(b2, new Insets(80,-400,300,600));
		StackPane.setMargin(b3, new Insets(80,0,-50,600));
		
		int size1 = 196;
		int size2 = 182;
		b1.setMaxSize(size1, size2);
		b2.setMaxSize(size1, size2);
		b3.setMaxSize(size1, size2);
		
		b1.getStyleClass().add("bBut");
		b1.setOnAction(e->{
			clickCorrect();
		});
		b2.getStyleClass().add("bBut");
		b2.setOnAction(e->{
			clickWrong();
		});
		b3.getStyleClass().add("bBut");
		b3.setOnAction(e->{
			clickWrong();
		});
		

		forward.setMaxSize(74,74);
		forward.setGraphic(forwImg);
		forward.getStyleClass().add("forward");
		forward.setOnAction(e->{
			clickForward(e);
		});
		StackPane.setMargin(forward, new Insets(0,0,-400,850));
		
		tryagain.setDisable(true);
		tryagain.setMaxSize(118,40);
		tryagain.getStyleClass().add("forward");
		tryagain.setOnAction(e->{
			clickTryAgain();
		});
		StackPane.setMargin(tryagain, new Insets(0,0,-400,600));
		
		StackPane.setAlignment(teacherImg, Pos.BOTTOM_RIGHT);
		StackPane.setAlignment(brainImg, Pos.TOP_RIGHT);
		StackPane.setAlignment(boyImg, Pos.BOTTOM_LEFT);
		
		root.getChildren().addAll( back,rectangle1,b1,b2,b3,rectangle2,forward,tryagain,teacherImg,brainImg,boyImg);
	}
	private void lan_change() {
		if (languageChange) {
			tryAgainImg.setVisible(false);
			qMMImg.setVisible(false);
			corMMImg.setVisible(false);
			wroMMImg.setVisible(false);
			
			Font quest_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 15);
			tryagainL.setText("Try Again");
			tryagainL.setFont(quest_font);
			tryagainL.setTextFill(Color.WHITE);
			tryagain.setGraphic(tryagainL);
			
			rectangle1.getChildren().add(qEngImg);
			
			root.getChildren().addAll();

			nonesense = true;
		} else {
			if (nonesense == true) {
				tryAgainImg.setVisible(true);
				qMMImg.setVisible(true);
				corMMImg.setVisible(true);
				wroMMImg.setVisible(true);
			}
			tryagain.setGraphic(tryAgainImg);
			rectangle1.getChildren().add(qMMImg);
			
			root.getChildren().addAll();
		}
	}
	private void clickCommon() {
		tryagain.setDisable(false);
		forward.setDisable(false);
		b1.setDisable(true);
		b2.setDisable(true);
		b3.setDisable(true);
	}
	private void clickCorrect() {
		checker = true;
		clickCommon();
		mark = 1;
		if(languageChange) {
			rectangle2.getChildren().add(corImg);
		}else {
			rectangle2.getChildren().add(corMMImg);
		}
	}
	private void clickWrong() {
		checker = false;
		clickCommon();
		mark = 0;
		if(languageChange) {
			rectangle2.getChildren().add(wroImg);
		}else {
			rectangle2.getChildren().add(wroMMImg);
		}
	}
	private void clickTryAgain() {
		rectangle2.getChildren().clear();
		mark = 0;
		tryagain.setDisable(true);
		b1.setDisable(false);
		b2.setDisable(false);
		b3.setDisable(false);
	}
	private void clickForward(ActionEvent e) {
		if(checker) {
			MathResultCheck.check();
		}
		rectangle1.getChildren().clear();
		rectangle2.getChildren().clear();
		switchingQuestionForEasyLogic.switchToQuestions(e, languageChange, root);
		System.out.println(mark);
		b1.setDisable(false);
		b2.setDisable(false);
		b3.setDisable(false);
	}
}
