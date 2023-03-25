import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import static javax.swing.JColorChooser.showDialog;


public class Frame extends JFrame implements ActionListener {


    Bar bar;

    JButton bestelwarmedrank;
    JButton bestelwater;
    JButton bekijk;
    JCheckBox thee;
    JCheckBox melk;
    JCheckBox suiker;
    private ArrayList<Drank> dranken;

    Panel panel;

    public Frame(Bar bar) {

        this.setTitle("Irshad NAzar-Ali S1186193");
        this.bar = bar;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dranken = new ArrayList<Drank>();
        this.setPreferredSize(new Dimension(700,100));



        this.setLayout(new FlowLayout());

        this.bestelwarmedrank = new JButton("warme drank bestellen");
        this.bestelwarmedrank.addActionListener(this);


        this.thee = new JCheckBox("thee?");
        this.thee.addActionListener(this);

        this.melk = new JCheckBox("melk?");
        this.melk.addActionListener(this);

        this.suiker = new JCheckBox("Suiker?");
        this.suiker.addActionListener(this);

        this.bestelwater = new JButton("Water bestellen");
        bestelwater.setBackground(Color.green);
        this.bestelwater.addActionListener(this);

        this.bekijk = new JButton("bekijk bestellingen");
        bekijk.setBackground(Color.pink);
        this.bekijk.addActionListener(this);

        this.add(bestelwarmedrank);
        this.add(thee);
        this.add(melk);
        this.add(suiker);
        this.add(bestelwater);
        this.add(bekijk);

        this.panel = new Panel();
        this.add(panel);


        pack();
        setVisible(true);


    }


    private void showDialog() {

        Dialoog d1 = new Dialoog(this, false, dranken);
        d1.setTitle("My Dialog");
        d1.setPreferredSize(new Dimension(500,500));
        d1.setResizable(false);
        d1.pack();
        d1.setVisible(true);
    }

    private void showDialog1() {

        Dialoog d1 = new Dialoog(this);
        d1.setTitle("Your order list");
        d1.add(new JLabel("Your order list:"));

        Drank[] drankenArray = dranken.toArray(new Drank[dranken.size()]);

        JList<Drank> list = new JList<>(drankenArray);
        JScrollPane scrollPane = new JScrollPane(list);

        d1.setPreferredSize(new Dimension(500,500));

        d1.add(list);
        d1.add(scrollPane);



        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> d1.dispose());
        d1.add(okButton);

        d1.setResizable(false);
        d1.pack();
        d1.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        boolean isThee = false;
        boolean melks = false;
        boolean suikers = false;
        WarmeDrank a;

        if (e.getSource() == bestelwarmedrank) {

            if (thee.isSelected()) {
                isThee = true;
            } else {
                isThee = false;
            }


            if (melk.isSelected() && suiker.isSelected()) {
                melks = true;
                suikers = true;
            }

            if (melk.isSelected()) {
                melks = true;
            }

            if (suiker.isSelected()) {
                suikers = true;
            }

            a = new WarmeDrank(isThee,melks,suikers);
            System.out.println(a.toString());
            dranken.add(a);

        }




        if(e.getSource() == bestelwater){

            //JOptionPane.showMessageDialog(this, String.valueOf(dranken.get(0)), "Water besteld", JOptionPane.PLAIN_MESSAGE);
            showDialog();
        }



        if(e.getSource() == bekijk){

            showDialog1();

        }

    }




    public static void main (String[]args){
        Bar b1 = new Bar();
        Frame frame = new Frame(b1);

        Panel p1 = new Panel();
        frame.add(p1);

    }


}