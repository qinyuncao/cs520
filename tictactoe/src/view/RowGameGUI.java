package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

import model.RowGameModel;
import controller.RowGameController;

public class RowGameGUI implements View {
    public JFrame gui = new JFrame("Tic Tac Toe");
    public JButton reset = new JButton("Reset");
    public ComponentA componentA;
    public ComponentC componentC;

    /**
     * Creates a new game initializing the GUI.
     */
    public RowGameGUI(RowGameController controller) {
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(new Dimension(500, 350));
        gui.setResizable(true);

        componentA = new ComponentA(controller);
        JPanel options = new JPanel(new FlowLayout());
        options.add(reset);
        componentC = new ComponentC(controller);

        gui.add(componentA.gamePanel, BorderLayout.NORTH);
        gui.add(options, BorderLayout.CENTER);
        gui.add(componentC.messages, BorderLayout.SOUTH);


        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.resetGame();
            }
        });
    }


    @Override
    public void update(RowGameModel model) {
        componentA.update(model);
        componentC.update(model);
    }
}
