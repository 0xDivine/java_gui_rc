import javax.swing.*;
import java.awt.*;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Dialoog extends Dialog  implements ActionListener{

    Water water;
    JTextField aantal;
    JTextField hoeveelheid;
    JButton ok;

    private ArrayList<Drank> dranken;


    public Dialoog(Frame owner, boolean modal, ArrayList<Drank> dranken) {
        super(owner, modal);

        //this.setTitle("water");
        this.setLayout(new FlowLayout());
        this.dranken = dranken;
        this.setPreferredSize(new Dimension(500,500));


        add(new JLabel("type:"));
        aantal = new JTextField();
        aantal.setPreferredSize(new Dimension(200,25));

        add(new JLabel("Hoeveel:"));
        hoeveelheid = new JTextField();
        hoeveelheid.setPreferredSize(new Dimension(200,25));


        this.ok = new JButton("ok");
        this.ok.addActionListener(this);


        this.add(aantal);
        this.add(ok);
        this.add(hoeveelheid);

    }

    public Dialoog(Frame owner) {
        super(owner);
        this.setLayout(new FlowLayout());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String type = aantal.getText();
        String hoeveel = hoeveelheid.getText();



        if(e.getSource() == ok){

            Water[] a = new Water[Integer.parseInt(hoeveel)];

            for (int i = 0; i < a.length; i++) {
                a[i] = new Water(type);
                dranken.add(a[i]);
                System.out.println(a[i]);
            }

            dispose();

            //Water a = new Water(value);
            //dranken.add(a);
            // System.out.println(a);


        }


    }

    public static void main(String[] args) {




    }





}