package com.usha.feereport.accountant;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountantDao {
    public static Connection getCon() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/feereort", "root", "1234");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static boolean validate(String name, String password) {
        boolean status = false;
        try {
            Connection con = getCon();
            PreparedStatement ps = con.prepareStatement("select * from feereport_accountant where name=? and password=?");
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int save(Accountant a) {
        int status = 0;
        try {
            Connection con = getCon();
            PreparedStatement ps = con.prepareStatement("insert into feereport_accountant(name,password,email,contactno) values(?,?,?,?)");
            ps.setString(1, a.getName());
            ps.setString(2, a.getPassword());
            ps.setString(3, a.getEmail());
            ps.setString(4, a.getContactno());
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static List<Accountant> view() {
        List<Accountant> list = new ArrayList<>();
        try {
            Connection con = getCon();
            PreparedStatement ps = con.prepareStatement("select * from feereport_accountant");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Accountant accountant = new Accountant();
                accountant.setId(rs.getInt(1));
                accountant.setName(rs.getString(2));
                accountant.setPassword(rs.getString(3));
                accountant.setEmail(rs.getString(4));
                accountant.setContactno(rs.getString(5));
                list.add(accountant);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
