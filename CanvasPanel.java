/**
 * 2D CanvasPanel
 * 
 *
 * @author (Prof R)
 * @version (v1.0 11-17-22)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CanvasPanel extends JPanel
{
    public final static int X_CORNER = 25;
    public final static int Y_CORNER = 25;
    public final static int CANVAS_WIDTH = 400;
    public final static int CANVAS_HEIGHT = 400;

    // private [] Shapes;
    public Circle Ball;
    //private Circle circle2;
    public Rectangle2Di Ball1;
    public Rectangle2Di Paddle1;
    public Rectangle2Di Paddle2;
    public int frameNumber;

    public CanvasPanel()
    {
        // Create some shapes, they should be in a List
        //Ball = new Circle();  // Construct a circle with the default color
        //circle2 = new Circle(7); // Construct a circle with color index 7
        Ball1= new Rectangle2Di(2,200,200,20,20);
        Paddle1= new Rectangle2Di(2,10,5,150,20); //paddle for player 1
        Paddle2= new Rectangle2Di(5,415,5,150,20); //paddle for player 2
        // Callback fro keyboard events
        this.setFocusable(true);
        this.addKeyListener(new myActionListener());
        System.out.println("keyboard event registered");
        Ball1.SetSpeed(10,10);

        // Create a render loop
        // Create a Swing Timer that will tick 30 times a second
        // At each tick the ActionListener that was registered via the lambda expression will be invoked
        Timer renderLoop = new Timer(30, (ActionEvent ev) -> {frameNumber++; Simulate(); repaint();}); // lambda expression for ActionListener implements actionPerformed
        renderLoop.start();
    }

    public void Simulate()
    {
        //Ball.Move(1, 2); // move the shape along via a delta in x and y
        // circle2.Move(2, 1); // move the shape along via a delta in x and y
        Ball1.Animate();

       
    }
    // This method is called by renderloop
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set window background to black
        g.setColor(Color.BLACK);
        g.fillRect(0,0,CANVAS_WIDTH + 2 * X_CORNER, CANVAS_HEIGHT + 2 * Y_CORNER); //draw the black border

        // Set canvas background to grey
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(X_CORNER, Y_CORNER, CANVAS_WIDTH, CANVAS_HEIGHT); //make the canvas white

        // Need to make draw polymorphic and in a List, draws objects on the canvas
        Ball1.Draw(g);
        //circle2.draw(g);
        Paddle1.Draw(g);
        Paddle2.Draw(g);

        //Collision Detection
        int ballX = Ball1.GetX();
        int ballY = Ball1.GetY();
        int ballH = Ball1.GetHeight();
        int ballW = Ball1.GetWidth();
        //ball collision against borders
        if( (ballY > (CANVAS_HEIGHT) ) || (ballY <= 25) ){
            Ball1.NegateYSpeed();
        }
        if( (ballX > (CANVAS_WIDTH) ) || (ballX <= 0) ){
            Ball1.NegateXSpeed();
        }

        
        
    }

    public static int getCanvasWidth()
    {
        return CANVAS_WIDTH;
    }

    public static int getCanvasHeight()
    {
        return CANVAS_HEIGHT;
    }

    public static int getCanvasXBorder()
    {
        return X_CORNER;
    }

    public static int getCanvasYBorder()
    {
        return Y_CORNER;
    }
    public class myActionListener extends KeyAdapter 
    {
        public void keyPressed(KeyEvent e)
        {
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_UP:
                    if(Paddle1.GetY()>=25){
                        Paddle1.Move(0,-10);//Moves paddle 1 down
                    }
                    System.out.println("press up arrow");
                    break;
                case KeyEvent.VK_DOWN:
                    if(Paddle1.GetY()<=275){
                        Paddle1.Move(0,10);
                    }
                    System.out.println("press down arrow");
                    break;
                case KeyEvent.VK_W:
                    System.out.println("press W Key");
                    if(Paddle2.GetY()>=25){
                        Paddle2.Move(0,-10);
                    }
                    break;
                case KeyEvent.VK_S:
                    System.out.println("press S Key");
                    if(Paddle2.GetY()<=275){
                        Paddle2.Move(0,10);
                    }
                    break;
                default:
                    System.out.println("press some other key besides the arrow keys");
            }
        }

        public void keyReleased(KeyEvent e)
        {
            System.out.println("released");
            Paddle1.SetSpeed(0,0);
        }
    }
  
}
