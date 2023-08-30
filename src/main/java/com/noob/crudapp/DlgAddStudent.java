package com.noob.crudapp;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.sql.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DlgAddStudent extends javax.swing.JDialog {

    Connection conn;
    PreparedStatement ps;
    ResultSet res;
    String path2 = null;
    
    public DlgAddStudent(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Connect();
        Load_crs();
    }
    
    public void Connect(){
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Java_DB","postgres","stinggreen");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DlgAddStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DlgAddStudent.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void Load_crs(){
        try {
            ps = conn.prepareStatement("SELECT course_desc FROM tbl_course");
            res = ps.executeQuery();
            course_dsc.removeAllItems();
            
            while(res.next()){
                course_dsc.addItem(res.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DlgAddStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exit_button = new javax.swing.JButton();
        course_dsc = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        student_name = new javax.swing.JTextField();
        add_button = new javax.swing.JButton();
        Addupload_photo = new javax.swing.JButton();
        lblPhoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        exit_button.setText("Cancel");
        exit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_buttonActionPerformed(evt);
            }
        });

        course_dsc.setAutoscrolls(true);
        course_dsc.setBorder(null);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("ADD NEW STUDENT");

        jLabel2.setText("Student Name:");

        jLabel3.setText("Course:");

        add_button.setText("Add");
        add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_buttonActionPerformed(evt);
            }
        });

        Addupload_photo.setText("Upload Photo");
        Addupload_photo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Addupload_photoActionPerformed(evt);
            }
        });

        lblPhoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(34, 34, 34))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(student_name, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(course_dsc, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)))
                        .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(38, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(add_button)
                        .addGap(18, 18, 18)
                        .addComponent(exit_button)
                        .addGap(91, 91, 91)
                        .addComponent(Addupload_photo)
                        .addGap(52, 52, 52))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(student_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(course_dsc))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Addupload_photo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(add_button)
                        .addComponent(exit_button)))
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_buttonActionPerformed
        this.dispose();
    }//GEN-LAST:event_exit_buttonActionPerformed

    private void add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_buttonActionPerformed
        String name = student_name.getText();
        String selectedCourse = (String) course_dsc.getSelectedItem();
        
            try {
                conn.setAutoCommit(false); // Disable auto-commit
                ps = conn.prepareStatement("INSERT INTO tbl_student (student_name, student_course,student_picture) VALUES (?,?,?) ");
                ps.setString(1, name);
                ps.setString(2, selectedCourse);
                InputStream inpt_str = new FileInputStream(new File(path2));
                ps.setBinaryStream(3,inpt_str);

                if(ps.executeUpdate() == 1){
                    conn.commit(); // Commit the transaction
                    JOptionPane.showMessageDialog(this,"Student Record Added");
                    student_name.setText("");
                    lblPhoto.setIcon(null);
                }else{
                    JOptionPane.showMessageDialog(this,"Invalid Details");
                }
            } catch (SQLException ex) {
                Logger.getLogger(DlgAddStudent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
            Logger.getLogger(DlgAddStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_add_buttonActionPerformed

    private void Addupload_photoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Addupload_photoActionPerformed
        
            JFileChooser choose = new JFileChooser();
            choose.showOpenDialog(null);
            File fl = choose.getSelectedFile();
            String path = fl.getAbsolutePath();
            
        try {
            BufferedImage bimg = ImageIO.read(new File(path));
            Image img = bimg.getScaledInstance(145, 123, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            lblPhoto.setIcon(icon);
            path2 = path;
        } catch (IOException ex) {
            Logger.getLogger(DlgAddStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Addupload_photoActionPerformed

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
                if ("Mac OS X".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DlgAddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgAddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgAddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgAddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgAddStudent dialog = new DlgAddStudent(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addupload_photo;
    private javax.swing.JButton add_button;
    private javax.swing.JComboBox<String> course_dsc;
    private javax.swing.JButton exit_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JTextField student_name;
    // End of variables declaration//GEN-END:variables
}
