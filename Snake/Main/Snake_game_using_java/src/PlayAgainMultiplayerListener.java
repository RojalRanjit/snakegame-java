import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayAgainMultiplayerListener implements ActionListener {

    JFrame frame;

    public PlayAgainMultiplayerListener(JFrame frame) {

        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ((MyFrame) frame).playAgainMultiplayer();
    }

}
