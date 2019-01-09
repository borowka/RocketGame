package game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    static AnchorPane root;
    static List<AnchorPane> panes = new ArrayList<>();
    public static int idxCurrent = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            root = FXMLLoader.load(getClass().getResource("views/anchor.fxml"));
            panes.add(FXMLLoader.load(getClass().getResource("views/start.fxml")));
            panes.add(FXMLLoader.load(getClass().getResource("views/menu.fxml")));
            panes.add(FXMLLoader.load(getClass().getResource("views/game.fxml")));
            root.getChildren().add(panes.get(0));
            Scene scene = new Scene(root, 800, 600);
            FileInputStream inputStream = new FileInputStream("cursor.png");
            Image image = new Image(inputStream);
            Cursor cursor = new ImageCursor(image);
            scene.setCursor(cursor);
            scene.getStylesheets().add(getClass().getResource("css/Style.css").toExternalForm());
            primaryStage.setTitle("SPACESHIP GAME");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e ){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void setPane(int idx){
        root.getChildren().remove(panes.get(idxCurrent));
        root.getChildren().add(panes.get(idx));
        idxCurrent = idx;
    }

    public static AnchorPane getPane(int idx){
        return panes.get(idx);
    }

}
