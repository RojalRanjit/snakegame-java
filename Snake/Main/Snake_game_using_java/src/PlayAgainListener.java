import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayAgainListener implements ActionListener {
    JFrame frame;

    public PlayAgainListener(JFrame frame) {

        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        ((MyFrame) frame).playAgain();
    }

}