package Final2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.stream.IntStream;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

//import javafx.scene.shape;

public class LineBuilder extends JFrame {
    static DSHashMap<String> hashmap;
    static DSGraph graph;
    static String hashMapAnswer;
    // Variable declaration
    Integer height = 1080;
    Integer width = 1920;
    Integer numShortestPaths = 6;
    Integer numNodes = 6;
    Integer numAltered = 1520 / numNodes;

    // Here are my Arrays
    //int shortestPathLength[] = {1, 2, 3, 4, 5};
    String[] letters = new String[]{"A", "B", "C", "D", "E", "F"};
    String[] letters2 = new String[]{"A", "B", "C", "F", "G", "F"};
    String[] letters3 = new String[]{"A", "B", "G", "F", "G", "F"};
    String[] letters4 = new String[]{"A", "G", "C", "F", "G", "F"};
    String[] letters5 = new String[]{"A", "B", "S", "F", "G", "F"};
    String[] letters6 = new String[]{"A", "B", "C", "E", "G", "F"};
     
    private static void getShortestPath() {
        getShortestPath();
        System.out.println("\nHere is the shortest path");
        DSGraph g = new DSGraph();
        // Here is a square
        g.addEdge("a", "b");
        g.addEdge("a", "d");
        g.addEdge("c", "b");
        g.addEdge("c", "d");
        g.shortestPath("c", "d");
    
        //checkExpect(g.shortestPath(), 0, "Square graph", null);
        }

public static void main(String[] args) {
    
    LineBuilder frame = new LineBuilder();
    frame.setResizable(false);
    var icon = new ImageIcon("reaper.png");
    var label = new JLabel(icon);
    frame.add(label);
    frame.setVisible(true);
 }

