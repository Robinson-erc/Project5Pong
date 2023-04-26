
/**
 * Write a description of class Rectangle2Di here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rectangle2Di extends Shape2Di
{
    private int height,width;
    
    public Rectangle2Di(){
        super(0,0,0);
        this.height=40;
        this.width=40;
    }
    
    public Rectangle2Di(int colorIndex,int xPosition, int yPosition,int width,int height){
       super(colorIndex, xPosition, yPosition);
        this.height=height;
        this.width=width;
        
    }
    @Override
    public void Draw(java.awt.Graphics g){
         if(super.GetFill()){
            g.setColor(super.GetFillColor()); 
            g.fillRect(super.GetX(), super.GetY(), this.height, this.width);
        }
        if(super.GetOutline()){
            g.setColor(super.GetOutlineColor());
            g.drawRect(super.GetX(), super.GetY(), this.height, this.width);
        }
    }
    @Override
     public void Animate(){
        xPos+=xVel;
        yPos+=yVel;
    }
}
