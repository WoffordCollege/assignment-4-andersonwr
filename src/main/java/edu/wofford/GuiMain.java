package edu.wofford;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GuiMain extends JFrame implements ActionListener {

    public void actionPerformed(ActionEvent event) {

    }
    
    public GuiMain() {
        setTitle("Tic Tac Toe");

    }

    
	public static void main(String[] args) {
	    GuiMain window = new GuiMain();
        window.setVisible(true);
	}
}