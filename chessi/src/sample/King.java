package sample;

import javafx.scene.SubScene;

public class King {
    private int posX;
    private int posY;
    private Pieces pieceType;
    private SubScene piece;

    public King(int posX, int posY, Pieces pieceType, SubScene piece) {
        this.posX = posX;
        this.posY = posY;
        this.pieceType = pieceType;
        this.piece = piece;
    }

}
