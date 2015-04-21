import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SMA_TPSession extends Application {
//    public static void main(String[] args) {
//        Environnement env = new Environnement();
//        env.run();
//    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("interface.fxml"));
        Scene scene = new Scene(root, 800, 800);
        scene.getStylesheets().addAll(getClass().getResource("windowStyle.css").toExternalForm());

        primaryStage.setTitle("Air Traffic Simulator (kinda)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
