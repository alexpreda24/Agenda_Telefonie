import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

public class CreareUtilizator extends JFrame implements ActionListener {
    public static LinkedList<User> users = new LinkedList<User>();
    private JLabel user;
    private JLabel pass;
    private JButton button1;

    private JLabel title;

    private JPanel panelMain;
    private JPanel panelLogin;
    private JPanel panelRegister;
    private ImageIcon registerImage;
    private JTextField text1;
    private JPasswordField text2;
    private Container c;

    public CreareUtilizator() {
        setTitle("Creare utilizator");
        c = getContentPane();
        c.setLayout(null);

        setBounds(300,40,400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        init();
        setVisible(true);
    }

    public void init() {
        title = new JLabel("Registration Page");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setSize(300, 30);
        title.setLocation(100, 30);
        c.add(title);

        user = new JLabel("Username: ");
        user.setFont(new Font("Arial", Font.PLAIN, 12));
        user.setSize(100, 20);
        user.setLocation(20, 100);
        c.add(user);

        text1 = new JTextField();
        text1.setFont(new Font("Arial", Font.PLAIN, 12));
        text1.setSize(200, 20);
        text1.setLocation(120, 100);
        c.add(text1);

        pass = new JLabel("Password: ");
        pass.setFont(new Font("Arial", Font.PLAIN, 12));
        pass.setSize(100, 20);
        pass.setLocation(20, 150);
        c.add(pass);

        text2 = new JPasswordField();
        text2.setFont(new Font("Arial", Font.PLAIN, 12));
        text2.setSize(200, 20);
        text2.setLocation(120, 150);
        c.add(text2);

        ImageIcon image = new ImageIcon("src\\register.png");
        Image img = image.getImage().getScaledInstance(110, 80, Image.SCALE_SMOOTH);
        registerImage = new ImageIcon(img);

        button1 = new JButton("OK");
        button1.setFont(new Font("Arial", Font.PLAIN, 12));
        button1.setSize(110, 20);
        button1.setLocation(160, 200);
        button1.addActionListener(this);
        button1.setIcon(registerImage);
        c.add(button1);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == button1) {
            String user = text1.getText();
            char[] pass = text2.getPassword();
            String passString = new String(pass);
            for(User u : CreareUtilizator.users) {
                if(u.getUsername().equals(user)) {
                    JOptionPane.showMessageDialog(null, "Utilizatorul cu numele " +
                            user + " exista deja!","Eroare", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if(user.equals("") || passString.equals("")) {
                JOptionPane.showMessageDialog(null, "Nu ati introdus toate datele!","Eroare", JOptionPane.ERROR_MESSAGE);
                return;
            }
            CreareUtilizator.users.add(new User(user, passString));

            JOptionPane.showMessageDialog(null, "Utilizatorul cu numele " + user + " a fost creat cu succes!");
            try {
                new Frame();
                setVisible(false);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new CreareUtilizator();
    }
}
