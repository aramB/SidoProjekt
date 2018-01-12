package sample;

import javafx.animation.Animation;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    private final static int HEIGHT = 800;
    private final static int WIDTH = 800;

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane board = new GridPane();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        makeGrid(8, 8, board);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(board, WIDTH, HEIGHT, Color.WHITE));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


    public static void makeGrid(int rowS, int col, GridPane board) {
        board.setGridLinesVisible(true);
//        board.getStyleClass().add("game-grid");
        for (int i = 0; i < rowS; i++) {
            for (int j = 0; j < col; j++) {
                Text tx = new Text("hej");
                ColumnConstraints column = new ColumnConstraints(100);
                board.add(tx, i, j);
                board.getColumnConstraints().add(column);
                RowConstraints row = new RowConstraints(100);
                board.getRowConstraints().add(row);
            }
        }
        pieceMarker(board);
    }


    public static void pieceMarker(GridPane board) {
//        board.setOnMouseReleased(new EventHandler<MouseEvent>() {
//            public void handle(MouseEvent event) {
//                System.out.println("x-coord: "+event.getSceneX()%8+ " =========== y-coord: " + event.getSceneY()%8);
//            }
//        });
        board.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                try {
                    board.add(Anims.getAnim(1), (int)((me.getSceneX() - (me.getSceneX() % 40)) / 40), (int)((me.getSceneY() - (me.getSceneY() % 40)) / 40)); //here the getAnim argument could be between 1-7
                    System.out.println("x-coord: "+me.getSceneX()%8+ " =========== y-coord: " + me.getSceneY()%8);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}