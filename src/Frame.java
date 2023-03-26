import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Frame extends JFrame implements ActionListener {


    Klas klas;
    JButton tijdverstrijkt;
    JButton helpiemand;
    JButton voegtoe;
    JTextField jtnaam;
    JTextField jtblij;
    JTextField jtS;
    String afhandeling = "";
    Panel panel;
    private ArrayList<Persoon> personenLijst;

    public Frame(Klas klas)  {

        this.klas = klas;
        this.personenLijst = klas.getPersonenLijst();
        this.panel = new Panel(this, personenLijst);

        this.setTitle("Irshad N (S1186193) " + this.klas + " mededeling - " + afhandeling);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(1000, 1000));

        this.setLayout(new FlowLayout());

        this.tijdverstrijkt = new JButton("tijdverstrijkt");
        this.tijdverstrijkt.addActionListener(this);

        this.helpiemand = new JButton("help iemand");
        this.helpiemand.addActionListener(this);

       // add(new JLabel("naam:"));
        this.jtnaam = new JTextField();
        jtnaam.setPreferredSize(new Dimension(200,25));


       // add(new JLabel("blij:"));
        this.jtblij = new JTextField();
        jtblij.setPreferredSize(new Dimension(200,25));


        //add(new JLabel("s:"));
        this.jtS = new JTextField();
        jtS.setPreferredSize(new Dimension(200,25));


        this.voegtoe = new JButton("voeg toe");
        this.voegtoe.addActionListener(this);

        this.add(tijdverstrijkt);
        this.add(helpiemand);
        add(new JLabel("naam:"));
        this.add(jtnaam);
        add(new JLabel("blij:"));
        this.add(jtblij);
        add(new JLabel("s:"));
        this.add(jtS);
        this.add(voegtoe);
        this.add(panel);


        pack();
        repaint();
        setVisible(true);



    }

    public void showDialog(){

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String naam = jtnaam.getText();
        String blij = jtblij.getText();
        String student = jtS.getText();

        if(e.getSource() == voegtoe){

            try{
                Student a = new Student(naam, Integer.parseInt(blij), student);
                personenLijst.add(a);
                repaint();
                System.out.println(personenLijst);

                this.afhandeling = "OK";
                this.setTitle("Irshad N (S1186193) " + this.klas + " mededeling - " + afhandeling);
            }catch (NumberFormatException nfe){
                this.afhandeling = "Exception!";
                this.setTitle("Irshad N (S1186193) " + this.klas + " mededeling - " + afhandeling);

            }


        }

        if(e.getSource() == tijdverstrijkt){

            klas.maakBlij(-5);
            System.out.println(klas);
        }

        if(e.getSource() == helpiemand){

            Dialoog d1 = new Dialoog(this, personenLijst);
            d1.setVisible(true);
            setPreferredSize(new Dimension(500,500));

        }

    }


    public static void main(String[] args) {

        Klas k1 = new Klas("ICTM2w");
        k1.voegToe("eva", "s3845784", 55);
        k1.voegToe(new Docent("Jolian"));


        Frame f1 = new Frame(k1);



    }


}
