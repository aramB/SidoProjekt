package sample;

import javafx.scene.Group;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PieceMaker {

	public static List<Pieces> pieceList = new ArrayList<>();

	public static void pieceSetters(GridPane board){
		pawnMaker(board);
		kingMaker(board);
		queenMaker(board);
		bishopMaker(board);
		knightMaker(board);
		rookMaker(board);
	}


	/**
	 * Returns a subscene/img
	 * @param path
	 * @return
	 */
	private static SubScene sceneMaker(String path) {
        //Circle circle = new Circle(20, 20f, 15);
		SubScene scene = null;
        try {
            FileInputStream inputstream = new FileInputStream(path);
			Image image = new Image(inputstream);
			ImageView imgV = new ImageView(image);
			imgV.setX(28);
			imgV.setY(28);
			//circle.setFill(Color.RED);
			Group group = new Group();
			group.getChildren().add(imgV);
			scene = new SubScene(group, 100, 100);
			scene.setFill(Color.TRANSPARENT);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		return scene;
    }


    /**
     * sätter ut både vita och svarta bönder/pawns
     * @param board
     */
    private static void pawnMaker(GridPane board){
    	// TODO -- select solution not done!!
        for (int i = 0; i < 8; i++) {
			//white pawn
            SubScene whitePawnScene = sceneMaker("src/chessPieces/whitePawn.png");
            board.add(whitePawnScene, i,1);
            Pawn whitePawn = new Pawn(board.getRowIndex(whitePawnScene), board.getColumnIndex(whitePawnScene), PieceType.PAWN, whitePawnScene);
            pieceList.add(whitePawn);
            whitePawnScene.setOnMouseReleased(event -> {
            	System.out.println(whitePawn.getPieceType() + " clicked!");
				if (!whitePawn.isSelected()) {
					for (Pieces item : pieceList) {
						if (!Objects.equals(item, whitePawn) && item.isSelected()) {
							if ((board.getRowIndex(whitePawnScene) % 2 == 0 && board.getColumnIndex(whitePawnScene) % 2 == 0) ||
								(board.getRowIndex(whitePawnScene) % 2 == 1 && board.getColumnIndex(whitePawnScene) % 2 == 1)) {
								item.setSelected(false);
								whitePawnScene.setFill(Color.GRAY);
								System.out.println("i if satsen");
								break;
							}
							else {
								item.setSelected(false);
								whitePawnScene.setFill(Color.GREEN);
								System.out.println("i else satsen");
								break;
							}
						}
						whitePawn.setSelected(true);
						whitePawnScene.setFill(Color.LIGHTGOLDENRODYELLOW);
					}
				}
				else {
					whitePawn.setSelected(false);
					if ((board.getRowIndex(whitePawnScene) % 2 == 0 && board.getColumnIndex(whitePawnScene) % 2 == 0) ||
						(board.getRowIndex(whitePawnScene) % 2 == 1 && board.getColumnIndex(whitePawnScene) % 2 == 1)) {
						whitePawnScene.setFill(Color.GRAY);
					}
					else {
						whitePawnScene.setFill(Color.GREEN);
					}
				}
			});

            //black pawn
			SubScene blackPawnScene = sceneMaker("src/chessPieces/blackPawn.png");
			board.add(blackPawnScene, i,6);
			Pawn blackPawn = new Pawn(board.getRowIndex(blackPawnScene), board.getColumnIndex(blackPawnScene), PieceType.PAWN, blackPawnScene);
			pieceList.add(blackPawn);
			blackPawnScene.setOnMouseReleased(event -> System.out.println(blackPawn.getPieceType() + " clicked!"));
        }
    }


	/**
	 * Setts 2 rooks
	 * @param board
	 */
    private static void rookMaker(GridPane board){
    	//white rooks
		for (int i = 0; i < 2; i++) {
			SubScene whiteRookScene = sceneMaker("src/chessPieces/whiteRook.png");
			if (i==0){
				board.add(whiteRookScene, 0, 0);
			}
			else {
				board.add(whiteRookScene, 7, 0);
			}
			Rook whiteRook = new Rook(board.getRowIndex(whiteRookScene), board.getColumnIndex(whiteRookScene), PieceType.ROOK, whiteRookScene);
			pieceList.add(whiteRook);
			whiteRookScene.setOnMouseReleased(event -> System.out.println(whiteRook.getPieceType() + " clicked!"));
		}

		//black rooks
		for (int i = 0; i < 2; i++) {
			SubScene blackRookScene = sceneMaker("src/chessPieces/blackRook.png");
			if (i==0){
				board.add(blackRookScene, 0, 7);
			}
			else {
				board.add(blackRookScene, 7, 7);
			}
			Rook blackRook = new Rook(board.getRowIndex(blackRookScene), board.getColumnIndex(blackRookScene), PieceType.ROOK, blackRookScene);
			pieceList.add(blackRook);
			blackRookScene.setOnMouseReleased(event -> System.out.println(blackRook.getPieceType() + " clicked!"));
		}
	}


	/**
	 * setts knights
	 * @param board
	 */
	private static void knightMaker(GridPane board){
		//white rooks
		for (int i = 0; i < 2; i++) {
			SubScene whiteKnightScene = sceneMaker("src/chessPieces/whiteKnight.png");
			if (i==0){
				board.add(whiteKnightScene, 1, 0);
			}
			else {
				board.add(whiteKnightScene, 6, 0);
			}
			Knight whiteKnight = new Knight(board.getColumnIndex(whiteKnightScene), board.getRowIndex(whiteKnightScene), PieceType.KNIGHT, whiteKnightScene);
			pieceList.add(whiteKnight);
			whiteKnightScene.setOnMouseReleased(event -> System.out.println(whiteKnight.getPieceType() + " clicked!"));
		}

		//black rooks
		for (int i = 0; i < 2; i++) {
			SubScene blackKnightScene = sceneMaker("src/chessPieces/blackKnight.png");
			if (i==0){
				board.add(blackKnightScene, 1, 7);
			}
			else {
				board.add(blackKnightScene, 6, 7);
			}
			Knight blackKnight = new Knight(board.getColumnIndex(blackKnightScene), board.getRowIndex(blackKnightScene), PieceType.KNIGHT, blackKnightScene);
			pieceList.add(blackKnight);
			blackKnightScene.setOnMouseReleased(event -> System.out.println(blackKnight.getPieceType() + " clicked!"));
		}
	}


	/**
	 * setts bishops
	 * @param board
	 */
	private static void bishopMaker(GridPane board){
		//white rooks
		for (int i = 0; i < 2; i++) {
			SubScene whiteBishopScene = sceneMaker("src/chessPieces/whiteBishop.png");
			if (i==0){
				board.add(whiteBishopScene, 2, 0);
			}
			else {
				board.add(whiteBishopScene, 5, 0);
			}
			Bishop whiteBishop = new Bishop(board.getColumnIndex(whiteBishopScene), board.getRowIndex(whiteBishopScene), PieceType.KNIGHT, whiteBishopScene);
			pieceList.add(whiteBishop);
			whiteBishopScene.setOnMouseReleased(event -> System.out.println(whiteBishop.getPieceType() + " clicked!"));
		}

		//black rooks
		for (int i = 0; i < 2; i++) {
			SubScene blackBishopScene = sceneMaker("src/chessPieces/blackBishop.png");
			if (i==0){
				board.add(blackBishopScene, 2, 7);
			}
			else {
				board.add(blackBishopScene, 5, 7);
			}
			Bishop blackBishop = new Bishop(board.getColumnIndex(blackBishopScene), board.getRowIndex(blackBishopScene),  PieceType.BISHOP, blackBishopScene);
			pieceList.add(blackBishop);
			blackBishopScene.setOnMouseReleased(event -> System.out.println(blackBishop.getPieceType() + " clicked!"));
		}
	}


	/**
	 * setts queens
	 * @param board
	 */
	private static void queenMaker(GridPane board){
		//white
		SubScene whiteQueenScene = sceneMaker("src/chessPieces/whiteQueen.png");
		board.add(whiteQueenScene, 3, 0);
		Queen whiteQueen = new Queen(board.getColumnIndex(whiteQueenScene), board.getRowIndex(whiteQueenScene), PieceType.QUEEN, whiteQueenScene);
		pieceList.add(whiteQueen);
		whiteQueenScene.setOnMouseReleased(event -> System.out.println(whiteQueen.getPieceType() + " clicked!"));

		//black
		SubScene blackQueenScene = sceneMaker("src/chessPieces/blackQueen.png");
		board.add(blackQueenScene, 3, 7);
		Queen blackQueen = new Queen(board.getColumnIndex(whiteQueenScene), board.getRowIndex(whiteQueenScene), PieceType.QUEEN, whiteQueenScene);
		pieceList.add(blackQueen);
		blackQueenScene.setOnMouseReleased(event -> System.out.println(blackQueen.getPieceType() + " clicked!"));
	}


	/**
	 * setts kings
	 * @param board
	 */
	private static void kingMaker(GridPane board){
		//white
		SubScene whiteKingScene = sceneMaker("src/chessPieces/whiteKing.png");
		board.add(whiteKingScene, 4, 0);
		King whiteKing = new King(board.getColumnIndex(whiteKingScene), board.getRowIndex(whiteKingScene), PieceType.KING, whiteKingScene);
		pieceList.add(whiteKing);
		whiteKingScene.setOnMouseReleased(event -> System.out.println(whiteKing.getPieceType() + " clicked!"));

		//black
		SubScene blackKingScene = sceneMaker("src/chessPieces/blackKing.png");
		board.add(blackKingScene, 4, 7);
		King blackKing = new King(board.getColumnIndex(whiteKingScene), board.getRowIndex(whiteKingScene), PieceType.KING, whiteKingScene);
		pieceList.add(blackKing);
		blackKingScene.setOnMouseReleased(event -> System.out.println(blackKing.getPieceType() + " clicked!"));
	}

}
