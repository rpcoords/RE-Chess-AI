/**
 * 
 */
package chess;
import java.util.List;
import java.util.ArrayList;

/**
 * Class to create a chess board object composed of spaces.
 * @author Robert Coords
 */
public class ChessBoard {
	
	// Final defensive values for each piece.
	// Determine defensive values for each piece.
	final int KING_VAL = 100;
	final int QUEEN_VAL = 10;
	final int ROOK_VAL = 5;
	final int BISHOP_VAL = 3;
	final int KNIGHT_VAL = 3;
	final int PAWN_VAL = 1;
	
	Space [][] board;
	
	/**
	 * Constructor to create a chess board object.
	 */
	public ChessBoard() {
		board = new Space[8][8];
		
		/** BOARD LAYOUT (for reference only)
		 *    A		B	  C		D	  E		F	  G		H
		 *   _______________________________________________
		 * 8|(7,0),(7,1),(7,2),(7,3),(7,4),(7,5),(7,6),(7,7) // BLACK START SIDE
		 * 7|(6,0),(6,1),(6,2),(6,3),(6,4),(6,5),(6,6),(6,7)
		 * 6|(5,0),(5,1),(5,2),(5,3),(5,4),(5,5),(5,6),(5,7)
		 * 5|(4,0),(4,1),(4,2),(4,3),(4,4),(4,5),(4,6),(4,7)
		 * 4|(3,0),(3,1),(3,2),(3,3),(3,4),(3,5),(3,6),(3,7)
		 * 3|(2,0),(2,1),(2,2),(2,3),(2,4),(2,5),(2,6),(2,7)
		 * 2|(1,0),(1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7)
		 * 1|(0,0),(0,1),(0,2),(0,3),(0,4),(0,5),(0,6),(0,7) // WHITE START SIDE
		 */
		
		init(); // Initializes chess board.
	}
	
	/**
	 * Function to initialize the chess board at the game's start.
	 */
	public void init() {
		// Initialize Chess Board.
		board[0][0] = new Space(Piece.r, 'w');
		board[0][1] = new Space(Piece.n, 'w');
		board[0][2] = new Space(Piece.b, 'w');
		board[0][3] = new Space(Piece.q, 'w');
		board[0][4] = new Space(Piece.k, 'w');
		board[0][5] = new Space(Piece.b, 'w');
		board[0][6] = new Space(Piece.n, 'w');
		board[0][7] = new Space(Piece.r, 'w');
		
		board[1][0] = new Space(Piece.p, 'w');
		board[1][1] = new Space(Piece.p, 'w');
		board[1][2] = new Space(Piece.p, 'w');
		board[1][3] = new Space(Piece.p, 'w');
		board[1][4] = new Space(Piece.p, 'w');
		board[1][5] = new Space(Piece.p, 'w');
		board[1][6] = new Space(Piece.p, 'w');
		board[1][7] = new Space(Piece.p, 'w');
		
		board[2][0] = new Space();
		board[2][1] = new Space();
		board[2][2] = new Space();
		board[2][3] = new Space();
		board[2][4] = new Space();
		board[2][5] = new Space();
		board[2][6] = new Space();
		board[2][7] = new Space();
		
		board[3][0] = new Space();
		board[3][1] = new Space();
		board[3][2] = new Space();
		board[3][3] = new Space();
		board[3][4] = new Space();
		board[3][5] = new Space();
		board[3][6] = new Space();
		board[3][7] = new Space();
		
		board[4][0] = new Space();
		board[4][1] = new Space();
		board[4][2] = new Space();
		board[4][3] = new Space();
		board[4][4] = new Space();
		board[4][5] = new Space();
		board[4][6] = new Space();
		board[4][7] = new Space();
		
		board[5][0] = new Space();
		board[5][1] = new Space();
		board[5][2] = new Space();
		board[5][3] = new Space();
		board[5][4] = new Space();
		board[5][5] = new Space();
		board[5][6] = new Space();
		board[5][7] = new Space();
		
		board[6][0] = new Space(Piece.p, 'b');
		board[6][1] = new Space(Piece.p, 'b');
		board[6][2] = new Space(Piece.p, 'b');
		board[6][3] = new Space(Piece.p, 'b');
		board[6][4] = new Space(Piece.p, 'b');
		board[6][5] = new Space(Piece.p, 'b');
		board[6][6] = new Space(Piece.p, 'b');
		board[6][7] = new Space(Piece.p, 'b');
		
		board[7][0] = new Space(Piece.r, 'b');
		board[7][1] = new Space(Piece.n, 'b');
		board[7][2] = new Space(Piece.b, 'b');
		board[7][3] = new Space(Piece.q, 'b');
		board[7][4] = new Space(Piece.k, 'b');
		board[7][5] = new Space(Piece.b, 'b');
		board[7][6] = new Space(Piece.n, 'b');
		board[7][7] = new Space(Piece.r, 'b');
	}
	
	/**
	 * Updates chess board after a move is made.
	 * @param move the most recent move made.
	 * TODO: Create moveUpdate
	 */
	public void moveUpdate(String move) {
		// TODO: Remove selected piece from current position.
		
		
		// TODO: Adjust defensive values by removing values for selected piece.
		
		
		// TODO: Add selected piece to new position.
		
		
		// TODO: Adjust defensive values by adding values for selected piece.
		
	}
	
	public ArrayList<int[]> moveLocations(int file, int rank){
		List answer = new ArrayList<int[2]>;
		Space s = board[file][rank];
		Piece moving = s.piece;
		switch(moving){
			case Piece.n: break;
			case Piece.p: answer.add({file,rank+1});
				if(file < 7 && board[file+1][rank+1].piece != Piece.e){
					answer.add({file+1, rank+1});
				}
				if(file > 0 && board[file-1][rank+1].piece != Piece.e){
					answer.add({file-1, rank+1});
				}
			case Piece.b: 
		}
		
	}
}
