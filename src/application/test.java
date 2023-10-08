package application;  
import javafx.application.Application;  
import javafx.scene.Scene;  
import javafx.scene.control.ProgressIndicator;  
import javafx.scene.layout.StackPane;  
import javafx.stage.Stage;
import javafx.util.Duration;  
import javafx.animation.*;
public class test extends Application{  
  
    @Override  
    public void start(Stage primaryStage) throws Exception {  
    	

        // TODO Auto-generated method stub  
    
        StackPane root = new StackPane();  
          
        Scene scene = new Scene(root,300,200);  
        scene.getStylesheets().add(getClass().getResource("IqQuestion.css").toExternalForm());
        ProgressIndicator PI=new ProgressIndicator();  
        PI.setMaxSize(500, 500);
        root.getChildren().add(PI);
        PI.getStyleClass().add("cpi");
        primaryStage.setScene(scene);  
        primaryStage.setTitle("Progress Indicator Example");  
        primaryStage.show();  
        double targetValue = 0.7;
        Duration duration = Duration.seconds(2); // Animation duration (in this case, 3 seconds)

        // Create a Timeline to animate the ProgressIndicator to the target value
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(PI.progressProperty(), 0)),
                new KeyFrame(duration, new KeyValue(PI.progressProperty(), targetValue))
        );
        timeline.play();
          
    }  
    public static void main(String[] args) {  
        launch(args);  
    }  
  
}  