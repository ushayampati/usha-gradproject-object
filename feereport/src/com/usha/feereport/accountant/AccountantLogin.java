package com.usha.feereport.accountant;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountantLogin extends JFrame {
    static AccountantLogin frame;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new AccountantLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the Accountant Login frame.
     */
    public AccountantLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        JLabel lblAccountantLogin = new JLabel("Accountant Login");
        lblAccountantLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblAccountantLogin.setForeground(Color.DARK_GRAY);
        JLabel lblName = new JLabel("Name:");
        textField = new JTextField();
        textField.setColumns(10);
        JLabel lblPassword = new JLabel("Password:");
        passwordField = new JPasswordField();
        JButton btnLogin = new JButton("login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String name = textField.getText();
                String password = String.valueOf(passwordField.getPassword());
                boolean status = AccountantDao.validate(name, password);
                if (status) {
                    AccountantSection.main(new String[]{});
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(AccountantLogin.this, "Sorry, username or password error!", "Login error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton btnBack = new JButton("back");
        GroupLayout groupLayout = new GroupLayout(contentPane);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup().addGap(28)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblPassword)
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addComponent(lblName)
                                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                                        .addGroup(groupLayout.createSequentialGroup().addGap(76)
                                                                                .addComponent(lblAccountantLogin))
                                                                        .addGroup(groupLayout.createSequentialGroup().addGap(54)
                                                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                                                                                        .addComponent(passwordField)
                                                                                        .addComponent(textField, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)))))))
                                        .addGroup(groupLayout.createSequentialGroup().addGap(158)
                                                .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE).addGap(52)
                                                .addComponent(btnBack)))
                                .addContainerGap(78, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblAccountantLogin).addGap(18)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblName)
                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(18)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblPassword)
                                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnBack))
                                .addContainerGap(96, Short.MAX_VALUE))
        );
        contentPane.setLayout(groupLayout);
    }
}
