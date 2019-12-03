import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {
    //initialize ball position and initial velocity
    int x = 0, y = 0, xVelocity = 1, yVelocity= 1;
    int width = 300, height = 400;

    private void moveBall(){
        if (x > width)
            xVelocity = -1;
        if (y > height)
            yVelocity = -1;
        // Move ball 
        x = x + xVelocity;
        y = y + yVelocity;
    }

    public void paint(Graphics g){
        //this clears the screen before reprinting circle at new position
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        //Antialiasing makes the figure smoother
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Draws the circle at new position with same diameter.
        g.fillOval(x, y, 30, 30);
    }

    public static void main(String[] args) throws InterruptedException {
        // creates a new, initially invisible Frame with the specified title.
        JFrame frame = new JFrame("Mini Tennis");
        
        // Create an isntance of the game
        Game game = new Game();
        // add the game object to the frame
        frame.add(game);
        // set window size (width, height)
        frame.setSize(game.width, game.height);
        // initially invisible so needs to be made visible
        frame.setVisible(true);
        // close the frame when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while (true) {
			game.moveBall();
            game.repaint();
            // pause the execution of current thread for specified time in milliseconds.
			Thread.sleep(10);
		}
    }
}