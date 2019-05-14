package com.usha.feereport.student;

import com.usha.feereport.accountant.AccountantDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public static int save(Student s) {
        int status = 0;
        try {
            Connection con = AccountantDao.getCon();
            PreparedStatement ps = con.prepareStatement("insert into feereport_student(name,email,course,fee,paid,due,address,city,state,country,contactno) values(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getCourse());
            ps.setInt(4, s.getFee());
            ps.setInt(5, s.getPaid());
            ps.setInt(6, s.getDue());
            ps.setString(7, s.getAddress());
            ps.setString(8, s.getCity());
            ps.setString(9, s.getState());
            ps.setString(10, s.getCountry());
            ps.setString(11, s.getContactno());
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int update(Student s) {
        int status = 0;
        try {
            Connection con = AccountantDao.getCon();
            PreparedStatement ps = con.prepareStatement("update feereport_student set name=?,email=?,course=?,fee=?,paid=?,due=?,address=?,city=?,state=?,country=?,contactno=? where rollno=?");
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getCourse());
            ps.setInt(4, s.getFee());
            ps.setInt(5, s.getPaid());
            ps.setInt(6, s.getDue());
            ps.setString(7, s.getAddress());
            ps.setString(8, s.getCity());
            ps.setString(9, s.getState());
            ps.setString(10, s.getCountry());
            ps.setString(11, s.getContactno());
            ps.setInt(12, s.getRollno());
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static List<Student> view() {
        List<Student> studentList = new ArrayList<Student>();
        try {
            Connection con = AccountantDao.getCon();
            PreparedStatement ps = con.prepareStatement("select * from feereport_student");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = constructStudent(rs);
                studentList.add(student);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return studentList;
    }

    public static Student getStudentByRollno(int rollno) {
        Student student = new Student();
        try {
            Connection con = AccountantDao.getCon();
            PreparedStatement ps = con.prepareStatement("select * from feereport_student where rollno=?");
            ps.setInt(1, rollno);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student = constructStudent(rs);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return student;
    }

    public static List<Student> due() {
        List<Student> studentList = new ArrayList<Student>();
        try {
            Connection con = AccountantDao.getCon();
            PreparedStatement ps = con.prepareStatement("select * from feereport_student where due>0");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = constructStudent(rs);
                studentList.add(student);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return studentList;
    }

    public static Student constructStudent(ResultSet rs) throws Exception {
        Student student = new Student();
        student.setRollno(rs.getInt("rollno"));
        student.setName(rs.getString("name"));
        student.setEmail(rs.getString("email"));
        student.setCourse(rs.getString("course"));
        student.setFee(rs.getInt("fee"));
        student.setPaid(rs.getInt("paid"));
        student.setDue(rs.getInt("due"));
        student.setAddress(rs.getString("address"));
        student.setCity(rs.getString("city"));
        student.setState(rs.getString("state"));
        student.setCountry(rs.getString("country"));
        student.setContactno(rs.getString("contactno"));
        return student;
    }
}
