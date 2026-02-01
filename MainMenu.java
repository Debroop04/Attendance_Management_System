import javax.swing.*;
import java.awt.event.*;

public class MainMenu extends JFrame {
    public MainMenu() {
        setTitle("Attendance Management System");
        setSize(300, 300);
        setLayout(null);

        JButton addStudent = new JButton("Add Student");
        JButton markAttendance = new JButton("Mark Attendance");
        JButton viewAttendance = new JButton("View Attendance");

        addStudent.setBounds(50, 40, 200, 30);
        markAttendance.setBounds(50, 90, 200, 30);
        viewAttendance.setBounds(50, 140, 200, 30);

        add(addStudent);
        add(markAttendance);
        add(viewAttendance);

        addStudent.addActionListener(e -> new AddStudent());
        markAttendance.addActionListener(e -> new MarkAttendance());
        viewAttendance.addActionListener(e -> new ViewAttendance());

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}
