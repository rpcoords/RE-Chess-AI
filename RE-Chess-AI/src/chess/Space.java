/**
 * 
 */
package chess;

/**
 * Class to create a space on a chess board.
 * @author Robert Coords
 * TODO: Represent who controls this space (use enum type?).
 */
public class Space {
	
	Piece piece;
	int whiteDefenseValue, blackDefenseValue;
	
	/**
	 * Default Constructor to create an empty space on the chess board.
	 */
	public Space() {
		piece = Piece.EMPTY;
		whiteDefenseValue = 0;
		blackDefenseValue = 0;
	}
	
	/**
	 * Constructor to create a space with a piece on it.
	 * @param p the piece on the space.
	 * @param w how well white is defending the space.
	 * @param b how well black is defending the space.
	 */
	public Space(Piece p, int w, int b) {
		piece = p;
		whiteDefenseValue = w;
		blackDefenseValue = b;
	}
}
