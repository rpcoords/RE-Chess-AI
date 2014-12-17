/**
 * 
 */
package chess;

import java.util.ArrayList;

/**
 * @author Robert Coords
 *
 */
public class AlphaBetaTree {
	
	char color;
	String best;
	
	public AlphaBetaTree() {
		color = '\0';
		best = "";
	}
	
	public AlphaBetaTree(char c) {
		color = c;
		best = "";
	}
	
	public void initTree() {
		
	}
	
	public String alphaBetaSearch(ChessBoard state) {
		String move = "";
		int posInf = 999999999;
		int negInf = -999999999;
		
		return maxVal(state, negInf, posInf);
//		move = action(state);
//		return move;
	}
	
	public String maxVal(ChessBoard state, int alpha, int beta) {
//		if (terminalTest(state) == true) {
//			return utility(state);
//		}
		int v = -999999999;
		String a = "";
		ArrayList<String> actions = action(state);
		int num = actions.size();
		
		for (int i = 0; i < num; i++) {
			a = actions.get(i);
			v = max(v, minVal(result(state, a), alpha, beta));
			if (v >= beta) {
				return a;
			}
			alpha = max(alpha, v);
			if (v == alpha) {
				best = a;
			}
		}
		
		return best;
	}
	
	public int minVal(ChessBoard state, int alpha, int beta) {
		
		int v = 999999999;
		String a = "";
		ArrayList<String> actions = action(state);
		int num = actions.size();
		
		
		for (int i = 0; i < num; i++) {
			a = actions.get(i);
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
		return state.eval(color);
	}
	
	public ArrayList<String> action(ChessBoard state) {
		ArrayList<String> actions = new ArrayList<String>();
		ArrayList<int[]> acts = new ArrayList<int[]>();
		int [] locs = new int[2];
		String temp =  "";
		
		// Checks every square
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				if ((state.board[x][y].color == 'w') || (state.board[x][y].color == 'b')) {
					acts = state.moveLocations(x, y);
					for (int a = 0; a < acts.size(); a++) {
						locs = acts.get(a);
						temp = state.board[x][y].piece.toString().toUpperCase() + intToString(y) + (x + 1) + intToString(locs[1]) + (locs[0] + 1);
						actions.add(temp);
					}
				}
			}
		}
		
		return actions;
	}
	
	public String intToString(int i) {
		if (i == 0) {
			return "a";
		} else if (i == 1) {
			return "b";
		} else if (i == 2) {
			return "c";
		} else if (i == 3) {
			return "d";
		} else if (i == 4) {
			return "e";
		} else if (i == 5) {
			return "f";
		} else if (i == 6) {
			return "g";
		} else {
			return "h";
		}
	} 
}
