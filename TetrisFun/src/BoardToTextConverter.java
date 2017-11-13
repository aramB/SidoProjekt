public class BoardToTextConverter
{
	public static String convertToText(Board board){
		StringBuilder stringBuilder = new StringBuilder();
		String result = "";



		for (int row = 0; row < board.getHeight(); row++) {
			for (int col = 0; col < board.getWidth(); col++) {
				SquareType squareType = board.getSquareType(row, col);

				switch (squareType){
					case EMPTY:
						stringBuilder.append("+");
						break;
					case I:
						stringBuilder.append("%");
						break;
					case J:
						stringBuilder.append("&");
						break;
					case L:
						stringBuilder.append("#");
						break;
					case O:
						stringBuilder.append("=");
						break;
					case S:
						stringBuilder.append("?");
						break;
					case T:
						stringBuilder.append("/");
						break;
					case Z:
						stringBuilder.append("(");
						break;
					default:
						stringBuilder.append("fel");
						break;
				}
			}
			stringBuilder.append("\n");
			result = stringBuilder.toString();
		}
		return result;
	}
}
