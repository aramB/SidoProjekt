package sample;

import javafx.scene.Group;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PieceMaker {

    public static SubScene setWhitePawns(String path) throws FileNotFoundException {
        //Circle circle = new Circle(20, 20f, 15);
        FileInputStream inputstream = new FileInputStream(path);
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

    public static void piecemaker(GridPane board) throws FileNotFoundException {
        for (int i = 0; i < 8; i++) {
            board.add(setWhitePawns("D:\\GitProjects\\SidoProjekt\\chessi\\src\\chessPieces\\whitePawn.png"), i,1);
            board.add(setWhitePawns("D:\\GitProjects\\SidoProjekt\\chessi\\src\\chessPieces\\blackPawn.png"), i,6);
        }
        //return subScene;
    }

}
