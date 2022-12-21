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

public class LineBuilder extends JFrame {
    // Variable declaration
    Integer height = 1080;
    Integer width = 1920;

public static void main(String[] args) {
    LineBuilder frame = new LineBuilder();
    frame.setResizable(false);
    frame.setVisible(true);
}

   public LineBuilder() {
      JPanel panel = new JPanel();
      getContentPane().add(panel);
      setSize(1920, 1080);
   }

// ****************************************************
   public void paint(Graphics gp) {
    
    DSGraph myGraph = new DSGraph();

    myGraph.addEdge("A", "B");
    myGraph.addEdge("B", "C");
    myGraph.addEdge("A", "D");
    myGraph.addEdge("D", "C");
    myGraph.addEdge("C", "I");
    //

    DSArrayList<DSArrayList<String>> paths = new DSArrayList<>();
    paths = myGraph.findShortestPathsColumn("A", "I");
    

    // We must first
    Graphics2D graphics = (Graphics2D) gp;
    super.paint(gp);
    graphics.setFont(new Font("TimesRoman", Font.PLAIN, 32));

    //graphics.drawString("A", 200,540);
    //graphics.drawString("I", 1720,540);
    
        for (DSArrayList<String> path : paths){
            
            Integer numAltered = 1120 / path.length;
            IntStream stepsX = IntStream.range(200, 1720).filter(s -> s % numAltered == 0);
            int[] sizeOfStepsX = stepsX.toArray();

                //graphics.drawString(path[i], sizeOfStepsX[i], 540);
                //System.out.print(paths.get(i) + " ");



                // Create new arrays with null values at repeating indices


                int i = 0;
            for (String vertex : path) {
                if(path.get(i).equals(path.get(i + 1))){
                    System.out.print(path.get(i));
                }
                graphics.drawString(vertex, sizeOfStepsX[i], 540);
                
                //System.out.print(path.get(i) + " ");
                i++;
                // ONLY FOR VERTEX STUFF
                //graphics.drawString(vertex, sizeOfStepsX[i], 540);
                
                }
                i = 0;
            }
        }
    }
