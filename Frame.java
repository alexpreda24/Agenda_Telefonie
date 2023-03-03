import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Frame extends JFrame implements ActionListener {

    private JButton buttonLogin;
    private JButton buttonRegister;
    private JLabel userLogin;
    private JLabel passLogin;
    private JTextField userField;
    private JPasswordField passField;
    private JLabel title;
    private Container c;
    private ImageIcon loginImage;

    public Frame() throws IOException {
        setTitle("Login");
        setBounds(300, 90, 400, 280);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        ImageIcon image = new ImageIcon(ImageIO.read(new File("src\\lbut.jpg")));
        Image img = image.getImage().getScaledInstance(110, 40, Image.SCALE_SMOOTH);
        loginImage = new ImageIcon(img);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Login Page");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setSize(300, 40);
        title.setLocation(130, 30);
        c.add(title);

        userLogin = new JLabel("Username: ");
        userLogin.setFont(new Font("Arial", Font.PLAIN, 12));
        userLogin.setSize(100, 20);
        userLogin.setLocation(20, 100);
        c.add(userLogin);

        userField = new JTextField();
        userField.setFont(new Font("Arial", Font.PLAIN, 12));
        userField.setSize(200, 20);
        userField.setLocation(120, 100);
        c.add(userField);

        passLogin = new JLabel("Password: ");
        passLogin.setFont(new Font("Arial", Font.PLAIN, 12));
        passLogin.setSize(100, 20);
        passLogin.setLocation(20, 150);
        c.add(passLogin);

        passField = new JPasswordField();
        passField.setFont(new Font("Arial", Font.PLAIN, 12));
        passField.setSize(200, 20);
        passField.setLocation(120, 150);
        c.add(passField);

        buttonLogin = new JButton("Login");

        buttonLogin.setIcon(loginImage);
        buttonLogin.setFont(new Font("Arial", Font.PLAIN, 12));
        buttonLogin.setSize(80, 20);
        buttonLogin.setLocation(120, 200);
        buttonLogin.addActionListener(this);
        c.add(buttonLogin);

        buttonRegister = new JButton("Register");
        buttonRegister.setFont(new Font("Arial", Font.PLAIN, 12));
        buttonRegister.setSize(80, 20);
        buttonRegister.setLocation(220, 200);
        buttonRegister.addActionListener(this);
        c.add(buttonRegister);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonLogin) {
            String user = userField.getText();
            char[] pass = passField.getPassword();
            String passString = new String(pass);

            User u = new User(user, passString);
            if (CreareUtilizator.users.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No users registered! \n " +
                        "Please register first", "Error", JOptionPane.ERROR_MESSAGE);
            }
            for (User user1 : CreareUtilizator.users)
                if (user1.getParola().equals(u.getParola()) && user1.getUsername().equals(u.getUsername())) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    this.dispose();
                    Agenda a = new Agenda();
                    try {
                        new FereastraStart(a);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            JOptionPane.showMessageDialog(null, "Login failed! \n " +
                    "Please enter a valid username" +
                    " and the right password \n for it", "Error", JOptionPane.ERROR_MESSAGE);


        }

        if (e.getSource() == buttonRegister) {
            this.dispose();
            CreareUtilizator c = new CreareUtilizator();
            c.setVisible(true);
        }
    }

    public static void main(String[] args) {
        try {
            new Frame();
        } catch (IOException e) {
            System.out.println("Nu s-a gasit imaginea");
            e.printStackTrace();
        }
    }
}
