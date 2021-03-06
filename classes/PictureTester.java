/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }

    public static void testCollage2()
    {
        Picture canvas = new Picture("640x480.jpg");
        canvas.createCollage2();
        canvas.explore();
    }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }

  public static void testFixUnderwater(){
    Picture water= new Picture("water.jpg");
    water.explore();
    water.fixUnderwater();;
    water.explore();
  }

  public static void testMirrorRightToLeft(){
    Picture temple= new Picture("temple.jpg");
    temple.explore();
    temple.mirrorRightToLeft();
    temple.explore();
  }

  public static void testMirrorHorizontal(){
    Picture motorcycle= new Picture("redMotorcycle.jpg");
    motorcycle.explore();
    motorcycle.mirrorHorizontal();
    motorcycle.explore();
  }

  public static void testMirrorBottomToTop(){
    Picture motorcycle= new Picture("redMotorcycle.jpg");
    motorcycle.explore();
    motorcycle.mirrorBottomToTop();
    motorcycle.explore();
  }

  public static void testMirrorDiagonal(){
    Picture motorcycle= new Picture("redMotorcycle.jpg");
    motorcycle.explore();
    motorcycle.mirrorDiagonal();
    motorcycle.explore();
  }

  public static void testMirrorArms(){
    Picture snowman= new Picture("snowman.jpg");
    snowman.explore();
    snowman.mirrorArms();
    snowman.explore();
  }

  public static void testMirrorGul(){
    Picture seagull= new Picture("seagull.jpg");
    seagull.explore();
    seagull.mirrorGul();
    seagull.explore();
  }

  public static void testCopy(){
      Picture mark= new Picture("blue-mark.jpg");
      Picture flo= new Picture("flower1.jpg");
      mark.explore();
      mark.copy(flo,50,50,200,200);
      mark.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
   // testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
  // testMirrorHorizontal();
   // testMirrorBottomToTop();
  //  testMirrorRightToLeft();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
   // testMirrorArms();
   // testMirrorGul();
    //testMirrorDiagonal();
    testCollage2();
  //  testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}