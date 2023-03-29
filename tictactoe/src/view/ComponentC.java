package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

import model.RowGameModel;
import controller.RowGameController;
import static model.RowGameModel.player1;

public class ComponentC implements View {
    public JTextArea playerturn = new JTextArea();
    public JPanel messages = new JPanel(new FlowLayout());

    public ComponentC(RowGameController controller){    
        messages.setBackground(Color.white);
        messages.add(playerturn);
        playerturn.setText("Player 1 to play 'X'");
        playerturn.setEditable(false);
    }

    @Override
    public void update(RowGameModel model) {
        if(model.getFinalResult() != null){
            playerturn.setText(model.getFinalResult());
        }
        else if(model.getPlayer().equals(player1)){
            playerturn.setText("Player 1 to play 'X'");
        }
        else{
            playerturn.setText("Player 2 to play 'O'");
        }

    }
}
