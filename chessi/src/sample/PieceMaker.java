package sample;

import javafx.scene.Group;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class PieceMaker {

    List<Pieces> pieces = new ArrayList<>();

    public static SubScene setPiece(String path) {
        //Circle circle = new Circle(20, 20f, 15);
        FileInputStream inputstream = null;
        try {
            inputstream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert inputstream != null;
        Image image = new Image(inputstream);
        ImageView imgV = new ImageView(image);
        imgV.setX(28);
        imgV.setY(28);
        //circle.setFill(Color.RED);
        Group group = new Group();
        group.getChildren().add(imgV);
        SubScene scene = new SubScene(group, 100, 100);
        scene.setFill(Color.TRANSPARENT);
        return scene;
    }


    /**
     *
     * @param board
     */
    public static void piecemaker(GridPane board){
        AtomicReference<Boolean> selected = new AtomicReference<>(false);
        //white pawn
        for (int i = 0; i < 8; i++) {
            SubScene scenePiece = setPiece("F:\\SidoProjekt\\chessi\\src\\chessPieces\\whitePawn.png");
            board.add(scenePiece, i,1);
            Pawn pawn = new Pawn(board.getRowIndex(scenePiece), board.getColumnIndex(scenePiece), PieceType.PAWN, scenePiece);
            scenePiece.setOnMouseReleased(event -> {
                if (!selected.get()) {
                    scenePiece.setFill(Color.LIGHTCYAN);
                    selected.set(true);
                }
                else {
                    scenePiece.setFill(Color.TRANSPARENT);
                    selected.set(false);
                }
            });
            //            System.out.println(board.getRowIndex(scenePiece));
        }

        //black pawn
        for (int i = 0; i < 8; i++) {
            board.add(setPiece("F:\\SidoProjekt\\chessi\\src\\chessPieces\\blackPawn.png"), i,6);
        }
    }

}
