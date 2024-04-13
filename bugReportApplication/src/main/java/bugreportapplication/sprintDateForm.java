package bugreportapplication;
import java.time.YearMonth;

/**
 *
 * @author David Liu, Longric Tran, Refath Ahmed, Tao Wang, Vito Carnovale (Group #33)
 *
 * Represents a sprintDateForm class to prompt user for the start and end date for which bug statistics will be displayed
 */
public class sprintDateForm extends javax.swing.JFrame {

    /**
     * Creates new form sprintDateForm
     */
    public sprintDateForm() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sprintTitle = new javax.swing.JLabel();
        dayLabel = new javax.swing.JLabel();
        monthLabel = new javax.swing.JLabel();
        yearLabel = new javax.swing.JLabel();
        getSprintGraphBtn = new javax.swing.JButton();
        dayInput = new javax.swing.JTextField();
        monthInput = new javax.swing.JTextField();
        yearInput = new javax.swing.JTextField();
        errorMsg = new javax.swing.JLabel();
        dayLabel1 = new javax.swing.JLabel();
        monthLabel1 = new javax.swing.JLabel();
        yearLabel1 = new javax.swing.JLabel();
        yearInput1 = new javax.swing.JTextField();
        monthInput1 = new javax.swing.JTextField();
        dayInput1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sprintTitle.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        sprintTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sprintTitle.setText("Enter Sprint Interval (dd-mm-year)");

        dayLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dayLabel.setText("Start Day ");

        monthLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        monthLabel.setText("Start Month");

        yearLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        yearLabel.setText("Start Year ");

        getSprintGraphBtn.setText("Get Sprint Graph");
        getSprintGraphBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getSprintGraphBtnActionPerformed(evt);
            }
        });

        errorMsg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        errorMsg.setForeground(new java.awt.Color(255, 51, 51));
        errorMsg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        dayLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dayLabel1.setText("End Day ");

        monthLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        monthLabel1.setText("End Month ");

        yearLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        yearLabel1.setText("End Year ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sprintTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(yearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(errorMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(yearInput, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(monthLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(monthInput, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dayInput, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yearLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dayLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yearInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dayInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(getSprintGraphBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(sprintTitle)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dayLabel)
                            .addComponent(dayInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(monthInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthLabel))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yearLabel)
                            .addComponent(yearInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(monthInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(21, 21, 21)
                            .addComponent(yearInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(dayLabel1)
                                .addComponent(dayInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(monthLabel1)
                            .addGap(21, 21, 21)
                            .addComponent(yearLabel1))))
                .addGap(18, 18, 18)
                .addComponent(errorMsg, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getSprintGraphBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * handles user input, makes sure the date is valid and displays an error message if not
     */
    private void getSprintGraphBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getSprintGraphBtnActionPerformed
        
        String day = dayInput.getText();
        String month = monthInput.getText();
        String year = yearInput.getText();
        String endDay = dayInput1.getText();
        String endMonth = monthInput1.getText();
        String endYear = yearInput1.getText();
        
        try {
                // not valid month or year 
                if ((Integer.parseInt(month) < 1 || Integer.parseInt(month) > 12) || (Integer.parseInt(year) < 0) ||
                    (Integer.parseInt(endMonth) < 1 || Integer.parseInt(endMonth) > 12) || (Integer.parseInt(endYear) < 0)
                        ) {
                    errorMsg.setText("Please enter a valid date.");
                } else {
                    // check day 
                    YearMonth date = YearMonth.of(Integer.parseInt(year), Integer.parseInt(month));
                    YearMonth otherDate = YearMonth.of(Integer.parseInt(endYear), Integer.parseInt(endMonth));
                    int daysInMonth = date.lengthOfMonth();
                    int daysInOtherMonth = otherDate.lengthOfMonth();
                    
                    if ((Integer.parseInt(day) >= 1 && Integer.parseInt(day) <= daysInMonth) &&
                           (Integer.parseInt(endDay) >= 1 && Integer.parseInt(endDay) <= daysInOtherMonth)){
                        dispose();
                        
                        if (Integer.parseInt(month) > 0 && Integer.parseInt(month) <= 9) {
                            if (month.charAt(0) != '0') {
                                month = "0" + month;
                            }
                        }
                        if (Integer.parseInt(endMonth) > 0 && Integer.parseInt(endMonth) <= 9) {
                            if (endMonth.charAt(0) != '0') {
                                endMonth = "0" + endMonth;
                            }
                        }
                        bugReportGraph screen = new bugReportGraph((year + "-" + month + "-" + day), (endYear + "-" + endMonth + "-" + endDay));
                        screen.setVisible(true);
                    } else {
                        errorMsg.setText("Please enter a valid date.");
                    }
                }
        } catch (NumberFormatException e) {
            errorMsg.setText("Please enter a valid date.");
        }
    }//GEN-LAST:event_getSprintGraphBtnActionPerformed

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
            java.util.logging.Logger.getLogger(sprintDateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sprintDateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sprintDateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sprintDateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sprintDateForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dayInput;
    private javax.swing.JTextField dayInput1;
    private javax.swing.JLabel dayLabel;
    private javax.swing.JLabel dayLabel1;
    private javax.swing.JLabel errorMsg;
    private javax.swing.JButton getSprintGraphBtn;
    private javax.swing.JTextField monthInput;
    private javax.swing.JTextField monthInput1;
    private javax.swing.JLabel monthLabel;
    private javax.swing.JLabel monthLabel1;
    private javax.swing.JLabel sprintTitle;
    private javax.swing.JTextField yearInput;
    private javax.swing.JTextField yearInput1;
    private javax.swing.JLabel yearLabel;
    private javax.swing.JLabel yearLabel1;
    // End of variables declaration//GEN-END:variables
}