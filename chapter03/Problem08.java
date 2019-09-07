package chapter03;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *  @author KRUTIK AMIN
 *	This program draws 8 * 8 square of 50px squares with alternation
 *	black & red colour.
 */
public class Problem08 extends Application {
	private final int	NUM_ROWS = 8;
	private	final int 	NUM_COLUMNS = 8;
    /**
     * Draws a picture.  The parameters width and height give the size 
     * of the drawing area, in pixels.  
     */
    public void drawPicture(GraphicsContext g, int width, int height) {

        g.setFill(Color.WHITE);
        g.fillRect(0, 0, width, height); // First, fill the entire image with a background color.

        for(int x = 0, column = 0; x <= width; x += (width/NUM_COLUMNS), column++) {
        	for(int y = 0, row = 0; y <= height; y += (height/NUM_ROWS), row++) {	
        		if(((column % 2 == 0) && (row % 2 == 0)) || ((column % 2 != 0) && (row % 2 != 0))) {
        			g.setFill(Color.RED);
        		} else {
        			g.setFill(Color.BLACK);
        		}
        		g.fillRect(x, y, x+50, y+50);
        	}
        }
    } // end drawPicture()

    public void start(Stage stage) {
        int width = 400;   // The width of the image.
        int height = 400;  // The height of the image.
        Canvas canvas = new Canvas(width,height);
        drawPicture(canvas.getGraphicsContext2D(), width, height);
        BorderPane root = new BorderPane(canvas);
        root.setStyle("-fx-border-width: 4px; -fx-border-color: #444");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Problem08"); // STRING APPEARS IN WINDOW TITLEBAR!
        stage.show();
        stage.setResizable(false);
    } 

    public static void main(String[] args) {
        launch();
    }

}
