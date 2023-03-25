import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {


    public Panel() {

        this.setPreferredSize(new Dimension(1000, 1000));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(175, 500, 60, 30);
        g.drawLine(175, 535, 235, 535);


    }









}