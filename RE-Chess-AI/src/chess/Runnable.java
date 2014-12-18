/**
 * 
 */
package chess;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.lang.Object;

import org.json.JSONException;
import org.json.JSONString;
import org.json.JSONObject;
import java.net.*;

/**
 * @author Robert Coords
 *
 */
public class Runnable {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws JSONException 
	 */
	public static void main(String[] args) throws IOException, JSONException {
		String gameID = "0";
		String mode = "";
		// String player = "0";
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Game ID: ");
		gameID = scan.next();
		System.out.println("Specify AI white/ black mode: ");
		mode = scan.next();
		char col = '\0';
		if (mode == "white") {
		col = 'w';
		} else if (mode == "black") {
		col = 'b';
		}
		AlphaBetaTree abt = new AlphaBetaTree(col);
		// Creates polling URL
		String link = "http://www.bencarle.com/chess/poll/" + gameID + "/204/1aca466d";
		String moveLink = "http://www.bencarle.com/chess/move/" + gameID + "/204/1aca466d/";
		URL pollingURL = new URL(link);
		URLConnection conn = pollingURL.openConnection();
		InputStream is = conn.getInputStream();
		// Create and initialize ChessBoard
		ChessBoard cb = new ChessBoard();
		// Polling variables taken from API.
		boolean ready = false;
		double secondsLeft = 900.0;
		String lastMove = "0";
		int lastMoveNumber = 0;
		String foo = new Scanner(is).useDelimiter("\\A").next();
		JSONObject obj = new JSONObject(foo);
		// Game loop
		boolean playing = true;
		while (playing) {
			// Polling API.
			if(obj.getBoolean("ready") == true){
				ready = true;
			}
			else{
				ready = false;
			}
			// Checks if
			if (ready) {
				// TODO: Update chess board.
				if (lastMoveNumber != obj.getInt("lastmovenumber")) {
					System.out.println(obj.getString("lastmove"));
					cb.moveUpdate(obj.getString("lastmove"));
					lastMoveNumber = obj.getInt("lastmovenumber");
					System.out.println(foo);
				}
				// TODO: Make move.
				String ourMove = abt.alphaBetaSearch(cb);
//				System.out.println("our: " + ourMove);
//				if (lastMoveNumber == 0) {
//					ourMove = "Pe2e4";
//				}
				try{
					URL movingURL = new URL(moveLink+ourMove+"/");
					URLConnection conn2 = movingURL.openConnection();
					InputStream blah = conn2.getInputStream();
					System.out.println(movingURL);
					cb.moveUpdate(ourMove);
				}catch(java.io.FileNotFoundException e){}
			} else {
				// TODO: Wait 5 seconds and poll again.
				try {
					Thread.sleep(5000); //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
				is = conn.getInputStream();
				foo = new Scanner(is).useDelimiter("\\A").next();
				obj = new JSONObject(foo);
			}
		}
		}

}
