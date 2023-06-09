
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
        this.height=20;
        this.width=20;
    }
    public void SetHeight(int height){
        this.height=height;
    }
    public void SetWidth(int width){
        this.width=width;
    }
    public int GetHeight(){
        return height;
    }
    public int GetWidth(){
        return width;
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
