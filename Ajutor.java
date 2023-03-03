import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Ajutor extends JFrame implements ActionListener {
    private Container c;
    private JLabel label1;
    private JLabel label2;

    private JComboBox combo1;

    private JButton OK;

    private JPanel panel1;


    public Ajutor() {
        setTitle("Ajutor");
        setBounds(300,90,350, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        label1 = new JLabel("E totul in regula?");
        label1.setFont(new Font("Arial", Font.PLAIN, 12));
        label1.setSize(100,20);
        label1.setLocation(40,10);
        c.add(label1);

        label2 = new JLabel("Afla mai multe despre: ");
        label2.setFont(new Font("Arial", Font.PLAIN, 12));
        label2.setSize(200,30);
        label2.setLocation(40,50);
        c.add(label2);

        OK = new JButton("OK");
        OK.setFont(new Font("Arial", Font.BOLD, 10));
        OK.setSize(50,20);
        OK.setLocation(200,10);
        OK.addActionListener(this);
        c.add(OK);

        combo1 = new JComboBox(new String [] {"Nume", "Prenume", "Telefon", "Data Nasterii", "Personalizare"});
        combo1.setFont(new Font("Arial", Font.PLAIN, 10));
        combo1.setSize(100,20);
        combo1.setLocation(200,50);
        combo1.addActionListener(this);
        c.add(combo1);

//        initComponents();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == OK) {
            this.dispose();
            try{
            new Frame();
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
        if (e.getSource() == combo1) {
            int x = combo1.getSelectedIndex();
            switch (x) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Numele trebuie sa fie din minim 3 caractere");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Prenumele trebuie sa fie din minim 3 caractere");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Numarul de telefon trebuie sa fie din 10 cifre \n" +
                            "si sa inceapa cu 07 daca este mobil sau cu 02/03 daca este fix");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Data nasterii trebuie sa fie in formatul dd/mm/yyyy");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Pentru a personaliza contactul trebuie sa introduceti \n" +
                            "numele si prenumele contactului");
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception{

        new Ajutor();
    }

}
