
package sierpinskirecursivenongui;

public class SierpinskiRecursiveNonGUI {

    public static void main(String[] args) {
        //Set the base of the triangle
        int side = 400;
        Point p1 = new Point(side/2, 0);    // e.g. P1(200,0)
        Point p2 = new Point(0, side);      // e.g. P2(0, 400)
        Point p3 = new Point(side, side);   // e.g. P3(400, 400)
        
        //Initiate the recursive calling
        int  order = 2;
        
        sierpinskiTriangles(order, p1, p2, p3);
        
    }//main
    
    static void printTrianglePoints(int order, Point p1, Point p2, Point p3){
        System.out.printf("Order: %2d  P1(%6.2f, %6.2f)\t " + 
                          "P2(%6.2f, %6.2f)\t P3(%6.2f, %6.2f)\n", 
                          order, p1.x, p1.y, p2.x, p2.y, p3.x, p3.y);
    }//printTrianglePoints
    
    static void sierpinskiTriangles(int order, Point p1, Point p2, Point p3){
        printTrianglePoints(order, p1, p2, p3);
        if (order == 0) return;
        
        //Calculate new midpoints from current sides
        Point p12 = new Point( (p1.x + p2.x)/2, (p1.y + p2.y)/2 );
        Point p13 = new Point( (p1.x + p3.x)/2, (p1.y + p3.y)/2 );
        Point p23 = new Point( (p2.x + p3.x)/2, (p2.y + p3.y)/2 );
        
        //Draw the new three triangles emerging from [p1, p2, p3]
        sierpinskiTriangles(order-1, p1, p12, p13);
        sierpinskiTriangles(order-1, p2, p12, p23);
        sierpinskiTriangles(order-1, p3, p13, p23);
            
    }//sierpinskiTriangle
}//class
