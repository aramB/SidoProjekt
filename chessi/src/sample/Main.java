package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.List;

/**
 * The entry point of the app
 */
public class Main extends Application {

    private final static int HEIGHT = 820;
    private final static int WIDTH = 820;
    public static boolean isSelected = false;
    public static Pieces currentPiece;


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
        PieceMaker.pieceSetters(board);
		System.out.println("listans storlek: " + PieceMaker.pieceList.size());

        primaryStage.setTitle("Chessiiiiiiiiiiii");
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
                board.getColumnConstraints().add(column);
                board.getRowConstraints().add(row);
            }
        }
        select(board, PieceMaker.pieceList);
    }


	public static void select(GridPane board, List<Pieces> pieceList) {
		//TODO -- eventhandler på hela brädet
		board.setOnMouseReleased(event -> {
			System.out.println("x: " + (int)((event.getSceneX() - (event.getSceneX() % 8)) / 100) +
							   ", y: " + (int)((event.getSceneY() - (event.getSceneY() % 8)) / 100));
			for (Pieces piece: pieceList) {
				if (piece.getPosX() == (int)((event.getSceneX() - (event.getSceneX() % 8)) / 100)
					&& piece.getPosY() == (int)((event.getSceneY() - (event.getSceneY() % 8)) / 100)
						&& !isSelected) {
					System.out.println("pieceType: " + piece.getPieceType());
					isSelected = true;
					piece.setSelected(true);
					currentPiece = piece;
					currentPiece.getPieceScene().setFill(Color.color(1, 0, 0));
				}
				else if (piece.getPosX() == (int)((event.getSceneX() - (event.getSceneX() % 8)) / 100)
									&& piece.getPosY() == (int)((event.getSceneY() - (event.getSceneY() % 8)) / 100)
										&& isSelected) {
					if ((board.getRowIndex(currentPiece.getPieceScene()) % 2 == 0 &&
						 board.getColumnIndex(currentPiece.getPieceScene()) % 2 == 0) ||
						(board.getRowIndex(currentPiece.getPieceScene()) % 2 == 1 &&
						 board.getColumnIndex(currentPiece.getPieceScene()) % 2 == 1)) {
						isSelected = false;
						currentPiece.setSelected(false);
						currentPiece.getPieceScene().setFill(Color.GRAY);
					}
					else {
						isSelected = false;
						currentPiece.setSelected(false);
						currentPiece.getPieceScene().setFill(Color.GREEN);
					}
				}
			}
		});
	}
/*    private static void circleTest(GridPane board) {
        board.setOnMouseReleased(me -> {
			try {
				board.add(PieceMaker.sceneMaker(""), (int)((me.getSceneX() - (me.getSceneX() % 8)) / 100),
				(int)((me.getSceneY() - (me.getSceneY() % 8)) / 100)); //here the sceneMaker argument could be between 1-7
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println(" **** "+ (int)((me.getSceneX() - (me.getSceneX() % 8)) / 100)+", "+ (int)((me.getSceneY() - (me.getSceneY() % 8)) / 100));
        });

    }*/
}