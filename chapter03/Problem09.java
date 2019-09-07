package chapter03;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *  This file can be used to create very simple animations.  Just fill in
 *  the definition of drawFrame with the code to draw one frame of the 
 *  animation, and possibly change a few of the values in the rest of
 *  the program as noted below.
 */
public class Problem09 extends Application {

    /**
     * Draws one frame of an animation. This subroutine should be called
     * about 60 times per second.  It is responsible for redrawing the
     * entire drawing area. The parameter g is used for drawing. The frameNumber 
     * starts at zero and increases by 1 each time this subroutine is called.  
     * The parameter elapsedSeconds gives the number of seconds since the animation
     * was started.  By using frameNumber and/or elapsedSeconds in the drawing
     * code, you can make a picture that changes over time.  That's an animation.
     * The parameters width and height give the size of the drawing area, in pixels.  
     */
    public void drawFrame(GraphicsContext g, int frameNumber, double elapsedSeconds, int width, int height) {

        /* NOTE:  To get a different animation, just erase the contents of this 
         * subroutine and substitute your own. 
         */
    	final int NUM_SQUARES = 6;
    	final int SQUARE_SIZE = height/NUM_SQUARES;
    	int       square1cyclicFrameNumber = frameNumber % 1;
    	int       square2cyclicFrameNumber = frameNumber % 2;
    	int       square3cyclicFrameNumber = frameNumber % 3;
    	int       square4oscillationFrameNumber = frameNumber % (2 * 1);
    	int       square5oscillationFrameNumber = frameNumber % (2 * 2);
    	int       square6oscillationFrameNumber = frameNumber % (2 * 3);
    	
    	if(square4oscillationFrameNumber > 1)
    		square4oscillationFrameNumber = (2 * 1) - square4oscillationFrameNumber; 

    	if(square5oscillationFrameNumber > 2)
    		square5oscillationFrameNumber = (2 * 2) - square5oscillationFrameNumber;
    	
    	if(square6oscillationFrameNumber > 3)
    		square6oscillationFrameNumber = (2 * 3) - square6oscillationFrameNumber;
    	
        g.setFill(Color.WHITE);
        g.fillRect(0, 0, width, height); // First, fill the entire image with a background color!

        g.setFill(Color.BLACK);
        g.setLineWidth(2);
        g.strokeRect(0, 0, width, height);
        
        for(int i = 0, x1 = 0, x2 = width, y1 = (height/NUM_SQUARES), y2 = y1; i < NUM_SQUARES; 
        		i++, y1 += (height/NUM_SQUARES), y2 = y1) {
        	g.strokeLine(x1, y1, x2, y2);
        }
        
        if(square1cyclicFrameNumber == 0) {
        	g.setFill(Color.RED);
            g.fillRect((frameNumber % width) + 1 , 1, SQUARE_SIZE, SQUARE_SIZE-2);	
        }
        if(square2cyclicFrameNumber == 0) {
        	g.setFill(Color.GREEN);
            g.fillRect(((2 * frameNumber) % (width)), SQUARE_SIZE + 1, SQUARE_SIZE, SQUARE_SIZE-2);	
        }
        if(square3cyclicFrameNumber == 0) {
        	g.setFill(Color.BLUE);
            g.fillRect(((3 * frameNumber) % (width)), (SQUARE_SIZE * 2) + 1, SQUARE_SIZE, SQUARE_SIZE-2);	
        }
        
        if(square4oscillationFrameNumber == 0) {
        	g.setFill(Color.CYAN);
            g.fillRect((frameNumber) % (width), (SQUARE_SIZE * 3) + 1, SQUARE_SIZE, SQUARE_SIZE-2);	
        }
        if(square5oscillationFrameNumber == 0) {
        	g.setFill(Color.PINK);
            g.fillRect(((2 * frameNumber) % (width)), (SQUARE_SIZE * 4) + 1, SQUARE_SIZE, SQUARE_SIZE-2);	
        }
        if(square6oscillationFrameNumber == 0) {
        	g.setFill(Color.YELLOW);
            g.fillRect(((3 * frameNumber) % (width)), (SQUARE_SIZE * 5) + 1, SQUARE_SIZE, SQUARE_SIZE-2);	
        }
        
        g.fillText( "Frame number " + frameNumber, 40, 50 );
        g.fillText( String.format("Elapsed Time: %1.1f seconds", elapsedSeconds), 40, 80);

    }

    //------ Implementation details: DO NOT EXPECT TO UNDERSTAND THIS ------

	public void start(Stage stage) {
        int width = 800;   // The width of the image.  You can modify this value!
        int height = 600;  // The height of the image. You can modify this value!
        Canvas canvas = new Canvas(width,height);
        drawFrame(canvas.getGraphicsContext2D(), 0, 0, width, height);
        BorderPane root = new BorderPane(canvas);
        root.setStyle("-fx-border-width: 4px; -fx-border-color: #444");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Simple Animation"); // STRING APPEARS IN WINDOW TITLEBAR!
        stage.show();
        stage.setResizable(false);
        AnimationTimer anim = new AnimationTimer() {
            private int frameNum;
            private long startTime = -1;
            private long previousTime;
            public void handle(long now) {
                if (startTime < 0) {
                    startTime = previousTime = now;
                    drawFrame(canvas.getGraphicsContext2D(), 0, 0, width, height);
                }
                else if (now - previousTime > 0.95e9/60) {
                       // The test in the else-if is to guard against a bug that has shown
                       // up in some versions of JavaFX on some computers.  The bug allows
                       // the handle() method to be called many times more than the 60 times
                       // per second that is specified in the JavaFX documentation.
                    frameNum++;
                    drawFrame(canvas.getGraphicsContext2D(), frameNum, (now-startTime)/1e9, width, height);
                    previousTime = now;
                }
            }
        };
        anim.start();
    } 

    public static void main(String[] args) {
        launch();
    }
    
} // end SimpleAnimationStarter
