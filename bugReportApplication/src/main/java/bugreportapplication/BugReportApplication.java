

package bugreportapplication;
import javax.swing.*;
import bugreportapplication.bugReport;
import java.awt.*;
/**
 *
 * @author 
 */
public class BugReportApplication {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new bugReportform());
        frame.setVisible(true);
        
        
        
    }
}
