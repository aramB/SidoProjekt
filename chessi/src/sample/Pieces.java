package sample;

import javafx.scene.SubScene;

public class Pieces {
    private int posX;
    private int posY;
    private PieceType pieceType;
    private SubScene piece;

    public Pieces(int posX, int posY, PieceType pieceType, SubScene piece) {
        this.posX = posX;
        this.posY = posY;
        this.pieceType = pieceType;
        this.piece = piece;
    }

    public int getPosX() {

        return posX;
    }

    public void setPosX(int posX) {

        this.posX = posX;
    }

    public int getPosY() {

        return posY;
    }

    public void setPosY(int posY) {

        this.posY = posY;
    }

    public PieceType getPieceType() {

        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {

        this.pieceType = pieceType;
    }

    public SubScene getPiece() {

        return piece;
    }

    public void setPiece(SubScene piece) {

        this.piece = piece;
    }
}
