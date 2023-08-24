import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MultiplayerListener implements ActionListener {

    JFrame frame;

    public MultiplayerListener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ((MyFrame) frame).multiplayer();
    }

}

