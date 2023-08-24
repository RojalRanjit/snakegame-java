import javax.swing.*;

public class SnakeFrame extends JFrame{

    public SnakeFrame() {

        SnakePanel panel=new SnakePanel();
        add(panel);
        pack();
        setTitle("Ai Snake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);


        setFocusable(true);

        addKeyListener(panel);




    }
}