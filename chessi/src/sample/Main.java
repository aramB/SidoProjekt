package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private final static int HEIGHT = 820;
    private final static int WIDTH = 820;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(false);
        GridPane board = new GridPane();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        board.setPadding(new Insets(10, 10, 10, 10));

        makeGrid(8, 8, board);

        primaryStage.setTitle("Chessi");
        primaryStage.setScene(new Scene(board, WIDTH, HEIGHT, Color.WHITE));
        primaryStage.show();
    }


    public static void makeGrid(int rowS, int col, GridPane board) {
        board.setGridLinesVisible(false);
        for (int i = 0; i < rowS; i++) {
            for (int j = 0; j < col; j++) {
                Text tx = new Text(i+", "+j);
                Rectangle rect = new Rectangle(100,100);
                if ((i%2==0 && j%2==0) || (i%2==1 && j%2==1)){
                    rect.setFill(Color.GRAY);
                }
                else {
                    rect.setFill(Color.GREEN);
                }
                ColumnConstraints column = new ColumnConstraints(100);
                board.add(rect, i, j);
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
        board.setOnMouseReleased(me -> {
            board.add(Anims.getAnim(), (int)((me.getSceneX() - (me.getSceneX() % 8)) / 100), (int)((me.getSceneY() - (me.getSceneY() % 8)) / 100)); //here the getAnim argument could be between 1-7
            System.out.println(Anims.getAnim()+" **** "+ (int)((me.getSceneX() - (me.getSceneX() % 8)) / 100)+", "+ (int)((me.getSceneY() - (me.getSceneY() % 8)) / 100)); //here the getAnim argument could be between 1-7
        });

    }
}