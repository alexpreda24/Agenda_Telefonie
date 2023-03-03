import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdaugaContact extends JFrame{

    private JPanel panelMain;
    private JButton buttonAdaugare;
    private JButton buttonStergere;
    private JList Lista;

    private JRadioButton nrFix = new JRadioButton("numar fix");
    private JRadioButton nrMobil = new JRadioButton("numar mobil");

    private Frame frame;

    private Agenda agenda;

    public AdaugaContact(Agenda x){

        this.agenda = x;
    }

    public void setFrame(Frame f){
        this.frame = f;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lista perversa");
        JList list = new JList();
        JButton buttonAdaugare = new JButton("Adauga Contact");
        JButton buttonStergere = new JButton("Sterge Contact");
        JButton buttonModificare = new JButton("Modifica Contact");
        JRadioButton nrFix = new JRadioButton("numar fix");
        JRadioButton nrMobil = new JRadioButton("numar mobil");
        JLabel label = new JLabel("Lista de contacte");
        DefaultListModel model = new DefaultListModel();
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        buttonAdaugare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   String x = JOptionPane.showInputDialog("Introduceti numele");
                   String y = JOptionPane.showInputDialog("Introduceti prenumele");
                     String z = JOptionPane.showInputDialog("Introduceti numarul");

            }
        });
        buttonStergere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    int pozitie = list.getSelectedIndex();
                    if(pozitie >= 0) {

//                        label.setText(model. + " contacte");
                    }
            }
        });
        buttonModificare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pozitie = list.getSelectedIndex();
                if(pozitie >= 0) {
                    String x = JOptionPane.showInputDialog("Introduceti numele");
                }
            }
        });
        model.addElement("Popescu Ion");
        model.addElement("Ionescu Vasile");
        model.addElement("Vasilescu Ion");

        list.setModel(model);
        frame.add(nrFix);
        frame.add(nrMobil);
        frame.add(list);
        frame.add(buttonAdaugare);
        frame.add(buttonStergere);
        frame.add(buttonModificare);
        frame.add(label);
        frame.setVisible(true);
        label.setText(model.size() + " contacte");
    }


}
