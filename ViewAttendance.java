import javax.swing.*;
import java.sql.*;

public class ViewAttendance extends JFrame {
    public ViewAttendance() {
        setTitle("Attendance Records");
        setSize(500, 300);

        JTextArea area = new JTextArea();
        JScrollPane scroll = new JScrollPane(area);
        add(scroll);

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                "SELECT s.name, a.date, a.status FROM students s JOIN attendance a ON s.student_id=a.student_id"
            );

            while (rs.next()) {
                area.append(
                    rs.getString("name") + " | " +
                    rs.getDate("date") + " | " +
                    rs.getString("status") + "\n"
                );
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }
}
