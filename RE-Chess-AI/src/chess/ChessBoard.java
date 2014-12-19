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
	 */
	public ChessBoard moveUpdate(String move) {
		move = move.toLowerCase();
//		System.out.println("move: " + move);
		String currY = move.substring(1, 2);
		String currX = move.substring(2, 3);
		String newY = move.substring(3, 4);
		String newX = move.substring(4, 5);
		ChessBoard newBoard = new ChessBoard();
//		System.out.println((Integer.valueOf(currX).intValue() - 1) + "" + rankerz(currY) + "-" + (Integer.valueOf(newX).intValue() - 1) + "" + rankerz(newY));
		
		newBoard = this.clone();
		
		newBoard.board[Integer.valueOf(newX).intValue() - 1][rankerz(newY)].color = this.board[Integer.valueOf(currX).intValue() - 1][rankerz(currY)].color;
		newBoard.board[Integer.valueOf(newX).intValue() - 1][rankerz(newY)].piece = this.board[Integer.valueOf(currX).intValue() - 1][rankerz(currY)].piece;
		
		newBoard.board[Integer.valueOf(currX).intValue() - 1][rankerz(currY)].color = 'e';
		newBoard.board[Integer.valueOf(currX).intValue() - 1][rankerz(currY)].piece = Piece.e;
		
//		System.out.println(board[Integer.valueOf(newX).intValue() - 1][rankerz(newY)].piece + " " + board[Integer.valueOf(currX).intValue() - 1][rankerz(currY)].piece);
		
		return newBoard;
	}
	
	public int rankerz(String y) {
		if (y.equals("a")) {
			return 0;
		} else if (y.equals("b")) {
			return 1;
		} else if (y.equals("c")) {
			return 2;
		} else if (y.equals("d")) {
			return 3;
		} else if (y.equals("e")) {
			return 4;
		} else if (y.equals("f")) {
			return 5;
		} else if (y.equals("g")) {
			return 6;
		} else {
			return 7;
		}
	}
	
	/**
	 * Returns an Array List of all possible move coordinates
	 * @param file x value (even though it is a column...)
	 * @param rank y value (even though it is a row...)
	 * 
	 */
	public ArrayList<int[]> moveLocations(int file, int rank) {
		ArrayList<int[]> answer = new ArrayList<int[]>();
		Space s = board[file][rank];
		Piece moving = s.piece;
		char pcolor = s.color;
		int[] input = new int[2];
		switch(moving){
			case e: break;
			case p: try {
				if(pcolor == 'w' && board[file][rank+1].piece == Piece.e){
					answer.add(new int[]{file,rank+1});
				}
				} catch (ArrayIndexOutOfBoundsException e) { }
				try {
				if(pcolor == 'w' && board[file+1][rank+1].color == 'b'){
					answer.add(new int[]{file+1,rank+1});
				}
				} catch (ArrayIndexOutOfBoundsException e) { }
				try {
				if(pcolor == 'w' && board[file-1][rank+1].color == 'b'){
					answer.add(new int[]{file-1,rank+1});
				}
				} catch (ArrayIndexOutOfBoundsException e) { }
				try {
				if(pcolor == 'b' && board[file][rank-1].piece == Piece.e){
					answer.add(new int[]{file,rank-1});
				}
				} catch (ArrayIndexOutOfBoundsException e) { }
				try {
				if(pcolor == 'b' && board[file+1][rank+1].color == 'w'){
					answer.add(new int[]{file+1,rank+1});
				}
				} catch (ArrayIndexOutOfBoundsException e) { }
				try {
				if(pcolor == 'b' && board[file-1][rank+1].color == 'w'){
					answer.add(new int[]{file-1,rank+1});
				}
				} catch (ArrayIndexOutOfBoundsException e) { }
			case b: int i = 1;
				try {
				while(true){
					if ((file+i < 7) && (rank+i < 7) && (board[file+i][rank+i].color != pcolor)) {
						answer.add(new int[]{file+i, rank+i});
					}
					else if((file+i < 6) && (rank+i < 6) && (board[file+i][rank+i].color != 'e')){
						answer.add(new int[]{file+i+1, rank+i+1});
						break;
					}else{
						break;
					}
					i++;
				} //check one space further for piece of same color to stop it here, to be implimented
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				i = 1;
				try {
				while(true){
					if ((file+i < 7) && (rank-i > 0) && (board[file+i][rank-i].color != pcolor)) {
						answer.add(new int[]{file+i, rank-i});
					}
					else if((file+i < 6) && (rank-i > 1) && (board[file+i][rank-i].color != 'e')){
						answer.add(new int[]{file+i+1, rank-i-1});
						break;
					}else{
						break;
					}
					i++;
				}
				} catch (ArrayIndexOutOfBoundsException e) { }
				i = 1;
				try {
				while(true){
					if ((file-i > 0) && (rank+i < 7)) {
						answer.add(new int[]{file-i, rank+i});
					}
					else if((file-i > 1) && (rank+i < 6) && (board[file-i][rank+i].color != 'e')){
						answer.add(new int[]{file-i-1, rank+i+1});
						break;
					}
					else{
						break;
					}
					i++;
				}
				} catch (ArrayIndexOutOfBoundsException e) { }
				i = 1;
				try {
				while(true){
					if ((file-i > 0) && (rank-i > 0)) {
						answer.add(new int[]{file-i, rank-i});
					}
					else if((file-i > 1) && (rank-i > 1) && (board[file-i][rank-i].color != 'e')){
						answer.add(new int[]{file-i-1, rank-i-1});
						break;
					}
					else{
						break;
					}
					i++;
				}
				} catch (ArrayIndexOutOfBoundsException e) { }
				break;
			case n:
				if(file >0){
					if(rank > 1){
						answer.add(new int[]{file-1, rank-2});
					}
					if(rank < 6){
						answer.add(new int[]{file-1, rank+2});
					}
				}
				if(file > 1){
					if(rank>0){
						answer.add(new int[]{file-2, rank-1});
					}
					if(rank<7){
						answer.add(new int[]{file-2, rank+1});
					}
				}
				if(file < 6){
					if(rank>0){
						answer.add(new int[]{file+2, rank-1});
					}
					if(rank<7){
						answer.add(new int[]{file+2, rank+1});
					}
				}
				if(file <7){
					if(rank > 1){
						answer.add(new int[]{file+1, rank-2});
					}
					if(rank < 6){
						answer.add(new int[]{file+1, rank+2});
					}
				}
				break;
			case r: i = 1;
				try {
				while(true){
					if (file+i < 7 && board[file+i][rank].color != pcolor) {
						answer.add(new int[]{file+i, rank});
					}
					else if((file+i < 1) && (board[file+i][rank].color != 'e')){
						answer.add(new int[]{file+i+1, rank});
						break;
					}
					else{
						break;
					}
					i++;
				} //check one space further for piece of same color to stop it here, to be implimented
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				i = 1;
				try {
				while(true){
					if (rank > 0 && board[file][rank-i].color != board[file][rank].color) {
						answer.add(new int[]{file, rank-i});
					}
					else if((rank-i > 1) && (board[file][rank-i].color != 'e')){
						answer.add(new int[]{file, rank-i-1});
						break;
					}
					else{
						break;
					}
					i++;
				}
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				i = 1;
				try {
				while(true){
					if (rank < 7 && board[file][rank+i].color != board[file][rank].color) {
						answer.add(new int[]{file, rank+i});
					}
					else if((rank+i < 6) && (board[file][rank+i].color != 'e')){
						answer.add(new int[]{file, rank+i+1});
						break;
					}
					else{
						break;
					}
					i++;
				}
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				i = 1;
				try {
				while(true){
					if (file > 0 && board[file-i][rank].color != board[file][rank].color) {
						answer.add(new int[]{file-i, rank});
					}
					else if((file+i < 1) && (board[file+i][rank].color != 'e')){
						answer.add(new int[]{file+i+1, rank});
						break;
					}
					else{
						break;
					}
					i++;
				}
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				break;
			case q: i = 1;
				try {
				while(true){
					if ((file+i < 7) && (rank+i < 7) && (board[file+i][rank+i].color != pcolor)) {
						answer.add(new int[]{file+i, rank+i});
					}
					else if((file+i < 6) && (rank+i < 6) && (board[file+i][rank+i].color != 'e')){
						answer.add(new int[]{file+i+1, rank+i+1});
						break;
					}
					else{
						break;
					}
					i++;
				} //check one space further for piece of same color to stop it here, to be implimented
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				i = 1;
				try {
				while(true){
					if ((file+i < 7) && (rank-i > 0) && (board[file+i][rank-i].color != pcolor)) {
						answer.add(new int[]{file+i, rank-i});
					}
					else if((file+i < 6) && (rank-i > 1) && (board[file+i][rank-i].color != 'e')){
						answer.add(new int[]{file+i+1, rank-i-1});
						break;
					}
					else{
						break;
					}
					i++;
				}
				} catch (ArrayIndexOutOfBoundsException e) { }
				i = 1;
				try {
				while(true){
					if ((file-i > 0) && (rank+i < 7)) {
						answer.add(new int[]{file-i, rank+i});
					}
					else if((file-i > 1) && (rank+i < 6) && (board[file-i][rank+i].color != 'e')){
						answer.add(new int[]{file-i-1, rank+i+1});
						break;
					}
					else{
						break;
					}
					i++;
				}
				} catch (ArrayIndexOutOfBoundsException e) { }
				i = 1;
				try {
				while(true){
					if ((file-i > 0) && (rank-i > 0)) {
						answer.add(new int[]{file-i, rank-i});
					}
					else if((file-i > 1) && (rank-i > 1) && (board[file-i][rank-i].color != 'e')){
						answer.add(new int[]{file-i-1, rank-i-1});
						break;
					}
					else{
						break;
					}
					i++;
				}
				} catch (ArrayIndexOutOfBoundsException e) { }
				try {
				while(true){
					if (file+i < 7 && board[file+i][rank].color != pcolor) {
						answer.add(new int[]{file+i, rank});
					}
					else if((file+i < 1) && (board[file+i][rank].color != 'e')){
						answer.add(new int[]{file+i+1, rank});
						break;
					}
					else{
						break;
					}
					i++;
				} //check one space further for piece of same color to stop it here, to be implimented
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				i = 1;
				try {
				while(true){
					if (rank > 0 && board[file][rank-i].color != board[file][rank].color) {
						answer.add(new int[]{file, rank-i});
					}
					else if((rank-i > 1) && (board[file][rank-i].color != 'e')){
						answer.add(new int[]{file, rank-i-1});
						break;
					}
					else{
						break;
					}
					i++;
				}
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				i = 1;
				try {
				while(true){
					if (rank < 7 && board[file][rank+i].color != board[file][rank].color) {
						answer.add(new int[]{file, rank+i});
					}
					else if((rank+i < 6) && (board[file][rank+i].color != 'e')){
						answer.add(new int[]{file, rank+i+1});
						break;
					}
					else{
						break;
					}
					i++;
				}
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				i = 1;
				try {
				while(true){
					if (file > 0 && board[file-i][rank].color != board[file][rank].color) {
						answer.add(new int[]{file-i, rank});
					}
					else if((file+i < 1) && (board[file+i][rank].color != 'e')){
						answer.add(new int[]{file+i+1, rank});
						break;
					}
					else{
						break;
					}
					i++;
				}
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				break;
			case k:
				try {
				if(board[file+1][rank+1].color != s.color){
					answer.add(new int[]{file+1, rank+1});
				}
				} catch (ArrayIndexOutOfBoundsException e) { }
				try {
				if(board[file+1][rank-1].color != s.color){
					answer.add(new int[]{file+1, rank-1});
				}
				} catch (ArrayIndexOutOfBoundsException e) { }
				try {
				if(board[file-1][rank+1].color != s.color){
					answer.add(new int[]{file-1, rank+1});
				}
				} catch (ArrayIndexOutOfBoundsException e) { }
				try {
				if(board[file-1][rank-1].color != s.color){
					answer.add(new int[]{file-1, rank-1});
				}
				} catch (ArrayIndexOutOfBoundsException e) { }
				try {
				if(board[file+1][rank].color != s.color){
					answer.add(new int[]{file+1, rank+1});
				}
				} catch (ArrayIndexOutOfBoundsException e) { }
				try {
				if(board[file][rank-1].color != s.color){
					answer.add(new int[]{file+1, rank-1});
				}
				} catch (ArrayIndexOutOfBoundsException e) { }
				try {
				if(board[file][rank+1].color != s.color){
					answer.add(new int[]{file-1, rank+1});
				}
				} catch (ArrayIndexOutOfBoundsException e) { }
				try {
				if(board[file-1][rank].color != s.color){
					answer.add(new int[]{file-1, rank-1});
				}
				} catch (ArrayIndexOutOfBoundsException e) { }
				break;
		}
	return answer;
	}
	
	public int eval(char col){
		int answer = 0;
		for(Space[] u: board){
				int i = 0;
				for(Space sp: u){
					int j = 0;
					if(sp.color == col){
						if(sp.piece == Piece.p){
							answer += PAWN_VAL;
						}
						if(sp.piece == Piece.b){
							answer += BISHOP_VAL;
						}
						if(sp.piece == Piece.n){
							answer += KNIGHT_VAL;
							if((i>=3 && i <= 6) && (j>=3 && j<=6)){
								answer +=1;
							}
						}
						if(sp.piece == Piece.r){
							answer += ROOK_VAL;
						}
						if(sp.piece == Piece.q){
							answer += QUEEN_VAL;
						}
						if(sp.piece == Piece.k){
							answer += KING_VAL*2;
						}
					}
					else if(sp.color != col && sp.color != 'e'){
						if(sp.piece == Piece.p){
							answer -= PAWN_VAL;
						}
						if(sp.piece == Piece.b){
							answer -= BISHOP_VAL;
						}
						if(sp.piece == Piece.n){
							answer -= KNIGHT_VAL;
						}
						if(sp.piece == Piece.r){
							answer -= ROOK_VAL;
						}
						if(sp.piece == Piece.q){
							answer -= QUEEN_VAL;
						}
						if(sp.piece == Piece.k){
							answer -= KING_VAL*3;
						}
				}
				j++;
			}
			i++;
		}
		return answer;
	}
	
	public ChessBoard clone() {
		ChessBoard cb = new ChessBoard();
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cb.board[x][y] = this.board[x][y].clone();
			}
		}
		
		return cb;
	}
}
