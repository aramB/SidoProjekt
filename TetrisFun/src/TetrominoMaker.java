
public class TetrominoMaker
{

	public int getNumberOfTypes(){
		SquareType[] squareTypes = SquareType.values();
		return squareTypes.length;
	}


	public Poly getPoly(int n){
		SquareType squareType = SquareType.values()[n];

		switch (squareType) {
			case Z:
				return new Poly(zMaker());
			case T:
				return new Poly(tMaker());
			case S:
				return new Poly(sMaker());
			case O:
				return new Poly(oMaker());
			case L:
				return new Poly(lMaker());
			case J:
				return new Poly(jMaker());
			case I:
				return new Poly(iMaker());
			/*case EMPTY:
				return new Poly(emptyMaker());*/
			default:
				throw new IllegalArgumentException("Invalid index: " + n);
		}
	}

	private SquareType[][] iMaker() {
		SquareType[][] squareTypes = new SquareType[4][4];
		for (int row = 0; row < squareTypes.length; row++) {
			for (int col = 0; col < squareTypes[row].length; col++) {
				if (row==1){
					squareTypes[row][col] = SquareType.I;
				}
				else {
					squareTypes[row][col] = SquareType.EMPTY;
				}
			}
		}
		return squareTypes;
	}

	private SquareType[][] jMaker() {
		SquareType[][] squareTypes = {
				{SquareType.EMPTY, SquareType.J, SquareType.EMPTY},
				{SquareType.EMPTY, SquareType.J, SquareType.EMPTY},
				{SquareType.J, SquareType.J, SquareType.EMPTY}
		};
		return squareTypes;
	}

	private SquareType[][] lMaker() {
		SquareType[][] squareTypes = {
				{SquareType.EMPTY, SquareType.L, SquareType.EMPTY},
				{SquareType.EMPTY, SquareType.L, SquareType.EMPTY},
				{SquareType.EMPTY, SquareType.L, SquareType.L}
		};

		return squareTypes;
	}

	private SquareType[][] oMaker() {
		SquareType[][] squareTypes = new SquareType[2][2];
		for (int row = 0; row < squareTypes.length; row++) {
			for (int col = 0; col < squareTypes[row].length; col++) {
				squareTypes[row][col] = SquareType.O;
			}
		}
		return squareTypes;
	}

	private SquareType[][] sMaker() {
		SquareType[][] squareTypes = {
				{SquareType.EMPTY, SquareType.S, SquareType.S},
				{SquareType.S, SquareType.S, SquareType.EMPTY},
				{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}
		};
		return squareTypes;
	}

	private SquareType[][] tMaker() {
		SquareType[][] squareTypes = {
				{SquareType.EMPTY, SquareType.T, SquareType.EMPTY},
				{SquareType.T, SquareType.T, SquareType.T},
				{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY},
		};
		return squareTypes;
	}

	private SquareType[][] zMaker() {
		SquareType[][] squareTypes = {
				{SquareType.Z, SquareType.Z, SquareType.EMPTY},
				{SquareType.EMPTY, SquareType.Z, SquareType.Z},
				{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}
		};
		return squareTypes;
	}

	private SquareType[][] emptyMaker() {
		SquareType[][] squareTypes = {
				{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY},
				{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY},
				{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}
		};
		return squareTypes;
	}
}
