package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Main extends Application {

    private final static int HEIGHT = 820;
    private final static int WIDTH = 820;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setResizable(false);
        GridPane board = new GridPane();
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        board.setPadding(new Insets(10, 10, 10, 10));

        makeBoard(8, 8, board);
        PieceMaker.piecemaker(board);

        primaryStage.setTitle("Chessi");
        primaryStage.setScene(new Scene(board, WIDTH, HEIGHT, Color.WHITE));
        primaryStage.show();
    }


    private static void makeBoard(int rowS, int col, GridPane board) {
        board.setGridLinesVisible(false);
        for (int i = 0; i < rowS; i++) {
            for (int j = 0; j < col; j++) {
                Rectangle rect = new Rectangle(100,100);
                if ((i%2==0 && j%2==0) || (i%2==1 && j%2==1)){
                    rect.setFill(Color.GRAY);
                }
                else {
                    rect.setFill(Color.GREEN);
                }

                ColumnConstraints column = new ColumnConstraints(100);
                RowConstraints row = new RowConstraints(100);

                board.add(rect, i, j);
                /*Text tx = new Text(i + ", " + j);
                board.add(tx, i, j);*/
                board.getColumnConstraints().add(column);
                board.getRowConstraints().add(row);
            }
        }
        circleTest(board);
    }


    private static void circleTest(GridPane board) {
        board.setOnMouseReleased(event -> {

        });

    }


/*    private static void circleTest(GridPane board) {
        board.setOnMouseReleased(me -> {
			try {
				board.add(PieceMaker.setPiece(""), (int)((me.getSceneX() - (me.getSceneX() % 8)) / 100), (int)((me.getSceneY() - (me.getSceneY() % 8)) / 100)); //here the setPiece argument could be between 1-7
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println(" **** "+ (int)((me.getSceneX() - (me.getSceneX() % 8)) / 100)+", "+ (int)((me.getSceneY() - (me.getSceneY() % 8)) / 100));
        });

    }*/
}