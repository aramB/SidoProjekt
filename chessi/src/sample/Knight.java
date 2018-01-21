package sample;

import javafx.scene.SubScene;

public class Knight {
    private int posX;
    private int posY;
    private Pieces pieceType;
    private SubScene piece;

    public Knight(int posX, int posY, Pieces pieceType, SubScene piece) {
        this.posX = posX;
        this.posY = posY;
        this.pieceType = pieceType;
        this.piece = piece;
    }
}
