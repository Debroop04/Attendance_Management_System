import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;

public class MarkAttendance extends JFrame {
    public MarkAttendance() {
        setTitle("Mark Attendance");
        setSize(300, 250);
        setLayout(null);

        JLabel idLabel = new JLabel("Student ID:");
        JLabel statusLabel = new JLabel("Status:");

        JTextField idField = new JTextField();
        JComboBox<String> statusBox = new JComboBox<>(new String[]{"Present", "Absent"});
        JButton markBtn = new JButton("Mark");

        idLabel.setBounds(30, 40, 80, 25);
        statusLabel.setBounds(30, 80, 80, 25);
        idField.setBounds(120, 40, 130, 25);
        statusBox.setBounds(120, 80, 130, 25);
        markBtn.setBounds(90, 130, 100, 30);

        add(idLabel);
        add(statusLabel);
        add(idField);
        add(statusBox);
        add(markBtn);

        markBtn.addActionListener(e -> {
            try {
                Connection con = DBConnection.getConnection();
                String sql = "INSERT INTO attendance(student_id, date, status) VALUES (?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(idField.getText()));
                ps.setDate(2, Date.valueOf(LocalDate.now()));
                ps.setString(3, statusBox.getSelectedItem().toString());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Attendance Marked");
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        setVisible(true);
    }
}
