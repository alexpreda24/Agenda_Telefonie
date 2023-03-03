import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class FereastraStart extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu menuFisier;
    private JMenu menuEditare;
    private JMenu menuAjutor;
    private JMenuItem itemIesire;
    private JMenuItem itemAdaugaUsers;
    private JMenuItem itemAjutor;
    private JMenuItem itemDespre;
    private JButton butonAdauga;
    private JButton butonSterge;
    private JButton butonediteaza;
    private JTable list;
    private JLabel title;
    private DefaultTableModel model;
    private Container c;

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JComboBox comboFiltrare1;
    private JButton butonFiltrare;
    private JButton butonOrdoneaza;
    private JLabel label6;
    private JComboBox comboOrdonare;
    private JLabel label7;
    private JComboBox comboOrdonare1;
    private Agenda agenda;
    private JLabel labelReclama;
    private JMenuItem itemFisier;

    ImageIcon superbet;
    ImageIcon casa_pariurilor;
    ImageIcon betfair;

    private JFileChooser fileChooser;


    private void reclama(ImageIcon imageIcon) {
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(750, 90, java.awt.Image.SCALE_SMOOTH);
        labelReclama.setIcon(new ImageIcon(newimg));
    }
    public FereastraStart(Agenda agenda) throws IOException{

        superbet = new ImageIcon(ImageIO.read(new File("src\\superbet.png")));
        casa_pariurilor = new ImageIcon(ImageIO.read(new File("src\\casa_pariurilor.jpg")));
        betfair = new ImageIcon(ImageIO.read(new File("src\\Betfair.png")));

        TimerTask reclamasuperbet = new TimerTask() {
            @Override
            public void run() {
                reclama(superbet);
            }
        };

        TimerTask reclamacasa_pariurilor = new TimerTask() {
            @Override
            public void run() {
                reclama(casa_pariurilor);
            }
        };

        TimerTask reclamabetfair = new TimerTask() {
            @Override
            public void run() {
                reclama(betfair);
            }
        };

        Timer timer = new Timer();


        timer.schedule(reclamasuperbet, 0, 15000);
        timer.schedule(reclamacasa_pariurilor, 5000, 15000);
        timer.schedule(reclamabetfair, 10000, 15000);

        this.agenda = agenda;
        setTitle("Agenda Telefonica");
        setBounds(300,0,900, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        c = getContentPane();
        c.setLayout(null);

        labelReclama = new JLabel();
        labelReclama.setSize(800, 100);
        labelReclama.setLocation(50, 600);
        c.add(labelReclama);

        title = new JLabel("Agenda Telefonica");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(250, 30);
        c.add(title);

        menuBar = new JMenuBar();

        menuFisier = new JMenu("Fisier");
        menuAjutor = new JMenu("Ajutor");

        itemIesire = new JMenuItem("Iesire");
        itemFisier = new JMenuItem("Fisier");
        itemAjutor = new JMenuItem("Ajutor");
        itemDespre = new JMenuItem("Despre");
        itemAdaugaUsers = new JMenuItem("Adauga User");
        itemIesire.addActionListener(this);
        itemFisier.addActionListener(this);

        menuFisier.add(itemIesire);
        menuFisier.add(itemFisier);
        menuAjutor.add(itemAjutor);
        menuAjutor.add(itemDespre);

        menuBar.add(menuFisier);
        menuBar.add(menuAjutor);

        setJMenuBar(menuBar);
        label1 = new JLabel("Adauga contact nou");
        label1.setFont(new Font("Arial", Font.PLAIN, 12));

        label2 = new JLabel("Sterge contact");
        label2.setFont(new Font("Arial", Font.PLAIN, 12));

        label3 = new JLabel("Editeaza contact");
        label3.setFont(new Font("Arial", Font.PLAIN, 12));

        label4 = new JLabel("Filtrare: ");

        butonAdauga = new JButton("Adauga");
        butonAdauga.setFont(new Font("Arial", Font.PLAIN, 12));
        butonSterge = new JButton("Sterge");
        butonSterge.setFont(new Font("Arial", Font.PLAIN, 12));
        butonediteaza = new JButton("Editeaza");
        butonediteaza.setFont(new Font("Arial", Font.PLAIN, 12));

        butonAdauga.addActionListener(this);
        butonSterge.addActionListener(this);
        butonediteaza.addActionListener(this);

        butonAdauga.setSize(100, 30);
        butonSterge.setSize(100, 30);
        butonediteaza.setSize(100, 30);

        label1.setSize(140, 30);
        label2.setSize(140, 30);
        label3.setSize(140, 30);
        label4.setSize(80, 30);

        label1.setLocation(10, 80);
        butonAdauga.setLocation(150, 80);

        label2.setLocation(10, 120);
        butonSterge.setLocation(150, 120);

        label3.setLocation(10, 160);
        butonediteaza.setLocation(150, 160);

        label4.setLocation(300, 80);

        c.add(label1);
        c.add(butonAdauga);
        c.add(label2);
        c.add(butonSterge);
        c.add(label3);
        c.add(butonediteaza);
        c.add(label4);

        comboFiltrare1 = new JComboBox(new String[] {"Numar Fix", "Numar Mobil", "Luna curenta", "Ziua curenta"});
        comboFiltrare1.setSize(100, 30);
        comboFiltrare1.setLocation(400, 80);
        c.add(comboFiltrare1);

        butonFiltrare = new JButton("Filtreaza");
        butonFiltrare.setSize(120, 30);
        butonFiltrare.setLocation(710, 80);
        butonFiltrare.addActionListener(this);
        c.add(butonFiltrare);

        label6 = new JLabel("Ordoneaza dupa: ");
        label6.setSize(100, 30);
        label6.setLocation(300, 120);
        c.add(label6);

        comboOrdonare = new JComboBox(new String[] {"Nume", "Prenume", "Telefon", "Data Nasterii"});
        comboOrdonare.setSize(100, 30);
        comboOrdonare.setLocation(400, 120);
        c.add(comboOrdonare);

        label7 = new JLabel("Ordonare: ");
        label7.setSize(70, 30);
        label7.setLocation(510, 120);
        c.add(label7);

        comboOrdonare1 = new JComboBox(new String[] {"Crescator", "Descrescator"});
        comboOrdonare1.setSize(120, 30);
        comboOrdonare1.setLocation(580, 120);
        c.add(comboOrdonare1);

        butonOrdoneaza = new JButton("Ordoneaza");
        butonOrdoneaza.setSize(120, 30);
        butonOrdoneaza.setLocation(710, 120);
        butonOrdoneaza.addActionListener(this);
        c.add(butonOrdoneaza);
        list = new JTable();
        model = new DefaultTableModel();
        Object[] columnsName = new Object[4];
        columnsName[0] = "Nume";
        columnsName[1] = "Prenume";
        columnsName[2] = "Telefon";
        columnsName[3] = "DataNasterii";

        model.setColumnIdentifiers(columnsName);
        Object[] rowData = new Object[4];
        list.setModel(model);
        list.setBackground(Color.LIGHT_GRAY);
        list.setForeground(Color.black);
        Font font = new Font("", 1, 22);
        list.setFont(font);
        list.setRowHeight(30);
        JScrollPane pane = new JScrollPane(list);
        pane.setBounds(0, 200, 900, 400);
        c.add(pane);
        setVisible(true);
    }



    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == itemFisier) {
            File f = new File("C:\\Users\\alex\\IdeaProjects\\AgendaTelefonie\\");
            JFileChooser fileChooser = new JFileChooser(f, FileSystemView.getFileSystemView());
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setDialogTitle("Specify a file to save");
            int userSelection = fileChooser.showSaveDialog(this);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            }
        }

        if (e.getSource() == itemIesire) {
            System.exit(0);
        }
        if (e.getSource() == butonSterge) {
            int index = list.getSelectedRow();
            if (index != -1) {
                int x = JOptionPane.showConfirmDialog(null,
                        "Sunteti sigur ca doriti sa stergeti acest contact?",
                        "Stergere", JOptionPane.YES_NO_OPTION);
                if(x == 0) {
                    model.removeRow(index);
                    agenda.getContactList().remove(index);
                }
            }
        }
        if (e.getSource() == butonAdauga) {
            String nume = JOptionPane.showInputDialog("Intorduceti numele");
            while (nume.length() < 3 || nume.length() > 20) {
                JOptionPane.showMessageDialog(null,
                        "Numele nu este valid","Eroare", JOptionPane.ERROR_MESSAGE);
                nume = JOptionPane.showInputDialog("Introduceti va rog un nume valid");
            }
            String prenume = JOptionPane.showInputDialog("Intorduceti prenumele");
            while (prenume.length() < 3 || prenume.length() > 20) {
                JOptionPane.showMessageDialog(null,
                        "Prenumele nu este valid","Eroare", JOptionPane.ERROR_MESSAGE);
                prenume = JOptionPane.showInputDialog("Introduceti va rog un prenume valid");
            }
            String telefon = "";
            try{
            NrTel nrTel;
            boolean ok = false;
            int a = JOptionPane.showOptionDialog(null,
                    "Introduceti tipul telefonului",
                    "Tipul telefonului",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new String[]{"Mobil", "Fix"}, null);
            String tipul_telefonului = "";
            if (a == 0) {
                tipul_telefonului = "Mobil";
            } else if (a == 1) {
                tipul_telefonului = "Fix";
            }

            if (tipul_telefonului.equals("Mobil")) {
                ok = true;
                telefon = JOptionPane.showInputDialog("Intorduceti numarul de telefon");
                while (!telefon.substring(0, 2).equals("07") || telefon.length() != 10) {
                    JOptionPane.showMessageDialog(null,
                            "Numarul de telefon nu este valid","Eroare", JOptionPane.ERROR_MESSAGE);
                    telefon = JOptionPane.showInputDialog("Introduceti va rog un numar valid de telefon");
                }
                nrTel= new NrMobil(telefon.toString());
            }
            else {
                telefon = JOptionPane.showInputDialog("Intorduceti numarul de telefon");
                while ((!telefon.substring(0, 2).equals("02") && !telefon.substring(0, 2).equals("03")) || telefon.length() != 10) {
                    JOptionPane.showMessageDialog(null,
                            "Numarul de telefon nu este valid","Eroare", JOptionPane.ERROR_MESSAGE);
                    telefon = JOptionPane.showInputDialog("Introduceti va rog un numar valid de telefon");

                }
                nrTel = new NrFix(telefon.toString());
            }
            JOptionPane.showMessageDialog(null,
                    "Data trebuie sa fie in format dd/mm/yyyy");
            String zi = JOptionPane.showInputDialog("Intorduceti ziua nasterii");
            int birthDay = Integer.parseInt(zi);
            String luna = JOptionPane.showInputDialog("Intorduceti luna nasterii");
            int birthMonth = Integer.parseInt(luna);
            String an = JOptionPane.showInputDialog("Intorduceti anul nasterii");
            while(an.length() != 4){
                JOptionPane.showMessageDialog(null,
                        "Anul nasterii nu este valid","Eroare", JOptionPane.ERROR_MESSAGE);
                an = JOptionPane.showInputDialog("Intorduceti anul nasterii");
            }
            int birthYear = Integer.parseInt(an);

            StringBuilder birthDate = new StringBuilder();

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            int anCurent = Integer.parseInt(dateFormat.format(date).substring(6, 10));
            int lunacurenta = Integer.parseInt(dateFormat.format(date).substring(3, 5));
            int zicurenta = Integer.parseInt(dateFormat.format(date).substring(0, 2));

            while(birthMonth < 1 || birthMonth > 12){
                JOptionPane.showMessageDialog(null,
                        "Luna nasterii nu este valida","Eroare", JOptionPane.ERROR_MESSAGE);
                luna = JOptionPane.showInputDialog("Introduceti va rog o luna valida");
                birthMonth = Integer.parseInt(luna);
            }
            while (birthDay < 1 || birthDay > 31) {
                JOptionPane.showMessageDialog(null,
                        "Ziua nasterii nu este valida","Eroare", JOptionPane.ERROR_MESSAGE);
                zi = JOptionPane.showInputDialog("Introduceti va rog o zi valida");
                birthDay = Integer.parseInt(zi);
            }

            while (birthYear > anCurent) {
                JOptionPane.showMessageDialog(null,
                        "Anul nasterii nu este valid","Eroare", JOptionPane.ERROR_MESSAGE);
                an = JOptionPane.showInputDialog("Introduceti va rog un an valid");
                birthYear = Integer.parseInt(an);
            }
            if (birthYear == anCurent) {
                while (birthMonth > lunacurenta || birthMonth < 1 ) {
                    JOptionPane.showMessageDialog(null,
                            "Luna nasterii nu este valida","Eroare", JOptionPane.ERROR_MESSAGE);
                    luna = JOptionPane.showInputDialog("Introduceti va rog o luna valida");
                    birthMonth = Integer.parseInt(luna);
                }
                if (birthMonth == lunacurenta) {
                    while (birthDay > zicurenta || birthDay < 1 || birthDay > 31) {
                        JOptionPane.showMessageDialog(null,
                                "Ziua nasterii nu este valida","Eroare", JOptionPane.ERROR_MESSAGE);
                        zi = JOptionPane.showInputDialog("Introduceti va rog o zi valida");
                        birthDay = Integer.parseInt(zi);
                    }
                }
            }
            if(birthDay < 10){
                zi = "0" + birthDay;
            }
            birthDate.append(zi);
            birthDate.append("/");
            if(birthMonth < 10){
                luna = "0" + birthMonth;
            }
            birthDate.append(luna);
            birthDate.append("/");
            birthDate.append(an);
            String data = birthDate.toString();
            DateValidator validator = new DateValidatorUsingDateFormat("dd/MM/yyyy");
            while(!validator.isValid(data)) {
                JOptionPane.showMessageDialog(null,
                        "Data nasterii nu este valida","Eroare", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null,"Introduceti va rog o data valida");
                zi = JOptionPane.showInputDialog("Intorduceti ziua nasterii");
                birthDay = Integer.parseInt(zi);
                luna = JOptionPane.showInputDialog("Intorduceti luna nasterii");
                birthMonth = Integer.parseInt(luna);
                an = JOptionPane.showInputDialog("Intorduceti anul nasterii");
                birthYear = Integer.parseInt(an);

                 anCurent = Integer.parseInt(dateFormat.format(date).substring(6, 10));
                 lunacurenta = Integer.parseInt(dateFormat.format(date).substring(3, 5));
                 zicurenta = Integer.parseInt(dateFormat.format(date).substring(0, 2));

                while(birthMonth < 1 || birthMonth > 12){
                    JOptionPane.showMessageDialog(null,
                            "Luna nasterii nu este valida","Eroare", JOptionPane.ERROR_MESSAGE);
                    luna = JOptionPane.showInputDialog("Introduceti va rog o luna valida");
                    birthMonth = Integer.parseInt(luna);
                }
                while (birthDay < 1 || birthDay > 31) {
                    JOptionPane.showMessageDialog(null,
                            "Ziua nasterii nu este valida","Eroare", JOptionPane.ERROR_MESSAGE);
                    zi = JOptionPane.showInputDialog("Introduceti va rog o zi valida");
                    birthDay = Integer.parseInt(zi);
                }

                while (birthYear > anCurent) {
                    JOptionPane.showMessageDialog(null,
                            "Anul nasterii nu este valid","Eroare", JOptionPane.ERROR_MESSAGE);
                    an = JOptionPane.showInputDialog("Introduceti va rog un an valid");
                    birthYear = Integer.parseInt(an);
                }
                if (birthYear == anCurent) {
                    while (birthMonth > lunacurenta || birthMonth < 1 ) {
                        JOptionPane.showMessageDialog(null,
                                "Luna nasterii nu este valida","Eroare", JOptionPane.ERROR_MESSAGE);
                        luna = JOptionPane.showInputDialog("Introduceti va rog o luna valida");
                        birthMonth = Integer.parseInt(luna);
                    }
                    if (birthMonth == lunacurenta) {
                        while (birthDay > zicurenta || birthDay < 1) {
                            JOptionPane.showMessageDialog(null,
                                    "Ziua nasterii nu este valida","Eroare", JOptionPane.ERROR_MESSAGE);
                            zi = JOptionPane.showInputDialog("Introduceti va rog o zi valida");
                            birthDay = Integer.parseInt(zi);
                        }
                    }
                }
                birthDate.delete(0, birthDate.length());
                if(Integer.parseInt(zi) < 10)
                    birthDate.append("0");
                birthDate.append(zi);
                birthDate.append("/");
                if(Integer.parseInt(luna) < 10)
                    birthDate.append("0");
                birthDate.append(luna);
                birthDate.append("/");
                birthDate.append(an);
                data = birthDate.toString();
            }
                Contact c = new Contact(nume, prenume, nrTel, data, ok);
                model.addRow(new Object[]{nume, prenume, telefon, data});
                agenda.addContact(c);
            } catch (NrTelException ex) {
                JOptionPane.showMessageDialog(null,
                        "Numarul de telefon nu este valid","Eroare", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == itemAjutor) {
            new Ajutor();
        }
        if(e.getSource() == butonediteaza){
            int row = list.getSelectedRow();
            if(row != -1) {
                int col = list.getSelectedColumn();
                if(model.getColumnName(col).equals("Nume"))
                    model.setValueAt(JOptionPane.showInputDialog("Introduceti numele"), row, 0);
                if(model.getColumnName(col).equals("Prenume"))
                    model.setValueAt(JOptionPane.showInputDialog("Introduceti prenumele"), row, 1);
                if(model.getColumnName(col).equals("Telefon"))
                    model.setValueAt(JOptionPane.showInputDialog("Introduceti numarul de telefon"), row, 2);
                if(model.getColumnName(col).equals("Data nasterii"))
                    model.setValueAt(JOptionPane.showInputDialog("Introduceti data nasterii"), row, 3);
            }
        }
        if(e.getSource() == butonOrdoneaza){
            try {
                int i = 0;
                while(i < model.getRowCount()){
                    model.removeRow(i);
                }
                if(comboOrdonare.getSelectedItem().equals("Nume"))
                    agenda.setCriteriu(Criteriu.DUPA_NUME);
                else if(comboOrdonare.getSelectedItem().equals("Prenume"))
                    agenda.setCriteriu(Criteriu.DUPA_PRENUME);
                else if(comboOrdonare.getSelectedItem().equals("Data Nasterii"))
                    agenda.setCriteriu(Criteriu.DUPA_NASTERE);
                else if(comboOrdonare.getSelectedItem().equals("Telefon"))
                    agenda.setCriteriu(Criteriu.DUPA_TELEFON);
                int forma = 0;
                if(comboOrdonare1.getSelectedItem().equals("Crescator"))
                    forma = 1;
                else if(comboOrdonare1.getSelectedItem().equals("Descrescator"))
                    forma = -1;
               agenda.ordoneazaList(forma);
                for (Contact c : agenda.getContactList()) {
                    model.addRow(new Object[]{c.getName(), c.getPrenume(), c.getPhoneNumber().getNumar(), c.getBirthDate()});
                }
            }catch (NullPointerException ex){
                JOptionPane.showMessageDialog(null,
                        "Nu exista contacte","Eroare", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource() == butonFiltrare){
            LocalDate data1 = LocalDate.now();
            int month = data1.getMonthValue();
            int day = data1.getDayOfMonth();

            String criteri = comboFiltrare1.getSelectedItem().toString();
            model.getDataVector().removeAllElements();
            switch(criteri){
                case "Numar Mobil":
                    agenda.getContactList().stream()
                            .filter(c -> c.getPhoneNumber() instanceof NrMobil)
                            .forEach(c -> model.addRow(new Object[]{c.getName(),
                                    c.getPrenume(), c.getPhoneNumber().getNumar(), c.getBirthDate()}));
                    break;
                case "Numar Fix":
                    agenda.getContactList().stream()
                            .filter(c -> c.getPhoneNumber() instanceof NrFix)
                            .forEach(c -> model.addRow(new Object[]{c.getName(),
                                    c.getPrenume(), c.getPhoneNumber().getNumar(), c.getBirthDate()}));
                    break;
                case "Luna curenta":
                    agenda.getContactList().stream()
                            .filter(c -> c.getMonth() == month)
                            .forEach(c -> model.addRow(new Object[]{c.getName(),
                                    c.getPrenume(), c.getPhoneNumber().getNumar(), c.getBirthDate()}));
                    break;
                case "Ziua curenta":
                    agenda.getContactList().stream()
                            .filter(c -> c.getMonth() == month &&
                                    c.getDay() == day)
                            .forEach(c -> model.addRow(new Object[]{c.getName(),
                                    c.getPrenume(), c.getPhoneNumber().getNumar(), c.getBirthDate()}));
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Agenda a = new Agenda();
        try {
            new FereastraStart(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
