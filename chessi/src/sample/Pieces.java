package sample;

import javafx.scene.SubScene;

public class Pieces {
    private int posX;
    private int posY;
    private PieceType pieceType;
    private SubScene pieceScene;
    private boolean selected;

    public Pieces(int posX, int posY, PieceType pieceType, SubScene pieceScene) {
        this.posX = posX;
        this.posY = posY;
        this.pieceType = pieceType;
        this.pieceScene = pieceScene;
        selected = false;
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

    public SubScene getPieceScene() {

        return pieceScene;
    }

    public void setPieceScene(SubScene pieceScene) {

        this.pieceScene = pieceScene;
    }

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(final boolean selected) {
		this.selected = selected;
	}
}
