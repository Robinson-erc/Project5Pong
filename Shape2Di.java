import java.awt.Color;

/**
 * Write a description of class Shape2Di here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Shape2Di
{
    protected int xPos;
    protected int yPos;
    protected double sX;
    protected double sY;
    protected double rotAngleZ;

    protected int xVel;
    protected int     yVel;               
    protected Color   fillColor;          
    protected int     fillColorIndex;     
    protected Color   outlineColor;       
    protected int     outlineColorIndex;  
    protected boolean fill;               
    protected boolean outline;            
    // RGB color table

    public static final Color[] COLORS = {

            //         R     G    B

            new Color(255,   0,   0),  // Red    0

            new Color(  0, 255,   0),  // Green  1

            new Color(  0,   0, 255),  // Blue   2

            new Color(  0,   0,   0),  // Black  3

            new Color(128, 128, 128),  // Grey   4

            new Color(255, 255, 255),  // White  5

            new Color(255,  38,  38),

            new Color(255, 168,  38),

            new Color(212, 255,  38),

            new Color( 82, 255,  38),

            new Color( 38, 255, 125),

            new Color( 38, 255, 255),

            new Color( 38, 125, 255),

            new Color( 82,  38, 255),

            new Color(212,  38, 255),

            new Color(255,  38, 168),

        };
    public Shape2Di(){
      
    }
    public void Animate(){
        xPos+=xVel;
        yPos+=yVel;
    }
    public Shape2Di(int fillColorIndex, int xPosition, int yPosition){
        this.xPos = xPosition;
        this.yPos=yPosition;
        this.xVel=0;
        this.yVel=0;
        this.sX=1.0;
        this.sY=1.0;
        this.rotAngleZ=0.0;
        this.fillColorIndex=fillColorIndex;
        this.fillColor = COLORS[fillColorIndex];
        this.fill = true;
        this.outline = false;
    }

    public void Move(int xDelta, int yDelta){
        this.xPos += xDelta;
        this.yPos += yDelta;
    }

    public boolean GetFill(){
        return fill;
    }

    public java.awt.Color GetFillColor(){
        return fillColor;
    }

    public int GetFillColorIndex(){
        return fillColorIndex;
    }

    public boolean GetOutline(){
        return outline;
    }

    public java.awt.Color GetOutlineColor(){
        return outlineColor;
    }

    public int GetOutlineColorIndex(){
        return outlineColorIndex;
    }

    public int GetX(){
        return xPos;
    }

    public int GetXSpeed(){
        return xVel;
    }

    public int GetY(){
        return yPos;
    }

    public int GetYSpeed(){
        return yVel;
    }
    public int NegateYSpeed(){
        return yVel=-yVel;
    }
    public int NegateXSpeed(){
        return xVel=-xVel;
    }

    public void Move(double xDelta, double yDelta){
        this.xPos=xPos;
        this.yPos=yPos;
    }

    public void setFill(boolean setting){
        this.fill=setting;
    }

    public void setFillColor(int fillColorIndex){
        this.fillColorIndex=fillColorIndex;
    }

    public void SetOutline(boolean Setting){
        this.outline=Setting;
    }

    public void SetOutlineColor(int outlineColorIndex){
        this.outlineColorIndex=outlineColorIndex;
    }

    public void SetPos(int x,int y){
        this.xPos=x;
        this.yPos=y;
    }

    public void SetSpeed(int xV, int yV){
        this.xVel=xV;
        this.yVel=yV;
    }
    public double GetZRotate(){
        return rotAngleZ;
    }
    public double GetScaleX(){
        return sX;
    }
    public double GetScaleY(){
        return sY;
    }
    public void SetScale(double x, double y){
        this.sX=x;
        this.sY=y;
        
    }
    public void SetRotateZ(double degs){
        this.rotAngleZ=degs;
    }
    



    public abstract void Draw(java.awt.Graphics g);

    
}