   public LineBuilder() {
      JPanel panel = new JPanel();
      getContentPane().add(panel);
      setSize(1920, 1080);

      panel.add(new JLabel(new ImageIcon("reaper.png")));
      //frame.add(jTextLeft);
   }
// I am not going to be using a private method, though it is important to understand
// the difference between the different frames that are being rendered. I did not know that,
// but I am having fun understanding these things!
   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // For all the nodes between the two vertices that are selected, create points in line equally seperated
        // that are labeled
        // If there are more than one shortest paths, then create another line that does not overlap the first line
        // To do this, I must create a function that will split the lines through angle tribulation
        // First, we must iterate over all of the vertices in the graph
        // We need to find all of the connections between two vertices that are selected
        }

        Image img = Toolkit.getDefaultToolkit().getImage("reaper.png");
   public void paint(Graphics gp) {
    // We must first
    Graphics2D graphics = (Graphics2D) gp;
    super.paint(gp);
    graphics.drawImage(img, 800, 500, null);
    graphics.setFont(new Font("TimesRoman", Font.PLAIN, 32));
// Here are some polylines that I am using to represent the graph visually
// It looks cool so far, though I am figuring out a system that will
// make it easier to input X and Y values
// The X and Y values are stored in arrays labeled xSin0 and ySin0

// Here I am using test integer arrays. My goal is to make sure that the arrays
// of integers will fit my screen resolution in the JFrame whenever it threads.
// The action events may matter later for each node that is processed, though this
// depends on if the painting, rendering, then buffering operates in the correct order
// This should be thus and thy could and maybe will or such that it will then be so
// For such that I will be born unto a rabbit

    // graphics.drawPolyline(1920 / numNodes,
    //int[] xSin0 = new int[numNodes];
    //{0, 384, 768, 1152, 1536, 1920};

    //int[] ySin0 = new int[numNodes];
    //{540, 700, 700, 700, 700, 540};

    IntStream stepsX = IntStream.range(200, 1720).filter(i -> i % numAltered == 0); // WORKING FINALLY
    int[] sizeOfStepsX = stepsX.toArray(); // Had to use toArray() method
    System.out.println(Arrays.toString(sizeOfStepsX)); // Also had to use Arrays.toString

    //IntStream stepsY = IntStream.range()

    //int[] sizeOfStepsY = 

    //stepsX.forEach(System.out::print);
    //IntStream intStream = IntStream.range(20, 30);
    //System.out.println("Here is the OG array: " + intStream);
    //System.out.println("Here is the altered array: " + sizeOfStepsX.forEach());

    // I am initializing many test arrays here as such

    int[] ySin = {540, 700, 700, 700, 700, 540};

    int[] ySin2 = {540, 850, 850, 850, 850, 540};

    int[] ySin3 = {540, 950, 950, 950, 950, 540};

    int[] ySin4 = {540, 380, 380, 380, 380, 540};

    int[] ySin5 = {540, 220, 220, 220, 220, 540};
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    if(numNodes == 5){
        int removeIndex = 1;
        for(int w = removeIndex; w < ySin.length - 1; w++){
            ySin[w] = ySin[w + 1];
        }
        for(int w = removeIndex; w < ySin2.length - 1; w++){
            ySin2[w] = ySin2[w + 1];
        }
        for(int w = removeIndex; w < ySin3.length - 1; w++){
            ySin3[w] = ySin3[w + 1];
        }
        for(int w = removeIndex; w < ySin4.length - 1; w++){
            ySin4[w] = ySin4[w + 1];
        }
        for(int w = removeIndex; w < ySin5.length - 1; w++){
            ySin5[w] = ySin5[w + 1];
        }
    }
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    if(numNodes == 4){
        int removeIndex = numNodes - 1;
        for(int w = removeIndex; w < ySin.length - 1; w++){
            ySin[w] = ySin[w + 1];
        }
        for(int w = removeIndex; w < ySin2.length - 1; w++){
            ySin2[w] = ySin2[w + 1];
        }
        for(int w = removeIndex; w < ySin3.length - 1; w++){
            ySin3[w] = ySin3[w + 1];
        }
        for(int w = removeIndex; w < ySin4.length - 1; w++){
            ySin4[w] = ySin4[w + 1];
        }
        for(int w = removeIndex; w < ySin5.length - 1; w++){
            ySin5[w] = ySin5[w + 1];
        }
        for(int w = removeIndex; w < ySin.length - 1; w++){
            ySin[w] = ySin[w + 1];
        }
        for(int w = removeIndex; w < ySin2.length - 1; w++){
            ySin2[w] = ySin2[w + 1];
        }
        for(int w = removeIndex; w < ySin3.length - 1; w++){
            ySin3[w] = ySin3[w + 1];
        }
        for(int w = removeIndex; w < ySin4.length - 1; w++){
            ySin4[w] = ySin4[w + 1];
        }
        for(int w = removeIndex; w < ySin5.length - 1; w++){
            ySin5[w] = ySin5[w + 1];
        }
    }
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    if(numNodes == 3){
        int removeIndex = numNodes - 1;
        for(int w = removeIndex; w < ySin.length - 1; w++){
            ySin[w] = ySin[w + 1];
        }
        for(int w = removeIndex; w < ySin2.length - 1; w++){
            ySin2[w] = ySin2[w + 1];
        }
        for(int w = removeIndex; w < ySin3.length - 1; w++){
            ySin3[w] = ySin3[w + 1];
        }
        for(int w = removeIndex; w < ySin4.length - 1; w++){
            ySin4[w] = ySin4[w + 1];
        }
        for(int w = removeIndex; w < ySin5.length - 1; w++){
            ySin5[w] = ySin5[w + 1];
        }
        for(int w = removeIndex; w < ySin.length - 1; w++){
            ySin[w] = ySin[w + 1];
        }
        for(int w = removeIndex; w < ySin2.length - 1; w++){
            ySin2[w] = ySin2[w + 1];
        }
        for(int w = removeIndex; w < ySin3.length - 1; w++){
            ySin3[w] = ySin3[w + 1];
        }
        for(int w = removeIndex; w < ySin4.length - 1; w++){
            ySin4[w] = ySin4[w + 1];
        }
        for(int w = removeIndex; w < ySin5.length - 1; w++){
            ySin5[w] = ySin5[w + 1];
        }
        for(int w = removeIndex; w < ySin.length - 1; w++){
            ySin[w] = ySin[w + 1];
        }
        for(int w = removeIndex; w < ySin2.length - 1; w++){
            ySin2[w] = ySin2[w + 1];
        }
        for(int w = removeIndex; w < ySin3.length - 1; w++){
            ySin3[w] = ySin3[w + 1];
        }
        for(int w = removeIndex; w < ySin4.length - 1; w++){
            ySin4[w] = ySin4[w + 1];
        }
        for(int w = removeIndex; w < ySin5.length - 1; w++){
            ySin5[w] = ySin5[w + 1];
        }
    }
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    if(numNodes == 2){
        int removeIndex = numNodes - 1;
        for(int w = removeIndex; w < ySin.length - 1; w++){
            ySin[w] = ySin[w + 1];
        }
        for(int w = removeIndex; w < ySin2.length - 1; w++){
            ySin2[w] = ySin2[w + 1];
        }
        for(int w = removeIndex; w < ySin3.length - 1; w++){
            ySin3[w] = ySin3[w + 1];
        }
        for(int w = removeIndex; w < ySin4.length - 1; w++){
            ySin4[w] = ySin4[w + 1];
        }
        for(int w = removeIndex; w < ySin5.length - 1; w++){
            ySin5[w] = ySin5[w + 1];
        }
        for(int w = removeIndex; w < ySin.length - 1; w++){
            ySin[w] = ySin[w + 1];
        }
        for(int w = removeIndex; w < ySin2.length - 1; w++){
            ySin2[w] = ySin2[w + 1];
        }
        for(int w = removeIndex; w < ySin3.length - 1; w++){
            ySin3[w] = ySin3[w + 1];
        }
        for(int w = removeIndex; w < ySin4.length - 1; w++){
            ySin4[w] = ySin4[w + 1];
        }
        for(int w = removeIndex; w < ySin5.length - 1; w++){
            ySin5[w] = ySin5[w + 1];
        }
        for(int w = removeIndex; w < ySin.length - 1; w++){
            ySin[w] = ySin[w + 1];
        }
        for(int w = removeIndex; w < ySin2.length - 1; w++){
            ySin2[w] = ySin2[w + 1];
        }
        for(int w = removeIndex; w < ySin3.length - 1; w++){
            ySin3[w] = ySin3[w + 1];
        }
        for(int w = removeIndex; w < ySin4.length - 1; w++){
            ySin4[w] = ySin4[w + 1];
        }
        for(int w = removeIndex; w < ySin5.length - 1; w++){
            ySin5[w] = ySin5[w + 1];
        }
        for(int w = removeIndex; w < ySin.length - 1; w++){
            ySin[w] = ySin[w + 1];
        }
        for(int w = removeIndex; w < ySin2.length - 1; w++){
            ySin2[w] = ySin2[w + 1];
        }
        for(int w = removeIndex; w < ySin3.length - 1; w++){
            ySin3[w] = ySin3[w + 1];
        }
        for(int w = removeIndex; w < ySin4.length - 1; w++){
            ySin4[w] = ySin4[w + 1];
        }
        for(int w = removeIndex; w < ySin5.length - 1; w++){
            ySin5[w] = ySin5[w + 1];
        }
    }
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    if(numNodes == 1){
        int removeIndex = numNodes - 1;
        for(int w = removeIndex; w < ySin.length - 1; w++){
            ySin[w] = ySin[w + 1];
        }
        for(int w = removeIndex; w < ySin2.length - 1; w++){
            ySin2[w] = ySin2[w + 1];
        }
        for(int w = removeIndex; w < ySin3.length - 1; w++){
            ySin3[w] = ySin3[w + 1];
        }
        for(int w = removeIndex; w < ySin4.length - 1; w++){
            ySin4[w] = ySin4[w + 1];
        }
        for(int w = removeIndex; w < ySin5.length - 1; w++){
            ySin5[w] = ySin5[w + 1];
        }
        for(int w = removeIndex; w < ySin.length - 1; w++){
            ySin[w] = ySin[w + 1];
        }
        for(int w = removeIndex; w < ySin2.length - 1; w++){
            ySin2[w] = ySin2[w + 1];
        }
        for(int w = removeIndex; w < ySin3.length - 1; w++){
            ySin3[w] = ySin3[w + 1];
        }
        for(int w = removeIndex; w < ySin4.length - 1; w++){
            ySin4[w] = ySin4[w + 1];
        }
        for(int w = removeIndex; w < ySin5.length - 1; w++){
            ySin5[w] = ySin5[w + 1];
        }
        for(int w = removeIndex; w < ySin.length - 1; w++){
            ySin[w] = ySin[w + 1];
        }
        for(int w = removeIndex; w < ySin2.length - 1; w++){
            ySin2[w] = ySin2[w + 1];
        }
        for(int w = removeIndex; w < ySin3.length - 1; w++){
            ySin3[w] = ySin3[w + 1];
        }
        for(int w = removeIndex; w < ySin4.length - 1; w++){
            ySin4[w] = ySin4[w + 1];
        }
        for(int w = removeIndex; w < ySin5.length - 1; w++){
            ySin5[w] = ySin5[w + 1];
        }
        for(int w = removeIndex; w < ySin.length - 1; w++){
            ySin[w] = ySin[w + 1];
        }
        for(int w = removeIndex; w < ySin2.length - 1; w++){
            ySin2[w] = ySin2[w + 1];
        }
        for(int w = removeIndex; w < ySin3.length - 1; w++){
            ySin3[w] = ySin3[w + 1];
        }
        for(int w = removeIndex; w < ySin4.length - 1; w++){
            ySin4[w] = ySin4[w + 1];
        }
        for(int w = removeIndex; w < ySin5.length - 1; w++){
            ySin5[w] = ySin5[w + 1];
        }
        for(int w = removeIndex; w < ySin.length - 1; w++){
            ySin[w] = ySin[w + 1];
        }
        for(int w = removeIndex; w < ySin2.length - 1; w++){
            ySin2[w] = ySin2[w + 1];
        }
        for(int w = removeIndex; w < ySin3.length - 1; w++){
            ySin3[w] = ySin3[w + 1];
        }
        for(int w = removeIndex; w < ySin4.length - 1; w++){
            ySin4[w] = ySin4[w + 1];
        }
        for(int w = removeIndex; w < ySin5.length - 1; w++){
            ySin5[w] = ySin5[w + 1];
        }
    }
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        
        // Here are all of the test cases for how many numShortestPaths there are present
        // I will see them through, they will be my light in the darkness
        // Oh goodness me, what a tribulation is this
        // Fly through this sky and go all through this world
        for(int i = 0; i <= numShortestPaths; i++){ // i is the steps for how many shortest paths
            if(numShortestPaths == 1){
                Line2D line = new Line2D.Float(0, height / 2, width, height / 2);
                graphics.draw(line);
                graphics.drawString(letters[i], sizeOfStepsX[i], 540);
            }
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            if(numShortestPaths == 2){
                graphics.drawPolyline(sizeOfStepsX, ySin, numNodes);
                graphics.drawPolyline(sizeOfStepsX, ySin4, numNodes);

                graphics.drawString(letters[i], sizeOfStepsX[i], ySin[i]);
                graphics.drawString(letters4[i], sizeOfStepsX[i], ySin4[i]);
            }
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            if(numShortestPaths == 3){
                Line2D line = new Line2D.Float(0, height / 2, width, height / 2);
                graphics.draw(line);
                graphics.drawPolyline(sizeOfStepsX, ySin, numNodes);
                graphics.drawPolyline(sizeOfStepsX, ySin4, numNodes);

                graphics.drawString(letters[i], sizeOfStepsX[i], 540);
                graphics.drawString(letters[i], sizeOfStepsX[i], ySin[i]);
                graphics.drawString(letters4[i], sizeOfStepsX[i], ySin4[i]);
            }
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            if(numShortestPaths == 4){
                Line2D line = new Line2D.Float(0, height / 2, width, height / 2);
                graphics.draw(line);
                graphics.drawPolyline(sizeOfStepsX, ySin, numNodes);
                graphics.drawPolyline(sizeOfStepsX, ySin2, numNodes);
                graphics.drawPolyline(sizeOfStepsX, ySin4, numNodes);

                graphics.drawString(letters[i], sizeOfStepsX[i], ySin[i]);
                graphics.drawString(letters[i], sizeOfStepsX[i], ySin2[i]);
                graphics.drawString(letters[i], sizeOfStepsX[i], ySin4[i]);
            }
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            if(numShortestPaths == 5){
                Line2D line = new Line2D.Float(0, height / 2, width, height / 2);
                graphics.draw(line);
                graphics.drawPolyline(sizeOfStepsX, ySin, numNodes);
                graphics.drawPolyline(sizeOfStepsX, ySin2, numNodes);
                graphics.drawPolyline(sizeOfStepsX, ySin4, numNodes);
                graphics.drawPolyline(sizeOfStepsX, ySin5, numNodes);

                graphics.drawString(letters[i], sizeOfStepsX[i], 540);
                graphics.drawString(letters[i], sizeOfStepsX[i], ySin[i]);
                graphics.drawString(letters2[i], sizeOfStepsX[i], ySin2[i]);
                graphics.drawString(letters4[i], sizeOfStepsX[i], ySin4[i]);
                graphics.drawString(letters5[i], sizeOfStepsX[i], ySin5[i]);
            }
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            if(numShortestPaths == 6){
                Line2D line = new Line2D.Float(0, height / 2, width, height / 2);
                graphics.draw(line);
                graphics.drawPolyline(sizeOfStepsX, ySin, numNodes);
                graphics.drawPolyline(sizeOfStepsX, ySin2, numNodes);
                graphics.drawPolyline(sizeOfStepsX, ySin3, numNodes);
                graphics.drawPolyline(sizeOfStepsX, ySin4, numNodes);
                graphics.drawPolyline(sizeOfStepsX, ySin5, numNodes);

                graphics.drawString(letters[i], sizeOfStepsX[i], 540);
                graphics.drawString(letters[i], sizeOfStepsX[i], ySin[i]);
                graphics.drawString(letters[i], sizeOfStepsX[i], ySin2[i]);
                graphics.drawString(letters[i], sizeOfStepsX[i], ySin3[i]);
                graphics.drawString(letters[i], sizeOfStepsX[i], ySin4[i]);
                graphics.drawString(letters[i], sizeOfStepsX[i], ySin5[i]);
                
    }
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    }
}
   // The button will start building lines in jButton1ActionPerformed
   // Two text fields will be used to input vertices from the graph
   // These are represented as letters or words
   private javax.swing.JButton jButton1;
   private javax.swing.JButton jTextField1;
   private javax.swing.JButton jTextField2;
   private javax.swing.JButton jLabel1;
   
}