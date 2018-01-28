package sample;

import javafx.scene.Group;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PieceMaker {

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
        //scene.setFill(Color.WHITE);
        return scene;
    }

    private static void selectPiece(SubScene subScene, Pawn pawn){
        subScene.setOnMouseReleased(event -> {
            System.out.println(pawn.getPieceType());
        });
    }

    /**
     *
     * @param board
     */
    public static void piecemaker(GridPane board){
        //white pawn
        for (int i = 0; i < 8; i++) {
            SubScene scenePiece = setPiece("D:\\GitProjects\\SidoProjekt\\chessi\\src\\chessPieces\\whitePawn.png");
            board.add(scenePiece, i,1);
            Pawn pawn = new Pawn(board.getRowIndex(scenePiece), i, Pieces.PAWN, scenePiece);
            selectPiece(scenePiece, pawn);
//            System.out.println(board.getRowIndex(scenePiece));
        }

        //black pawn
        for (int i = 0; i < 8; i++) {
            board.add(setPiece("D:\\GitProjects\\SidoProjekt\\chessi\\src\\chessPieces\\blackPawn.png"), i,6);
        }
    }

}
