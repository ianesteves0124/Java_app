package com.noob.crudapp;

import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DlgEditStudent extends javax.swing.JDialog {
    
    
    

    public DlgEditStudent(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Connect();
        Load_crs();
    }
    
    Connection conn;
    PreparedStatement ps;
    ResultSet res;
    
    public void Connect(){
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Java_DB","postgres","stinggreen");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(add_Student.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(add_Student.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void Load_crs(){
        try {
            ps = conn.prepareStatement("SELECT course_desc FROM tbl_course");
            res = ps.executeQuery();
            edit_scourse.removeAllItems();
            
            while(res.next()){
                edit_scourse.addItem(res.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(add_Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setStudentData(String number, String name, String course) {
        edit_sno.setText(number);
        edit_sname.setText(name);
        edit_scourse.setSelectedItem(course);
    }
    
     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        edit_cancelbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        edit_sno = new javax.swing.JTextField();
        edit_sname = new javax.swing.JTextField();
        edit_scourse = new javax.swing.JComboBox<>();
        edit_savebtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        edit_cancelbtn.setText("Cancel");
        edit_cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_cancelbtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("EDIT STUDENT DATA");

        jLabel2.setText("Student No.");

        jLabel3.setText("Student Name:");

        jLabel4.setText("Course:");

        edit_sno.setEditable(false);

        edit_scourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        edit_savebtn.setText("Save");
        edit_savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_savebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edit_sno)
                            .addComponent(edit_sname)
                            .addComponent(edit_scourse, 0, 212, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(edit_savebtn)
                                .addGap(18, 18, 18)
                                .addComponent(edit_cancelbtn)))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(edit_sno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(edit_sname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(edit_scourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edit_savebtn)
                    .addComponent(edit_cancelbtn))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edit_cancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_cancelbtnActionPerformed
        dispose();
    }//GEN-LAST:event_edit_cancelbtnActionPerformed

    private void edit_savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_savebtnActionPerformed
        
        try {
            String sNo = edit_sno.getText();
            String sName = edit_sname.getText();
            String sCourse = (String) edit_scourse.getSelectedItem();
            
            ps = conn.prepareStatement("UPDATE public.tbl_student SET student_name='"+sName+"', student_course='"+sCourse+"' WHERE student_id = '"+sNo+"'");
            
            if(ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(this, "Update Successfully!");
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this, "Invalid Details!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DlgEditStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_edit_savebtnActionPerformed

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
            java.util.logging.Logger.getLogger(DlgEditStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgEditStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgEditStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgEditStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DlgEditStudent dialog = new DlgEditStudent(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton edit_cancelbtn;
    private javax.swing.JButton edit_savebtn;
    private javax.swing.JComboBox<String> edit_scourse;
    private javax.swing.JTextField edit_sname;
    private javax.swing.JTextField edit_sno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
