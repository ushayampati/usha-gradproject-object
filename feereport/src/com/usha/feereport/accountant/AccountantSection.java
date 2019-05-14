package com.usha.feereport.accountant;

import com.usha.feereport.*;
import com.usha.feereport.student.AddStudent;
import com.usha.feereport.student.EditStudent;
import com.usha.feereport.student.StudentFeeDue;
import com.usha.feereport.student.ViewStudent;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountantSection extends JFrame {
    static AccountantSection frame;
    private JPanel contentPane;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new AccountantSection();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    // Create the Accountant Section frame.

    public AccountantSection() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 423);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JButton btnNewButton = new JButton("Add Student");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddStudent.main(new String[]{});
                frame.disable();
            }
        });

        JLabel lblAccountantSection = new JLabel("Accountant Section");
        lblAccountantSection.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblAccountantSection.setForeground(Color.DARK_GRAY);

        JButton btnViewStudent = new JButton("View Student");
        btnViewStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewStudent.main(new String[]{});
            }
        });

        JButton btnEditStudent = new JButton("Edit Student");
        btnEditStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                EditStudent.main(new String[]{});
                frame.dispose();
            }
        });

        JButton btnDueFee = new JButton("Due Fee");
        btnDueFee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StudentFeeDue.main(new String[]{});
            }
        });

        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                FeeReport.main(new String[]{});
                frame.dispose();
            }
        });
        GroupLayout groupLayout = new GroupLayout(contentPane);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup().addGap(136)
                                                .addComponent(lblAccountantSection))
                                        .addGroup(groupLayout.createSequentialGroup().addGap(52)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addComponent(btnEditStudent, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnDueFee, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE).addGap(53)
                                                                .addComponent(btnViewStudent, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(144)
                                                .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(53, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup().addGap(7)
                                .addComponent(lblAccountantSection).addGap(25)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnViewStudent, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)).addGap(35)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnEditStudent, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDueFee, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)).addGap(36)
                                .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(138, Short.MAX_VALUE))
        );
        contentPane.setLayout(groupLayout);
    }
}
