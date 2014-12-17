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

/**
 * @author Robert Coords
 *
 */
public class Runnable {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String gameID = "0";
		String mode = "";
//		String player = "0";
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Game ID: ");
		gameID = scan.next();
		System.out.println("Specify AI white/ black mode: ");
		mode = scan.next();
		
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
		URLConnection conn2 = pollingURL.openConnection();
		InputStream is = conn.getInputStream();
		
		// Create and initialize ChessBoard
		ChessBoard cb = new ChessBoard();
		
		// Polling variables taken from API.
		boolean ready = false;
		double secondsLeft = 900.0;
		String lastMove = "0";
		int lastMoveNumber = 0;
		JsonReader rdr;
		rdr.createReader(is);
		JsonObject obj = rdr.readObject();
		
		// Game loop
		boolean playing = true;
		while (playing) {
			// Polling API.			
			if(obj.getJsonString("ready") == "true"){
				ready = true;
			}
			else{
				ready = false;
			}
			// Checks if 
			if (ready) {
				// TODO: Update chess board.
				if (lastMoveNumber != obj.getJsonNumber("lastmovenumber")) {
					cb.moveUpdate(obj.getJsonString("lastmove"));
					lastMoveNumber = obj.getJsonNumber("lastmovenumber");
				}
				// TODO: Make move.
				
				String ourMove = apt.alphaBetaSearch();
				URL movingURL = new URL(moveLink+ourMove+"/");
				conn2 = pollingURL.openConnection();
				
			} else {
				// TODO: Wait 5 seconds and poll again.
				try {
					Thread.sleep(5000);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
				is = conn.getInputStream();
				rdr.createReader(is);
				obj = rdr.readObject();
			}
			
		}
	}

}
