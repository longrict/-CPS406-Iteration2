
package bugreportapplication;
import bugreportapplication.model.BugReport;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import org.jfree.chart.plot.CategoryPlot;
/**
 *
 * @author David Liu, Longric Tran, Refath Ahmed, Tao Wang, Vito Carnovale (Group #33)
 *
 * Represents a bugReportGraph class for creating graphs that display information about previous sprints
 */
public class bugReportGraph extends javax.swing.JFrame {

    /**
     * Creates new form bugReportGraph; uses current date as the cutoff
     */
    public bugReportGraph() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        ArrayList<BugReport> bugs = AccessDB.getReports();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int resolved_count = 0;
        int unresolved_count = 0;
        
        // get current date in the form YYYY-MM-DD
        ZonedDateTime easternDateTime = ZonedDateTime.now(ZoneId.of("America/Toronto"));
        String formattedDate = easternDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate current_date = LocalDate.parse(formattedDate, formatter);

        // get count of unresolved and resolved bugs before current date
        for (BugReport bug : bugs){
            LocalDate report_date = LocalDate.parse(bug.getDate(),formatter);
            if (report_date.isBefore(current_date)){
                if (bug.getStatus().equals("Unresolved")){
                    unresolved_count++;
                }else{
                    resolved_count++;
                }
            }
        }
        
        dataset.addValue(unresolved_count, "Series 1", "Unresolved");
        dataset.addValue(resolved_count, "Series 1", "Resolved");

        // Create a chart with counts of unresolved and resolved bugs
        JFreeChart chart = ChartFactory.createBarChart(
                "Bug Reports Before "+current_date.toString(),
                "Category",
                "# Of Reports",
                dataset,
                PlotOrientation.VERTICAL, false, true, false
        );
        
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setLowerBound(0);
        
        int max_val = bugs.size();
        if (max_val == 0){
            yAxis.setUpperBound(1);
        } else{
            yAxis.setUpperBound(bugs.size());
        }
        
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 300));
        setContentPane(chartPanel);

        }

        /**
         * Creates new form bugReportGraph; uses specified date interval
         */
        public bugReportGraph(String startDate, String endDate) {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        ArrayList<BugReport> bugs = AccessDB.getReports();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int resolved_count = 0;
        int unresolved_count = 0;
        
        // convert string date to LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start_date = LocalDate.parse(startDate, formatter);
        LocalDate end_date = LocalDate.parse(endDate,formatter);
        
        // get count of unresolved and resolved bugs before current date
        for (BugReport bug : bugs){
            LocalDate report_date = LocalDate.parse(bug.getDate(),formatter);
            if ((report_date.isBefore(end_date) && report_date.isAfter(start_date)) || 
                    report_date.equals(end_date) || report_date.equals(start_date)){
                if (bug.getStatus().equals("Unresolved")){
                    unresolved_count++;
                }else{
                    resolved_count++;
                }
            }
        }

        dataset.addValue(unresolved_count, "Series 1", "Unresolved");
        dataset.addValue(resolved_count, "Series 1", "Resolved");

        // Create a chart with counts of unresolved and resolved bugs
        JFreeChart chart = ChartFactory.createBarChart(
                "Bug Reports Between "+start_date+" and "+ end_date,
                "Category",
                "# Of Reports",
                dataset,
                PlotOrientation.VERTICAL, false, true, false
        );
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setLowerBound(0);
        
        int max_val = bugs.size();
        if (max_val == 0){
            yAxis.setUpperBound(1);
        } else{
            yAxis.setUpperBound(bugs.size());
        }
        
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 300));
        setContentPane(chartPanel);
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(bugReportGraph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bugReportGraph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bugReportGraph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bugReportGraph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bugReportGraph().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
