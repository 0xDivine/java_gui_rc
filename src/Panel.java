import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel extends JPanel {

    Klas klas;

    Frame frame;
    ArrayList<Persoon> personenlijst;


    public Panel(Frame frame, ArrayList<Persoon> personenlijst) {
        this.frame = frame;
        this.personenlijst = personenlijst;
        this.setPreferredSize(new Dimension(1000, 1000));
        this.setLayout(new FlowLayout());
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = 10; // initial x position
        int y = 10; // initial y position
        int gap = 5; // gap between shapes
        System.out.println("paint");

        for (Persoon p : personenlijst) {
            if (p instanceof Docent) {
                g.setColor(p.getKleur());
                g.fillRect(x, y, 20, 20); // draw a square for Docent

                g.setFont(new Font("Arial", Font.PLAIN, 16));// Set the font to Arial, plain style, size 16

                g.drawString(p.getNaam(), x + 5, y+30);
                g.drawString(String.valueOf(p.getBlij()), x+5, y+60);
                g.drawString(p.getSmiley(),x+5, y+80);

                x += 25; // increase x position for next shape
            } else if (p instanceof Student) {
                g.setColor(p.getKleur());

                g.fillOval(x, y, 20, 20); // draw a circle for Student

                g.setFont(new Font("Arial", Font.PLAIN, 16));// Set the font to Arial, plain style, size 16

                g.drawString(p.getNaam(), x + 5, y+30);
                g.drawString(String.valueOf(p.getBlij()), x+5, y+60);
                g.drawString(p.getSmiley(),x+5, y+80);

                x += 25; // increase x position for next shape
            }
        }


    }
}


