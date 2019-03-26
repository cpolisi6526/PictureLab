import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }

  public void keepOnlyBlue()
  {
    Pixel[][] pixels= this.getPixels2D();
    for(Pixel[] rowArray: pixels){
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setGreen(0);
        pixelObj.setRed(0);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }

  public void mirrorRightToLeft() {
      Pixel[][] pixels = this.getPixels2D();
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      int width = pixels[0].length;
      for (int row = 0; row < pixels.length; row++) {
          for (int col = 0; col < width / 2; col++) {
              leftPixel = pixels[row][col];
              rightPixel = pixels[row][width - 1 - col];
              leftPixel.setColor(rightPixel.getColor());
          }
      }
  }

  public void mirrorHorizontal(){
      Pixel[][] pixels= this.getPixels2D();
      Pixel topPixel= null;
      Pixel botPixel= null;
      int height= pixels.length;
      for(int row=0; row<pixels.length;row++){
          for(int col=0;col<pixels[0].length;col++){
              topPixel= pixels[row][col];
              botPixel= pixels[height-1-row][col];
              botPixel.setColor(topPixel.getColor());
          }
      }
  }

  public void mirrorBottomToTop(){
      Pixel[][] pixels= this.getPixels2D();
      Pixel topPixel= null;
      Pixel botPixel= null;
      int height= pixels.length;
      for(int row=0; row<pixels.length;row++){
          for(int col=0;col<pixels[0].length;col++){
              topPixel= pixels[row][col];
              botPixel=pixels[height-1-row][col];
              topPixel.setColor(botPixel.getColor());
          }
      }
  }

  public void mirrorDiagonal(){
      Pixel[][] pixels= this.getPixels2D();
      Pixel topPixel=null;
      Pixel botPixel= null;
      int height=pixels.length;
      int width=pixels[0].length;
      for(int row=0; row<pixels.length;row++) {
          for (int col = 0; col < pixels[0].length; col++) {
              topPixel = pixels[row][col];
              botPixel = pixels[height - 1 - row][width - 1 - col];
              botPixel.setColor(topPixel.getColor());
          }
      }
  }
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }

  public void mirrorArms(){
    Pixel pixels[][]=this.getPixels2D();
    Pixel top=null;
    Pixel bot=null;
    int mirrorPoint=190;
    int height= pixels.length;
    for(int row=160;row<mirrorPoint;row++){
        for(int col=100;col<292;col++){
        top=pixels[row][col];
        bot=pixels[(height-row+(height/3))][col];
        bot.setColor(top.getColor());
        }
    }
  }

  public void mirrorGul(){
      Pixel pixels[][]= this.getPixels2D();
      Pixel left=null;
      Pixel right=null;
      int width=pixels[0].length;
      for(int row=235;row<320;row++){
          for(int col=235;col<345;col++){
              left=pixels[row][col];
              right=pixels[row+15][col+150];
              right.setColor(left.getColor());
          }
      }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  public void copy(Picture fromPic, int startRow, int startCol, int endRow, int endCol) {
      Pixel fromPixel = null;
      Pixel toPixel = null;
      Pixel[][] toPixels = this.getPixels2D();
      Pixel[][] fromPixels = fromPic.getPixels2D();
      for (int fromRow = 0, toRow = startRow;
           fromRow < fromPixels.length &&
                   toRow < endRow;
           fromRow++, toRow++) {
          for (int fromCol = 0, toCol = startCol;
               fromCol < fromPixels[0].length &&
                       toCol < endCol;
               fromCol++, toCol++) {
              fromPixel=fromPixels[fromRow][fromCol];
              toPixel=toPixels[toRow][toCol];
              toPixel.setColor(fromPixel.getColor());
          }
      }
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }

  public void createCollage2(){
      Picture mark= new Picture("blue-mark.jpg");
      Picture barb= new Picture("barbaraS.jpg");
      this.copy(mark,0,0);
      this.copy(barb,100,0);
      Picture blueBarb=new Picture(barb);
      blueBarb.keepOnlyBlue();
      this.copy(blueBarb,200,0);
      Picture negMark= new Picture(mark);
      negMark.negate();
      this.copy(negMark,300,0);
      this.mirrorVertical();
      this.write("mandb");
  }
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }

  public void negate() {
      int red=0;
      int green=0;
      int blue=0;
      Pixel[][] pixels = this.getPixels2D();
      for(int row=0; row<pixels.length;row++){
          for(int col=0;col<pixels[row].length;col++){
              red=pixels[row][col].getRed();
              green=pixels[row][col].getGreen();
              blue=pixels[row][col].getBlue();
              pixels[row][col].setRed(255-red);
              pixels[row][col].setGreen(255-green);
              pixels[row][col].setBlue(255-blue);
          }
      }
  }

  public void grayscale() {
      int red = 0;
      int green = 0;
      int blue = 0;
      int aver = 0;
      Pixel[][] pixels = this.getPixels2D();
      for (int row = 0; row < pixels.length; row++) {
          for (int col = 0; col < pixels[row].length; col++) {
              red = pixels[row][col].getRed();
              green = pixels[row][col].getGreen();
              blue = pixels[row][col].getBlue();
              aver = (blue + red + green) / 3;
              pixels[row][col].setGreen(aver);
              pixels[row][col].setRed(aver);
              pixels[row][col].setBlue(aver);
          }
      }
  }

  public void fixUnderwater(){
      int r=0;
      int g=0;
      int b=0;
      Pixel[][] pixels= this.getPixels2D();
      for(int row=0; row<pixels.length;row++){
          for (int col=0; col<pixels[row].length;col++){
              r = pixels[row][col].getRed();
              g = pixels[row][col].getGreen();
              b = pixels[row][col].getBlue();
              pixels[row][col].setGreen(g-15);
              pixels[row][col].setRed(r+50);
              pixels[row][col].setBlue(b+10);
          }
      }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
