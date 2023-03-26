import javax.swing.*;
import java.awt.*;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Dialoog extends JDialog implements ActionListener {

    Klas klas;
    JTextField jtnaam;
    JTextField jtblij;

    JButton ok;
    JButton cancel;
    private ArrayList<Persoon> personenLijst;

    Docent docent;

    public Dialoog(Frame owner, ArrayList<Persoon> personenLijst) {
        super(owner);

        this.personenLijst = personenLijst;
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(500, 500));


        this.jtnaam = new JTextField();
        jtnaam.setPreferredSize(new Dimension(200,25));


        this.jtblij = new JTextField();
        jtblij.setPreferredSize(new Dimension(200,25));

        this.ok = new JButton("OK");
        this.ok.addActionListener(this);

        this.cancel = new JButton("Cancel");
        this.cancel.addActionListener(this);

        add(new JLabel("naam: "));
        this.add(jtnaam);

        add(new JLabel("blijheidwijziging"));
        this.add(jtblij);

        this.add(ok);
        this.add(cancel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String naam = jtnaam.getText();
        String blij = jtblij.getText();



        if(e.getSource() == ok){

            for(int i = 0; i<personenLijst.size(); i++){

                if(personenLijst.get(i).getNaam().equals(jtnaam.getText())){
                    personenLijst.get(i).maakBlij(Integer.parseInt(blij));

                }

                System.out.println(personenLijst.get(i));
            }

        }



    }




}
