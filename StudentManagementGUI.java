import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class StudentManagementGUI extends JFrame implements ActionListener {

    JTextField txtId, txtName;
    JTextArea area;

    JButton add, view, delete;

    ArrayList<Student> students = new ArrayList<>();

    StudentManagementGUI() {

        setTitle("Student Management System");
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("ID");
        l1.setBounds(30, 30, 100, 30);
        add(l1);

        txtId = new JTextField();
        txtId.setBounds(120, 30, 150, 30);
        add(txtId);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(30, 80, 100, 30);
        add(l2);

        txtName = new JTextField();
        txtName.setBounds(120, 80, 150, 30);
        add(txtName);

        add = new JButton("Add");
        add.setBounds(30, 140, 80, 30);
        add(add);

        view = new JButton("View");
        view.setBounds(130, 140, 80, 30);
        add(view);

        delete = new JButton("Delete");
        delete.setBounds(230, 140, 90, 30);
        add(delete);

        area = new JTextArea();
        area.setBounds(30, 200, 300, 120);
        add(area);

        add.addActionListener(this);
        view.addActionListener(this);
        delete.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        
        if (e.getSource() == add) {

            int id = Integer.parseInt(txtId.getText());
            String name = txtName.getText();

            students.add(new Student(id, name));

            JOptionPane.showMessageDialog(this, "Student Added");

            txtId.setText("");
            txtName.setText("");
        }

        
        if (e.getSource() == view) {

            area.setText("");

            for (Student s : students) {
                area.append("ID: " + s.id + "  Name: " + s.name + "\n");
            }
        }

       
        if (e.getSource() == delete) {

            int id = Integer.parseInt(txtId.getText());

            for (Student s : students) {

                if (s.id == id) {
                    students.remove(s);
                    JOptionPane.showMessageDialog(this, "Student Deleted");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

        new StudentManagementGUI();
    }
}
