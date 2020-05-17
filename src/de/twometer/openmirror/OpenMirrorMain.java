package de.twometer.openmirror;

import de.twometer.openmirror.io.ResourceLoader;
import de.twometer.openmirror.web.WebServerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class OpenMirrorMain extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        WebServerController webServerController = new WebServerController();
        webServerController.start();

        FXMLLoader loader = new FXMLLoader(ResourceLoader.getResource("layout/main.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        scene.getStylesheets().add(ResourceLoader.getResource("css/main.css").toExternalForm());
        scene.setCursor(Cursor.NONE);

        primaryStage.setTitle("OpenMirror Frontend");
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.setFullScreenExitHint(null);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
