import javax.swing.*;
import java.awt.*;

public class GameOverPanel extends JPanel {
    int applesEaten;
    int width;
    int height;
    Graphics g;
    JFrame frame;

    public GameOverPanel(int applesEaten, int width, int height, Graphics g, JFrame frame) {


        this.applesEaten = applesEaten;
        this.width = width;
        this.height = height;
        this.g = g;
        this.frame = frame;

        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
        setLayout(null);

        JButton againB = new JButton("Play Again?");
        againB.setLayout(null);
        againB.setBounds((width / 2) - 100, (height - (height / 4)) - 30, 200, 60);
        againB.setBackground(Color.GREEN);
        againB.setBorder(BorderFactory.createBevelBorder(0));
        againB.addActionListener(new PlayAgainListener(frame));
        add(againB);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: " + applesEaten, (width - metrics1.stringWidth("Score: " + applesEaten))/2, g.getFont().getSize());

        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (width - metrics2.stringWidth("Game Over"))/2, height / 2);
    }
}