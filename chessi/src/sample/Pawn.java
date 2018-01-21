package sample;

import javafx.scene.SubScene;

public class Pawn {
    private int posX;
    private int posY;
    private Pieces pieceType;
    private SubScene piece;

    public Pawn(int posX, int posY, Pieces pieceType, SubScene piece) {
        this.posX = posX;
        this.posY = posY;
        this.pieceType = pieceType;
        this.piece = piece;
    }
}
