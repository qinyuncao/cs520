package view;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

import model.RowGameModel;
import controller.RowGameController;


public class ComponentA implements View{
    public JButton[][] blocks = new JButton[3][3];
    JPanel gamePanel = new JPanel(new FlowLayout());
    JPanel game = new JPanel(new GridLayout(3,3));

    public ComponentA(RowGameController controller){
        gamePanel.add(game, BorderLayout.CENTER);

        // Initialize a JButton for each cell of the 3x3 game board.
        for(int row = 0; row<3; row++) {
            for(int column = 0; column<3 ;column++) {
                blocks[row][column] = new JButton();
                blocks[row][column].setPreferredSize(new Dimension(75,75));
                game.add(blocks[row][column]);
                blocks[row][column].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
			            controller.move((JButton)e.getSource());
                    }
                });
            }
        }

    }

    @Override
    public void update(RowGameModel model) {
        for (int row = 0; row<3; row++){
            for (int column = 0; column <3; column++){
                blocks[row][column].setText(model.blocksData[row][column].getContents());
	            blocks[row][column].setEnabled(model.blocksData[row][column].getIsLegalMove());
            }
        }
    }



}
