import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    int width;
    int height;
    JFrame frame;

    public MenuPanel(int width, int height, JFrame frame) {
        this.width = width;
        this.height = height;
        this.frame = frame;

        setPreferredSize(new Dimension(width, height));
        setBackground(Color.DARK_GRAY);
        setLayout(null);

        JButton sp = new JButton("SinglePlayer");
        sp.setLayout(null);
        sp.setBounds((width / 2) - 100, (height / 4) + 100 - 30, 200, 60);
        sp.setBackground(Color.GREEN);
        sp.setBorder(BorderFactory.createBevelBorder(0));
        sp.addActionListener(new SinglePlayerListener(frame));
        add(sp);

        JButton mp = new JButton("MultiPlayer");
        mp.setLayout(null);
        mp.setBounds((width / 2) - 100, (height / 4) + 175 - 30, 200, 60);
        mp.setBackground(Color.RED);
        mp.setBorder(BorderFactory.createBevelBorder(0));
        mp.addActionListener(new MultiplayerListener(frame));
        add(mp);


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("SNAKE", (width - metrics.stringWidth("SNAKE"))/2, height / 4);
    }
}

