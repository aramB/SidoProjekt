package sample;

import javafx.scene.SubScene;

public class Queen {
    private int posX;
    private int posY;
    private Pieces pieceType;
    private SubScene piece;

    public Queen(int posX, int posY, Pieces pieceType, SubScene piece) {
        this.posX = posX;
        this.posY = posY;
        this.pieceType = pieceType;
        this.piece = piece;
    }

}
