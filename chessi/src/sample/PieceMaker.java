package sample;

import javafx.scene.SubScene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class PieceMaker {

    public static SubScene piecemaker(GridPane board){
        SubScene subScene = null;
        if (board.getRowCount()==1) {
            for (int i = 0; i < 8; i++) {
                ImageView iv = new ImageView("../45px-CHess_pdt45.svg.png");
                subScene = new SubScene(board, 45,45);
            }
        }
        return subScene;
    }

}
