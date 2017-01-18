// CSE 142
// Homework 3, pt B
// Celine Pastore
// October 14, 2016

// This program draws a "Cafe Wall" illusion.

import java.awt.*;

public class CafeWall {
   public static final int MORTAR = 2; // change to alter pixel width separating rows
   
   public static void main(String[] arg) {
      DrawingPanel p = new DrawingPanel(650, 400);
      p.setBackground(Color.GRAY);
      Graphics g = p.getGraphics();
      
      // draw free-floating rows composed of <length> pairs of boxes 
      // with sidelength <size>
      // drawRow(Graphics g, x, y, size, length)
      drawRow(g, 0, 0, 20, 4);
      drawRow(g, 50, 70, 30, 5);
      
      // draw square grids of rows 
      // (Graphics g, x, y, size, length, offset) 
      drawGrid(g, 10, 150, 25, 4, 0);
      drawGrid(g, 250, 200, 25, 3, 10);
      drawGrid(g, 425, 180, 20, 5, 10);
      drawGrid(g, 400, 20, 35, 2, 35);
            
   }
   
   // Draw a single row of alternating black and white boxes
   // with given length (# of box pairs)
   public static void drawRow(Graphics g, int x, int y, int size, int length) {
      for(int i = 0; i < length; i++) {      
         // draw black box with blue X
         g.setColor(Color.BLACK);
         g.fillRect((x + 2*size*i), y, size, size);
         g.setColor(Color.BLUE);
         g.drawLine(x + 2*size*i, y, x + 2*size*i + size, y + size);
         g.drawLine(x + 2*size*i + size, y, x + 2*size*i, y + size);
         
         // draw white box
         g.setColor(Color.WHITE);
         g.fillRect((x + 2*size*i) + size, y, size, size);
      }
   }
   
   // Draw a grid of stacked rows separated by MORTAR
   // where # rows = # of boxes in each row (length*2)
   public static void drawGrid(Graphics g, int x, int y, int size, int length, int offset) {
      for(int row = 0; row < length*2; row++) {
         drawRow(g, x + offset*(row%2), y + (MORTAR+size)*row, size, length);
      }
   }
    
}