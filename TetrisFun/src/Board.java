import java.util.Random;

public class Board
{
	Random random = new Random();
	private SquareType[][] squares;
	private int width, height;
	private Poly fallingPoly = null;
	private int xFalling, yFalling;

	public static void main(String[] args) {
		Board board = new Board(20,10);
		System.out.println(BoardToTextConverter.convertToText(board));
	}

	public Board(final int width, final int height) {
		this.width = width;
		this.height = height;
		squares = new SquareType[height][width];
		for (int row = 0; row < squares.length; row++) {
			for (int col = 0; col < squares[row].length; col++) {
				squares[row][col] = randomGen();
			}
		}
	}

	public SquareType randomGen(){
		SquareType[] squareTypes = SquareType.values();
		int rand = random.nextInt(squareTypes.length);
 		return squareTypes[rand];
	}

	public Poly getFallingPoly() {
		return fallingPoly;
	}

	public int getxFalling() {
		return xFalling;
	}

	public int getyFalling() {
		return yFalling;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public SquareType getSquareType(int y, int x){
		return squares[y][x];
	}
}
