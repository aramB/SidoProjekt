package sample;

import javafx.scene.SubScene;

public class Rook {
    private int posX;
    private int posY;
    private Pieces pieceType;
    private SubScene piece;

    public Rook(int posX, int posY, Pieces pieceType, SubScene piece) {
        this.posX = posX;
        this.posY = posY;
        this.pieceType = pieceType;
        this.piece = piece;
    }


}
