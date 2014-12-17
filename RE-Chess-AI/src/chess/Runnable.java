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
			
		} else if (mode == "black") {
			
		}
		
		// Creates polling URL
		String link = "http://www.bencarle.com/chess/poll/" + gameID + "/204/1aca466d";
		URL pollingURL = new URL(link);
		URLConnection conn = pollingURL.openConnection();
		InputStream is = conn.getInputStream();
		
		// Create and initialize ChessBoard
		ChessBoard cb = new ChessBoard();
		
		// Polling variables taken from API.
		boolean ready = false;
		double secondsLeft = 900.0;
		String lastMove = "0";
		
		// Game loop
		boolean playing = true;
		while (playing == true) {
			// Polling API.
			String foo = new Scanner(is).useDelimiter("\\A").next();
			ready = false;
			
			// Checks if 
			if (ready == true) {
				// TODO: Update chess board.
				if (lastMove != "0") {
					
				}
				
				// TODO: Make move.
				
			} else {
				// TODO: Wait 5 seconds and poll again.
				
			}
		}
	}

}
