package com.usha.feereport;

import com.usha.feereport.accountant.AccountantLogin;
import com.usha.feereport.admin.AdminLogin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FeeReport extends JFrame {
    static FeeReport frame;
    private JPanel contentPane;

    // Launch the Fee Report application.

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new FeeReport();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Creates the Fee Report frame.

    public FeeReport() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setForeground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        JLabel lblFeeReport = new JLabel("Fee Report");
        lblFeeReport.setFont(new Font("Tahoma", Font.PLAIN, 20));
        JButton btnAdminLogin = new JButton("Admin Login");
        btnAdminLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                AdminLogin.main(new String[]{});
                frame.dispose();
            }
        });
        JButton btnAccountantLogin = new JButton("Accountant Login");
        btnAccountantLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                AccountantLogin.main(new String[]{});
                frame.dispose();
            }
        });
        GroupLayout groupLayout = new GroupLayout(contentPane);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup().addGap(143)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(btnAccountantLogin, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                                                .addComponent(btnAdminLogin, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                                .addComponent(lblFeeReport)))
                                .addContainerGap(210, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(lblFeeReport).addGap(42)
                                .addComponent(btnAdminLogin, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE).addGap(30)
                                .addComponent(btnAccountantLogin, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(91, Short.MAX_VALUE))
        );
        contentPane.setLayout(groupLayout);
    }
}
