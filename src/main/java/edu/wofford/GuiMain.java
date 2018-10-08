package edu.wofford;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GuiMain extends JFrame implements ActionListener {

    private JButton[][] buttons;
    private JLabel result;
    private TicTacToeModel game;

    public void actionPerformed(ActionEvent event) {
        String name = ((JButton) event.getSource()).getName();
        int row = Character.getNumericValue(name.charAt(8));
        int col = Character.getNumericValue(name.charAt(9));

        game.setMarkAt(row, col);

        if(game.getMarkAt(row,col) == TicTacToeModel.Mark.XMARK){
            ((JButton) event.getSource()).setText("X");
        } else if (game.getMarkAt(row, col) == TicTacToeModel.Mark.OMARK){
            ((JButton) event.getSource()).setText("O");
        }

        if(game.getResult() == TicTacToeModel.Result.XWIN){
            result.setText("X wins");
        } else if (game.getResult() == TicTacToeModel.Result.OWIN){
            result.setText("O wins");
        } else if (game.getResult() == TicTacToeModel.Result.TIE){
            result.setText("Tie");
        }

    }
    
    public GuiMain() {
        game = new TicTacToeModel();

        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 600);

        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(3,3));

        result = new JLabel(" ");
        result.setName("result");

        buttons = new JButton[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                buttons[j][i] = new JButton();
                buttons[j][i].setName("location" + Integer.toString(i) + Integer.toString(j));
                buttons[j][i].addActionListener(this);
                panelButtons.add(buttons[j][i]);
            }
        }
        panelMain.add(result);
        panelMain.add(panelButtons);
        add(panelMain);
    }

    
	public static void main(String[] args) {
	    GuiMain window = new GuiMain();
        window.setVisible(true);
	}
}