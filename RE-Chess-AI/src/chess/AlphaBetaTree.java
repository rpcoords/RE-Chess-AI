/**
 * 
 */
package chess;

/**
 * @author Robert Coords
 *
 */
public class AlphaBetaTree {
	
	
	public AlphaBetaTree() {
		
	}
	
	public void initTree() {
		
	}
	
	public String alphaBetaSearch(ChessBoard state) {
		String move = "";
		int posInf = 999999999;
		int negInf = -999999999;
		
		int util = maxVal(state, negInf, posInf);
//		move = ACTION(state);
		return move;
	}
	
	public int maxVal(ChessBoard state, int alpha, int beta) {
		if (terminalTest(state) == true) {
			return utility(state);
		}
		int v = -999999999;
		String a = "";
		int num = 0; // TODO: change to total number of moves from given state.
		
		for (int i = 0; i < num; i++) {
			v = max(v, minVal(result(state, a), alpha, beta));
			if (v >= beta) {
				return v;
			}
			alpha = max(alpha, v);
		}
		
		return v;
	}
	
	public int minVal(ChessBoard state, int alpha, int beta) {
		
		int v = 999999999;
		String a = "";
		int num = 0; // TODO: change to total number of moves from given state.
		
		for (int i = 0; i < num; i++) {
			v = min(v, utility(result(state, a)));
//			v = min(v, maxVal(result(state, a), alpha, beta));
			if (v <= alpha) {
				return v;
			}
			beta = min(beta, v);
		}
		
		return v;
	}
	
	public int max(int a, int b) {
		if (a > b) {
			return a;
		} else if (b > a) {
			return b;
		} else {
			return a;
		}
	}
	
	public int min(int a, int b) {
		if (a < b) {
			return a;
		} else if (b < a) {
			return b;
		} else {
			return a;
		}
	}
	
	/**
	 * Checks for checkmate.
	 * @param state
	 * @return
	 */
	public boolean terminalTest(ChessBoard state) {
		
		
		return false;
	}
	
	/**
	 * Gives resulting board state after move.
	 * @param state
	 * @param move
	 * @return
	 */
	public ChessBoard result(ChessBoard state, String move) {
		state.moveUpdate(move);
		return state;
	}
	
	/**
	 * Gives eval value for state.
	 * @param state
	 * @return
	 */
	public int utility(ChessBoard state) {
		
		return 0;
	}
}
