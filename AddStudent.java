import javax.swing.*;
import java.sql.*;

public class AddStudent extends JFrame {
    public AddStudent() {
        setTitle("Add Student");
        setSize(300, 250);
        setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        JLabel rollLabel = new JLabel("Roll No:");

        JTextField nameField = new JTextField();
        JTextField rollField = new JTextField();

        JButton addBtn = new JButton("Add");

        nameLabel.setBounds(30, 40, 80, 25);
        rollLabel.setBounds(30, 80, 80, 25);
        nameField.setBounds(120, 40, 130, 25);
        rollField.setBounds(120, 80, 130, 25);
        addBtn.setBounds(90, 130, 100, 30);

        add(nameLabel);
        add(rollLabel);
        add(nameField);
        add(rollField);
        add(addBtn);

        addBtn.addActionListener(e -> {
            try {
                Connection con = DBConnection.getConnection();
                String sql = "INSERT INTO students(name, roll_no) VALUES (?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, nameField.getText());
                ps.setString(2, rollField.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Student Added");
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        setVisible(true);
    }
}
